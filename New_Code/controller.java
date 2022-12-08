package final_project_MVC;

import java.io.*;

import javax.swing.*;

public class controller {
	private DataBase model;
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
	}
	
	private void login() {
		String username = Lview.getUsernameTextField().getText();
		String password = Lview.getPassTextField().getText();
		
		try(FileInputStream loginf = new FileInputStream("StudentData.txt");
			ObjectInputStream obIn = new ObjectInputStream(loginf)){
			while(loginf.available() > 0) {
				Student student1 = (Student) obIn.readObject();
				String email = student1.getEmail();
				String pass = student1.getPassword();
				
				if(username.equals(email) && password.equals(pass)) {
					JOptionPane.showMessageDialog(null, "Log In Successful");
				}else{
				JOptionPane.showMessageDialog(null, "Username or Password mismatch");
				}
			}
			obIn.close();
			
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
	}
	
	public void submit_reg() {
		boolean validEntry;
		try(FileInputStream studentIN = new FileInputStream("StudentData.txt");
				ObjectInputStream obIN = new ObjectInputStream(studentIN)){
		if(!Rview.getReg_userTextField().getText().contains("@") || 
		   !Rview.getReg_userTextField().getText().contains(".")) {
			JOptionPane.showMessageDialog(null, "Please enter valid email address");
		}else {
				
			}
			}catch(FileNotFoundException ex) {
				throw new RuntimeException(ex);
			}catch(IOException ex) {
				throw new RuntimeException(ex);
			}//catch(ClassNotFoundException ex) {}
			
		}
		
	}
	
	public void reset_reg() {
		
	}
}
