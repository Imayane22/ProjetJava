package application;
import composant.BlocFichier;
import composant.Pelouse;
import composant.Tondeuse;
import traitement.Actions;
import traitement.ParsingFichier;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.*;

/**
 * C'est la classe principale
 * @author Imane
 *
 */

public class MyApp {

	/**
	 * @param args
	 * @throws Exception 
	 */
	static final Logger LOGGER =  LogManager.getLogger( MyApp.class );
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	
		Actions actions = new Actions();
		try{
			//on recupere le chemin du fichier input
			
			ParsingFichier parsingfich = new ParsingFichier(args[0]);
			Pelouse pelouse=parsingfich.getPelouse();
			List<BlocFichier> listeBlocs=parsingfich.getBlocs();
			for(BlocFichier bloc : listeBlocs)
			{
				Tondeuse tondeuse= new Tondeuse(bloc.getAbs(),bloc.getOrd(), bloc.getOrientation());
				actions.actionsTondeuse(tondeuse, pelouse, bloc.getActions());
			}
			
		}catch(Exception e){
			LOGGER.error(e.getMessage());
			System.exit(-1);
			}
		
		}

}
