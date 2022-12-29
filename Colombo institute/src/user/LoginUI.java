package user;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import Colombo.Login;
import data.LoginDB;

public class LoginUI extends JFrame {

	private JPanel contentPane;
	private JTextField textUserID;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI frame = new LoginUI();
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
	public LoginUI() {
		setTitle("Login");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 512);
		setLocationRelativeTo(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(59, 180, 100, 57);
		contentPane.add(lblPassword);
		
		JLabel lblUserID = new JLabel("User ID");
		lblUserID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUserID.setHorizontalAlignment(SwingConstants.LEFT);
		lblUserID.setBounds(59, 118, 80, 35);
		contentPane.add(lblUserID);
		
		textUserID = new JTextField();
		textUserID.setBounds(219, 128, 165, 19);
		contentPane.add(textUserID);
		textUserID.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(219, 201, 165, 19);
		contentPane.add(password);
		
		JButton btnOk = new JButton("OK");
		btnOk.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String uID=textUserID.getText();
				String pwd=password.getText();
				
				
				LoginDB logDB=new LoginDB();
				Login log=logDB.get(uID);
				if (log!=null &&(pwd.equals(log.getPassword()))) {
					LoginSystem.UserId=uID;
				MainUI mUI=new MainUI();
				mUI.setVisible(true);
				setVisible(false);
					
				}else {
					JOptionPane.showMessageDialog(contentPane, "Invalid User ID or Password");
				}
				
				
			}
		});
		btnOk.setBounds(88, 304, 85, 21);
		contentPane.add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCancel.setBounds(345, 306, 85, 21);
		contentPane.add(btnCancel);
	}
}
