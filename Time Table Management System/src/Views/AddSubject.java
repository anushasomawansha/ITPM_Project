package Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import DBConnect.DBConnect;

import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;
import java.awt.SystemColor;

public class AddSubject {

	private JFrame frame;
	private JTextField tfSubName;
	private JTextField tfSubCode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddSubject window = new AddSubject();
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
	public AddSubject() {
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
		
		JButton btnAddSubject = new JButton("Add Subject");
		btnAddSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
					AddSubject addSubject = new AddSubject();
					try {
						AddSubject.main(null);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					frame.setVisible(false);
				}
			
		});
		btnAddSubject.setForeground(Color.WHITE);
		btnAddSubject.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddSubject.setBackground(new Color(0, 139, 139));
		btnAddSubject.setBounds(10, 103, 230, 57);
		panel.add(btnAddSubject);
		
		JButton btnManegeSubject = new JButton("Manage Subject");
		btnManegeSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ManageSubjects addSubject = new ManageSubjects();
				try {
					ManageSubjects.main(null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setVisible(false);
			}

		});
		btnManegeSubject.setForeground(Color.WHITE);
		btnManegeSubject.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnManegeSubject.setBackground(new Color(0, 139, 139));
		btnManegeSubject.setBounds(10, 165, 230, 57);
		panel.add(btnManegeSubject);
		
		JLabel lblAddSubject = new JLabel("Add Subjects");
		lblAddSubject.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblAddSubject.setBounds(278, 30, 381, 37);
		frame.getContentPane().add(lblAddSubject);
		
		JLabel lblOffer = new JLabel("Offered year");
		lblOffer.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblOffer.setBounds(290, 127, 116, 28);
		frame.getContentPane().add(lblOffer);
		
		JLabel lblOfferedSemester = new JLabel("Offered semester");
		lblOfferedSemester.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblOfferedSemester.setBounds(290, 184, 116, 28);
		frame.getContentPane().add(lblOfferedSemester);
		
		JLabel lblSubjectName = new JLabel("Subject name");
		lblSubjectName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSubjectName.setBounds(290, 238, 116, 28);
		frame.getContentPane().add(lblSubjectName);
		
		JLabel lblName = new JLabel("Subject code");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblName.setBounds(290, 295, 116, 28);
		frame.getContentPane().add(lblName);
		
		JComboBox cbOfferedYear = new JComboBox();
		cbOfferedYear.setModel(new DefaultComboBoxModel(new String[] {"Select", "1st Year", "2nd Year", "3rd Year", "4th Year"}));
		cbOfferedYear.setForeground(Color.BLACK);
		cbOfferedYear.setBackground(Color.WHITE);
		cbOfferedYear.setBounds(435, 132, 145, 20);
		frame.getContentPane().add(cbOfferedYear);
		
		tfSubName = new JTextField();
		tfSubName.setColumns(10);
		tfSubName.setBounds(435, 243, 138, 20);
		frame.getContentPane().add(tfSubName);
		
		tfSubCode = new JTextField();
		tfSubCode.setColumns(10);
		tfSubCode.setBounds(435, 300, 138, 20);
		frame.getContentPane().add(tfSubCode);
		
		JRadioButton rbSem1 = new JRadioButton("1st");
		rbSem1.setFont(new Font("Tahoma", Font.BOLD, 11));
		rbSem1.setBackground(Color.LIGHT_GRAY);
		rbSem1.setBounds(435, 189, 67, 23);
		frame.getContentPane().add(rbSem1);
		
		JRadioButton rbSem2 = new JRadioButton("2nd");
		rbSem2.setFont(new Font("Tahoma", Font.BOLD, 11));
		rbSem2.setBackground(Color.LIGHT_GRAY);
		rbSem2.setBounds(518, 189, 75, 23);
		frame.getContentPane().add(rbSem2);
		
		JLabel lblNumberOfLecturer = new JLabel("Number of lecture hours");
		lblNumberOfLecturer.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNumberOfLecturer.setBounds(685, 127, 159, 28);
		frame.getContentPane().add(lblNumberOfLecturer);
		
		JLabel lblNumberOfTutorials = new JLabel("Number of tutorials hours");
		lblNumberOfTutorials.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNumberOfTutorials.setBounds(685, 184, 174, 28);
		frame.getContentPane().add(lblNumberOfTutorials);
		
		JLabel lblNumberOfLab = new JLabel("Number of lab hours");
		lblNumberOfLab.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNumberOfLab.setBounds(685, 238, 145, 28);
		frame.getContentPane().add(lblNumberOfLab);
		
		JLabel lblNumberOfEvalution = new JLabel("Number of evalution hours");
		lblNumberOfEvalution.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNumberOfEvalution.setBounds(685, 295, 174, 28);
		frame.getContentPane().add(lblNumberOfEvalution);
		
		JSpinner spLecHours = new JSpinner();
		spLecHours.setModel(new SpinnerNumberModel(0, 0, 5, 1));
		spLecHours.setBounds(889, 132, 94, 20);
		frame.getContentPane().add(spLecHours);
		
		JSpinner spTutHours = new JSpinner();
		spTutHours.setModel(new SpinnerNumberModel(0, 0, 5, 1));
		spTutHours.setBounds(889, 189, 94, 20);
		frame.getContentPane().add(spTutHours);
		
		JSpinner spLabHours = new JSpinner();
		spLabHours.setModel(new SpinnerNumberModel(0, 0, 5, 1));
		spLabHours.setBounds(889, 246, 94, 20);
		frame.getContentPane().add(spLabHours);
		
		JSpinner spEvalHours = new JSpinner();
		spEvalHours.setModel(new SpinnerNumberModel(0, 0, 5, 1));
		spEvalHours.setBounds(889, 300, 94, 20);
		frame.getContentPane().add(spEvalHours);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBackground(SystemColor.textHighlight);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfSubName.setText(null);
				tfSubCode.setText(null);
				rbSem1.setSelected(false);
				rbSem2.setSelected(false);
				cbOfferedYear.setSelectedIndex(0);
				spLecHours.setValue(new Integer(0));
				spTutHours.setValue(new Integer(0));
				spLabHours.setValue(new Integer(0));
				spEvalHours.setValue(new Integer(0));
				
			}
		});
		btnClear.setBounds(748, 437, 89, 37);
		frame.getContentPane().add(btnClear);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBackground(SystemColor.textHighlight);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 String Semester=null;
					
					String offerfYear=cbOfferedYear.getSelectedItem().toString();
					String subName=tfSubName.getText();
					String subCode=tfSubCode.getText();
					String semester = null;
					
					if(rbSem1.isSelected()) {
						semester = "1st Semester";
					}
					else if(rbSem2.isSelected()) {
						semester = "2nd Semester";
					}
					
					
					
					String lecHours= spLecHours.getValue().toString();
					String tutHours= spTutHours.getValue().toString();
					String labHours= spLabHours.getValue().toString();
					String evalHours= spEvalHours.getValue().toString();
					
					
					
					if(cbOfferedYear.getSelectedIndex()==0) {
						JOptionPane.showMessageDialog(null, "Select Offered Year!");
					}else if(semester==null){
						JOptionPane.showMessageDialog(null, "Please Select Semester!");
					}else if(tfSubName.getText().equals("")){
						JOptionPane.showMessageDialog(null, "Please Enter Subject Name!");
					}
					else if(tfSubCode.getText().equals("")){
						JOptionPane.showMessageDialog(null, "Please Enter Code!");
					}
					else {
					
					try {
						 Connection con = DBConnect.connect();
						 
						 String query = "INSERT INTO subjects values(null, '" + offerfYear + "','" + semester + "','" + subName + "','" +
								 subCode + "','" + lecHours + "','" + tutHours + "','"+ labHours +"','"+ evalHours +"')";
						 
		                  Statement sta = con.createStatement();
		                    int x = sta.executeUpdate(query);
		                   if (x == 0) {
		                        JOptionPane.showMessageDialog(btnSave, "This is alredy exist");
		                    } else {
		                        JOptionPane.showMessageDialog(btnSave,"Subject details successfuly added!");
		                    }
		                    con.close();
		                    tfSubName.setText(null);
		    				tfSubCode.setText(null);
		    				rbSem1.setSelected(false);
		    				rbSem2.setSelected(false);
		    				cbOfferedYear.setSelectedIndex(0);
		    				spLecHours.setValue(new Integer(0));
		    				spTutHours.setValue(new Integer(0));
		    				spLabHours.setValue(new Integer(0));
		    				spEvalHours.setValue(new Integer(0));
		                } catch (Exception exception) {
		                    exception.printStackTrace();
		                    
		                }
					}
			}
		});
		btnSave.setBounds(867, 437, 89, 37);
		frame.getContentPane().add(btnSave);
	}

}
