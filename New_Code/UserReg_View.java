package final_project_MVC;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UserReg_View extends JPanel{
	protected JFrame reg_Frame;
	private JLabel reg_nameLabel;
	private JTextField reg_nameTextField;
	private JLabel reg_idLabel;
	private JTextField reg_idTextField;
	private JLabel reg_userLabel;
	private JTextField reg_userTextField;
	private JLabel reg_passLabel;
	private JTextField reg_passTextField;
	private JButton reg_submit;
	private JButton reg_reset;
	private JButton back_to_login;
	
	public UserReg_View() {
		
        this.setLayout(null);
        
        //declare fonts for ease of use
        Font bold = new Font("Times New Roman", Font.BOLD, 20);
        Font plain = new Font("Times New Roman", Font.PLAIN, 15);
        
        
        //set up window
        reg_Frame = new JFrame("User Registration");
        reg_Frame.setLocation(new Point(700, 300));
        reg_Frame.add(this);
        reg_Frame.setSize(new Dimension(500, 500));
        reg_Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        //Student Name Label and entry box
        reg_nameLabel = new JLabel("Name: ");
        reg_nameLabel.setFont(bold);
        reg_nameLabel.setSize(250,40);
        reg_nameLabel.setLocation(100, 100);
        this.add(reg_nameLabel);
        reg_nameTextField = new JTextField();
        reg_nameTextField.setFont(plain);
        reg_nameTextField.setSize(190, 25);
        reg_nameTextField.setLocation(155, 110);
        this.add(reg_nameTextField);
        
        
        //Student ID Label and entry box
        reg_idLabel = new JLabel(" ID: ");
        reg_idLabel.setFont(bold);
        reg_idLabel.setSize(250, 40);
        reg_idLabel.setLocation(120, 130);
        this.add(reg_idLabel);
        reg_idTextField = new JTextField();
        reg_idTextField.setFont(plain);
        reg_idTextField.setSize(190, 25);
        reg_idTextField.setLocation(155, 140);
        this.add(reg_idTextField);
        
        
        //Student email Label and entry box
        reg_userLabel = new JLabel("Email: ");
        reg_userLabel.setFont(bold);
        reg_userLabel.setSize(250, 40);
        reg_userLabel.setLocation(100, 160);
        this.add(reg_userLabel);
        reg_userTextField = new JTextField();
        reg_userTextField.setFont(plain);
        reg_userTextField.setSize(190, 25);
        reg_userTextField.setLocation(155, 170);
        this.add(reg_userTextField);
        
        
        //Student Password Label and entry box
        reg_passLabel = new JLabel("Password: ");
        reg_passLabel.setFont(bold);
        reg_passLabel.setSize(250, 40);
        reg_passLabel.setLocation(70, 190);
        this.add(reg_passLabel);
        reg_passTextField = new JTextField();
        reg_passTextField.setFont(plain);
        reg_passTextField.setSize(190, 25);
        reg_passTextField.setLocation(155, 200);
        this.add(reg_passTextField);
        
        
        //Submit button Setup (functionality in controller)
        reg_submit = new JButton("Submit");
        reg_submit.setBounds(160, 250, 70, 25);
        reg_submit.setForeground(Color.WHITE);
        reg_submit.setBackground(Color.BLACK);
        reg_submit.setFont(new Font("Times New Roman", Font.BOLD,10));
        this.add(reg_submit);
        
        //Reset Button Setup
        reg_reset = new JButton("Reset");
        reg_reset.setBounds(240, 250, 70, 25);
        reg_reset.setForeground(Color.WHITE);
        reg_reset.setBackground(Color.BLACK);
        reg_reset.setFont(new Font("Times New Roman", Font.BOLD,10));
        this.add(reg_reset);
        
        //Back to Login
        back_to_login = new JButton("Back");
        back_to_login.setBounds(180, 290, 100, 25);
        back_to_login.setForeground(Color.WHITE);
        back_to_login.setBackground(Color.BLACK);
        back_to_login.setFont(new Font("Times New Roman", Font.BOLD, 10));
        this.add(back_to_login);
	}
	
	/*
	 * Getters and Setters
	 * |   |   |   |   |
	 * V   V   V   V   V
	 */
	
	public JFrame getReg_Frame() {
		return reg_Frame;
	}

	public void setReg_Frame(JFrame reg_Frame) {
		this.reg_Frame = reg_Frame;
	}

	public JLabel getReg_nameLabel() {
		return reg_nameLabel;
	}

	public void setReg_nameLabel(JLabel reg_nameLabel) {
		this.reg_nameLabel = reg_nameLabel;
	}

	public JTextField getReg_nameTextField() {
		return reg_nameTextField;
	}

	public void setReg_nameTextField(JTextField reg_nameTextField) {
		this.reg_nameTextField = reg_nameTextField;
	}

	public JLabel getReg_idLabel() {
		return reg_idLabel;
	}

	public void setReg_idLabel(JLabel reg_idLabel) {
		this.reg_idLabel = reg_idLabel;
	}

	public JTextField getReg_idTextField() {
		return reg_idTextField;
	}

	public void setReg_idTextField(JTextField reg_idTextField) {
		this.reg_idTextField = reg_idTextField;
	}

	public JLabel getReg_userLabel() {
		return reg_userLabel;
	}

	public void setReg_userLabel(JLabel reg_userLabel) {
		this.reg_userLabel = reg_userLabel;
	}

	public JTextField getReg_userTextField() {
		return reg_userTextField;
	}

	public void setReg_userTextField(JTextField reg_userTextField) {
		this.reg_userTextField = reg_userTextField;
	}

	public JLabel getReg_passLabel() {
		return reg_passLabel;
	}

	public void setReg_passLabel(JLabel reg_passLabel) {
		this.reg_passLabel = reg_passLabel;
	}

	public JTextField getReg_passTextField() {
		return reg_passTextField;
	}

	public void setReg_passTextField(JTextField reg_passTextField) {
		this.reg_passTextField = reg_passTextField;
	}

	public JButton getReg_submit() {
		return reg_submit;
	}

	public void setReg_submit(JButton reg_submit) {
		this.reg_submit = reg_submit;
	}

	public JButton getReg_reset() {
		return reg_reset;
	}

	public void setReg_reset(JButton reg_reset) {
		this.reg_reset = reg_reset;
	}

	public JButton getBack_to_login() {
		return back_to_login;
	}

	public void setBack_to_login(JButton back_to_login) {
		this.back_to_login = back_to_login;
	}
}
