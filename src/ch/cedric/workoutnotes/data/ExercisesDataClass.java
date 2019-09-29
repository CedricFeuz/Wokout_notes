package ch.cedric.workoutnotes.data;

import java.io.Serializable;

import ch.cedric.workoutnotes.model.ExercisesDataModel;

/**
 * Die Klasse DataClass reprensentiert ein Datenobjekt mit diversen Attributen.
 * 
 * @author C�dric Feuz
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
	 * Leerer Konstrukter f�r ein Objekt der Daten-Klasse
	 */
	public ExercisesDataClass() {
	}

	/**
	 * Parametrierter Konstruktor der Data-Klasse
	 * 
	 * @param exercises die dazugeh�rige �bung
	 * @param gruppe    die dazugeh�rige Gruppe
	 */
	public ExercisesDataClass(String excercises, String group, int type) {
		this.excercises = excercises;
		this.group = group;
		this.type = type;
	}

	/**
	 * R�ckgabe einer �bung
	 * 
	 * @return eine �bung
	 */
	public String getExcercises() {
		return excercises;
	}

	/**
	 * Setzt eine neue �bung
	 * 
	 * @param excercises eine �bung
	 */
	public void setExcercises(String excercises) {
		this.excercises = excercises;
	}

	/**
	 * R�ckgabe eine Gruppe
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
	 * R�ckgabe eines Types
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
