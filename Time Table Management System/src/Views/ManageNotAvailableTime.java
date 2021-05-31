package Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import DBConnect.DBConnect;
import net.proteanit.sql.DbUtils;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.SystemColor;

public class ManageNotAvailableTime {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JComboBox comboBox_1;
	private JComboBox comboBox;
	private JComboBox comboBox_2;
	private JComboBox comboBox_3;
	private JComboBox comboBox_4;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageNotAvailableTime window = new ManageNotAvailableTime();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public void fillComboBox_2() {
		try {
			Connection con = DBConnect.connect();
			
			String query="select * from studentGroups";
			PreparedStatement pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			//comboBox.setModel(DbUtils.resultSetToNestedList(rs));
			//comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Lecturer..."}))
			while(rs.next()) {
				String group=rs.getString("groupID");
				String subgroup=rs.getString("subGroupID");
				
				comboBox_1.addItem(group);
				comboBox_2.addItem(subgroup);
			}
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void fillComboBox() {
		try {
			Connection con = DBConnect.connect();
			
			String query="select * from lecturers";
			PreparedStatement pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			//comboBox.setModel(DbUtils.resultSetToNestedList(rs));
			//comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Lecturer..."}))
			while(rs.next()) {
				String name=rs.getString("lectureName");
				comboBox.addItem(name);
			}
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void fillComboBox_4() {
		try {
			Connection con = DBConnect.connect();
			
			String query="select * from location";
			PreparedStatement pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			//comboBox.setModel(DbUtils.resultSetToNestedList(rs));
			//comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Lecturer..."}))
			while(rs.next()) {
				String room=rs.getString("roomName");
				comboBox_4.addItem(room);
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
	public ManageNotAvailableTime() {
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
					
					String query="select * from timeAlloLecture ";
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
		
		JButton button_1 = new JButton("Add Not Available Times");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NotAvailableTime itm = new NotAvailableTime();
				try {
					NotAvailableTime.main(null);
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
		
		JButton btnManageNotAvailable = new JButton("Manage Not Available Times");
		btnManageNotAvailable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnManageNotAvailable.setForeground(Color.WHITE);
		btnManageNotAvailable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnManageNotAvailable.setBackground(new Color(0, 139, 139));
		btnManageNotAvailable.setBounds(10, 165, 230, 57);
		panel.add(btnManageNotAvailable);
		
		JLabel lblManegeNotAvailable = new JLabel("Manage Not Available Times");
		lblManegeNotAvailable.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblManegeNotAvailable.setBounds(281, 25, 381, 37);
		frame.getContentPane().add(lblManegeNotAvailable);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(281, 92, 865, 228);
		frame.getContentPane().add(scrollPane);
		
		
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
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				  int selectedRow=table.getSelectedRow();
	                DefaultTableModel model=(DefaultTableModel)table.getModel();
					
	                textField.setText(table.getValueAt(selectedRow, 0).toString());
	                //textField_5.setText(table.getValueAt(selectedRow, 1).toString());
	                //comboBox.setName(model.getValueAt(selectedRow, 2).toString());
	                
	               /* String combolevel1 = table.getValueAt(selectedRow, 2).toString();
	      		  for(int j=0;j<comboBox.getItemCount();j++) {
	      		  
	      		  if(comboBox.getItemAt(j).toString().equalsIgnoreCase(combolevel1)) {
	      		  comboBox.setSelectedIndex(j); } }*/
	                
	               
	      		  
	                //textField_7.setText(table.getValueAt(selectedRow, 3).toString());
	                textField_1.setText(table.getValueAt(selectedRow, 4).toString());
	               // textField_9.setText(table.getValueAt(selectedRow, 5).toString());
	                textField_2.setText(table.getValueAt(selectedRow, 6).toString());
	                textField_3.setText(table.getValueAt(selectedRow, 7).toString());
	                //textField_6.setText(table.getValueAt(selectedRow, 8).toString());
	                
	                
	                String comboLevel1 = table.getValueAt(selectedRow, 2).toString();
					for(int i=0; i<comboBox_1.getItemCount();i++) {
						if(comboBox_1.getItemAt(i).toString().equalsIgnoreCase(comboLevel1)) {
							
							
							comboBox_1.setSelectedIndex(i);
						}
					}
					
					String comboLevel2 = table.getValueAt(selectedRow, 5).toString();
					for(int i=0; i<comboBox_3.getItemCount();i++) {
						if(comboBox_3.getItemAt(i).toString().equalsIgnoreCase(comboLevel2)) {
							
							
							comboBox_3.setSelectedIndex(i);
						}
					}
					
					String comboLevel3 = table.getValueAt(selectedRow, 8).toString();
					for(int i=0; i<comboBox_4.getItemCount();i++) {
						if(comboBox_4.getItemAt(i).toString().equalsIgnoreCase(comboLevel3)) {
							
							
							comboBox_4.setSelectedIndex(i);
						}
					}
					
					String comboLevel4 = table.getValueAt(selectedRow, 3).toString();
					for(int i=0; i<comboBox_2.getItemCount();i++) {
						if(comboBox_2.getItemAt(i).toString().equalsIgnoreCase(comboLevel4)) {
							
							
							comboBox_2.setSelectedIndex(i);
						}
					}
					
					String comboLevel5 = table.getValueAt(selectedRow, 1).toString();
					for(int i=0; i<comboBox.getItemCount();i++) {
						if(comboBox.getItemAt(i).toString().equalsIgnoreCase(comboLevel5)) {
							
							
							comboBox.setSelectedIndex(i);
						}
					}
			}
		});
		
		
		
		scrollPane.setViewportView(table);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(424, 362, 145, 20);
		frame.getContentPane().add(textField);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"SELECT"}));
		comboBox.setForeground(Color.BLACK);
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(424, 404, 145, 20);
		frame.getContentPane().add(comboBox);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"SELECT"}));
		comboBox_1.setForeground(Color.BLACK);
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setBounds(424, 451, 145, 20);
		frame.getContentPane().add(comboBox_1);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"SELECT"}));
		comboBox_2.setForeground(Color.BLACK);
		comboBox_2.setBackground(Color.WHITE);
		comboBox_2.setBounds(424, 501, 145, 20);
		frame.getContentPane().add(comboBox_2);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(424, 545, 291, 20);
		frame.getContentPane().add(textField_1);
		
		comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"SELECT", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY"}));
		comboBox_3.setForeground(Color.BLACK);
		comboBox_3.setBackground(Color.WHITE);
		comboBox_3.setBounds(938, 362, 145, 20);
		frame.getContentPane().add(comboBox_3);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(938, 404, 145, 20);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(938, 451, 145, 20);
		frame.getContentPane().add(textField_3);
		
		comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"SELECT"}));
		comboBox_4.setForeground(Color.BLACK);
		comboBox_4.setBackground(Color.WHITE);
		comboBox_4.setBounds(938, 501, 145, 20);
		frame.getContentPane().add(comboBox_4);
		
		JButton button_3 = new JButton("Clear");
		button_3.setBackground(SystemColor.textHighlight);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				comboBox_2.setSelectedIndex(0);
				comboBox_3.setSelectedIndex(0);
				comboBox_1.setSelectedIndex(0);
				comboBox_4.setSelectedIndex(0);
				comboBox.setSelectedIndex(0);
			}
		});
		button_3.setBounds(689, 596, 89, 37);
		frame.getContentPane().add(button_3);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(SystemColor.textHighlight);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(textField.getText().isEmpty()) {
					
					JOptionPane.showMessageDialog(null, "No data to be deleted");
				}
				else {
				
				
				try {
					Connection con = DBConnect.connect();
					String query="Delete from timeAlloLecture where lectimeAllID='"+textField.getText()+"'";
					PreparedStatement pst=con.prepareStatement(query);
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Data Deleted");
					pst.close();
					
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					comboBox_2.setSelectedIndex(0);
					comboBox.setSelectedIndex(0);
					comboBox_4.setSelectedIndex(0);
					comboBox_1.setSelectedIndex(0);
					comboBox_3.setSelectedIndex(0);
					
					}
					catch(Exception e1) {
						e1.printStackTrace();
						
					}
			}}
		});
		btnDelete.setBounds(1008, 596, 89, 37);
		frame.getContentPane().add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBackground(SystemColor.textHighlight);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(( comboBox).getSelectedItem().equals("SELECT")) {
					JOptionPane.showMessageDialog(null, "Please Select Lecturer!!!");
				}
				
				else if(comboBox_1.getSelectedItem().equals("SELECT")) {
					JOptionPane.showMessageDialog(null, "Please Select Group!!!");
				}
				else if(comboBox_2.getSelectedItem().equals("SELECT")) {
					JOptionPane.showMessageDialog(null, "Please Select Sub Group!!!");
				}
				/*else if(comboBox_4.getSelectedItem().equals("Select Session Signature...")) {
					JOptionPane.showMessageDialog(null, "Please Select Session Signatue!!!");
				}*/
				else if(comboBox_3.getSelectedItem().equals("SELECT")) {
					JOptionPane.showMessageDialog(null, "Please Select Day!!!");
				}
				else if(comboBox_4.getSelectedItem().equals("SELECT")) {
					JOptionPane.showMessageDialog(null, "Please Select Room!!!");
				}
				/*else if(spinner.getValue().equals(0)) {
					JOptionPane.showMessageDialog(null, "Please Select start Time !!!");
				}
                else if(spinner_2.getValue().equals(0)) {
					JOptionPane.showMessageDialog(null, "Please Select End Time!!!");
				}*/
				
				else {
				
				
				try {
					Connection con = DBConnect.connect();
					
					String query="Update timeAlloLecture set lecName='"+comboBox.getSelectedItem()+"',subGroup='"+comboBox_1.getSelectedItem()+"',sessionSign='"+textField_1.getText()+"',day='"+comboBox_3.getSelectedItem()+"',startTime='"+textField_2.getText()+"',endTime='"+textField_3.getText()+"',room='"+comboBox_4.getSelectedItem()+"'where lectimeAllID='"+textField.getText()+"' ";
					PreparedStatement pst=con.prepareStatement(query);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Data Updated");
					pst.close();
					
					
				}
				catch(Exception e1) {
					e1.printStackTrace();
				}
			}
			}
		});
		btnUpdate.setBounds(850, 596, 89, 37);
		frame.getContentPane().add(btnUpdate);
		
		JLabel lblLectimealloid = new JLabel("LecTimeAlloID");
		lblLectimealloid.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLectimealloid.setBounds(275, 354, 116, 28);
		frame.getContentPane().add(lblLectimealloid);
		
		JLabel label_1 = new JLabel("Lecturer name");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_1.setBounds(275, 396, 116, 28);
		frame.getContentPane().add(label_1);
		
		JLabel lblGroup = new JLabel("Group");
		lblGroup.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblGroup.setBounds(275, 443, 116, 28);
		frame.getContentPane().add(lblGroup);
		
		JLabel lblSubgroup = new JLabel("SubGroup");
		lblSubgroup.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSubgroup.setBounds(275, 493, 116, 28);
		frame.getContentPane().add(lblSubgroup);
		
		JLabel lblSessionId = new JLabel("Session ID");
		lblSessionId.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSessionId.setBounds(275, 537, 116, 28);
		frame.getContentPane().add(lblSessionId);
		
		JLabel lblDay = new JLabel("Day");
		lblDay.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDay.setBounds(778, 357, 116, 28);
		frame.getContentPane().add(lblDay);
		
		JLabel lblStartTime = new JLabel("Start Time");
		lblStartTime.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblStartTime.setBounds(778, 404, 116, 28);
		frame.getContentPane().add(lblStartTime);
		
		JLabel lblEndtime = new JLabel("EndTime");
		lblEndtime.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEndtime.setBounds(778, 451, 116, 28);
		frame.getContentPane().add(lblEndtime);
		
		JLabel lblRoom = new JLabel("Room");
		lblRoom.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRoom.setBounds(778, 493, 116, 28);
		frame.getContentPane().add(lblRoom);
		
		
		fillComboBox_2();
		fillComboBox();
		fillComboBox_4();
	}
}
