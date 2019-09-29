package ch.cedric.workoutnotes.gui;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.*;

import ch.cedric.workoutnotes.data.ExercisesDataClass;
import ch.cedric.workoutnotes.model.ExercisesDataModel;

import java.awt.*;
import java.awt.event.*;

/**
 * Die Klasse TableView bringt die Daten des Modells DataModel zur Anzeige
 * 
 * @author Cédric Feuz
 * @since 2019-07-24
 * @version 1.0
 */
public class ExercisesGUI extends JFrame {

	private JFrame f;
	private TableModel model;
	private ImageIcon schwarzerKreisIcon = new ImageIcon("src/assets/schwarzerKreis.png");
	private ImageIcon blauerKreisIcon = new ImageIcon("src/assets/blauerKreis.png");
	private ImageIcon orangerKreisIcon = new ImageIcon("src/assets/orangerKreis.png");
	private ImageIcon hellgrünerKreisIcon = new ImageIcon("src/assets/hellgrünerKreis.png");
	private ImageIcon roterKreisIcon = new ImageIcon("src/assets/roterKreis.png");
	private ImageIcon lilaKreisIcon = new ImageIcon("src/assets/lilaKreis.png");
	private ImageIcon braunerKreisIcon = new ImageIcon("src/assets/braunerKreis.png");
	private ImageIcon dunkelgrünerKreisIcon = new ImageIcon("src/assets/dunkelgrünerKreis.png");
	private ImageIcon menuIcon = new ImageIcon("src/assets/menu-icon.png");
	private ImageIcon newExercisesIcon = new ImageIcon("src/assets/plus.png");

	private JPanel northPanel;
	private JPanel northButtonPanel;
	private JPanel categoriesPanel;
	private JPanel southPanel;
	private JScrollPane absTableScrollerPane;
	private JPanel absPanel;
	private JPanel backPanel;
	private JPanel bicepsPanel;
	private JPanel cardioPanel;
	private JPanel chestPanel;
	private JPanel legsPanel;
	private JPanel shouldersPanel;
	private JPanel tricepsPanel;

	private JTable absTable;
	private JLabel allExercisesLabel = new JLabel("All Exercises");
	private JLabel menuIconLabel = new JLabel(menuIcon);
	private JLabel newExercisesLabel = new JLabel(newExercisesIcon);
	private JLabel schwarzerKreisLabel = new JLabel(schwarzerKreisIcon);
	private JLabel blauerKreisLabel = new JLabel(blauerKreisIcon);
	private JLabel orangerKreisLabel = new JLabel(orangerKreisIcon);
	private JLabel hellgrünerKreisLabel = new JLabel(hellgrünerKreisIcon);
	private JLabel roterKreisLabel = new JLabel(roterKreisIcon);
	private JLabel lilaKreisLabel = new JLabel(lilaKreisIcon);
	private JLabel braunerKreisLabel = new JLabel(braunerKreisIcon);
	private JLabel dunkelgrünerKreisLabel = new JLabel(dunkelgrünerKreisIcon);
	private JLabel absLabel = new JLabel("  Abs");
	private JLabel backLabel = new JLabel("  Back");
	private JLabel bicepsLabel = new JLabel("  Bizeps");
	private JLabel cardioLabel = new JLabel("  Cardio");
	private JLabel chestLabel = new JLabel("  Chest");
	private JLabel legsLabel = new JLabel("  Legs");
	private JLabel shouldersLabel = new JLabel("  Shoulders");
	private JLabel tricepsLabel = new JLabel("  Trizeps");
	private JSeparator seperate1 = new JSeparator();
	private JSeparator seperate2 = new JSeparator();
	private JSeparator seperate3 = new JSeparator();
	private JSeparator seperate4 = new JSeparator();
	private JSeparator seperate5 = new JSeparator();
	private JSeparator seperate6 = new JSeparator();
	private JSeparator seperate7 = new JSeparator();
	private JSeparator seperate8 = new JSeparator();
	private JSeparator seperate9 = new JSeparator();
	private JButton backButton = new JButton("Back");

	/**
	 * Konstruktor
	 * 
	 * @param m Referenz zur TableModel-Klasse
	 */
	public ExercisesGUI(TableModel m) {
		f = new JFrame("Übungen");
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		model = m;
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
		categoriesPanel = new JPanel();
		northPanel = new JPanel();
		northButtonPanel = new JPanel();
		southPanel = new JPanel();
		absTable = new JTable(model);
		absTableScrollerPane = new JScrollPane(absTable);
		absPanel = new JPanel();
		backPanel = new JPanel();
		bicepsPanel = new JPanel();
		cardioPanel = new JPanel();
		chestPanel = new JPanel();
		legsPanel = new JPanel();
		shouldersPanel = new JPanel();
		tricepsPanel = new JPanel();

		categoriesPanel.setLayout(new GridLayout(17, 1));
		northPanel.setLayout(new BorderLayout());
		northButtonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		southPanel.setLayout(new BorderLayout());
		absPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		backPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		bicepsPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		cardioPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		chestPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		legsPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		shouldersPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		tricepsPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

		f.add(northPanel, BorderLayout.NORTH);
		f.getContentPane().add(categoriesPanel, BorderLayout.CENTER);
		f.add(southPanel, BorderLayout.SOUTH);

		northPanel.setBackground(Color.DARK_GRAY);
		northButtonPanel.setBackground(Color.DARK_GRAY);
		schwarzerKreisIcon.setImage(schwarzerKreisIcon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		blauerKreisIcon.setImage(blauerKreisIcon.getImage().getScaledInstance(17, 17, Image.SCALE_DEFAULT));
		orangerKreisIcon.setImage(orangerKreisIcon.getImage().getScaledInstance(17, 17, Image.SCALE_DEFAULT));
		hellgrünerKreisIcon.setImage(hellgrünerKreisIcon.getImage().getScaledInstance(17, 17, Image.SCALE_DEFAULT));
		roterKreisIcon.setImage(roterKreisIcon.getImage().getScaledInstance(17, 17, Image.SCALE_DEFAULT));
		lilaKreisIcon.setImage(lilaKreisIcon.getImage().getScaledInstance(17, 17, Image.SCALE_DEFAULT));
		braunerKreisIcon.setImage(braunerKreisIcon.getImage().getScaledInstance(17, 17, Image.SCALE_DEFAULT));
		dunkelgrünerKreisIcon.setImage(dunkelgrünerKreisIcon.getImage().getScaledInstance(17, 17, Image.SCALE_DEFAULT));
		menuIcon.setImage(menuIcon.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
		newExercisesIcon.setImage(newExercisesIcon.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
		allExercisesLabel.setBackground(Color.DARK_GRAY);
		allExercisesLabel.setForeground(Color.WHITE);
		allExercisesLabel.setFont(new Font("8514oem", Font.BOLD, 22));
		seperate1.setFont(new Font("Dialog", Font.BOLD, 18));
		seperate1.setForeground(new Color(0xC0C0C0));
		seperate2.setFont(new Font("Dialog", Font.BOLD, 18));
		seperate2.setForeground(new Color(0xC0C0C0));
		seperate3.setFont(new Font("Dialog", Font.BOLD, 18));
		seperate3.setForeground(new Color(0xC0C0C0));
		seperate4.setFont(new Font("Dialog", Font.BOLD, 18));
		seperate4.setForeground(new Color(0xC0C0C0));
		seperate5.setFont(new Font("Dialog", Font.BOLD, 18));
		seperate5.setForeground(new Color(0xC0C0C0));
		seperate6.setFont(new Font("Dialog", Font.BOLD, 18));
		seperate6.setForeground(new Color(0xC0C0C0));
		seperate7.setFont(new Font("Dialog", Font.BOLD, 18));
		seperate7.setForeground(new Color(0xC0C0C0));
		seperate8.setFont(new Font("Dialog", Font.BOLD, 18));
		seperate8.setForeground(new Color(0xC0C0C0));
		seperate9.setFont(new Font("Dialog", Font.BOLD, 18));
		seperate9.setForeground(new Color(0xC0C0C0));
		absLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		backLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		bicepsLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		cardioLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		chestLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		legsLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		shouldersLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		tricepsLabel.setFont(new Font("Dialog", Font.BOLD, 20));

		northPanel.add(allExercisesLabel, BorderLayout.CENTER);
		northPanel.add(northButtonPanel, BorderLayout.EAST);
		northButtonPanel.add(newExercisesLabel);
		northButtonPanel.add(menuIconLabel);
		southPanel.add(backButton, BorderLayout.WEST);
		absPanel.add(schwarzerKreisLabel);
		absPanel.add(absLabel);
		backPanel.add(blauerKreisLabel);
		backPanel.add(backLabel);
		bicepsPanel.add(orangerKreisLabel);
		bicepsPanel.add(bicepsLabel);
		cardioPanel.add(hellgrünerKreisLabel);
		cardioPanel.add(cardioLabel);
		chestPanel.add(roterKreisLabel);
		chestPanel.add(chestLabel);
		legsPanel.add(lilaKreisLabel);
		legsPanel.add(legsLabel);
		shouldersPanel.add(braunerKreisLabel);
		shouldersPanel.add(shouldersLabel);
		tricepsPanel.add(dunkelgrünerKreisLabel);
		tricepsPanel.add(tricepsLabel);
		categoriesPanel.add(seperate1);
		categoriesPanel.add(absPanel);
		categoriesPanel.add(seperate2);
		categoriesPanel.add(backPanel);
		categoriesPanel.add(seperate3);
		categoriesPanel.add(bicepsPanel);
		categoriesPanel.add(seperate4);
		categoriesPanel.add(cardioPanel);
		categoriesPanel.add(seperate5);
		categoriesPanel.add(chestPanel);
		categoriesPanel.add(seperate6);
		categoriesPanel.add(legsPanel);
		categoriesPanel.add(seperate7);
		categoriesPanel.add(shouldersPanel);
		categoriesPanel.add(seperate8);
		categoriesPanel.add(tricepsPanel);
		categoriesPanel.add(seperate9);
	}

	/**
	 * wenn man den addExerciseButton drückt öffnet sich der InputDialog
	 * 
	 * @param listenForExerciseButton der ActionListener
	 */
	public void addExerciseButtonListener(MouseListener listenForExerciseButton) {
		newExercisesLabel.addMouseListener(listenForExerciseButton);
	}

	/**
	 * Wartet bis Abs angeklickt wird
	 * 
	 * @param listenForAbsLabel der MouseListener
	 */
	public void addAbsLabel(MouseListener listenForAbsLabel) {
		absPanel.addMouseListener(listenForAbsLabel);
	}

	/**
	 * Wartet bis Back angelickt wird
	 * 
	 * @param listenForBackLabel der MouseListener
	 */
	public void addBackLabel(MouseListener listenforBackLabel) {
		backPanel.addMouseListener(listenforBackLabel);
	}

	/**
	 * Wartet bis Biceps angelickt wird
	 * 
	 * @param listenForBicepsLabel der MouseListener
	 */
	public void addBicepsLabel(MouseListener listenforBicepsLabel) {
		bicepsPanel.addMouseListener(listenforBicepsLabel);
	}

	/**
	 * Wartet bis Cardio angelickt wird
	 * 
	 * @param listenForCardioLabel der MouseListener
	 */
	public void addCardioLabel(MouseListener listenforCardioLabel) {
		cardioPanel.addMouseListener(listenforCardioLabel);
	}

	/**
	 * Wartet bis Chest angelickt wird
	 * 
	 * @param listenForChestLabel der MouseListener
	 */
	public void addChestLabel(MouseListener listenforChestLabel) {
		chestPanel.addMouseListener(listenforChestLabel);
	}

	/**
	 * Wartet bis Legs angelickt wird
	 * 
	 * @param listenForLegsLabel der MouseListener
	 */
	public void addLegsLabel(MouseListener listenforLegsLabel) {
		legsPanel.addMouseListener(listenforLegsLabel);
	}

	/**
	 * Wartet bis Shoulders angelickt wird
	 * 
	 * @param listenForShouldersLabel der MouseListener
	 */
	public void addShouldersLabel(MouseListener listenforShouldersLabel) {
		shouldersPanel.addMouseListener(listenforShouldersLabel);
	}

	/**
	 * Wartet bis Tricpes angelickt wird
	 * 
	 * @param listenForTricepsLabel der MouseListener
	 */
	public void addTricepsLabel(MouseListener listenforTricepsLabel) {
		tricepsPanel.addMouseListener(listenforTricepsLabel);
	}
	/**
	 * Wartet bis die Tabelle angelickt wird
	 * 
	 * @param listenForTricepsLabel der MouseListener
	 */
	public void addTableListener(MouseListener listenforTable) {
		absTable.addMouseListener(listenforTable);
	}

	/**
	 * gibt ein JFrame zurück
	 * 
	 * @return f JFrame
	 */
	public JFrame getFrame() {
		return f;
	}

	/**
	 * gibt ein TableModel zurück
	 * 
	 * @return model ein TableModel
	 */
	public TableModel getModel() {
		return model;
	}

	/**
	 * gibt ein JPanel zurück
	 * 
	 * @return categories ein JPanel
	 */
	public JPanel getCategoriesPanel() {
		return categoriesPanel;
	}

	/**
	 * gibt ein JScrollPane zurück
	 * 
	 * @return absTableScrollerPane ein JScrollPane
	 */
	public JScrollPane getAbsTableScrollerPane() {
		return absTableScrollerPane;
	}

	/**
	 * gibt ein JTable zurück
	 * 
	 * @return absTable ein JTable
	 */
	public JTable getAbsTable() {
		return absTable;
	}
	
	/**
	 * Wartet bis back angeklickt wird
	 * 
	 * @param listenForBackButton der ActionListener
	 */
	public void addBackButton(ActionListener listenforbackButton) {
		backButton.addActionListener(listenforbackButton);
	}

	/**
	 * Gibt ein JLabel zurück
	 * 
	 * @param ein JLabel
	 */
	public JLabel getAllExercisesLabel() {
		return allExercisesLabel;
	}
}