package Views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DBConnect.DBConnect;
import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.SystemColor;

public class ManageLocation {

	private JFrame frame;
	private JTable table;
	private JTextField txtMLBuildingName;
	private JTextField txtMLRoomName;
	private JTextField txtMLCapacity;
	
	private JRadioButton rdbtnMLLectureHall;
	private JRadioButton rdbtnMLLab;
	private JTextField LocID;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageLocation window = new ManageLocation();
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
	public ManageLocation() {
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
					
					String query="select * from location";
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
		
		JButton btnAddSubject = new JButton("Add Location");
		btnAddSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddLocation itm = new AddLocation();
				AddLocation.main(null);
				frame.setVisible(false);
				
			}
		});
		btnAddSubject.setForeground(Color.WHITE);
		btnAddSubject.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddSubject.setBackground(new Color(0, 139, 139));
		btnAddSubject.setBounds(10, 103, 230, 57);
		panel.add(btnAddSubject);
		
		JButton btnManegeSubject = new JButton("Manage Location");
		btnManegeSubject.setForeground(Color.WHITE);
		btnManegeSubject.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnManegeSubject.setBackground(new Color(0, 139, 139));
		btnManegeSubject.setBounds(10, 165, 230, 57);
		panel.add(btnManegeSubject);
		
		JLabel lblManageLocation = new JLabel("Manage Location");
		lblManageLocation.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblManageLocation.setBounds(288, 40, 381, 37);
		frame.getContentPane().add(lblManageLocation);
		
		JLabel lblAddRoomsBuilding = new JLabel("Add Rooms Building Wise");
		lblAddRoomsBuilding.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAddRoomsBuilding.setBounds(375, 358, 181, 28);
		frame.getContentPane().add(lblAddRoomsBuilding);
		
		JLabel lblBuidingName = new JLabel("Buiding Name");
		lblBuidingName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBuidingName.setBounds(375, 425, 181, 28);
		frame.getContentPane().add(lblBuidingName);
		
	    txtMLBuildingName = new JTextField();
		txtMLBuildingName.setColumns(10);
		txtMLBuildingName.setBounds(556, 429, 144, 22);
		frame.getContentPane().add(txtMLBuildingName);
		
		txtMLRoomName = new JTextField();
		txtMLRoomName.setColumns(10);
		txtMLRoomName.setBounds(556, 476, 144, 22);
		frame.getContentPane().add(txtMLRoomName);
		
		JLabel lblRoomName = new JLabel("Room Name");
		lblRoomName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRoomName.setBounds(375, 472, 181, 28);
		frame.getContentPane().add(lblRoomName);
		
		JLabel lblRoomType = new JLabel("Room Type");
		lblRoomType.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRoomType.setBounds(375, 511, 181, 28);
		frame.getContentPane().add(lblRoomType);
		
		 rdbtnMLLectureHall = new JRadioButton("Lecture Hall");
		rdbtnMLLectureHall.setBackground(Color.LIGHT_GRAY);
		rdbtnMLLectureHall.setBounds(556, 514, 100, 25);
		frame.getContentPane().add(rdbtnMLLectureHall);
		
		 rdbtnMLLab = new JRadioButton("Laboratory");
		rdbtnMLLab.setBackground(Color.LIGHT_GRAY);
		rdbtnMLLab.setBounds(721, 514, 127, 25);
		frame.getContentPane().add(rdbtnMLLab);
		
		rdbtnMLLectureHall.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	rdbtnMLLab.setSelected(false);
			    }
		});
		
		rdbtnMLLab.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	rdbtnMLLectureHall.setSelected(false);
			    }
		});
		
		txtMLCapacity = new JTextField();
		txtMLCapacity.setColumns(10);
		txtMLCapacity.setBounds(556, 554, 144, 22);
		frame.getContentPane().add(txtMLCapacity);
		
		JLabel lblCapacity = new JLabel("Capacity");
		lblCapacity.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCapacity.setBounds(375, 550, 181, 28);
		frame.getContentPane().add(lblCapacity);
		
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBackground(SystemColor.textHighlight);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtMLBuildingName.setText("");
				txtMLRoomName.setText("");
				txtMLCapacity.setText("");	
				rdbtnMLLectureHall.setSelected(false);
				rdbtnMLLab.setSelected(false);
				
			}
		});
		btnClear.setBounds(556, 599, 119, 37);
		frame.getContentPane().add(btnClear);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBackground(SystemColor.textHighlight);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*
				 * table selected row to text boxes	
				 *1  all null check	radio
				 *2 else msg, set a flag if radio buttons not selected
				 *3 capacity check separately
				 *4 if flag ==0 update table
				 */
						
						
						
						String bName= txtMLBuildingName.getText();
						String rName= txtMLRoomName.getText();
						int cap = 0;
						//if condition is used to handle the null error when updating 
						if(txtMLCapacity.getText().equals("")) {
							//JOptionPane.showMessageDialog(null, "E");
							System.out.println("Capacity is not entered ");
						}else {
							try {
								//	capacity =  Integer.parseInt(txtCapacity.getText());
								cap =  Integer.parseInt(txtMLCapacity.getText());
														
								}catch(NumberFormatException nuEx) {
									JOptionPane.showMessageDialog(null, "Please enter a number to capacity");			
									System.out.println("Please enter a number to capacity");
									return ;
								}
							
							
						}

						//String cap = txtMLCapacity.getText();
						String type = null;
						int flag = 0;
					
						//Query to select table data
						int i=table.getSelectedRow();
						DefaultTableModel model=(DefaultTableModel)table.getModel();
						
						if(i>=1) {
							model.setValueAt( LocID.getText() , i, 1);
						}
						else {
						//	JOptionPane.showMessageDialog(null, "Error!!!");
						}
						
						
						//1
						if(txtMLBuildingName.getText().equals("")||txtMLRoomName.getText().equals("") ||txtMLCapacity.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Please fill the form");			
						}else {
							
							//check radio buttons
							if (rdbtnMLLectureHall.isSelected()) { 
			                	type = "LectureHall";
			                } 
			  
			                else if (rdbtnMLLab.isSelected()) { 
			                    type = "Laboratory"; 
			                } 
			                else { 
			                	JOptionPane.showMessageDialog(panel, "Please select a Type", "Warning",JOptionPane.WARNING_MESSAGE);
			                	flag =1;
			                } 	
							
							//check capacity
							if(cap > 120 ) {
								cap = 0;
								JOptionPane.showMessageDialog(null, "Maximum Capacity is 120");			
							}else if(cap< 0) {
								cap = 0;
								JOptionPane.showMessageDialog(null, "Capacity Should not be 0. Please enter a valid capacity");		
								
							}else if(flag == 0) {
								//Query to connect db
								try {
									Connection con = DBConnect.connect();

									String query="Update location set buildingName='"+txtMLBuildingName.getText()+"', roomName='"+txtMLRoomName.getText()+"',type='"+type+"',capacity='"+txtMLCapacity.getText()+"' where locationID='"+LocID.getText()+"' ";
									PreparedStatement pst=con.prepareStatement(query);
									pst.executeUpdate();
									JOptionPane.showMessageDialog(null, "Data Updated");
									pst.close();
									
								}
								catch(Exception updateTable) {
									updateTable.printStackTrace();
								}
								
							}//~check capacity
							else {
								
							}
									
						}
				
			}
		});
		btnUpdate.setBounds(703, 599, 119, 37);
		frame.getContentPane().add(btnUpdate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(288, 108, 866, 239);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		
		//Table Selection
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int selectedRow=table.getSelectedRow();		
				LocID.setText(table.getValueAt(selectedRow, 0).toString());
				txtMLBuildingName.setText(table.getValueAt(selectedRow, 1).toString());
				txtMLRoomName.setText(table.getValueAt(selectedRow, 2).toString());
				txtMLCapacity.setText(table.getValueAt(selectedRow, 4).toString());
			
			}
		});
		
		
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"LocationID", "Building Name", "Room Name", "Type", "Capacity"
				}
			) {
				Class[] columnTypes = new Class[] {
					Object.class, Object.class, Object.class, Object.class, Integer.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				boolean[] columnEditables = new boolean[] {
					 false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
		
		scrollPane.setViewportView(table);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(SystemColor.textHighlight);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection con = DBConnect.connect();
					String query="Delete from location where locationID='"+LocID.getText()+"'";
					PreparedStatement pst=con.prepareStatement(query);
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Data Deleted Successfully");
					pst.close();
					
					}
					catch(Exception deleteRecord) {
						deleteRecord.printStackTrace();
						
					}
				
			}
		});
		btnDelete.setBounds(859, 599, 119, 37);
		frame.getContentPane().add(btnDelete);
		
		LocID = new JTextField();
		LocID.setBounds(556, 390, 32, 20);
		frame.getContentPane().add(LocID);
		LocID.setColumns(10);
		
		JLabel lblLocationId = new JLabel("Location ID");
		lblLocationId.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLocationId.setBounds(375, 386, 181, 28);
		frame.getContentPane().add(lblLocationId);
	}
}
