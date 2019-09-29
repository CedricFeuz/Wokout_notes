package ch.cedric.workoutnotes.main;

import ch.cedric.workoutnotes.AppController;
import ch.cedric.workoutnotes.gui.MainWorkoutGUI;
import ch.cedric.workoutnotes.gui.WeightRepsGUI;

/**
 * Von dieser Klasse aus l�uft das ganze Programm
 * 
 * @author C�dric Feuz
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