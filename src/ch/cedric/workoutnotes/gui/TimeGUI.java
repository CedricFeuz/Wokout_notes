package ch.cedric.workoutnotes.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * Das GUI vom Hinzufügen von Time-Übungen
 * 
 * @author Cédric Feuz
 * @since 2019-07-30
 * @version 1.0
 *
 */
public class TimeGUI {
	
	private JFrame f;
	
	private JPanel northPanel;
	private JPanel mainPanel;
	private JPanel buttonPanel;
	private JScrollPane southPanel;
	private JPanel timePanel;
	
	private JTable table = new JTable(0,2);
	private DefaultTableModel model = (DefaultTableModel) table.getModel();
	private JLabel timeLabel = new JLabel("TIME:");
	private JLabel übungLabel = new JLabel("Übung");
	private JTextField hourText = new JTextField();
	private JTextField minutsText = new JTextField();
	private JTextField secondsText = new JTextField();
	private JSeparator firstSeperator = new JSeparator();
	private JButton saveButton = new JButton("SAVE");
	private JButton clearButton = new JButton("CLEAR");
	private JButton abortButton = new JButton("abort");
	
	/**
	 * default Konstruktor
	 */
	public TimeGUI() {
		f = new JFrame("");
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		init(f);
		f.setSize(size.width * 100 / 100, size.height * 100 / 100);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setUndecorated(true);
		f.setVisible(true);
	}

	/**
	 * das ganze JFrame
	 * 
	 * @param f das JFrame
	 */
	private void init(JFrame f) {
		northPanel = new JPanel();
		mainPanel = new JPanel();
		buttonPanel = new JPanel();
		southPanel = new JScrollPane(table);
		timePanel = new JPanel();
		
		northPanel.setLayout(new BorderLayout());
		mainPanel.setLayout(new GridLayout(4, 1));
		buttonPanel.setLayout(new FlowLayout());
		timePanel.setLayout(new GridLayout(1, 3));
		
		f.add(northPanel, BorderLayout.NORTH);
		f.add(mainPanel, BorderLayout.CENTER);
		f.add(southPanel, BorderLayout.SOUTH);
		
		table.getColumnModel().getColumn(0).setHeaderValue("set");
		table.getColumnModel().getColumn(1).setHeaderValue("Time");
		hourText.setHorizontalAlignment(JTextField.CENTER);
		hourText.setForeground(Color.gray);
		hourText.setFont(new Font("8514oem", Font.BOLD, 33));
		hourText.setText("hh");
		minutsText.setHorizontalAlignment(JTextField.CENTER);
		minutsText.setForeground(Color.gray);
		minutsText.setFont(new Font("8514oem", Font.BOLD, 33));
		minutsText.setText("mm");
		secondsText.setHorizontalAlignment(JTextField.CENTER);
		secondsText.setForeground(Color.gray);
		secondsText.setFont(new Font("8514oem", Font.BOLD, 33));
		secondsText.setText("ss");
		
		northPanel.add(übungLabel, BorderLayout.CENTER);
		mainPanel.add(timeLabel);
		mainPanel.add(firstSeperator);
		mainPanel.add(timePanel);
		mainPanel.add(buttonPanel);
		buttonPanel.add(saveButton);
		buttonPanel.add(clearButton);
		buttonPanel.add(abortButton);
		timePanel.add(hourText);
		timePanel.add(minutsText);
		timePanel.add(secondsText);
	}
	
	/**
	 * Wartet bis abort angeklickt wird
	 * 
	 * @param listenForAbortButton der ActionListener
	 */
	public void addAbortButton(ActionListener listenforAbortButton) {
		abortButton.addActionListener(listenforAbortButton);
	}
	
	/**
	 * Wartet bis save angelickt wird
	 * 
	 * @param listenForSaveButton der ActionListener
	 */
	public void addSaveButton(ActionListener listenforSaveButton) {
		saveButton.addActionListener(listenforSaveButton);
	}
	
	/**
	 * Wartet bis clear angeklickt wird
	 * 
	 * @param listenForClearButton der ActionListener
	 */
	public void addClearButton(ActionListener listenforClearButton) {
		clearButton.addActionListener(listenforClearButton);
	}
	
	/**
	 * Gibt ein JTable zurück
	 * 
	 * @param ein JTable
	 */
	public DefaultTableModel getModel() {
		return model;
	}

	/**
	 * Gibt die Stunden zurück
	 * 
	 * @return die Stunden
	 */
	public String getHourText() {
		return hourText.getText();
	}

	/**
	 * setzt die Stunden
	 * 
	 * @param die Distanz
	 */
	public void setHourText(String hourText) {
		this.hourText.setText(hourText);
	}

	/**
	 * Gibt die Minuten zurück
	 * 
	 * @return die Minuten
	 */
	public String getMinutsText() {
		return minutsText.getText();
	}

	/**
	 * Setzt die Minuten
	 * 
	 * @param die Minuten
	 */
	public void setMinutsText(String minutsText) {
		this.minutsText.setText(minutsText);
	}

	/**
	 * Gibt die Sekunden zurück
	 * 
	 * @return die Sekunden
	 */
	public String getSecondsText() {
		return secondsText.getText();
	}

	/**
	 * Setzt die Sekunden
	 * 
	 * @param die Distanz
	 */
	public void setSecondsText(String secondsText) {
		this.secondsText.setText(secondsText);
	}
	
	/**
	 * Gibt ein JFrame zurück
	 * 
	 * @param ein JFrame
	 */
	public JFrame getFrame() {
		return f;
	}
	
	/**
	 * Gibt die JLabel zurück
	 * 
	 * @return ein JLabel
	 */
	public JLabel getÜbungLabel() {
		return übungLabel;
	}
}
