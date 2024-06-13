package vehicleparking;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Toolkit;
import vehicleparking.EXP2;
public class Exit extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int[] a10 = {0,0};
	private JPanel[] sc1 = new JPanel[100];
    private JLabel[] la = new JLabel[100];
    private JLabel[] la1 = new JLabel[100];
    private JLabel[] la2 = new JLabel[100];
    private JLabel[] la3 = new JLabel[100];
    private JLabel[] la4 = new JLabel[100];
    private JLabel[] la5 = new JLabel[100];
    private JLabel[] la6 = new JLabel[100];
    private JButton[] la7= new JButton[100];
	private ActionListener lis1;
	private ResultSet rs4;
	private int wo;
	private String b1;
	static String timeout;
	private Connection con1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exit frame = new Exit();
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
	public Exit() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Tirumurugaa R S\\Downloads\\parking-icon-flat-style-isolated-on-white-background-free-vector (1).jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1072, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(108, 85, 185, 182);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Tirumurugaa R S\\Downloads\\parking-icon-flat-style-isolated-on-white-background-free-vector (1).jpg"));
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(417, 82, 631, 349);
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JLabel lblDetailedExit = new JLabel("Detailed Exit");
		lblDetailedExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblDetailedExit.setForeground(SystemColor.controlText);
		lblDetailedExit.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblDetailedExit.setBackground(SystemColor.textHighlight);
		lblDetailedExit.setBounds(400, 10, 203, 54);
		contentPane.add(lblDetailedExit);
		
		JLabel lblNewLabel_2 = new JLabel("Vehicle Parking");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_2.setBounds(57, 277, 281, 64);
		contentPane.add(lblNewLabel_2);
		//actionlistener for exit
		lis1 = new ActionListener() {
			
			

			public void actionPerformed(ActionEvent ew) {
				int kl=0;
				for( kl = 0;kl<100;kl++) {
				 if (ew.getSource()==la7[kl]) {
					    String text = la1[kl].getText();
					    System.out.println("Text:"+text);
					    int in = text.length();
					    int b=0;
					    for(int d = 0;d<in;d++) {
					    	char ch = text.charAt(d);
					    	System.out.println("d"+d);
	                		System.out.println(ch);
	                		System.out.println((int) ch);
	                		if((int)ch == 83 ) {
	                			wo=0;
	                			b=0;
	                			continue;
	                		}
	                	    if((int)ch == 82 ) {
	                			wo=1;
	                			b=0;
	                			continue;
	                		}
	                		else {
	                			if(b==0 || b==1) {
	                				if((int)ch!=32) {
	                				a10[b]=(a10[b]*10)+(ch-48);
	                				b=1;}
	                			}
	                		}
	                		
	                		

					    }
					    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
					    LocalDateTime now = LocalDateTime.now();
					    timeout=dtf.format(now);
					    try{
					    	Class.forName("com.mysql.cj.jdbc.Driver");
							con1 = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","tiru@2607");
					    	System.out.println(a10[0]+" "+a10[1]);
					    	String sq6="select ID from entry where userID='"+page1.id+"' and i='"+a10[0]+"' and j='"+a10[1]+"'"; 
					    	PreparedStatement ps3=con1.prepareStatement(sq6);
					    	rs4 = ps3.executeQuery();
					    	}
					    catch(Exception oy) {
					    	oy.printStackTrace();
					    }
					   // String sq6="select ID from entry where userID='"+EXP2.ID+"'(select userID from entry where userID='"+EXP2.ID+"', and i='"+a12[0]+"' and j='"+a12[1]+"')"; 
					   
					    try{
					    	//PreparedStatement ps3=con1.prepareStatement(sq6);
					    	//ResultSet rs3 = ps3.executeQuery();
					    	while(rs4.next()) {
					    		if(wo==1) {
					    			 b1 = "slot";
					    		}
					    		else {
					    			 b1 = "slot1";
					    		}
					    		String sq5="update entry set ExitDateTime='"+dtf.format(now)+"',IsExit='T' where ID='"+rs4.getString(1)+"'";
						    	PreparedStatement ps2=con1.prepareStatement(sq5);
						    	ps2.executeUpdate(sq5);
						    	String sw3="delete from "+b1+" where i='"+a10[0]+"' and j='"+a10[1]+"'";
						    	PreparedStatement ps23=con1.prepareStatement(sw3);
						    	int ra = ps23.executeUpdate();
						    	//r[a10[0]][a10[1]].setBackground(Color.GREEN);
						    	//r[a10[0]][a10[1]].setEnabled(true);
						    	//++i1;
						    	new lastpage().setVisible(true);
						    	break;
						    	//Switch_screen(panel_1_1_1);
					    	}
					        
					    }
					    catch(Exception et) {
					    	et.printStackTrace();
					    }
					    
		        
		                
		            }
				 
				}
			}
		};
		//
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","tiru@2607");
			String sql = "select * from entry where IsExit = 'F'";
			PreparedStatement ps3=con.prepareStatement(sql);
			ResultSet rs = ps3.executeQuery();
			int i=0;
			while(rs.next()) {
				sc1[i]= new JPanel();
				sc1[i].setPreferredSize(new Dimension(300, 250)); 
				sc1[i].setBackground(Color.white);
				sc1[i].setBorder(new LineBorder(new Color(0, 0, 0), 2));
				sc1[i].setLayout(null);
				la[i] = new JLabel("");
				la[i].setIcon(new ImageIcon("C:\\Users\\Tirumurugaa R S\\Downloads\\Bike-512.jpg"));
				la[i].setBounds(20, 26, 150, 147);
				sc1[i].add(la[i]);
				la1[i] = new JLabel("");
				if(((String)rs.getString("vtype")).equals("4Wheeler")) {
				    la1[i].setText("R"+" "+rs.getString("i")+" "+rs.getString("j"));
				    //la[i].setIcon(new ImageIcon("C:\\Users\\Tirumurugaa R S\\Downloads\\Bike-512.jpg"));
				    la[i].setIcon(new ImageIcon("C:\\Users\\Tirumurugaa R S\\Downloads\\car (1).png"));
				}
				else {
					la1[i].setText("S"+" "+rs.getString("i")+" "+rs.getString("j"));
					la[i].setIcon(new ImageIcon("C:\\Users\\Tirumurugaa R S\\Downloads\\Bike-512.jpg"));
				}
				la1[i].setFont(new Font("Tahoma", Font.BOLD, 22));
				la1[i].setHorizontalAlignment(SwingConstants.CENTER);
				la1[i].setBounds(20, 152, 150, 51);
				sc1[i].add(la1[i]);
				la2[i] = new JLabel("");
				la2[i].setText("IN                :"+rs.getString("EntryDateTime"));
				la2[i].setFont(new Font("Tahoma", Font.BOLD, 22));
				la2[i].setHorizontalAlignment(SwingConstants.CENTER);
				la2[i].setBounds(180, 52, 466, 30);
				sc1[i].add(la2[i]);
				//la3[i] = new JLabel("");
				//la3[i].setText("OUT             :"+rs.getString("ExitDateTime"));
				//la3[i].setFont(new Font("Tahoma", Font.BOLD, 22));
				//la3[i].setHorizontalAlignment(SwingConstants.CENTER);
				//la3[i].setBounds(180, 80, 466, 30);
				//sc1[i].add(la3[i]);
				la4[i] = new JLabel();
				la4[i].setText("Name          :"+rs.getString("Name"));
				la4[i].setFont(new Font("Tahoma", Font.BOLD, 22));
				//la4[i].setHorizontalAlignment(SwingConstants.CENTER);
				la4[i].setBounds(223, 26, 386, 30);
				sc1[i].add(la4[i]);
				la5[i] = new JLabel();
				la5[i].setText("Phone No    :"+rs.getString("Mobile"));
				la5[i].setFont(new Font("Tahoma", Font.BOLD, 22));
				//la4[i].setHorizontalAlignment(SwingConstants.CENTER);
				la5[i].setBounds(221, 107, 314, 30);
				sc1[i].add(la5[i]);
				la6[i] = new JLabel();
				la6[i].setText("Vehicle No  :"+rs.getString("VehicleNo"));
				la6[i].setFont(new Font("Tahoma", Font.BOLD, 22));
				//la4[i].setHorizontalAlignment(SwingConstants.CENTER);
				la6[i].setBounds(221, 80, 466, 30);
				sc1[i].add(la6[i]);
				la7[i] = new JButton("EXIT");
				la7[i].setBackground(Color.CYAN);
				la7[i].setForeground(Color.WHITE);
				la7[i].setFont(new Font("Tahoma", Font.BOLD, 20));
				la7[i].addActionListener(lis1);
				la7[i].setBounds(223, 182, 324, 44);
				sc1[i].add(la7[i]);
                panel.add(sc1[i]);
				i++;
			}
		}
		catch(Exception et) {
			et.printStackTrace();
		}
		
		//
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					page1 nf1= new page1();
					nf1.setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton).dispose();
				}
				catch(Exception et) {
					et.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnNewButton.setBounds(30, 393, 156, 54);
		contentPane.add(btnNewButton);
	}
}
