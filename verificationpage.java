package vehicleparking;

import java.awt.EventQueue;
import java.util.*; 
import javax.mail.*; 
import javax.mail.internet.*; 
//import javax.activation.*; 
import javax.mail.Session; 
import javax.mail.Transport;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Color;

public class verification extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField emailid;
	private JTextField OTP;
    private int n;
	private JLabel lblNewLabel;
	private String n3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					verification frame = new verification();
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
	public verification() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Tirumurugaa R S\\Downloads\\parking-icon-flat-style-isolated-on-white-background-free-vector.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 893, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Email id:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1.setBounds(65, 102, 191, 40);
		contentPane.add(lblNewLabel_1);
		
		emailid = new JTextField();
		emailid.setFont(new Font("Tahoma", Font.BOLD, 22));
		emailid.setColumns(10);
		emailid.setBounds(266, 103, 388, 40);
		contentPane.add(emailid);
		
		JButton btnNewButton = new JButton("Send mail");
		btnNewButton.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				 String fr = emailid.getText();
				 String to = fr; // to address. It can be any like gmail, hotmail etc.
				  final String from = "tirumurugaars@gmail.com"; // from address. As this is using Gmail SMTP.
				  final String password = "ahwz ralp lljn ygsc"; // password for from mail address. 
				 
				  Properties prop = new Properties();
				  prop.put("mail.smtp.host", "smtp.gmail.com");
				  prop.put("mail.smtp.port", "465");
				  prop.put("mail.smtp.auth", "true");
				  prop.put("mail.smtp.socketFactory.port", "465");
				  prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
				 
				  Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
				   protected PasswordAuthentication getPasswordAuthentication() {
				    return new PasswordAuthentication(from, password);
				   }
				  });
				 
				  try {
				 
				   Message message = new MimeMessage(session);
				   message.setFrom(new InternetAddress(from));
				   message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
				   message.setSubject("Verification Mail");
				   int n;
				   Random ran = new Random();
				   n = ran.nextInt();
				   n=Math.abs(n);
				   System.out.println(n);
				   n3 = String.valueOf(n);
				   String msg = "OTP :"+n3 ;
				    
				   MimeBodyPart mimeBodyPart = new MimeBodyPart();
				   mimeBodyPart.setContent(msg, "text/html");
				     
				   Multipart multipart = new MimeMultipart();
				   multipart.addBodyPart(mimeBodyPart);
				    
				  /* MimeBodyPart attachmentBodyPart = new MimeBodyPart();
				   try {
					attachmentBodyPart.attachFile(new File("C:\\Users\\Tirumurugaa R S\\Downloads\\parking-lot.jpeg"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				   multipart.addBodyPart(attachmentBodyPart);*/
				   message.setContent(multipart);
				   System.out.println(message);
				   Transport.send(message);
				 
				   System.out.println("Mail successfully sent..");
				 
				  } catch (MessagingException er) {
				   er.printStackTrace();
				  }
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(664, 102, 123, 40);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1_1 = new JLabel("Enter OTP  :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_1.setBounds(96, 223, 160, 40);
		contentPane.add(lblNewLabel_1_1);
		
		OTP = new JTextField();
		OTP.setFont(new Font("Tahoma", Font.BOLD, 22));
		OTP.setColumns(10);
		OTP.setBounds(266, 224, 388, 40);
		contentPane.add(OTP);
		
		final JButton btnNewButton_1 = new JButton("Verify");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String n1 = OTP.getText();
				
				if(n1.equals(n3)) {
					try {
						new forgetpassword1().setVisible(true);
						SwingUtilities.windowForComponent(btnNewButton_1).dispose();
					}
					catch(Exception ew) {
						ew.printStackTrace();
					}
				}
				else {
					lblNewLabel.setText("Incorrect OTP");
				}
			
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnNewButton_1.setBounds(336, 361, 205, 68);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(294, 288, 348, 40);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					EXP2 newframe = new EXP2();
				    newframe.frmVehicleParking.setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton_2).dispose();
					
				}
				catch(Exception a)
				{
					JOptionPane.showMessageDialog(btnNewButton_2, this, "Error while establishing connection failed", 0);
				}
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_2.setBounds(52, 464, 85, 31);
		contentPane.add(btnNewButton_2);
	}
}
