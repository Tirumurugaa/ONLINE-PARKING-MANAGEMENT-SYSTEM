package vehicleparking;

import java.awt.EventQueue;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
public class forgetpassword1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField userf;
	protected Object window;
	private JPasswordField newpass1;
	private JPasswordField confirmpass;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					forgetpassword1 frame = new forgetpassword1();
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
	public forgetpassword1() {
		setForeground(SystemColor.activeCaption);
		setBackground(SystemColor.activeCaption);
		setTitle("VehicleParking");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Tirumurugaa R S\\Downloads\\parking-icon-flat-style-isolated-on-white-background-free-vector.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1030, 559);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		rdbtnNewRadioButton_1 = new JRadioButton("show password");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton_1.isSelected()) {
					confirmpass.setEchoChar((char)0);
				}
				else{
					confirmpass.setEchoChar('*');
				}
			}
		});
		rdbtnNewRadioButton_1.setBounds(635, 264, 120, 21);
		contentPane.add(rdbtnNewRadioButton_1);
		
		rdbtnNewRadioButton = new JRadioButton("show password");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton.isSelected()) {
					newpass1.setEchoChar((char)0);
				}
				else{
					newpass1.setEchoChar('*');
				}
			}
		});
		rdbtnNewRadioButton.setBounds(635, 191, 120, 21);
		contentPane.add(rdbtnNewRadioButton);
		
		confirmpass = new JPasswordField();
		confirmpass.setFont(new Font("Tahoma", Font.BOLD, 16));
		confirmpass.setBounds(367, 218, 388, 40);
		contentPane.add(confirmpass);
		
		newpass1 = new JPasswordField();
		newpass1.setFont(new Font("Tahoma", Font.BOLD, 16));
		newpass1.setBounds(367, 145, 388, 40);
		contentPane.add(newpass1);
		
		JLabel lblNewLabel_1 = new JLabel("Confirm Password :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1.setBounds(114, 218, 236, 40);
		contentPane.add(lblNewLabel_1);
		
		userf = new JTextField();
		userf.setFont(new Font("Tahoma", Font.BOLD, 16));
		userf.setBounds(367, 75, 388, 40);
		contentPane.add(userf);
		userf.setColumns(10);
		
		JLabel newpass = new JLabel("New Password :");
		newpass.setFont(new Font("Tahoma", Font.BOLD, 22));
		newpass.setBounds(154, 145, 216, 40);
		contentPane.add(newpass);
		
		final JLabel user1 = new JLabel("Username :");
		user1.setFont(new Font("Tahoma", Font.BOLD, 22));
		user1.setBounds(207, 76, 150, 28);
		contentPane.add(user1);
		
		final JButton btnNewButton = new JButton("Confirm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				int i=1;
				String us1 = userf.getText();
				String np = newpass1.getText();	
				String cp = confirmpass.getText();
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con1 = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","tiru@2607");
				Statement st1 = con1.createStatement();
				String sql1 =  "Select * from access";
				ResultSet res1 = st1.executeQuery(sql1);
				while(res1.next()) {
					String use1 = res1.getString("username");
					System.out.print("1");
					if(us1.equals(use1) && np.equals(cp)) {
						String sql2 = "update access set password = '"+newpass1.getText()+"' where ID = '"+i+"'";
						PreparedStatement pts = con1.prepareStatement(sql2);
						System.out.print(np);
					    /*pts.setValueAt(np,sql2,0);
					    System.out.print(i);
						pts.setInt(1,i);
						System.out.println(sql2);*/
						System.out.println("2");
						pts.executeUpdate(sql2);
						System.out.print("success");
						JOptionPane.showMessageDialog(btnNewButton, " data updated", "updated", -1);
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
					else {
					     userf.setText("");
					     newpass1.setText("");
					     confirmpass.setText("");
					}
					i++;
				}
				}
				catch(Exception os)
				{
					System.out.print(os);
					JOptionPane.showMessageDialog(btnNewButton, this, "Error while establishing connection failed", 0);
				}
			}

			private String String(int i) {
				// TODO Auto-generated method stub
				return null;
			}
		});
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnNewButton.setBounds(421, 417, 180, 46);
		contentPane.add(btnNewButton);
		
		final JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					EXP2 newframe = new EXP2();
				    newframe.frmVehicleParking.setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton_1).dispose();
					
				}
				catch(Exception a)
				{
					JOptionPane.showMessageDialog(btnNewButton_1, this, "Error while establishing connection failed", 0);
				}
			}
		});
		btnNewButton_1.setForeground(SystemColor.text);
		btnNewButton_1.setBackground(SystemColor.textHighlight);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnNewButton_1.setBounds(114, 417, 108, 46);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(SystemColor.activeCaption);
		lblNewLabel.setBackground(SystemColor.activeCaption);
		lblNewLabel.setBounds(10, 10, 1235, 522);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_1.setBounds(114, 284, 236, 40);
		contentPane.add(lblNewLabel_1_1);
	}
}
