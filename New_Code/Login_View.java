package final_project_MVC;

import java.awt.*;
import javax.swing.*;


public class Login_View extends JPanel{
	private JFrame loginFrame;
	private JLabel login_userLabel;
	private JLabel login_passLabel;
	private JTextField login_userTextField;
	private JTextField login_passTextField;
	private JButton loginButton;
	private JButton registerButton;
	
	public Login_View() {
			
			this.setLayout(null);
			this.setVisible(true);
			
			loginFrame = new JFrame("Log In: ");
			loginFrame.setVisible(true);
			loginFrame.setLocation(new Point(300, 300));
			loginFrame.setSize(new Dimension(400, 200));
			loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			loginFrame.add(this);
			
			login_userLabel = new JLabel("Email:");
			login_userLabel.setBounds(100, 8, 70, 20);
			this.add(login_userLabel);
		
			login_userTextField = new JTextField();
			login_userTextField.setBounds(100, 27, 193, 28);
			this.add(login_userTextField);
			
			login_passLabel = new JLabel("Password:");
			login_passLabel.setBounds(100, 55, 70, 20);
			this.add(login_passLabel);
			
			login_passTextField = new JTextField();
			login_passTextField.setBounds(100, 75, 193, 28);
			this.add(login_passTextField);
			
			loginButton = new JButton("Log In");
			loginButton.setBounds(100,110,70,25);
	        loginButton.setForeground(Color.WHITE);
	        loginButton.setBackground(Color.BLACK);
	        loginButton.setFont(new Font("Arial", Font.BOLD, 10));
	        this.add(loginButton);
	        
	        registerButton = new JButton("Register");
	        registerButton.setBounds(200, 110, 90, 25);
	        registerButton.setForeground(Color.WHITE);
	        registerButton.setBackground(Color.BLACK);
	        registerButton.setFont(new Font("Arial", Font.BOLD, 10));
	        this.add(registerButton);
	}

	public JFrame getLoginFrame() {
		return loginFrame;
	}

	public void setLoginFrame(JFrame loginFrame) {
		this.loginFrame = loginFrame;
	}

	public JLabel getUsernameLabel() {
		return login_userLabel;
	}

	public void setUsernameLabel(JLabel login_userLabel) {
		this.login_userLabel = login_userLabel;
	}

	public JLabel getPassLabel() {
		return login_passLabel;
	}

	public void setPassLabel(JLabel login_passLabel) {
		this.login_passLabel = login_passLabel;
	}

	public JTextField getUsernameTextField() {
		return login_userTextField;
	}

	public void setUsernameTextField(JTextField login_userTextField) {
		this.login_userTextField = login_userTextField;
	}

	public JTextField getPassTextField() {
		return login_passTextField;
	}

	public void setPassTextField(JTextField login_passTextField) {
		this.login_passTextField = login_passTextField;
	}

	public JButton getLoginButton() {
		return loginButton;
	}

	public void setLoginButton(JButton loginButton) {
		this.loginButton = loginButton;
	}

	public JButton getRegisterButton() {
		return registerButton;
	}

	public void setRegisterButton(JButton registerButton) {
		this.registerButton = registerButton;
	}
	
	
}
