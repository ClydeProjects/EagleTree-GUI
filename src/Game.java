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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.JScrollBar;
import javax.swing.JToggleButton;


public class Game {

	JFrame frmEagletreeThe;
	private JTextField txtGautamDas;
	private JTextField txtMs;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton btnNewButton;
	private JTextPane txtpns;
	private JSlider slider;
	private JTextPane txtpnDimitriosGunopulosUniversity;
	private JTextPane txtpnXXX;
	private JTextPane txtpnXXX_1; 
	private JTextPane txtpnXXX_2;

	private int readLatency = 100;
	private int writeLatency = 200;
	private int throughput = 300;
	private int schedulerId = -1;

	final private static String eagleTreeExecutable = "../EagleTree/Experiments/game";
	final private static String srcLocation = "/home/niv/Desktop/GUI_eagle_tree/src/configuration.txt";
	final private static String resultsLocation = "/home/niv/Desktop/GUI_eagle_tree/src/";

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

	private void resetButtonColors() {
		button.setBackground(Color.PINK);
		button_1.setBackground(Color.PINK);
		button_2.setBackground(Color.PINK);
		button_3.setBackground(Color.PINK);
		button_4.setBackground(Color.PINK);
		btnNewButton.setBackground(Color.PINK);
	}

	private int readInt(String line) {
		line = line.replaceAll( "[^\\d]", "" );
		return Integer.parseInt(line);
	}

	private double readDouble(String line) {
		line = line.split(":")[1].trim();
		//line = line.replaceAll( "[^\\d]", "" );
		return Double.parseDouble(line);
	}

	private void loadResultsEntry(String line) {
		if (line.startsWith("avg writes latency:")) {			// YES
			writeLatency = (int)readDouble(line);
			System.out.println("avg writes latency: " + writeLatency);
		}
		else if (line.startsWith("avg reads latency:")) {			// YES
			readLatency = (int)readDouble(line);
			System.out.println("avg reads latency: " + readLatency);
		}
		else if (line.startsWith("total throughput:")) {
			throughput = readInt(line);
			System.out.println("throughput: " + throughput);
		}
	}

	private void loadResults() {
		System.out.println("load res");
		FileReader fr;
		try {
			fr = new FileReader("src/results.txt");
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			while (line != null) {
				loadResultsEntry(line);
				line = br.readLine();
			}
			txtpns.setText(readLatency + " \u03BCs\n" + writeLatency + " \u03BCs\n--- \u03BCs\n" + throughput + " IO/s");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	private void writeConfigFile() {
		double writeDeadline;
		double val = slider.getValue();
		if (val == 100) {
			writeDeadline = 10000000;
		} else {
			writeDeadline = val / 100. * 5; 
		}
		System.out.println("Writes deadline:  " + writeDeadline);

		String fileName = "src/configuration.txt";
		FileWriter outFile;
		try {
			outFile = new FileWriter(fileName);
			PrintWriter out = new PrintWriter(outFile);

			out.print("#SSD Architecture\n");
			out.print("\tSSD_SIZE 8\n");
			out.print("\tPACKAGE_SIZE 8\n");
			out.print("\tDIE_SIZE 1\n");
			out.print("\tPLANE_SIZE 512\n");
			out.print("\tBLOCK_SIZE 128\n");
			out.print("\tPAGE_SIZE 16\n");
			out.print("\tMAX_SSD_QUEUE_SIZE 64\n");
			out.print("\tOVER_PROVISIONING_FACTOR 0.7\n");

			out.print("#Operation timings\n");
			out.print("\tPAGE_READ_DELAY 115\n");
			out.print("\tPAGE_WRITE_DELAY 1600\n");
			out.print("\tBUS_DATA_DELAY 350\n");
			out.print("\tBLOCK_ERASE_DELAY 3000\n");
			out.print("\tBUS_CTRL_DELAY 5\n");

			out.print("#SSD Conctroller:\n");
			out.print("\tBLOCK_MANAGER_ID 0\n");
			out.print("\tGREED_SCALE 2\n");
			out.print("\tMAX_CONCURRENT_GC_OPS 64\n");
			out.print("\tFTL_IMPLEMENTATION 0\n");
			out.print("\tMAX_REPEATED_COPY_BACKS_ALLOWED 0\n");
			out.print("\tMAX_ITEMS_IN_COPY_BACK_MAP 0\n");
			out.print("\tWRITE_DEADLINE " + writeDeadline + "\n");
			out.print("\tREAD_DEADLINE 100000\n");
			out.print("\tENABLE_WEAR_LEVELING 0\n");
			out.print("\tALLOW_DEFERRING_TRANSFERS 1\n");
			out.print("\tSCHEDULING_SCHEME " + schedulerId + "\n");

			out.print("#Open Interface:\n");
			out.print("\tENABLE_TAGGING 0\n");

			out.print("#OS Scheduler:\n");
			out.print("\tOS_SCHEDULER 0\n");
			out.close();
			outFile.close();

			Runtime runtime = Runtime.getRuntime();
			String command_name = eagleTreeExecutable + " " + srcLocation + " " + resultsLocation;
			System.out.println(command_name);
			Process process = runtime.exec(command_name);
			InputStream is = process.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			loadResults();
		} catch (IOException e) {
			e.printStackTrace();
		}	
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

		txtpnDimitriosGunopulosUniversity = new JTextPane();
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

		/*JTextPane txtpnAppReadsApp = new JTextPane();
		txtpnAppReadsApp.setForeground(Color.RED);
		txtpnAppReadsApp.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		txtpnAppReadsApp.setBackground(UIManager.getColor("Button.background"));
		txtpnAppReadsApp.setText("App. Reads\nApp. Writes\nIntern. Reads\nIntern. Writes\nIntern. Erases");
		txtpnAppReadsApp.setBounds(24, 43, 101, 80);
		frmEagletreeThe.getContentPane().add(txtpnAppReadsApp);
		 */
		btnNewButton = new JButton("<html>Erases<br>App. Writes<br>App. Reads<br>Gc. Reads<br>gc. Writes</html>");
		btnNewButton.setBackground(Color.PINK);
		btnNewButton.setBounds(10, 29, 120, 108);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetButtonColors();
				btnNewButton.setBackground(Color.GRAY);
				schedulerId = 3;
			}
		});
		frmEagletreeThe.getContentPane().add(btnNewButton);

		//JTextPane txtpnInternReadsIntern = new JTextPane();


		/*txtpnInternReadsIntern.setText();
		txtpnInternReadsIntern.setForeground(Color.RED);
		txtpnInternReadsIntern.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		txtpnInternReadsIntern.setBackground(UIManager.getColor("Button.background"));
		txtpnInternReadsIntern.setBounds(139, 43, 101, 80);
		frmEagletreeThe.getContentPane().add(txtpnInternReadsIntern);*/

		/*JTextPane txtpnAppReadsIntern = new JTextPane();
		txtpnAppReadsIntern.setText("App. Reads\nIntern. Reads\nApp. Writes\nIntern. Writes\nIntern. Erases");
		txtpnAppReadsIntern.setForeground(Color.RED);
		txtpnAppReadsIntern.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		txtpnAppReadsIntern.setBackground(UIManager.getColor("Button.background"));
		txtpnAppReadsIntern.setBounds(24, 149, 101, 80);
		frmEagletreeThe.getContentPane().add(txtpnAppReadsIntern);
		 */
		/*JTextPane txtpnFirstInFirst = new JTextPane();
		txtpnFirstInFirst.setText("  FIRST IN\n\nFIRST OUT");
		txtpnFirstInFirst.setForeground(Color.RED);
		txtpnFirstInFirst.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		txtpnFirstInFirst.setBackground(UIManager.getColor("Button.background"));
		txtpnFirstInFirst.setBounds(152, 161, 70, 73);
		frmEagletreeThe.getContentPane().add(txtpnFirstInFirst);
		 */
		button = new JButton("<html>GC. Reads<br>GC. Writes<br>Erases<br>App. Reads<br>App. Writes</html>");
		button.setBackground(Color.PINK);
		button.setBounds(128, 29, 120, 108);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetButtonColors();
				button.setBackground(Color.GRAY);
				schedulerId = 2;
			}
		});
		frmEagletreeThe.getContentPane().add(button);

		button_1 = new JButton("<html>FIRST IN<br>FIRST OUT</html>");
		button_1.setBackground(Color.PINK);
		button_1.setBounds(128, 135, 120, 108);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetButtonColors();
				button_1.setBackground(Color.GRAY);
				schedulerId = 0;
			}
		});
		frmEagletreeThe.getContentPane().add(button_1);

		button_2 = new JButton("<html>App. Reads<br>GC. Reads<br>App. Writes<br>GC. Writes<br>GC. Erases</html>");
		button_2.setBackground(Color.PINK);
		button_2.setBounds(10, 135, 120, 108);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetButtonColors();
				button_2.setBackground(Color.GRAY);
			}
		});
		frmEagletreeThe.getContentPane().add(button_2);

		/*JTextPane txtpnAppWritesIntern = new JTextPane();
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
		frmEagletreeThe.getContentPane().add(txtpnAppReadsIntern_1);*/

		button_4 = new JButton("<html>App. Writes<br>GC. Writes<br>App. Reads<br>GC. Reads<br>Erases</html>");
		button_4.setBackground(Color.PINK);
		button_4.setBounds(10, 241, 120, 108);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetButtonColors();
				button_4.setBackground(Color.GRAY);
			}
		});
		frmEagletreeThe.getContentPane().add(button_4);


		button_3 = new JButton("<html>App. Reads<br>GC. Reads<br>Erases<br>App. Writes<br>GC. Writes</html>");
		button_3.setBackground(Color.PINK);
		button_3.setBounds(128, 241, 120, 108);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetButtonColors();
				button_3.setBackground(Color.GRAY);
				schedulerId = 1;
			}
		});
		frmEagletreeThe.getContentPane().add(button_3);

		JLabel lblChoose_1 = new JLabel("2 - Choose the deadline");
		lblChoose_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblChoose_1.setForeground(Color.BLUE);
		lblChoose_1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblChoose_1.setBounds(6, 357, 252, 21);
		frmEagletreeThe.getContentPane().add(lblChoose_1);

		slider = new JSlider();
		slider.setValue(100);
		slider.setBounds(0, 378, 252, 29);
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (slider.getValueIsAdjusting()) {
					double val = slider.getValue();
					if (val == 100) {
						txtMs.setText("\u221e");
					} else {
						double deadline = val / 100. * 5; 
						DecimalFormat df = new DecimalFormat("#.##");
						txtMs.setText(df.format(deadline) + "");
					}
				}    
			}	
		});
		frmEagletreeThe.getContentPane().add(slider);

		JButton btnNewButton_1 = new JButton("RUN");
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1.setForeground(Color.BLUE);
		btnNewButton_1.setBounds(193, 430, 59, 29);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (schedulerId == -1) {
					System.out.println("You must choose a scheduling scheme!");	
				}
				else {
					System.out.println("run!");	
					writeConfigFile();				
				}
			}
		});
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
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = txtGautamDas.getText().trim();
				if (name.compareTo("") != 0) {
					String readLatencies = txtpnXXX.getText() + readLatency + "\n";
					String writeLatencies = txtpnXXX_1.getText() + writeLatency + "\n";
					String throughputs = txtpnXXX_2.getText() + throughput + "\n";

					txtpnXXX.setText(readLatencies);
					txtpnXXX_1.setText(writeLatencies);
					txtpnXXX_2.setText(throughputs);
				}				
			}
		});
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
		txtMs.setText("\u221e");
		txtMs.setBounds(179, 354, 59, 28);
		frmEagletreeThe.getContentPane().add(txtMs);
		txtMs.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLUE);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(245, 0, 17, 527);
		frmEagletreeThe.getContentPane().add(separator);

		txtpnXXX = new JTextPane();
		txtpnXXX.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtpnXXX.setText("950\n1020\n890\n1300\n");
		txtpnXXX.setBounds(406, 354, 36, 142);
		frmEagletreeThe.getContentPane().add(txtpnXXX);

		txtpnXXX_1 = new JTextPane();
		txtpnXXX_1.setText("1100\n1210\n1800\n2100\n");
		txtpnXXX_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtpnXXX_1.setBounds(441, 354, 36, 142);
		frmEagletreeThe.getContentPane().add(txtpnXXX_1);

		txtpnXXX_2 = new JTextPane();
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

		txtpns = new JTextPane();
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

	class TableModel extends AbstractTableModel {

		//Two arrays used for the table data
		String[] columnNames = {"First Name", "Reads", "Writes", "Throughput" };

		Object[][] data = {
				{"Bob", "33", "33", "33" },
				{"John", "33", "33", "33" },
		};

		@Override
		public int getRowCount()
		{
			return data.length;
		}

		@Override
		public int getColumnCount()            
		{
			return columnNames.length;
		}

		@Override
		public Object getValueAt(int row, int column)
		{        
			return data[row][column];
		}

		//Used by the JTable object to set the column names
		@Override
		public String getColumnName(int column) {
			return columnNames[column];
		}

		//Used by the JTable object to render different
		//functionality based on the data type
		@Override
		public Class getColumnClass(int c) {
			return getValueAt(0, c).getClass();
		}

		@Override
		public boolean isCellEditable(int row, int column)
		{
			if (column == 0 || column == 1)
			{
				return false;
			}
			else
			{
				return false;
			}
		}
	}       
}
