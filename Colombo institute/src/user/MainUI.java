package user;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

public class MainUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainUI frame = new MainUI();
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
	public MainUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 545, 491);
		setLocationRelativeTo(this);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		
		JMenu mnuOptions = new JMenu("Options");
		menuBar.add(mnuOptions);
		//if (!LoginSystem.UserId.equals("jhon")){
				//mnuOptions.setEnabled(false);
			//}
			
		
		JMenuItem mntmEmployee = new JMenuItem("Employee");
		mntmEmployee.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
		mntmEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			employeeUI eUI= new employeeUI();
			eUI.setVisible(true);
			
			}
		});
		mnuOptions.add(mntmEmployee);
		
		JMenuItem mntmClose = new JMenuItem("Close");
		mntmClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		mntmClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			System.exit(0);
			}
		});
		mnuOptions.add(mntmClose);
		
		JMenu search = new JMenu("Search Employee");
		menuBar.add(search);
		//if (!LoginSystem.UserId.equals("nimal")) {
		//search.setEnabled(false);
	//}
		
		JMenuItem mntmsearch = new JMenuItem("Search");
		mntmsearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchUI sUI= new SearchUI();
				sUI.setVisible(true);
			}
		});
		search.add(mntmsearch);
		
		JMenu mnuManage = new JMenu("Manage");
		menuBar.add(mnuManage);
		//if (!LoginSystem.UserId.equals("admin")) {
		//	mnuManage.setEnabled(false);
		//}
		
		JMenuItem mntmAddUser = new JMenuItem("Add New User");
		mntmAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddAccountUI aUI= new AddAccountUI();
				aUI.setVisible(true);
			}
		});
		mnuManage.add(mntmAddUser);
		
		JMenu mnuHelp = new JMenu("Help");
		menuBar.add(mnuHelp);
		
		JMenuItem mntmLogout = new JMenuItem("Log out");
		mntmLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LoginUI lUI=new LoginUI();
				lUI.setVisible(true);
				setVisible(false);
			}
		});
		mnuHelp.add(mntmLogout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
