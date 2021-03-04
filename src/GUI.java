

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.Color;
import javax.swing.JButton;

public class GUI {

	private JFrame frame;
	private JTextField textField = new JTextField();;
	private JTextField textField_1 = new JTextField();;
	private JTextField textField_2 = new JTextField();;
	private JButton btnNewButton = new JButton("Track!");;
	private JTextField textField_3 = new JTextField();;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		JavaClient jc = new JavaClient();
		GUI gui = new GUI();
		@SuppressWarnings("unused")
		GUIController gcontroller = new GUIController(jc,gui);
		
		gui.frame.setVisible(true);
	}

	/**
	 * Create the application.
	 */
	public GUI() {
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
		
		JLabel lblNewLabel = new JLabel("Mail:");
		lblNewLabel.setBounds(10, 11, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setBounds(10, 49, 61, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField.setBounds(81, 8, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1.setBounds(81, 46, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Order ID:");
		lblNewLabel_2.setBounds(10, 90, 61, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_2.setBounds(81, 87, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		btnNewButton.setBounds(196, 86, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		textField_3.setBackground(Color.WHITE);
		textField_3.setEditable(false);
		textField_3.setBounds(10, 145, 414, 105);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
	}

	String getCustomerMail() {
	    return textField.getText();
	}
	
	String getCustomerPassword() {
	    return textField_1.getText();
	}

	String getOrderId() {
	    return textField_2.getText();
	}
	
	void addTrackListener(ActionListener e) {
		btnNewButton.addActionListener(e);
    }
	
	void setText(List<String> text) {
		textField_3.setText(String.join(",", text));
	}
	
}


