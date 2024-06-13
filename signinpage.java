package vehicleparking;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;

public class signinpage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JTextField newuser = new JTextField();
	private JPasswordField newpass;
	private JRadioButton rdbtnNewRadioButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signinpage frame = new signinpage();
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
	public signinpage() {
		setTitle("VehicleParking");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Tirumurugaa R S\\Downloads\\parking-icon-flat-style-isolated-on-white-background-free-vector.jpg"));
		setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1025, 602);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel user1 = new JLabel("Username :");
		user1.setFont(new Font("Tahoma", Font.BOLD, 22));
		user1.setBounds(226, 90, 150, 28);
		contentPane.add(user1);
		newuser.setFont(new Font("Tahoma", Font.BOLD, 16));
		newuser.setBounds(407, 92, 293, 36);
		contentPane.add(newuser);
		newuser.setColumns(10);
		
		JLabel newuserpass = new JLabel("Password :");
		newuserpass.setFont(new Font("Tahoma", Font.BOLD, 22));
		newuserpass.setBounds(226, 188, 150, 28);
		contentPane.add(newuserpass);
		
		final JButton signin = new JButton("Sign In");
		signin.addActionListener(new ActionListener() {
			
			private int ty=0;
			private int yi;

			public void actionPerformed(ActionEvent e) {
				try {
					int i=1,c=0;
					String nu = newuser.getText();
					String np = newpass.getText();	
					if(newuser.getText().equals("")) {
						ty=1;
					}
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con1 = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","tiru@2607");
					Statement st1 = con1.createStatement();
					
					String sql1 =  "Select * from access";
					ResultSet res1 = st1.executeQuery(sql1);
					System.out.println("1");
					
					System.out.println("2");
					String sql2 = "select count(*) as count from access";
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
							String sql3 = "insert into access values("+c+",'"+nu+"','"+np+"')";
							PreparedStatement pts = con1.prepareStatement(sql3);
							System.out.print(np);
						    /*pts.setValueAt(np,sql2,0);
						    System.out.print(i);
							pts.setInt(1,i);
							System.out.println(sql2);*/
							System.out.println("2");
							pts.executeUpdate(sql3);
							System.out.print("success");
							JOptionPane.showMessageDialog(signin, " data created", "created", -1);
							try {
								EXP2 newframe = new EXP2();
							    newframe.frmVehicleParking.setVisible(true);
								SwingUtilities.windowForComponent(signin).dispose();
								
							}
							catch(Exception a)
							{
								JOptionPane.showMessageDialog(signin, this, "Error while establishing connection failed", 0);
							}
						}
						else {
							yi=1;
						     newuser.setText("");
						     newpass.setText("");
						     
						}
						i++;
					}
					if(yi==1) {
						JOptionPane.showMessageDialog(signin, "not entered", "error", 0);
					}
					}
					catch(Exception os)
					{   
						JOptionPane.showMessageDialog(signin, "Username already exist", "Change", -1);
						System.out.print(os);
						
					}
			}
		});
		signin.setForeground(SystemColor.text);
		signin.setBackground(SystemColor.textHighlight);
		signin.setFont(new Font("Tahoma", Font.BOLD, 22));
		signin.setBounds(372, 363, 225, 45);
		contentPane.add(signin);
		
		final JButton btnNewButton = new JButton("BACK");
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					EXP2 newframe = new EXP2();
				    newframe.frmVehicleParking.setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton).dispose();
					
				}
				catch(Exception a)
				{
					JOptionPane.showMessageDialog(btnNewButton, this, "Error while establishing connection failed", 0);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(109, 363, 97, 45);
		contentPane.add(btnNewButton);
		
		newpass = new JPasswordField();
		newpass.setFont(new Font("Tahoma", Font.BOLD, 16));
		newpass.setBounds(407, 188, 293, 40);
		contentPane.add(newpass);
		
		rdbtnNewRadioButton_1 = new JRadioButton("show password");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton_1.isSelected()) {
					newpass.setEchoChar((char)0);
				}
				else{
					newpass.setEchoChar('*');
				}
			}
		});
		rdbtnNewRadioButton_1.setBounds(588, 234, 112, 21);
		contentPane.add(rdbtnNewRadioButton_1);
	}
}
