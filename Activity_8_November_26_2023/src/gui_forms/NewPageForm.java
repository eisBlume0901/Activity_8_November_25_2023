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
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class NewPageForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewPageForm frame = new NewPageForm(null);
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
	public NewPageForm(String username) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(236, 244, 214));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel helloWelcomeLabel = new JLabel("Hello, " + username);
		helloWelcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		helloWelcomeLabel.setForeground(new Color(45, 149, 150));
		helloWelcomeLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		helloWelcomeLabel.setBounds(0, 51, 426, 80);
		contentPane.add(helloWelcomeLabel);
		
		JLabel lblWelcome = new JLabel("WELCOME");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setForeground(new Color(38, 80, 115));
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 45));
		lblWelcome.setBounds(0, 117, 426, 80);
		contentPane.add(lblWelcome);
		
	

	}
	
}
