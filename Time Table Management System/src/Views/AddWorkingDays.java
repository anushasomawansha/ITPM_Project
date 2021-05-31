package Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import DBConnect.DBConnect;
import java.awt.SystemColor;

public class AddWorkingDays {

	private JFrame frame;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnTuseday;
	private JRadioButton rdbtnWensday;
	private JRadioButton rdbtnThursday;
	private JRadioButton rdbtnFriday;
	private JRadioButton rdbtnSturday;
	private JRadioButton rdbtnSunday;
	private JSpinner spinner_2;
	private JSpinner spinner;
	private JSpinner spinner_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddWorkingDays window = new AddWorkingDays();
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
	public AddWorkingDays() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 17));
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setForeground(Color.GRAY);
		frame.setBounds(100, 100, 1200, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 139, 139));
		panel.setForeground(Color.WHITE);
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
		
		JButton btnAddWorkingDays = new JButton("Add Working Days");
		btnAddWorkingDays.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		btnAddWorkingDays.setForeground(Color.WHITE);
		btnAddWorkingDays.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddWorkingDays.setBackground(new Color(0, 139, 139));
		btnAddWorkingDays.setBounds(10, 106, 230, 57);
		panel.add(btnAddWorkingDays);
		
		JButton btnManegeWorkingDays = new JButton("Manage Working Days");
		btnManegeWorkingDays.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageWorkingDays itm = new ManageWorkingDays();
				try {
					ManageWorkingDays.main(null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setVisible(false);
			}
		});
		btnManegeWorkingDays.setForeground(Color.WHITE);
		btnManegeWorkingDays.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnManegeWorkingDays.setBackground(new Color(0, 139, 139));
		btnManegeWorkingDays.setBounds(10, 168, 230, 57);
		panel.add(btnManegeWorkingDays);
		
		JLabel lblNewLabel = new JLabel("Add Working Days & Hours");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel.setBounds(299, 37, 381, 37);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Working Days");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(284, 292, 117, 21);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Working Hours Per Day");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(284, 440, 203, 24);
		frame.getContentPane().add(lblNewLabel_2);
		
		rdbtnNewRadioButton = new JRadioButton("Monday");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnNewRadioButton.setBackground(Color.LIGHT_GRAY);
		rdbtnNewRadioButton.setForeground(Color.BLACK);
		rdbtnNewRadioButton.setBounds(483, 293, 96, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		rdbtnTuseday = new JRadioButton("Tuesday");
		rdbtnTuseday.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnTuseday.setBackground(Color.LIGHT_GRAY);
		rdbtnTuseday.setBounds(581, 293, 91, 23);
		frame.getContentPane().add(rdbtnTuseday);
		
		rdbtnWensday = new JRadioButton("Wednesday");
		rdbtnWensday.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnWensday.setBackground(Color.LIGHT_GRAY);
		rdbtnWensday.setBounds(678, 293, 109, 23);
		frame.getContentPane().add(rdbtnWensday);
		
		rdbtnThursday = new JRadioButton("Thursday");
		rdbtnThursday.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnThursday.setBackground(Color.LIGHT_GRAY);
		rdbtnThursday.setBounds(789, 293, 91, 23);
		frame.getContentPane().add(rdbtnThursday);
		
		rdbtnFriday = new JRadioButton("Friday");
		rdbtnFriday.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnFriday.setBackground(Color.LIGHT_GRAY);
		rdbtnFriday.setBounds(889, 293, 109, 23);
		frame.getContentPane().add(rdbtnFriday);
		
		rdbtnSturday = new JRadioButton("Saturday");
		rdbtnSturday.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnSturday.setBackground(Color.LIGHT_GRAY);
		rdbtnSturday.setBounds(483, 349, 91, 23);
		frame.getContentPane().add(rdbtnSturday);
		
		rdbtnSunday = new JRadioButton("Sunday");
		rdbtnSunday.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnSunday.setBackground(Color.LIGHT_GRAY);
		rdbtnSunday.setBounds(581, 349, 109, 23);
		frame.getContentPane().add(rdbtnSunday);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		spinner.setBounds(509, 439, 71, 30);
		frame.getContentPane().add(spinner);
		
		spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		spinner_1.setBounds(652, 439, 71, 30);
		frame.getContentPane().add(spinner_1);
		
		JLabel lblNewLabel_3 = new JLabel("Hours");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(590, 451, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblMinutes = new JLabel("Mins");
		lblMinutes.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMinutes.setBounds(733, 447, 46, 14);
		frame.getContentPane().add(lblMinutes);
		
		JButton btnNewButton_1 = new JButton("Clear");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 spinner_2.setValue(0);
				 spinner.setValue(0);
				 spinner_1.setValue(0);
				 rdbtnNewRadioButton.setSelected(false);
				 rdbtnTuseday.setSelected(false);
				 rdbtnWensday.setSelected(false);
				 rdbtnThursday.setSelected(false);
				 rdbtnFriday.setSelected(false);
				 rdbtnSturday.setSelected(false);
				 rdbtnSunday.setSelected(false);
				
			}
		});
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBackground(SystemColor.textHighlight);
		btnNewButton_1.setBounds(671, 544, 89, 37);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String noOfWorkingDays= spinner_2.getValue().toString();
				String hours= spinner.getValue().toString();
				String minutes= spinner_1.getValue().toString();
				
				String monday="-";
				String tuesday="-";
				String wednesday="-";
				String thursday="-";
				String friday="-";
				String saturday="-";
				String sunday="-";
				
				
				if(rdbtnNewRadioButton.isSelected()) {
					monday="Monday";
				}
				if(rdbtnTuseday.isSelected()) {
					tuesday="Tuesday";
				}
				if(rdbtnWensday.isSelected()) {
					wednesday="Wednesday";
				}
				if(rdbtnThursday.isSelected()) {
					thursday="Thursday";
				}
				if(rdbtnFriday.isSelected()) {
					friday="Friday";
				}
				if(rdbtnSturday.isSelected()) {
					saturday="Saturday";
				}
				if(rdbtnSunday.isSelected()) {
					sunday="Sunday";
				}
				
				 if(spinner_2.getValue().equals(0)&& spinner.getValue().equals(0)&& spinner_1.getValue().equals(0)) {
					JOptionPane.showMessageDialog(null, "Please Select Number of working Hours and Days!!!");
				}
				 else if(spinner_2.getValue().equals(0)) {
						JOptionPane.showMessageDialog(null, "Please Select Number of working days!!!");
					}
				 
				 else if(spinner.getValue().equals(0)&& spinner_1.getValue().equals(0)) {
						JOptionPane.showMessageDialog(null, "Please Select Number of working hours and minutes!!!");
					}
				 else {
				 try {
					 Connection con = DBConnect.connect();

	                    String query = "INSERT INTO main values(1, '" + noOfWorkingDays + "','" + monday + "','" + tuesday + "','" +
	                    		wednesday + "','" + thursday + "','" + friday + "','"+ saturday +"','"+ sunday +"','"+ hours +"','"+ minutes +"')";

	                    Statement sta = con.createStatement();
	                    int x = sta.executeUpdate(query);
	                    if (x == 0) {
	                        JOptionPane.showMessageDialog(btnSave, "This is alredy exist");
	                    } else {
	                        JOptionPane.showMessageDialog(btnSave,
	                            "Data Successfully Added!!!");
	                    }
	                    con.close();
	                } catch (Exception exception) {
	                    //exception.printStackTrace();
	                	JOptionPane.showMessageDialog(btnSave, "This is alredy exist");
	                }
			}
				
			}
		});
		btnSave.setForeground(Color.BLACK);
		btnSave.setBackground(SystemColor.textHighlight);
		btnSave.setBounds(842, 544, 89, 37);
		frame.getContentPane().add(btnSave);
		
		JLabel lblNoworkingDays = new JLabel("No. of Working Days");
		lblNoworkingDays.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNoworkingDays.setBounds(284, 185, 175, 21);
		frame.getContentPane().add(lblNoworkingDays);
		
		spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(0, 0, 7, 1));
		spinner_2.setBounds(530, 176, 55, 30);
		frame.getContentPane().add(spinner_2);
	}
}
