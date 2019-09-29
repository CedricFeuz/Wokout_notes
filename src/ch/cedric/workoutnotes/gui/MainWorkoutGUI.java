package ch.cedric.workoutnotes.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import ch.cedric.workoutnotes.data.ExercisesDataClass;

/**
 * Das HauptGUI vom Workout
 * 
 * @author Cédric Feuz
 * @since 2019-07-24
 * @version 1.0
 *
 */
public class MainWorkoutGUI extends JFrame {

	private JFrame f;

	private ImageIcon newWorkoutIcon = new ImageIcon("src/assets/plus.png");
	private ImageIcon arrowRightIcon = new ImageIcon("src/assets/blue-arrow.png");
	private ImageIcon arrowLeftIcon = new ImageIcon("src/assets/blue-arrow-left.png");
	private ImageIcon menuIcon = new ImageIcon("src/assets/menu-icon.png");

	private JPanel mainPanel;
	private JPanel northButtonPanel;
	private JPanel northButtonNorthPanel;
	private JPanel northButtonSouthPanel;
	private JPanel showWorkoutPanel;
	private JScrollPane tablePane;
	
	private int zaehler = 0;
	private JTable table = new JTable(0,3);
	private DefaultTableModel model = (DefaultTableModel) table.getModel();
	private JLabel emptyLogLabel = new JLabel("Workout Log Empty");
	private JLabel newWorkoutLabel = new JLabel("Start New Workout", newWorkoutIcon, JLabel.CENTER);
	private JLabel dateLabel = new JLabel("TODAY");
	private JLabel arrowRightIconLabel = new JLabel(arrowRightIcon);
	private JLabel arrowLeftIconLabel = new JLabel(arrowLeftIcon);
	private JLabel workoutLabel = new JLabel("WorkoutNotes");
	private JLabel menuIconLabel = new JLabel(menuIcon);
	private Vector<ExercisesDataClass> dataVector = new Vector<ExercisesDataClass>();

	/**
	 * default Konstruktor
	 */
	public MainWorkoutGUI() {
		f = new JFrame("Workout");
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
		mainPanel = new JPanel();
		northButtonPanel = new JPanel();
		northButtonNorthPanel = new JPanel();
		northButtonSouthPanel = new JPanel();
		showWorkoutPanel = new JPanel();
		tablePane = new JScrollPane(table);
		
		mainPanel.setLayout(new BorderLayout());
		northButtonPanel.setLayout(new BorderLayout());
		northButtonNorthPanel.setLayout(new BorderLayout());
		northButtonSouthPanel.setLayout(new BorderLayout());
		showWorkoutPanel.setLayout(new BorderLayout());
		
		f.add(mainPanel, BorderLayout.CENTER);

		table.getColumnModel().getColumn(0).setHeaderValue("Übung");
		table.getColumnModel().getColumn(1).setHeaderValue("Weight/Distance");
		table.getColumnModel().getColumn(2).setHeaderValue("Reps/Time");
		newWorkoutIcon.setImage(newWorkoutIcon.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT));
		arrowRightIcon.setImage(arrowRightIcon.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
		arrowLeftIcon.setImage(arrowLeftIcon.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
		menuIcon.setImage(menuIcon.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
		newWorkoutLabel.setHorizontalTextPosition(JLabel.CENTER);
		emptyLogLabel.setHorizontalAlignment(SwingConstants.CENTER);
		newWorkoutLabel.setVerticalTextPosition(JLabel.BOTTOM);
		dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		northButtonSouthPanel.setBackground(Color.BLACK);
		northButtonSouthPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, Color.CYAN));
		northButtonNorthPanel.setBackground(Color.DARK_GRAY);
		dateLabel.setBackground(Color.BLACK);
		dateLabel.setForeground(Color.WHITE);
		dateLabel.setFont(new Font("System", Font.BOLD, 16));
		workoutLabel.setBackground(Color.DARK_GRAY);
		workoutLabel.setForeground(Color.WHITE);
		workoutLabel.setFont(new Font("8514oem", Font.BOLD, 22));
		emptyLogLabel.setBackground(Color.white);
		emptyLogLabel.setForeground(Color.GRAY);
		emptyLogLabel.setFont(new Font("Arial", Font.PLAIN, 22));

		mainPanel.add(emptyLogLabel, BorderLayout.CENTER);
		mainPanel.add(newWorkoutLabel, BorderLayout.SOUTH);
		mainPanel.add(northButtonPanel, BorderLayout.NORTH);
		northButtonPanel.add(northButtonNorthPanel, BorderLayout.NORTH);
		northButtonPanel.add(northButtonSouthPanel, BorderLayout.SOUTH);
		northButtonNorthPanel.add(workoutLabel, BorderLayout.CENTER);
		northButtonNorthPanel.add(menuIconLabel, BorderLayout.EAST);
		northButtonSouthPanel.add(dateLabel, BorderLayout.CENTER);
		northButtonSouthPanel.add(arrowRightIconLabel, BorderLayout.EAST);
		northButtonSouthPanel.add(arrowLeftIconLabel, BorderLayout.WEST);
	}

	/**
	 * Macht aus einem Bild ein ImageIcon für das Projekt
	 *
	 * @param path        der Pfad an dem das Icon gespeichert ist
	 * @param description die Beschreibung des Icons
	 * @return ein ImageIcon, oder null falls der Pfad ungültig ist
	 */
	protected ImageIcon createImageIcon(String path, String description) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL, description);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

	/**
	 * wenn man rechten Pfeil anklickt erhöht sich das Datum um einen Tag
	 * 
	 * @param listenForArrowRightIconLabelListener der MouseListener
	 */
	public void addArrowRightIconLabelListener(MouseListener listenForArrowRightIconLabel) {
		arrowRightIconLabel.addMouseListener(listenForArrowRightIconLabel);
	}
	
	/**
	 * wenn man rechten Pfeil anklickt erhöht sich das Datum um einen Tag
	 * 
	 * @param listenForArrowLeftLiconLabelListener der MouseListener
	 */
	public void addArrowLeftIconLabelListener(MouseListener listenForArrowLeftIconLabel) {
		arrowLeftIconLabel.addMouseListener(listenForArrowLeftIconLabel);
	}
	
	/**
	 * wenn man das newWorkoutLabel drückt kommt man ins mainWorkoutGUI
	 * 
	 * @param listenForWorkoutButton der ActionListener
	 */
	public void addNewWorkoutLabelListener(MouseListener listenForNewWorkoutLabel) {
		newWorkoutLabel.addMouseListener(listenForNewWorkoutLabel);
	}

	/**
	 * Setzt den richtigen JLabelwert
	 */
	private void editZaehler() {
		if(zaehler == 0) {
			emptyLogLabel.hide();
			tablePane.show();
			dateLabel.setText("TODAY");
		}else if(zaehler == -1) {
			tablePane.setVisible(false);
			emptyLogLabel.show();
			dateLabel.setText("YESTERDAY");
		}else if(zaehler == 1) {
			tablePane.setVisible(false);
			emptyLogLabel.show();
			dateLabel.setText("TOMORROW");
		}else {
			dateLabel.setText(getDay());
		}
	}
	
	/**
	 * gibt das heutige Datum zurück
	 * 
	 * @return das heutige Datum
	 */
	private String getDay() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.DAY_OF_MONTH, zaehler);  
		String newDate = sdf.format(cal.getTime());  
		return newDate;
	}

	/**
	 * gibt ein JFrame zurück
	 * 
	 * @return f ein JFrame
	 */
	public JFrame getFrame() {
		return f;
	}

	/**
	 * gibt ein JPanel zurück
	 * 
	 * @return ein JPanel
	 */
	public JPanel getShowWorkoutPanel() {
		return showWorkoutPanel;
	}

	/**
	 * gibt ein JLabel zurück
	 * 
	 * @return ein JLabel
	 */
	public JLabel getEmptyLogLabel() {
		return emptyLogLabel;
	}

	/**
	 * gibt ein JScrollPane zurück
	 * 
	 * @return ein JScrollPane
	 */
	public JScrollPane getTablePane() {
		return tablePane;
	}
	/**
	 * gibt ein JPanel zurück
	 * 
	 * @return ein JPanel
	 */
	public JPanel getMainPanel() {
		return mainPanel;
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
	 * Gibt den Zaehler zurück für die Tage
	 * 
	 * @param eine Zahl
	 */
	public int getZaehler() {
		return zaehler;
	}

	/**
	 * Setzt den Zaehler
	 * 
	 * @param eine Zahl
	 */
	public void setZaehler(int zaehler) {
		this.zaehler = zaehler;
		editZaehler();
	}
}