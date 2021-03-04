import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class GUIController {
	
	private JavaClient jc;
	private GUI gui;
	
	GUIController(JavaClient jc, GUI gui) {
		this.jc = jc;
		this.gui = gui;
		
		gui.addTrackListener(new TrackListener());
	}

	class TrackListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String mailInput = "";
			String passwordInput = "";
			String idInput = "";

			mailInput = gui.getCustomerMail();
			passwordInput = gui.getCustomerPassword();
			idInput = gui.getOrderId();
			
			try {
				gui.setText(jc.track(mailInput, passwordInput, idInput));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}
	
}
