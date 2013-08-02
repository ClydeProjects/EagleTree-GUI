import java.awt.EventQueue;

import javax.swing.JFrame;


public class graphW {

	JFrame frmEagle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					graphW window = new graphW();
					window.frmEagle.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public graphW() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEagle = new JFrame();
		frmEagle.setTitle("EAGLE TREE - Graphs");
		frmEagle.setBounds(100, 100, 450, 300);
		frmEagle.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

}
