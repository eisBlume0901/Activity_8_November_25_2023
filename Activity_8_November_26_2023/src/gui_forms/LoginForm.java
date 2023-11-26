package gui_forms;

import java.util.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import pojo.User;

import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginForm {

	private JFrame frame;
	private JTextField usernameTextField;
	private JLabel passwordLabel;
	private JPasswordField passwordField;
	private Map<String, String> userCredentialsMap;
	private JButton resetButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		Map<String, String> userCredentialsMap = new HashMap<>();
		
		User user1 = new User();
		user1.setUsername("Mary Kate");
		user1.setPassword("Anecito");
		
		userCredentialsMap.put(user1.getUsername(), user1.getPassword());
		
		User user2 = new User();
		user2.setUsername("Phillipe Dwaine");
		user2.setPassword("Estacio");
		
		new LoginForm(userCredentialsMap);
		
		
		
	}

	/**
	 * Create the application.
	 */
	public LoginForm(Map<String, String> map) {
		
		this.userCredentialsMap = map;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(38, 80, 115));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setForeground(new Color(236, 244, 214));
		usernameLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		usernameLabel.setBounds(38, 50, 83, 27);
		frame.getContentPane().add(usernameLabel);
		
		usernameTextField = new JTextField();
		usernameTextField.setBackground(new Color(236, 244, 214));
		usernameTextField.setBounds(120, 56, 276, 19);
		frame.getContentPane().add(usernameTextField);
		usernameTextField.setColumns(10);
		
		passwordLabel = new JLabel("Password");
		passwordLabel.setForeground(new Color(236, 244, 214));
		passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		passwordLabel.setBounds(38, 82, 83, 27);
		frame.getContentPane().add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(236, 244, 214));
		passwordField.setBounds(120, 88, 276, 19);
		frame.getContentPane().add(passwordField);
		
		JButton loginButton = new JButton("Login");
		loginButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (e.getSource() == loginButton)
				{
					
					String userNameInput = usernameTextField.getText();
					char[] passwordInput = passwordField.getPassword();
					
				
					if (userCredentialsMap.containsKey(userNameInput))
					{		
						if (Arrays.equals(userCredentialsMap.get(userNameInput).toCharArray(), passwordInput))
						{
							JOptionPane.showMessageDialog(frame, "Login successfully");
							NewPageForm newPageForm = new NewPageForm(userNameInput);
							newPageForm.setVisible(true);
					 	}
						else
						{
							JOptionPane.showMessageDialog(frame, "Invalid password");
						}
					}
					else
					{
						JOptionPane.showMessageDialog(frame, "Invalid username");
					}
					
				}
				
			}
		});
		loginButton.setBounds(81, 144, 83, 27);
		frame.getContentPane().add(loginButton);
		
		resetButton = new JButton("Reset");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (e.getSource() == resetButton)
				{
					ResetPasswordForm resetPasswordForm = new ResetPasswordForm(userCredentialsMap, usernameTextField.getText());
					resetPasswordForm.setVisible(true);
					
				}
			}
		});
		resetButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		resetButton.setBounds(268, 144, 83, 27);
		frame.getContentPane().add(resetButton);
		
		frame.setVisible(true);
	}
	
}
