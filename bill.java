package vehicleparking;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.Font;
import vehicleparking.page1;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.event.ActionEvent;
public class Bill extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String as;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bill frame = new Bill();
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
	public Bill() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		if((page1.vt).equals("4Wheeler")) {
			 as = "R";
		}
		else {
			as ="S";
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 617, 369);
		contentPane.add(scrollPane);
	    textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.append("\n\n\n"+
				"Phone NO:9486829737\t\t\twww.vehicleparking.com\n"+
				"Fax:0427-122333\t\t\temail:vehiclepark@gmail.com\n\n\n"+
				"\t\tVehicle Parking\n\n"+
				"\t\t     BILL SUMMARY\n\n"+
				"Reference NO: \t\t\t vinoth5678" +
				"\n=======================================================================\n\n"+
				"Parking Slot:\t\t\t"+as+" "+page1.a12[0]+" "+page1.a12[1]+"\n"+
				"-----------------------------------------------------------------------------------------------------------------------\n"+
				
				"Name:\t\t\t"+page1.n+"\n"+
				"-----------------------------------------------------------------------------------------------------------------------\n"+
				"Vehicle Type:\t\t\t"+page1.vt+"\n"+
				"-----------------------------------------------------------------------------------------------------------------------\n"+
				"Vehicle No:\t\t\t"+page1.vn+"\n"+
				"-----------------------------------------------------------------------------------------------------------------------\n"+
				"Vehicle In:\t\t\t"+page1.timein+"\n"+
				"-----------------------------------------------------------------------------------------------------------------------\n"+
				"Phone No:\t\t\t"+page1.pn+"\n"+
				"-----------------------------------------------------------------------------------------------------------------------\n"+
				"Amount:\t\t\tRs:"+"20"+"\n"+
				"-----------------------------------------------------------------------------------------------------------------------\n"+
				
				"==========================================================================\n\n\n\n\n"+
				"\t\tTHANK YOU :))\n"+
				"\t \n"
				
				
				
				);
		
		JButton btnNewButton = new JButton("Print");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					textArea.print();
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnNewButton.setBounds(191, 389, 111, 40);
		contentPane.add(btnNewButton);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new page1().setVisible(true);
				SwingUtilities.windowForComponent(btnExit).dispose();
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnExit.setBounds(320, 389, 111, 40);
		contentPane.add(btnExit);
	}
}
