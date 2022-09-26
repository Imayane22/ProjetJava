package composant;

/**
 * C'est la classe qui nous permettra d'extraire la pelouse et la liste des tendeuse du fichier input
 * @author Imane
 *
 */
public class BlocFichier {
	private int abs; //il s'agit de l'abscisse de la tondeuse
	private int ord; //il s'agit de l'ordonnee de la tondeuse
	private char orientation; //il s'agit de l'orientation de la tondeuse
	private String actions; //il s'agit des deplacement de la tondeuse
	/**
	 * @return l'abcisse
	 */
	public int getAbs() {
		return abs;
	}
	/**
	 * @param abs, affecte l'abcisse
	 */
	public void setAbs(int abs) {
		this.abs = abs;
	}
	/**
	 * @return l'ordonnee
	 */
	public int getOrd() {
		return ord;
	}
	/**
	 * @param ord, affecte l'ordonnee
	 */
	public void setOrd(int ord) {
		this.ord = ord;
	}
	/**
	 * @return l'orientation
	 */
	public char getOrientation() {
		return orientation;
	}
	/**
	 * @param orientation, affecte l'orientation
	 */
	public void setOrientation(char orientation) {
		this.orientation = orientation;
	}
	/**
	 * @return la liste des actions sous forme de chaine de caracteres
	 */
	public String getActions() {
		return actions;
	}
	/**
	 * @param actions, affecte la liste des actions
	 */
	public void setActions(String actions) {
		this.actions = actions;
	}

}
