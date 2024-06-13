package vehicleparking;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JTextArea;
public class Adminpage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultPieDataset pieDataset;
    private JFreeChart pieChart;
    private PiePlot piePlot;
    private ChartPanel ChartPanel;
    private JScrollPane scrollPane;
    private int c2=0;
    private int c4=0;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel[] sc1 = new JPanel[100];
    private JLabel[] la = new JLabel[100];
    private JLabel[] la1 = new JLabel[100];
    private JLabel[] la2 = new JLabel[100];
    private JLabel[] la3 = new JLabel[100];
    private JLabel[] la4 = new JLabel[100];
    private JLabel[] la5 = new JLabel[100];
    private JLabel[] la6 = new JLabel[100];
    private JPanel[] sc11 = new JPanel[100];
    private JLabel[] la111 = new JLabel[100];
    private JLabel[] la11 = new JLabel[100];
    private JLabel[] la21 = new JLabel[100];
    private JLabel[] la31 = new JLabel[100];
    private JLabel[] la41 = new JLabel[100];
    private JLabel[] la51 = new JLabel[100];
    private JLabel[] la61 = new JLabel[100];
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Adminpage frame = new Adminpage();
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
	public Adminpage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1014, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		JPanel pn1 = new JPanel();
		pn1.setPreferredSize(new Dimension(100,100));
		pn1.setBackground(Color.white);
		pn1.setLayout(null);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","tiru@2607");
			String sql = "Select count(*) as count from entry where vtype = '2Wheeler'";
			PreparedStatement ps3=con.prepareStatement(sql);
			ResultSet rs = ps3.executeQuery();
			while(rs.next()) {
				c2=c2+rs.getInt(1);
			}
			String sql1 = "Select count(*) as count from entry where vtype = '4Wheeler'";
			PreparedStatement ps31=con.prepareStatement(sql1);
			ResultSet rs1 = ps31.executeQuery();
			while(rs1.next()) {
				c4=c4+rs1.getInt(1);
			}
			System.out.println(c2+""+c4);
		}
		catch(Exception ey) {
			
		}
        pieDataset=new DefaultPieDataset();
        pieDataset.setValue("2-Wheeler", new Double(c2));
        
        pieDataset.setValue("4-Wheeler", new Double(c4));
        //pieDataset.setValue("the jiji", new Double(8.90));
        //pieDataset.setValue("the dfhgj", new Double(9.2));
        pieChart = ChartFactory.createPieChart3D("Booking Rate",pieDataset,true,true,false);
        piePlot = (PiePlot) pieChart.getPlot();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 38, 980, 492);
		contentPane.add(scrollPane);
		ChartPanel = new ChartPanel(pieChart);
		ChartPanel.setPreferredSize(new Dimension(400,400));
        
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		 panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		 panel.add(pn1);
		 
		 JLabel lblNewLabel = new JLabel("Parking Details");
		 lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		 lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		 lblNewLabel.setBounds(292, 10, 359, 58);
		 pn1.add(lblNewLabel);
		 
		 JButton btnNewButton = new JButton("Summary 4wheeler");
		 btnNewButton.setForeground(SystemColor.text);
		 btnNewButton.setBackground(SystemColor.textHighlight);
		 btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		 btnNewButton.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 			//table.print();
		 			//Document document = new Document();
		 		      // String PATH_NAME="C:/Users/Tirumurugaa R S/Downloads/hello.pdf";
		 		try {
		 			//table_1.print();
		 			new pdf11().setVisible(true);
		 			SwingUtilities.windowForComponent(btnNewButton).dispose();
		 		}catch(Exception ty){
		 			ty.printStackTrace();
		 		}
		 		
		 	}
		 });
		 btnNewButton.setBounds(736, 10, 215, 37);
		 pn1.add(btnNewButton);
		 
		 JButton btnSummarywheeler = new JButton("Summary 2wheeler");
		 btnSummarywheeler.setForeground(SystemColor.text);
		 btnSummarywheeler.setBackground(SystemColor.textHighlight);
		 btnSummarywheeler.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		try {
		 			//table_1.print();
		 			new pdf12().setVisible(true);
		 			SwingUtilities.windowForComponent(btnSummarywheeler).dispose();
		 		}catch(Exception ty){
		 			ty.printStackTrace();
		 		}
		 	}
		 });
		 btnSummarywheeler.setFont(new Font("Tahoma", Font.BOLD, 15));
		 btnSummarywheeler.setBounds(10, 10, 215, 37);
		 pn1.add(btnSummarywheeler);
		 panel .add(ChartPanel);
		//panel.setLayout(new BorderLayout(0, 0));
		 JPanel panel1 = new JPanel();
		 panel1.setPreferredSize(new Dimension(400,400));
		 panel1.setBackground(Color.white);
		 panel1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		 panel1.setLayout(null);
		 panel.add(panel1);
		 
		 JScrollPane scrollPane_1 = new JScrollPane();
		 scrollPane_1.setBounds(50, 70, 400, 320);
		 panel1.add(scrollPane_1);
		 
		 panel2=new JPanel();
		 scrollPane_1.setViewportView(panel2);
		 panel2.setBackground(Color.white);
		 panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","tiru@2607");
				String sql = "Select * from entry where vtype = '4Wheeler'";
				PreparedStatement ps3=con.prepareStatement(sql);
				ResultSet rs = ps3.executeQuery();
				int i=0;
				while(rs.next()) {
					sc1[i]= new JPanel();
					sc1[i].setPreferredSize(new Dimension(200, 200)); 
					sc1[i].setBackground(Color.white);
					sc1[i].setBorder(new LineBorder(new Color(0, 0, 0), 2));
					sc1[i].setLayout(null);
					la[i] = new JLabel("");
					la[i].setIcon(new ImageIcon("C:\\Users\\Tirumurugaa R S\\Downloads\\Bike-512.jpg"));
					la[i].setBounds(30, 26, 80, 80);
					sc1[i].add(la[i]);
					la1[i] = new JLabel("");
					la1[i].setText("R"+" "+rs.getString("i")+" "+rs.getString("j"));
				    //la[i].setIcon(new ImageIcon("C:\\Users\\Tirumurugaa R S\\Downloads\\Bike-512.jpg"));
				    la[i].setIcon(new ImageIcon("C:\\Users\\Tirumurugaa R S\\Downloads\\car (1) (1).png"));
				    la1[i].setFont(new Font("Tahoma", Font.BOLD, 14));
					//la1[i].setHorizontalAlignment(SwingConstants.CENTER);
					la1[i].setBounds(42, 80, 150, 51);
					sc1[i].add(la1[i]);
					la2[i] = new JLabel("");
					la2[i].setText("IN                :"+rs.getString("EntryDateTime"));
					la2[i].setFont(new Font("Tahoma", Font.BOLD, 14));
					//la2[i].setHorizontalAlignment(SwingConstants.CENTER);
					la2[i].setBounds(120, 52, 466, 30);
					sc1[i].add(la2[i]);
					la3[i] = new JLabel("");
					la3[i].setText("OUT             :"+rs.getString("ExitDateTime"));
					la3[i].setFont(new Font("Tahoma", Font.BOLD, 14));
					//la3[i].setHorizontalAlignment(SwingConstants.CENTER);
					la3[i].setBounds(120, 80, 466, 30);
					sc1[i].add(la3[i]);
					la4[i] = new JLabel();
					la4[i].setText("Name          :"+rs.getString("Name"));
					la4[i].setFont(new Font("Tahoma", Font.BOLD, 14));
					//la4[i].setHorizontalAlignment(SwingConstants.CENTER);
					la4[i].setBounds(120, 26, 386, 30);
					sc1[i].add(la4[i]);
					la5[i] = new JLabel();
					la5[i].setText("Phone No    :"+rs.getString("Mobile"));
					la5[i].setFont(new Font("Tahoma", Font.BOLD, 14));
					//la4[i].setHorizontalAlignment(SwingConstants.CENTER);
					la5[i].setBounds(120, 134, 314, 30);
					sc1[i].add(la5[i]);
					la6[i] = new JLabel();
					la6[i].setText("Vehicle No  :"+rs.getString("VehicleNo"));
					la6[i].setFont(new Font("Tahoma", Font.BOLD, 14));
					//la4[i].setHorizontalAlignment(SwingConstants.CENTER);
					la6[i].setBounds(120, 107, 314, 30);
					sc1[i].add(la6[i]);
					//sc1[i].add(la7[i]);
	                panel2.add(sc1[i]);
					i++;
				}
		 }catch(Exception tu) {
			 tu.printStackTrace();
		 }
		 JScrollPane scrollPane_2 = new JScrollPane();
		 scrollPane_2.setBounds(510, 70, 400, 320);
		 panel1.add(scrollPane_2);
		 panel3=new JPanel();
		 scrollPane_2.setViewportView(panel3);
		 panel3.setBackground(Color.white);
		 panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
		 //JPanel panel_1 = new JPanel();
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con =(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","tiru@2607");
			 String sql = "select * from entry where vtype='4Wheeler' and IsExit<>'F'";
			 PreparedStatement pst = con.prepareStatement(sql);
			 ResultSet rs = pst.executeQuery();
			// DefaultTableModel dt=(DefaultTableModel)table.getModel(); 
			/*dt.setRowCount(0);
			 while(rs.next()) {
				 Object o[]= {rs.getString("Name"),rs.getString("VehicleNo"),rs.getString("EntryDateTime"),rs.getString("ExitDateTime"),rs.getString("i")+" "+rs.getString("j")
						 
				 };
				 dt.addRow(o);
			 }
			 */
		 }catch(Exception yu) {
			 yu.printStackTrace();
		 }
		 
		 
		 JButton btnNewButton_1 = new JButton("BACK");
		 btnNewButton_1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		adminlogin nk =new adminlogin();
		 		nk.setVisible(true);
		 		SwingUtilities.windowForComponent(btnNewButton_1).dispose();
		 	}
		 });
		 btnNewButton_1.setBounds(24, 7, 85, 21);
		 contentPane.add(btnNewButton_1);
		 //
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con =(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","tiru@2607");
			 String sql = "select * from entry where vtype='2Wheeler' and IsExit<>'F'";
			 PreparedStatement pst = con.prepareStatement(sql);
			 ResultSet rs = pst.executeQuery();
			 //DefaultTableModel dt=(DefaultTableModel)table.getModel(); 
			 /*dt1.setRowCount(0);
			 while(rs.next()) {
				 Object o[]= {rs.getString("Name"),rs.getString("VehicleNo"),rs.getString("EntryDateTime"),rs.getString("ExitDateTime"),rs.getString("i")+" "+rs.getString("j")
						 
				 };
				 dt1.addRow(o);
			 }*/
			 
		 }catch(Exception yu) {
			 yu.printStackTrace();
		 }
		 //
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","tiru@2607");
				String sql = "Select * from entry where vtype = '4Wheeler'";
				PreparedStatement ps3=con.prepareStatement(sql);
				ResultSet rs = ps3.executeQuery();
				int i=0;
				while(rs.next()) {
					sc11[i]= new JPanel();
					sc11[i].setPreferredSize(new Dimension(200, 200)); 
					sc11[i].setBackground(Color.white);
					sc11[i].setBorder(new LineBorder(new Color(0, 0, 0), 2));
					sc11[i].setLayout(null);
					la111[i] = new JLabel("");
					la111[i].setIcon(new ImageIcon("C:\\Users\\Tirumurugaa R S\\Downloads\\Bike-512.jpg"));
					la111[i].setBounds(20, 26, 80, 80);
					sc11[i].add(la111[i]);
					la11[i] = new JLabel("");
					la11[i].setText("S"+" "+rs.getString("i")+" "+rs.getString("j"));
				    //la[i].setIcon(new ImageIcon("C:\\Users\\Tirumurugaa R S\\Downloads\\Bike-512.jpg"));
				    la111[i].setIcon(new ImageIcon("C:\\Users\\Tirumurugaa R S\\Downloads\\man (1).png"));
				    la11[i].setFont(new Font("Tahoma", Font.BOLD, 14));
					//la1[i].setHorizontalAlignment(SwingConstants.CENTER);
					la11[i].setBounds(42, 95, 150, 51);
					sc11[i].add(la11[i]);
					la21[i] = new JLabel("");
					la21[i].setText("IN                :"+rs.getString("EntryDateTime"));
					la21[i].setFont(new Font("Tahoma", Font.BOLD, 14));
					//la2[i].setHorizontalAlignment(SwingConstants.CENTER);
					la21[i].setBounds(120, 52, 466, 30);
					sc11[i].add(la21[i]);
					la31[i] = new JLabel("");
					la31[i].setText("OUT             :"+rs.getString("ExitDateTime"));
					la31[i].setFont(new Font("Tahoma", Font.BOLD, 14));
					//la3[i].setHorizontalAlignment(SwingConstants.CENTER);
					la31[i].setBounds(120, 80, 466, 30);
					sc11[i].add(la31[i]);
					la41[i] = new JLabel();
					la41[i].setText("Name          :"+rs.getString("Name"));
					la41[i].setFont(new Font("Tahoma", Font.BOLD, 14));
					//la4[i].setHorizontalAlignment(SwingConstants.CENTER);
					la41[i].setBounds(120, 26, 386, 30);
					sc11[i].add(la41[i]);
					la51[i] = new JLabel();
					la51[i].setText("Phone No    :"+rs.getString("Mobile"));
					la51[i].setFont(new Font("Tahoma", Font.BOLD, 14));
					//la4[i].setHorizontalAlignment(SwingConstants.CENTER);
					la51[i].setBounds(120, 134, 314, 30);
					sc11[i].add(la51[i]);
					la61[i] = new JLabel();
					la61[i].setText("Vehicle No  :"+rs.getString("VehicleNo"));
					la61[i].setFont(new Font("Tahoma", Font.BOLD, 14));
					//la4[i].setHorizontalAlignment(SwingConstants.CENTER);
					la61[i].setBounds(120, 107, 314, 30);
					sc11[i].add(la61[i]);
					//sc1[i].add(la7[i]);
	                panel3.add(sc11[i]);
					i++;
				}
		 }catch(Exception tu) {
			 tu.printStackTrace();
		 }
	}
}
