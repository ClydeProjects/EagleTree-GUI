import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JSlider;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JFormattedTextField;
import javax.swing.border.LineBorder;
import javax.swing.JScrollBar;
import javax.swing.JToggleButton;


public class Game {

	JFrame frmEagletreeThe;
	private JTextField txtGautamDas;
	private JTextField txtMs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game window = new Game();
					window.frmEagletreeThe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Game() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEagletreeThe = new JFrame();
		frmEagletreeThe.setTitle("EagleTree - The game");
		frmEagletreeThe.setBounds(100, 100, 574, 562);
		frmEagletreeThe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmEagletreeThe.getContentPane().setLayout(null);
		
		JTextPane txtpnHiddenHiddenHidden = new JTextPane();
		txtpnHiddenHiddenHidden.setEnabled(false);
		txtpnHiddenHiddenHidden.setText(" Hidden\n Hidden\n Hidden\n Hidden");
		txtpnHiddenHiddenHidden.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtpnHiddenHiddenHidden.setBounds(348, 354, 59, 142);
		frmEagletreeThe.getContentPane().add(txtpnHiddenHiddenHidden);
		
		JTextPane txtpnInThisGame = new JTextPane();
		txtpnInThisGame.setForeground(Color.BLUE);
		txtpnInThisGame.setText("In this game, everything is fixed except");
		txtpnInThisGame.setEditable(false);
		txtpnInThisGame.setBackground(UIManager.getColor("Button.background"));
		txtpnInThisGame.setBounds(316, 7, 252, 19);
		frmEagletreeThe.getContentPane().add(txtpnInThisGame);
		
		JLabel lblGoal = new JLabel("Goal:");
		lblGoal.setHorizontalAlignment(SwingConstants.CENTER);
		lblGoal.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblGoal.setBounds(262, 5, 59, 19);
		frmEagletreeThe.getContentPane().add(lblGoal);
		
		JTextPane txtpnDimitriosGunopulosUniversity = new JTextPane();
		txtpnDimitriosGunopulosUniversity.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtpnDimitriosGunopulosUniversity.setText("Anna\nOscar\nTheo\nClara\n");
		txtpnDimitriosGunopulosUniversity.setBounds(267, 354, 82, 142);
		frmEagletreeThe.getContentPane().add(txtpnDimitriosGunopulosUniversity);
		
		JLabel lblResults = new JLabel("Registered scores");
		lblResults.setForeground(Color.RED);
		lblResults.setHorizontalAlignment(SwingConstants.CENTER);
		lblResults.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblResults.setBounds(263, 311, 298, 21);
		frmEagletreeThe.getContentPane().add(lblResults);
		
		JLabel lblChoose = new JLabel("1 - Choose the scheduling strategy");
		lblChoose.setForeground(Color.BLUE);
		lblChoose.setHorizontalAlignment(SwingConstants.CENTER);
		lblChoose.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblChoose.setBounds(0, 5, 252, 21);
		frmEagletreeThe.getContentPane().add(lblChoose);
		
		JTextPane txtpnAppReadsApp = new JTextPane();
		txtpnAppReadsApp.setForeground(Color.RED);
		txtpnAppReadsApp.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		txtpnAppReadsApp.setBackground(UIManager.getColor("Button.background"));
		txtpnAppReadsApp.setText("App. Reads\nApp. Writes\nIntern. Reads\nIntern. Writes\nIntern. Erases");
		txtpnAppReadsApp.setBounds(24, 43, 101, 80);
		frmEagletreeThe.getContentPane().add(txtpnAppReadsApp);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(Color.PINK);
		btnNewButton.setBounds(10, 29, 120, 108);
		frmEagletreeThe.getContentPane().add(btnNewButton);
		
		JTextPane txtpnInternReadsIntern = new JTextPane();
		txtpnInternReadsIntern.setText("Intern. Reads\nIntern. Writes\nIntern. Erases\nApp. Reads\nApp. Writes\n");
		txtpnInternReadsIntern.setForeground(Color.RED);
		txtpnInternReadsIntern.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		txtpnInternReadsIntern.setBackground(UIManager.getColor("Button.background"));
		txtpnInternReadsIntern.setBounds(139, 43, 101, 80);
		frmEagletreeThe.getContentPane().add(txtpnInternReadsIntern);
		
		JTextPane txtpnAppReadsIntern = new JTextPane();
		txtpnAppReadsIntern.setText("App. Reads\nIntern. Reads\nApp. Writes\nIntern. Writes\nIntern. Erases");
		txtpnAppReadsIntern.setForeground(Color.RED);
		txtpnAppReadsIntern.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		txtpnAppReadsIntern.setBackground(UIManager.getColor("Button.background"));
		txtpnAppReadsIntern.setBounds(24, 149, 101, 80);
		frmEagletreeThe.getContentPane().add(txtpnAppReadsIntern);
		
		JTextPane txtpnFirstInFirst = new JTextPane();
		txtpnFirstInFirst.setText("  FIRST IN\n\nFIRST OUT");
		txtpnFirstInFirst.setForeground(Color.RED);
		txtpnFirstInFirst.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		txtpnFirstInFirst.setBackground(UIManager.getColor("Button.background"));
		txtpnFirstInFirst.setBounds(152, 161, 70, 73);
		frmEagletreeThe.getContentPane().add(txtpnFirstInFirst);
		
		JButton button = new JButton("");
		button.setBackground(Color.PINK);
		button.setBounds(128, 29, 120, 108);
		frmEagletreeThe.getContentPane().add(button);
		
		JButton button_1 = new JButton("");
		button_1.setBackground(Color.PINK);
		button_1.setBounds(128, 135, 120, 108);
		frmEagletreeThe.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setBackground(Color.PINK);
		button_2.setBounds(10, 135, 120, 108);
		frmEagletreeThe.getContentPane().add(button_2);
		
		JTextPane txtpnAppWritesIntern = new JTextPane();
		txtpnAppWritesIntern.setText("App. Writes\nIntern. Writes\nApp. Reads\nIntern. Reads\nIntern. Erases");
		txtpnAppWritesIntern.setForeground(Color.RED);
		txtpnAppWritesIntern.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		txtpnAppWritesIntern.setBackground(UIManager.getColor("Button.background"));
		txtpnAppWritesIntern.setBounds(24, 255, 101, 80);
		frmEagletreeThe.getContentPane().add(txtpnAppWritesIntern);
		
		JTextPane txtpnAppReadsIntern_1 = new JTextPane();
		txtpnAppReadsIntern_1.setText("App. Reads\nIntern. Reads\nIntern. Erases\nApp. Writes\nIntern. Writes");
		txtpnAppReadsIntern_1.setForeground(Color.RED);
		txtpnAppReadsIntern_1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		txtpnAppReadsIntern_1.setBackground(UIManager.getColor("Button.background"));
		txtpnAppReadsIntern_1.setBounds(139, 255, 101, 80);
		frmEagletreeThe.getContentPane().add(txtpnAppReadsIntern_1);
		
		JButton button_4 = new JButton("");
		button_4.setBackground(Color.PINK);
		button_4.setBounds(10, 241, 120, 108);
		frmEagletreeThe.getContentPane().add(button_4);
		
		JButton button_3 = new JButton("");
		button_3.setBackground(Color.PINK);
		button_3.setBounds(128, 241, 120, 108);
		frmEagletreeThe.getContentPane().add(button_3);
		
		JLabel lblChoose_1 = new JLabel("2 - Choose the deadline");
		lblChoose_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblChoose_1.setForeground(Color.BLUE);
		lblChoose_1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblChoose_1.setBounds(6, 357, 252, 21);
		frmEagletreeThe.getContentPane().add(lblChoose_1);
		
		JSlider slider = new JSlider();
		slider.setValue(24);
		slider.setBounds(0, 378, 252, 29);
		frmEagletreeThe.getContentPane().add(slider);
		
		JButton btnNewButton_1 = new JButton("RUN");
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1.setForeground(Color.BLUE);
		btnNewButton_1.setBounds(193, 430, 59, 29);
		frmEagletreeThe.getContentPane().add(btnNewButton_1);
		
		JLabel lblRun = new JLabel("3 - Run the simulation");
		lblRun.setHorizontalAlignment(SwingConstants.LEFT);
		lblRun.setForeground(Color.BLUE);
		lblRun.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblRun.setBounds(6, 433, 252, 21);
		frmEagletreeThe.getContentPane().add(lblRun);
		
		JLabel lblRegister = new JLabel("4 - Register your score :)");
		lblRegister.setHorizontalAlignment(SwingConstants.LEFT);
		lblRegister.setForeground(Color.BLUE);
		lblRegister.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblRegister.setBounds(6, 471, 252, 21);
		frmEagletreeThe.getContentPane().add(lblRegister);
		
		txtGautamDas = new JTextField();
		txtGautamDas.setText("Ta\u00EFna");
		txtGautamDas.setBounds(16, 504, 149, 28);
		frmEagletreeThe.getContentPane().add(txtGautamDas);
		txtGautamDas.setColumns(10);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setHorizontalAlignment(SwingConstants.LEFT);
		btnRegister.setForeground(Color.BLUE);
		btnRegister.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnRegister.setBounds(164, 505, 88, 29);
		frmEagletreeThe.getContentPane().add(btnRegister);
		
		JLabel lblMs = new JLabel("0 ms");
		lblMs.setBounds(10, 405, 42, 16);
		frmEagletreeThe.getContentPane().add(lblMs);
		
		JLabel lblMs_1 = new JLabel("5 ms");
		lblMs_1.setBounds(210, 405, 42, 16);
		frmEagletreeThe.getContentPane().add(lblMs_1);
		
		txtMs = new JTextField();
		txtMs.setHorizontalAlignment(SwingConstants.CENTER);
		txtMs.setText("1.2 ms");
		txtMs.setBounds(179, 354, 59, 28);
		frmEagletreeThe.getContentPane().add(txtMs);
		txtMs.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLUE);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(245, 0, 17, 527);
		frmEagletreeThe.getContentPane().add(separator);
		
		JTextPane txtpnXXX = new JTextPane();
		txtpnXXX.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtpnXXX.setText("950\n1020\n890\n1300\n");
		txtpnXXX.setBounds(406, 354, 36, 142);
		frmEagletreeThe.getContentPane().add(txtpnXXX);
		
		JTextPane txtpnXXX_1 = new JTextPane();
		txtpnXXX_1.setText("1100\n1210\n1800\n2100\n");
		txtpnXXX_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtpnXXX_1.setBounds(441, 354, 36, 142);
		frmEagletreeThe.getContentPane().add(txtpnXXX_1);
		
		JTextPane txtpnXXX_2 = new JTextPane();
		txtpnXXX_2.setText(" 300\n 335\n 530\n 450");
		txtpnXXX_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtpnXXX_2.setBounds(476, 354, 36, 142);
		frmEagletreeThe.getContentPane().add(txtpnXXX_2);
		
		JTextPane txtpnXXX_3 = new JTextPane();
		txtpnXXX_3.setText(" 180\n 147\n 155\n 120");
		txtpnXXX_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtpnXXX_3.setBounds(511, 354, 36, 142);
		frmEagletreeThe.getContentPane().add(txtpnXXX_3);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(546, 354, 15, 142);
		frmEagletreeThe.getContentPane().add(scrollBar);
		
		JTextPane txtpnForThisExperiment = new JTextPane();
		txtpnForThisExperiment.setForeground(Color.BLUE);
		txtpnForThisExperiment.setEditable(false);
		txtpnForThisExperiment.setBackground(UIManager.getColor("Button.background"));
		txtpnForThisExperiment.setText("the scheduling strategy and the deadlines for IOs. IOs that have passed the deadline are scheduled in FIFO. You must  find the best strategy for IOs that have not passed the deadline\u2026. and fix that deadline!. The goal is to obtain maximal throughput, minimum latency and minimal variability between IOs and types of IOs (reads/writes).");
		txtpnForThisExperiment.setBounds(274, 25, 300, 126);
		frmEagletreeThe.getContentPane().add(txtpnForThisExperiment);
		
		JTextPane txtpnReadLatencyrl = new JTextPane();
		txtpnReadLatencyrl.setText("Read Latency (RL):\t950 \u03BCs \nWrite Latency (WL):\t1100 \u03BCs\nVariability (V):\t300 \u03BCs\nThroughput(T):\t180 MB/s");
		txtpnReadLatencyrl.setBackground(UIManager.getColor("Button.background"));
		txtpnReadLatencyrl.setBounds(262, 226, 210, 73);
		frmEagletreeThe.getContentPane().add(txtpnReadLatencyrl);
		
		JTextPane txtpns = new JTextPane();
		txtpns.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		txtpns.setText("1120 \u03BCs\n1300 \u03BCs\n530 \u03BCs\n130 MB/s\n");
		txtpns.setBounds(478, 226, 78, 66);
		frmEagletreeThe.getContentPane().add(txtpns);
		
		JTextPane txtpnBestYourScore = new JTextPane();
		txtpnBestYourScore.setForeground(Color.RED);
		txtpnBestYourScore.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		txtpnBestYourScore.setText("Best \tYour\nscore\tscore");
		txtpnBestYourScore.setBackground(UIManager.getColor("Button.background"));
		txtpnBestYourScore.setBounds(413, 192, 120, 37);
		frmEagletreeThe.getContentPane().add(txtpnBestYourScore);
		
		JTextPane txtpnRlWlV = new JTextPane();
		txtpnRlWlV.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		txtpnRlWlV.setText("STRAT.    RL     WL     V      T");
		txtpnRlWlV.setBackground(UIManager.getColor("Button.background"));
		txtpnRlWlV.setBounds(348, 339, 202, 21);
		frmEagletreeThe.getContentPane().add(txtpnRlWlV);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("Show scheduling strategie");
		tglbtnNewToggleButton.setBounds(262, 503, 299, 29);
		frmEagletreeThe.getContentPane().add(tglbtnNewToggleButton);
	}
}
