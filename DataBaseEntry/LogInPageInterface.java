

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

import static java.lang.System.in;


public class LogInPageInterface implements ActionListener,Serializable{
    private static JLabel password1, label;
    private static JTextField username;
    private static JButton button;
    private static JPasswordField Password;




    public static void main(String[] args) {

            //jpanel class
            JPanel panel = new JPanel();
            panel.setLayout(null);
            panel.setVisible(true);


            //jframe class
            JFrame frame = new JFrame();
            frame.setTitle("LOGIN PAGE");
            frame.setVisible(true);
            frame.setLocation(new Point(300,300));
            frame.add(panel);
            frame.setSize(new Dimension(400, 200));
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            //username label
            label = new JLabel("Username");
            label.setBounds(100,8,70,20);
            panel.add(label);

            //password label
            username = new JTextField();
            username.setBounds(100,27,193,28);
            panel.add(username);

            //password textfield
        password1 = new JLabel("Password");
        password1.setBounds(100,55,70,20);
        panel.add(password1);

        Password = new JPasswordField();
        Password.setBounds(100,75,193,28);
        panel.add(Password);




        //adding button
        button = new JButton("LogIn");
        button.setBounds(100,110,90,25);
        button.setForeground(Color.WHITE);
        button.setBackground(Color.BLACK);
        button.setFont(new Font("Arial", Font.BOLD, 12));
        button.addActionListener((ActionListener) new LogInPageInterface());
        panel.add(button);



        }

    @Override
    public void actionPerformed(ActionEvent e) {

        //UserName and password typed into the login page
        String Username = username.getText();
        String password = String.valueOf(Password.getPassword());



        //must put your own
        try(FileInputStream loginf = new FileInputStream("C:\\Users\\moomo\\IdeaProjects\\Sweng311FinalProject\\src\\StudentData.txt");
            ObjectInputStream o = new ObjectInputStream(loginf);
        ) {
            Scanner read = new Scanner(loginf);
            read.useDelimiter("\\n|,");
            boolean login = false;
            while (loginf.available() > 0) {
                Student s1 = (Student) o.readObject();
                String em = s1.getEmail();
                String pass = s1.getPassword();

                //if username and password in text box matches username and password in textfile show class page
                if (Username.equals(em) && password.equals(pass)) {
                    login = true;
                    break;

                }
            }
            if(login){
                    JOptionPane.showMessageDialog(null, "LogIn Succesful");
                    ClassPageInterface c1 = new ClassPageInterface();
                    c1.setVisible(true);
                    c1.pack();
                    c1.setLocationRelativeTo(null);
                    c1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                }
                else {

                    JOptionPane.showMessageDialog(null, "Username or Password mismatch");
                }

                o.close();
                loginf.close();

        } catch (FileNotFoundException exception) {
            throw new RuntimeException(exception);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }


    }