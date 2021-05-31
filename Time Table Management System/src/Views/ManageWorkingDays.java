package Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import DBConnect.DBConnect;
import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.SpinnerNumberModel;
import java.awt.SystemColor;

public class ManageWorkingDays {

	private JFrame frame;
	public String Mon ,Tu ,We,Th,Fr,Sat,Sun;
	private JTable table;
	private JTextField textField;
	
	private JRadioButton radioButton;
	private JRadioButton radioButton_1;
	private JRadioButton radioButton_2;
	private JRadioButton radioButton_3;
	private JRadioButton radioButton_4;
	private JRadioButton radioButton_5;
	private JRadioButton radioButton_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageWorkingDays window = new ManageWorkingDays();
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
	public ManageWorkingDays() {
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
					
					String query="select * from main ";
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
		
		JButton button_1 = new JButton("Add Working Days");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddWorkingDays itm = new AddWorkingDays();
				try {
					AddWorkingDays.main(null);
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
		button_1.setBounds(10, 106, 230, 57);
		panel.add(button_1);
		
		JButton button_2 = new JButton("Manage Working Days");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_2.setBackground(new Color(0, 139, 139));
		button_2.setBounds(10, 168, 230, 57);
		panel.add(button_2);
		
		JLabel label = new JLabel("No. of Working Days");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(330, 388, 175, 21);
		frame.getContentPane().add(label);
		
		JSpinner spNoOfWorkingDays = new JSpinner();
		spNoOfWorkingDays.setModel(new SpinnerNumberModel(0, 0, 7, 1));
		spNoOfWorkingDays.setBounds(559, 379, 55, 30);
		frame.getContentPane().add(spNoOfWorkingDays);
		
		JLabel label_1 = new JLabel("Working Days");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_1.setBounds(330, 458, 117, 21);
		frame.getContentPane().add(label_1);
		
		radioButton = new JRadioButton("Monday");
		radioButton.setForeground(Color.BLACK);
		radioButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		radioButton.setBackground(Color.LIGHT_GRAY);
		radioButton.setBounds(535, 459, 96, 23);
		frame.getContentPane().add(radioButton);
		
		radioButton_1 = new JRadioButton("Tuesday");
		radioButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		radioButton_1.setBackground(Color.LIGHT_GRAY);
		radioButton_1.setBounds(635, 459, 91, 23);
		frame.getContentPane().add(radioButton_1);
		
		radioButton_2 = new JRadioButton("Wednesday");
		radioButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		radioButton_2.setBackground(Color.LIGHT_GRAY);
		radioButton_2.setBounds(728, 459, 109, 23);
		frame.getContentPane().add(radioButton_2);
		
		radioButton_3 = new JRadioButton("Thursday");
		radioButton_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		radioButton_3.setBackground(Color.LIGHT_GRAY);
		radioButton_3.setBounds(835, 459, 91, 23);
		frame.getContentPane().add(radioButton_3);
		
		radioButton_4 = new JRadioButton("Friday");
		radioButton_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		radioButton_4.setBackground(Color.LIGHT_GRAY);
		radioButton_4.setBounds(928, 459, 109, 23);
		frame.getContentPane().add(radioButton_4);
		
		radioButton_5 = new JRadioButton("Saturday");
		radioButton_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		radioButton_5.setBackground(Color.LIGHT_GRAY);
		radioButton_5.setBounds(535, 493, 91, 23);
		frame.getContentPane().add(radioButton_5);
		
		radioButton_6 = new JRadioButton("Sunday");
		radioButton_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		radioButton_6.setBackground(Color.LIGHT_GRAY);
		radioButton_6.setBounds(635, 493, 109, 23);
		frame.getContentPane().add(radioButton_6);
		
		JLabel label_2 = new JLabel("Working Hours Per Day");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_2.setBounds(330, 565, 203, 24);
		frame.getContentPane().add(label_2);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		spinner_1.setBounds(560, 559, 71, 30);
		frame.getContentPane().add(spinner_1);
		
		JLabel label_3 = new JLabel("Hours");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_3.setBounds(635, 565, 46, 14);
		frame.getContentPane().add(label_3);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		spinner_2.setBounds(799, 559, 71, 30);
		frame.getContentPane().add(spinner_2);
		
		JLabel label_4 = new JLabel("Mins");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_4.setBounds(880, 567, 46, 14);
		frame.getContentPane().add(label_4);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton.isSelected()) {
					Mon=radioButton.getText().toString();
				}
				else{
					Mon = " - ";
				}
				
				
				if(radioButton_1.isSelected()) {
					Tu=radioButton_1.getText().toString();
				}
				else{
					Tu = " - ";
				}
				
				if(radioButton_2.isSelected()) {
					We=radioButton_2.getText().toString();
				}
				else{
					We = " - ";
				}
				
				if(radioButton_3.isSelected()) {
					Th=radioButton_3.getText().toString();
				}
				else{
					Th = " - ";
				}
				
				
				if(radioButton_4.isSelected()) {
					Fr=radioButton_4.getText().toString();
				}
				
				else{
					Fr = " - ";
				}
				
				if(radioButton_5.isSelected()) {
					Sat=radioButton_5.getText().toString();
				}
				
				else{
					Sat = " - ";
				}
				
				if(radioButton_6.isSelected()) {
					Sun=radioButton_6.getText().toString();
				}
				else{
					Sun = " - ";
				}
				
				if(spNoOfWorkingDays.getValue().equals(0)&& spinner_1.getValue().equals(0)&& spinner_2.getValue().equals(0)) {
					JOptionPane.showMessageDialog(null, "Please Select Number of working Hours and Days!!!");
				}
				 else if(spNoOfWorkingDays.getValue().equals(0)) {
						JOptionPane.showMessageDialog(null, "Please Select Number of working days!!!");
					}
				 
				 else if(spinner_1.getValue().equals(0)&& spinner_2.getValue().equals(0)) {
						JOptionPane.showMessageDialog(null, "Please Select Number of working hours and minutes!!!");
					}
				 else {
				
				try {
					Connection con = DBConnect.connect();
					
					String query="Update main set noOfWorkingDays='"+spNoOfWorkingDays.getValue()+"',monday='"+Mon+"',tuesday='"+Tu+"',wednesday='"+We+"',thursday='"+Th+"',friday='"+Fr+"',saturday='"+Sat+"',sunday='"+Sun+"',hours='"+spinner_1.getValue()+"',minutes='"+spinner_2.getValue()+"' where mid='"+textField.getText()+"' ";
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
		btnUpdate.setForeground(Color.BLACK);
		btnUpdate.setBackground(SystemColor.textHighlight);
		btnUpdate.setBounds(855, 613, 89, 37);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textField.getText().isEmpty()) {
				
					JOptionPane.showMessageDialog(null, "No data to be deleted");
				}
				else {
				try {
					Connection con = DBConnect.connect();
					String query="Delete from main where mid='"+textField.getText()+"'";
					PreparedStatement pst=con.prepareStatement(query);
					pst.execute();
					
					
					
					JOptionPane.showMessageDialog(null, "Data Deleted");
					pst.close();
					}
					
					catch(Exception e1) {
						e1.printStackTrace();
						
					}
				}
			}
		});
		btnDelete.setForeground(Color.BLACK);
		btnDelete.setBackground(SystemColor.textHighlight);
		btnDelete.setBounds(988, 613, 89, 37);
		frame.getContentPane().add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(282, 76, 881, 247);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int selectedRow=table.getSelectedRow();
				
				
				//textField.setText(table.getValueAt(selectedRow, 1).toString());
				//textField_1.setText(table.getValueAt(selectedRow, 9).toString());
				//textField_2.setText(table.getValueAt(selectedRow, 10).toString());
				textField.setText(table.getValueAt(selectedRow, 0).toString());
				//spi1.setValue((Integer)table.getValueAt(selectedRow, 1));
				
				
				//spi1.setValue((Integer)table.getValueAt(selectedRow, 1));
				String checkdaymon=table.getValueAt(selectedRow, 2).toString();
				String checkdaytues=table.getValueAt(selectedRow, 3).toString();
				String checkdayWed=table.getValueAt(selectedRow, 4).toString();
				String checkdayThur=table.getValueAt(selectedRow, 5).toString();
				String checkdayFri=table.getValueAt(selectedRow, 6).toString();
				String checkdaySat=table.getValueAt(selectedRow, 7).toString();
				
				String checkdaySun=table.getValueAt(selectedRow, 8).toString();
				
				
				
				if(checkdaymon.equals("Monday")) {
					radioButton.setSelected(true);
				}
				else{
					radioButton.setSelected(false);
				}
				
				
				if(checkdaytues.equals("Tuesday")) {
					radioButton_1.setSelected(true);
				}
				else{
					radioButton_1.setSelected(false);
				}
				
				if(checkdayWed.equals("Wednesday")) {
					radioButton_2.setSelected(true);
				}
				else{
					radioButton_2.setSelected(false);
				}
				
				if(checkdayThur.equals("Thursday")) {
					radioButton_3.setSelected(true);
				}
				else{
					radioButton_3.setSelected(false);
				}
				
				
				if(checkdayFri.equals("Friday")) {
					radioButton_4.setSelected(true);
				}
				else{
					radioButton_4.setSelected(false);
				}
				
				if(checkdaySat.equals("Saturday")) {
					radioButton_5.setSelected(true);
				}
				else{
					radioButton_5.setSelected(false);
				}
				
				if(checkdaySun.equals("Sunday")) {
					radioButton_6.setSelected(true);
				}
				else{
					radioButton_6.setSelected(false);
				}
				spNoOfWorkingDays.setValue((Integer)table.getValueAt(selectedRow, 1));
				spinner_1.setValue((Integer)table.getValueAt(selectedRow, 9));
				spinner_2.setValue((Integer)table.getValueAt(selectedRow, 10));
				
				
			}
		});
			
		scrollPane.setViewportView(table);
		
		JLabel lblManegeWorkingDays = new JLabel("Manage Working Days");
		lblManegeWorkingDays.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblManegeWorkingDays.setBounds(282, 28, 381, 37);
		frame.getContentPane().add(lblManegeWorkingDays);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setForeground(Color.LIGHT_GRAY);
		textField.setBounds(457, 342, -22, 14);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnRefresh = new JButton("Clear");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 spinner_2.setValue(0);
				 spNoOfWorkingDays.setValue(0);
				 spinner_1.setValue(0);
				 radioButton.setSelected(false);
				 radioButton_1.setSelected(false);
				 radioButton_2.setSelected(false);
				 radioButton_3.setSelected(false);
				 radioButton_4.setSelected(false);
				 radioButton_5.setSelected(false);
				 radioButton_6.setSelected(false);
				
			}
		});
		btnRefresh.setForeground(Color.BLACK);
		btnRefresh.setBackground(SystemColor.textHighlight);
		btnRefresh.setBounds(728, 613, 89, 37);
		frame.getContentPane().add(btnRefresh);
	}
}
