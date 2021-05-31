package Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DBConnect.DBConnect;
import net.proteanit.sql.DbUtils;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;

public class ManageTag {

	private JFrame frame;
	private JTextField TagName;
	private JTextField TagCode;
	private JTable table;
	private JTextField TagID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageTag window = new ManageTag();
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
	public ManageTag() {
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
					
					String query="select * from tag ";
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
		
		JButton button_1 = new JButton("Add Tags");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AddTag itm = new AddTag();
				AddTag.main(null);
				frame.setVisible(false);
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_1.setBackground(new Color(0, 139, 139));
		button_1.setBounds(10, 103, 230, 57);
		panel.add(button_1);
		
		JButton btnManageTag = new JButton("Manage Tag");
		btnManageTag.setForeground(Color.WHITE);
		btnManageTag.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnManageTag.setBackground(new Color(0, 139, 139));
		btnManageTag.setBounds(10, 165, 230, 57);
		panel.add(btnManageTag);
		
		JLabel label = new JLabel("Tag name");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(406, 444, 116, 28);
		frame.getContentPane().add(label);
		
		TagName = new JTextField();
		TagName.setColumns(10);
		TagName.setBounds(607, 444, 116, 31);
		frame.getContentPane().add(TagName);
		
		JLabel label_1 = new JLabel("Tag code");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_1.setBounds(406, 499, 116, 28);
		frame.getContentPane().add(label_1);
		
		TagCode = new JTextField();
		TagCode.setColumns(10);
		TagCode.setBounds(607, 499, 116, 31);
		frame.getContentPane().add(TagCode);
		
		JLabel label_2 = new JLabel("Related tag");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_2.setBounds(406, 557, 172, 18);
		frame.getContentPane().add(label_2);
		
		JComboBox Rtag = new JComboBox();
		Rtag.setModel(new DefaultComboBoxModel(new String[] {"Lec", "Tute", "Lab"}));
		Rtag.setForeground(Color.BLACK);
		Rtag.setBackground(Color.WHITE);
		Rtag.setBounds(607, 557, 151, 20);
		frame.getContentPane().add(Rtag);
		
		JButton btnClearManageTag = new JButton("Clear");
		btnClearManageTag.setBackground(SystemColor.textHighlight);
		btnClearManageTag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TagName.setText(null);
				TagCode.setText(null);
				Rtag.setSelectedItem(null);
				
			}
		});
		btnClearManageTag.setBounds(515, 613, 89, 37);
		frame.getContentPane().add(btnClearManageTag);
		
		JButton btnUpdateTag = new JButton("Update");
		btnUpdateTag.setBackground(SystemColor.textHighlight);
		btnUpdateTag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
if(TagName.getText().equals("")||TagCode.getText().equals("")|| Rtag.getSelectedItem().equals("")) {
					
					JOptionPane.showMessageDialog(null, "Please fill the form");
				}else {
				try {
					Connection con = DBConnect.connect();					
					String query="Update tag set TAGNAME='"+TagName.getText()+"',TAGCODE='"+TagCode.getText()+"',RELATEDTAG='"+Rtag.getSelectedItem()+"' where TAGID='"+TagID.getText()+"'";
					PreparedStatement pst=con.prepareStatement(query);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Data Updated");
					pst.close();
					
				}
				catch(Exception ea) {
					ea.printStackTrace();
				}
				}
				
			}
		});
		btnUpdateTag.setBounds(634, 613, 89, 37);
		frame.getContentPane().add(btnUpdateTag);
		
		JLabel lblManageTag = new JLabel("Manage Tag");
		lblManageTag.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblManageTag.setBounds(279, 24, 381, 37);
		frame.getContentPane().add(lblManageTag);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(279, 85, 882, 266);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int selectedRow=table.getSelectedRow();
			    TagID.setText(table.getValueAt(selectedRow, 0).toString());
			    TagName.setText(table.getValueAt(selectedRow, 1).toString());
			    TagCode.setText(table.getValueAt(selectedRow, 2).toString());
				
			    String comboLevel = table.getValueAt(selectedRow, 3).toString();
				
			    
			    for(int i=0; i<Rtag.getItemCount();i++) {
					if(Rtag.getItemAt(i).toString().equalsIgnoreCase(comboLevel)) {
						Rtag.setSelectedIndex(i);
					}
				}

			}
		});
		
		scrollPane.setViewportView(table);
		
		JButton btnDeleteTag = new JButton("Delete");
		btnDeleteTag.setBackground(SystemColor.textHighlight);
		btnDeleteTag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Connection con = DBConnect.connect();
					String query="Delete from tag where TAGID='"+TagID.getText()+"'";
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
		btnDeleteTag.setBounds(761, 613, 89, 37);
		frame.getContentPane().add(btnDeleteTag);
		
		JLabel lblTagId = new JLabel("Tag ID");
		lblTagId.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTagId.setBounds(406, 394, 116, 28);
		frame.getContentPane().add(lblTagId);
		
		TagID = new JTextField();
		TagID.setColumns(10);
		TagID.setBounds(607, 394, 116, 31);
		frame.getContentPane().add(TagID);
	}
}
