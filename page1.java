package vehicleparking;


import vehicleparking.EXP2;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.JEditorPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Panel;
import java.awt.Button;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class page1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Panel panel;
	private JPanel contentPane_1;
	private Panel panel_1;
	private Panel panel_3;
	private Panel panel_1_1_1;
	private JButton change;
	private Panel panel_4;
	private JPanel[] sa  = new JPanel[100];
	private int h;
	private String table;
	/*private JButton r1;
	private JButton r2;
	private JButton r3;
	private JButton r4;
	private JButton r5;
	private JButton r6;
	private JButton r7;
	private JButton r8;
	private JButton r9;
	private JButton r10;
	private JButton r11;
	private JButton r12;
	private JButton r13;
	private JButton r14;
	private JButton r15;
	private JButton r16;
	private JButton r17;
	private JButton r18;
	private JButton r19;
	private JButton r20;
	private JButton r21;
	private JButton r22;
	private JButton r23;
	private JButton r24;
	private JButton r25;
	private JButton r26;
	private JButton r27;
	private JButton r28;
	private JButton r29;
	private JButton r30;
	private JButton r40;
	private JButton r39;
	private JButton r38;
	private JButton r37;
	private JButton r36;
	private JButton r35;
	private JButton r34;
	private JButton r33;
	private JButton r32;
	private JButton r31;
	private JButton r41;
	private JButton r42;
	private JButton r43;
	private JButton r44;
	private JButton r45;
	private JButton r46;
	private JButton r47;
	private JButton r48;
	private JButton r49;
	private JButton r50;*/
	static String pn;
	static String vt;
	static String vn;
	static String n;
	private JButton[][] s1 = new JButton[10][20];
	private JButton[][] r= new JButton[10][20];
    String a;
    private Panel panel_2;
    private JTextField Name1;
    private JLabel lblNewLabel_1;
    private JLabel Name;
    private JLabel Vno;
    private JTextField Vno1;
    private JLabel lblNewLabel_1_2_1_1;
    static JComboBox vehicletype;
    private JLabel lblNewLabel_1_2_1_1_1;
    private JTextField Pno;
    private JButton btnNewButton;
    private JLabel Error;
    private JLabel lblNewLabel_2;
    private int a1;
    private int c;
    static int[] a12 = {0,0};
    private int[] a10 = {0,0};
	private int t1;
	private int t2;
	private int i1=0;
	private int i2=0;
	private int a2;
	private int s;
	private int m;
	private JPanel panel_5;
	
	private int i;
	private Connection con1;
	private JLabel[] entry1 =new JLabel[10];
	private JLabel[] exit1=new JLabel[10];
	private JLabel[] park=new JLabel[10];
	private JLabel[] vno1=new JLabel[10];
	private JLabel er1;
	private JLabel lblNewLabel_4;
	private JPanel panel_6;
	private int ey;
	private JPanel[] sa12  = new JPanel[10];
	private JButton[] bt=new JButton[10];
	private JLabel[] entry12=new JLabel[10];
	private JLabel[] park1=new JLabel[10];
	private JLabel[] vno12=new JLabel[10];
	private ActionListener lis1;
	private ActionListener lis;
	private int i12;
	private int t11;
	private int t12;
	private int i11;
	static String timein;
	static String timeout;
	private String wheeler;
	private ActionListener lis2;
	private JLabel lblNewLabel_6;
	private String re;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	static int id= EXP2.ID;
    //private JButton r[]= {r1,r2,r3,r4,r5,r6,r7,r8,r9,r10,r11,r12,r13,r14,r15,r16,r17,r18,r19,r20,r21,r22,r23,r24,r25,r26,r27,r28,r29,r30,r31,r32,r33,r34,r35,r36,r37,r38,r39,r40,r41,r42,r43,r44,r45,r46,r47,r48,r49,r50};
	/**
	 * Launch the application.
	 */
   /* public void run1(int k,int l) {
    	try {
    		System.out.println("1");
			String n = Name1.getText();
			System.out.println("1");
			String vn = Vno1.getText();
			System.out.println("1");
			String vt = (String) vehicletype.getSelectedItem();
			System.out.println("1");
			String pn = Pno.getText();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con1 = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","tiru@2607");
			Statement st1 = con1.createStatement();
			int n1;
			 if(vt=="2Wheeler") {
				 n1=25;
			 }
			 else {
				 n1=50;
			 }
			 System.out.println(r[k][l].getColorModel());
			
				
		        if(n!="" && vn!="" && pn!="" ) {
			    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			    LocalDateTime now = LocalDateTime.now();  
			    System.out.println(dtf.format(now)); 
			    String sql4 = "insert into slot values("+k+","+l+",'"+vn+"','T')";
			    
			    String sql3 = "insert into entry values("+c+",'"+n+"','"+pn+"','"+vn+"','"+dtf.format(now)+"',NULL,'F')";
				PreparedStatement pts = con1.prepareStatement(sql3);
				System.out.print(n);
			    /*pts.setValueAt(np,sql2,0);
			    System.out.print(i);
				pts.setInt(1,i);
				System.out.println(sql2);
				System.out.println("2");
				pts.executeUpdate(sql4);
				pts.executeUpdate(sql3);
				System.out.print("success");
				
		        }
    	}
    	catch(Exception qw) {
    		
    	}
    
    }*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					page1 frame = new page1();
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
	public page1() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Tirumurugaa R S\\Downloads\\parking-icon-flat-style-isolated-on-white-background-free-vector.jpg"));
		setBackground(new Color(153, 180, 209));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1214, 527);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		lis1 = new ActionListener() {
			private ResultSet rs4;
			private int wo;
			private String b1;
			

			public void actionPerformed(ActionEvent ew) {
				for(int kl = 0;kl<=8;kl++) {
				 if (ew.getSource() == bt[kl]) {
					    String text = park1[kl].getText();
					    System.out.println("Text:"+text);
					    int in = text.length();
					    int b=0;
					    for(int d = 0;d<in;d++) {
					    	char ch = text.charAt(d);
					    	System.out.println("d"+d);
	                		System.out.println(ch);
	                		System.out.println((int) ch);
	                		if((int)ch == 83) {
	                			wo=0;
	                			b=0;
	                			continue;
	                		}
	                		if((int)ch == 82) {
	                			wo=1;
	                			b=0;
	                			continue;
	                		}
	                		else {
	                			if(b==0||b==1) {
	                				a10[b]=(a10[b]*10)+(ch-48);
	                				b=1;
	                			}
	                		}
	                		

					    }
					    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
					    LocalDateTime now = LocalDateTime.now();
					    timeout=dtf.format(now);
					    try{
					    	System.out.println(a10[0]+" "+a10[1]);
					    	String sq6="select ID from entry where userID='"+EXP2.ID+"' and i='"+a10[0]+"' and j='"+a10[1]+"'"; 
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
						    	r[a10[0]][a10[1]].setBackground(Color.GREEN);
						    	r[a10[0]][a10[1]].setEnabled(true);
						    	++i1;
						    	new lastpage().setVisible(true);
;						    	//Switch_screen(panel_1_1_1);
					    	}
					        
					    }
					    catch(Exception et) {
					    	et.printStackTrace();
					    }
					    
		        
		                
		            }
				}
			}
		};
		JButton exit = new JButton("Exit");
		exit.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				try {
					//Class.forName("com.mysql.cj.jdbc.Driver");
					//Connection con1 = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","tiru@2607");
					//Statement st1 = con1.createStatement();
					String sq1 = "select * from entry where userID='"+EXP2.ID+"' and IsExit = 'F'";
					String sq2 ="select * from slot where userID='"+EXP2.ID+"'";
					PreparedStatement p5 = con1.prepareStatement(sq1);
					
					ResultSet rs3 = p5.executeQuery();
					PreparedStatement p6 = con1.prepareStatement(sq2);
					ResultSet rs4 = p6.executeQuery();
					int q = 2;
					int w = 2;
					int r = 2;
					for(int vb=0;vb<8;vb++) {
						//rs1.next() && rs2.next()) {
						if(sa12[vb]!=null) {
						sa12[vb].revalidate();
						sa12[vb].repaint();}
						
						while(rs3.next()) {
							System.out.println("In12");
							sa12[vb]=new JPanel();
							sa12[vb].setBackground(Color.GRAY);
							sa12[vb].setLayout(null);
							
							bt[vb] = new JButton("Exit");
							bt[vb].setBounds(49, 72, 90, 35);
							bt[vb].addActionListener(lis1);
							sa12[vb].add(bt[vb]);
							timein=rs3.getString("EntryDateTime");
							entry12[vb] = new JLabel(vb+" "+"Entry:"+rs3.getString("EntryDateTime"));
							entry12[vb].setForeground(Color.WHITE);
							entry12[vb].setFont(new Font("Tahoma", Font.PLAIN, 12));
							entry12[vb].setBounds(10, 0, 172, 35);
							sa12[vb].add(entry12[vb]);
							System.out.println(rs3.getString("i")+" "+rs3.getString("j"));
							if(rs3.getString("vtype").equals("4Wheeler")) {
								re="R";
							}
							else {
								re="S";
							}
							park1[vb] = new JLabel(re+""+rs3.getString("i")+rs3.getString("j"));
							park1[vb].setHorizontalAlignment(SwingConstants.CENTER);
							park1[vb].setForeground(Color.WHITE);
							park1[vb].setFont(new Font("Tahoma", Font.BOLD, 18));
							park1[vb].setBounds(20, 22, 143, 68);
							
							sa12[vb].add(park1[vb]);
							
							vno12[vb] = new JLabel("Vno:"+rs3.getString("VehicleNo"));
							vno12[vb].setForeground(Color.WHITE);
							vno12[vb].setFont(new Font("Tahoma", Font.PLAIN, 15));
							vno12[vb].setBounds(10, 111, 172, 21);
							sa12[vb].add(vno12[vb]);
		                    sa12[vb].setBounds(q, w, 190, 142);
						    panel_6.add(sa12[vb]);
						    sa12[vb].setVisible(true);
						if(vb%4==vb) {
							q+=190;
							q+=2;
							
						}
						else {
							if(q>r && vb==4) {
								q=r;
							}
							else {
							q=q+190+2;
							}
							w=146;
					    }
						
					}
					
					 
				}}
				catch(Exception ed) {
					ed.printStackTrace();
				}
				Switch_screen(panel_3);
			}
		});
		exit.setFont(new Font("Tahoma", Font.BOLD, 25));
		exit.setBackground(Color.LIGHT_GRAY);
		exit.setBounds(10, 320, 202, 76);
		contentPane.add(exit);
		
		JLabel lblNewLabel = new JLabel(" DASHBOARD");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(24, 0, 182, 54);
		contentPane.add(lblNewLabel);
		
		JButton History = new JButton("History");
		History.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Switch_screen(panel_1);
				
			}
		});
		History.setFont(new Font("Tahoma", Font.BOLD, 25));
		History.setBackground(Color.LIGHT_GRAY);
		History.setBounds(10, 54, 202, 76);
		contentPane.add(History);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con1 = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","tiru@2607");
			Statement st1 = con1.createStatement();
		}
		catch(Exception io) {
			io.printStackTrace();
		}
		
		final JButton btnNewButton_1 = new JButton("Log out");
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
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setBounds(50, 417, 118, 48);
		contentPane.add(btnNewButton_1);
		
		JButton Entry = new JButton("Entry");
		Entry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Switch_screen(panel_2);
			}
		});
		Entry.setFont(new Font("Tahoma", Font.BOLD, 25));
		Entry.setBackground(Color.LIGHT_GRAY);
		Entry.setBounds(10, 229, 202, 76);
		contentPane.add(Entry);
		
		JButton btnNewButton_2 = new JButton("Slot Available");
		btnNewButton_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Switch_screen(panel_1_1_1);
				
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnNewButton_2.setBounds(10, 140, 202, 79);
		contentPane.add(btnNewButton_2);
		
		contentPane_1 = new JPanel();
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(249, 10, 900, 490);
		contentPane.add(contentPane_1);
		contentPane_1.setLayout(null);
		
		panel_5 = new JPanel();
		
		panel_5.setBounds(38, 84, 768, 305);
		panel_5.setLayout(null);
		//panel_1.add(panel_5);
		final String[] choice1 = {"4Wheeler","2Wheeler"};
		//exit actionlistener
		//exit panel
		
		
		
		
		panel_1_1_1 = new Panel();
		panel_1_1_1.setBounds(0, 29, 870, 407);
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBackground(Color.GRAY);
		contentPane_1.add(panel_1_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("4WHEELER");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_1.setBounds(246, 10, 151, 32);
		panel_1_1_1.add(lblNewLabel_1_1);
		
		er1 = new JLabel("New label");
		er1.setForeground(Color.GREEN);
		er1.setFont(new Font("Tahoma", Font.BOLD, 18));
		er1.setBounds(500, 13, 200, 30);
		panel_1_1_1.add(er1);
		
		
		panel_1 = new Panel();
		panel_1.setBounds(10, 29, 850, 399);
		panel_1.setBackground(Color.BLACK);
		panel_1.add(panel_5);
		contentPane_1.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("HISTORY");
		lblNewLabel_3.setBounds(384, 27, 140, 20);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(lblNewLabel_3);
		
		
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");
			//Connection con1 = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","tiru@2607");
			//Statement st1 = con1.createStatement();
			String sq1 = "select * from entry where userID='"+EXP2.ID+"'";
			//String sq1 = "select * from entry where userID='1'";
			
			PreparedStatement p1 = con1.prepareStatement(sq1);

			ResultSet rs1 = p1.executeQuery();
			String sq2 ="select * from slot where userID='"+EXP2.ID+"'";
			PreparedStatement p2 = con1.prepareStatement(sq2);

			ResultSet rs2 = p2.executeQuery();
			int q = 2;
			int w = 2;
			int r = 2;
			h=0;
			while(rs1.next()&& h<=8) {
				System.out.println("In1");
				sa[h] = new JPanel();
				sa[h].setForeground(Color.WHITE);
				sa[h].setBackground(Color.GRAY);
				sa[h].setLayout(null);
				
				entry1[h] = new JLabel("Entry:"+rs1.getString("EntryDateTime"));
				
				entry1[h].setFont(new Font("Tahoma", Font.PLAIN, 12));
				entry1[h].setForeground(Color.WHITE);
				entry1[h].setBounds(10, 10, 172, 21);
				sa[h].add(entry1[h]);
				
				exit1[h] = new JLabel();
				exit1[h].setText("Exit:"+rs1.getString("ExitDateTime"));
				exit1[h].setForeground(Color.WHITE);
				exit1[h].setFont(new Font("Tahoma", Font.PLAIN, 12));
				exit1[h].setBounds(10, 30, 172, 21);
				sa[h].add(exit1[h]);
				if(rs1.getString("vtype").equals("4Wheeler")) {
					 re ="R";
				}
				else {
					 re ="S";
				}
				park[h] = new JLabel(re+rs1.getString("i")+" "+rs1.getString("j"));
				park[h].setForeground(Color.WHITE);
				park[h].setHorizontalAlignment(SwingConstants.CENTER);
				park[h].setFont(new Font("Tahoma", Font.BOLD, 18));
				park[h].setBounds(23, 41, 143, 68);
				sa[h].add(park[h]);
				
				vno1[h] = new JLabel("Vno:"+rs1.getString("VehicleNo"));
				vno1[h].setForeground(Color.WHITE);
				vno1[h].setFont(new Font("Tahoma", Font.PLAIN, 15));
				vno1[h].setBounds(10, 101, 172, 21);
				sa[h].add(vno1[h]);
				sa[h].setBounds(q, w, 190, 142);
				panel_5.add(sa[h]);
				sa[h].setVisible(true);
				if(h%4==h) {
					q+=190;
					q+=2;
					
				}
				else {
					if(q>r && h==4) {
						q=r;
					}
					else {
					q=q+190+2;
					}
					w=146;
			    }
				++h;
				
			}
			
			
		}
	
		catch(Exception ed) {
			ed.printStackTrace();
		}
		
		panel_1.add(panel_5);
		
		btnNewButton_4 = new JButton("Detailed History");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new History().setVisible(true);
				SwingUtilities.windowForComponent(btnNewButton_4).dispose();
			}
		});
		btnNewButton_4.setBounds(550, 40, 170, 25);
		panel_1.add(btnNewButton_4);
		lis = new ActionListener() {
			

			public void actionPerformed(ActionEvent ew) {
				 if (ew.getSource() instanceof JButton) {
					    wheeler="R";
					    table="slot";
		                String text = ((JButton) ew.getSource()).getText();
		                int in = text.length();
		                    
		                    int b = 0;
		                    System.out.println(in);
		                	for(int j=0;j<in;j++) {
		                		char ch = text.charAt(j);
		                		System.out.println("j"+j);
		                		System.out.println(ch);
		                		System.out.println((int) ch);
		                		if((int)ch == 32) {
		                			b=1;
		                			continue;
		                		}
		                		else {
		                			if(b==0||b==1) {
		                				a12[b]=(a12[b]*10)+(ch-48);
		                			}
		                		}
		                	
		                }
		                JOptionPane.showMessageDialog(null, text);
		                System.out.println((JButton)ew.getSource());
		                System.out.println(a12[0]);
		                System.out.println(a12[1]);
		                Switch_screen(panel_2);
		                
		            }
			}
		};
		//JButton
lis2 = new ActionListener() {
			

			public void actionPerformed(ActionEvent ew) {
				 if (ew.getSource() instanceof JButton) {
					    wheeler="S";
					    vehicletype.setSelectedIndex(1);
					    table="slot1";
		                String text = ((JButton) ew.getSource()).getText();
		                int in = text.length();
		                    
		                    int b = 0;
		                    System.out.println(in);
		                	for(int j=0;j<in;j++) {
		                		char ch = text.charAt(j);
		                		System.out.println("j"+j);
		                		System.out.println(ch);
		                		System.out.println((int) ch);
		                		if((int)ch == 32) {
		                			b=1;
		                			continue;
		                		}
		                		else {
		                			if(b==0||b==1) {
		                				a12[b]=(a12[b]*10)+(ch-48);
		                			}
		                		}
		                	
		                }
		                JOptionPane.showMessageDialog(null, text);
		                System.out.println((JButton)ew.getSource());
		                System.out.println(a12[0]);
		                System.out.println(a12[1]);
		                Switch_screen(panel_2);
		                
		            }
			}
		};
		a2 = 0;
	     a1 = 55;
		 c= 50;
		 s=10;
		m=15;
		 
		 for(int i=1;i<=(s-4);i++){
			for(int j=1;j<=m;j++) {
				if(r[i][j]!=null) {
					r[i][j].revalidate();
					r[i][j].repaint();
				}
			++a2;	
			ey=0;
			r[i][j]= new JButton();
			r[i][j].setText(i+" "+j);
			r[i][j].setFont(new Font("Tahoma", Font.BOLD, 6));
			try{
			//Class.forName("com.mysql.cj.jdbc.Driver");
			//Connection con1 = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","tiru@2607");
			//Statement st1 = con1.createStatement();
			String sql2 = "select * from slot where i="+i+" and j="+j;
			PreparedStatement ps2 = con1.prepareStatement(sql2);
			ResultSet res2 = ps2.executeQuery();
			while(res2.next()) {
				t1 = res2.getInt(1);
				t2 = res2.getInt(2);
				if(i==t1&& j==t2) {
					r[i][j].setBackground(Color.RED);
					r[i][j].setEnabled(false);
					
					ey=1;
					++i2;
				}
				
				
			}
			if(ey==0){
				r[i][j].setBackground(Color.GREEN);
				r[i][j].setEnabled(true);
			}
			}
			
			catch(Exception ws) {
				ws.printStackTrace();
				//r[i][j].setBackground(Color.GREEN);
				}
			//r[i][j].setBackground(Color.GREEN);
			++i1;
			r[i][j].setBounds(a1,c ,50,50);
			r[i][j].addActionListener(lis);
			 
			panel_1_1_1.add(r[i][j]);
			a1=a1+50;
			 }
			 if(i%2==1) {
			     a1=55; 
			     c=c+50;}
			 else {
				 a1=55;
				 c=c+50+20;
			 }
			
			 
		}
		 er1.setText("Available:"+(i1-i2));
		 System.out.println(i1-i2);
		
		 
		 
		 //2 wheeler
		 
	    
		/*r1 = new JButton("E");
		r1.setFont(new Font("Tahoma", Font.BOLD, 15));
		r1.setBackground(Color.GREEN);
		r1.setBounds(43, 49, 54, 44);
		panel_1_1_1.add(r1);
		
		r2 = new JButton("E");
		r2.setFont(new Font("Tahoma", Font.BOLD, 15));
		r2.setBackground(Color.GREEN);
		r2.setBounds(99, 49, 54, 44);
		panel_1_1_1.add(r2);
		
		r3 = new JButton("E");
		r3.setFont(new Font("Tahoma", Font.BOLD, 15));
		r3.setBackground(Color.GREEN);
		r3.setBounds(153, 49, 54, 44);
		panel_1_1_1.add(r3);
		
		r4 = new JButton("E");
		r4.setFont(new Font("Tahoma", Font.BOLD, 15));
		r4.setBackground(Color.GREEN);
		r4.setBounds(208, 49, 54, 44);
		panel_1_1_1.add(r4);
		
		r5 = new JButton("E");
		r5.setFont(new Font("Tahoma", Font.BOLD, 15));
		r5.setBackground(Color.GREEN);
		r5.setBounds(262, 49, 54, 44);
		panel_1_1_1.add(r5);
		
		r6 = new JButton("E");
		r6.setFont(new Font("Tahoma", Font.BOLD, 15));
		r6.setBackground(Color.GREEN);
		r6.setBounds(318, 49, 54, 44);
		panel_1_1_1.add(r6);
		
		r7 = new JButton("E");
		r7.setFont(new Font("Tahoma", Font.BOLD, 15));
		r7.setBackground(Color.GREEN);
		r7.setBounds(373, 49, 54, 44);
		panel_1_1_1.add(r7);
		
		r8 = new JButton("E");
		r8.setFont(new Font("Tahoma", Font.BOLD, 15));
		r8.setBackground(Color.GREEN);
		r8.setBounds(426, 49, 54, 44);
		panel_1_1_1.add(r8);
		
		r9 = new JButton("E");
		r9.setFont(new Font("Tahoma", Font.BOLD, 15));
		r9.setBackground(Color.GREEN);
		r9.setBounds(480, 49, 54, 44);
		panel_1_1_1.add(r9);
		
		r10 = new JButton("E");
		r10.setFont(new Font("Tahoma", Font.BOLD, 15));
		r10.setBackground(Color.GREEN);
		r10.setBounds(535, 49, 54, 44);
		panel_1_1_1.add(r10);
		
		r11 = new JButton("E");
		r11.setFont(new Font("Tahoma", Font.BOLD, 15));
		r11.setBackground(Color.GREEN);
		r11.setBounds(43, 93, 54, 44);
		panel_1_1_1.add(r11);
		
		r12 = new JButton("E");
		r12.setFont(new Font("Tahoma", Font.BOLD, 15));
		r12.setBackground(Color.GREEN);
		r12.setBounds(99, 93, 54, 44);
		panel_1_1_1.add(r12);
		
		r13 = new JButton("E");
		r13.setFont(new Font("Tahoma", Font.BOLD, 15));
		r13.setBackground(Color.GREEN);
		r13.setBounds(153, 93, 54, 44);
		panel_1_1_1.add(r13);
		
		r14 = new JButton("E");
		r14.setFont(new Font("Tahoma", Font.BOLD, 15));
		r14.setBackground(Color.GREEN);
		r14.setBounds(208, 93, 54, 44);
		panel_1_1_1.add(r14);
		
		r15 = new JButton("E");
		r15.setFont(new Font("Tahoma", Font.BOLD, 15));
		r15.setBackground(Color.GREEN);
		r15.setBounds(262, 93, 54, 44);
		panel_1_1_1.add(r15);
		
		r16 = new JButton("E");
		r16.setFont(new Font("Tahoma", Font.BOLD, 15));
		r16.setBackground(Color.GREEN);
		r16.setBounds(318, 93, 54, 44);
		panel_1_1_1.add(r16);
		
		r17 = new JButton("E");
		r17.setFont(new Font("Tahoma", Font.BOLD, 15));
		r17.setBackground(Color.GREEN);
		r17.setBounds(373, 93, 54, 44);
		panel_1_1_1.add(r17);
		
		r18 = new JButton("E");
		r18.setFont(new Font("Tahoma", Font.BOLD, 15));
		r18.setBackground(Color.GREEN);
		r18.setBounds(426, 93, 54, 44);
		panel_1_1_1.add(r18);
		
		r19 = new JButton("E");
		r19.setFont(new Font("Tahoma", Font.BOLD, 15));
		r19.setBackground(Color.GREEN);
		r19.setBounds(480, 93, 54, 44);
		panel_1_1_1.add(r19);
		
		r20 = new JButton("E");
		r20.setFont(new Font("Tahoma", Font.BOLD, 15));
		r20.setBackground(Color.GREEN);
		r20.setBounds(535, 93, 54, 44);
		panel_1_1_1.add(r20);
		
		r21 = new JButton("E");
		r21.setFont(new Font("Tahoma", Font.BOLD, 15));
		r21.setBackground(Color.GREEN);
		r21.setBounds(43, 197, 54, 44);
		panel_1_1_1.add(r21);
		
		r22 = new JButton("E");
		r22.setFont(new Font("Tahoma", Font.BOLD, 15));
		r22.setBackground(Color.GREEN);
		r22.setBounds(99, 197, 54, 44);
		panel_1_1_1.add(r22);
		
		r23 = new JButton("E");
		r23.setFont(new Font("Tahoma", Font.BOLD, 15));
		r23.setBackground(Color.GREEN);
		r23.setBounds(153, 197, 54, 44);
		panel_1_1_1.add(r23);
		
		r24 = new JButton("E");
		r24.setFont(new Font("Tahoma", Font.BOLD, 15));
		r24.setBackground(Color.GREEN);
		r24.setBounds(208, 197, 54, 44);
		panel_1_1_1.add(r24);
		
		r25 = new JButton("E");
		r25.setFont(new Font("Tahoma", Font.BOLD, 15));
		r25.setBackground(Color.GREEN);
		r25.setBounds(262, 197, 54, 44);
		panel_1_1_1.add(r25);
		
		r26 = new JButton("E");
		r26.setFont(new Font("Tahoma", Font.BOLD, 15));
		r26.setBackground(Color.GREEN);
		r26.setBounds(318, 197, 54, 44);
		panel_1_1_1.add(r26);
		
		r27 = new JButton("E");
		r27.setFont(new Font("Tahoma", Font.BOLD, 15));
		r27.setBackground(Color.GREEN);
		r27.setBounds(373, 197, 54, 44);
		panel_1_1_1.add(r27);
		
		r28 = new JButton("E");
		r28.setFont(new Font("Tahoma", Font.BOLD, 15));
		r28.setBackground(Color.GREEN);
		r28.setBounds(426, 197, 54, 44);
		panel_1_1_1.add(r28);
		
		r29 = new JButton("E");
		r29.setFont(new Font("Tahoma", Font.BOLD, 15));
		r29.setBackground(Color.GREEN);
		r29.setBounds(480, 197, 54, 44);
		panel_1_1_1.add(r29);
		
		r30 = new JButton("E");
		r30.setFont(new Font("Tahoma", Font.BOLD, 15));
		r30.setBackground(Color.GREEN);
		r30.setBounds(535, 197, 54, 44);
		panel_1_1_1.add(r30);
		
		r40 = new JButton("E");
		r40.setFont(new Font("Tahoma", Font.BOLD, 15));
		r40.setBackground(Color.GREEN);
		r40.setBounds(535, 240, 54, 44);
		panel_1_1_1.add(r40);
		
		r39 = new JButton("E");
		r39.setFont(new Font("Tahoma", Font.BOLD, 15));
		r39.setBackground(Color.GREEN);
		r39.setBounds(480, 240, 54, 44);
		panel_1_1_1.add(r39);
		
		r38 = new JButton("E");
		r38.setFont(new Font("Tahoma", Font.BOLD, 15));
		r38.setBackground(Color.GREEN);
		r38.setBounds(426, 240, 54, 44);
		panel_1_1_1.add(r38);
		
		r37 = new JButton("E");
		r37.setFont(new Font("Tahoma", Font.BOLD, 15));
		r37.setBackground(Color.GREEN);
		r37.setBounds(373, 240, 54, 44);
		panel_1_1_1.add(r37);
		
		r36 = new JButton("E");
		r36.setFont(new Font("Tahoma", Font.BOLD, 15));
		r36.setBackground(Color.GREEN);
		r36.setBounds(318, 240, 54, 44);
		panel_1_1_1.add(r36);
		
		r35 = new JButton("E");
		r35.setFont(new Font("Tahoma", Font.BOLD, 15));
		r35.setBackground(Color.GREEN);
		r35.setBounds(262, 240, 54, 44);
		panel_1_1_1.add(r35);
		
		r34 = new JButton("E");
		r34.setFont(new Font("Tahoma", Font.BOLD, 15));
		r34.setBackground(Color.GREEN);
		r34.setBounds(208, 240, 54, 44);
		panel_1_1_1.add(r34);
		
		r33 = new JButton("E");
		r33.setFont(new Font("Tahoma", Font.BOLD, 15));
		r33.setBackground(Color.GREEN);
		r33.setBounds(153, 240, 54, 44);
		panel_1_1_1.add(r33);
		
		r32 = new JButton("E");
		r32.setFont(new Font("Tahoma", Font.BOLD, 15));
		r32.setBackground(Color.GREEN);
		r32.setBounds(99, 240, 54, 44);
		panel_1_1_1.add(r32);
		
		r31 = new JButton("E");
		r31.setFont(new Font("Tahoma", Font.BOLD, 15));
		r31.setBackground(Color.GREEN);
		r31.setBounds(43, 240, 54, 44);
		panel_1_1_1.add(r31);
		
		r41 = new JButton("E");
		r41.setFont(new Font("Tahoma", Font.BOLD, 15));
		r41.setBackground(Color.GREEN);
		r41.setBounds(43, 336, 54, 44);
		panel_1_1_1.add(r41);
		
		r42 = new JButton("E");
		r42.setFont(new Font("Tahoma", Font.BOLD, 15));
		r42.setBackground(Color.GREEN);
		r42.setBounds(99, 336, 54, 44);
		panel_1_1_1.add(r42);
		
		r43 = new JButton("E");
		r43.setFont(new Font("Tahoma", Font.BOLD, 15));
		r43.setBackground(Color.GREEN);
		r43.setBounds(153, 336, 54, 44);
		panel_1_1_1.add(r43);
		
		r44 = new JButton("E");
		r44.setFont(new Font("Tahoma", Font.BOLD, 15));
		r44.setBackground(Color.GREEN);
		r44.setBounds(208, 336, 54, 44);
		panel_1_1_1.add(r44);
		
		r45 = new JButton("E");
		r45.setFont(new Font("Tahoma", Font.BOLD, 15));
		r45.setBackground(Color.GREEN);
		r45.setBounds(262, 336, 54, 44);
		panel_1_1_1.add(r45);
		
		r46 = new JButton("E");
		r46.setFont(new Font("Tahoma", Font.BOLD, 15));
		r46.setBackground(Color.GREEN);
		r46.setBounds(318, 336, 54, 44);
		panel_1_1_1.add(r46);
		
		r47 = new JButton("E");
		r47.setFont(new Font("Tahoma", Font.BOLD, 15));
		r47.setBackground(Color.GREEN);
		r47.setBounds(373, 336, 54, 44);
		panel_1_1_1.add(r47);
		
		r48 = new JButton("E");
		r48.setFont(new Font("Tahoma", Font.BOLD, 15));
		r48.setBackground(Color.GREEN);
		r48.setBounds(426, 336, 54, 44);
		panel_1_1_1.add(r48);
		
		r49 = new JButton("E");
		r49.setFont(new Font("Tahoma", Font.BOLD, 15));
		r49.setBackground(Color.GREEN);
		r49.setBounds(480, 336, 54, 44);
		panel_1_1_1.add(r49);
		
		r50 = new JButton("E");
		r50.setFont(new Font("Tahoma", Font.BOLD, 15));
		r50.setBackground(Color.GREEN);
		r50.setBounds(535, 336, 54, 44);
		panel_1_1_1.add(r50);*/
		
		panel_2 = new Panel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.ORANGE);
		panel_2.setBounds(10, 29, 850, 396);
		contentPane_1.add(panel_2);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(221, 251, 282, 28);
		panel_2.add(lblNewLabel_2);
		
		Name1 = new JTextField();
		Name1.setToolTipText("NAME");
		Name1.setForeground(Color.BLACK);
		Name1.setFont(new Font("Tahoma", Font.BOLD, 16));
		Name1.setColumns(10);
		Name1.setBounds(211, 58, 309, 34);
		panel_2.add(Name1);
		
		lblNewLabel_1 = new JLabel("ENTRY");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(240, 10, 131, 38);
		panel_2.add(lblNewLabel_1);
		
		Name = new JLabel("Name :");
		Name.setHorizontalAlignment(SwingConstants.CENTER);
		Name.setFont(new Font("Tahoma", Font.BOLD, 20));
		Name.setBounds(84, 54, 131, 38);
		panel_2.add(Name);
		
		Vno = new JLabel("Vehicle No :");
		Vno.setHorizontalAlignment(SwingConstants.CENTER);
		Vno.setFont(new Font("Tahoma", Font.BOLD, 20));
		Vno.setBounds(61, 102, 131, 38);
		panel_2.add(Vno);
		
		Vno1 = new JTextField();
		Vno1.setToolTipText("NAME");
		Vno1.setForeground(Color.BLACK);
		Vno1.setFont(new Font("Tahoma", Font.BOLD, 16));
		Vno1.setColumns(10);
		Vno1.setBounds(211, 106, 309, 34);
		panel_2.add(Vno1);
		
		lblNewLabel_1_2_1_1 = new JLabel("Vehicle Type :");
		lblNewLabel_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_2_1_1.setBounds(45, 155, 147, 38);
		panel_2.add(lblNewLabel_1_2_1_1);
		vehicletype = new JComboBox(choice1);
		vehicletype.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(vehicletype.getSelectedItem());
			}
		});
		vehicletype.setFont(new Font("Tahoma", Font.PLAIN, 16));
		vehicletype.setBounds(211, 160, 309, 33);
		panel_2.add(vehicletype);
		
		lblNewLabel_1_2_1_1_1 = new JLabel("Phone no :");
		lblNewLabel_1_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_2_1_1_1.setBounds(61, 203, 147, 38);
		panel_2.add(lblNewLabel_1_2_1_1_1);
		
		Pno = new JTextField();
		Pno.setToolTipText("NAME");
		Pno.setForeground(Color.BLACK);
		Pno.setFont(new Font("Tahoma", Font.BOLD, 16));
		Pno.setColumns(10);
		Pno.setBounds(211, 207, 309, 34);
		panel_2.add(Pno);
		
		btnNewButton = new JButton("Enter");
		btnNewButton.addActionListener(new ActionListener() {
			

			

			public void actionPerformed(ActionEvent e) {
				
				try {
					//new Bill().setVisible(true);
					if(a12[0]==0 && a12[1]==0) {
					n = Name1.getText();
					 vn = Vno1.getText();
					vt = (String)vehicletype.getSelectedItem();
					 pn = Pno.getText();
					//Class.forName("com.mysql.cj.jdbc.Driver");
					//Connection con1 = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","tiru@2607");
					//Statement st1 = con1.createStatement();
					String sql2 = "select count(*) as count from entry";
					String sql5 = "select count(*) as count from slot";
					String sql6 = "select count(*) as count from slot1";
					System.out.println("3");
					PreparedStatement ps2 = con1.prepareStatement(sql2);
					PreparedStatement ps4 = con1.prepareStatement(sql5);
					PreparedStatement ps5 = con1.prepareStatement(sql6);
					System.out.println("4");
					ResultSet res2 = ps2.executeQuery();
					ResultSet res4 = ps4.executeQuery();
					ResultSet res5 = ps5.executeQuery();
					System.out.println("5");
					int c = 100,t=0,c2=0,c1 = 0;
					while(res2.next())
					{ c1 = res2.getInt(1);
					 System.out.println(c);
					 }
					while(res4.next())
					{ t = res4.getInt(1);
					 System.out.println(c);
					 }
					 c=c + c1 + 1;
					 c2 = c2+(2*c)+t;
					 t=0;
					 while(res5.next()) {
						 t=res5.getInt(1);
						 System.out.println(t);
					 }
					 System.out.print(c);
					 int q1,w2;
					 int i,j;
					 int n1;
					 if(vt=="2Wheeler") {
						 c=t;
					 }
					 else {
						 
					 }
					 int u=0;
					 for(i=0;i<10;i++) {
						 for( j=0;j<c;j++) {
						 System.out.println(r[i][j].getText()=="E");
						 //if(vehicletype.getSelectedItem()=="4Wheeler") {
						 if(r[i][j].getText()=="E") {
							 q1=i;
							 w2=j;
							
					        if(n!="" && vn!="" && pn!="" && u==0) {
						    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
						    LocalDateTime now = LocalDateTime.now();
						    timein=dtf.format(now);
						    System.out.println(dtf.format(now)); 
						    String sql4 = "insert into "+table+" values("+i+","+j+",'"+vn+"','T',"+EXP2.ID+")";
						    
						    String sql3 = "insert into entry values("+c+",'"+n+"','"+pn+"','"+vn+"','"+dtf.format(now)+"',NULL,'F',"+EXP2.ID+",'"+q1+"','"+w2+"','"+vehicletype.getSelectedItem()+"')";
							PreparedStatement pts = con1.prepareStatement(sql3);
							System.out.print(n);
						   // pts.setValueAt(np,sql2,0);
						    System.out.print(i);
							pts.setInt(1,i);
							System.out.println(sql2);
							System.out.println("2");//
							pts.executeUpdate(sql4);
							pts.executeUpdate(sql3);
							r[i][j].setBackground(Color.RED);
							ey-=1;
							System.out.print("success");
						
							++u;
							break;
							
					        }}}}
						 
					 
					 }
					else{
						int k =a12[0];
						int l = a12[1];
						System.out.println("1");
						n = Name1.getText();
						System.out.println("1");
						vn = Vno1.getText();
						System.out.println("1");
						vt = (String) vehicletype.getSelectedItem();
						System.out.println("1");
						pn = Pno.getText();
						//Class.forName("com.mysql.cj.jdbc.Driver");
						//Connection con1 = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","tiru@2607");
						//Statement st1 = con1.createStatement();
						int c = 100,t=0,c2=0,c1 = 0;
						String sql2 = "select count(*) as count from entry";
						PreparedStatement ps2 = con1.prepareStatement(sql2);
						ResultSet res2 = ps2.executeQuery();
						while(res2.next())
						{ c1 = res2.getInt(1);
						 System.out.println(c);
						 }
						c = c+c1+1;
						int n1;
						 if(vt=="2Wheeler") {
							 n1=25;
						 }
						 else {
							 n1=50;
						 }
						 System.out.println(r[k][l].getColorModel());
						
							
					        if(n!="" && vn!="" && pn!="" ) {
						    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
						    LocalDateTime now = LocalDateTime.now();  
						    System.out.println(dtf.format(now)); 
						    String sql4 = "insert into "+table+" values("+k+","+l+",'"+vn+"','T',"+EXP2.ID+")";
						    
						    String sql3 = "insert into entry values("+c+",'"+n+"','"+pn+"','"+vn+"','"+dtf.format(now)+"',NULL,'F',"+EXP2.ID+",'"+k+"','"+l+"','"+vehicletype.getSelectedItem()+"')";
							PreparedStatement pts = con1.prepareStatement(sql3);
							System.out.print(n);
						    /*pts.setValueAt(np,sql2,0);
						    System.out.print(i);
							pts.setInt(1,i);
							System.out.println(sql2);*/
							System.out.println("2");
							pts.executeUpdate(sql4);
							pts.executeUpdate(sql3);
							if(vt=="4Wheeler") {
								r[k][l].setBackground(Color.RED);}
							else {
								s1[k][l].setBackground(Color.RED);
							}
							ey-=1;
							System.out.print("success");
							
					        }
						}
					
					Switch_screen(panel_1_1_1);
					new Bill().setVisible(true);
					}
				
				catch(Exception et) {
					
					//lblNewLabel_2.setText("Don't leave any field empty");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(251, 306, 119, 43);
		panel_2.add(btnNewButton);
		
		Error = new JLabel("");
		Error.setHorizontalAlignment(SwingConstants.CENTER);
		Error.setBounds(224, 266, 212, 26);
		panel_2.add(Error);
		
		/*panel_3 = new Panel();
		panel_3.setBounds(10, 29, 850, 396);
		panel_3.setBackground(Color.BLUE);
		contentPane_1.add(panel_3);
		panel_3.setLayout(null);*/
		
		/*panel_6 = new JPanel();
		panel_6.setBounds(40, 70, 768, 290);
		panel_6.setLayout(null);
		panel_3.add(panel_6);
		panel_3.add(panel_5);*/
		panel_3 = new Panel();
		panel_3.setBounds(10, 29, 850, 396);
		panel_3.setBackground(Color.BLUE);
		contentPane_1.add(panel_3);
		panel_3.setLayout(null);
		panel_6 = new JPanel();
		panel_6.setBounds(40, 70, 768, 290);
		panel_6.setLayout(null);
		panel_3.add(panel_6);
		
		lblNewLabel_4 = new JLabel("Exit");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(365, 10, 100, 30);
		panel_3.add(lblNewLabel_4);
		
		btnNewButton_3 = new JButton("Detailed Exit");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Exit().setVisible(true);
				SwingUtilities.windowForComponent(btnNewButton_3).dispose();
			}
		});
		btnNewButton_3.setBounds(550, 40, 170, 25);
		panel_3.add(btnNewButton_3);
		panel_4 = new Panel();
		panel_4.setBackground(Color.GRAY);
		panel_4.setBounds(0, 29, 870, 407);
		contentPane_1.add(panel_4);
		panel_4.setLayout(null);
		lblNewLabel_6 = new JLabel("Available :"+i11);
		lblNewLabel_6.setForeground(Color.GREEN);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_6.setBounds(534, 10, 180, 31);
		panel_4.add(lblNewLabel_6);
		//
		a2 = 0;
	     a1 = 55;
		 c= 50;
		 s=10;
		m=15;
		 
		 for(int i=1;i<=(s-4);i++){
			for(int j=1;j<=m;j++) {
				if(s1[i][j]!=null) {
					s1[i][j].revalidate();
					s1[i][j].repaint();
				}
			++a2;	
			ey=0;
			s1[i][j]= new JButton();
			s1[i][j].setText(i+" "+j);
			s1[i][j].setFont(new Font("Tahoma", Font.BOLD, 6));
			s1[i][j].setBackground(Color.GREEN);
			s1[i][j].setEnabled(true);
			++i11;
			try{
			//Class.forName("com.mysql.cj.jdbc.Driver");
			//Connection con1 = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","tiru@2607");
			//Statement st1 = con1.createStatement();
			//String sql2 = "select * from slot1 where i="+i+" and j="+j;
				String sql2 = "select * from slot1";
			PreparedStatement ps2 = con1.prepareStatement(sql2);
			ResultSet res2 = ps2.executeQuery();
			while(res2.next()) {
				t11 = res2.getInt(1);
				t12 = res2.getInt(2);
				if(i==t1&& j==t2) {
					s1[t11][t12].setBackground(Color.RED);
					s1[t11][t12].setEnabled(false);
					
					ey=1;
					++i12;
				}
				
			
			}
			
			ey=0;
			}
			
			catch(Exception op) {
				op.printStackTrace();
				//r[i][j].setBackground(Color.GREEN);
				}
			//r[i][j].setBackground(Color.GREEN);
			++i1;
			s1[i][j].setBounds(a1,c ,50,50);
			s1[i][j].addActionListener(lis2);
			 
			panel_4.add(s1[i][j]);
			a1=a1+50;
			 }
			 if(i%2==1) {
			     a1=55; 
			     c=c+50;}
			 else {
				 a1=55;
				 c=c+50+20;
			 }
			
			 
		}
		 lblNewLabel_6.setText("Available:"+(i11-i12));
		 System.out.println(90-i12);
		
		
		//
		
		change = new JButton("to 2wheeler");
		change.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(change.getText()=="to 2wheeler") {
					change.setText("to 4wheeler");
				    Switch_screen(panel_4);
				    	
				}
				else {
					change.setText("to 2wheeler");
				    Switch_screen(panel_1_1_1);
				}
			}
		});
		
		
		
		JLabel lblNewLabel_5 = new JLabel("2 Wheeler");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_5.setBounds(242, 10, 193, 39);
		panel_4.add(lblNewLabel_5);
		
		
		change.setFont(new Font("Tahoma", Font.BOLD, 20));
		change.setBackground(new Color(240, 240, 240));
		change.setBounds(10, 2, 173, 21);
		contentPane_1.add(change);
		Switch_screen(panel_1_1_1);

	}
	


	public void Switch_screen(Panel panel_12){
		contentPane_1.removeAll();
		if( panel_12 == panel_1_1_1 || panel_12 == panel_4) {
			System.out.println("here");
		    contentPane_1.add(panel_12);
		    System.out.println("here1");
		    System.out.println(EXP2.ID);
		    panel_12.repaint();
		    panel_12.revalidate();
		    
		    contentPane_1.add(change);
		    
		    }
		else {
			panel_12.repaint();
		    panel_12.revalidate();
			contentPane_1.add(panel_12);
		}
		contentPane_1.repaint();
		contentPane_1.revalidate();
	}
}
