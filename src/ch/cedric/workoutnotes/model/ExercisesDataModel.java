package ch.cedric.workoutnotes.model;
import java.io.Serializable;
import java.util.*;

import javax.swing.table.*;

import ch.cedric.workoutnotes.AppController;
import ch.cedric.workoutnotes.data.ExercisesDataClass;

/**
 * Die Klasse DataModel stellt eine Menge von Objekten einer Datenklasse (hier
 * DataClass) bereit
 * 
 * @author Cédric Feuz
 * @since 2019-07-24
 * @version 1.0
 */
public class ExercisesDataModel extends AbstractTableModel implements Serializable {

	private Vector<ExercisesDataClass> dataVector;
	private String[] title = { "Excercises", "Group", "Type" };
	private AppController controller;
	// default Konstruktor
	public ExercisesDataModel() {
		dataVector = new Vector<ExercisesDataClass>();
		//Abs
		dataVector.add(new ExercisesDataClass("Ab-Wheel Rollout", "Abs", 0));
		dataVector.add(new ExercisesDataClass("Cable Crunch", "Abs", 0));
		dataVector.add(new ExercisesDataClass("Crunch", "Abs", 2));
		dataVector.add(new ExercisesDataClass("Crunch Machine", "Abs", 0));
		dataVector.add(new ExercisesDataClass("Decline Crunch", "Abs", 2));
		dataVector.add(new ExercisesDataClass("Dragon Flag", "Abs", 3));
		dataVector.add(new ExercisesDataClass("Hanging Knee Raise", "Abs", 2));
		dataVector.add(new ExercisesDataClass("Hanging Leg Raise", "Abs", 2));
		dataVector.add(new ExercisesDataClass("Lying Leg Raise", "Abs", 2));
		dataVector.add(new ExercisesDataClass("Plank", "Abs", 3));
		dataVector.add(new ExercisesDataClass("Side Crunch", "Abs", 2));
		//Back
		dataVector.add(new ExercisesDataClass("Barbell Row", "Back", 0));
		dataVector.add(new ExercisesDataClass("Barbell Shrug", "Back", 0));
		dataVector.add(new ExercisesDataClass("Chin Up", "Back", 2));
		dataVector.add(new ExercisesDataClass("Deadlift", "Back", 0));
		dataVector.add(new ExercisesDataClass("Dumbbell Row", "Back", 0));
		dataVector.add(new ExercisesDataClass("Good Morning", "Back", 0));
		dataVector.add(new ExercisesDataClass("Hammer Strength Row", "Back", 0));
		dataVector.add(new ExercisesDataClass("Lat Pulldown", "Back", 0));
		dataVector.add(new ExercisesDataClass("Machine Shrug", "Back", 0));
		dataVector.add(new ExercisesDataClass("Neutral Chin Up", "Back", 2));
		dataVector.add(new ExercisesDataClass("Pendlay Row", "Back", 0));
		dataVector.add(new ExercisesDataClass("Pull Up", "Back", 2));
		dataVector.add(new ExercisesDataClass("Rack Pull", "Back", 0));
		dataVector.add(new ExercisesDataClass("Seated Cable Row", "Back", 0));
		dataVector.add(new ExercisesDataClass("Straight-Arm Cable Pushdown", "Back", 0));
		dataVector.add(new ExercisesDataClass("T-Bar Row", "Back", 0));
		//Biceps
		dataVector.add(new ExercisesDataClass("Barbell Curl", "Biceps", 0));
		dataVector.add(new ExercisesDataClass("Cable Curl", "Biceps", 0));
		dataVector.add(new ExercisesDataClass("Dumbbell Concentration Curl", "Biceps", 0));
		dataVector.add(new ExercisesDataClass("Dumbbell Curl", "Biceps", 0));
		dataVector.add(new ExercisesDataClass("Dumbbell Hammer Curl", "Biceps", 0));
		dataVector.add(new ExercisesDataClass("Dumbbell Preacher Curl", "Biceps", 0));
		dataVector.add(new ExercisesDataClass("EZ-Bar Curl", "Biceps", 0));
		dataVector.add(new ExercisesDataClass("Ez-Bar Preacher Curl", "Biceps", 0));
		dataVector.add(new ExercisesDataClass("Seated Incline Dumbbell Curl", "Biceps", 0));
		dataVector.add(new ExercisesDataClass("Seated Machine Curl", "Biceps", 0));
		dataVector.add(new ExercisesDataClass("Scottbank Hammer Curl", "Biceps", 0));
		//Cardio
		dataVector.add(new ExercisesDataClass("Cycling", "Cardio", 1));
		dataVector.add(new ExercisesDataClass("Ellipical Trainer", "Cardio", 1));
		dataVector.add(new ExercisesDataClass("Rowing Machine", "Cardio", 1));
		dataVector.add(new ExercisesDataClass("Running (Outdoor)", "Cardio", 1));
		dataVector.add(new ExercisesDataClass("Running (Treadmill)", "Cardio", 1));
		dataVector.add(new ExercisesDataClass("Stationary Bike", "Cardio", 1));
		dataVector.add(new ExercisesDataClass("Swimming", "Cardio", 1));
		dataVector.add(new ExercisesDataClass("Walking", "Cardio", 1));
		//Chest
		dataVector.add(new ExercisesDataClass("Cable Crossover", "Chest", 0));
		dataVector.add(new ExercisesDataClass("Chest Dip", "Chest", 2));
		dataVector.add(new ExercisesDataClass("Decline Barbell Bench Press", "Chest", 0));
		dataVector.add(new ExercisesDataClass("Decline Hammer Strength Chest Press", "Chest", 0));
		dataVector.add(new ExercisesDataClass("Flat Barbell Bench Press", "Chest", 0));
		dataVector.add(new ExercisesDataClass("Flat Dumbbell Bench Press", "Chest", 0));
		dataVector.add(new ExercisesDataClass("Flat Dumbbell Fly", "Chest", 0));
		dataVector.add(new ExercisesDataClass("Incline Barbell Bench Press", "Chest", 0));
		dataVector.add(new ExercisesDataClass("Incline Dumbbell Bench Press", "Chest", 0));
		dataVector.add(new ExercisesDataClass("Incline Dumbbell Fly", "Chest", 0));
		dataVector.add(new ExercisesDataClass("Incline Hammer Strength Chest Press", "Chest", 0));
		dataVector.add(new ExercisesDataClass("Seated Machine Fly", "Chest", 0));
		dataVector.add(new ExercisesDataClass("tight Incline Bench Press", "Chest", 0));
		//Legs
		dataVector.add(new ExercisesDataClass("Barbell Calf Raise", "Legs", 0));
		dataVector.add(new ExercisesDataClass("Barbell Front Squad", "Legs", 0));
		dataVector.add(new ExercisesDataClass("Barbell Glute Bridge", "Legs", 0));
		dataVector.add(new ExercisesDataClass("Barbell Squad", "Legs", 0));
		dataVector.add(new ExercisesDataClass("Donkey Calf Raise", "Legs", 0));
		dataVector.add(new ExercisesDataClass("Glute-Ham Raise", "Legs", 0));
		dataVector.add(new ExercisesDataClass("Leg Extendsion Machine", "Legs", 0));
		dataVector.add(new ExercisesDataClass("Leg Press", "Legs", 0));
		dataVector.add(new ExercisesDataClass("Lying Leg Curl Machine", "Legs", 0));
		dataVector.add(new ExercisesDataClass("Romanian Deadlift", "Legs", 0));
		dataVector.add(new ExercisesDataClass("Seated Calf Raise Machine", "Legs", 0));
		dataVector.add(new ExercisesDataClass("Seated Leg Curl Machine", "Legs", 0));
		dataVector.add(new ExercisesDataClass("Standing Calf Raise Machine", "Legs", 0));
		dataVector.add(new ExercisesDataClass("Stiff-Legged Deadlift", "Legs", 0));
		dataVector.add(new ExercisesDataClass("Sumo Deadlift", "Legs", 0));
		//Shoulders
		dataVector.add(new ExercisesDataClass("Arnold Dumbbell Press", "Shoulders", 0));
		dataVector.add(new ExercisesDataClass("Behind The Neck Barbbell Press", "Shoulders", 0));
		dataVector.add(new ExercisesDataClass("Cable Face Pull", "Shoulders", 0));
		dataVector.add(new ExercisesDataClass("Front Dumbbell Raise", "Shoulders", 0));
		dataVector.add(new ExercisesDataClass("Hammer Strength Shoulder Press", "Shoulders", 0));
		dataVector.add(new ExercisesDataClass("Lateral Dumbbell Raise", "Shoulders", 0));
		dataVector.add(new ExercisesDataClass("Lateral Machine Raise", "Shoulders", 0));
		dataVector.add(new ExercisesDataClass("Log Press", "Shoulders", 0));
		dataVector.add(new ExercisesDataClass("One-Arm Standing Dumbbell Press", "Shoulders", 0));
		dataVector.add(new ExercisesDataClass("Overhead Press", "Shoulders", 0));
		dataVector.add(new ExercisesDataClass("Push Press", "Shoulders", 0));
		dataVector.add(new ExercisesDataClass("Rear Delt Dumbbell Raise", "Shoulders", 0));
		dataVector.add(new ExercisesDataClass("Rear Delt Machine Fly", "Shoulders", 0));
		dataVector.add(new ExercisesDataClass("Seated Dumbbell Lateral Raise", "Shoulders", 0));
		dataVector.add(new ExercisesDataClass("Seated Dumbbell Press", "Shoulders", 0));
		dataVector.add(new ExercisesDataClass("Smith Machine Overhead Press", "Shoulders", 0));
		//Triceps
		dataVector.add(new ExercisesDataClass("Cable Overhead Triceps Extension", "Triceps", 0));
		dataVector.add(new ExercisesDataClass("Cable Triceps Extension", "Triceps", 0));
		dataVector.add(new ExercisesDataClass("Close Grip Barbell Bench Press", "Triceps", 0));
		dataVector.add(new ExercisesDataClass("Dumbbell Overhead Triceps Extension", "Triceps", 0));
		dataVector.add(new ExercisesDataClass("EZ-Bar Skullcrusher", "Triceps", 0));
		dataVector.add(new ExercisesDataClass("Lying Triceps Extension", "Triceps", 0));
		dataVector.add(new ExercisesDataClass("Parallel Bar Triceps Dip", "Triceps", 0));
		dataVector.add(new ExercisesDataClass("Ring Dip", "Triceps", 0));
		dataVector.add(new ExercisesDataClass("Rope Push Down", "Triceps", 0));
		dataVector.add(new ExercisesDataClass("Smith Machine Close Grip Bench Press", "Triceps", 0));
		dataVector.add(new ExercisesDataClass("V-Bar Push Down", "Triceps", 0));
	}

	/**
	 * Klärt die Frage ob die Zelle editierbar ist
	 *
	 * @param rowIndex    die Reihe, in der die Zelle ist
	 * @param columnIndex die Kolonne, in der die Zelle ist
	 * @return true, wenn die Zelle editierbar ist und false, falls nicht
	 */
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if (columnIndex > 0)
			return true;
		else
			return false;
	}

	/**
	 * Fügt eine Reihe zur Tabelle hinzu
	 *
	 * @param obj Eine Referenz zur DataClass-Klasse
	 */
	public void addRow(ExercisesDataClass obj) {
		dataVector.add(obj);
		this.fireTableDataChanged();
	}

	/**
	 * Saved Objekte
	 *
	 * @param obj Eine Referenz zur DataClass-Klasse
	 */
	/**
	 * gibt die Anzahl Kolonnen zurück
	 *
	 * @return die Anzahl Kolonnen
	 */
	@Override
	public int getColumnCount() {
		return title.length - 2;
	}

	/**
	 * gibt die Anzahl Reihen zurück
	 *
	 * @return die Anzahl Reihen
	 */
	@Override
	public int getRowCount() {
		return dataVector.size();
	}

	/**
	 * gibt den Namen Kolonne zurück
	 *
	 * @return Name der Kolonne
	 */
	@Override
	public String getColumnName(int column) {
		return title[column];
	}

	/**
	 * gibt den Wert einer Zelle zurück
	 *
	 * @param rowIndex    die Reihe, in der sich die Zelle befindet
	 * @param columnIndex Die Kolonne, in der sich die Zelle befindet
	 * @return Die Zelle
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		ExercisesDataClass dc = dataVector.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return dc.getExcercises();
		case 1:
			return dc.getGroup();
		case 2:
			return dc.getType();
		default:
			return null;
		}
	}

	/**
	 * setzt den Wert einer Zelle
	 *
	 * @param aValue
	 * @param rowIndex     die Reihe, in der sich die Zelle befindet
	 * @param coloumnIndex Die Kolonne, in der sich die Zelle befindet
	 */
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		ExercisesDataClass dc = dataVector.get(rowIndex);
		switch (columnIndex) {
		case 0:
			dc.setExcercises((String) aValue);
			break;
		case 1:
			dc.setGroup((String) aValue);
			break;
		}
		this.fireTableDataChanged();
	}

	/**
	 * Gibt ein Vektor zurück
	 * 
	 * @return ein Vektor
	 */
	public Vector<ExercisesDataClass> getDataVector() {
		return dataVector;
	}
}
