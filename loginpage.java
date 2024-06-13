package vehicleparking;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

//import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EXP2 {

	JFrame frmVehicleParking;
	private JTextField user;
	private JPasswordField pass;
	private JLabel error;
	private JRadioButton rdbtnNewRadioButton;
	public static int ID;
    public String us;
    private Timer tm;
	private int counter;
	private JLabel lblNewLabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EXP2 window = new EXP2();
					window.frmVehicleParking.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EXP2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmVehicleParking = new JFrame();
		frmVehicleParking.setForeground(SystemColor.activeCaption);
		frmVehicleParking.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Tirumurugaa R S\\Downloads\\parking-icon-flat-style-isolated-on-white-background-free-vector.jpg"));
		frmVehicleParking.setBackground(SystemColor.activeCaption);
		frmVehicleParking.getContentPane().setBackground(new Color(255, 255, 255));
		frmVehicleParking.setTitle("Vehicle Parking");
		frmVehicleParking.setBounds(100, 100, 1098, 621);
		frmVehicleParking.setResizable(false);
		frmVehicleParking.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVehicleParking.getContentPane().setLayout(null);
		
		user = new JTextField();
		user.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("Admin Login");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				adminlogin nf1 = new adminlogin();
				nf1.setVisible(true);
				SwingUtilities.windowForComponent(lblNewLabel_2).dispose();
			}
		});
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setForeground(new Color(153, 50, 204));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(456, 419, 168, 63);
		frmVehicleParking.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("PARKING SPACE MANAGEMENT SYSTEM");
		lblNewLabel_1.setForeground(new Color(245, 245, 245));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setBounds(310, 26, 512, 63);
		frmVehicleParking.getContentPane().add(lblNewLabel_1);
		user.setBackground(SystemColor.activeCaption);
		user.setFont(new Font("Tahoma", Font.BOLD, 16));
		user.setBounds(413, 117, 340, 26);
		frmVehicleParking.getContentPane().add(user);
		user.setColumns(10);
		
		pass = new JPasswordField();
		pass.setFont(new Font("Tahoma", Font.BOLD, 16));
		pass.setBackground(SystemColor.activeCaption);
		pass.setBounds(413, 185, 340, 26);
		frmVehicleParking.getContentPane().add(pass);
		
		JLabel lblNewJgoodiesLabel = new JLabel(" USERNAME  :");
		lblNewJgoodiesLabel.setBackground(Color.WHITE);
		lblNewJgoodiesLabel.setIcon(null);
		lblNewJgoodiesLabel.setForeground(Color.BLACK);
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewJgoodiesLabel.setLabelFor(user);
		lblNewJgoodiesLabel.setBounds(267, 117, 146, 26);
		frmVehicleParking.getContentPane().add(lblNewJgoodiesLabel);
		
		JLabel lblNewJgoodiesLabel_1 = new JLabel("PASSWORD :");
		lblNewJgoodiesLabel_1.setForeground(Color.BLACK);
		lblNewJgoodiesLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewJgoodiesLabel_1.setLabelFor(pass);
		lblNewJgoodiesLabel_1.setBounds(275, 185, 138, 26);
		frmVehicleParking.getContentPane().add(lblNewJgoodiesLabel_1);
		
		final JButton btnNewButton = new JButton("LOG IN");
		btnNewButton.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
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
					String sql = "Select * from access";
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
					new page1().setVisible(true);
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
				}
			}

		});
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(456, 298, 146, 34);
		frmVehicleParking.getContentPane().add(btnNewButton);
		
		final JButton btnNewButton_1 = new JButton("Forget Password");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					new verification().setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton_1).dispose();
				}
				catch(Exception f) {
					JOptionPane.showMessageDialog(btnNewButton_1, this, "Error while establishing connection failed", 0);
				}
				}
				
				
			
		});
		btnNewButton_1.setForeground(SystemColor.text);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnNewButton_1.setBackground(SystemColor.textHighlight);
		btnNewButton_1.setBounds(94, 448, 245, 26);
		frmVehicleParking.getContentPane().add(btnNewButton_1);
		
		final JButton btnNewButton_2 = new JButton("Sign In/Sign Up");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					new signinpage().setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton_2).dispose();
				}
				catch(Exception f) {
					
					JOptionPane.showMessageDialog(btnNewButton_2, this, "Error while establishing connection failed", 0);
				}
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnNewButton_2.setForeground(SystemColor.text);
		btnNewButton_2.setBackground(SystemColor.textHighlight);
		btnNewButton_2.setBounds(725, 448, 251, 26);
		frmVehicleParking.getContentPane().add(btnNewButton_2);
		
		lblNewLabel = new JLabel();
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.addFocusListener(new FocusAdapter() {
			
		});
		
		error = new JLabel("");
		error.setForeground(Color.RED);
		error.setFont(new Font("Tahoma", Font.PLAIN, 15));
		error.setBackground(Color.RED);
		error.setBounds(413, 227, 340, 26);
		frmVehicleParking.getContentPane().add(error);
		
		rdbtnNewRadioButton = new JRadioButton("Show password");
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
		rdbtnNewRadioButton.setBounds(759, 187, 146, 21);
		frmVehicleParking.getContentPane().add(rdbtnNewRadioButton);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Tirumurugaa R S\\Downloads\\empty-garage-with-parking-lots-with-concrete-ceiling-flooring-pillars-marked-with-numbers.jpg"));
		lblNewLabel.setBounds(-1178, -2274, 6769, 4480);
		frmVehicleParking.getContentPane().add(lblNewLabel);
		counter  = 0;
		//
		tm = new Timer(2000,new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(counter%3==0) {
					lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Tirumurugaa R S\\Downloads\\abstract-blur-car-parking-lot-background-blur-parking-with-cars-blurred-underground-parking-lot-with (1).jpg"));
					System.out.println(counter);
					counter++;
				}
				else if(counter%3==1) {
					lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Tirumurugaa R S\\Downloads\\wp3218567.jpg"));
					System.out.println(counter);
					counter++;
				}
				else if(counter%3==2) {
					lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Tirumurugaa R S\\Downloads\\empty-garage-with-parking-lots-with-concrete-ceiling-flooring-pillars-marked-with-numbers.jpg"));
					System.out.println(counter);
					counter++;
				}
				else {
					
				}
				
			}
		});
		tm.start();
		
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
