package gui_forms;

import java.util.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class ResetPasswordForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField oldPasswordField;
	private JPasswordField newPasswordField;
	private Map<String, String> userCredentialsMap;
	private String userName;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResetPasswordForm frame = new ResetPasswordForm(null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ResetPasswordForm(Map<String, String> map, String userName) {
		
		this.userCredentialsMap = map;
		this.userName = userName;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(154, 208, 194));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel oldPasswordLabel = new JLabel("Old Password");
		oldPasswordLabel.setBackground(new Color(38, 80, 115));
		oldPasswordLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		oldPasswordLabel.setBounds(40, 68, 127, 13);
		contentPane.add(oldPasswordLabel);
		
		JLabel newPasswordLabel = new JLabel("New Password");
		newPasswordLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		newPasswordLabel.setBackground(new Color(38, 80, 115));
		newPasswordLabel.setBounds(40, 114, 127, 13);
		contentPane.add(newPasswordLabel);
		
		JButton okButton = new JButton("OK");
		okButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				char[] oldPassword = oldPasswordField.getPassword();
				char[] newPassword = newPasswordField.getPassword();
				
				if (e.getSource() == okButton)
				{
					System.out.println(userCredentialsMap);
					
					if (userCredentialsMap.containsKey(userName))
					{
						if (Arrays.equals(userCredentialsMap.get(userName).toCharArray(), oldPassword))
						{
							if (!Arrays.equals(oldPassword, newPassword))
							{
								
								JOptionPane.showMessageDialog(okButton, "Changed password successfully!");
								
								userCredentialsMap.replace(userName, String.valueOf(newPassword));
								
								System.out.println(userCredentialsMap);
								
								LoginForm loginForm = new LoginForm(userCredentialsMap);
								
								
							}
							
						}
						else
						{
							JOptionPane.showMessageDialog(okButton, "Your input does not match your old password");
						}
					}
					else
					{
						JOptionPane.showMessageDialog(okButton, "Username is invalid");
					}
				}
			}
		});
		okButton.setBounds(187, 180, 85, 21);
		contentPane.add(okButton);
		
		oldPasswordField = new JPasswordField();
		oldPasswordField.setBounds(160, 67, 226, 19);
		contentPane.add(oldPasswordField);
		
		newPasswordField = new JPasswordField();
		newPasswordField.setBounds(163, 113, 226, 19);
		contentPane.add(newPasswordField);
	}
	
}
