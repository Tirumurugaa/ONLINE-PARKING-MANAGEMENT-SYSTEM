package vehicleparking;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import java.awt.SystemColor;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class adminlogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField user;
	private JPasswordField passwordField;
	private JPasswordField pass;
	private JLabel error;
	private ImageIcon[] images = new ImageIcon[3];
	private String[] im = {"C:\\Users\\Tirumurugaa R S\\Downloads\\blurred-car-parking-lot-with-many-cars-abstract-background-free-photo.jpg","C:\\Users\\Tirumurugaa R S\\Downloads\\pngtree-night-cars-parked-in-an-empty-parking-lot-picture-image_2601314.jpg","C:\\Users\\Tirumurugaa R S\\Downloads\\4327615.jpg"};
	private JLabel lblNewLabel;
	private int counter;
	private ActionListener lis;
	Timer tm;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminlogin frame = new adminlogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public adminlogin() {
		setTitle("AdminLogin");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Tirumurugaa R S\\Downloads\\parking-icon-flat-style-isolated-on-white-background-free-vector.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 921, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("Sign In/Sign Up");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminsignup fg = new adminsignup();
				fg.setVisible(true);
				SwingUtilities.windowForComponent(btnNewButton_2).dispose();
			}
		});
		
		JButton btnNewButton_3 = new JButton("BACK");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					EXP2 newframe = new EXP2();
				    newframe.frmVehicleParking.setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton_3).dispose();
					
				}
				catch(Exception a)
				{
					JOptionPane.showMessageDialog(btnNewButton_3, this, "Error while establishing connection failed", 0);
				}
			}});
		btnNewButton_3.setBounds(750, 10, 85, 21);
		contentPane.add(btnNewButton_3);
		btnNewButton_2.setForeground(SystemColor.text);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnNewButton_2.setBackground(SystemColor.textHighlight);
		btnNewButton_2.setBounds(603, 408, 251, 26);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Forget Password");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Adminmail ng = new Adminmail();
				ng.setVisible(true);
				SwingUtilities.windowForComponent(btnNewButton_1).dispose();
			}
		});
		btnNewButton_1.setForeground(SystemColor.text);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnNewButton_1.setBackground(SystemColor.textHighlight);
		btnNewButton_1.setBounds(44, 408, 245, 26);
		contentPane.add(btnNewButton_1);
		error = new JLabel("");
		error.setForeground(Color.RED);
		error.setFont(new Font("Tahoma", Font.PLAIN, 15));
		error.setBackground(Color.RED);
		error.setBounds(294, 258, 340, 26);
		contentPane.add(error);
		
		JButton btnNewButton = new JButton("LOG IN");
		btnNewButton.addActionListener(new ActionListener() {
			private int ID;

			public void actionPerformed(ActionEvent e) {
				//
				try {
					int er = 0;
					String us = user.getText();
					String ps = pass.getText();
					System.out.println(us);
					Class.forName("com.mysql.cj.jdbc.Driver");


					System.out.println(ps);
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","tiru@2607");
					System.out.println("1");
					Statement st = con.createStatement();
					System.out.println("1");
					String sql = "Select * from adminaccess";
					System.out.println("1");
					ResultSet rs = st.executeQuery(sql);
					System.out.println("1");
					System.out.println(rs == null);
					
					while(rs.next()){
					ID = rs.getInt("ID");
					System.out.println(ID);
					String username = rs.getString("username");
					System.out.println("1-");
					System.out.println(username);
					String password = rs.getString("password");
					System.out.println(password);
					System.out.println("1-");
					if(error.isEnabled()) {
						System.out.println("In");
						error.setVisible(false);
					}
                    if(us.equals(username) && ps.equals(password) && us!=null ){
					new Adminpage().setVisible(true);
					System.out.println("true");
					SwingUtilities.windowForComponent(btnNewButton).dispose();
					er = 0;
					break;
					}
					else{
					user.setText("");
					pass.setText("");
					System.out.println("false");
					er = 1;
					
					}
					
				}
					if(er == 1) {
						error.setVisible(true);
						error.setText("Incorrect Password of Username");	
					}
					}
				catch(Exception o) {
					JOptionPane.showMessageDialog(btnNewButton, this, "Error while establishing connection failed", 0);
					o.printStackTrace();
				}
				
				
				
				
				//
			}
		});
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.setBounds(388, 310, 146, 34);
		contentPane.add(btnNewButton);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Show password");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton.isSelected()) {
					pass.setEchoChar((char)0);
				}
				else{
					pass.setEchoChar('*');
				}
			}
		});
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		rdbtnNewRadioButton.setBackground(SystemColor.text);
		rdbtnNewRadioButton.setBounds(552, 218, 146, 21);
		contentPane.add(rdbtnNewRadioButton);
		
		pass = new JPasswordField();
		pass.setFont(new Font("Tahoma", Font.BOLD, 16));
		pass.setBackground(SystemColor.activeCaption);
		pass.setBounds(358, 186, 340, 26);
		contentPane.add(pass);
		
		user = new JTextField();
		user.setFont(new Font("Tahoma", Font.BOLD, 16));
		user.setColumns(10);
		user.setBackground(SystemColor.activeCaption);
		user.setBounds(358, 122, 340, 26);
		contentPane.add(user);
		
		JLabel lblNewJgoodiesLabel_1 = new JLabel("PASSWORD :");
		lblNewJgoodiesLabel_1.setForeground(Color.BLACK);
		lblNewJgoodiesLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewJgoodiesLabel_1.setBounds(217, 186, 138, 26);
		contentPane.add(lblNewJgoodiesLabel_1);
		
		JLabel lblNewJgoodiesLabel = new JLabel(" USERNAME  :");
		lblNewJgoodiesLabel.setForeground(Color.BLACK);
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewJgoodiesLabel.setBackground(Color.WHITE);
		lblNewJgoodiesLabel.setBounds(209, 122, 146, 26);
		contentPane.add(lblNewJgoodiesLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Tirumurugaa R S\\Downloads\\white (1).jpg"));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(184, 85, 545, 296);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Tirumurugaa R S\\Downloads\\4327615.jpg"));
		lblNewLabel.setBounds(-32, 0, 939, 464);
		contentPane.add(lblNewLabel);
		//lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Tirumurugaa R S\\Downloads\\AdminBackground.jpg"));
		counter  = 0;
		//
		tm = new Timer(2000,new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(counter%3==0) {
					lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Tirumurugaa R S\\Downloads\\AdminBackground.jpg"));
					System.out.println(counter);
					counter++;
				}
				else if(counter%3==1) {
					lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Tirumurugaa R S\\Downloads\\pngtree-night-cars-parked-in-an-empty-parking-lot-picture-image_2601314.jpg"));
					System.out.println(counter);
					counter++;
				}
				else if(counter%3==2) {
					lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Tirumurugaa R S\\Downloads\\4327615.jpg"));
					System.out.println(counter);
					counter++;
				}
				else {
					
				}
				
			}
		});
		tm.start();
		
		
		
		//
	}
}

