package Views;



import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UnsupportedLookAndFeelException;

import DBConnect.DBConnect;


import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;

public class AddTag {

	private JFrame frame;
	private JTextField TagName;
	private JTextField TagCode;
	private JComboBox Rtag;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTag window = new AddTag();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddTag() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().getContentPane().setBackground(Color.LIGHT_GRAY);
		getFrame().setBounds(100, 100, 1200, 700);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(Color.WHITE);
		panel.setBackground(new Color(0, 139, 139));
		panel.setBounds(0, 0, 250, 661);
		getFrame().getContentPane().add(panel);
		
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
		
		JButton btnAddTags = new JButton("Add Tags");
		btnAddTags.setForeground(Color.WHITE);
		btnAddTags.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddTags.setBackground(new Color(0, 139, 139));
		btnAddTags.setBounds(10, 103, 230, 57);
		panel.add(btnAddTags);
		
		JButton btnManegeTag = new JButton("Manage Tag");
		btnManegeTag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ManageTag itm = new ManageTag();
				ManageTag.main(null);
				getFrame().setVisible(false);
			}
		});
		btnManegeTag.setForeground(Color.WHITE);
		btnManegeTag.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnManegeTag.setBackground(new Color(0, 139, 139));
		btnManegeTag.setBounds(10, 165, 230, 57);
		panel.add(btnManegeTag);
		
		JLabel lblTagName = new JLabel("Tag name");
		lblTagName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTagName.setBounds(485, 169, 116, 28);
		getFrame().getContentPane().add(lblTagName);
		
		TagName = new JTextField();
		TagName.setColumns(10);
		TagName.setBounds(686, 169, 116, 31);
		getFrame().getContentPane().add(TagName);
		
		TagCode = new JTextField();
		TagCode.setColumns(10);
		TagCode.setBounds(686, 230, 116, 31);
		getFrame().getContentPane().add(TagCode);
		
		JLabel lblTagCode = new JLabel("Tag code");
		lblTagCode.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTagCode.setBounds(485, 230, 116, 28);
		getFrame().getContentPane().add(lblTagCode);
		
		JLabel lblAddTag = new JLabel("Add Tag");
		lblAddTag.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblAddTag.setBounds(284, 26, 381, 37);
		getFrame().getContentPane().add(lblAddTag);
		
		JLabel lblRelatedTag = new JLabel("Related tag");
		lblRelatedTag.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRelatedTag.setBounds(485, 307, 172, 18);
		getFrame().getContentPane().add(lblRelatedTag);
		
		JComboBox Rtag = new JComboBox();
		Rtag.setModel(new DefaultComboBoxModel(new String[] {"Lec", "Tute", "Lab"}));
		Rtag.setForeground(Color.BLACK);
		Rtag.setBackground(Color.WHITE);
		Rtag.setBounds(686, 307, 151, 20);
		getFrame().getContentPane().add(Rtag);
		
		JButton btnClearAddTag = new JButton("Clear");
		btnClearAddTag.setBackground(SystemColor.textHighlight);
		btnClearAddTag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TagName.setText(null);
				TagCode.setText(null);
				
			}
		});
		btnClearAddTag.setBounds(594, 432, 89, 37);
		getFrame().getContentPane().add(btnClearAddTag);
		
		JButton btnAddTag = new JButton("Save");
		btnAddTag.setBackground(SystemColor.textHighlight);
		btnAddTag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String tagname= TagName.getText();
				String tagcode= TagCode.getText();
				String rtag = Rtag.getSelectedItem().toString();
				
if(TagName.getText().equals("")||TagCode.getText().equals("")|| Rtag.getSelectedItem().equals("")) {
					
					JOptionPane.showMessageDialog(null, "Please fill the form");
				}else {
				
				
				 try {
					 Connection con = DBConnect.connect();

	                    String query = "INSERT INTO tag values(null, '" + tagname + "','" + tagcode + "','" + rtag + "')";

	                    Statement sta = con.createStatement();
	                    int x = sta.executeUpdate(query);
	                    if (x == 0) {
	                        JOptionPane.showMessageDialog(btnAddTag, "This is alredy exist");
	                    } else {
	                        JOptionPane.showMessageDialog(btnAddTag,
	                            "Tag is sucessfully Added!");
	                    }
	                    con.close();
	                } catch (Exception exception) {
	                    exception.printStackTrace();
	                }
	                }
				
			}
		});
		btnAddTag.setBounds(748, 432, 89, 37);
		getFrame().getContentPane().add(btnAddTag);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
		frame.setResizable(false);
	}

}
