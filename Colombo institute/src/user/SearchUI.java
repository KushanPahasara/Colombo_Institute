package user;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import Colombo.Employee;
import data.*;
import java.util.ArrayList;

public class SearchUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtemployee;
	private JTextField txtnumber;
	private JTextField txtdepartment;
	
	private EmployeeData fileDB;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchUI frame = new SearchUI();
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
	public SearchUI() {
		setResizable(false);
		setTitle("Search");
		setBounds(100, 100, 588, 524);
		setLocationRelativeTo(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		fileDB=new EmployeeData();
		
		JLabel lblname = new JLabel("Name");
		lblname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblname.setHorizontalAlignment(SwingConstants.LEFT);
		lblname.setBounds(38, 49, 107, 29);
		contentPane.add(lblname);
		
		JLabel lblepf = new JLabel("EPF Number");
		lblepf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblepf.setBounds(38, 87, 88, 38);
		contentPane.add(lblepf);
		
		JLabel lbldepartment = new JLabel("Department");
		lbldepartment.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbldepartment.setBounds(38, 145, 107, 26);
		contentPane.add(lbldepartment);
		
		JLabel lblSection = new JLabel("Section");
		lblSection.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSection.setBounds(38, 195, 88, 29);
		contentPane.add(lblSection);
		
		JLabel lblDes = new JLabel("Designation");
		lblDes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDes.setBounds(38, 250, 107, 29);
		contentPane.add(lblDes);
		
		txtemployee = new JTextField();
		txtemployee.setBounds(216, 54, 192, 24);
		contentPane.add(txtemployee);
		txtemployee.setColumns(10);
		
		txtnumber = new JTextField();
		txtnumber.setBounds(216, 97, 192, 28);
		contentPane.add(txtnumber);
		txtnumber.setColumns(10);
		
		txtdepartment = new JTextField();
		txtdepartment.setBounds(216, 142, 192, 29);
		contentPane.add(txtdepartment);
		txtdepartment.setColumns(10);
		
		JRadioButton rdbtnAcademic = new JRadioButton("Academic");
		rdbtnAcademic.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnAcademic.setBounds(209, 199, 103, 21);
		contentPane.add(rdbtnAcademic);
		
		JRadioButton rdbtnNonAcademic = new JRadioButton("Non Academic");
		rdbtnNonAcademic.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnNonAcademic.setBounds(338, 199, 141, 21);
		contentPane.add(rdbtnNonAcademic);
		
		JComboBox cmbDesignation = new JComboBox();
		cmbDesignation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cmbDesignation.setModel(new DefaultComboBoxModel(new String[] {"Senior lecturer", "lecturer", "manager", "accountant", "counselor"}));
		cmbDesignation.setBounds(227, 256, 192, 21);
		contentPane.add(cmbDesignation);
		
		
		JButton btnFind = new JButton("Search \r\n(first click me)");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int epf= Integer.valueOf(JOptionPane.showInputDialog("plese enter EPF number to be Found"));
				Employee l =fileDB.get(epf);
				if(l!=null) {
					txtemployee.setText(l.getName());
					txtnumber.setText(String.valueOf(l.getEpf()));
					txtdepartment.setText(l.getDepartment());
					if(l.getSection().equals("Academic")){
						rdbtnAcademic.setSelected(true);
			
		         }else {
		        	 rdbtnNonAcademic.setSelected(true);
		         }
					cmbDesignation.setSelectedItem(l.getDesignation());
					
				}else {
					JOptionPane.showMessageDialog(contentPane, "not avaialble");
				}
				
			}
		});
		btnFind.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnFind.setBounds(235, 333, 173, 53);
		contentPane.add(btnFind);
		
		
	}
}
