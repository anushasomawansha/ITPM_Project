package Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.UnsupportedLookAndFeelException;

import DBConnect.DBConnect;
import net.proteanit.sql.DbUtils;

import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;

public class ManageStudentGroups {

	private JFrame frame;
	private JTextField GroupID;
	private JTextField SubGroupID;
	private JTextField textField_2;
	private JComboBox AcademicYear;
	private JComboBox Program;
	private JSpinner SubGroupNumber;
	private JSpinner GroupNumber;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageStudentGroups window = new ManageStudentGroups();
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
	public ManageStudentGroups() {
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
					
					String query="select * from studentGroups ";
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
		
		JButton btnAddSubjects = new JButton("Add Student Groups");
		btnAddSubjects.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AddStudentGroups itm = new AddStudentGroups();
				AddStudentGroups.main(null);
				frame.setVisible(false);
			}
		});
		btnAddSubjects.setForeground(Color.WHITE);
		btnAddSubjects.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddSubjects.setBackground(new Color(0, 139, 139));
		btnAddSubjects.setBounds(10, 103, 230, 57);
		panel.add(btnAddSubjects);
		
		JButton btnManegeSubjects = new JButton("Manage Student Groups");
		btnManegeSubjects.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnManegeSubjects.setForeground(Color.WHITE);
		btnManegeSubjects.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnManegeSubjects.setBackground(new Color(0, 139, 139));
		btnManegeSubjects.setBounds(10, 165, 230, 57);
		panel.add(btnManegeSubjects);
		
		JLabel label = new JLabel("Academic year semester");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(289, 446, 172, 18);
		frame.getContentPane().add(label);
		
		AcademicYear = new JComboBox();
		AcademicYear.setModel(new DefaultComboBoxModel(new String[] {"Y1.S1", "Y1.S2", "Y2.S1", "Y2.S2", "Y3.S1", "Y3.S2", "Y4.S1", "Y4.S2"}));
		AcademicYear.setForeground(Color.BLACK);
		AcademicYear.setBackground(Color.WHITE);
		AcademicYear.setBounds(490, 442, 151, 28);
		frame.getContentPane().add(AcademicYear);
		
		JLabel label_1 = new JLabel("Program");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_1.setBounds(289, 498, 116, 20);
		frame.getContentPane().add(label_1);
		
		Program = new JComboBox();
		Program.setModel(new DefaultComboBoxModel(new String[] {"IT", "SE", "CSE", "CSSE", "IM"}));
		Program.setForeground(Color.BLACK);
		Program.setBackground(Color.WHITE);
		Program.setBounds(490, 495, 151, 28);
		frame.getContentPane().add(Program);
		
		JLabel label_2 = new JLabel("Group number");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_2.setBounds(289, 554, 116, 18);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Sub group number");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_3.setBounds(289, 614, 135, 18);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Group ID");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_4.setBounds(846, 409, 116, 28);
		frame.getContentPane().add(label_4);
		
		GroupID = new JTextField();
		GroupID.setEditable(false);
		GroupID.setColumns(10);
		GroupID.setBounds(1018, 409, 116, 31);
		frame.getContentPane().add(GroupID);
		
		SubGroupID = new JTextField();
		SubGroupID.setEditable(false);
		SubGroupID.setColumns(10);
		SubGroupID.setBounds(1018, 470, 116, 31);
		frame.getContentPane().add(SubGroupID);
		
		JLabel label_5 = new JLabel("Sub group ID");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_5.setBounds(846, 470, 116, 28);
		frame.getContentPane().add(label_5);
		
		JButton GenerateID = new JButton("Generate IDs");
		GenerateID.setBackground(SystemColor.textHighlight);
		GenerateID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GroupID.setText(AcademicYear.getSelectedItem().toString()+"."+Program.getSelectedItem().toString()+"."+ GroupNumber.getValue().toString());
				
				SubGroupID.setText(AcademicYear.getSelectedItem().toString()+"."+Program.getSelectedItem().toString()+"."+ GroupNumber.getValue().toString()+"."+SubGroupNumber.getValue().toString());
				
			}
		});
		GenerateID.setBounds(1018, 528, 116, 37);
		frame.getContentPane().add(GenerateID);
		
		JButton btnUpdateManageGroup = new JButton("Update");
		btnUpdateManageGroup.setBackground(SystemColor.textHighlight);
		btnUpdateManageGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection con = DBConnect.connect();					
					String query="Update studentGroups set AcademicYearSemester='"+AcademicYear.getSelectedItem()+"',Programme='"+Program.getSelectedItem()+"',GroupNo='"+GroupNumber.getValue()+"',SubGroupNo='"+SubGroupNumber.getValue()+"',GroupID='"+GroupID.getText()+"',SubGroupID='"+SubGroupID.getText()+"' where SGroupID='"+textField_2.getText()+"'";
					PreparedStatement pst=con.prepareStatement(query);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Data Updated");
					pst.close();
					
				}
				catch(Exception ea) {
					ea.printStackTrace();
				}
				
			}
		});
		btnUpdateManageGroup.setBounds(934, 606, 89, 37);
		frame.getContentPane().add(btnUpdateManageGroup);
		
		JButton btnDeleteManageGroup = new JButton("Delete");
		btnDeleteManageGroup.setBackground(SystemColor.textHighlight);
		btnDeleteManageGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection con = DBConnect.connect();
					String query="Delete from studentGroups where SGroupID='"+textField_2.getText()+"'";
					PreparedStatement pst=con.prepareStatement(query);
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Data Deleted");
					pst.close();
					
					}
					catch(Exception en) {
						en.printStackTrace();
						
					}
				
				
			}
		});
		btnDeleteManageGroup.setBounds(1061, 606, 89, 37);
		frame.getContentPane().add(btnDeleteManageGroup);
		
		JLabel lblManege = new JLabel("Manage Student Groups");
		lblManege.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblManege.setBounds(271, 11, 381, 37);
		frame.getContentPane().add(lblManege);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(276, 78, 887, 291);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
				int selectedRow=table.getSelectedRow();

				textField_2.setText(table.getValueAt(selectedRow, 0).toString());
				
			    String comboLevel = table.getValueAt(selectedRow, 1).toString();
				for(int i=0; i<AcademicYear.getItemCount();i++) {
					if(AcademicYear.getItemAt(i).toString().equalsIgnoreCase(comboLevel)) {
						AcademicYear.setSelectedIndex(i);
					}
				}

				String comboLevel1 = table.getValueAt(selectedRow, 2).toString();
				for(int i=0; i<Program.getItemCount();i++) {
					if(Program.getItemAt(i).toString().equalsIgnoreCase(comboLevel1)) {
						Program.setSelectedIndex(i);
					}
				}

				GroupNumber.setValue((Integer)table.getValueAt(selectedRow, 3));
				
				SubGroupNumber.setValue((Integer)table.getValueAt(selectedRow, 4));
			    
				GroupID.setText(table.getValueAt(selectedRow, 5).toString());
				
				SubGroupID.setText(table.getValueAt(selectedRow, 6).toString());
				
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBackground(SystemColor.textHighlight);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GroupID.setText(null);
				SubGroupID.setText(null);
				
			}
		});
		btnClear.setBounds(794, 606, 89, 37);
		frame.getContentPane().add(btnClear);
		
		GroupNumber = new JSpinner();
		GroupNumber.setModel(new SpinnerNumberModel(0, 0, 15, 1));
		GroupNumber.setBounds(490, 550, 151, 28);
		frame.getContentPane().add(GroupNumber);
		
		SubGroupNumber = new JSpinner();
		SubGroupNumber.setModel(new SpinnerNumberModel(0, 0, 20, 1));
		SubGroupNumber.setBounds(490, 606, 151, 28);
		frame.getContentPane().add(SubGroupNumber);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblId.setBounds(289, 398, 172, 18);
		frame.getContentPane().add(lblId);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(490, 393, 151, 31);
		frame.getContentPane().add(textField_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(176, 224, 230));
		lblNewLabel.setBounds(804, 380, 359, 203);
		frame.getContentPane().add(lblNewLabel);
	}

}
