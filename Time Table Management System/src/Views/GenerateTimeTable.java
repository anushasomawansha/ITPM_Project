package Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.MessageFormat;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import DBConnect.DBConnect;
import net.proteanit.sql.DbUtils;
import javax.swing.JTextField;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;



import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;

public class GenerateTimeTable {

	private JFrame frame;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	public JComboBox cbLecturer,cbStudGroup,cbRooms;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenerateTimeTable window = new GenerateTimeTable();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
				cbStudGroup.addItem(groups);
			}
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
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
			}
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}



public void getRooms() {
	try {
		Connection con = DBConnect.connect();
		
		String query="select * from location";
		PreparedStatement pst=con.prepareStatement(query);
		ResultSet rs=pst.executeQuery();
		//comboBox.setModel(DbUtils.resultSetToNestedList(rs));
		//comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Lecturer..."}))
		while(rs.next()) {
			String loc=rs.getString("roomName");
			cbRooms.addItem(loc);
			
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
	public GenerateTimeTable() {
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
				/*try {
					Connection con = DBConnect.connect();
					
				//	String query="select startTime || ' - ' ||endTime AS TIME,sessionSign AS SUBJECT from timeAlloLecture";
					String query="select startTime || ' - ' ||endTime AS TIME,Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday from TimeTable";
					String query2="select startTime || ' - ' ||endTime AS TIME,Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday from TimeTable";
					String query3="select startTime || ' - ' ||endTime AS TIME,Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday from TimeTable";
					
					PreparedStatement pst=con.prepareStatement(query);
					PreparedStatement pst2=con.prepareStatement(query2);
					PreparedStatement pst3=con.prepareStatement(query3);
					
					ResultSet rs=pst.executeQuery();
					ResultSet rs2=pst2.executeQuery();
					ResultSet rs3=pst3.executeQuery();
					
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				}
				catch(Exception e) {
					e.printStackTrace();
				}*/
			}
		});
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 1200, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSessionAllocation = new JLabel("Generate Time Tables");
		lblSessionAllocation.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblSessionAllocation.setBounds(28, 45, 381, 37);
		frame.getContentPane().add(lblSessionAllocation);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(28, 97, 1146, 553);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("Lecturer", null, panel_1, null);
		panel_1.setLayout(null);
		
		cbLecturer = new JComboBox();
		cbLecturer.setModel(new DefaultComboBoxModel(new String[] {"Select"}));
		cbLecturer.setBounds(184, 33, 385, 27);
		cbLecturer.setForeground(Color.BLACK);
		cbLecturer.setBackground(Color.WHITE);
		panel_1.add(cbLecturer);
		
		JLabel lblSession = new JLabel("Select Lecturer");
		lblSession.setBounds(34, 37, 123, 16);
		lblSession.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_1.add(lblSession);
		
		JButton btnAdd = new JButton("Generate");
		btnAdd.setBackground(SystemColor.textHighlight);
		btnAdd.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				try {
					Connection con = DBConnect.connect();
					
					String lec = cbLecturer.getSelectedItem().toString();
				
					String query="select startTime || ' - ' ||endTime AS TIME,Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday from TimeTable where Lec_Name='"+lec+"' group by TIME order by TIME ASC";

					PreparedStatement pst=con.prepareStatement(query);
			
					ResultSet rs=pst.executeQuery();
			
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				
				
			}
		});

		btnAdd.setBounds(625, 29, 97, 37);
		panel_1.add(btnAdd);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 111, 1109, 386);
		panel_1.add(scrollPane);
		
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
		scrollPane.setViewportView(table);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.setBackground(SystemColor.textHighlight);
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{


					MessageFormat header = new MessageFormat("Time Table Management System");
					MessageFormat footer = new MessageFormat("Page{0,number,integer}");
					table.print(JTable.PrintMode.FIT_WIDTH, header, footer);
					}catch(java.awt.print.PrinterException er){
					System.err.format("Cannot print %s%n", er.getMessage());
					}
				
			}
		});
		btnPrint.setBounds(732, 30, 97, 37);
		panel_1.add(btnPrint);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("Student Group", null, panel_2, null);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 123, 1121, 374);
		panel_2.add(scrollPane_1);
		
		table_1 = new JTable() {
			@Override
		       public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		           Component component = super.prepareRenderer(renderer, row, column);
		           int rendererWidth = component.getPreferredSize().width;
		           TableColumn tableColumn = getColumnModel().getColumn(column);
		           tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
		           return component;
		        }
		};
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblSelectStudentGroup = new JLabel("Select Student Group");
		lblSelectStudentGroup.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSelectStudentGroup.setBounds(27, 39, 147, 16);
		panel_2.add(lblSelectStudentGroup);
		
		cbStudGroup = new JComboBox();
		cbStudGroup.setModel(new DefaultComboBoxModel(new String[] {"Select"}));
		cbStudGroup.setForeground(Color.BLACK);
		cbStudGroup.setBackground(Color.WHITE);
		cbStudGroup.setBounds(184, 35, 385, 27);
		panel_2.add(cbStudGroup);
		
		JButton btnAdd_1 = new JButton("Generate");
		btnAdd_1.setBackground(SystemColor.textHighlight);
		btnAdd_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Connection con = DBConnect.connect();
					
					String group = cbStudGroup.getSelectedItem().toString();
					
				
					String query2="select startTime || ' - ' ||endTime AS TIME,Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday from TimeTable where studGroup='"+group+"' group by TIME order by TIME ASC";
			
					PreparedStatement pst2=con.prepareStatement(query2);
				
					ResultSet rs2=pst2.executeQuery();
				
					
					TableColumnModel columnModel = table_1.getColumnModel();
					table_1.setModel(DbUtils.resultSetToTableModel(rs2));
					columnModel.getColumn(0).setPreferredWidth(5);
					columnModel.getColumn(1).setPreferredWidth(200);
					
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnAdd_1.setBounds(625, 31, 97, 37);
		panel_2.add(btnAdd_1);
		
		JButton btnPrint_1 = new JButton("Print");
		btnPrint_1.setBackground(SystemColor.textHighlight);
		btnPrint_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{ 
						MessageFormat header = new MessageFormat("Time Table Management System");
						MessageFormat footer = new MessageFormat("Page{0,number,integer}");
						table.print(JTable.PrintMode.FIT_WIDTH, header, footer);
	            }catch(java.awt.print.PrinterException er){
	                System.err.format("Cannot print %s%n", er.getMessage());
	            }				
			}
		});
		btnPrint_1.setBounds(732, 32, 97, 37);
		panel_2.add(btnPrint_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("Room", null, panel_3, null);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 145, 1121, 356);
		panel_3.add(scrollPane_2);
		
		table_2 = new JTable() {
			
			@Override
		       public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		           Component component = super.prepareRenderer(renderer, row, column);
		           int rendererWidth = component.getPreferredSize().width;
		           TableColumn tableColumn = getColumnModel().getColumn(column);
		           tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
		           return component;
		        }
		};
		scrollPane_2.setViewportView(table_2);
		
		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table_2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		JLabel lblSelectRoom = new JLabel("Select Room");
		lblSelectRoom.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSelectRoom.setBounds(30, 36, 123, 16);
		panel_3.add(lblSelectRoom);
		
		cbRooms = new JComboBox();
		cbRooms.setModel(new DefaultComboBoxModel(new String[] {"Select"}));
		cbRooms.setForeground(Color.BLACK);
		cbRooms.setBackground(Color.WHITE);
		cbRooms.setBounds(180, 32, 385, 27);
		panel_3.add(cbRooms);
		
		JButton btnAdd_2 = new JButton("Generate");
		btnAdd_2.setBackground(SystemColor.textHighlight);
		btnAdd_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Connection con = DBConnect.connect();
					
					String room = cbRooms.getSelectedItem().toString();
				
					String query3="select startTime || ' - ' ||endTime AS TIME,Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday from TimeTable where room = '"+room+"' group by TIME order by TIME ASC";
					
		
					PreparedStatement pst3=con.prepareStatement(query3);
			
					ResultSet rs3=pst3.executeQuery();
				
					table_2.setModel(DbUtils.resultSetToTableModel(rs3));
					
					
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnAdd_2.setBounds(621, 28, 97, 37);
		panel_3.add(btnAdd_2);
		
		JButton btnPrint_2 = new JButton("Print");
		btnPrint_2.setBackground(SystemColor.textHighlight);
		btnPrint_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{


					MessageFormat header = new MessageFormat("Time Table Management System");
					MessageFormat footer = new MessageFormat("Page{0,number,integer}");
					table.print(JTable.PrintMode.FIT_WIDTH, header, footer);
					}catch(java.awt.print.PrinterException er){
					System.err.format("Cannot print %s%n", er.getMessage());
					}
			}
		});
		btnPrint_2.setBounds(728, 29, 97, 37);
		panel_3.add(btnPrint_2);
		
		JButton button = new JButton("< Back");
		button.setFont(new Font("Tahoma", Font.BOLD, 13));
		button.setBounds(10, 11, 89, 30);
		frame.getContentPane().add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DashBoard itm = new DashBoard();
				DashBoard.main(null);
				frame.setVisible(false);
			}
		});
	
		
		getLecturers();
		getGroups();
		getRooms();
		
	}
}
