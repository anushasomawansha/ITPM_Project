package Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import DBConnect.DBConnect;
import net.proteanit.sql.DbUtils;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;

public class ManageSession {

	private JFrame frame;
	private JFrame frame_1;
	private JTable table;
	private JTextField tfID;
	public JComboBox cbLecturer1 , cbLecturer2,cbStuGroups,cbSubjects,cbTags;
	public JSpinner spNoOfStudents,spDuration;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageSession window = new ManageSession();
					window.frame_1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ManageSession() {
		initialize();
	}
	
	public void getLecturers() {
		try {
			Connection con = DBConnect.connect();
			
			String query="select * from lecturers";
			PreparedStatement pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			//comboBox.setModel(DbUtils.resultSetToNestedList(rs));
			//comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Lecturer..."}))
			while(rs.next()) {
				String lec1=rs.getString("lectureName");
				cbLecturer1.addItem(lec1);
				cbLecturer2.addItem(lec1);
			}
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}


public void getsubjects() {
	try {
		Connection con = DBConnect.connect();
		
		String query="select * from subjects";
		PreparedStatement pst=con.prepareStatement(query);
		ResultSet rs=pst.executeQuery();
		//comboBox.setModel(DbUtils.resultSetToNestedList(rs));
		//comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Lecturer..."}))
		while(rs.next()) {
			String subjects=rs.getString("subName");
			String subCode=rs.getString("subCode");
			cbSubjects.addItem(subjects);
		
		}
		con.close();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}

public void getTags() {
	try {
		Connection con = DBConnect.connect();
		
		String query="select * from tag";
		PreparedStatement pst=con.prepareStatement(query);
		ResultSet rs=pst.executeQuery();
		//comboBox.setModel(DbUtils.resultSetToNestedList(rs));
		//comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Lecturer..."}))
		while(rs.next()) {
			String tags=rs.getString("tagName");
			cbTags.addItem(tags);
		}
		con.close();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}

public void getGroups() {
	try {
		Connection con = DBConnect.connect();
		
		String query="select * from studentGroups";
		PreparedStatement pst=con.prepareStatement(query);
		ResultSet rs=pst.executeQuery();
		//comboBox.setModel(DbUtils.resultSetToNestedList(rs));
		//comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Lecturer..."}))
		while(rs.next()) {
			String groups=rs.getString("SubGroupID");
			cbStuGroups.addItem(groups);
		}
		con.close();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame_1 = new JFrame();
		frame_1.setResizable(false);
		frame_1.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				try {
					Connection con = DBConnect.connect();
					
					String query="select * from session";
					PreparedStatement pst=con.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		frame_1.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame_1.setBounds(100, 100, 1200, 700);
		frame_1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame_1.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(Color.WHITE);
		panel.setBackground(new Color(0, 139, 139));
		panel.setBounds(0, 0, 250, 661);
		frame_1.getContentPane().add(panel);
		
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
		
		JButton button_1 = new JButton("Add Session");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddSession addSession = new AddSession();
				AddSession.main(null);
				frame_1.setVisible(false);
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_1.setBackground(new Color(0, 139, 139));
		button_1.setBounds(10, 103, 230, 57);
		panel.add(button_1);
		
		JButton button_2 = new JButton("Manage Session");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ManageSession manageSesssion = new ManageSession();
				ManageSession.main(null);
				frame_1.setVisible(false);
			}
		});
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_2.setBackground(new Color(0, 139, 139));
		button_2.setBounds(10, 165, 230, 57);
		panel.add(button_2);
		
		JButton button_3 = new JButton("Session Allocation");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					SessionAllocation newWindow = new SessionAllocation();	
					SessionAllocation.main(null);
					frame_1.setVisible(false);
		
			}
		});
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_3.setBackground(new Color(0, 139, 139));
		button_3.setBounds(10, 228, 230, 57);
		panel.add(button_3);
		
		JLabel lblManageSessions = new JLabel("Manage Sessions");
		lblManageSessions.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblManageSessions.setBounds(287, 36, 271, 37);
		frame_1.getContentPane().add(lblManageSessions);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBackground(SystemColor.textHighlight);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(cbStuGroups.getSelectedIndex()==0) {
					JOptionPane.showMessageDialog(null, "Please Select Student Group");
				}else if(cbSubjects.getSelectedIndex()==0) {
					JOptionPane.showMessageDialog(null, "Please Select Subject!");
				}else if(spNoOfStudents.getValue().equals(0)) {
					JOptionPane.showMessageDialog(null, "Please Add Number Of Students!");
				}else if(spDuration.getValue().equals(0)) {
					JOptionPane.showMessageDialog(null, "Please Add Session Duration!");
				}else {
				try {
					Connection con = DBConnect.connect();

					String SubCode = null;
					String query2="select subCode from subjects where subName= '"+cbSubjects.getSelectedItem().toString()+"'";
					PreparedStatement pst2=con.prepareStatement(query2);
					ResultSet rs2=pst2.executeQuery();
					while(rs2.next()) {
						SubCode=rs2.getString("subCode");
					}
				
				String sessionID=cbLecturer1.getSelectedItem().toString()+" "+cbSubjects.getSelectedItem().toString()+"("+SubCode+") "+cbTags.getSelectedItem().toString()+" "+cbStuGroups.getSelectedItem().toString()+" "+spNoOfStudents.getValue().toString()+"("+spDuration.getValue().toString()+")";
					
		
					
					String query="Update session set Lectuer1_Name='"+cbLecturer1.getSelectedItem().toString()+"',Lectuer2_Name='"+cbLecturer2.getSelectedItem().toString()+"',Subject_Code='"+SubCode+"',Subject_Name='"+cbSubjects.getSelectedItem().toString()+"',Student_Group_ID='"+cbStuGroups.getSelectedItem().toString()+"',Tag='"+cbTags.getSelectedItem().toString()+"',No_Of_Students='"+spNoOfStudents.getValue().toString()+"',Duration='"+spDuration.getValue().toString()+"',Session_Signature='"+sessionID+"' where Session_ID='"+tfID.getText()+"' ";
					PreparedStatement pst=con.prepareStatement(query);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Session Data Updated Successfully");
					pst.close();
					cbLecturer1.setSelectedIndex(0);
					cbLecturer2.setSelectedIndex(0);
					cbTags.setSelectedIndex(0);
					cbStuGroups.setSelectedIndex(0);
					cbSubjects.setSelectedIndex(0);
					spNoOfStudents.setValue(new Integer(0));
					spDuration.setValue(new Integer(0));

				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
			
				
				}
			}
		});
		btnUpdate.setBounds(899, 588, 89, 37);
		frame_1.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(SystemColor.textHighlight);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Connection con = DBConnect.connect();
					String query="Delete from session where Session_ID='"+tfID.getText()+"'";
					PreparedStatement pst=con.prepareStatement(query);
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Session Details Deleleted Successfully");
					pst.close();
					
					cbLecturer1.setSelectedIndex(0);
					cbLecturer2.setSelectedIndex(0);
					cbTags.setSelectedIndex(0);
					cbStuGroups.setSelectedIndex(0);
					cbSubjects.setSelectedIndex(0);
					spNoOfStudents.setValue(new Integer(0));
					spDuration.setValue(new Integer(0));

					}
					catch(Exception ex) {
						ex.printStackTrace();
					}
		
			}
		});
		btnDelete.setBounds(1016, 588, 89, 37);
		frame_1.getContentPane().add(btnDelete);
		
		JLabel lblSelectLecturer = new JLabel("Select lecturer");
		lblSelectLecturer.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSelectLecturer.setBounds(287, 447, 116, 28);
		frame_1.getContentPane().add(lblSelectLecturer);
		
		cbLecturer1 = new JComboBox();
		cbLecturer1.setModel(new DefaultComboBoxModel(new String[] {"Select"}));
		cbLecturer1.setForeground(Color.BLACK);
		cbLecturer1.setBackground(Color.WHITE);
		cbLecturer1.setBounds(443, 452, 145, 20);
		frame_1.getContentPane().add(cbLecturer1);
		
		JLabel lblSelectGroups = new JLabel("Select groups");
		lblSelectGroups.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSelectGroups.setBounds(287, 520, 116, 28);
		frame_1.getContentPane().add(lblSelectGroups);
		
		cbStuGroups = new JComboBox();
		cbStuGroups.setModel(new DefaultComboBoxModel(new String[] {"Select"}));
		cbStuGroups.setForeground(Color.BLACK);
		cbStuGroups.setBackground(Color.WHITE);
		cbStuGroups.setBounds(443, 524, 145, 20);
		frame_1.getContentPane().add(cbStuGroups);
		
		cbSubjects = new JComboBox();
		cbSubjects.setModel(new DefaultComboBoxModel(new String[] {"Select"}));
		cbSubjects.setForeground(Color.BLACK);
		cbSubjects.setBackground(Color.WHITE);
		cbSubjects.setBounds(443, 564, 145, 20);
		frame_1.getContentPane().add(cbSubjects);
		
		JLabel lblSelectSubjects = new JLabel("Select subjects");
		lblSelectSubjects.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSelectSubjects.setBounds(285, 565, 101, 18);
		frame_1.getContentPane().add(lblSelectSubjects);
		
		JLabel lblSelectTag = new JLabel("Select tag");
		lblSelectTag.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSelectTag.setBounds(700, 447, 116, 28);
		frame_1.getContentPane().add(lblSelectTag);
		
		cbTags = new JComboBox();
		cbTags.setModel(new DefaultComboBoxModel(new String[] {"Select"}));
		cbTags.setForeground(Color.BLACK);
		cbTags.setBackground(Color.WHITE);
		cbTags.setBounds(856, 452, 145, 20);
		frame_1.getContentPane().add(cbTags);
		
		JLabel lblNumberOfStudent = new JLabel("Number of student");
		lblNumberOfStudent.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNumberOfStudent.setBounds(700, 494, 134, 28);
		frame_1.getContentPane().add(lblNumberOfStudent);
		
		JLabel lblDuration = new JLabel("Duration");
		lblDuration.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDuration.setBounds(700, 538, 116, 28);
		frame_1.getContentPane().add(lblDuration);
		
		spNoOfStudents = new JSpinner();
		spNoOfStudents.setBounds(856, 499, 94, 20);
		frame_1.getContentPane().add(spNoOfStudents);
		
		spDuration = new JSpinner();
		spDuration.setBounds(856, 543, 94, 20);
		frame_1.getContentPane().add(spDuration);
		
		JLabel lblHrs = new JLabel("hrs");
		lblHrs.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHrs.setBounds(960, 538, 116, 28);
		frame_1.getContentPane().add(lblHrs);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(280, 86, 862, 356);
		frame_1.getContentPane().add(scrollPane);
		
		table = new JTable() {
			@Override
		       public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		           Component component = super.prepareRenderer(renderer, row, column);
		           int rendererWidth = component.getPreferredSize().width;
		           TableColumn tableColumn = getColumnModel().getColumn(column);
		           tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
		           return component;
		        }
		};
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int selectedRow=table.getSelectedRow();
				
				tfID.setText(table.getValueAt(selectedRow, 0).toString());
				
				
			/*	tfEmpID.setText(table.getValueAt(selectedRow, 2).toString());
				tfRank.setText(table.getValueAt(selectedRow, 8).toString());
				//textField_5.setText(table.getValueAt(selectedRow, 8).toString());
				textField_3.setText(table.getValueAt(selectedRow, 0).toString());*/
				
				
				String lec1 = table.getValueAt(selectedRow, 1).toString();
				for(int i=0; i<cbLecturer1.getItemCount();i++) {
					if(cbLecturer1.getItemAt(i).toString().equalsIgnoreCase(lec1)) {
						cbLecturer1.setSelectedIndex(i);
					}
				}
				
				String lec2 = table.getValueAt(selectedRow, 2).toString();
				for(int i=0; i<cbLecturer2.getItemCount();i++) {
					if(cbLecturer2.getItemAt(i).toString().equalsIgnoreCase(lec2)) {
						cbLecturer2.setSelectedIndex(i);
					}
				}
			
				String subName = table.getValueAt(selectedRow,4).toString();
				for(int i=0; i<cbSubjects.getItemCount();i++) {
					if(cbSubjects.getItemAt(i).toString().equalsIgnoreCase(subName)) {
						cbSubjects.setSelectedIndex(i);
					}
				}
				
				String studGroup = table.getValueAt(selectedRow,5).toString();
				for(int i=0; i<cbStuGroups.getItemCount();i++) {
					if(cbStuGroups.getItemAt(i).toString().equalsIgnoreCase(studGroup)) {
						cbStuGroups.setSelectedIndex(i);
					}
				}
				
				String tags = table.getValueAt(selectedRow,6).toString();
				for(int i=0; i<cbTags.getItemCount();i++) {
					if(cbTags.getItemAt(i).toString().equalsIgnoreCase(tags)) {
						cbTags.setSelectedIndex(i);
					}
				}
				
				spNoOfStudents.setValue(table.getValueAt(selectedRow, 7));
				spDuration.setValue(table.getValueAt(selectedRow, 8));

		}
		});
		
		tfID = new JTextField();
		tfID.setEditable(false);
		tfID.setBackground(Color.LIGHT_GRAY);
		tfID.setBounds(1034, 450, -2, 22);
		frame_1.getContentPane().add(tfID);
		tfID.setColumns(10);
		
		cbLecturer2 = new JComboBox();
		cbLecturer2.setModel(new DefaultComboBoxModel(new String[] {"Select"}));
		cbLecturer2.setForeground(Color.BLACK);
		cbLecturer2.setBackground(Color.WHITE);
		cbLecturer2.setBounds(443, 491, 145, 20);
		frame_1.getContentPane().add(cbLecturer2);
		
		JLabel lblSelectLecturer_1 = new JLabel("Select lecturer");
		lblSelectLecturer_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSelectLecturer_1.setBounds(287, 488, 116, 28);
		frame_1.getContentPane().add(lblSelectLecturer_1);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBackground(SystemColor.textHighlight);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbLecturer1.setSelectedIndex(0);
				cbLecturer2.setSelectedIndex(0);
				cbTags.setSelectedIndex(0);
				cbStuGroups.setSelectedIndex(0);
				cbSubjects.setSelectedIndex(0);
				spNoOfStudents.setValue(new Integer(0));
				spDuration.setValue(new Integer(0));
			
			}
		});
		btnClear.setBounds(780, 588, 89, 37);
		frame_1.getContentPane().add(btnClear);
		
		getLecturers();
		getTags();
		getGroups();
		getsubjects();
	}
}
