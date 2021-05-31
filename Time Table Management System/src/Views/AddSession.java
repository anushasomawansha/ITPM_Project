package Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import DBConnect.DBConnect;

import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;

public class AddSession {

	private JFrame frame;
	private JTextField tfLecturers;
	public JComboBox cbLecturer,cbLecturer_1 , cbTag , cbGroups,cbSubjects;
	public JPanel panel_2;
	private JTextField textField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddSession window = new AddSession();
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
	public AddSession() {
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
				cbLecturer.addItem(lec1);
				cbLecturer_1.addItem(lec1);
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
			cbTag.addItem(tags);
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
			cbGroups.addItem(groups);
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
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 1200, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(new Color(0, 139, 139));
		panel.setBounds(0, 0, 250, 661);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
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
		JButton btnAddSession = new JButton("Add Session");
		btnAddSession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddSession addSession = new AddSession();
				try {
					AddSession.main(null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setVisible(false);
				
			}
		});
		btnAddSession.setBounds(10, 103, 230, 57);
		btnAddSession.setForeground(Color.WHITE);
		btnAddSession.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddSession.setBackground(new Color(0, 139, 139));
		panel.add(btnAddSession);
		
		JButton btnManegeSession = new JButton("Manage Session");
		btnManegeSession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ManageSession manageSesssion = new ManageSession();
				try {
					ManageSession.main(null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setVisible(false);
			}
		});
		btnManegeSession.setBounds(10, 165, 230, 57);
		btnManegeSession.setForeground(Color.WHITE);
		btnManegeSession.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnManegeSession.setBackground(new Color(0, 139, 139));
		panel.add(btnManegeSession);
		
		JButton btnSessionAllocation = new JButton("Session Allocation");
		btnSessionAllocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SessionAllocation newWindow = new SessionAllocation();
				try {
					SessionAllocation.main(null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setVisible(false);
			}
		});
		btnSessionAllocation.setForeground(Color.WHITE);
		btnSessionAllocation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSessionAllocation.setBackground(new Color(0, 139, 139));
		btnSessionAllocation.setBounds(10, 228, 230, 57);
		panel.add(btnSessionAllocation);
		
		JLabel lblAddSession = new JLabel("Add Sessions");
		lblAddSession.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblAddSession.setBounds(287, 26, 271, 37);
		frame.getContentPane().add(lblAddSession);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(276, 103, 898, 547);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("Select lecturer", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblSelectLecturer = new JLabel("Select Lecturer 1");
		lblSelectLecturer.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSelectLecturer.setBounds(42, 73, 113, 16);
		panel_1.add(lblSelectLecturer);
		
		cbLecturer = new JComboBox();
		cbLecturer.setModel(new DefaultComboBoxModel(new String[] {"Select"}));
		cbLecturer.setForeground(Color.BLACK);
		cbLecturer.setBackground(Color.WHITE);
		cbLecturer.setBounds(195, 72, 145, 20);
		panel_1.add(cbLecturer);
		
		JLabel lblSelectTag = new JLabel("Select tag");
		lblSelectTag.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSelectTag.setBounds(475, 73, 113, 16);
		panel_1.add(lblSelectTag);
		
		cbTag = new JComboBox();
		cbTag.setModel(new DefaultComboBoxModel(new String[] {"Select"}));
		cbTag.setForeground(Color.BLACK);
		cbTag.setBackground(Color.WHITE);
		cbTag.setBounds(598, 72, 145, 20);
		panel_1.add(cbTag);
		
		JLabel lblSelectedLecturer = new JLabel("Selected Lecturer");
		lblSelectedLecturer.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSelectedLecturer.setBounds(214, 172, 126, 16);
		panel_1.add(lblSelectedLecturer);
		
		tfLecturers = new JTextField();
		tfLecturers.setEditable(false);
		tfLecturers.setColumns(10);
		tfLecturers.setBounds(381, 171, 256, 59);
		panel_1.add(tfLecturers);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBackground(SystemColor.textHighlight);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			cbLecturer.setSelectedIndex(0);
			cbLecturer_1.setSelectedIndex(0);
			cbTag.setSelectedIndex(0);
			tfLecturers.setText("");
			}
		});
		btnClear.setBounds(294, 294, 89, 37);
		panel_1.add(btnClear);
		
		JButton btnNext = new JButton("Next>>");
		btnNext.setBackground(SystemColor.textHighlight);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String lec1=cbLecturer.getSelectedItem().toString();
				String lec2=cbLecturer_1.getSelectedItem().toString();
				
				if(lec1=="Select" && lec2 =="Select") {
					tfLecturers.setText("Select Lecturers");
				}else if(lec2 =="Select") {
					tfLecturers.setText(lec1);
				}else if(lec1 =="Select") {
					tfLecturers.setText(lec2);
				}
				else {
					tfLecturers.setText(lec1+" , " +lec2);
				}
				
				if(cbLecturer.getSelectedIndex()==0) {
					JOptionPane.showMessageDialog(null, "Please Select Lecturer");
				}else if(cbTag.getSelectedIndex()==0) {
					JOptionPane.showMessageDialog(null, "Please Enter Tag!");
				}
					
					
			}
		});
		btnNext.setBounds(499, 294, 89, 37);
		panel_1.add(btnNext);
		
		cbLecturer_1 = new JComboBox();
		cbLecturer_1.setModel(new DefaultComboBoxModel(new String[] {"Select"}));
		cbLecturer_1.setForeground(Color.BLACK);
		cbLecturer_1.setBackground(Color.WHITE);
		cbLecturer_1.setBounds(195, 116, 145, 20);
		panel_1.add(cbLecturer_1);
		
		JLabel lblSelectLecturer_2 = new JLabel("Select Lecturer 2");
		lblSelectLecturer_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSelectLecturer_2.setBounds(42, 117, 113, 16);
		panel_1.add(lblSelectLecturer_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("Select Gropus & Sub Groups", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblSelectGroups = new JLabel("Select groups");
		lblSelectGroups.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSelectGroups.setBounds(85, 92, 116, 28);
		panel_2.add(lblSelectGroups);
		
		JLabel lblSelectSubjects = new JLabel("Select subject");
		lblSelectSubjects.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSelectSubjects.setBounds(85, 186, 116, 28);
		panel_2.add(lblSelectSubjects);
		
		JLabel lblNumberOfSession = new JLabel("Number of students");
		lblNumberOfSession.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNumberOfSession.setBounds(471, 92, 143, 28);
		panel_2.add(lblNumberOfSession);
		
		JLabel lblDuration = new JLabel("Duration");
		lblDuration.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDuration.setBounds(471, 186, 116, 28);
		panel_2.add(lblDuration);
		
		 cbGroups = new JComboBox();
		 cbGroups.setModel(new DefaultComboBoxModel(new String[] {"Select"}));
		cbGroups.setForeground(Color.BLACK);
		cbGroups.setBackground(Color.WHITE);
		cbGroups.setBounds(199, 97, 145, 20);
		panel_2.add(cbGroups);
		
		cbSubjects = new JComboBox();
		cbSubjects.setModel(new DefaultComboBoxModel(new String[] {"Select"}));
		cbSubjects.setForeground(Color.BLACK);
		cbSubjects.setBackground(Color.WHITE);
		cbSubjects.setBounds(199, 191, 145, 20);
		panel_2.add(cbSubjects);
		
		JSpinner spStudents = new JSpinner();
		spStudents.setModel(new SpinnerNumberModel(0, 0, 200, 1));
		spStudents.setBounds(624, 97, 94, 20);
		panel_2.add(spStudents);
		
		JSpinner spHours = new JSpinner();
		spHours.setModel(new SpinnerNumberModel(0, 0, 5, 1));
		spHours.setBounds(624, 191, 94, 20);
		panel_2.add(spHours);
		
		JButton btnClear2 = new JButton("Clear");
		btnClear2.setBackground(SystemColor.textHighlight);
		btnClear2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cbGroups.setSelectedIndex(0);
				cbSubjects.setSelectedIndex(0);
				spStudents.setValue(new Integer(0));
				spHours.setValue(new Integer(0));
			}
		});
		btnClear2.setBounds(319, 327, 89, 37);
		panel_2.add(btnClear2);
		
		JButton btnBack = new JButton("< Back");
		btnBack.setBackground(SystemColor.textHighlight);
		btnBack.setBounds(471, 327, 89, 37);
		panel_2.add(btnBack);
		
		JLabel lblHrs = new JLabel("hrs");
		lblHrs.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHrs.setBounds(728, 186, 33, 28);
		panel_2.add(lblHrs);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBackground(SystemColor.textHighlight);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(cbGroups.getSelectedIndex()==0) {
					JOptionPane.showMessageDialog(null, "Please Select Student Group");
				}else if(cbSubjects.getSelectedIndex()==0) {
					JOptionPane.showMessageDialog(null, "Please Select Subject!");
				}else if(spStudents.getValue().equals(0)) {
					JOptionPane.showMessageDialog(null, "Please Add Number Of Students!");
				}else if(spHours.getValue().equals(0)) {
					JOptionPane.showMessageDialog(null, "Please Add Session Duration!");
				}else {
				
				try {
					 Connection con = DBConnect.connect();
					 
					 	String SubCode = null;
					 	String lec2= null;
						String query2="select subCode from subjects where subName= '"+cbSubjects.getSelectedItem().toString()+"'";
						PreparedStatement pst2=con.prepareStatement(query2);
						ResultSet rs2=pst2.executeQuery();
						while(rs2.next()) {
							SubCode=rs2.getString("subCode");
						
						}
						if(cbLecturer_1.getSelectedItem().toString().equals("Select")) {
							lec2="";
						}else  {
							lec2=cbLecturer_1.getSelectedItem().toString();
						}

					String sessionID=cbLecturer.getSelectedItem().toString()+" "+lec2+" "+cbSubjects.getSelectedItem().toString()+"("+SubCode+") "+cbTag.getSelectedItem().toString()+" "+cbGroups.getSelectedItem().toString()+" "+spStudents.getValue().toString()+"("+spHours.getValue().toString()+")";
					 
					 String query = "INSERT INTO session values(null, '" + cbLecturer.getSelectedItem().toString() + "','" + cbLecturer_1.getSelectedItem().toString() + "','" + SubCode  + "','" +
							 cbSubjects.getSelectedItem().toString() + "','" + cbGroups.getSelectedItem().toString() + "','"+cbTag.getSelectedItem().toString()+"','"+ spStudents.getValue().toString() +"','"+ spHours.getValue().toString() +"','"+ sessionID+"')";
					 
	                  Statement sta = con.createStatement();
	                    int x = sta.executeUpdate(query);
	                   if (x == 0) {
	                        JOptionPane.showMessageDialog(btnSubmit, "This is alredy exist");
	                    } else {
	                        JOptionPane.showMessageDialog(btnSubmit,"Session Details Added Successfully!");
	                    }
	                    con.close();
	                    
	                    cbLecturer_1.setSelectedIndex(0);
	    				cbLecturer.setSelectedIndex(0);
	    				cbTag.setSelectedIndex(0);
	    				cbGroups.setSelectedIndex(0);
	    				cbSubjects.setSelectedIndex(0);
	    				spHours.setValue(new Integer(0));
	    				spStudents.setValue(new Integer(0));
	                    
	                } catch (Exception exception) {
	                    exception.printStackTrace();
	                    
	                }
				}
			}	
		});
		btnSubmit.setBounds(611, 327, 89, 37);
		panel_2.add(btnSubmit);
		
		textField = new JTextField();
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setEditable(false);
		textField.setBounds(199, 144, -3, 22);
		panel_2.add(textField);
		textField.setColumns(10);
	
		getLecturers();
		getTags();
		getGroups();
		getsubjects();
	}
}
