package composant;
/**
 * Represente la pelouse qui est un rectangle (Larg x Long)
 * @author Imane
 *
 */
public class Pelouse {
	private int largeur;
	private int longueur;
	
	/**
	 * @return la largeur
	 */
	public int getLargeur() {
		return largeur;
	}
	/**
	 * @param largeur, qui est la largeur a affecter a la pelouse
	 */
	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}
	/**
	 * @return la longueur
	 */
	public int getLongueur() {
		return longueur;
	}
	/**
	 * @param longueur,  qui est la longueur a affecter a la pelouse
	 */
	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}
	/**
	 * Constructeur de la Pelouse
	 * @param largeur
	 * @param longueur
	 */
	public Pelouse(int largeur, int longueur)
	{
		this.largeur=largeur;
		this.longueur=longueur;
		
	}

	
}
