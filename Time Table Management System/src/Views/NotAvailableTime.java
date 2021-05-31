package Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTabbedPane;

import DBConnect.DBConnect;

import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;
import java.awt.SystemColor;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;

public class NotAvailableTime {

	private JFrame frame;
	private JComboBox comboBox_6;
	private JComboBox comboBox_5;
	private JComboBox comboBox_4;
	private JComboBox comboBox_3;
	private JComboBox comboBox_2;
	private JComboBox comboBox_1;
	private JComboBox comboBox;
	private JSpinner spinner;
	private JSpinner spinner_1;
	private JSpinner spinner_2;
	private JSpinner spinner_3;
	private JSpinner spinner_1_1;
	private JSpinner spinner_1_2;
	private JSpinner sp_start1;
	private JSpinner sp_end1;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NotAvailableTime window = new NotAvailableTime();
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
	public NotAvailableTime() {
		initialize();
	}
	
public void fillComboBox3() {
		
		//AutoCompleteDecrator.decarate(comboBox_4);
		
		try {
			Connection con = DBConnect.connect();
			
			String query="select * from location";
			PreparedStatement pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			//comboBox.setModel(DbUtils.resultSetToNestedList(rs));
			//comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Lecturer..."}))
			while(rs.next()) {
				String room=rs.getString("roomName");
				comboBox_5.addItem(room);
			}
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void fillComboBox2() {
			
            //String temp = String.valueOf(comboBox_4.getSelectedItem());
			//String temp2 = comboBox_4.getSelectedItem().toString();
		String selection=(String)comboBox.getSelectedItem();
		System.out.println(selection);
		
		

			try {
				//String selection=(String)comboBox_4.getSelectedItem();
				
				Connection con = DBConnect.connect();
			
			
			
				String query="select * from roomSession";
				PreparedStatement pst=con.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				//comboBox.setModel(DbUtils.resultSetToNestedList(rs));
				//comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Lecturer..."}))
				while(rs.next()) {
					String sessionSignature=rs.getString("sessionSignRoom");
					comboBox_3.addItem(sessionSignature);
				}
			//comboBox_4 = new JComboBox(options.toArray());

			
			//selection=null;
			con.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
			
		
		
	}
	
	/*public class TimeZoneSpinners {
		Date date = new Date();
		SpinnerDateModel sm = new SpinnerDateModel(date, null, null, Calendar.MINUTE);

		JSpinner spinner = new JSpinner(sm);
		JSpinner.DateEditor de = new JSpinner.DateEditor(spinner, "hh:mm a");
		de.getTextField().setEditable( false );
		spinner.setEditor(de);

		System.out.println("Spinner:      "+de.getFormat().format(spinner.getValue()));
	}*/
	
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
	
	public void fillComboBox1() {
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
		
		JButton btnNewButton = new JButton("Add Not Available Times");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(0, 139, 139));
		btnNewButton.setBounds(10, 103, 230, 57);
		panel.add(btnNewButton);
		
		JButton btnManegeNotAvailable = new JButton("Manage Not Available Times");
		btnManegeNotAvailable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageNotAvailableTime itm = new ManageNotAvailableTime();
				try {
					ManageNotAvailableTime.main(null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setVisible(false);
				
			}
		});
		btnManegeNotAvailable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnManegeNotAvailable.setForeground(Color.WHITE);
		btnManegeNotAvailable.setBackground(new Color(0, 139, 139));
		btnManegeNotAvailable.setBounds(10, 165, 230, 57);
		panel.add(btnManegeNotAvailable);
		
		JLabel lblNotAvailableTimes = new JLabel("Not Available Times");
		lblNotAvailableTimes.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNotAvailableTimes.setBounds(276, 26, 381, 37);
		frame.getContentPane().add(lblNotAvailableTimes);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(249, 74, 935, 587);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("Lecutres,Groups & Sub groups & Location", null, panel_1, null);
		panel_1.setLayout(null);
		
		 comboBox = new JComboBox();
		 comboBox.setModel(new DefaultComboBoxModel(new String[] {"SELECT"}));
		comboBox.setForeground(Color.BLACK);
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(154, 75, 151, 20);
		panel_1.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Select Lecturer");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 77, 116, 14);
		panel_1.add(lblNewLabel);
		
		JLabel lblSelectGroup = new JLabel("Select Group");
		lblSelectGroup.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSelectGroup.setBounds(10, 144, 116, 14);
		panel_1.add(lblSelectGroup);
		
		JLabel lblSelectSubGroup = new JLabel("Select sub Group");
		lblSelectSubGroup.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSelectSubGroup.setBounds(10, 207, 116, 14);
		panel_1.add(lblSelectSubGroup);
		
		JLabel lblSelectSessionId = new JLabel("Select session ID");
		lblSelectSessionId.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSelectSessionId.setBounds(10, 271, 116, 14);
		panel_1.add(lblSelectSessionId);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"SELECT"}));
		comboBox_1.setForeground(Color.BLACK);
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setBounds(154, 142, 151, 20);
		panel_1.add(comboBox_1);
		
	    comboBox_2 = new JComboBox();
	    comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"SELECT"}));
		comboBox_2.setForeground(Color.BLACK);
		comboBox_2.setBackground(Color.WHITE);
		comboBox_2.setBounds(154, 205, 151, 20);
		panel_1.add(comboBox_2);
		
		comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"SELECT"}));
		comboBox_3.setForeground(Color.BLACK);
		comboBox_3.setBackground(Color.WHITE);
		comboBox_3.setBounds(154, 269, 559, 26);
		panel_1.add(comboBox_3);
		
		JLabel label = new JLabel("Select room");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(420, 77, 87, 14);
		panel_1.add(label);
		
		comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"SELECT"}));
		comboBox_5.setBounds(517, 75, 143, 20);
		panel_1.add(comboBox_5);
		
		JLabel label_1 = new JLabel("Select Day");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_1.setBounds(680, 77, 87, 14);
		panel_1.add(label_1);
		
		comboBox_6 = new JComboBox();
		comboBox_6.setModel(new DefaultComboBoxModel(new String[] {"SELECT", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY"}));
		comboBox_6.setBounds(777, 75, 143, 20);
		panel_1.add(comboBox_6);
		
		JLabel label_2 = new JLabel("Start time");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_2.setBounds(420, 144, 72, 14);
		panel_1.add(label_2);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, 0, 9, 1));
		spinner.setBounds(590, 142, 55, 20);
		panel_1.add(spinner);
		
		JLabel label_3 = new JLabel("hrs");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_3.setBounds(659, 144, 27, 14);
		panel_1.add(label_3);
		
		spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(0, 0, 5, 1));
	
		spinner_1.setBounds(730, 142, 55, 20);
		panel_1.add(spinner_1);
		
		
		JLabel label_4 = new JLabel("mins");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_4.setBounds(893, 144, 27, 14);
		panel_1.add(label_4);
		
		JLabel label_5 = new JLabel("End time");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_5.setBounds(420, 207, 55, 14);
		panel_1.add(label_5);
		
		spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(0, 0, 9, 1));
		spinner_2.setBounds(590, 205, 55, 20);
		panel_1.add(spinner_2);
		
		JLabel label_6 = new JLabel("hrs");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_6.setBounds(659, 207, 27, 14);
		panel_1.add(label_6);
		
		spinner_3 = new JSpinner();
		spinner_3.setModel(new SpinnerNumberModel(0, 0, 5, 1));
		spinner_3.setBounds(730, 205, 55, 20);
		panel_1.add(spinner_3);
		
		JLabel label_7 = new JLabel("mins");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_7.setBounds(893, 207, 27, 14);
		panel_1.add(label_7);
		
		JButton button_1 = new JButton("Add Session");
		button_1.setBackground(SystemColor.textHighlight);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		
					String lecname= comboBox.getSelectedItem().toString();
					String group= comboBox_1.getSelectedItem().toString();
					String subgroup= comboBox_2.getSelectedItem().toString();
					String signature= comboBox_3.getSelectedItem().toString();
					System.out.println(signature);
					String day= comboBox_6.getSelectedItem().toString();
					String room= comboBox_5.getSelectedItem().toString();
					String starttime= sp_start1.getValue().toString()+spinner.getValue().toString()+":"+spinner_1.getValue().toString()+spinner_1_1.getValue().toString();
					String endtime= sp_end1.getValue().toString()+spinner_2.getValue().toString()+":"+spinner_3.getValue().toString()+spinner_1_2.getValue().toString();
					if(comboBox_6.getSelectedItem().equals("SELECT")) {
						day="--";
						}
						else if(comboBox_6.getSelectedItem().equals("MONDAY")) {
						day="Monday";
						}else if(comboBox_6.getSelectedItem().equals("TUESDAY")) {
						day="Tuesday";
						}else if(comboBox_6.getSelectedItem().equals("WEDNESDAY")) {
						day="Wednesday";
						}else if(comboBox_6.getSelectedItem().equals("THURSDAY")) {
						day="Thursday";
						}else if(comboBox_6.getSelectedItem().equals("FRIDAY")) {
						day="Friday";
						}else if(comboBox_6.getSelectedItem().equals("SATURDAY")) {
						day="Saturday";
						}else if(comboBox_6.getSelectedItem().equals("SUNDAY")) {
						day="Sunday";
						}
					
					if(comboBox.getSelectedItem().equals("SELECT")) {
						JOptionPane.showMessageDialog(null, "Please Select Lecturer!!!");
					}
					
					else if(comboBox_1.getSelectedItem().equals("SELECT")) {
						JOptionPane.showMessageDialog(null, "Please Select Group!!!");
					}
					else if(comboBox_2.getSelectedItem().equals("SELECT")) {
						JOptionPane.showMessageDialog(null, "Please Select Sub Group!!!");
					}
					else if(comboBox_3.getSelectedItem().equals("SELECT")) {
						JOptionPane.showMessageDialog(null, "Please Select Session Signatue!!!");
					}
					else if(comboBox_6.getSelectedItem().equals("SELECT")) {
						JOptionPane.showMessageDialog(null, "Please Select Day!!!");
					}
					else if(comboBox_5.getSelectedItem().equals("SELECT")) {
						JOptionPane.showMessageDialog(null, "Please Select Room!!!");
					}
	
					
					else {
					try {
						 Connection con = DBConnect.connect();

		                    String query = "INSERT INTO timeAlloLecture values(null, '" + lecname + "','" + group + "','" + subgroup + "','" +
		                    		signature + "','" + day + "','" + starttime + "','"+ endtime +"','"+ room +"')";

		                    String query1="INSERT INTO TimeTable (id,startTime,'"+day+"',Lec_Name,endTime,studGroup,room)values (null,'"+starttime+"' ,'"+signature+"','"+lecname+"','"+endtime+"','"+subgroup+"','"+room+"')";
		                    Statement sta1 = con.createStatement();
		                    sta1.executeUpdate(query1);
		                    Statement sta = con.createStatement();
		                    int x = sta.executeUpdate(query);
		                    if (x == 0) {
		                        JOptionPane.showMessageDialog(button_1, "This is alredy exist");
		                    } else {
		                        JOptionPane.showMessageDialog(button_1,
		                            "Successfully added!!!");
		                    }
		                    con.close();
		                } catch (Exception exception) {
		                    exception.printStackTrace();
		                	
		                }
				}
					
				}
			
	
		});
		button_1.setBounds(727, 405, 109, 37);
		panel_1.add(button_1);
		
		JButton button_2 = new JButton("Clear");
		button_2.setBackground(SystemColor.textHighlight);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//private Object comboBox;

				
					comboBox.setSelectedIndex(0);
					comboBox_6.setSelectedIndex(0);
					comboBox_2.setSelectedIndex(0);
					comboBox_3.setSelectedIndex(0);
					comboBox_1.setSelectedIndex(0);
					comboBox_5.setSelectedIndex(0);
					 spinner.setValue(0);
					 spinner_1.setValue(0);
					 spinner_2.setValue(0);
					 spinner_3.setValue(0);
					//spinner.setValue(((SpinnerNumberModel) spinner.getModel()));
				}
				
			
		});
		button_2.setBounds(570, 405, 89, 37);
		panel_1.add(button_2);
		
		 spinner_1_1 = new JSpinner();
		spinner_1_1.setModel(new SpinnerNumberModel(0, 0, 9, 1));
		spinner_1_1.setBounds(811, 142, 55, 20);
		panel_1.add(spinner_1_1);
		
		 spinner_1_2 = new JSpinner();
		spinner_1_2.setModel(new SpinnerNumberModel(0, 0, 9, 1));
		spinner_1_2.setBounds(812, 205, 55, 20);
		panel_1.add(spinner_1_2);
		
		 sp_start1 = new JSpinner();
		sp_start1.setModel(new SpinnerNumberModel(0, 0, 2, 1));
		sp_start1.setBounds(525, 142, 55, 20);
		panel_1.add(sp_start1);
		
		 sp_end1 = new JSpinner();
		sp_end1.setModel(new SpinnerNumberModel(0, 0, 2, 1));
		sp_end1.setBounds(525, 205, 55, 20);
		panel_1.add(sp_end1);
		

		fillComboBox();
		fillComboBox1();
		fillComboBox2();
		fillComboBox3();
	}
}
