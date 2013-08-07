import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;


public class graphW {

	private JFrame frmEagle;
	private String graphName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					graphW window = new graphW("");
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
	public graphW(String graphName) {
		this.graphName = graphName;
		
		System.out.println(graphName);
		initialize();
		frmEagle.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEagle = new JFrame();
		frmEagle.setTitle("EAGLE TREE - Graphs");
		int length = (int)(450 * 1.5);
		int height = (int)(300 * 1.5);
		frmEagle.setBounds(100, 100, length, height);
		frmEagle.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setOpaque(true);
		btnNewButton.setRequestFocusEnabled(false);
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 5));
		btnNewButton.setIcon(new ImageIcon(graphName));
		//btnNewButton.setBounds(6, 265, 938, 187);
		frmEagle.getContentPane().add(btnNewButton);
	}

}
