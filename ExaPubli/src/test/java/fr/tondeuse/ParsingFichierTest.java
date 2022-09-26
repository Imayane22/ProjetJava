package fr.tondeuse;

import static org.junit.Assert.*;
import org.junit.Test;

import composant.Pelouse;
import traitement.ParsingFichier;

/**
 * Tests pour la classe ParsingFichier
 * @author Imane
 *
 */
public class ParsingFichierTest {

	@Test
	public void lecturePelouseFichierTest() throws Exception {
		ParsingFichier parsingfichier= new ParsingFichier("src/test/resources/testune");
		Pelouse pelouse = parsingfichier.getPelouse();
		assertEquals(6,pelouse.getLargeur());
		assertEquals(6,pelouse.getLongueur());
	}
	@Test
	public void lectureUneTondeuseFichierTest() throws Exception {
		ParsingFichier parsingfichier= new ParsingFichier("src/test/resources/testune");
		assertEquals(1,parsingfichier.getBlocs().get(0).getAbs());
		assertEquals(2,parsingfichier.getBlocs().get(0).getOrd());
		assertEquals('N',parsingfichier.getBlocs().get(0).getOrientation());
	}

}
