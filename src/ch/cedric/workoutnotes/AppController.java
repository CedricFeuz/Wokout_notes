package ch.cedric.workoutnotes;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import ch.cedric.workoutnotes.data.ExercisesDataClass;
import ch.cedric.workoutnotes.gui.DistanceTimeGUI;
import ch.cedric.workoutnotes.gui.ExercisesGUI;
import ch.cedric.workoutnotes.gui.MainWorkoutGUI;
import ch.cedric.workoutnotes.gui.RepsGUI;
import ch.cedric.workoutnotes.gui.TimeGUI;
import ch.cedric.workoutnotes.gui.WeightRepsGUI;
import ch.cedric.workoutnotes.gui.newExercisesGUI;
import ch.cedric.workoutnotes.model.ExercisesDataModel;

/**
 * Kombiniert die Model-Klassen und die GUI-Klassen
 * 
 * @author C�dric Feuz
 * @since 2019-07-24
 * @version 1.0
 *
 */
public class AppController {

	private MainWorkoutGUI mainWorkout;
	private ExercisesDataModel model;
	private ExercisesDataClass data;
	private ExercisesGUI exercises;
	private newExercisesGUI input;
	private WeightRepsGUI weightreps;
	private DistanceTimeGUI distancetime;
	private RepsGUI reps;
	private TimeGUI time;
	private Vector<ExercisesDataClass> dataVector = new Vector<ExercisesDataClass>();
	private boolean isExercisesGUIopen = false;
	private boolean isAbsopen = false;
	public boolean test = false;

	/**
	 * Konstruktor
	 * 
	 * @param mainWorkout Referenz zur MainWorkoutGUI-Klasse
	 */
	public AppController(MainWorkoutGUI mainWorkout) {
		this.mainWorkout = mainWorkout;
		mainWorkout.addNewWorkoutLabelListener(new StartNewWorkoutLabelListener());
		mainWorkout.addArrowRightIconLabelListener(new addRightIconLabelListener());
		mainWorkout.addArrowLeftIconLabelListener(new addLeftIconLabelListener());
	}

	/**
	 * �ffnet die Tabelle und schliesst die mainWorkoutGUI-Klasse
	 */
	public void workoutTableInstance() {
		if (isExercisesGUIopen == false) {
			model = new ExercisesDataModel();
			exercises = new ExercisesGUI(model);
			exercises.addAbsLabel(new addAbsLabel());
			exercises.addBackLabel(new addBackLabel());
			exercises.addBicepsLabel(new addBicepsLabel());
			exercises.addCardioLabel(new addCardioLabel());
			exercises.addChestLabel(new addChestLabel());
			exercises.addLegsLabel(new addLegsLabel());
			exercises.addShouldersLabel(new addShouldersLabel());
			exercises.addTricepsLabel(new addTricpesLabel());
			exercises.addExerciseButtonListener(new addExerciseButton());
			exercises.addTableListener(new absTableListener());
			exercises.addBackButton(new backButtonExercisesListener());
			isExercisesGUIopen = true;
		} else {
			exercises.getFrame().show();
			exercises.getAbsTableScrollerPane().hide();
			exercises.getCategoriesPanel().setVisible(true);
		}
		mainWorkout.getFrame().hide();
	}

	/**
	 * Zeigt alle Rumpf�bungen an
	 */
	public void absSelectInstance() {
		exercises.getAllExercisesLabel().setText("Abs");
		exercises.getCategoriesPanel().setVisible(false);
		// Alle Objekte die der Gruppe Abs angeh�ren raussortieren
		if (isAbsopen == false) {
			for (int i = 0; i < model.getDataVector().size(); i++) {
				dataVector.add(model.getDataVector().elementAt(i));
				if (model.getDataVector().elementAt(i).getGroup() != "Abs") {
					model.getDataVector().remove(i);
					i--;
				}
			}
			exercises.getFrame().add(exercises.getAbsTableScrollerPane(), BorderLayout.CENTER);
			isAbsopen = true;
		} else {
			// den Vektor komplett leer machen
			for (int i = 0; i < model.getDataVector().size(); i++) {
				model.getDataVector().remove(i);
				i--;
			}
			// Die Abs Tabelle anzeigen
			exercises.getAbsTableScrollerPane().show();
			// Den Vektor wieder auff�llen
			for (int i = 0; i < dataVector.size(); i++) {
				model.getDataVector().add(dataVector.elementAt(i));
			}
			// Alle Objekte die der Gruppe Abs angeh�ren raussortieren
			for (int i = 0; i < model.getDataVector().size(); i++) {
				if (model.getDataVector().elementAt(i).getGroup() != "Abs") {
					model.getDataVector().remove(i);
					i--;
				}
			}
		}
		exercises.getFrame().add(exercises.getAbsTableScrollerPane(), BorderLayout.CENTER);
	}

	/**
	 * Zeigt alle R�cken�bungen an
	 */
	public void backSelectInstance() {
		exercises.getAllExercisesLabel().setText("Back");
		exercises.getCategoriesPanel().setVisible(false);
		// Alle Objekte die der Gruppe Back angeh�ren raussortieren
		if (isAbsopen == false) {
			for (int i = 0; i < model.getDataVector().size(); i++) {
				dataVector.add(model.getDataVector().elementAt(i));
				if (model.getDataVector().elementAt(i).getGroup() != "Back") {
					model.getDataVector().remove(i);
					i--;
				}
			}
			exercises.getFrame().add(exercises.getAbsTableScrollerPane(), BorderLayout.CENTER);
			isAbsopen = true;
		} else {
			// den Vektor komplett leer machen
			for (int i = 0; i < model.getDataVector().size(); i++) {
				model.getDataVector().remove(i);
				i--;
			}
			// Die Back Tabelle anzeigen
			exercises.getAbsTableScrollerPane().show();
			// Den Vektor wieder auff�llen
			for (int i = 0; i < dataVector.size(); i++) {
				model.getDataVector().add(dataVector.elementAt(i));
			}
			// Alle Objekte die der Gruppe Back angeh�ren raussortieren
			for (int i = 0; i < model.getDataVector().size(); i++) {
				if (model.getDataVector().elementAt(i).getGroup() != "Back") {
					model.getDataVector().remove(i);
					i--;
				}
			}
		}
		exercises.getFrame().add(exercises.getAbsTableScrollerPane(), BorderLayout.CENTER);
	}

	/**
	 * Zeigt alle Bizeps�bungen an
	 */
	public void bicepsSelectInstance() {
		exercises.getAllExercisesLabel().setText("Biceps");
		exercises.getCategoriesPanel().setVisible(false);
		// Alle Objekte die der Gruppe Biceps angeh�ren raussortieren
		if (isAbsopen == false) {
			for (int i = 0; i < model.getDataVector().size(); i++) {
				dataVector.add(model.getDataVector().elementAt(i));
				if (model.getDataVector().elementAt(i).getGroup() != "Biceps") {
					model.getDataVector().remove(i);
					i--;
				}
			}
			exercises.getFrame().add(exercises.getAbsTableScrollerPane(), BorderLayout.CENTER);
			isAbsopen = true;
		} else {
			// den Vektor komplett leer machen
			for (int i = 0; i < model.getDataVector().size(); i++) {
				model.getDataVector().remove(i);
				i--;
			}
			// Die Biceps Tabelle anzeigen
			exercises.getAbsTableScrollerPane().show();
			// Den Vektor wieder auff�llen
			for (int i = 0; i < dataVector.size(); i++) {
				model.getDataVector().add(dataVector.elementAt(i));
			}
			// Alle Objekte die der Gruppe Biceps angeh�ren raussortieren
			for (int i = 0; i < model.getDataVector().size(); i++) {
				if (model.getDataVector().elementAt(i).getGroup() != "Biceps") {
					model.getDataVector().remove(i);
					i--;
				}
			}
		}
		exercises.getFrame().add(exercises.getAbsTableScrollerPane(), BorderLayout.CENTER);
	}

	/**
	 * Zeigt alle Cardio�bungen an
	 */
	public void cardioSelectInstance() {
		exercises.getAllExercisesLabel().setText("Cardio");
		exercises.getCategoriesPanel().setVisible(false);
		// Alle Objekte die der Gruppe Cardio angeh�ren raussortieren
		if (isAbsopen == false) {
			for (int i = 0; i < model.getDataVector().size(); i++) {
				dataVector.add(model.getDataVector().elementAt(i));
				if (model.getDataVector().elementAt(i).getGroup() != "Cardio") {
					model.getDataVector().remove(i);
					i--;
				}
			}
			exercises.getFrame().add(exercises.getAbsTableScrollerPane(), BorderLayout.CENTER);
			isAbsopen = true;
		} else {
			// den Vektor komplett leer machen
			for (int i = 0; i < model.getDataVector().size(); i++) {
				model.getDataVector().remove(i);
				i--;
			}
			// Die Cardio Tabelle anzeigen
			exercises.getAbsTableScrollerPane().show();
			// Den Vektor wieder auff�llen
			for (int i = 0; i < dataVector.size(); i++) {
				model.getDataVector().add(dataVector.elementAt(i));
			}
			// Alle Objekte die der Gruppe Cardio angeh�ren raussortieren
			for (int i = 0; i < model.getDataVector().size(); i++) {
				if (model.getDataVector().elementAt(i).getGroup() != "Cardio") {
					model.getDataVector().remove(i);
					i--;
				}
			}
		}
		exercises.getFrame().add(exercises.getAbsTableScrollerPane(), BorderLayout.CENTER);
	}

	/**
	 * Zeigt alle Brust�bungen an
	 */
	public void chestSelectInstance() {
		exercises.getAllExercisesLabel().setText("Chest");
		exercises.getCategoriesPanel().setVisible(false);
		// Alle Objekte die der Gruppe Chest angeh�ren raussortieren
		if (isAbsopen == false) {
			for (int i = 0; i < model.getDataVector().size(); i++) {
				dataVector.add(model.getDataVector().elementAt(i));
				if (model.getDataVector().elementAt(i).getGroup() != "Chest") {
					model.getDataVector().remove(i);
					i--;
				}
			}
			exercises.getFrame().add(exercises.getAbsTableScrollerPane(), BorderLayout.CENTER);
			isAbsopen = true;
		} else {
			// den Vektor komplett leer machen
			for (int i = 0; i < model.getDataVector().size(); i++) {
				model.getDataVector().remove(i);
				i--;
			}
			// Die Chest Tabelle anzeigen
			exercises.getAbsTableScrollerPane().show();
			// Den Vektor wieder auff�llen
			for (int i = 0; i < dataVector.size(); i++) {
				model.getDataVector().add(dataVector.elementAt(i));
			}
			// Alle Objekte die der Gruppe Chest angeh�ren raussortieren
			for (int i = 0; i < model.getDataVector().size(); i++) {
				if (model.getDataVector().elementAt(i).getGroup() != "Chest") {
					model.getDataVector().remove(i);
					i--;
				}
			}
		}
		exercises.getFrame().add(exercises.getAbsTableScrollerPane(), BorderLayout.CENTER);
	}

	/**
	 * Zeigt alle Bein�bungen an
	 */
	public void legsSelectInstance() {
		exercises.getAllExercisesLabel().setText("Legs");
		exercises.getCategoriesPanel().setVisible(false);
		// Alle Objekte die der Gruppe Legs angeh�ren raussortieren
		if (isAbsopen == false) {
			for (int i = 0; i < model.getDataVector().size(); i++) {
				dataVector.add(model.getDataVector().elementAt(i));
				if (model.getDataVector().elementAt(i).getGroup() != "Legs") {
					model.getDataVector().remove(i);
					i--;
				}
			}
			exercises.getFrame().add(exercises.getAbsTableScrollerPane(), BorderLayout.CENTER);
			isAbsopen = true;
		} else {
			// den Vektor komplett leer machen
			for (int i = 0; i < model.getDataVector().size(); i++) {
				model.getDataVector().remove(i);
				i--;
			}
			// Die Legs Tabelle anzeigen
			exercises.getAbsTableScrollerPane().show();
			// Den Vektor wieder auff�llen
			for (int i = 0; i < dataVector.size(); i++) {
				model.getDataVector().add(dataVector.elementAt(i));
			}
			// Alle Objekte die der Gruppe Legs angeh�ren raussortieren
			for (int i = 0; i < model.getDataVector().size(); i++) {
				if (model.getDataVector().elementAt(i).getGroup() != "Legs") {
					model.getDataVector().remove(i);
					i--;
				}
			}
		}
		exercises.getFrame().add(exercises.getAbsTableScrollerPane(), BorderLayout.CENTER);
	}

	/**
	 * Zeigt alle Schulter�bungen an
	 */
	public void shouldersSelectInstance() {
		exercises.getAllExercisesLabel().setText("Shoulders");
		exercises.getCategoriesPanel().setVisible(false);
		// Alle Objekte die der Gruppe Shoulders angeh�ren raussortieren
		if (isAbsopen == false) {
			for (int i = 0; i < model.getDataVector().size(); i++) {
				dataVector.add(model.getDataVector().elementAt(i));
				if (model.getDataVector().elementAt(i).getGroup() != "Shoulders") {
					model.getDataVector().remove(i);
					i--;
				}
			}
			exercises.getFrame().add(exercises.getAbsTableScrollerPane(), BorderLayout.CENTER);
			isAbsopen = true;
		} else {
			// den Vektor komplett leer machen
			for (int i = 0; i < model.getDataVector().size(); i++) {
				model.getDataVector().remove(i);
				i--;
			}
			// Die Shoulders Tabelle anzeigen
			exercises.getAbsTableScrollerPane().show();
			// Den Vektor wieder auff�llen
			for (int i = 0; i < dataVector.size(); i++) {
				model.getDataVector().add(dataVector.elementAt(i));
			}
			// Alle Objekte die der Gruppe Shoulders angeh�ren raussortieren
			for (int i = 0; i < model.getDataVector().size(); i++) {
				if (model.getDataVector().elementAt(i).getGroup() != "Shoulders") {
					model.getDataVector().remove(i);
					i--;
				}
			}
		}
		exercises.getFrame().add(exercises.getAbsTableScrollerPane(), BorderLayout.CENTER);
	}

	/**
	 * Zeigt alle Triceps�bungen an
	 */
	public void tricepsSelectInstance() {
		exercises.getAllExercisesLabel().setText("Triceps");
		exercises.getCategoriesPanel().setVisible(false);
		// Alle Objekte die der Gruppe Triceps angeh�ren raussortieren
		if (isAbsopen == false) {
			for (int i = 0; i < model.getDataVector().size(); i++) {
				dataVector.add(model.getDataVector().elementAt(i));
				if (model.getDataVector().elementAt(i).getGroup() != "Triceps") {
					model.getDataVector().remove(i);
					i--;
				}
			}
			exercises.getFrame().add(exercises.getAbsTableScrollerPane(), BorderLayout.CENTER);
			isAbsopen = true;
		} else {
			// den Vektor komplett leer machen
			for (int i = 0; i < model.getDataVector().size(); i++) {
				model.getDataVector().remove(i);
				i--;
			}
			// Die Triceps Tabelle anzeigen
			exercises.getAbsTableScrollerPane().show();
			// Den Vektor wieder auff�llen
			for (int i = 0; i < dataVector.size(); i++) {
				model.getDataVector().add(dataVector.elementAt(i));
			}
			// Alle Objekte die der Gruppe Triceps angeh�ren raussortieren
			for (int i = 0; i < model.getDataVector().size(); i++) {
				if (model.getDataVector().elementAt(i).getGroup() != "Triceps") {
					model.getDataVector().remove(i);
					i--;
				}
			}
		}
		exercises.getFrame().add(exercises.getAbsTableScrollerPane(), BorderLayout.CENTER);
	}

	/**
	 * F�gt eine �bung hinzu
	 */
	public void addExerciseInstance() {
		input = new newExercisesGUI(exercises.getModel());
		input.addOkButton(new okButtonListener());
		input.addAbortButton(new abortButtonListener());
	}

	/**
	 * Geht aus der Klasse newExercisesGUI
	 */
	public void abortInstance() {
		input.dispose();
	}

	/**
	 * F�gt eine �bung hinzu
	 */
	public void okInstance() {
		// direktes Hinzuf�gen zu Tabelle
		((ExercisesDataModel) model).addRow(new ExercisesDataClass(input.getExerciseTextField().getText(),
				input.getGroupComboBox().getSelectedItem().toString(), input.getTypeComboBox()));
		dataVector.add(new ExercisesDataClass(input.getExerciseTextField().getText(),
				input.getGroupComboBox().getSelectedItem().toString(), input.getTypeComboBox()));
		input.dispose();
	}

	/**
	 * F�gt eine �bung zum Workout hinzu
	 */
	public void tableInstance() {
		if ((model.getValueAt(exercises.getAbsTable().getSelectedRow(),
				exercises.getAbsTable().getSelectedColumn() + 2)).toString().equals("0")) {
			weightreps = new WeightRepsGUI();
			String text = model.getValueAt(exercises.getAbsTable().getSelectedRow(), 0).toString();
			weightreps.get�bungLabel().setText(text);
			weightreps.addSaveButton(new saveWeightRepsButtonListener());
			weightreps.addAbortButton(new abortButtonWeightRepsListener());
			weightreps.addClearButton(new clearWeightRepsButtonListener());
			weightreps.addPlusIconLabelListener(new plusIconLabelListener());
			weightreps.addMinusIconLabelListener(new minusIconLabelListener());
			weightreps.addPlusIconRepsLabelListener(new plusIconRepsLabelListener());
			weightreps.addMinusIconRepsLabelListener(new minusIconRepsLabelListener());
		} else if ((model.getValueAt(exercises.getAbsTable().getSelectedRow(),
				exercises.getAbsTable().getSelectedColumn() + 2)).toString().equals("1")) {
			distancetime = new DistanceTimeGUI();
			String text = model.getValueAt(exercises.getAbsTable().getSelectedRow(), 0).toString();
			distancetime.get�bungLabel().setText(text);
			distancetime.addAbortButton(new abortButtonDistanceTimeListener());
			distancetime.addClearButton(new clearDistanceTimeButtonListener());
			distancetime.addSaveButton(new saveDistanceTimeButtonListener());
			
		} else if ((model.getValueAt(exercises.getAbsTable().getSelectedRow(),
				exercises.getAbsTable().getSelectedColumn() + 2)).toString().equals("2")) {
			reps = new RepsGUI();
			String text = model.getValueAt(exercises.getAbsTable().getSelectedRow(), 0).toString();
			reps.get�bungLabel().setText(text);
			reps.addAbortButton(new abortButtonRepsListener());
			reps.addClearButton(new clearRepsButtonListener());
			reps.addSaveButton(new saveRepsButtonListener());
			reps.addPlusIconRepsLabelListener(new plusIconRepsRepsLabelListener());
			reps.addMinusIconRepsLabelListener(new minusIconRepsRepsLabelListener());
		} else if ((model.getValueAt(exercises.getAbsTable().getSelectedRow(),
				exercises.getAbsTable().getSelectedColumn() + 2)).toString().equals("3")) {
			time = new TimeGUI();
			String text = model.getValueAt(exercises.getAbsTable().getSelectedRow(), 0).toString();
			time.get�bungLabel().setText(text);
			time.addAbortButton(new abortButtonTimeListener());
			time.addClearButton(new clearTimeButtonListener());
			time.addSaveButton(new saveTimeButtonListener());
		}
	}

	/**
	 * Erh�ht das Gewicht um 2.5
	 */
	public void plusIconLabel() {
		Double wert = Double.parseDouble(weightreps.getWeightText());
		wert = wert + 2.5;
		String wert2 = wert.toString();
		weightreps.setWeightText(wert2);
	}
	
	/**
	 * senkt das Gewicht um 2.5
	 */
	public void minusIconLabel() {
		Double wert = Double.parseDouble(weightreps.getWeightText());
		wert = wert - 2.5;
		String wert2 = wert.toString();
		weightreps.setWeightText(wert2);
	}
	
	/**
	 * Erh�ht das Gewicht um 2.5
	 */
	public void plusIconRepsLabel() {
		Integer wert = Integer.parseInt(weightreps.getRepsText());
		wert = wert + 1;
		String wert2 = wert.toString();
		weightreps.setRepsText(wert2);
	}
	
	/**
	 * senkt das Gewicht um 2.5
	 */
	public void minusIconRepsLabel() {
		Integer wert = Integer.parseInt(weightreps.getRepsText());
		wert = wert - 1;
		String wert2 = wert.toString();
		weightreps.setRepsText(wert2);
	}
	
	/**
	 * Erh�ht das Gewicht um 2.5
	 */
	public void plusIconRepsRepsLabel() {
		Integer wert = Integer.parseInt(reps.getRepsText());
		wert = wert + 1;
		String wert2 = wert.toString();
		reps.setRepsText(wert2);
	}
	
	/**
	 * senkt das Gewicht um 2.5
	 */
	public void minusIconRepsRepsLabel() {
		Integer wert = Integer.parseInt(reps.getRepsText());
		wert = wert - 1;
		String wert2 = wert.toString();
		reps.setRepsText(wert2);
	}
	/**
	 * Speichert eine �bung
	 */
	public void saveWeightRepsButton() {
		weightreps.getModel().addRow(new Object[] { weightreps.getModel().getRowCount() + 1, weightreps.getWeightText(),
				weightreps.getRepsText() });
		mainWorkout.getEmptyLogLabel().hide();
		mainWorkout.getMainPanel().add(mainWorkout.getTablePane(), BorderLayout.CENTER);
		mainWorkout.getModel().addRow(new Object[] { weightreps.get�bungLabel().getText(), weightreps.getWeightText(),
				weightreps.getRepsText() });
	}

	/**
	 * l�scht alle S�tze einer �bung
	 */
	public void clearWeightRepsButton() {
		int j = weightreps.getModel().getRowCount();
		for (int i = 0; i < j; i++) {
			weightreps.getModel().removeRow(0);
		}
	}

	/**
	 * Speichert eine �bung
	 */
	public void saveDistanceTimeButton() {
		distancetime.getModel().addRow(new Object[] { distancetime.getModel().getRowCount() + 1,
				distancetime.getDistanceText() + "m", distancetime.getHourText() + "h:" + distancetime.getMinutsText()+ "min:" + distancetime.getSecondsText() + "s" });
		mainWorkout.getEmptyLogLabel().hide();
		mainWorkout.getMainPanel().add(mainWorkout.getTablePane(), BorderLayout.CENTER);
		mainWorkout.getModel().addRow(new Object[] { distancetime.get�bungLabel().getText(),
				distancetime.getDistanceText() + "m", distancetime.getHourText() + "h:" + distancetime.getMinutsText()+ "min:" + distancetime.getSecondsText() + "s"});
	}

	/**
	 * l�scht alle S�tze einer �bung
	 */
	public void clearDistanceTimeButton() {
		int j = distancetime.getModel().getRowCount();
		for (int i = 0; i < j; i++) {
			distancetime.getModel().removeRow(0);
		}
	}

	/**
	 * Speichert eine �bung
	 */
	public void saveRepsButton() {
		reps.getModel().addRow(new Object[] { reps.getModel().getRowCount() + 1, reps.getRepsText() });
		mainWorkout.getEmptyLogLabel().hide();
		mainWorkout.getMainPanel().add(mainWorkout.getTablePane(), BorderLayout.CENTER);
		mainWorkout.getModel().addRow(new Object[] {reps.get�bungLabel().getText(), reps.getRepsText() });
	}

	/**
	 * l�scht alle S�tze einer �bung
	 */
	public void clearRepsButton() {
		int j = reps.getModel().getRowCount();
		for (int i = 0; i < j; i++) {
			reps.getModel().removeRow(0);
		}
	}

	/**
	 * Speichert eine �bung
	 */
	public void saveTimeButton() {
		time.getModel().addRow(new Object[] { time.getModel().getRowCount() + 1, time.getHourText() + "h:" + time.getMinutsText() + "min:" + time.getSecondsText() + "s:" });
		mainWorkout.getEmptyLogLabel().hide();
		mainWorkout.getMainPanel().add(mainWorkout.getTablePane(), BorderLayout.CENTER);
		mainWorkout.getModel().addRow(new Object[] { time.get�bungLabel().getText(), time.getHourText() + "h:" + time.getMinutsText() + "min:" + time.getSecondsText() + "s:" });
	}

	/**
	 * l�scht alle S�tze einer �bung
	 */
	public void clearTimeButton() {
		int j = time.getModel().getRowCount();
		for (int i = 0; i < j; i++) {
			time.getModel().removeRow(0);
		}
	}

	/**
	 * geht zur�k zur Tabelle
	 */
	public void abortRepsInstance() {
		reps.getFrame().dispose();
	}

	/**
	 * geht zur�k zur Tabelle
	 */
	public void abortTimeInstance() {
		time.getFrame().dispose();
	}

	/**
	 * geht zur�k zur Tabelle
	 */
	public void abortDistanceTimeInstance() {
		distancetime.getFrame().dispose();
	}

	/**
	 * geht zur�k zur Tabelle
	 */
	public void abortWeightRepsInstance() {
		weightreps.getFrame().dispose();
	}

	/**
	 * geht zur�ck auf MainWorkoutGUI
	 */
	public void backExercisesInstance() {
		exercises.getFrame().hide();
		exercises.getAllExercisesLabel().setText("All Exercises");
		mainWorkout.getFrame().show();
	}

	/**
	 * Der n�chste Tag wir ge�ndert
	 */
	public void arrowRightIconInstance() {
		mainWorkout.setZaehler(mainWorkout.getZaehler() + 1);
	}
	
	/**
	 * Der letzte Tag wir ge�ndert
	 *
	 */
	public void arrowLeftIconInstance() {
		mainWorkout.setZaehler(mainWorkout.getZaehler() - 1);
	}
	// Alle Listener-Klassen
	
	class	addLeftIconLabelListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			arrowLeftIconInstance();
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class	addRightIconLabelListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			arrowRightIconInstance();
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

	class StartNewWorkoutLabelListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			workoutTableInstance();
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}
	}

	class addAbsLabel implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			absSelectInstance();
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}
	}

	class addBackLabel implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			backSelectInstance();
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}
	}

	class addBicepsLabel implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			bicepsSelectInstance();
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}
	}

	class addCardioLabel implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			cardioSelectInstance();
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}
	}

	class addChestLabel implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			chestSelectInstance();
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}
	}

	class addLegsLabel implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			legsSelectInstance();
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}
	}

	class addShouldersLabel implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			shouldersSelectInstance();
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}
	}

	class addTricpesLabel implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			tricepsSelectInstance();
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}
	}

	class addExerciseButton implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			addExerciseInstance();
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}
	}

	class abortButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			abortInstance();
		}
	}

	class okButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			okInstance();
		}
	}

	class absTableListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			tableInstance();
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}
	}

	class abortButtonRepsListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			abortRepsInstance();
		}
	}

	class abortButtonTimeListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			abortTimeInstance();
		}
	}

	class abortButtonDistanceTimeListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			abortDistanceTimeInstance();
		}
	}

	class abortButtonWeightRepsListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			abortWeightRepsInstance();
		}
	}

	class backButtonExercisesListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			backExercisesInstance();
		}
	}

	class plusIconLabelListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			plusIconLabel();
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	class minusIconLabelListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			minusIconLabel();
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class plusIconRepsLabelListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			plusIconRepsLabel();
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	class minusIconRepsLabelListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			minusIconRepsLabel();
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class plusIconRepsRepsLabelListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			plusIconRepsRepsLabel();
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	class minusIconRepsRepsLabelListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			minusIconRepsRepsLabel();
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class saveWeightRepsButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			saveWeightRepsButton();
		}
	}

	class clearWeightRepsButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			clearWeightRepsButton();
		}
	}

	class saveDistanceTimeButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			saveDistanceTimeButton();
		}
	}

	class clearDistanceTimeButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			clearDistanceTimeButton();
		}
	}

	class saveRepsButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			saveRepsButton();
		}
	}

	class clearRepsButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			clearRepsButton();
		}
	}

	class saveTimeButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			saveTimeButton();
		}
	}

	class clearTimeButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			clearTimeButton();
		}
	}
}