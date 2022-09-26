package composant;
/**
 * Represente la tondeuse
 * @author Imane
 *
 */
public class Tondeuse {
	private int abs; //il s'agit de l'abscisse de la tondeuse
	private int ord; //il s'agit de l'ordonnee de la tondeuse
	private char orientation; //il s'agit de l'orientation de la tondeuse
	/**
	 * @return l'abscisse
	 */
	public int getAbs() {
		return abs;
	}
	/**
	 * @param abs, qui est l'abscisse a affecter a la tondeuse
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
	 * @param ord, qui est l'ordonnee a affecter a la tondeuse
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
	 * @param orientation, qui est l'orientation a affecter a la tondeuse
	 */
	public void setOrientation(char orientation) {
		this.orientation = orientation;
	}
	/**
	 * Constructeur de la tondeuse
	 * @param i
	 * @param j
	 * @param c
	 */
	public Tondeuse(int i, int j, char c) {
		this.setAbs(i);
		this.setOrd(j);
		this.setOrientation(c);
	}
	
}
