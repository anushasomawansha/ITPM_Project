package Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;

public class DashBoard {

	private JFrame frame;
	private JLabel lblNewLabel_2 ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashBoard window = new DashBoard();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void clock() {
		
		Thread clock=new Thread() {
			public void run() {
				try {
					for(;;) {
					Calendar cal=new GregorianCalendar();
					int day=cal.get(Calendar.DAY_OF_MONTH);
					int month=cal.get(Calendar.MONTH);
					int year=cal.get(Calendar.YEAR);
					
					int second=cal.get(Calendar.SECOND);
					int minute=cal.get(Calendar.MINUTE);
					int hour=cal.get(Calendar.HOUR);
					
					lblNewLabel_2.setText("Time - "+hour+":"+minute+":"+second+"  Date - "+year+"/"+month+"/"+day);
					sleep(1000);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		clock.start();
	}

	/**
	 * Create the application.
	 */
	public DashBoard() {
		initialize();
		clock();
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
		panel.setBounds(0, 0, 301, 661);
		frame.getContentPane().add(panel);
		
		JButton btnAddTags = new JButton("Student Groups");
		btnAddTags.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AddStudentGroups itm = new AddStudentGroups();
				AddStudentGroups.main(null);
				frame.setVisible(false);
				
			}
		});
		btnAddTags.setForeground(Color.WHITE);
		btnAddTags.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddTags.setBackground(new Color(0, 139, 139));
		btnAddTags.setBounds(34, 206, 230, 54);
		panel.add(btnAddTags);
		
		JButton btnManegeTag = new JButton("Subjects");
		btnManegeTag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddSubject itm = new AddSubject();
				AddSubject.main(null);
				frame.setVisible(false);
		
			}
		});
		btnManegeTag.setForeground(Color.WHITE);
		btnManegeTag.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnManegeTag.setBackground(new Color(0, 139, 139));
		btnManegeTag.setBounds(34, 141, 230, 54);
		panel.add(btnManegeTag);
		
		JButton btnManegeTag_1 = new JButton("Working Details");
		btnManegeTag_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddWorkingDays itm = new AddWorkingDays();
				AddWorkingDays.main(null);
				frame.setVisible(false);
				
			}
		});
		btnManegeTag_1.setForeground(Color.WHITE);
		btnManegeTag_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnManegeTag_1.setBackground(new Color(0, 139, 139));
		btnManegeTag_1.setBounds(34, 11, 230, 54);
		panel.add(btnManegeTag_1);
		
		JButton btnManegeTag_3 = new JButton("Tags");
		btnManegeTag_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AddTag itm = new AddTag();
				AddTag.main(null);
				frame.setVisible(false);
				
			}
		});
		btnManegeTag_3.setForeground(Color.WHITE);
		btnManegeTag_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnManegeTag_3.setBackground(new Color(0, 139, 139));
		btnManegeTag_3.setBounds(34, 271, 230, 54);
		panel.add(btnManegeTag_3);
		
		JButton btnManegeTag_4 = new JButton("Sessions");
		btnManegeTag_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddSession itm = new AddSession();
				AddSession.main(null);
				frame.setVisible(false);
			}
		});
		btnManegeTag_4.setForeground(Color.WHITE);
		btnManegeTag_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnManegeTag_4.setBackground(new Color(0, 139, 139));
		btnManegeTag_4.setBounds(34, 401, 230, 54);
		panel.add(btnManegeTag_4);
		
		JButton btnManegeTag_6 = new JButton("Session Rooms");
		btnManegeTag_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AddSessionRooms itm = new AddSessionRooms();
				AddSessionRooms.main(null);
				frame.setVisible(false);
			}
		});
		btnManegeTag_6.setForeground(Color.WHITE);
		btnManegeTag_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnManegeTag_6.setBackground(new Color(0, 139, 139));
		btnManegeTag_6.setBounds(34, 466, 230, 54);
		panel.add(btnManegeTag_6);
		
		JButton btnManegeTag_6_1 = new JButton("Generate Time Table");
		btnManegeTag_6_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GenerateTimeTable itm = new GenerateTimeTable();
				GenerateTimeTable.main(null);
				frame.setVisible(false);
			}
		});
		btnManegeTag_6_1.setForeground(Color.WHITE);
		btnManegeTag_6_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnManegeTag_6_1.setBackground(new Color(0, 139, 139));
		btnManegeTag_6_1.setBounds(34, 595, 230, 54);
		panel.add(btnManegeTag_6_1);
		
		JButton btnLecturer = new JButton("Lecturer");
		btnLecturer.setBounds(34, 76, 230, 54);
		panel.add(btnLecturer);
		btnLecturer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddLecturers itm = new AddLecturers();
				AddLecturers.main(null);
				frame.setVisible(false);
			}
		});
		btnLecturer.setForeground(Color.WHITE);
		btnLecturer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLecturer.setBackground(new Color(0, 139, 139));
		
		JButton btnManegeTag_2 = new JButton("Locations");
		btnManegeTag_2.setBounds(34, 336, 230, 54);
		panel.add(btnManegeTag_2);
		btnManegeTag_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AddLocation itm = new AddLocation();
				AddLocation.main(null);
				frame.setVisible(false);
				
			}
		});
		btnManegeTag_2.setForeground(Color.WHITE);
		btnManegeTag_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnManegeTag_2.setBackground(new Color(0, 139, 139));
		
		JButton btnManegeTag_6_1_1 = new JButton("Not Available Time");
		btnManegeTag_6_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NotAvailableTime itm = new NotAvailableTime();
				NotAvailableTime.main(null);
				frame.setVisible(false);
			}
		});
		btnManegeTag_6_1_1.setForeground(Color.WHITE);
		btnManegeTag_6_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnManegeTag_6_1_1.setBackground(new Color(0, 139, 139));
		btnManegeTag_6_1_1.setBounds(34, 530, 230, 54);
		panel.add(btnManegeTag_6_1_1);
		
		JLabel lblNewLabel = new JLabel("TIME TABLE MANAGEMENT SYSTEM");
		lblNewLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 30));
		lblNewLabel.setBounds(444, 81, 609, 101);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblAbcInstitute = new JLabel("ABC INSTITUTE");
		lblAbcInstitute.setFont(new Font("Baskerville Old Face", Font.BOLD, 30));
		lblAbcInstitute.setBounds(607, 176, 273, 99);
		frame.getContentPane().add(lblAbcInstitute);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(627, 286, 225, 225);
		frame.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("/db.png")));
		
		 lblNewLabel_2 = new JLabel("Clock");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(556, 506, 432, 114);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
