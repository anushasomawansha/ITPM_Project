package Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import DBConnect.DBConnect;
import net.proteanit.sql.DbUtils;

import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;
import java.awt.SystemColor;

public class ManageSubjects {

	private JFrame frame;
	private JTextField tfSubName;
	private JTextField tfSubCode;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageSubjects window = new ManageSubjects();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ManageSubjects() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				try {
					Connection con = DBConnect.connect();
					
					String query="select subID AS SUBJECT_ID ,year AS YEAR,semester AS SEMESTER,subName AS SUBJECT ,subCode AS SUBJECT_CODE , lectureHours AS LECTURE_HOURS , tuteHours AS TUTE_HOURS,labHours AS LAB_HOURS,evaluationHours AS EVALUATION_HOURS from subjects";
					PreparedStatement pst=con.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 1200, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(Color.WHITE);
		panel.setBackground(new Color(0, 139, 139));
		panel.setBounds(0, 0, 250, 661);
		frame.getContentPane().add(panel);
		
		JButton button = new JButton("< Back");
		button.setFont(new Font("Tahoma", Font.BOLD, 13));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DashBoard itm = new DashBoard();
				DashBoard.main(null);
				frame.setVisible(false);
			}
		});
		button.setBounds(77, 11, 89, 30);
		panel.add(button);
		
		JButton button_1 = new JButton("Add Subject");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddSubject addSubject = new AddSubject();
				try {
					AddSubject.main(null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setVisible(false);
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_1.setBackground(new Color(0, 139, 139));
		button_1.setBounds(10, 103, 230, 57);
		panel.add(button_1);
		
		JButton btnManageSubject = new JButton("Manage Subject");
		btnManageSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ManageSubjects addSubject = new ManageSubjects();
				try {
					ManageSubjects.main(null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setVisible(false);
			}
		});
		btnManageSubject.setForeground(Color.WHITE);
		btnManageSubject.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnManageSubject.setBackground(new Color(0, 139, 139));
		btnManageSubject.setBounds(10, 165, 230, 57);
		panel.add(btnManageSubject);
		
		JLabel lblManageSubjects = new JLabel("Manage Subjects");
		lblManageSubjects.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblManageSubjects.setBounds(286, 25, 271, 37);
		frame.getContentPane().add(lblManageSubjects);
		
		JLabel label = new JLabel("Offered year");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(286, 383, 116, 28);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Offered semester");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_1.setBounds(286, 440, 116, 28);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Subject name");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_2.setBounds(286, 494, 116, 28);
		frame.getContentPane().add(label_2);
		
		JRadioButton rbSem1 = new JRadioButton("1st");
		rbSem1.setFont(new Font("Tahoma", Font.BOLD, 11));
		rbSem1.setBackground(Color.LIGHT_GRAY);
		rbSem1.setBounds(431, 445, 67, 23);
		frame.getContentPane().add(rbSem1);
		
		JComboBox cbOfferedYear = new JComboBox();
		cbOfferedYear.setModel(new DefaultComboBoxModel(new String[] {"Select", "1st Year", "2nd Year", "3rd Year", "4th Year"}));
		cbOfferedYear.setForeground(Color.BLACK);
		cbOfferedYear.setBackground(Color.WHITE);
		cbOfferedYear.setBounds(431, 388, 145, 20);
		frame.getContentPane().add(cbOfferedYear);
		
		JRadioButton rbSem2 = new JRadioButton("2nd");
		rbSem2.setFont(new Font("Tahoma", Font.BOLD, 11));
		rbSem2.setBackground(Color.LIGHT_GRAY);
		rbSem2.setBounds(514, 445, 75, 23);
		frame.getContentPane().add(rbSem2);
		
		tfSubName = new JTextField();
		tfSubName.setColumns(10);
		tfSubName.setBounds(431, 499, 138, 20);
		frame.getContentPane().add(tfSubName);
		
		tfSubCode = new JTextField();
		tfSubCode.setColumns(10);
		tfSubCode.setBounds(431, 556, 138, 20);
		frame.getContentPane().add(tfSubCode);
		
		JLabel label_3 = new JLabel("Subject code");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_3.setBounds(286, 551, 116, 28);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Number of lecture hours");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_4.setBounds(681, 383, 159, 28);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("Number of tutorials hours");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_5.setBounds(681, 440, 174, 28);
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("Number of lab hours");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_6.setBounds(681, 494, 145, 28);
		frame.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("Number of evalution hours");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_7.setBounds(681, 551, 174, 28);
		frame.getContentPane().add(label_7);
		
		JSpinner spEvalHours = new JSpinner();
		spEvalHours.setModel(new SpinnerNumberModel(0, 0, 5, 1));
		spEvalHours.setBounds(885, 556, 94, 20);
		frame.getContentPane().add(spEvalHours);
		
		JSpinner spLabHours = new JSpinner();
		spLabHours.setModel(new SpinnerNumberModel(0, 0, 5, 1));
		spLabHours.setBounds(885, 502, 94, 20);
		frame.getContentPane().add(spLabHours);
		
		JSpinner spTutHours = new JSpinner();
		spTutHours.setModel(new SpinnerNumberModel(0, 0, 5, 1));
		spTutHours.setBounds(885, 445, 94, 20);
		frame.getContentPane().add(spTutHours);
		
		JSpinner spLecHours = new JSpinner();
		spLecHours.setModel(new SpinnerNumberModel(0, 0, 5, 1));
		spLecHours.setBounds(885, 388, 94, 20);
		frame.getContentPane().add(spLecHours);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBackground(SystemColor.textHighlight);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tfSubName.setText(null);
				tfSubCode.setText(null);
				rbSem1.setSelected(false);
				rbSem2.setSelected(false);
				cbOfferedYear.setSelectedIndex(0);
				spLecHours.setValue(new Integer(0));
				spTutHours.setValue(new Integer(0));
				spLabHours.setValue(new Integer(0));
				spEvalHours.setValue(new Integer(0));
			}
		});
		btnClear.setBounds(663, 613, 89, 37);
		frame.getContentPane().add(btnClear);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(274, 89, 900, 264);
		frame.getContentPane().add(scrollPane);
		

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int selectedRow=table.getSelectedRow();
				
				String offerdYear = table.getValueAt(selectedRow, 1).toString();
				for(int i=0; i<cbOfferedYear.getItemCount();i++) {
					if(cbOfferedYear.getItemAt(i).toString().equalsIgnoreCase(offerdYear)) {
						cbOfferedYear.setSelectedIndex(i);
					}
				}
				
				String semester = table.getValueAt(selectedRow, 2).toString();
				System.out.println(semester);
				if(semester.equals("1st Semester")) {
					rbSem1.setSelected(true);
					rbSem2.setSelected(false);
					
				}else if(semester.equals("2nd Semester")){
					rbSem2.setSelected(true);
					rbSem1.setSelected(false);
				}
				
				tfSubName.setText(table.getValueAt(selectedRow, 3).toString());
				tfSubCode.setText(table.getValueAt(selectedRow, 4).toString());
				spLecHours.setValue(table.getValueAt(selectedRow, 5));
				spTutHours.setValue(table.getValueAt(selectedRow, 6));
				spLabHours.setValue(table.getValueAt(selectedRow, 7));
				spEvalHours.setValue(table.getValueAt(selectedRow, 8));
				textField.setText(table.getValueAt(selectedRow, 0).toString());
				
			}});
		scrollPane.setViewportView(table);
		
		textField = new JTextField();
		textField.setBackground(new Color(192, 192, 192));
		textField.setColumns(10);
		textField.setBounds(286, 390, -7, -4);
		frame.getContentPane().add(textField);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBackground(SystemColor.textHighlight);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String sem = null;
				
				if(rbSem1.isSelected()) {
					 sem = "1st Semester";
				}else if(rbSem2.isSelected()) {
					 sem = "2nd Semester";
				}
				
				if(cbOfferedYear.getSelectedIndex()==0) {
					JOptionPane.showMessageDialog(null, "Select Offered Year!");
				}else if(sem==null){
					JOptionPane.showMessageDialog(null, "Please Select Semester!");
				}else if(tfSubName.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Please Enter Subject Name!");
				}
				else if(tfSubCode.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Please Enter Code!");
				}
				else {
				try {
					Connection con = DBConnect.connect();
				
					String query="Update subjects set year='"+cbOfferedYear.getSelectedItem().toString()+"',semester='"+sem+"',subName='"+tfSubName.getText()+"',subCode='"+tfSubCode.getText()+"',lectureHours='"+spLecHours.getValue().toString()+"',tuteHours='"+spTutHours.getValue().toString()+"',labHours='"+spLabHours.getValue().toString()+"',evaluationHours='"+spEvalHours.getValue().toString()+"' where subID='"+textField.getText()+"' ";
					PreparedStatement pst=con.prepareStatement(query);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Subject Details Updated Successfully!");
					pst.close();
					
					tfSubName.setText(null);
					tfSubCode.setText(null);
					rbSem1.setSelected(false);
					rbSem2.setSelected(false);
					cbOfferedYear.setSelectedIndex(0);
					spLecHours.setValue(new Integer(0));
					spTutHours.setValue(new Integer(0));
					spLabHours.setValue(new Integer(0));
					spEvalHours.setValue(new Integer(0));
					
					System.out.println(cbOfferedYear.getSelectedItem().toString() +" "+sem+ tfSubName.getText()+tfSubCode.getText()+spLecHours.getValue().toString()+spTutHours.getValue().toString()+spLabHours.getValue().toString()+spEvalHours.getValue().toString());
					
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			
			}	
			}
		});
		btnUpdate.setBounds(779, 613, 89, 37);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(SystemColor.textHighlight);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Connection con = DBConnect.connect();
					String query="Delete from subjects where subID='"+textField.getText()+"'";
					PreparedStatement pst=con.prepareStatement(query);
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Subjects Details Deleted Successfully");
					pst.close();
					
					tfSubName.setText(null);
					tfSubCode.setText(null);
					rbSem1.setSelected(false);
					rbSem2.setSelected(false);
					cbOfferedYear.setSelectedIndex(0);
					spLecHours.setValue(new Integer(0));
					spTutHours.setValue(new Integer(0));
					spLabHours.setValue(new Integer(0));
					spEvalHours.setValue(new Integer(0));
	
					}
					catch(Exception ex) {
						ex.printStackTrace();
						
					}
			}
		});
		btnDelete.setBounds(890, 613, 89, 37);
		frame.getContentPane().add(btnDelete);
		
		
		
	
		
		
	}
}
