package vehicleparking;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import vehicleparking.History;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.event.ActionEvent;

public class historybill extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea textArea;
	private JButton btnExit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					historybill frame = new historybill();
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
	public historybill() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 660);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 550, 550);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		//
		String[] n = History.name.split(" :");
		String[] vi = History.timein.split(" :");
		String[] vn1= History.vn.split(" :");
		String[] vo = History.timeout.split(" :");
		String[] phn = History.pn.split(" :");
		//
		textArea.append("\n\n\n"+
				"Phone NO:9486829737\t\t\t    www.vehicleparking.com\n"+
				"Fax:0427-122333\t\t\t    email:vehiclepark@gmail.com\n\n\n"+
				"\t\t      VEHICLE PARKING\n\n"+
				"\t\t        BILL  SUMMARY\n\n"+
				"Reference NO: \t\t\t\t Sujjith5678" +
				"\n=======================================================================\n\n"+
				"Parking Slot:\t\t\t\t"+History.Slot+"\n"+
				"-----------------------------------------------------------------------------------------------------------------------\n"+
				
				"Name:\t\t\t\t"+n[1]+"\n"+
				"-----------------------------------------------------------------------------------------------------------------------\n"+
				"Vehicle Type:\t\t\t\t"+History.vt+"\n"+
				"-----------------------------------------------------------------------------------------------------------------------\n"+
				"Vehicle No:\t\t\t\t"+vn1[1]+"\n"+
				"-----------------------------------------------------------------------------------------------------------------------\n"+
				"Vehicle In:\t\t\t\t"+vi[1]+"\n"+
				"-----------------------------------------------------------------------------------------------------------------------\n"+
				"Vehicle Out:\t\t\t\t"+vo[1]+"\n"+
				"-----------------------------------------------------------------------------------------------------------------------\n"+
				"Phone No:\t\t\t\t"+phn[1]+"\n"+
				"-----------------------------------------------------------------------------------------------------------------------\n"+
				"Amount:\t\t\t\tRs:"+"20"+"\n"+
				"-----------------------------------------------------------------------------------------------------------------------\n"+
				
				"==========================================================================\n\n\n\n\n"+
				"\t\tTHANK YOU :))\n"+
				"\t \n"
				);
		//
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
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(180, 577, 85, 40);
		contentPane.add(btnNewButton);
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				History nf = new History();
				nf.setVisible(true);
				SwingUtilities.windowForComponent(btnExit).dispose();
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnExit.setBounds(290, 577, 85, 40);
		contentPane.add(btnExit);
	}
}
