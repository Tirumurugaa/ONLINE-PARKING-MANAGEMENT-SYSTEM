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
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class adminforgetpass extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private int counter;
	private Timer tm;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminforgetpass frame = new adminforgetpass();
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
	public adminforgetpass() {
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
		btnNewButton.setBounds(39, 396, 97, 45);
		contentPane.add(btnNewButton);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int i=1;
					String us1 = textField.getText();
					String np = passwordField.getText();	
					String cp = passwordField_1.getText();
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con1 = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","tiru@2607");
					Statement st1 = con1.createStatement();
					String sql1 =  "Select * from access";
					ResultSet res1 = st1.executeQuery(sql1);
					while(res1.next()) {
						String use1 = res1.getString("username");
						System.out.print("1");
						if(us1.equals(use1) && np.equals(cp)) {
							String sql2 = "update adminaccess set password = '"+passwordField.getText()+"' where ID = '"+i+"'";
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
								adminlogin newframe = new adminlogin();
							    newframe.setVisible(true);
								SwingUtilities.windowForComponent(btnNewButton).dispose();
								
							}
							catch(Exception a)
							{
								JOptionPane.showMessageDialog(btnNewButton, this, "Error while establishing connection failed", 0);
							}
						}
						else {
							textField.setText("");
							passwordField.setText("");
							passwordField_1.setText("");
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

				
			
		});
		btnUpdate.setForeground(SystemColor.text);
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUpdate.setBackground(SystemColor.textHighlight);
		btnUpdate.setBounds(385, 318, 146, 34);
		contentPane.add(btnUpdate);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Show password");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton_1.isSelected()) {
					passwordField_1.setEchoChar((char)0);
				}
				else{
					passwordField_1.setEchoChar('*');
				}
			}
		});
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		rdbtnNewRadioButton_1.setBackground(SystemColor.text);
		rdbtnNewRadioButton_1.setBounds(559, 269, 146, 21);
		contentPane.add(rdbtnNewRadioButton_1);
		
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
		rdbtnNewRadioButton.setBounds(559, 180, 146, 21);
		contentPane.add(rdbtnNewRadioButton);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		passwordField_1.setBackground(SystemColor.activeCaption);
		passwordField_1.setBounds(365, 236, 340, 26);
		contentPane.add(passwordField_1);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 16));
		passwordField.setBackground(SystemColor.activeCaption);
		passwordField.setBounds(365, 150, 340, 26);
		contentPane.add(passwordField);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 16));
		textField.setColumns(10);
		textField.setBackground(SystemColor.activeCaption);
		textField.setBounds(365, 96, 340, 26);
		contentPane.add(textField);
		
		JLabel lblNewJgoodiesLabel_2_1 = new JLabel("PASSWORD :");
		lblNewJgoodiesLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesLabel_2_1.setForeground(Color.BLACK);
		lblNewJgoodiesLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewJgoodiesLabel_2_1.setBackground(Color.WHITE);
		lblNewJgoodiesLabel_2_1.setBounds(209, 248, 146, 26);
		contentPane.add(lblNewJgoodiesLabel_2_1);
		
		JLabel lblNewJgoodiesLabel_1 = new JLabel("PASSWORD  :");
		lblNewJgoodiesLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesLabel_1.setForeground(Color.BLACK);
		lblNewJgoodiesLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewJgoodiesLabel_1.setBackground(Color.WHITE);
		lblNewJgoodiesLabel_1.setBounds(209, 150, 146, 26);
		contentPane.add(lblNewJgoodiesLabel_1);
		
		JLabel lblNewJgoodiesLabel_2 = new JLabel("CONFIRM");
		lblNewJgoodiesLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesLabel_2.setForeground(Color.BLACK);
		lblNewJgoodiesLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewJgoodiesLabel_2.setBackground(Color.WHITE);
		lblNewJgoodiesLabel_2.setBounds(209, 224, 127, 26);
		contentPane.add(lblNewJgoodiesLabel_2);
		
		JLabel lblNewJgoodiesLabel = new JLabel(" USERNAME  :");
		lblNewJgoodiesLabel.setForeground(Color.BLACK);
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewJgoodiesLabel.setBackground(Color.WHITE);
		lblNewJgoodiesLabel.setBounds(209, 96, 146, 26);
		contentPane.add(lblNewJgoodiesLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Tirumurugaa R S\\Downloads\\white (1).jpg"));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(187, 56, 545, 329);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 907, 464);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Tirumurugaa R S\\Downloads\\4327615.jpg"));
		contentPane.add(lblNewLabel);
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
