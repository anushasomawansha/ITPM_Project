package Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
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
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

import DBConnect.DBConnect;
import net.proteanit.sql.DbUtils;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.SystemColor;



public class AddSessionRooms {

	private JFrame frame;
	private JRadioButton rdbtnConsecutive; 
	private JRadioButton rdbtnParallelSessions;
	private JRadioButton rdbtnNonOverlapping;
	private JComboBox rooms_1;
	private JComboBox rooms;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddSessionRooms window = new AddSessionRooms();
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
	
	//method to fill comboBox sessions ********
	public void fillComboBox1() {

		try {
					
			
			Connection con = DBConnect.connect();
			
			String query="select * from consecutiveSession";
			PreparedStatement pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			//comboBox.setModel(DbUtils.resultSetToNestedList(rs));
			//comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Lecturer..."}))
			while(rs.next()) {
				String group=rs.getString("ConSessionSignature");
			//	String subgroup=rs.getString("subGroupID");
				
				rooms_1.addItem(group);
			//	comboBox_3.addItem(subgroup);
			}
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}//method
	
	public void fillComboBox2() {

		try {
					
			
			Connection con = DBConnect.connect();
			
			String query="select * from parallel";
			PreparedStatement pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			//comboBox.setModel(DbUtils.resultSetToNestedList(rs));
			//comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Lecturer..."}))
			while(rs.next()) {
				String group=rs.getString("parallelSessionSignature");
			//	String subgroup=rs.getString("subGroupID");
				
				rooms_1.addItem(group);
			//	comboBox_3.addItem(subgroup);
			}
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}//method
	
	public void fillComboBox3() {

		try {
					
			
			Connection con = DBConnect.connect();
			
			String query="select * from nonOverlapping";
			PreparedStatement pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			//comboBox.setModel(DbUtils.resultSetToNestedList(rs));
			//comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Lecturer..."}))
			while(rs.next()) {
				String group=rs.getString("nonOverlappingSignature");
			//	String subgroup=rs.getString("subGroupID");
				
				rooms_1.addItem(group);
			//	comboBox_3.addItem(subgroup);
			}
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}//method

	//method to fill comboCox rooms **********
		public void fillRoom() {

			try {
				Connection con = DBConnect.connect();
				
				String query="select * from location";
				PreparedStatement pst=con.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				//comboBox.setModel(DbUtils.resultSetToNestedList(rs));
				//comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Lecturer..."}))
				while(rs.next()) {
					String group=rs.getString("roomName");
				//	String subgroup=rs.getString("subGroupID");
					
					rooms.addItem(group);
				//	comboBox_3.addItem(subgroup);
				}
				con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}/**/
		}//method
		
	
	
	public AddSessionRooms() {
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
					
					String query="select * from roomSession";
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
		
		JButton btnAddStudentGroup = new JButton("Add Sessions");
		btnAddStudentGroup.setForeground(Color.WHITE);
		btnAddStudentGroup.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddStudentGroup.setBackground(new Color(0, 139, 139));
		btnAddStudentGroup.setBounds(10, 103, 230, 57);
		panel.add(btnAddStudentGroup);
		
		JButton btnManegeStudentGroup = new JButton("Add Locations");
		btnManegeStudentGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddLocation itm = new AddLocation();
				AddLocation.main(null);
				frame.setVisible(false);
			}
		});
		btnManegeStudentGroup.setForeground(Color.WHITE);
		btnManegeStudentGroup.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnManegeStudentGroup.setBackground(new Color(0, 139, 139));
		btnManegeStudentGroup.setBounds(10, 165, 230, 57);
		panel.add(btnManegeStudentGroup);
		
		JLabel lblAdd = new JLabel(" Add Sessions for Rooms");
		lblAdd.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblAdd.setBounds(281, 26, 381, 37);
		frame.getContentPane().add(lblAdd);
		
		JLabel lblAcademicYearSemester = new JLabel("Select Session");
		lblAcademicYearSemester.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAcademicYearSemester.setBounds(292, 99, 172, 18);
		frame.getContentPane().add(lblAcademicYearSemester);
		
		rdbtnConsecutive = new JRadioButton("Consecutive Sessions");
		rdbtnConsecutive.setBounds(571, 98, 153, 23);
		frame.getContentPane().add(rdbtnConsecutive);
		
		rdbtnParallelSessions = new JRadioButton("Parrallel Sessions");
		rdbtnParallelSessions.setBounds(762, 98, 153, 23);
		frame.getContentPane().add(rdbtnParallelSessions);
		
		rdbtnNonOverlapping = new JRadioButton("Non Over-lapping");
		rdbtnNonOverlapping.setBounds(957, 98, 153, 23);
		frame.getContentPane().add(rdbtnNonOverlapping);
		
		rdbtnParallelSessions.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
				rdbtnConsecutive.setSelected(false);
				rdbtnNonOverlapping.setSelected(false);
				System.out.println("Combo2 selexted");
				rooms_1.removeAllItems();
				
				fillComboBox2();
				
			//	rooms_1.setSelectedIndex(0);
		    
			    }
		});
		
		rdbtnNonOverlapping.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
				rdbtnConsecutive.setSelected(false);
		    	rdbtnParallelSessions.setSelected(false);
		    	System.out.println("Combo3 selexted");
				rooms_1.removeAllItems();

				fillComboBox3();
		    }
		});
		
		rdbtnConsecutive.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	rdbtnParallelSessions.setSelected(false);
		    	rdbtnNonOverlapping.setSelected(false);
				System.out.println("Combo1 selexted");
				rooms_1.removeAllItems();

				
				fillComboBox1();
	/*
	 * 			rdbtnConsecutive.addItemListener(evt -> {
	
				    rooms_1.setEnabled(evt.getStateChange() == ItemEvent.SELECTED);
				    
				    try {
						
						
						Connection con = DBConnect.connect();
						
						String query="select * from location";
						PreparedStatement pst=con.prepareStatement(query);
						ResultSet rs=pst.executeQuery();
						//comboBox.setModel(DbUtils.resultSetToNestedList(rs));
						//comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Lecturer..."}))
						while(rs.next()) {
							String group=rs.getString("buildingName");
						//	String subgroup=rs.getString("subGroupID");
							
							rooms_1.addItem(group);
						//	comboBox_3.addItem(subgroup);
						}
						con.close();
					}
					catch(Exception el) {
						el.printStackTrace();
					}
				    
				}); */
		    }
		});
		
		
		JLabel lblAcademicYearSemester_1 = new JLabel("Select Room");
		lblAcademicYearSemester_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAcademicYearSemester_1.setBounds(292, 237, 172, 18);
		frame.getContentPane().add(lblAcademicYearSemester_1);
		
		JLabel lblAcademicYearSemester_2 = new JLabel("Select Session");
		lblAcademicYearSemester_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAcademicYearSemester_2.setBounds(292, 172, 172, 18);
		frame.getContentPane().add(lblAcademicYearSemester_2);
		
		rooms_1 = new JComboBox();
		rooms_1.setModel(new DefaultComboBoxModel(new String[] {"Select Session....."}));
		rooms_1.setBounds(571, 168, 512, 29);
		frame.getContentPane().add(rooms_1);
		
		rooms = new JComboBox();
		rooms.setModel(new DefaultComboBoxModel(new String[] {"Select a Room.."}));
		rooms.setBounds(571, 233, 172, 29);
		frame.getContentPane().add(rooms);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBackground(SystemColor.textHighlight);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				rooms_1.removeAllItems();
				rooms_1.setModel(new DefaultComboBoxModel(new String[] {"Select Session.."}));
				rdbtnConsecutive.setSelected(false);
				rdbtnNonOverlapping.setSelected(false);
        		rdbtnParallelSessions.setSelected(false);

				rooms.setSelectedIndex(0);
			}
		});
		btnClear.setBounds(511, 308, 109, 37);
		frame.getContentPane().add(btnClear);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBackground(SystemColor.textHighlight);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String sessionType = null;
				String session = null;
				String room = null;
				String Combosession = rooms_1.getSelectedItem().toString();
				String Comboroom = rooms.getSelectedItem().toString();
				String sessionSign = Combosession +" " + Comboroom;
				
				System.out.println(sessionSign);
				if(rooms_1.getSelectedItem().toString().equals("") || rooms.getSelectedItem().toString().equals("") || rooms_1.getSelectedItem().toString().equals("Select Session..") ||  rooms.getSelectedItem().toString().equals("Select a Room..") ) {
					JOptionPane.showMessageDialog(null, "Please fill the Data you want to save");			
				}else {
					
					
					 // If condition to check if jRadioButton2 is selected. 
	                if (rdbtnConsecutive.isSelected()) { 
	                	sessionType = "Consecutive";
	                	System.out.println("Session type" + sessionType);
	     
	                	//set the combo box rooms
	                	//check for the no of students in session with room capacity***************
	                	
	                }else if (rdbtnParallelSessions.isSelected()) { 
	                	sessionType = "Parallel"; 
	                
	                	//set the combo box values
	                	//set the combo box rooms
	                	//check for the no of students in session with room capacity***************
	                	
	                } else if (rdbtnNonOverlapping.isSelected()) { 
	                	sessionType = "Non overlapping"; 
	                	
	                	//set the combo box rooms
	                	//check for the no of students in session with room capacity***************
	                } else { 
	                	JOptionPane.showMessageDialog(panel, "Please select a Type", "Warning Select a Session ",JOptionPane.WARNING_MESSAGE);
	                } 
	                
	                //Query
	   /*   */            try {
						 Connection con = DBConnect.connect();
	
		                    String query = "INSERT INTO roomSession values(null, '" + Combosession + "','" + Comboroom + "','"+ sessionSign +"')";
	
		                    Statement sta = con.createStatement();
		                    int x = sta.executeUpdate(query);
		                    if (x == 0) {
		                        JOptionPane.showMessageDialog(btnSave, "This is alredy exist");
		                    } else {
		                        JOptionPane.showMessageDialog(btnSave,
		                            "Successfully added!!!");
		                    }
		                    con.close();
		                } catch (Exception exception) {
		                    exception.printStackTrace();
		                	
		                }     
		
				}//end of check if else
				//check for null combo boxes
                //insert into table use a flag
			}
		});
		btnSave.setBounds(651, 308, 109, 37);
		frame.getContentPane().add(btnSave);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
				/*	Connection con = DBConnect.connect();
					
					String query="select * from roomSession ";
					PreparedStatement pst=con.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					*/
					Connection con = DBConnect.connect();
					String query="Delete from roomSession where sessionRoomID='"+textField.getText()+"'";
					PreparedStatement pst=con.prepareStatement(query);
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Data Deleted Successfully");
					pst.close();
					
				}
				catch(Exception loadTable) {
					loadTable.printStackTrace();
				}
				
			}
		});
		btnDelete.setBounds(857, 613, 109, 37);
		frame.getContentPane().add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(292, 356, 871, 246);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		
		//Table Selection
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int selectedRow=table.getSelectedRow();		
				textField.setText(table.getValueAt(selectedRow, 0).toString());
			
			}
		});
table.setModel(new DefaultTableModel(
		new Object[][] {
		},
		new String[] {
			"SessionRoomID", "Session Sign", "Room ", "Tag"
		}
	) {
		Class[] columnTypes = new Class[] {
			Object.class, Object.class, Object.class, Object.class
		};
		public Class getColumnClass(int columnIndex) {
			return columnTypes[columnIndex];
		}
		boolean[] columnEditables = new boolean[] {
			 false, false, false, false
		};
		public boolean isCellEditable(int row, int column) {
			return columnEditables[column];
		}
	});
		
		scrollPane.setViewportView(table);
		
		textField = new JTextField();
		textField.setForeground(SystemColor.activeCaptionBorder);
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setBounds(292, 621, 6, 1);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		fillRoom();
	}
}
