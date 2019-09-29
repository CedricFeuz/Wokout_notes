package ch.cedric.workoutnotes.data;

import java.io.Serializable;

import ch.cedric.workoutnotes.model.ExercisesDataModel;

/**
 * Die Klasse DataClass reprensentiert ein Datenobjekt mit diversen Attributen.
 * 
 * @author Cédric Feuz
 * @date 24-7-2019
 * @version 1.0
 *
 */
public class ExercisesDataClass {

	private String excercises;
	private String group;
	private int type;
	private ExercisesDataModel model;

	/**
	 * Leerer Konstrukter für ein Objekt der Daten-Klasse
	 */
	public ExercisesDataClass() {
	}

	/**
	 * Parametrierter Konstruktor der Data-Klasse
	 * 
	 * @param exercises die dazugehörige Übung
	 * @param gruppe    die dazugehörige Gruppe
	 */
	public ExercisesDataClass(String excercises, String group, int type) {
		this.excercises = excercises;
		this.group = group;
		this.type = type;
	}

	/**
	 * Rückgabe einer Übung
	 * 
	 * @return eine Übung
	 */
	public String getExcercises() {
		return excercises;
	}

	/**
	 * Setzt eine neue Übung
	 * 
	 * @param excercises eine Übung
	 */
	public void setExcercises(String excercises) {
		this.excercises = excercises;
	}

	/**
	 * Rückgabe eine Gruppe
	 * 
	 * @return eine Gruppe
	 */
	public String getGroup() {
		return group;
	}

	/**
	 * Setzt eine neue Gruppe
	 * 
	 * @param group eine Gruppe
	 */
	public void setGroup(String group) {
		this.group = group;
	}

	/**
	 * Rückgabe eines Types
	 * 
	 * @return ein Typ
	 */
	public int getType() {
		return type;
	}

	/**
	 * ein neuer Typ
	 * 
	 * @param type ein Typ
	 */
	public void setType(int type) {
		this.type = type;
	}

}
