package user;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Colombo.Employee;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import data.EmployeeDB;
import data.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class employeeUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtemployee;
	private JTextField txtnumber;
	private JTextField txtdepartment;
	private Employee em;
	
	
	
	private EmployeeDB eDB;
	private EmployeeData fileDB;
	private JTable tblData;
	private DefaultTableModel tblModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					employeeUI frame = new employeeUI();
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
	public employeeUI() {
		setResizable(false);
		setTitle("employee details");
		setBounds(100, 100, 564, 599);
		setLocationRelativeTo(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		eDB=new EmployeeDB();
		fileDB=new EmployeeData();
		
		
		JLabel lblname = new JLabel("Employee name");
		lblname.setForeground(Color.BLACK);
		lblname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblname.setBounds(28, 38, 123, 22);
		contentPane.add(lblname);
		
		JLabel lblepf = new JLabel("EPF Number");
		lblepf.setForeground(Color.BLACK);
		lblepf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblepf.setBounds(28, 89, 142, 22);
		contentPane.add(lblepf);
		
		JLabel lbldepartment = new JLabel("Department");
		lbldepartment.setForeground(Color.BLACK);
		lbldepartment.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbldepartment.setHorizontalAlignment(SwingConstants.LEFT);
		lbldepartment.setBounds(28, 139, 123, 27);
		contentPane.add(lbldepartment);
		
		txtemployee = new JTextField();
		txtemployee.setToolTipText("Name of Employee");
		txtemployee.setBounds(225, 42, 155, 19);
		contentPane.add(txtemployee);
		txtemployee.setColumns(10);
		
		txtnumber = new JTextField();
		txtnumber.setToolTipText("EPF of Employee");
		txtnumber.setBounds(225, 93, 155, 19);
		contentPane.add(txtnumber);
		txtnumber.setColumns(10);
		
		txtdepartment = new JTextField();
		txtdepartment.setToolTipText("Departmet of Employee");
		txtdepartment.setBounds(225, 145, 155, 19);
		contentPane.add(txtdepartment);
		txtdepartment.setColumns(10);
		
		JLabel lblSection = new JLabel("Section");
		lblSection.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSection.setBounds(28, 190, 97, 32);
		contentPane.add(lblSection);
		
		JLabel lblDes = new JLabel("Designation");
		lblDes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDes.setBounds(28, 244, 85, 27);
		contentPane.add(lblDes);
		
		JRadioButton rdbtnAcademic = new JRadioButton("Academic");
		rdbtnAcademic.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnAcademic.setBounds(213, 196, 103, 21);
		contentPane.add(rdbtnAcademic);
		
		JRadioButton rdbtnNonAcademic = new JRadioButton("Non Academic");
		rdbtnNonAcademic.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnNonAcademic.setBounds(351, 196, 142, 21);
		contentPane.add(rdbtnNonAcademic);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(rdbtnAcademic);
		bg.add(rdbtnNonAcademic);
		
		JComboBox cmbDesignation = new JComboBox();
		cmbDesignation.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbDesignation.setModel(new DefaultComboBoxModel(new String[] {"Senior lecturer", "lecturer", "manager", "accountant", "counselor"}));
		cmbDesignation.setBounds(225, 249, 211, 21);
		contentPane.add(cmbDesignation);
		
		JScrollPane scrollPane=new JScrollPane();
		scrollPane.setBounds(40, 368, 486, 173);
		contentPane.add(scrollPane);
		
		tblModel= new DefaultTableModel();
		tblModel.addColumn("Name");
		tblModel.addColumn("EPF No");
		tblModel.addColumn("Department");
		tblModel.addColumn("Section");
		tblModel.addColumn("Designation");
		

		tblData = new JTable();
		tblData.setBounds(40, 368, 486, 173);
		tblData.setModel(tblModel);
		scrollPane.setViewportView(tblData);
		
		
		
		JButton btnadd = new JButton("Add");
		
		
		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(checkValidation()==true) {
					String name=txtemployee.getText();
					int epf=Integer.valueOf(txtnumber.getText());
					String department=txtdepartment.getText();
					String section="";
					if(rdbtnAcademic.isSelected()) {
						section="Academic";
					}else {
						section="Non Academic";
					}
					
					String designation=cmbDesignation.getSelectedItem().toString();	
							
					em= new Employee(name , epf , department,section,designation);
					
					fileDB.add(em);
					
				}
				
			}
		
		});
		btnadd.setBounds(40, 296, 85, 21);
		contentPane.add(btnadd);
		
		JButton btndisplay = new JButton("Display");
		btndisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				
				tblModel.setRowCount(0);
				for( Employee l:fileDB.getAll()) {
					String name=l.getName();
	                int epf=l.getEpf();
	                String department=l.getDepartment();
	                String section=l.getSection();
	                String designation=l.getDesignation();
	                		tblModel.addRow(new Object[] {name,epf,department,section,designation}) ;
					
					
				}
				
				
				
			}
		});
		btndisplay.setBounds(169, 296, 85, 21);
		contentPane.add(btndisplay);
		
		JButton btnreset = new JButton("Reset");
		btnreset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtemployee.setText("");
				txtnumber.setText("");
				txtdepartment.setText("");
					
				
			}
		});
		btnreset.setForeground(Color.BLACK);
		btnreset.setBounds(441, 296, 85, 21);
		contentPane.add(btnreset);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int epf= Integer.valueOf(JOptionPane.showInputDialog("plese enter EPF number to be Delete"));
				
				boolean flag=fileDB.delete(epf);
				if(flag) {
					JOptionPane.showMessageDialog(contentPane, " The name is deleted");
				}else {
					JOptionPane.showMessageDialog(contentPane, "The name is not deleted");
				}
			}
		});
		btnDelete.setBounds(295, 296, 85, 21);
		contentPane.add(btnDelete);
		
		JButton btnFind = new JButton("Find");
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
		btnFind.setBounds(169, 337, 85, 21);
		contentPane.add(btnFind);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkValidation()==true) {
					String name=txtemployee.getText();
					int epf=Integer.valueOf(txtnumber.getText());
					String department=txtdepartment.getText();
					String section="";
					if(rdbtnAcademic.isSelected()) {
						section="Academic";
					}else {
						section="Non Academic";
					}
					
					String designation=cmbDesignation.getSelectedItem().toString();	
							
					em= new Employee(name , epf , department,section,designation);
					
					fileDB.update(em);
					
				}
				
			}
		});
		btnUpdate.setBounds(295, 337, 85, 21);
		contentPane.add(btnUpdate);
		
		}	
		
		
		
	//}
	private boolean checkValidation() {
		if (txtemployee.getText().equals("")){
			JOptionPane.showMessageDialog(txtemployee, "Employee name cannot be blank");
			return false;
		}
		
		if (txtnumber.getText().equals("")){
			JOptionPane.showMessageDialog(txtnumber, "EPF number cannot be blank");
			return false;	
	}
		
		if (txtdepartment.getText().equals("")){
			JOptionPane.showMessageDialog(txtdepartment, "Depatment cannot be blank");
			return false;	
	}
		return true;
		
	}
}
