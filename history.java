package vehicleparking;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class History extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel[] sc1 = new JPanel[100];
    private JLabel[] la = new JLabel[100];
    private JLabel[] la1 = new JLabel[100];
    private JLabel[] la2 = new JLabel[100];
    private JLabel[] la3 = new JLabel[100];
    private JLabel[] la4 = new JLabel[100];
    private JLabel[] la5 = new JLabel[100];
    private JLabel[] la6 = new JLabel[100];
    private JButton[] la7= new JButton[100];
	private ActionListener lis;
	static String Slot;
	static String timein;
	static String timeout;
	static String name;
	static String pn;
	static String vn;
	static String vt;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					History frame = new History();
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
	public History() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1004, 555);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(355, 96, 635, 390);
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		//
lis = new ActionListener() {
			

		

			

			public void actionPerformed(ActionEvent ew) {
				int k =0;
				for(k=0;k<100;k++) {
					if(ew.getSource()==la7[k]) {
					  Slot = la1[k].getText();
					  timein = la2[k].getText();
					  timeout = la3[k].getText();
					  name = la4[k].getText();
					  pn = la5[k].getText();
					  vn = la6[k].getText();
					  if((la1[k].getText()).contains("R")) {
						  vt = "4Wheeler";
					  }
					  else {
						  vt="2Wheeler";
					  }
					  historybill ng =new historybill();
					  ng.setVisible(true);
					  SwingUtilities.windowForComponent(la7[k]).dispose();
					  
					}
				}
			
			}
};
		//
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","tiru@2607");
			String sql = "Select * from entry";
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
				la3[i] = new JLabel("");
				la3[i].setText("OUT             :"+rs.getString("ExitDateTime"));
				la3[i].setFont(new Font("Tahoma", Font.BOLD, 22));
				la3[i].setHorizontalAlignment(SwingConstants.CENTER);
				la3[i].setBounds(180, 80, 466, 30);
				sc1[i].add(la3[i]);
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
				la5[i].setBounds(221, 134, 314, 30);
				sc1[i].add(la5[i]);
				la6[i] = new JLabel();
				la6[i].setText("Vehicle No  :"+rs.getString("VehicleNo"));
				la6[i].setFont(new Font("Tahoma", Font.BOLD, 22));
				//la4[i].setHorizontalAlignment(SwingConstants.CENTER);
				la6[i].setBounds(221, 107, 314, 30);
				sc1[i].add(la6[i]);
				la7[i] = new JButton("Download");
				la7[i].setBackground(Color.CYAN);
				la7[i].setForeground(Color.WHITE);
				la7[i].setFont(new Font("Tahoma", Font.BOLD, 20));
				la7[i].setBounds(223, 182, 324, 44);
				la7[i].addActionListener(lis);
				sc1[i].add(la7[i]);
                panel.add(sc1[i]);
				i++;
			}
		}
		catch(Exception et) {
			et.printStackTrace();
		}
		
		JLabel lblNewLabel = new JLabel("Detailed History");
		lblNewLabel.setForeground(SystemColor.controlText);
		lblNewLabel.setBackground(SystemColor.textHighlight);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(380, 22, 203, 54);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Tirumurugaa R S\\Downloads\\parking-icon-flat-style-isolated-on-white-background-free-vector (1).jpg"));
		lblNewLabel_1.setBounds(88, 92, 185, 182);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Vehicle Parking");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_2.setBounds(41, 284, 281, 64);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//page1 nf1= new page1();
					//nf1.setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton).dispose();
				}
				catch(Exception et) {
					et.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnNewButton.setBounds(31, 436, 156, 54);
		contentPane.add(btnNewButton);
	}
}
