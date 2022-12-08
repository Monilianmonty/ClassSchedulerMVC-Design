package final_project_MVC;

import java.io.*;

import javax.swing.*;

public class controller {
	private Login_View Lview;
	private UserReg_View Rview;
	public controller(Login_View v1, UserReg_View v2) {
		Lview = v1;
		Rview = v2;
	}
	
	public void initView() {
		
	}
	
	public void initController() {
		Lview.getLoginButton().addActionListener(e -> login());
		Lview.getRegisterButton().addActionListener(e -> register());
		Rview.getReg_submit().addActionListener(e -> submit_reg());
		Rview.getReg_reset().addActionListener(e -> reset_reg());
		Rview.getBack_to_login().addActionListener(e -> back());
	}
	
	private void login() {
		String username = Lview.getUsernameTextField().getText();
		JPasswordField tempField = Lview.getPassTextField();
		String password = String.valueOf(tempField.getPassword());
		
		try(FileInputStream loginf = new FileInputStream("StudentData.txt");
			ObjectInputStream obIn = new ObjectInputStream(loginf)){
			while(loginf.available() > 0) {
				Student student1 = (Student) obIn.readObject();
				String email = student1.getEmail();
				String pass = student1.getPassword();
				
				if(username.equals(email) && password.equals(pass)) {
					JOptionPane.showMessageDialog(null, "Log In Successful");
					break;
				}else{
				JOptionPane.showMessageDialog(null, "Username or Password mismatch");
				}
			}
			obIn.close();
			loginf.close();
		}catch(FileNotFoundException ex) {
			throw new RuntimeException(ex);
		}catch(IOException ex) {
			throw new RuntimeException(ex);
		}catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}
	
	public void register() {
		Rview.reg_Frame.setVisible(true);
		Lview.getLoginFrame().dispose();
	}
	
	public void submit_reg() {
		boolean validEntry = false;
		try(FileInputStream studentIN = new FileInputStream("StudentData.txt");
				ObjectInputStream obIN = new ObjectInputStream(studentIN)){
			if(!Rview.getReg_userTextField().getText().contains("@") || 
			   !Rview.getReg_userTextField().getText().contains(".")) {
				JOptionPane.showMessageDialog(null, "Please enter valid email address");
			}else {
				while(studentIN.available() > 0) {
					Student val_student = (Student) obIN.readObject();
					
					if(Rview.getReg_nameTextField().getText().equals(null)) {
						JOptionPane.showMessageDialog(null, "PLease enter your Name");
					}else if(Rview.getReg_idTextField().getText().equals(null)) {
						JOptionPane.showMessageDialog(null, "PLease enter your ID");
					}else if(Rview.getReg_idTextField().getText().equals(val_student.id)) {
						JOptionPane.showMessageDialog(null, "ID already taken");
					}else if(Rview.getReg_userTextField().getText().equals(null)) {
						JOptionPane.showMessageDialog(null, "PLease enter your Email");
					}else if(Rview.getReg_userTextField().getText().equals(val_student.email)) {
						JOptionPane.showMessageDialog(null, "Email already taken");
					}else if(Rview.getReg_passTextField().getText().equals(null)) {
						JOptionPane.showMessageDialog(null, "PLease enter your Password");
					}else if(Rview.getReg_passTextField().getText().equals(val_student.password)) {
						JOptionPane.showMessageDialog(null, "Password already taken");
					}else {
						JOptionPane.showMessageDialog(null, "Registration Complete!");
						validEntry = true;
						Lview = new Login_View();
						Rview.reg_Frame.dispose();
						break;
					}
				}
			}
			obIN.close();
			studentIN.close();
		}catch(FileNotFoundException ex) {
			throw new RuntimeException(ex);
		}catch(IOException ex) {
			throw new RuntimeException(ex);
		}catch(ClassNotFoundException ex) {
			throw new RuntimeException(ex);
		}	
		
		try(FileOutputStream studentOUT = new FileOutputStream("StudentData.txt");
			ObjectOutputStream obOUT = new ObjectOutputStream(studentOUT)){
			
			Student newStudent = new Student();
			newStudent.setName(Rview.getReg_nameTextField().getText());
			newStudent.setId(Rview.getReg_idTextField().getText());
			newStudent.setEmail(Rview.getReg_userTextField().getText());
			newStudent.setPassword(Rview.getReg_passTextField().getText());
			
			obOUT.writeObject(newStudent);
			
		}catch(FileNotFoundException ex) {
			throw new RuntimeException(ex);
		}catch(IOException ex) {
			throw new RuntimeException(ex);
		}
	}
		
	
	
	public void reset_reg() {
		Rview.getReg_nameTextField().setText(null);
		Rview.getReg_idTextField().setText(null);
		Rview.getReg_userTextField().setText(null);
		Rview.getReg_passTextField().setText(null);
	}
	
	public void back() {
		Lview = new Login_View();
		Rview.reg_Frame.dispose();
	}
}
