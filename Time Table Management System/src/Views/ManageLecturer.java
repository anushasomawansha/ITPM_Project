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
import javax.swing.JTextField;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import DBConnect.DBConnect;
import net.proteanit.sql.DbUtils;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;

public class ManageLecturer {

	private JFrame frame;
	private JTextField tfLecName;
	private JTextField tfEmpID;
	private JTextField tfRank;
	private JTable table;
	private JTextField textField_3;
	private JComboBox cbbuilding;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageLecturer window = new ManageLecturer();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void getLocation() {
		try {
		Connection con = DBConnect.connect();

		String query="select * from location";
		PreparedStatement pst=con.prepareStatement(query);
		ResultSet rs=pst.executeQuery();
		//comboBox.setModel(DbUtils.resultSetToNestedList(rs));
		//comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Lecturer..."}))
		while(rs.next()) {
		String lec1=rs.getString("buildingName");
		cbbuilding.addItem(lec1);
		
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
	public ManageLecturer() {
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
					
					String query="select lid As Lecturer_ID , lectureName AS LECTURER_NAME, empID AS Employee_ID,faculty AS FACULTY, department AS DEPARTMENT, centre AS CENTRE,building AS BUILDING,level AS LEVEL,rank AS RANK from lecturers ";
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
		
		JButton btnAddLecturers = new JButton("Add Lecturers");
		btnAddLecturers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddLecturers itm = new AddLecturers();
				try {
					AddLecturers.main(null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setVisible(false);
			}
		});
		btnAddLecturers.setForeground(Color.WHITE);
		btnAddLecturers.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddLecturers.setBackground(new Color(0, 139, 139));
		btnAddLecturers.setBounds(10, 103, 230, 57);
		panel.add(btnAddLecturers);
		
		JButton btnManegeLecturers = new JButton("Manage Lecturers");
		btnManegeLecturers.setForeground(Color.WHITE);
		btnManegeLecturers.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnManegeLecturers.setBackground(new Color(0, 139, 139));
		btnManegeLecturers.setBounds(10, 165, 230, 57);
		panel.add(btnManegeLecturers);
		
		JLabel lblManageLecturers = new JLabel("Manage Lecturers");
		lblManageLecturers.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblManageLecturers.setBounds(284, 24, 381, 37);
		frame.getContentPane().add(lblManageLecturers);
		
		
		
		
		
		JLabel label = new JLabel("Lecturer name");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(284, 370, 116, 28);
		frame.getContentPane().add(label);
		
		JLabel label_2 = new JLabel("Employee ID");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_2.setBounds(284, 424, 101, 18);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Faculty");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_3.setBounds(284, 468, 116, 28);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Department");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_4.setBounds(284, 507, 116, 28);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("Level");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_5.setBounds(284, 556, 101, 18);
		frame.getContentPane().add(label_5);
		
		tfLecName = new JTextField();
		tfLecName.setColumns(10);
		tfLecName.setBounds(440, 374, 138, 20);
		frame.getContentPane().add(tfLecName);
		
		tfEmpID = new JTextField();
		tfEmpID.setColumns(10);
		tfEmpID.setBounds(440, 424, 138, 20);
		frame.getContentPane().add(tfEmpID);
		
		JComboBox cbFac = new JComboBox();
		cbFac.setModel(new DefaultComboBoxModel(new String[] {"Select", "Computing", "Engineering", "Business Management"}));
		cbFac.setForeground(Color.BLACK);
		cbFac.setBackground(Color.WHITE);
		cbFac.setBounds(440, 473, 145, 20);
		frame.getContentPane().add(cbFac);
		
		JComboBox cbDepartment = new JComboBox();
		cbDepartment.setModel(new DefaultComboBoxModel(new String[] {"Select", "SE", "CSE", "CSSE", "IT", "IM"}));
		cbDepartment.setForeground(Color.BLACK);
		cbDepartment.setBackground(Color.WHITE);
		cbDepartment.setBounds(440, 512, 145, 20);
		frame.getContentPane().add(cbDepartment);
		
		JComboBox cbLevel = new JComboBox();
		cbLevel.setModel(new DefaultComboBoxModel(new String[] {"Select", "Professor", "Assistant Professor", "Senior Lecturer(HG)", "Senior Lecturer", "Lecturer", "Assistant Lecturer"}));
		cbLevel.setForeground(Color.BLACK);
		cbLevel.setBackground(Color.WHITE);
		cbLevel.setBounds(440, 556, 145, 20);
		frame.getContentPane().add(cbLevel);
		
		tfRank = new JTextField();
		tfRank.setEditable(false);
		tfRank.setColumns(10);
		tfRank.setBounds(924, 511, 145, 20);
		frame.getContentPane().add(tfRank);
		
		 cbbuilding = new JComboBox();
		cbbuilding.setModel(new DefaultComboBoxModel(new String[] {"Select"}));
		cbbuilding.setForeground(Color.BLACK);
		cbbuilding.setBackground(Color.WHITE);
		cbbuilding.setBounds(924, 472, 145, 20);
		frame.getContentPane().add(cbbuilding);
		
		JComboBox cbCenter = new JComboBox();
		cbCenter.setModel(new DefaultComboBoxModel(new String[] {"Select", "Malabe", "Kandy", "Matara"}));
		cbCenter.setForeground(Color.BLACK);
		cbCenter.setBackground(Color.WHITE);
		cbCenter.setBounds(924, 423, 145, 20);
		frame.getContentPane().add(cbCenter);
		
		JLabel label_6 = new JLabel("Center");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_6.setBounds(810, 419, 67, 28);
		frame.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("Building");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_7.setBounds(810, 468, 75, 28);
		frame.getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("Rank");
		label_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_8.setBounds(810, 507, 75, 28);
		frame.getContentPane().add(label_8);
		
		JButton bntGenID = new JButton("Generate ID");
		bntGenID.setBackground(SystemColor.textHighlight);
		bntGenID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					//	capacity =  Integer.parseInt(txtCapacity.getText());
					int cap =Integer.parseInt(tfEmpID.getText().toString());
					
					String level = cbLevel.getSelectedItem().toString();
					
					if(level=="Professor") {
						level = "1";
					}else if(level == "Assistant Professor") {
						level = "2";
					}else if(level == "Senior Lecturer(HG)") {
						level = "3";
					}else if(level == "Senior Lecturer") {
						level = "4";
					}else if(level == "Lecturer") {
						level = "5";
					}else if(level == "Assistant Lecturer") {
						level = "6";
					}
					
					tfRank.setText(level+"."+tfEmpID.getText().toString());
											
					}catch(NumberFormatException nuEx) {
						JOptionPane.showMessageDialog(null, "Can't add String values as EmployeeId");			
						System.out.println("Can't add String values as EmployeeId");
						return ;
					}
			}
		});
		bntGenID.setBounds(950, 547, 119, 37);
		frame.getContentPane().add(bntGenID);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBackground(SystemColor.textHighlight);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfLecName.setText(null);
				tfEmpID.setText(null);
				cbFac.setSelectedIndex(0);
				cbCenter.setSelectedIndex(0);
				cbDepartment.setSelectedIndex(0);
				cbbuilding.setSelectedIndex(0);
				cbLevel.setSelectedIndex(0);
				tfRank.setText(null);
			}
		});
		btnClear.setBounds(740, 613, 89, 37);
		frame.getContentPane().add(btnClear);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(284, 85, 866, 248);
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
				
				tfLecName.setText(table.getValueAt(selectedRow, 1).toString());
				tfEmpID.setText(table.getValueAt(selectedRow, 2).toString());
				tfRank.setText(table.getValueAt(selectedRow, 8).toString());
				//textField_5.setText(table.getValueAt(selectedRow, 8).toString());
				textField_3.setText(table.getValueAt(selectedRow, 0).toString());
				
				
				String combofaculty = table.getValueAt(selectedRow, 3).toString();
				for(int i=0; i<cbFac.getItemCount();i++) {
					if(cbFac.getItemAt(i).toString().equalsIgnoreCase(combofaculty)) {
						cbFac.setSelectedIndex(i);
					}
				}
				
				
				String comboDepartment = table.getValueAt(selectedRow, 4).toString();
				for(int i=0; i<cbDepartment.getItemCount();i++) {
					if(cbDepartment.getItemAt(i).toString().equalsIgnoreCase(comboDepartment)) {
						cbDepartment.setSelectedIndex(i);
					}
				}
				
				
				String comboCenter = table.getValueAt(selectedRow, 5).toString();
				for(int i=0; i<cbCenter.getItemCount();i++) {
					if(cbCenter.getItemAt(i).toString().equalsIgnoreCase(comboCenter)) {
						cbCenter.setSelectedIndex(i);
					}
				}
				
				
				String comboBuilding = table.getValueAt(selectedRow, 6).toString();
				for(int i=0; i<cbbuilding.getItemCount();i++) {
					if(cbbuilding.getItemAt(i).toString().equalsIgnoreCase(comboBuilding)) {
						cbbuilding.setSelectedIndex(i);
					}
				}
				
				
				String comboLevel = table.getValueAt(selectedRow, 7).toString();
				for(int i=0; i<cbLevel.getItemCount();i++) {
					if(cbLevel.getItemAt(i).toString().equalsIgnoreCase(comboLevel)) {
						cbLevel.setSelectedIndex(i);
					}
				}
			}
		});
		scrollPane.setViewportView(table);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 5));
		textField_3.setForeground(Color.LIGHT_GRAY);
		textField_3.setBackground(Color.LIGHT_GRAY);
		textField_3.setBounds(779, 377, -2, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton bntUpdate = new JButton("Update");
		bntUpdate.setBackground(SystemColor.textHighlight);
		bntUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(tfLecName.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please Enter Lecture Name!");
				}else if(tfEmpID.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Please Enter Lecture Employee ID!");
				}else if(cbFac.getSelectedIndex()==0){
					JOptionPane.showMessageDialog(null, "Please Enter Faculty!");
				}
				else if(cbDepartment.getSelectedIndex()==0){
					JOptionPane.showMessageDialog(null, "Please Enter Department!");
				}
				else if(cbCenter.getSelectedIndex()==0){
					JOptionPane.showMessageDialog(null, "Please Enter Center!");
				}
				else if(cbLevel.getSelectedIndex()==0){
					JOptionPane.showMessageDialog(null, "Please Enter Level!");
				}else if(cbbuilding.getSelectedIndex()==0){
					JOptionPane.showMessageDialog(null, "Please Enter Building!");
				}else if(tfRank.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Please Enter Rank!");
				}
				else {
				try {
					Connection con = DBConnect.connect();
					
					String query="Update lecturers set lectureName='"+tfLecName.getText()+"',empID='"+tfEmpID.getText()+"',faculty='"+cbFac.getSelectedItem()+"',department='"+cbDepartment.getSelectedItem()+"',centre='"+cbCenter.getSelectedItem()+"',building='"+cbbuilding.getSelectedItem()+"',level='"+cbLevel.getSelectedItem()+"',rank='"+tfRank.getText()+"' where lid='"+textField_3.getText()+"' ";
					PreparedStatement pst=con.prepareStatement(query);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Lecturer Details Updated Successfully!");
					pst.close();
					
					
					tfLecName.setText("");
					tfEmpID.setText("");
					tfRank.setText("");
					textField_3.setText("");
					cbFac.setSelectedIndex(0);
					cbDepartment.setSelectedIndex(0);
					cbCenter.setSelectedIndex(0);
					cbbuilding.setSelectedIndex(0);
					cbLevel.setSelectedIndex(0);
					
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		});
		bntUpdate.setBounds(878, 613, 89, 37);
		frame.getContentPane().add(bntUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(SystemColor.textHighlight);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = DBConnect.connect();
					String query="Delete from lecturers where lid='"+textField_3.getText()+"'";
					PreparedStatement pst=con.prepareStatement(query);
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Lecturer Details Deleted Successfully");
					pst.close();
					
					
					tfLecName.setText("");
					tfEmpID.setText("");
					tfRank.setText("");
					textField_3.setText("");
					cbFac.setSelectedIndex(0);
					cbDepartment.setSelectedIndex(0);
					cbCenter.setSelectedIndex(0);
					cbbuilding.setSelectedIndex(0);
					cbLevel.setSelectedIndex(0);
					
					}
					catch(Exception ex) {
						ex.printStackTrace();
						
					}
			}
		});
		btnDelete.setBounds(1009, 613, 89, 37);
		frame.getContentPane().add(btnDelete);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(176, 224, 230));
		lblNewLabel.setBounds(779, 499, 315, 103);
		frame.getContentPane().add(lblNewLabel);
		
		getLocation();
	}
}
