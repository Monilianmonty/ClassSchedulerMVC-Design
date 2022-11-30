import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;


public class UserRegistration extends JFrame implements ActionListener,Serializable{

    //user registration gui layout
    private static JPanel p1;
    private static JLabel id,name,email,upassword;
    private static JTextField tid,tname,temail;

    private static JPasswordField tpassword;
    private static JButton submit, reset;
    private static JFrame regFrame;



    public static void main(String[] args) {

        //drawEve();
    }

    //public static void main (String[] args) {
    public static void drawEve() {
        p1 = new JPanel();
        p1.setLayout(null);
        p1.setVisible(true);


        //jframe class
        regFrame = new JFrame();
        regFrame.setTitle("Student Registration");
        regFrame.setVisible(true);
        regFrame.setLocation(new Point(300,300));
        regFrame.add(p1);
        regFrame.setSize(new Dimension(500, 500));
        regFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //name label
        name = new JLabel("Name");
        name.setFont(new Font("Times New Roman", Font.BOLD, 20));
        name.setSize(250,40);
        name.setLocation(100,100);
        p1.add(name);

        //name text field
        tname = new JTextField();
        tname.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        tname.setSize(190, 25);
        tname.setLocation(155,110);
        p1.add(tname);

        //id label
        id = new JLabel("ID");
        id.setFont(new Font("Times New Roman", Font.BOLD, 20));
        id.setSize(250,40);
        id.setLocation(120,130);
        p1.add(id);

        //id text field
        tid = new JTextField();
        tid.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        tid.setSize(190, 25);
        tid.setLocation(155,140);
        p1.add(tid);


        email = new JLabel("Email");
        email.setFont(new Font("Times New Roman", Font.BOLD, 20));
        email.setSize(250,40);
        email.setLocation(100,160);
        p1.add(email);

        temail = new JTextField();
        temail.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        temail.setSize(190, 25);
        temail.setLocation(155,170);
        p1.add(temail);

        upassword = new JLabel("Password");
        upassword.setFont(new Font("Times New Roman", Font.BOLD, 20));
        upassword.setSize(250,40);
        upassword.setLocation(70,200);
        p1.add(upassword);

        tpassword = new JPasswordField();
        tpassword.setLocation(155,208);
        tpassword.setSize(190,25);
        p1.add(tpassword);

        submit = new JButton("Submit");
        submit.setBounds(160, 250, 70, 25);
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLACK);
        submit.setFont(new Font("Times New Roman", Font.BOLD,10));
        submit.addActionListener(new UserRegistration());
        p1.add(submit);

        reset = new JButton("Reset");
        reset.setBounds(240, 250, 70, 25);
        reset.setForeground(Color.WHITE);
        reset.setBackground(Color.BLACK);
        reset.setFont(new Font("Times New Roman", Font.BOLD,10));
        reset.addActionListener(new UserRegistration());
        p1.add(reset);

    }






    @Override
    public void actionPerformed (ActionEvent e){

        //used to get strings from text box
        String newName = tname.getText();
        String newID = tid.getText();
        String newEmail = temail.getText();
        String newPassword = String.valueOf(tpassword.getPassword());
        boolean takenStudent = false;

        //reset the text boxes
        if(e.getSource() == reset){
            tname.setText(null);
            tid.setText(null);
            temail.setText(null);
            tpassword.setText(null);

        }

        //first see if the current stored users have any attributes already taken
        try(FileInputStream userf = new FileInputStream("StudentData.txt");
            ObjectInputStream of = new ObjectInputStream(userf)) {
            Scanner readf = new Scanner(userf);
            readf.useDelimiter("\\n|,");

            //read the objects available in the database
            while(userf.available() > 0) {
                Student sf = (Student) of.readObject();
                String Uem = sf.getEmail();
                String Upass = sf.getPassword();
                String UID = sf.getId();
                //if the user has entered an email,id, or password that is already taken then error message occurs
                if (e.getSource() == submit) {
                    if(newEmail.equals("")){
                        JOptionPane.showMessageDialog(null, "Please enter email");
                        takenStudent = false;
                    }
                    else if(newName.equals("")){
                        JOptionPane.showMessageDialog(null, "Please enter name");
                        takenStudent = false;
                    }
                    else if(newID.equals("")){
                        JOptionPane.showMessageDialog(null, "Please enter ID");
                        takenStudent = false;
                    }
                    else if(newPassword.equals("")){
                        JOptionPane.showMessageDialog(null, "Please enter password");
                        takenStudent = false;
                    }
                    else if (newEmail.equals(Uem)) {
                        JOptionPane.showMessageDialog(null, "Email already taken");
                        takenStudent = false;
                    } else if (newID.equals(UID)) {
                        JOptionPane.showMessageDialog(null, "ID already taken");
                        takenStudent = false;
                    } else if (newPassword.equals(Upass)) {
                        JOptionPane.showMessageDialog(null, "Password already taken");
                        takenStudent = false;

                    } else {
                        JOptionPane.showMessageDialog(null, "Registration Complete!");
                        takenStudent = true;

                    }
                }
            }

        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }

        //if the students credentials are not taken then write the information to the text file
        if(takenStudent) {
            try {
                FileOutputStream userOut = new FileOutputStream("StudentData.txt");
                ObjectOutputStream userOb = new ObjectOutputStream(userOut);
                Student s1 = new Student();

                s1.setName(newName);
                s1.setId(newID);
                s1.setEmail(newEmail);
                s1.setPassword(newPassword);


                if (e.getSource() == submit) {


                    userOb.writeObject(s1);

                }
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        }
    }



}
