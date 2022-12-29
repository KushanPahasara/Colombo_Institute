package user;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Colombo.Employee;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import data.Employeefile;
import Colombo.Login;

public class AddAccountUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtPassword;
	private Employeefile fileDB;
	private Login lo;
	private JButton btnreset;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddAccountUI frame = new AddAccountUI();
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
	public AddAccountUI() {
		setResizable(false);
		setTitle("Add New Account");
		setBounds(100, 100, 514, 468);
		setLocationRelativeTo(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		fileDB=new Employeefile();
		
		JLabel lblID = new JLabel("New User ID");
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblID.setHorizontalAlignment(SwingConstants.LEFT);
		lblID.setBounds(80, 98, 114, 28);
		contentPane.add(lblID);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setBounds(80, 171, 67, 45);
		contentPane.add(lblPassword);
		
		txtID = new JTextField();
		txtID.setBounds(240, 103, 160, 23);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(240, 180, 160, 28);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String UserID=txtID.getText();
			    String password=txtPassword.getText();
				
						
				lo= new Login(UserID,password);
				
				fileDB.add(lo);
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAdd.setBounds(80, 289, 114, 34);
		contentPane.add(btnAdd);
		
		btnreset = new JButton("Reset");
		btnreset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtID.setText("");
				txtPassword.setText("");
				
			}
		});
		btnreset.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnreset.setBounds(303, 289, 108, 34);
		contentPane.add(btnreset);
	}
}
