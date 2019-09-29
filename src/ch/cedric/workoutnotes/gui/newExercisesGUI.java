package ch.cedric.workoutnotes.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.TableModel;

/**
 * Die Klasse fügt eine neue Übung hinzu
 * 
 * @author Cédric Feuz
 * @date 27-7-2019
 * @version 1.0
 *
 */
public class newExercisesGUI extends JDialog {

	private JPanel northPanel;
	private JPanel mainPanel;
	private JPanel buttonSouthPanel;

	private JDialog dialog;
	private JTextField exerciseTextField = new JTextField();
	private JLabel exercisesLabel = new JLabel("Exercise:");
	private JLabel groupLabel = new JLabel("Group:");
	private JLabel typeLabel = new JLabel("Type:");
	private JLabel newExercisesLabel = new JLabel("New Exercise");
	private JSeparator seperator1 = new JSeparator();
	private JSeparator seperator2 = new JSeparator();
	private JSeparator seperator3 = new JSeparator();
	private JButton okButton = new JButton("OK");
	private JButton abortButton = new JButton("abort");
	private String groups[] = { "Abs", "Back", "Biceps", "Cardio", "Chest", "Legs", "Shoulders", "Triceps" };
	private String types[] = {"Weight and Reps", "Distance and Time", "Reps", "Time"};
	private JComboBox groupComboBox = new JComboBox(groups);
	private JComboBox typeComboBox = new JComboBox(types);

	/**
	 * default Konstruktor
	 */
	public newExercisesGUI(TableModel model) {
		dialog = this;
		setTitle("Übung erfassen");
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		init(model);
		setSize(size.width * 100 / 100, size.height * 100 / 100);
		setUndecorated(true);
		pack();
		setVisible(true);
		setAlwaysOnTop(true);
	}

	/**
	 * das ganze JFrame
	 * 
	 * @param f das JFrame
	 */
	private void init(TableModel model) {
		northPanel = new JPanel();
		mainPanel = new JPanel();
		buttonSouthPanel = new JPanel();

		northPanel.setLayout(new BorderLayout());
		mainPanel.setLayout(new GridLayout(9, 1));
		buttonSouthPanel.setLayout(new GridLayout(1, 2));

		getContentPane().add(northPanel, BorderLayout.NORTH);
		getContentPane().add(mainPanel, BorderLayout.CENTER);
		getContentPane().add(buttonSouthPanel, BorderLayout.SOUTH);

		northPanel.setBackground(Color.DARK_GRAY);
		newExercisesLabel.setBackground(Color.DARK_GRAY);
		newExercisesLabel.setForeground(Color.WHITE);
		newExercisesLabel.setFont(new Font("8514oem", Font.BOLD, 22));

		northPanel.add(newExercisesLabel, BorderLayout.CENTER);
		mainPanel.add(exercisesLabel);
		mainPanel.add(seperator1);
		mainPanel.add(exerciseTextField);
		mainPanel.add(groupLabel);
		mainPanel.add(seperator2);
		mainPanel.add(groupComboBox);
		mainPanel.add(typeLabel);
		mainPanel.add(seperator3);
		mainPanel.add(typeComboBox);
		buttonSouthPanel.add(abortButton);
		buttonSouthPanel.add(okButton);
	}

	/**
	 * Wartet bis abort angelickt wird
	 * 
	 * @param listenForAbortButton der ActionListener
	 */
	public void addAbortButton(ActionListener listenforAbortButton) {
		abortButton.addActionListener(listenforAbortButton);
	}

	/**
	 * Wartet bis OK angelickt wird
	 * 
	 * @param listenForOkButton der ActionListener
	 */
	public void addOkButton(ActionListener listenforOkButton) {
		okButton.addActionListener(listenforOkButton);
	}

	/**
	 * Gibt ein TextFeld zurück
	 * 
	 * @return ein Textfeld
	 */
	public JTextField getExerciseTextField() {
		return exerciseTextField;
	}

	/**
	 * Gibt eine Combobox zurück
	 * 
	 * @return eine Combobox
	 */
	public JComboBox getGroupComboBox() {
		return groupComboBox;
	}

	/**
	 * Gibt eine Combobox zurück
	 * 
	 * @return eine Combobox
	 */
	public int getTypeComboBox() {
		if(typeComboBox.getSelectedItem() == "Weight and Reps") {
			return 0;
		}else if(typeComboBox.getSelectedItem() == "Distance and Time") {
			return 1;
		}else if(typeComboBox.getSelectedItem() == "Reps") {
			return 2;
		}else if(typeComboBox.getSelectedItem() == "Time") {
			return 3;
		}
		return 0;
	}
}
