package Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.UnsupportedLookAndFeelException;

import DBConnect.DBConnect;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class AddStudentGroups {

	private JFrame frame;
	private JTextField GroupID;
	private JTextField SubGroupID;
	private JSpinner SubGroupNumber;
	private JSpinner GroupNumber;
	private JComboBox AcademicYear;
	private JComboBox Program;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudentGroups window = new AddStudentGroups();
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
	public AddStudentGroups() {
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
		
		JButton btnAddStudentGroup = new JButton("Add Student Group");
		btnAddStudentGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAddStudentGroup.setBounds(10, 103, 230, 57);
		btnAddStudentGroup.setForeground(Color.WHITE);
		btnAddStudentGroup.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddStudentGroup.setBackground(new Color(0, 139, 139));
		panel.add(btnAddStudentGroup);
		
		JButton btnManegeStudentGroup = new JButton("Manage Student Group");
		btnManegeStudentGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ManageStudentGroups itm = new ManageStudentGroups();
				ManageStudentGroups.main(null);
				frame.setVisible(false);
				
			}
		});
		btnManegeStudentGroup.setBounds(10, 165, 230, 57);
		btnManegeStudentGroup.setForeground(Color.WHITE);
		btnManegeStudentGroup.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnManegeStudentGroup.setBackground(new Color(0, 139, 139));
		panel.add(btnManegeStudentGroup);
		
		JLabel lblAcademicYearSemester = new JLabel("Academic year semester");
		lblAcademicYearSemester.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAcademicYearSemester.setBounds(282, 147, 172, 18);
		frame.getContentPane().add(lblAcademicYearSemester);
		
		AcademicYear = new JComboBox();
		AcademicYear.setModel(new DefaultComboBoxModel(new String[] {"Y1.S1", "Y1.S2", "Y2.S1", "Y2.S2", "Y3.S1", "Y3.S2", "Y4.S1", "Y4.S2"}));
		AcademicYear.setForeground(Color.BLACK);
		AcademicYear.setBackground(Color.WHITE);
		AcademicYear.setBounds(483, 145, 151, 28);
		frame.getContentPane().add(AcademicYear);
		
		JLabel lblProgram = new JLabel("Program");
		lblProgram.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblProgram.setBounds(282, 208, 116, 20);
		frame.getContentPane().add(lblProgram);
		
		JLabel lblGroupNumber = new JLabel("Group number");
		lblGroupNumber.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblGroupNumber.setBounds(282, 272, 116, 18);
		frame.getContentPane().add(lblGroupNumber);
		
		JLabel lblSubGroupNumber = new JLabel("Sub group number");
		lblSubGroupNumber.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSubGroupNumber.setBounds(282, 342, 135, 18);
		frame.getContentPane().add(lblSubGroupNumber);
		
		Program = new JComboBox();
		Program.setModel(new DefaultComboBoxModel(new String[] {"IT", "SE", "CSE", "CSSE", "IM"}));
		Program.setForeground(Color.BLACK);
		Program.setBackground(Color.WHITE);
		Program.setBounds(483, 206, 151, 28);
		frame.getContentPane().add(Program);
		
		JLabel lblAdd = new JLabel(" Add Student Groups");
		lblAdd.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblAdd.setBounds(282, 27, 381, 37);
		frame.getContentPane().add(lblAdd);
		
		JLabel lblGroupId = new JLabel("Group ID");
		lblGroupId.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblGroupId.setBounds(778, 175, 116, 28);
		frame.getContentPane().add(lblGroupId);
		
		JLabel lblSubGroupId = new JLabel("Sub group ID");
		lblSubGroupId.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSubGroupId.setBounds(778, 240, 116, 28);
		frame.getContentPane().add(lblSubGroupId);
		
		GroupID = new JTextField();
		GroupID.setEditable(false);
		GroupID.setBounds(962, 175, 116, 31);
		frame.getContentPane().add(GroupID);
		GroupID.setColumns(10);
		
		SubGroupID = new JTextField();
		SubGroupID.setEditable(false);
		SubGroupID.setColumns(10);
		SubGroupID.setBounds(962, 240, 116, 31);
		frame.getContentPane().add(SubGroupID);
		
		JButton btnGenerateId = new JButton("Genarade IDs");
		btnGenerateId.setBackground(SystemColor.textHighlight);
		btnGenerateId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				
				
				GroupID.setText(AcademicYear.getSelectedItem().toString()+"."+Program.getSelectedItem().toString()+"."+ GroupNumber.getValue().toString());
				
				SubGroupID.setText(AcademicYear.getSelectedItem().toString()+"."+Program.getSelectedItem().toString()+"."+ GroupNumber.getValue().toString()+"."+SubGroupNumber.getValue().toString());
				
			}
		});
		btnGenerateId.setBounds(949, 312, 129, 37);
		frame.getContentPane().add(btnGenerateId);
		
		JButton btnClearStudentGroups = new JButton("Clear");
		btnClearStudentGroups.setBackground(SystemColor.textHighlight);
		btnClearStudentGroups.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				GroupID.setText(null);
				SubGroupID.setText(null);
				
			}
		});
		btnClearStudentGroups.setBounds(783, 448, 89, 37);
		frame.getContentPane().add(btnClearStudentGroups);
		
		JButton btnAddGroup = new JButton("Save");
		btnAddGroup.setBackground(SystemColor.textHighlight);
		btnAddGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String ays= AcademicYear.getSelectedItem().toString();
				String program= Program.getSelectedItem().toString();
				String groupnumber= GroupNumber.getValue().toString();
				String subgroupnumber= SubGroupNumber.getValue().toString();
				String groupid = GroupID.getText();
				String subgroupid = SubGroupID.getText();
				
				
				
				
				if(GroupID.getText().equals("")||SubGroupID.getText().equals("")) {
					
					JOptionPane.showMessageDialog(null, "Please Genarate IDs First!");
				}else {
				
				try {
					 Connection con = DBConnect.connect();

	                    String query = "INSERT INTO studentGroups values(null, '" + ays + "','" + program + "','" + groupnumber + "', '" + subgroupnumber + "', '" + groupid + "', '" + subgroupid + "')";

	                    Statement sta = con.createStatement();
	                    int x = sta.executeUpdate(query);
	                    if (x == 0) {
	                        JOptionPane.showMessageDialog(btnAddGroup, "This is alredy exist");
	                    } else {
	                        JOptionPane.showMessageDialog(btnAddGroup,
	                            "Student Group is sucessfully Added!");
	                    }
	                    con.close();
	                } catch (Exception exception) {
	                    System.out.println("xxxxxxxxxxxxxxxxxxxxxxx");
	                	
	                }
				
				}
				
			}
		});
		btnAddGroup.setBounds(937, 448, 89, 37);
		frame.getContentPane().add(btnAddGroup);
		
		 GroupNumber = new JSpinner();
		GroupNumber.setModel(new SpinnerNumberModel(0, 0, 15, 1));
		GroupNumber.setBounds(483, 272, 151, 28);
		frame.getContentPane().add(GroupNumber);
		
		 SubGroupNumber = new JSpinner();
		SubGroupNumber.setModel(new SpinnerNumberModel(0, 0, 20, 1));
		SubGroupNumber.setBounds(483, 340, 151, 28);
		frame.getContentPane().add(SubGroupNumber);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(176, 224, 230));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(748, 147, 358, 221);
		frame.getContentPane().add(lblNewLabel);
	}
}
