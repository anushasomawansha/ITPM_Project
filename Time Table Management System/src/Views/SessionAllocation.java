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
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import DBConnect.DBConnect;
import net.proteanit.sql.DbUtils;
import javax.swing.JTextField;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;



import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;

public class SessionAllocation {

	private JFrame frame;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	public JComboBox cbSession1,cbSession2,cbPSession1,cbPSession2,cbNOSession1,cbPDay;
	public JSpinner spStartTime,spDuration;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SessionAllocation window = new SessionAllocation();
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
	public SessionAllocation() {
		initialize();
	}

	public void getSessions() {
		try {
			Connection con = DBConnect.connect();
			
			
			String query="select * from session where Tag='Tutorial'";
			String query2="select * from session where Tag='Lecture'";
			String query3="select * from session";
			
			PreparedStatement pst=con.prepareStatement(query);
			PreparedStatement pst1=con.prepareStatement(query2);
			PreparedStatement pst2=con.prepareStatement(query3);
			
			ResultSet rs=pst.executeQuery();
			ResultSet rs2=pst1.executeQuery();
			ResultSet rs3=pst2.executeQuery();
	
			
			while(rs.next()) {
				String session1=rs.getString("Session_Signature");
				cbSession1.addItem(session1);
			}
			
			while(rs2.next()) {
				String session=rs2.getString("Session_Signature");
				cbSession2.addItem(session);
			}
			
			while(rs3.next()) {
				String session=rs3.getString("Session_Signature");
				cbPSession1.addItem(session);
				cbPSession2.addItem(session);
				cbNOSession1.addItem(session);
				
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
		
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				try {
					Connection con = DBConnect.connect();
					
					String query="select conSessionID AS Session_ID, ConSessionSignature AS ConsecutiveSessionSignature from consecutiveSession";
					String query2="select * from parallel";
					String query3="select * from nonOverlapping";
					
					PreparedStatement pst=con.prepareStatement(query);
					PreparedStatement pst1=con.prepareStatement(query2);
					PreparedStatement pst2=con.prepareStatement(query3);
					
					ResultSet rs=pst.executeQuery();
					ResultSet rs2=pst1.executeQuery();
					ResultSet rs3=pst2.executeQuery();
					
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					table_1.setModel(DbUtils.resultSetToTableModel(rs2));
					table_2.setModel(DbUtils.resultSetToTableModel(rs3));
					
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
		
		JButton btnAddSession = new JButton("Add Session");
		btnAddSession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddSession newWindow = new AddSession();
				try {
					AddSession.main(null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setVisible(false);
			}
		});
		btnAddSession.setForeground(Color.WHITE);
		btnAddSession.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddSession.setBackground(new Color(0, 139, 139));
		btnAddSession.setBounds(10, 103, 230, 57);
		panel.add(btnAddSession);
		
		JButton btnManegeSession = new JButton("Manage Session");
		btnManegeSession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ManageSession newWindow = new ManageSession();
				try {
					ManageSession.main(null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setVisible(false);
			}
		});
		btnManegeSession.setForeground(Color.WHITE);
		btnManegeSession.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnManegeSession.setBackground(new Color(0, 139, 139));
		btnManegeSession.setBounds(10, 165, 230, 57);
		panel.add(btnManegeSession);
		
		JButton btnSessionAllocatin = new JButton("Session Allocatin");
		btnSessionAllocatin.addActionListener(new ActionListener() {
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
		btnSessionAllocatin.setForeground(Color.WHITE);
		btnSessionAllocatin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSessionAllocatin.setBackground(new Color(0, 139, 139));
		btnSessionAllocatin.setBounds(10, 229, 230, 57);
		panel.add(btnSessionAllocatin);
		
		JLabel lblSessionAllocation = new JLabel("Session Allocation");
		lblSessionAllocation.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblSessionAllocation.setBounds(283, 22, 381, 37);
		frame.getContentPane().add(lblSessionAllocation);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(283, 97, 874, 553);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("Consecutive Sessions", null, panel_1, null);
		panel_1.setLayout(null);
		
		cbSession1 = new JComboBox();
		cbSession1.setModel(new DefaultComboBoxModel(new String[] {"Select"}));
		cbSession1.setBounds(158, 26, 315, 31);
		cbSession1.setForeground(Color.BLACK);
		cbSession1.setBackground(Color.WHITE);
		panel_1.add(cbSession1);
		
		JLabel lblSession = new JLabel("Tute Session");
		lblSession.setBounds(12, 37, 97, 16);
		lblSession.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_1.add(lblSession);
		
		cbSession2 = new JComboBox();
		cbSession2.setModel(new DefaultComboBoxModel(new String[] {"Select"}));
		cbSession2.setForeground(Color.BLACK);
		cbSession2.setBackground(Color.WHITE);
		cbSession2.setBounds(158, 81, 315, 25);
		panel_1.add(cbSession2);
		
		JLabel lblSession_1 = new JLabel("Lecture Session");
		lblSession_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSession_1.setBounds(12, 88, 119, 18);
		panel_1.add(lblSession_1);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBackground(SystemColor.textHighlight);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				if(cbSession1.getSelectedItem().toString()=="Select" || cbSession2.getSelectedItem().toString()=="Select") {
					JOptionPane.showMessageDialog(null, "Please Select a Session!");
				}
				else {
				try {
					Connection con = DBConnect.connect();
					
					String sessionId=cbSession1.getSelectedItem().toString();
					String sessionID=cbSession2.getSelectedItem().toString();
					String conSecSessionSign = "("+sessionID+") ("+sessionId+")";
					
					 String query3 = "INSERT INTO consecutiveSession values(null, '" + sessionID + "','" + sessionId + "', '"+conSecSessionSign+"')";
					 
					 Statement sta = con.createStatement();
	                    int x = sta.executeUpdate(query3);
	                   if (x == 0) {
	                        JOptionPane.showMessageDialog(btnAdd, "This is alredy exist");
	                    } else {
	                        JOptionPane.showMessageDialog(btnAdd,"Consecutive Sesssion Details Added Successfully!");
	                    }
	                    
					
	                String query="select conSessionID AS Session_ID, ConSessionSignature AS ConsecutiveSessionSignature from consecutiveSession";
					PreparedStatement pst=con.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					con.close();
					
					cbSession1.setSelectedIndex(0);
					cbSession2.setSelectedIndex(0);

				}
				catch(Exception e) {
					e.printStackTrace();
				}
			
			}
		}
		});
		btnAdd.setBounds(158, 150, 87, 37);
		panel_1.add(btnAdd);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 207, 809, 239);
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
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(table);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("Parallel Sessions", null, panel_2, null);
		panel_2.setLayout(null);
		
		JButton btnPAdd = new JButton("Add");
		btnPAdd.setBackground(SystemColor.textHighlight);
		btnPAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			if(cbPSession1.getSelectedIndex()==0 || cbPSession2.getSelectedIndex()==0) {
				JOptionPane.showMessageDialog(null, "Please Select Session!");
			}else if(cbPDay.getSelectedIndex()==0){
				JOptionPane.showMessageDialog(null, "Please Select Day!");
			}else if(spStartTime.getValue().toString().equals("0")){
				JOptionPane.showMessageDialog(null, "Please Insert Session Start Time!");	
			}else if(spDuration.getValue().toString().equals("0")){
				JOptionPane.showMessageDialog(null, "Please Insert Session Duration!");	
			}else {
			try {
				 Connection con = DBConnect.connect();
				 
				 String sessionId=cbPSession1.getSelectedItem().toString();
					String sessionID=cbPSession2.getSelectedItem().toString();
					String conSecSessionSign = "("+sessionId+") ("+sessionID+")";
				
				String query = "INSERT INTO parallel values(null, '" + cbPSession1.getSelectedItem().toString() + "','" + cbPSession2.getSelectedItem().toString() + "','"+conSecSessionSign+"','" +
						 cbPDay.getSelectedItem().toString() + "','" + spStartTime.getValue().toString() + "','"+spDuration.getValue().toString()+"')";
				
				Statement sta = con.createStatement();
                int x = sta.executeUpdate(query);
               if (x == 0) {
                    JOptionPane.showMessageDialog(btnPAdd, "This is alredy exist");
                } else {
                    JOptionPane.showMessageDialog(btnPAdd,"Subject details successfully added!");
                }
                con.close();
                

				cbPSession1.setSelectedIndex(0);
				cbPSession2.setSelectedIndex(0);
				cbPDay.setSelectedIndex(0);
				spStartTime.setValue(new Integer(0));
				spDuration.setValue(new Integer(0));
		
                
                
			} catch (Exception exception) {
                exception.printStackTrace();
                
			}
			}
			}
		});
		btnPAdd.setBounds(359, 209, 87, 37);
		panel_2.add(btnPAdd);
		
		cbPSession2 = new JComboBox();
		cbPSession2.setModel(new DefaultComboBoxModel(new String[] {"Select"}));
		cbPSession2.setForeground(Color.BLACK);
		cbPSession2.setBackground(Color.WHITE);
		cbPSession2.setBounds(169, 49, 343, 27);
		panel_2.add(cbPSession2);
		
		cbPSession1 = new JComboBox();
		cbPSession1.setModel(new DefaultComboBoxModel(new String[] {"Select"}));
		cbPSession1.setForeground(Color.BLACK);
		cbPSession1.setBackground(Color.WHITE);
		cbPSession1.setBounds(169, 11, 343, 27);
		panel_2.add(cbPSession1);
		
		JLabel label = new JLabel("Session 1");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(21, 12, 97, 16);
		panel_2.add(label);
		
		JLabel label_1 = new JLabel("Session 2");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_1.setBounds(21, 49, 119, 18);
		panel_2.add(label_1);
		
		JLabel lblSelectDay = new JLabel("Select day");
		lblSelectDay.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSelectDay.setBounds(21, 90, 119, 18);
		panel_2.add(lblSelectDay);
		
		cbPDay = new JComboBox();
		cbPDay.setModel(new DefaultComboBoxModel(new String[] {"Select", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"}));
		cbPDay.setForeground(Color.BLACK);
		cbPDay.setBackground(Color.WHITE);
		cbPDay.setBounds(169, 90, 119, 18);
		panel_2.add(cbPDay);
		
		JLabel lblStartingTime = new JLabel("Starting time");
		lblStartingTime.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblStartingTime.setBounds(21, 154, 119, 18);
		panel_2.add(lblStartingTime);
		
		spStartTime = new JSpinner();
		spStartTime.setBounds(138, 148, 84, 24);
		panel_2.add(spStartTime);
		
		spDuration = new JSpinner();
		spDuration.setBounds(372, 148, 84, 27);
		panel_2.add(spDuration);
		
		JLabel lblDuration = new JLabel("Duration");
		lblDuration.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDuration.setBounds(272, 154, 90, 18);
		panel_2.add(lblDuration);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(21, 267, 808, 247);
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
		table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane_1.setViewportView(table_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("Non Overlapping", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel label_2 = new JLabel("Session 1");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_2.setBounds(30, 44, 97, 16);
		panel_3.add(label_2);
		
		cbNOSession1 = new JComboBox();
		cbNOSession1.setModel(new DefaultComboBoxModel(new String[] {"Select"}));
		cbNOSession1.setForeground(Color.BLACK);
		cbNOSession1.setBackground(Color.WHITE);
		cbNOSession1.setBounds(168, 37, 346, 32);
		panel_3.add(cbNOSession1);
		
		JButton btnNOAdd = new JButton("Add");
		btnNOAdd.setBackground(SystemColor.textHighlight);
		btnNOAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(cbNOSession1.getSelectedItem().toString()=="Select") {
					JOptionPane.showMessageDialog(null, "Please Select a Session!");
				}
				else {
				try {
					 Connection con = DBConnect.connect();
					
					String query = "INSERT INTO nonOverlapping values(null, '" + cbNOSession1.getSelectedItem().toString() + "')";
					
					Statement sta = con.createStatement();
	                int x = sta.executeUpdate(query);
	               if (x == 0) {
	                    JOptionPane.showMessageDialog(btnPAdd, "This is alredy exist");
	                } else {
	                    JOptionPane.showMessageDialog(btnPAdd,"Subject details successfully added!");
	                }
	                con.close();
	                
	                cbNOSession1.setSelectedIndex(0);
	                
	                
				} catch (Exception exception) {
	                exception.printStackTrace();
	                
				}
				
			}
		}
		});
		btnNOAdd.setBounds(359, 136, 87, 37);
		panel_3.add(btnNOAdd);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(30, 205, 800, 296);
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
		table_2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane_2.setViewportView(table_2);
		
		getSessions();
	}
}
