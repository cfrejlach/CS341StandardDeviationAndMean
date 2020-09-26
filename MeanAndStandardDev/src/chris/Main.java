package chris;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileSystemView;

import org.w3c.dom.Text;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.io.File; 
import java.util.Scanner; 
// TODO: Auto-generated Javadoc

/**
 * The Class Main.
 * 
 * @author Chris
 */
public class Main {

	/** The frame. */
	private JFrame frame;
	
	/** The list. */
	public static LinkedList list = new LinkedList();
	
	

	/**
	 * Launch the application.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pick a file of numbers to get the mean and standard deviation of those numbers");
		lblNewLabel.setBounds(10, 37, 414, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(198, 147, 178, 22);
		frame.getContentPane().add(textArea);
		
		JLabel lblNewLabel_1 = new JLabel("Standard Deviation:");
		lblNewLabel_1.setBounds(49, 195, 100, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mean:");
		lblNewLabel_2.setBounds(49, 152, 73, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(198, 190, 178, 22);
		frame.getContentPane().add(textArea_1);
		
		JLabel lblNewLabel_3 = new JLabel("Standard Deviation and Mean Calculator");
		lblNewLabel_3.setFont(new Font("Valken", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(58, 0, 318, 26);
		frame.getContentPane().add(lblNewLabel_3);
		JButton btnNewButton = new JButton("press to add file ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//action when button is pressed
				JFileChooser fc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				int result = fc.showOpenDialog(null);
				if(result == fc.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					
					try {
						Calculator.calc(file);
						textArea.setText(String.valueOf(Calculator.getMean()));
						textArea_1.setText(String.valueOf(Calculator.getSD()));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setBounds(142, 62, 156, 23);
		frame.getContentPane().add(btnNewButton);
		
	}
}
