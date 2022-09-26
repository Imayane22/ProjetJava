package traitement;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.*;

import composant.*;

/**
 * Represente l'ensemble des traitement a effectuer sur un fichier input
 * le but c'est d'extraire une pelouse (1ere ligne) et
 * une liste de couple (tondeuse & actions a appliquees a cette tondeuse)
 * @author Imane
 *
 */

public class ParsingFichier {

	//on instancie un logger pour suivi d'execution sur la console
	
			static final Logger LOGGER =  LogManager.getLogger(ParsingFichier.class);
			private String path; //le chemin du fichier input
			private Pelouse pelouse; //la pelouse correspondant a la 1ere ligne du fichier input
			private List<BlocFichier> blocs; //chaque BlocFichier contient une tondeuse avec les deplacements qu'elle doit effectuer
			
			/**
			 * @param path
			 * @param pelouse
			 * @param blocs
			 * @throws Exception 
			 */
			
			public ParsingFichier(String path) throws Exception {
				
				LOGGER.info("On commence la lecture du fichier");
				
				this.path = path;
				File file = new File(path);
				Scanner scanner = new Scanner(file);
								
				/**
				 * On construit la pelouse
				 * on verifie que les deux dimensions sont precisees et qu'elles sont des entiers positifs
				 */
				LOGGER.info("On commence par creer la pelouse");
				
				int largeur;
				int longueur;
				String ligne;
				
				this.blocs=new ArrayList<BlocFichier>();
				
				if(scanner.hasNext())
				{
					ligne=scanner.nextLine();
					String[] token = ligne.split(" ");
					if(token.length==2)
					{
					largeur=Integer.valueOf(token[0]);
					longueur=Integer.valueOf(token[1]);
					if(largeur>0 && longueur>0)
						this.pelouse=new Pelouse(largeur+1, longueur+1);
					else
						throw new Exception("Les dimensions doivent etre des entiers positifs");
					}
					else
						throw new Exception("Une dimension est manquante pour creer la pelouse");
				}
				else
					throw new Exception("Fichier vide");
				
				LOGGER.info("La pelouse avec les dimensions "+pelouse.getLargeur()+" x "+pelouse.getLongueur()+" est bien cree");
				
				/**
				 * On construit les blocs de notre traitement
				 * chaque bloc contient la tondeuse avec les deplacements qu'elle doit realiser
				 * Pour creer une tondeuse, on verifie que les coordonnees sont des entiers positifs et que l'orientation est dans la liste [N,E,W,S]
				 */
				String a[] = new String[]{"N","S","E","W"};
				ArrayList arlist = new ArrayList(Arrays.asList(a));
				int i=1;
				
				while(scanner.hasNext())
				{
					LOGGER.info("On cree la Tondeuse N"+i);
					ligne=scanner.nextLine();
					String[] token = ligne.split(" ");
					BlocFichier bloc=new BlocFichier();
					if(Integer.valueOf(token[0])>=0 && Integer.valueOf(token[1])>=0 && arlist.contains(token[2]))
					{
						bloc.setAbs(Integer.valueOf(token[0]));
						bloc.setOrd(Integer.valueOf(token[1]));
						bloc.setOrientation(token[2].charAt(0));			
					}
					else
						throw new Exception("Probleme de creation de la tondeuse, coordonnees non valides");
					if(scanner.hasNext())
					{
						ligne=scanner.nextLine();
						if(ligne.length()>0)
						{
							bloc.setActions(ligne);
							this.blocs.add(bloc);
						}
						else
							throw new Exception("Probleme de creation de la tondeuse, deplacements non fournis");
					}
					else
						throw new Exception("Probleme de creation de la tondeuse, deplacements non fournis");
					
					LOGGER.info("La Tondeuse N"+i+ " est bien cree avec la position ({},{},{}) " ,bloc.getAbs(),bloc.getOrd(),bloc.getOrientation());
					LOGGER.info("Les deplacements prevus pour cette tondeuse sont: "+bloc.getActions());
					i++;
				}
				
			}
			
			/**
			 * @return le chemin du fichier input
			 */
			public String getPath() {
				return path;
			}
			/**
			 * @param path, le chemin ou se trouve le fichier input
			 */
			public void setPath(String path) {
				this.path = path;
			} 
			/**
			 * @return la pelouse
			 */
			public Pelouse getPelouse() {
				return pelouse;
			}
			/**
			 * @param pelouse, qui est la pelouse a affecter
			 */
			public void setPelouse(Pelouse pelouse) {
				this.pelouse = pelouse;
			}
			/**
			 * @return la liste des blocs
			 */
			public List<BlocFichier> getBlocs() {
				return blocs;
			}

			/**
			 * @param blocs, qui sont les blocs a affecter
			 */
			public void setBlocs(List<BlocFichier> blocs) {
				this.blocs = blocs;
			}
}
