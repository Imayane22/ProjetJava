package traitement;

import org.apache.logging.log4j.*;

import composant.Pelouse;
import composant.Tondeuse;

/**
 * Represente l'ensemble des actions possibles pour la tondeuse
 * @author Imane
 *
 */
public class Actions {
	
	//on instancie un logger pour suivi d'execution sur la console
	
	static final Logger LOGGER =  LogManager.getLogger( Actions.class );
	
	/**
	 * Traitement correspondant a l'action 'D'
	 * @param tondeuse
	 */
	public void tournerDroite(Tondeuse tondeuse)
	{
				
		LOGGER.info("La tondeuse tourne a droite");
		switch(tondeuse.getOrientation()) {
			case 'N': 
			   tondeuse.setOrientation('E');
	           break;
	   
	       case 'E':
	    	   tondeuse.setOrientation('S');
	           break;
	   
	       case 'W':
	    	   tondeuse.setOrientation('N');
	           break;
	           
	       case 'S':
	    	   tondeuse.setOrientation('W');
	           break;
		}
	}
	/**
	 * Traitement correspondant a l'action 'G'
	 * @param tondeuse
	 */
	public void tournerGauche(Tondeuse tondeuse)
	{
	
		
		LOGGER.info("La tondeuse tourne a gauche");
		switch(tondeuse.getOrientation()) {
			case 'N': 
			   tondeuse.setOrientation('W');
	           break;
	   
	       case 'E':
	    	   tondeuse.setOrientation('N');
	           break;
	   
	       case 'W':
	    	   tondeuse.setOrientation('S');
	           break;
	           
	       case 'S':
	    	   tondeuse.setOrientation('E');
	           break;
		}
	}
	/**
	 * Traitement correspondant a l'action 'A' 
	 * Si depassement de la pelouse, affichage d'un message et on passe a l'action suivante
	 * @param tondeuse
	 * @param pelouse
	 */
	public void avancer(Tondeuse tondeuse, Pelouse pelouse) 
	{
		LOGGER.info("La tondeuse avance");
		switch (tondeuse.getOrientation()) {
			case 'N':
				if(tondeuse.getOrd()<pelouse.getLargeur()-1)
					tondeuse.setOrd(tondeuse.getOrd()+1);
				else
					LOGGER.info("Le deplacement demande depasse les dimensions de la pelouse, la tondeuse ne bouge pas");
				break;
			case 'E':
				if(tondeuse.getAbs()<pelouse.getLongueur()-1)
					tondeuse.setAbs(tondeuse.getAbs()+1);
				else
					LOGGER.info("Le deplacement demande depasse les dimensions de la pelouse, la tondeuse ne bouge pas");
				break;
			case 'S':
				if(tondeuse.getOrd()>0)
					tondeuse.setOrd(tondeuse.getOrd()-1);
				else
					LOGGER.info("Le deplacement demande depasse les dimensions de la pelouse, la tondeuse ne bouge pas");
				break;
			case 'W':
				if(tondeuse.getAbs()>0)
					tondeuse.setAbs(tondeuse.getAbs()-1);
				else
					LOGGER.info("Le deplacement demande depasse les dimensions de la pelouse, la tondeuse ne bouge pas");
				break;
		}
	}
	/**
	 * La tondeuse a un ensemble d'actions a realiser dans une pelouse
	 * Les actions sont groupees dans une chaine de caracteres
	 * Si une action differe de 'A', 'D', ou 'G', une exception est levee
	 * On affiche a la fin la position finale de la tondeuse, une fois les deplacements effectues
	 * @param tondeuse
	 * @param pelouse
	 * @param actions
	 * @throws Exception
	 */
	public void actionsTondeuse(Tondeuse tondeuse, Pelouse pelouse, String actions) throws Exception
	{
		LOGGER.log(Level.INFO,"La tondeuse demarre son deplacement");
		int i=0;
		char [] actionsSplit = actions.toCharArray();
		while(i<actionsSplit.length)
		{
			LOGGER.info("Position actuelle ({},{},{})", tondeuse.getAbs(), tondeuse.getOrd(), tondeuse.getOrientation());
			switch (actionsSplit[i]) {
			case 'D': 
				tournerDroite(tondeuse);
				break;
			case 'G':
				tournerGauche(tondeuse);
				break;
			case 'A':
				avancer(tondeuse, pelouse);
				break;
			default:
				throw new Exception("Action non reconnue");
			}
			i++;
		}
		LOGGER.info("Position finale ({},{},{})", tondeuse.getAbs(), tondeuse.getOrd(), tondeuse.getOrientation());
	}
}
