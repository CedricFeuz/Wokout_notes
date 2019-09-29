package ch.cedric.workoutnotes.main;

import ch.cedric.workoutnotes.AppController;
import ch.cedric.workoutnotes.gui.MainWorkoutGUI;
import ch.cedric.workoutnotes.gui.WeightRepsGUI;

/**
 * Von dieser Klasse aus läuft das ganze Programm
 * 
 * @author Cédric Feuz
 * @since 2019-07-23
 * @version 1.0
 *
 */

public class Main {

	public static void main(String[] args) {
		MainWorkoutGUI mainGui = new MainWorkoutGUI();
		AppController theController = new AppController(mainGui);
	}
}