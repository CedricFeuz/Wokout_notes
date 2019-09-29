package ch.cedric.workoutnotes.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
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
 * Das GUI vom Hinzufügen von Reps-Übungen
 * 
 * @author Cédric Feuz
 * @since 2019-07-30
 * @version 1.0
 *
 */
public class RepsGUI {
	private JFrame f;
	private ImageIcon minusIcon = new ImageIcon("src/assets/minus-5-512.png");
	private ImageIcon plusIcon = new ImageIcon("src/assets/plus-4-512.png");
	
	private JPanel northPanel;
	private JPanel mainPanel;
	private JPanel buttonPanel;
	private JScrollPane southPanel;
	private JPanel repsPanel;
	
	private JTable table = new JTable(0,2);
	private DefaultTableModel model = (DefaultTableModel) table.getModel();
	private JLabel repsLabel = new JLabel("REPS:");
	private JLabel übungLabel = new JLabel("Übung");
	private JLabel minusIconLabel = new JLabel(minusIcon);
	private JLabel plusIconLabel = new JLabel(plusIcon);
	private JTextField repsText = new JTextField();
	private JSeparator firstSeperator = new JSeparator();
	private JButton saveButton = new JButton("SAVE");
	private JButton clearButton = new JButton("CLEAR");
	private JButton abortButton = new JButton("abort");
	
	/**
	 * default Konstruktor
	 */
	public RepsGUI() {
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
		repsPanel = new JPanel();
		
		northPanel.setLayout(new BorderLayout());
		mainPanel.setLayout(new GridLayout(4, 1));
		buttonPanel.setLayout(new FlowLayout());
		repsPanel.setLayout(new GridLayout(1, 3));
		
		f.add(northPanel, BorderLayout.NORTH);
		f.add(mainPanel, BorderLayout.CENTER);
		f.add(southPanel, BorderLayout.SOUTH);
		
		table.getColumnModel().getColumn(0).setHeaderValue("Set");
		table.getColumnModel().getColumn(1).setHeaderValue("Reps");
		minusIcon.setImage(minusIcon.getImage().getScaledInstance(55, 55, Image.SCALE_DEFAULT));
		plusIcon.setImage(plusIcon.getImage().getScaledInstance(55, 55, Image.SCALE_DEFAULT));
		repsText.setText("0");
		repsText.setEditable(false);
		repsText.setHorizontalAlignment(JTextField.CENTER);
		repsText.setForeground(Color.gray);
		repsText.setFont(new Font("8514oem", Font.BOLD, 33));
		
		northPanel.add(übungLabel, BorderLayout.CENTER);
		mainPanel.add(repsLabel);
		mainPanel.add(firstSeperator);
		mainPanel.add(repsPanel);
		mainPanel.add(buttonPanel);
		buttonPanel.add(saveButton);
		buttonPanel.add(clearButton);
		buttonPanel.add(abortButton);
		repsPanel.add(minusIconLabel);
		repsPanel.add(repsText);
		repsPanel.add(plusIconLabel);
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
	 * wenn man den Minus Button anklickt senkt sich das Gewicht um 2.5
	 * 
	 * @param listenForMinusIconRepsLabel der MouseListener
	 */
	public void addMinusIconRepsLabelListener(MouseListener listenForMinusIconRepsLabel) {
		minusIconLabel.addMouseListener(listenForMinusIconRepsLabel);
	}
	
	/**
	 * wenn man den Plus Button anklickt erhöht sich das Gewicht um 2.5
	 * 
	 * @param listenForPlusIconLabel der MouseListener
	 */
	public void addPlusIconRepsLabelListener(MouseListener listenForPlusRepsIconLabel) {
		plusIconLabel.addMouseListener(listenForPlusRepsIconLabel);
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
	 * Gibt die Wiederholungsanzahl zurück
	 * 
	 * @return wiederholungszahl
	 */
	public String getRepsText() {
		return repsText.getText();
	}

	/**
	 * Setzt den Wert der Wiederholungen
	 * 
	 * @param text Der Wert
	 */
	public void setRepsText(String text) {
		repsText.setText(text);
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
