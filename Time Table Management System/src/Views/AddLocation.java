package Views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import DBConnect.DBConnect;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class AddLocation {

	private JFrame frame;
	private JTextField txtBuildingName;
	private JTextField txtRoomName;
	private JTextField txtCapacity;
	private JRadioButton rdbtnLectureHall;
	private JRadioButton rdbtnLab;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddLocation window = new AddLocation();
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
	public AddLocation() {
		initialize();
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
		JButton btnAddSubject = new JButton("Add Location");
		btnAddSubject.setForeground(Color.WHITE);
		btnAddSubject.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddSubject.setBackground(new Color(0, 139, 139));
		btnAddSubject.setBounds(10, 103, 230, 57);
		panel.add(btnAddSubject);
		
		JButton btnManegeSubject = new JButton("Manage Location");
		btnManegeSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ManageLocation itm = new ManageLocation();
				ManageLocation.main(null);
				frame.setVisible(false);
			}
		});
		btnManegeSubject.setForeground(Color.WHITE);
		btnManegeSubject.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnManegeSubject.setBackground(new Color(0, 139, 139));
		btnManegeSubject.setBounds(10, 165, 230, 57);
		panel.add(btnManegeSubject);
		
		JLabel lblAddLocation = new JLabel("Add Location");
		lblAddLocation.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblAddLocation.setBounds(278, 30, 381, 37);
		frame.getContentPane().add(lblAddLocation);
		
		JLabel lblAddRoomsBuilding = new JLabel("Add Rooms Building Wise");
		lblAddRoomsBuilding.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAddRoomsBuilding.setBounds(340, 100, 181, 28);
		frame.getContentPane().add(lblAddRoomsBuilding);
		
		JLabel lblBuidingName = new JLabel("Buiding Name");
		lblBuidingName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBuidingName.setBounds(340, 150, 181, 28);
		frame.getContentPane().add(lblBuidingName);
		
		JLabel lblRoomName = new JLabel("Room Name");
		lblRoomName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRoomName.setBounds(340, 201, 181, 28);
		frame.getContentPane().add(lblRoomName);
		
		JLabel lblRoomType = new JLabel("Room Type");
		lblRoomType.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRoomType.setBounds(340, 249, 181, 28);
		frame.getContentPane().add(lblRoomType);
		
		JLabel lblCapacity = new JLabel("Capacity");
		lblCapacity.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCapacity.setBounds(340, 300, 181, 28);
		frame.getContentPane().add(lblCapacity);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBackground(SystemColor.textHighlight);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				txtBuildingName.setText("");
				txtRoomName.setText("");
				txtCapacity.setText("");
				
			}
		});
		btnClear.setBounds(559, 412, 119, 37);
		frame.getContentPane().add(btnClear);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBackground(SystemColor.textHighlight);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//validations
				
				String bName= txtBuildingName.getText();
				String rName= txtRoomName.getText();
				String cap = txtCapacity.getText();
			//check for null all 
			//check for capacity
			//check for radiobutton
			//run query
				if(txtBuildingName.getText().equals("")||txtRoomName.getText().equals("") ||txtCapacity.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please fill the form");			
				}else {
					//Values to variables
				
					String buildingName = txtBuildingName.getText();
					String roomName = txtRoomName.getText();
					String type = null;
					int capacity =  0;
					
					try {
						capacity =Integer.parseInt(txtCapacity.getText());
					}catch(NumberFormatException ex) {
						//ex.printStackTrace();
						JOptionPane.showMessageDialog(null, "Enter only numbers to capacity");			

					}

					if(capacity > 120 ) {
						capacity = 0;
						JOptionPane.showMessageDialog(null, "Maximum Capacity is 120");			
					}else if(capacity<=0) {
						capacity = 0;
						JOptionPane.showMessageDialog(null, "Capacity Should not be 0. Please enter a valid capacity");		
						
					}else {
						try {
						//	int capacityCheck =  Integer.parseInt(txtCapacity.getText());
												
						}catch(NumberFormatException nuEx) {
							JOptionPane.showMessageDialog(null, "Please enter a number to capacity");			
							System.out.println("Please enter a number to capacity");
							return;
						}
					
						
						//Query to connect db
						try {
							
							 // If condition to check if jRadioButton2 is selected. 
			                if (rdbtnLectureHall.isSelected()) { 
			                	type = "LectureHall";
			                	rdbtnLab.setSelected(false);
			    		    	//rdbtnLectureHall.setSelected(false);
			    				Connection con = DBConnect.connect();


			                    String query = "INSERT INTO location values(null,'" +buildingName + "','" + roomName + "','" + type + "','"+ capacity +"')";
			                    Statement sta = con.createStatement();
			                    sta.executeUpdate(query);
								JOptionPane.showMessageDialog(null, "Data inserted Successfully");		
			                    con.close();
			                } 
			  
			                else if (rdbtnLab.isSelected()) { 
			                    type = "Laboratory"; 
			                    rdbtnLectureHall.setSelected(false);
			                    
			    				Connection con = DBConnect.connect();


			                    String query = "INSERT INTO location values(null,'" +buildingName + "','" + roomName + "','" + type + "','"+ capacity +"')";
			                    Statement sta = con.createStatement();
			                    sta.executeUpdate(query);
								JOptionPane.showMessageDialog(null, "Data inserted Successfully");		
			                    con.close();
			                } 
			                else { 
			                	JOptionPane.showMessageDialog(panel, "Please select a Type", "Warning",JOptionPane.WARNING_MESSAGE);
			                	return;
			                } 
							
			
		                    
						}catch(Exception insertDB) {
							insertDB.printStackTrace();
						}
						
					}			
				}
				
			}
		});
		btnSave.setBounds(721, 412, 119, 37);
		frame.getContentPane().add(btnSave);
		
		 txtBuildingName = new JTextField();
		txtBuildingName.setBounds(515, 153, 144, 22);
		frame.getContentPane().add(txtBuildingName);
		txtBuildingName.setColumns(10);
		
		 txtRoomName = new JTextField();
		txtRoomName.setColumns(10);
		txtRoomName.setBounds(515, 204, 144, 22);
		frame.getContentPane().add(txtRoomName);
		
		 txtCapacity = new JTextField();
		txtCapacity.setColumns(10);
		txtCapacity.setBounds(515, 303, 144, 22);
		frame.getContentPane().add(txtCapacity);
		
		 rdbtnLectureHall = new JRadioButton("Lecture Hall");
		rdbtnLectureHall.setBackground(Color.LIGHT_GRAY);
		rdbtnLectureHall.setBounds(513, 251, 119, 25);
		frame.getContentPane().add(rdbtnLectureHall);
		
		 rdbtnLab = new JRadioButton("Laboratory");
		rdbtnLab.setBackground(Color.LIGHT_GRAY);
		rdbtnLab.setBounds(652, 252, 127, 25);
		frame.getContentPane().add(rdbtnLab);
		
		rdbtnLectureHall.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	rdbtnLab.setSelected(false);
			    }
		});
		
		rdbtnLab.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	rdbtnLectureHall.setSelected(false);
			    }
		});
		
	}

}
