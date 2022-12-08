package final_project_MVC;


import java.io.*;

import javax.swing.*;

public class controller {
    private Login_View Lview;
    private UserReg_View Rview;
    private ClassPage_View Cview;
    public controller(Login_View v1, UserReg_View v2, ClassPage_View v3) {
        Lview = v1;
        Rview = v2;
        Cview = v3;
    }

    public void initView() {

    }

    public void initController() {
        Lview.getLoginButton().addActionListener(e -> login());
        Lview.getRegisterButton().addActionListener(e -> register());
        Rview.getReg_submit().addActionListener(e -> submit_reg());
        Rview.getReg_reset().addActionListener(e -> reset_reg());
        Rview.getBack_to_login().addActionListener(e -> back());
        Cview.getClass_addClassButton().addActionListener(e -> addClass());
        Cview.getClass_removeClassButton().addActionListener(e -> removeClass());
        Cview.getLogOut().addActionListener(e -> logOut());

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
                    Cview.classFrame.setVisible(true);
                    Lview.getLoginFrame().setVisible(false);
                    try(FileInputStream classIN = new FileInputStream("ClassData.txt");
                        ObjectInputStream obIN = new ObjectInputStream(classIN)){

                        while(classIN.available() > 0) {
                            Class temp = (Class) obIN.readObject();
                            Cview.getClass_addClassOptions().addItem(temp);
                        }
                    }
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

                    if(Rview.getReg_nameTextField().getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "PLease enter your Name");
                    }else if(Rview.getReg_idTextField().getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "PLease enter your ID");
                    }else if(Rview.getReg_idTextField().getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "ID already taken");
                    }else if(Rview.getReg_userTextField().getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "PLease enter your Email");
                    }else if(Rview.getReg_userTextField().getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Email already taken");
                    }else if(Rview.getReg_passTextField().getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "PLease enter your Password");
                    }else if(Rview.getReg_passTextField().getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Password already taken");
                    }else {
                        JOptionPane.showMessageDialog(null, "Registration Complete!");
                        validEntry = true;
                        Lview.getLoginFrame().setVisible(true);
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
        Lview.getLoginFrame().setVisible(true);
        Rview.reg_Frame.dispose();
    }

    public void dispJOP(String message) {
        JFrame f = new JFrame("Warning");
        JOptionPane.showMessageDialog(f, message);
    }
    public void addClass() {
        if (Cview.getClass_addClassOptions().getSelectedIndex() == -1) {
            this.dispJOP("You can't add any more classes!");
        }
        else {
            Class pickedClass = (Class) Cview.getClass_addClassOptions().getSelectedItem();
            Object[][] data = Cview.getClass_selectedClassesTableData();
            JTable table = Cview.getClass_selectedClassesTable();
            JComboBox add = Cview.getClass_addClassOptions();
            JComboBox remove = Cview.getClass_removeClassOptions();
            for (int i = 1; i < 27; i++) {
                if (data[i][0].equals(pickedClass.intToTimeSlot(pickedClass.getStart(), pickedClass.getEnd())) && data[i][1] == null) {
                    for (int j = 0; j < 5; j++) {
                        if (pickedClass.getDays()[j]) {
                            table.setValueAt(pickedClass.getName(),i,j+1);
                            table.setValueAt(pickedClass.getTitle(),i+1,j+1);
                        }
                    }
                    remove.addItem(pickedClass);
                    add.removeItemAt(add.getSelectedIndex());
                }
                else if (data[i][1] != null && data[i][0].equals(pickedClass.intToTimeSlot(pickedClass.getStart(), pickedClass.getEnd()))) {
                    this.dispJOP("That time slot is reserved for another class. Remove the class in this slot to add your current selected one.");
                }
            }
        }
    }

    public void removeClass() {
        Class pickedClass = (Class) Cview.getClass_removeClassOptions().getSelectedItem();
        Object[][] data = Cview.getClass_selectedClassesTableData();
        JTable table = Cview.getClass_selectedClassesTable();
        JComboBox add = Cview.getClass_addClassOptions();
        JComboBox remove = Cview.getClass_removeClassOptions();
        for (int i = 1; i < 27; i++) {
            if (data[i][0].equals(pickedClass.intToTimeSlot(pickedClass.getStart(),pickedClass.getEnd())) && data[i][1] != null) {
                for (int j = 0; j < 5; j++) {
                    if (pickedClass.getDays()[j]) {
                        table.setValueAt(null,i,j+1);
                        table.setValueAt(null,i+1,j+1);
                    }
                }
            }
        }
        add.addItem(remove.getSelectedItem());
        remove.removeItemAt(remove.getSelectedIndex());
    }

    public void logOut() {
        Cview.classFrame.dispose();
        Lview.getLoginFrame().setVisible(true);
    }
}
