package vehicleparking;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JButton;

public class adminsignup extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private int counter;
	private Timer tm;
	private JLabel lblNewJgoodiesLabel;
	private JLabel lblPassword;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminsignup frame = new adminsignup();
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
	public adminsignup() {
		setTitle("AdminSignup");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 921, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new adminlogin().setVisible(true);
				SwingUtilities.windowForComponent(btnNewButton).dispose();
			}
		});
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.setBounds(33, 396, 97, 45);
		contentPane.add(btnNewButton);
		
		JButton btnSignUp = new JButton("Sign up");
		btnSignUp.addActionListener(new ActionListener() {
			private int yi;
			private int ty;

			public void actionPerformed(ActionEvent e) {
				try {
					int i=1,c=0;
					String nu = textField.getText();
					String np = passwordField.getText();	
					if(passwordField.getText().equals("")) {
						ty=1;
					}
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con1 = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","tiru@2607");
					Statement st1 = con1.createStatement();
					
					String sql1 =  "Select * from adminaccess";
					ResultSet res1 = st1.executeQuery(sql1);
					System.out.println("1");
					
					System.out.println("2");
					String sql2 = "select count(*) as count from adminaccess";
					System.out.println("3");
					PreparedStatement ps2 = con1.prepareStatement(sql2);
					System.out.println("4");
					ResultSet res2 = ps2.executeQuery();
					System.out.println("5");
					while(res2.next())
					{ c = res2.getInt(1);
					 System.out.print(c);
					 }
					 c=c+1;
					 System.out.print(c);
					while(res1.next()) {
						
						String use1 = res1.getString("username");
						System.out.print("1");
						if(nu!=use1&&ty==0) {
							yi=0;
							String sql3 = "insert into adminaccess values("+c+",'"+nu+"','"+np+"')";
							PreparedStatement pts = con1.prepareStatement(sql3);
							System.out.print(np);
						    /*pts.setValueAt(np,sql2,0);
						    System.out.print(i);
							pts.setInt(1,i);
							System.out.println(sql2);*/
							System.out.println("2");
							pts.executeUpdate(sql3);
							System.out.print("success");
							JOptionPane.showMessageDialog(btnSignUp, " data created", "created", -1);
							try {
								adminlogin newframe = new adminlogin();
							    newframe.setVisible(true);
								SwingUtilities.windowForComponent(btnSignUp).dispose();
								
							}
							catch(Exception a)
							{
								JOptionPane.showMessageDialog(btnSignUp, this, "Error while establishing connection failed", 0);
							}
						}
						else {
							yi=1;
							textField.setText("");
						     passwordField.setText("");
						     
						}
						i++;
					}
					if(yi==1) {
						JOptionPane.showMessageDialog(btnSignUp, "not entered", "error", 0);
					}
					}
					catch(Exception os)
					{   
						JOptionPane.showMessageDialog(btnSignUp, "Username already exist", "Change", -1);
						System.out.print(os);
						
					}
			}
		});
		btnSignUp.setForeground(SystemColor.text);
		btnSignUp.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSignUp.setBackground(SystemColor.textHighlight);
		btnSignUp.setBounds(382, 320, 146, 34);
		contentPane.add(btnSignUp);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Show password");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton.isSelected()) {
					passwordField.setEchoChar((char)0);
				}
				else{
					passwordField.setEchoChar('*');
				}
			}
		});
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		rdbtnNewRadioButton.setBackground(SystemColor.text);
		rdbtnNewRadioButton.setBounds(550, 199, 146, 21);
		contentPane.add(rdbtnNewRadioButton);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 16));
		passwordField.setBackground(SystemColor.activeCaption);
		passwordField.setBounds(356, 167, 340, 26);
		contentPane.add(passwordField);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 16));
		textField.setColumns(10);
		textField.setBackground(SystemColor.activeCaption);
		textField.setBounds(356, 108, 340, 26);
		contentPane.add(textField);
		
		lblPassword = new JLabel("PASSWORD  :");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPassword.setBackground(Color.WHITE);
		lblPassword.setBounds(204, 167, 146, 26);
		contentPane.add(lblPassword);
		
		lblNewJgoodiesLabel = new JLabel(" USERNAME  :");
		lblNewJgoodiesLabel.setForeground(Color.BLACK);
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewJgoodiesLabel.setBackground(Color.WHITE);
		lblNewJgoodiesLabel.setBounds(204, 106, 146, 26);
		contentPane.add(lblNewJgoodiesLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PASSWORD :");
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Tirumurugaa R S\\Downloads\\white (1).jpg"));
		lblNewLabel_1.setBounds(179, 54, 545, 350);
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
	}
}
