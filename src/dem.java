import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JSplitPane;

import java.awt.BorderLayout;

import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.UIManager;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JToolBar;
import javax.swing.JScrollBar;

import java.awt.GridLayout;

import javax.swing.JTextPane;
import javax.swing.JLabel;

import java.awt.Font;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JToggleButton;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.ImageIcon;

import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import java.io.*;
import java.util.*;

public class dem {

	private JFrame frmEagleTree;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField txtB;
	private JTextField txts;
	private JTextField txts_1;
	private JTextField txts_2;
	private JTextField txts_3;
	private JTextField txts_4;
	private JTextField txts_5;
	private JTextField txtReadMbs;
	private JTextField txtRead;
	private JTextField txtRead_1;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField txtInfinite;
	private JTextField textField_14;
	private JTextField textField_15;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	private JComboBox comboBox_3;
	private JComboBox comboBox_4;
	private JCheckBox chckbxIoPriorities;
	private JCheckBox chckbxTemperatures; 
	private JCheckBox chckbxLocality ;
	private JList list;
	
	final private static String eagleTreeExecutable = "../EagleTree/Experiments/config_loader";
	final private static String srcLocation = "/home/niv/Desktop/GUI_eagle_tree/src/configuration.txt";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dem window = new dem();
					window.frmEagleTree.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public dem() {
		initialize();
	}
	
	private void writeFile() {
		String ssdSize = textField.getText();
		String packageSize = textField_1.getText();
		String dieSize = "1";
		String planeSize = textField_2.getText();
		String blockSize = textField_3.getText();
		int page = Integer.parseInt( textField_11.getText() ) * 1024;
		String pageSize = page + "";
		
		String read = textField_4.getText();
		String write = textField_8.getText();
		String transfer = textField_12.getText();
		String erase = textField_9.getText();
		String command = textField_13.getText();
		
		String mapping = comboBox.getSelectedIndex() + "";
		String scheduling = comboBox_2.getSelectedIndex() + "";
		
		String readDeadline = textField_5.getText();
		String writeDeadline = textField_6.getText();
		String interleaving = comboBox_1.getSelectedIndex() + "";
		
		String queueSize = textField_10.getText();
		String bm = comboBox_3.getSelectedIndex() + "";
		String gcGreediness = textField_7.getText();
		String maxOngoingGcOperations = txtInfinite.getText();
		
		String enableWearLeveling = comboBox_4.getSelectedIndex() + "";
		String overprovisioningFactor = textField_14.getText();
		String maxCopyBacksPerPage = textField_15.getText();
		
		String tagging = "" + (chckbxLocality.isSelected() ? 1 : 0);
		
		String osScheduler = list.getSelectedIndex() + "";
		
		System.out.println("ssd_size: " + ssdSize);
		
		String fileName = "src/configuration.txt";
		FileWriter outFile;
		try {
			outFile = new FileWriter(fileName);
			PrintWriter out = new PrintWriter(outFile);
			
			out.print("#SSD Architecture\n");
			out.print("\tSSD_SIZE " + ssdSize + "\n");
			out.print("\tPACKAGE_SIZE " + packageSize + "\n");
			out.print("\tDIE_SIZE " + dieSize + "\n");
			out.print("\tPLANE_SIZE " + planeSize + "\n");
			out.print("\tBLOCK_SIZE " + blockSize + "\n");
			out.print("\tPAGE_SIZE " + pageSize + "\n");
			out.print("\tMAX_SSD_QUEUE_SIZE " + queueSize + "\n");
			out.print("\tOVER_PROVISIONING_FACTOR " + overprovisioningFactor + "\n");
			
			out.print("#Operation timings\n");
			out.print("\tPAGE_READ_DELAY " + read + "\n");
			out.print("\tPAGE_WRITE_DELAY " + write + "\n");
			out.print("\tBUS_DATA_DELAY " + transfer + "\n");
			out.print("\tBLOCK_ERASE_DELAY " + erase + "\n");
			out.print("\tBUS_CTRL_DELAY " + command + "\n");
			
			out.print("#SSD Conctroller:\n");
			out.print("\tBLOCK_MANAGER_ID " + bm + "\n");
			out.print("\tGREED_SCALE " + gcGreediness + "\n");
			out.print("\tMAX_CONCURRENT_GC_OPS " + maxOngoingGcOperations + "\n");
			out.print("\tFTL_IMPLEMENTATION " + mapping + "\n");
			out.print("\tMAX_REPEATED_COPY_BACKS_ALLOWED " + maxCopyBacksPerPage + "\n");
			out.print("\tMAX_ITEMS_IN_COPY_BACK_MAP " + command + "\n");
			out.print("\tWRITE_DEADLINE " + writeDeadline + "\n");
			out.print("\tREAD_DEADLINE " + readDeadline + "\n");
			out.print("\tENABLE_WEAR_LEVELING " + enableWearLeveling + "\n");
			out.print("\tALLOW_DEFERRING_TRANSFERS " + interleaving + "\n");
			out.print("\tSCHEDULING_SCHEME " + scheduling + "\n");
			
			out.print("#Open Interface:\n");
			out.print("\tENABLE_TAGGING " + tagging + "\n");
			
			out.print("#OS Scheduler:\n");
			out.print("\tOS_SCHEDULER " + osScheduler + "\n");
			out.close();
			outFile.close();
			
			Runtime runtime = Runtime.getRuntime();
		    Process process;
		    String command_name = eagleTreeExecutable + " " + srcLocation + " /gui_experiment";
		    process = runtime.exec(command_name);
			InputStream is = process.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String line;
			while ((line = br.readLine()) != null) {
		    	System.out.println(line);
		    }
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEagleTree = new JFrame();
		frmEagleTree.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEagleTree.setBounds(new Rectangle(0, 0, 950, 690));
		frmEagleTree.setTitle("EagleTree - Main control panel");
		frmEagleTree.getContentPane().setLayout(null);
		
		JLabel lblHardwareConfiguration = new JLabel("Hardware configuration");
		lblHardwareConfiguration.setBounds(19, 5, 187, 19);
		frmEagleTree.getContentPane().add(lblHardwareConfiguration);
		lblHardwareConfiguration.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		
		JLabel lblOpenInterface = new JLabel("Open interface");
		lblOpenInterface.setEnabled(false);
		lblOpenInterface.setBounds(606, 5, 115, 19);
		lblOpenInterface.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		frmEagleTree.getContentPane().add(lblOpenInterface);
		
		JLabel lblWorloadDefinition = new JLabel("Predefined settings");
		lblWorloadDefinition.setHorizontalAlignment(SwingConstants.CENTER);
		lblWorloadDefinition.setBounds(780, 5, 164, 19);
		lblWorloadDefinition.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		frmEagleTree.getContentPane().add(lblWorloadDefinition);
		
		JLabel lblControllerConfiguration = new JLabel("SSD Controller configuration");
		lblControllerConfiguration.setHorizontalAlignment(SwingConstants.CENTER);
		lblControllerConfiguration.setBounds(232, 5, 320, 19);
		lblControllerConfiguration.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		frmEagleTree.getContentPane().add(lblControllerConfiguration);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 29, 220, 201);
		frmEagleTree.getContentPane().add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblChannels = new JLabel("# Channels");
		panel.add(lblChannels, "2, 2, left, default");
		
		textField = new JTextField();
		textField.setFont(new Font("Lucida Grande", Font.BOLD, 10));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setText("8");
		panel.add(textField, "4, 2");
		textField.setColumns(5);
		
		JLabel lblLunschannel = new JLabel("# LUNs/channel");
		panel.add(lblLunschannel, "2, 4, left, default");
		
		textField_1 = new JTextField();
		textField_1.setText("8");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Lucida Grande", Font.BOLD, 10));
		textField_1.setColumns(5);
		panel.add(textField_1, "4, 4, fill, default");
		
		JLabel lblBlockslun = new JLabel("# Blocks/LUN");
		panel.add(lblBlockslun, "2, 6, left, default");
		
		textField_2 = new JTextField();
		textField_2.setText("512");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("Lucida Grande", Font.BOLD, 10));
		textField_2.setColumns(5);
		panel.add(textField_2, "4, 6, fill, default");
		
		JLabel lblPagesblock = new JLabel("# Pages/block");
		panel.add(lblPagesblock, "2, 8, left, default");
		
		textField_3 = new JTextField();
		textField_3.setText("128");
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setFont(new Font("Lucida Grande", Font.BOLD, 10));
		textField_3.setColumns(5);
		panel.add(textField_3, "4, 8, fill, default");
		
		JLabel lblPageSize = new JLabel("Page Size (KB)");
		panel.add(lblPageSize, "2, 10, left, default");
		
		textField_11 = new JTextField();
		textField_11.setText("16");
		textField_11.setHorizontalAlignment(SwingConstants.CENTER);
		textField_11.setFont(new Font("Lucida Grande", Font.BOLD, 10));
		textField_11.setColumns(5);
		panel.add(textField_11, "4, 10, fill, default");
		
		JLabel lblFlashTimings = new JLabel("Flash timings");
		lblFlashTimings.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		panel.add(lblFlashTimings, "2, 12, left, default");
		
		JLabel lblReadTiming = new JLabel("- Read (\u03BCs)");
		panel.add(lblReadTiming, "2, 14, left, default");
		
		textField_4 = new JTextField();
		textField_4.setText("115");
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setFont(new Font("Lucida Grande", Font.BOLD, 10));
		textField_4.setColumns(5);
		panel.add(textField_4, "4, 14, fill, default");
		
		JLabel lblWriteTimings = new JLabel("- Write (\u03BCs)");
		panel.add(lblWriteTimings, "2, 16, left, default");
		
		textField_8 = new JTextField();
		textField_8.setText("1600");
		textField_8.setHorizontalAlignment(SwingConstants.CENTER);
		textField_8.setFont(new Font("Lucida Grande", Font.BOLD, 10));
		textField_8.setColumns(5);
		panel.add(textField_8, "4, 16, fill, default");
		
		JLabel lblTransferTiming = new JLabel("- Transfer (\u03BCs)");
		panel.add(lblTransferTiming, "2, 18, left, default");
		
		textField_12 = new JTextField();
		textField_12.setText("350");
		textField_12.setHorizontalAlignment(SwingConstants.CENTER);
		textField_12.setFont(new Font("Lucida Grande", Font.BOLD, 10));
		textField_12.setColumns(5);
		panel.add(textField_12, "4, 18, fill, default");
		
		JLabel lblEraseTimings = new JLabel("- Erase (\u03BCs)");
		panel.add(lblEraseTimings, "2, 20, left, default");
		
		textField_9 = new JTextField();
		textField_9.setText("3000");
		textField_9.setHorizontalAlignment(SwingConstants.CENTER);
		textField_9.setFont(new Font("Lucida Grande", Font.BOLD, 10));
		textField_9.setColumns(5);
		panel.add(textField_9, "4, 20, fill, default");
		
		JLabel lblCommandTimings = new JLabel("- Command (\u03BCs)");
		panel.add(lblCommandTimings, "2, 22, left, default");
		
		textField_13 = new JTextField();
		textField_13.setText("5");
		textField_13.setHorizontalAlignment(SwingConstants.CENTER);
		textField_13.setFont(new Font("Lucida Grande", Font.BOLD, 10));
		textField_13.setColumns(5);
		panel.add(textField_13, "4, 22, fill, default");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(232, 29, 320, 201);
		frmEagleTree.getContentPane().add(scrollPane_1);
		
		JPanel panel_1 = new JPanel();
		scrollPane_1.setViewportView(panel_1);
		panel_1.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("42dlu:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblMapping = new JLabel("Mapping");
		lblMapping.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		panel_1.add(lblMapping, "2, 2, left, default");
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Pure Page Mapping", "DFTL"}));
		comboBox.setSelectedIndex(0);
		comboBox.setToolTipText("Pure page mapping");
		panel_1.add(comboBox, "4, 2, fill, default");
		
		JLabel lblScheduling = new JLabel("Scheduling");
		lblScheduling.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		panel_1.add(lblScheduling, "2, 4, left, default");
		
		comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"FIFO", "Smart", "AR/AW/IR/IW/E", "IR/IW/E/AR/AW", "AR/IR/AW/IW/E", "AW/IW/AR/IR/E", "AR/IR/IE/AW/IW"}));
		comboBox_2.setSelectedIndex(0);
		comboBox_2.setToolTipText("FIFO");
		panel_1.add(comboBox_2, "4, 4, fill, default");
		
		JLabel lblReadDeadline = new JLabel("- Read deadline");
		lblReadDeadline.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		panel_1.add(lblReadDeadline, "2, 6");
		
		textField_5 = new JTextField();
		textField_5.setText("20");
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setFont(new Font("Lucida Grande", Font.BOLD, 10));
		textField_5.setColumns(5);
		panel_1.add(textField_5, "4, 6, fill, default");
		
		JLabel lblWriteDeadline = new JLabel("- Write deadline");
		lblWriteDeadline.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		panel_1.add(lblWriteDeadline, "2, 8");
		
		textField_6 = new JTextField();
		textField_6.setText("400");
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setFont(new Font("Lucida Grande", Font.BOLD, 10));
		textField_6.setColumns(5);
		panel_1.add(textField_6, "4, 8, fill, default");
		
		JLabel lblInterleaving = new JLabel("- Interleaving");
		lblInterleaving.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		panel_1.add(lblInterleaving, "2, 10, left, default");
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Smart (defer transfers)", "Na\u00EFve"}));
		comboBox_1.setSelectedIndex(0);
		comboBox_1.setToolTipText("Pure page mapping");
		panel_1.add(comboBox_1, "4, 10, fill, default");
		
		JLabel lblSsdQueue = new JLabel("- SSD Queue Size");
		lblSsdQueue.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		panel_1.add(lblSsdQueue, "2, 12, left, default");
		
		textField_10 = new JTextField();
		textField_10.setText("64");
		textField_10.setHorizontalAlignment(SwingConstants.CENTER);
		textField_10.setFont(new Font("Lucida Grande", Font.BOLD, 10));
		textField_10.setColumns(5);
		panel_1.add(textField_10, "4, 12, fill, default");
		
		JLabel lblBlockManagement = new JLabel("Block management");
		lblBlockManagement.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		panel_1.add(lblBlockManagement, "2, 14");
		
		JLabel lblAllocationStrategy = new JLabel("- Allocation strategy");
		lblAllocationStrategy.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		panel_1.add(lblAllocationStrategy, "2, 16, right, default");
		
		comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Shortest queue (SQ)", "SQ + DWL", "SQ + Locality", "Round Robin"}));
		comboBox_3.setSelectedIndex(0);
		comboBox_3.setToolTipText("Shortest queue (SQ)");
		panel_1.add(comboBox_3, "4, 16, fill, default");
		
		JLabel lblGarbageCollection = new JLabel("Garbage Collection");
		lblGarbageCollection.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		panel_1.add(lblGarbageCollection, "2, 18");
		
		JLabel lblGcGreedyness = new JLabel("- GC greediness");
		lblGcGreedyness.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		panel_1.add(lblGcGreedyness, "2, 20, left, default");
		
		textField_7 = new JTextField();
		textField_7.setText("2");
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setFont(new Font("Lucida Grande", Font.BOLD, 10));
		textField_7.setColumns(5);
		panel_1.add(textField_7, "4, 20, fill, default");
		
		JLabel lblMaxGc = new JLabel("- Max GC OPs");
		lblMaxGc.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		panel_1.add(lblMaxGc, "2, 22, left, default");
		
		txtInfinite = new JTextField();
		txtInfinite.setText("64");
		txtInfinite.setHorizontalAlignment(SwingConstants.CENTER);
		txtInfinite.setFont(new Font("Lucida Grande", Font.BOLD, 10));
		txtInfinite.setColumns(5);
		panel_1.add(txtInfinite, "4, 22, fill, default");
		
		JLabel lblOverprovisioning = new JLabel("- Overprovisioning");
		lblOverprovisioning.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		panel_1.add(lblOverprovisioning, "2, 24, left, default");
		
		textField_14 = new JTextField();
		textField_14.setText("0.6");
		textField_14.setHorizontalAlignment(SwingConstants.CENTER);
		textField_14.setFont(new Font("Lucida Grande", Font.BOLD, 10));
		textField_14.setColumns(5);
		panel_1.add(textField_14, "4, 24, fill, default");
		
		JLabel lblStaticWearLeveling = new JLabel("Static Wear Leveling");
		lblStaticWearLeveling.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		panel_1.add(lblStaticWearLeveling, "2, 26, right, default");
		
		comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"Disabled", "Enabled"}));
		comboBox_4.setSelectedIndex(0);
		comboBox_4.setToolTipText("Disabled");
		panel_1.add(comboBox_4, "4, 26, fill, default");
		
		JLabel lblMaxCopybacks = new JLabel("Max Copybacks");
		lblMaxCopybacks.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		panel_1.add(lblMaxCopybacks, "2, 28, left, default");
		
		textField_15 = new JTextField();
		textField_15.setText("0");
		textField_15.setHorizontalAlignment(SwingConstants.CENTER);
		textField_15.setFont(new Font("Lucida Grande", Font.BOLD, 10));
		textField_15.setColumns(5);
		panel_1.add(textField_15, "4, 28, fill, default");
		
		JLabel label_1 = new JLabel("- GC greedyness");
		label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		panel_1.add(label_1, "2, 50");
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(564, 29, 204, 103);
		frmEagleTree.getContentPane().add(scrollPane_3);
		
		JPanel panel_2 = new JPanel();
		scrollPane_3.setViewportView(panel_2);
		panel_2.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		chckbxIoPriorities = new JCheckBox("Tagging");
		chckbxIoPriorities.setEnabled(false);
		panel_2.add(chckbxIoPriorities, "2, 2");
		
		chckbxTemperatures = new JCheckBox("Temperature");
		chckbxTemperatures.setEnabled(false);
		panel_2.add(chckbxTemperatures, "2, 4");
		
		chckbxLocality = new JCheckBox("Locality");
		chckbxLocality.setEnabled(true);
		panel_2.add(chckbxLocality, "2, 6");
		
		JLabel lblOsSceduling = new JLabel("OS Scheduling");
		lblOsSceduling.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblOsSceduling.setBounds(606, 166, 115, 19);
		frmEagleTree.getContentPane().add(lblOsSceduling);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(Color.GRAY));
		panel_4.setLayout(null);
		panel_4.setBounds(780, 29, 164, 103);
		frmEagleTree.getContentPane().add(panel_4);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(6, 6, 148, 91);
		panel_4.add(scrollPane_4);
		
		JList list_1 = new JList();
		list_1.setModel(new AbstractListModel() {
			String[] values = new String[] {"FIFO/NA\u00CFVE", "SMART/SMART", "FIFO/No Deadlines", "FIFO/Deadlines", "Block Device Interface", "Open Interface"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list_1.setSelectedIndex(6);
		list_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_4.setViewportView(list_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(564, 188, 204, 42);
		frmEagleTree.getContentPane().add(scrollPane_2);
		
		list = new JList();
		scrollPane_2.setViewportView(list);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"NOOP (FIFO)", "CFQ (Completely Fair Queuing)"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setSelectedIndex(0);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(Color.GRAY));
		panel_3.setBackground(new Color(250, 235, 215));
		panel_3.setBounds(6, 484, 220, 175);
		frmEagleTree.getContentPane().add(panel_3);
		panel_3.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("max(5dlu;default)"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(46dlu;default):grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(35dlu;default):grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblChannelUsage = new JLabel("Channel usage");
		panel_3.add(lblChannelUsage, "2, 2, left, default");
		
		JScrollPane scrollPane_5 = new JScrollPane();
		panel_3.add(scrollPane_5, "4, 2, fill, fill");
		
		JList list_2 = new JList();
		list_2.setBackground(new Color(211, 211, 211));
		scrollPane_5.setViewportView(list_2);
		list_2.setModel(new AbstractListModel() {
			String[] values = new String[] {"#1: 87%", "#2: 91%", "#3: 81%", "#4: 95%"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		JLabel lblNewLabel = new JLabel("LUN usage");
		panel_3.add(lblNewLabel, "2, 4, left, default");
		
		JScrollPane scrollPane_6 = new JScrollPane();
		panel_3.add(scrollPane_6, "4, 4, fill, fill");
		
		JList list_3 = new JList();
		list_3.setBackground(new Color(211, 211, 211));
		scrollPane_6.setViewportView(list_3);
		list_3.setModel(new AbstractListModel() {
			String[] values = new String[] {"#1: L1 85%", "#1: L2 82%", "#1: L3 91%", "", "", "", "", "a"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		JLabel lblRamUsage = new JLabel("RAM usage");
		panel_3.add(lblRamUsage, "2, 6, left, default");
		
		txtB = new JTextField();
		txtB.setBackground(new Color(211, 211, 211));
		txtB.setText("19560 B");
		txtB.setHorizontalAlignment(SwingConstants.CENTER);
		txtB.setFont(new Font("Lucida Grande", Font.BOLD, 10));
		txtB.setColumns(5);
		panel_3.add(txtB, "4, 6, fill, default");
		
		JScrollPane scrollPane_7 = new JScrollPane();
		scrollPane_7.setBounds(232, 484, 320, 175);
		frmEagleTree.getContentPane().add(scrollPane_7);
		
		JPanel panel_5 = new JPanel();
		scrollPane_7.setViewportView(panel_5);
		panel_5.setBackground(new Color(250, 235, 215));
		panel_5.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("2dlu"),
				FormFactory.DEFAULT_COLSPEC,
				ColumnSpec.decode("1dlu"),
				ColumnSpec.decode("31dlu:grow"),
				ColumnSpec.decode("1dlu"),
				ColumnSpec.decode("30dlu:grow"),
				ColumnSpec.decode("1dlu"),
				ColumnSpec.decode("28dlu:grow"),
				ColumnSpec.decode("max(1dlu;default)"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblMean = new JLabel("Mean");
		panel_5.add(lblMean, "4, 2, center, default");
		
		JLabel lblMax = new JLabel("Max");
		panel_5.add(lblMax, "6, 2, center, default");
		
		JLabel lblStd = new JLabel("Std");
		panel_5.add(lblStd, "8, 2, center, default");
		
		JLabel lblReadLatency = new JLabel("Read latency");
		panel_5.add(lblReadLatency, "2, 4, left, default");
		
		txts = new JTextField();
		txts.setBackground(new Color(211, 211, 211));
		txts.setText("130 \u03BCs");
		txts.setHorizontalAlignment(SwingConstants.CENTER);
		txts.setFont(new Font("Lucida Grande", Font.BOLD, 10));
		txts.setColumns(5);
		panel_5.add(txts, "4, 4, fill, default");
		
		txts_1 = new JTextField();
		txts_1.setBackground(new Color(211, 211, 211));
		txts_1.setText("380 \u03BCs");
		txts_1.setHorizontalAlignment(SwingConstants.CENTER);
		txts_1.setFont(new Font("Lucida Grande", Font.BOLD, 10));
		txts_1.setColumns(5);
		panel_5.add(txts_1, "6, 4, fill, default");
		
		txts_2 = new JTextField();
		txts_2.setBackground(new Color(211, 211, 211));
		txts_2.setText("163 \u03BCs");
		txts_2.setHorizontalAlignment(SwingConstants.CENTER);
		txts_2.setFont(new Font("Lucida Grande", Font.BOLD, 10));
		txts_2.setColumns(5);
		panel_5.add(txts_2, "8, 4, fill, default");
		
		JLabel lblWriteLatency = new JLabel("Write latency");
		panel_5.add(lblWriteLatency, "2, 6, left, default");
		
		txts_3 = new JTextField();
		txts_3.setBackground(new Color(211, 211, 211));
		txts_3.setText("400 \u03BCs");
		txts_3.setHorizontalAlignment(SwingConstants.CENTER);
		txts_3.setFont(new Font("Lucida Grande", Font.BOLD, 10));
		txts_3.setColumns(5);
		panel_5.add(txts_3, "4, 6, fill, default");
		
		txts_4 = new JTextField();
		txts_4.setBackground(new Color(211, 211, 211));
		txts_4.setText("3927 \u03BCs");
		txts_4.setHorizontalAlignment(SwingConstants.CENTER);
		txts_4.setFont(new Font("Lucida Grande", Font.BOLD, 10));
		txts_4.setColumns(5);
		panel_5.add(txts_4, "6, 6, fill, default");
		
		txts_5 = new JTextField();
		txts_5.setBackground(new Color(211, 211, 211));
		txts_5.setText("1240 \u03BCs");
		txts_5.setHorizontalAlignment(SwingConstants.CENTER);
		txts_5.setFont(new Font("Lucida Grande", Font.BOLD, 10));
		txts_5.setColumns(5);
		panel_5.add(txts_5, "8, 6, fill, default");
		
		JLabel lblThroughput = new JLabel("Throughput MB/s");
		panel_5.add(lblThroughput, "2, 8, left, default");
		
		txtReadMbs = new JTextField();
		txtReadMbs.setText("All:120- Reads:130- Writes:110");
		txtReadMbs.setHorizontalAlignment(SwingConstants.CENTER);
		txtReadMbs.setFont(new Font("Lucida Grande", Font.BOLD, 10));
		txtReadMbs.setColumns(5);
		txtReadMbs.setBackground(new Color(211, 211, 211));
		panel_5.add(txtReadMbs, "4, 8, 5, 1, fill, default");
		
		JLabel lblGcIos = new JLabel("# GC IOs");
		panel_5.add(lblGcIos, "2, 10, left, center");
		
		txtRead = new JTextField();
		txtRead.setText("Read:410 - Write:409 - Erase:23");
		txtRead.setHorizontalAlignment(SwingConstants.CENTER);
		txtRead.setFont(new Font("Lucida Grande", Font.BOLD, 10));
		txtRead.setColumns(5);
		txtRead.setBackground(new Color(211, 211, 211));
		panel_5.add(txtRead, "4, 10, 5, 1, fill, default");
		
		JLabel lblWlIos = new JLabel("# WL IOs");
		panel_5.add(lblWlIos, "2, 12, left, default");
		
		txtRead_1 = new JTextField();
		txtRead_1.setText("Read:54 - Write:54 - Erase:1");
		txtRead_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtRead_1.setFont(new Font("Lucida Grande", Font.BOLD, 10));
		txtRead_1.setColumns(5);
		txtRead_1.setBackground(new Color(211, 211, 211));
		panel_5.add(txtRead_1, "4, 12, 5, 1, fill, default");
		
		JLabel label_2 = new JLabel("GC IOs");
		panel_5.add(label_2, "2, 24");
		
		JButton btnRun = new JButton("RUN");
		btnRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				writeFile();
			}
		});
		btnRun.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnRun.setForeground(new Color(220, 20, 60));
		btnRun.setBackground(new Color(165, 42, 42));
		btnRun.setBounds(870, 235, 74, 29);
		frmEagleTree.getContentPane().add(btnRun);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(Color.GRAY));
		panel_6.setBackground(new Color(250, 235, 215));
		panel_6.setBounds(774, 484, 170, 144);
		frmEagleTree.getContentPane().add(panel_6);
		panel_6.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("max(3dlu;default)"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				RowSpec.decode("max(5dlu;default)"),}));
		
		JLabel lblInputQueues = new JLabel("Recorded graphics");
		lblInputQueues.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		panel_6.add(lblInputQueues, "2, 2");
		
		JScrollPane scrollPane_8 = new JScrollPane();
		scrollPane_8.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel_6.add(scrollPane_8, "2, 4, fill, fill");
		
		JTextArea txtrMixSeqVarying = new JTextArea();
		txtrMixSeqVarying.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					graphW window = new graphW();
					window.frmEagle.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}}
		});
		txtrMixSeqVarying.setBackground(new Color(211, 211, 211));
		scrollPane_8.setViewportView(txtrMixSeqVarying);
		txtrMixSeqVarying.setText("Mix Seq, vary R Dead.\nMix Seq, vary W Dead.\n");
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(Color.GRAY));
		panel_7.setBackground(new Color(250, 235, 215));
		panel_7.setBounds(564, 484, 204, 175);
		frmEagleTree.getContentPane().add(panel_7);
		panel_7.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		JLabel lblReadIo = new JLabel("# Read IOs");
		panel_7.add(lblReadIo, "2, 2, right, default");
		
		JList list_4 = new JList();
		list_4.setModel(new AbstractListModel() {
			String[] values = new String[] {"Thread 1: 30000", "Thread 2: 30000", "Thread 3: 30000", "Thread 4: 30000"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list_4.setBackground(new Color(211, 211, 211));
		panel_7.add(list_4, "4, 2, fill, fill");
		
		JLabel lblWriteIos = new JLabel("# Write IOs");
		panel_7.add(lblWriteIos, "2, 4, right, default");
		
		JList list_5 = new JList();
		list_5.setModel(new AbstractListModel() {
			String[] values = new String[] {"Thread 1: 15000", "Thread 2: 15000", "Thread 3: 15000", "Thread 4: 15000"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list_5.setBackground(new Color(211, 211, 211));
		panel_7.add(list_5, "4, 4, fill, fill");
		
		JButton btnDetailledTraces = new JButton("Detailed execution traces");
		btnDetailledTraces.setForeground(Color.BLUE);
		btnDetailledTraces.setFont(new Font("Lucida Grande", Font.BOLD, 12));
		btnDetailledTraces.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnDetailledTraces.setBounds(0, 452, 220, 29);
		frmEagleTree.getContentPane().add(btnDetailledTraces);
		
		JButton btnLatencyDistribution = new JButton("Latency distribution");
		btnLatencyDistribution.setForeground(Color.BLUE);
		btnLatencyDistribution.setFont(new Font("Lucida Grande", Font.BOLD, 12));
		btnLatencyDistribution.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLatencyDistribution.setBounds(232, 452, 155, 29);
		frmEagleTree.getContentPane().add(btnLatencyDistribution);
		
		JButton btnGcWl = new JButton("Throughput vs time");
		btnGcWl.setForeground(Color.BLUE);
		btnGcWl.setFont(new Font("Lucida Grande", Font.BOLD, 12));
		btnGcWl.setBounds(397, 452, 155, 29);
		frmEagleTree.getContentPane().add(btnGcWl);
		
		JButton btnLatencyDistributionWrt = new JButton("Latency dist. wrt priorities");
		btnLatencyDistributionWrt.setFont(new Font("Lucida Grande", Font.BOLD, 12));
		btnLatencyDistributionWrt.setEnabled(false);
		btnLatencyDistributionWrt.setBounds(564, 452, 204, 29);
		frmEagleTree.getContentPane().add(btnLatencyDistributionWrt);
		
		JButton btnAddNewGraphics = new JButton("Add new graphics");
		btnAddNewGraphics.setEnabled(false);
		btnAddNewGraphics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAddNewGraphics.setBounds(780, 630, 148, 29);
		frmEagleTree.getContentPane().add(btnAddNewGraphics);
		
		JButton btnGame = new JButton("GAME");
		btnGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Game window = new Game();
					window.frmEagletreeThe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnGame.setForeground(new Color(220, 20, 60));
		btnGame.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnGame.setBackground(new Color(165, 42, 42));
		btnGame.setBounds(863, 452, 81, 29);
		frmEagleTree.getContentPane().add(btnGame);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setOpaque(true);
		btnNewButton.setRequestFocusEnabled(false);
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 5));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ImageWindow window = new ImageWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon("src/demo.jpg"));
		btnNewButton.setBounds(6, 265, 938, 187);
		frmEagleTree.getContentPane().add(btnNewButton);
		
		JLabel lblWorkload = new JLabel("Workload");
		lblWorkload.setHorizontalAlignment(SwingConstants.CENTER);
		lblWorkload.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblWorkload.setBounds(780, 166, 164, 19);
		frmEagleTree.getContentPane().add(lblWorkload);
		
		JScrollPane scrollPane_9 = new JScrollPane();
		scrollPane_9.setBounds(780, 192, 164, 38);
		frmEagleTree.getContentPane().add(scrollPane_9);
		
		JList list_6 = new JList();
		scrollPane_9.setViewportView(list_6);
		list_6.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list_6.setModel(new AbstractListModel() {
			String[] values = new String[] {"Workload 1", "Workload 2", "Workload 3", "Workload 4"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list_6.setSelectedIndex(0);
		
		JButton btnAddNewWorkload = new JButton("Save settings");
		btnAddNewWorkload.setBounds(790, 135, 148, 29);
		frmEagleTree.getContentPane().add(btnAddNewWorkload);
	}
	
}
