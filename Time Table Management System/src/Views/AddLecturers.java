package Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DBConnect.DBConnect;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import javax.swing.border.EmptyBorder;

public class AddLecturers {

	private JFrame frame;
	private JTextField tfLecName;
	private JTextField tfEmpID;
	private JTextField tfRank;
	public JComboBox cbDep,cbFac,cbLevel,cbCenter,cbBilding;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddLecturers window = new AddLecturers();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void getLocation() {
		try {
		Connection con = DBConnect.connect();

		String query="select * from location";
		PreparedStatement pst=con.prepareStatement(query);
		ResultSet rs=pst.executeQuery();
		//comboBox.setModel(DbUtils.resultSetToNestedList(rs));
		//comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Lecturer..."}))
		while(rs.next()) {
		String lec1=rs.getString("buildingName");
		cbBilding.addItem(lec1);
		
		}
		con.close();
		}
		catch(Exception e) {
		e.printStackTrace();
		}
		}


	
	/**
	 * Create the application.
	 */
	public AddLecturers() {
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
		
		JButton btnAddLecturers = new JButton("Add Lecturers");
		btnAddLecturers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAddLecturers.setForeground(Color.WHITE);
		btnAddLecturers.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddLecturers.setBackground(new Color(0, 139, 139));
		btnAddLecturers.setBounds(10, 103, 230, 57);
		panel.add(btnAddLecturers);
		
		JButton btnManageLecturers = new JButton("Manage Lecturers");
		btnManageLecturers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ManageLecturer lec = new ManageLecturer();
				try {
					ManageLecturer.main(null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setVisible(false);
			}
		});
		btnManageLecturers.setForeground(Color.WHITE);
		btnManageLecturers.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnManageLecturers.setBackground(new Color(0, 139, 139));
		btnManageLecturers.setBounds(10, 165, 230, 57);
		panel.add(btnManageLecturers);
		
		JLabel lblAddLecturers = new JLabel("Add Lecturers");
		lblAddLecturers.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblAddLecturers.setBounds(283, 27, 381, 37);
		frame.getContentPane().add(lblAddLecturers);
		
		JLabel lblLecturerName = new JLabel("Lecturer name");
		lblLecturerName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLecturerName.setBounds(283, 103, 116, 28);
		frame.getContentPane().add(lblLecturerName);
		
		JLabel lblEmploy = new JLabel("Employee ID");
		lblEmploy.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEmploy.setBounds(285, 163, 101, 18);
		frame.getContentPane().add(lblEmploy);
		
		JLabel lblFaculty = new JLabel("Faculty");
		lblFaculty.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFaculty.setBounds(283, 229, 116, 28);
		frame.getContentPane().add(lblFaculty);
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDepartment.setBounds(283, 282, 116, 28);
		frame.getContentPane().add(lblDepartment);
		
		JLabel lblLevel = new JLabel("Level");
		lblLevel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLevel.setBounds(283, 341, 172, 18);
		frame.getContentPane().add(lblLevel);
		
		tfLecName = new JTextField();
		tfLecName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfLecName.setBounds(442, 106, 301, 20);
		frame.getContentPane().add(tfLecName);
		tfLecName.setColumns(10);
		
		tfEmpID = new JTextField();
		tfEmpID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfEmpID.setColumns(10);
		tfEmpID.setBounds(442, 162, 138, 20);
		frame.getContentPane().add(tfEmpID);
		
		cbFac = new JComboBox();
		cbFac.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbFac.setModel(new DefaultComboBoxModel(new String[] {"Select",  "Computing","Engineering", "Business Management"}));
		cbFac.setForeground(Color.BLACK);
		cbFac.setBackground(Color.WHITE);
		cbFac.setBounds(442, 232, 145, 20);
		frame.getContentPane().add(cbFac);
		
		cbDep = new JComboBox();
		cbDep.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbDep.setModel(new DefaultComboBoxModel(new String[] {"Select", "SE", "CSE", "CSSE", "IT", "IM"}));
		cbDep.setForeground(Color.BLACK);
		cbDep.setBackground(Color.WHITE);
		cbDep.setBounds(442, 287, 145, 20);
		frame.getContentPane().add(cbDep);
		
		cbLevel = new JComboBox();
		cbLevel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbLevel.setModel(new DefaultComboBoxModel(new String[] {"Select", "Professor", "Assistant Professor", "Senior Lecturer(HG)", "Senior Lecturer", "Lecturer", "Assistant Lecturer"}));
		cbLevel.setForeground(Color.BLACK);
		cbLevel.setBackground(Color.WHITE);
		cbLevel.setBounds(442, 341, 145, 20);
		frame.getContentPane().add(cbLevel);
		
		cbCenter = new JComboBox();
		cbCenter.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbCenter.setModel(new DefaultComboBoxModel(new String[] {"Select", "Malabe", "Kandy", "Matara"}));
		cbCenter.setForeground(Color.BLACK);
		cbCenter.setBackground(Color.WHITE);
		cbCenter.setBounds(929, 234, 145, 20);
		frame.getContentPane().add(cbCenter);
		
		cbBilding = new JComboBox();
		cbBilding.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbBilding.setModel(new DefaultComboBoxModel(new String[] {"Select"}));
		cbBilding.setForeground(Color.BLACK);
		cbBilding.setBackground(Color.WHITE);
		cbBilding.setBounds(929, 287, 145, 20);
		frame.getContentPane().add(cbBilding);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBackground(SystemColor.textHighlight);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tfLecName.setText(null);
				tfEmpID.setText(null);
				cbFac.setSelectedIndex(0);
				cbCenter.setSelectedIndex(0);
				cbDep.setSelectedIndex(0);
				cbBilding.setSelectedIndex(0);
				cbLevel.setSelectedIndex(0);
				tfRank.setText(null);
			}
		});
		btnClear.setBounds(943, 613, 89, 37);
		frame.getContentPane().add(btnClear);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBackground(SystemColor.textHighlight);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String lectureName=tfLecName.getText();
				String EmpID=tfEmpID.getText();
				String Rank=tfRank.getText();
				
				String Faculty=(String) cbFac.getSelectedItem();
				String Department=(String) cbDep.getSelectedItem();
				String Center=(String) cbCenter.getSelectedItem();
				String Building=(String) cbBilding.getSelectedItem();
				String level=(String) cbLevel.getSelectedItem();
			
				

				if(tfLecName.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please Enter Lecture Name!");
				}else if(tfEmpID.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Please Enter Lecture Employee ID!");
				}else if(cbFac.getSelectedIndex()==0){
					JOptionPane.showMessageDialog(null, "Please Enter Faculty!");
				}
				else if(cbDep.getSelectedIndex()==0){
					JOptionPane.showMessageDialog(null, "Please Enter Department!");
				}
				else if(cbCenter.getSelectedIndex()==0){
					JOptionPane.showMessageDialog(null, "Please Enter Center!");
				}
				else if(cbLevel.getSelectedIndex()==0){
					JOptionPane.showMessageDialog(null, "Please Enter Level!");
				}else if(cbBilding.getSelectedIndex()==0){
					JOptionPane.showMessageDialog(null, "Please Enter Building!");
				}else if(tfRank.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Please Enter Rank!");
				}
				else {
				try {
					 Connection con = DBConnect.connect();

	                    String query = "INSERT INTO lecturers values(null, '" + lectureName + "','" + EmpID + "','" + Faculty + "','" +
	                    		Department + "','" + Center + "','" + Building + "','"+ level +"','"+ Rank +"')";
	                  Statement sta = con.createStatement();
	                    int x = sta.executeUpdate(query);
	                   if (x == 0) {
	                        JOptionPane.showMessageDialog(btnSave, "This is alredy exist");
	                    } else {
	                        JOptionPane.showMessageDialog(btnSave,"Lecturer details successfully added!");
	                    }
	                    con.close();
	                    
	                    tfLecName.setText(null);
	    				tfEmpID.setText(null);
	    				cbFac.setSelectedIndex(0);
	    				cbCenter.setSelectedIndex(0);
	    				cbDep.setSelectedIndex(0);
	    				cbBilding.setSelectedIndex(0);
	    				cbLevel.setSelectedIndex(0);
	    				tfRank.setText(null);
	                    
	                    
	                } catch (Exception exception) {
	                    exception.printStackTrace();
	                    
	                }
			}
			}
		});
		btnSave.setBounds(1069, 613, 89, 37);
		frame.getContentPane().add(btnSave);
		
		JLabel lblCenter = new JLabel("Center");
		lblCenter.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCenter.setBounds(758, 229, 67, 28);
		frame.getContentPane().add(lblCenter);
		
		JLabel lblBuilding = new JLabel("Building");
		lblBuilding.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBuilding.setBounds(758, 282, 75, 28);
		frame.getContentPane().add(lblBuilding);
		
		JLabel lblRank = new JLabel("Rank");
		lblRank.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRank.setBounds(758, 331, 75, 28);
		frame.getContentPane().add(lblRank);
		
		tfRank = new JTextField();
		tfRank.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfRank.setEditable(false);
		tfRank.setColumns(10);
		tfRank.setBounds(929, 341, 138, 20);
		frame.getContentPane().add(tfRank);
		
		JButton bntGenID = new JButton("Generate ID");
		bntGenID.setBackground(SystemColor.textHighlight);
		bntGenID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bntGenID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
						try {
							//	capacity =  Integer.parseInt(txtCapacity.getText());
							int cap =Integer.parseInt(tfEmpID.getText().toString());
							
							String level = cbLevel.getSelectedItem().toString();
							
							if(level=="Professor") {
								level = "1";
							}else if(level == "Assistant Professor") {
								level = "2";
							}else if(level == "Senior Lecturer(HG)") {
								level = "3";
							}else if(level == "Senior Lecturer") {
								level = "4";
							}else if(level == "Lecturer") {
								level = "5";
							}else if(level == "Assistant Lecturer") {
								level = "6";
							}
							
							tfRank.setText(level+"."+tfEmpID.getText().toString());
													
							}catch(NumberFormatException nuEx) {
								JOptionPane.showMessageDialog(null, "Can't add String values as EmployeeId");			
								System.out.println("Can't add String values as EmployeeId");
								return ;
							}
						
						
					}
				
				//rankbox.setText(Level.getSelectedItem().toString()+"."+empIdbox.getText().toString());	
			
				
		});
			
		bntGenID.setBounds(939, 397, 119, 37);
		frame.getContentPane().add(bntGenID);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(176, 224, 230));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(729, 318, 429, 138);
		frame.getContentPane().add(lblNewLabel);
		
		 getLocation();
	}
}
