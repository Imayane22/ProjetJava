package fr.tondeuse;

import static org.junit.Assert.*;

import org.junit.Test;

import composant.Pelouse;
import composant.Tondeuse;
import traitement.Actions;
/**
 * Tests pour la classe Actions
 * @author Imane
 *
 */
public class ActionsTest {

	@Test
	public void tournerDroiteTestNord() {
		Tondeuse tondeuse=new Tondeuse(1,2,'N');
		Actions actions=new Actions();
		actions.tournerDroite(tondeuse);
		assertEquals(1,tondeuse.getAbs());
		assertEquals(2,tondeuse.getOrd());
		assertEquals('E',tondeuse.getOrientation());
	}
	@Test
	public void tournerDroiteTestEst() {
		Tondeuse tondeuse=new Tondeuse(1,2,'E');
		Actions actions=new Actions();
		actions.tournerDroite(tondeuse);
		assertEquals(1,tondeuse.getAbs());
		assertEquals(2,tondeuse.getOrd());
		assertEquals('S',tondeuse.getOrientation());
	}
	@Test
	public void tournerDroiteTestWest() {
		Tondeuse tondeuse=new Tondeuse(1,2,'W');
		Actions actions=new Actions();
		actions.tournerDroite(tondeuse);
		assertEquals(1,tondeuse.getAbs());
		assertEquals(2,tondeuse.getOrd());
		assertEquals('N',tondeuse.getOrientation());
	}
	@Test
	public void tournerDroiteTestSud() {
		Tondeuse tondeuse=new Tondeuse(1,2,'S');
		Actions actions=new Actions();
		actions.tournerDroite(tondeuse);
		assertEquals(1,tondeuse.getAbs());
		assertEquals(2,tondeuse.getOrd());
		assertEquals('W',tondeuse.getOrientation());
	}
	@Test
	public void tournerGaucheTestNord() {
		Tondeuse tondeuse=new Tondeuse(1,2,'N');
		Actions actions=new Actions();
		actions.tournerGauche(tondeuse);
		assertEquals(1,tondeuse.getAbs());
		assertEquals(2,tondeuse.getOrd());
		assertEquals('W',tondeuse.getOrientation());
	}
	@Test
	public void tournerGaucheTestEst() {
		Tondeuse tondeuse=new Tondeuse(1,2,'E');
		Actions actions=new Actions();
		actions.tournerGauche(tondeuse);
		assertEquals(1,tondeuse.getAbs());
		assertEquals(2,tondeuse.getOrd());
		assertEquals('N',tondeuse.getOrientation());
	}
	@Test
	public void tournerGaucheTestWest() {
		Tondeuse tondeuse=new Tondeuse(1,2,'W');
		Actions actions=new Actions();
		actions.tournerGauche(tondeuse);
		assertEquals(1,tondeuse.getAbs());
		assertEquals(2,tondeuse.getOrd());
		assertEquals('S',tondeuse.getOrientation());
	}
	@Test
	public void tournerGaucheTestSud() {
		Tondeuse tondeuse=new Tondeuse(1,2,'S');
		Actions actions=new Actions();
		actions.tournerGauche(tondeuse);
		assertEquals(1,tondeuse.getAbs());
		assertEquals(2,tondeuse.getOrd());
		assertEquals('E',tondeuse.getOrientation());
	}
	@Test
	public void avancerTestNord() {
		Tondeuse tondeuse=new Tondeuse(1,2,'N');
		Pelouse pelouse=new Pelouse(4,5);
		Actions actions=new Actions();
		actions.avancer(tondeuse, pelouse);
		assertEquals(1,tondeuse.getAbs());
		assertEquals(3,tondeuse.getOrd());
		assertEquals('N',tondeuse.getOrientation());
	}
	@Test
	public void avancerTestEst() {
		Tondeuse tondeuse=new Tondeuse(1,2,'E');
		Pelouse pelouse=new Pelouse(4,5);
		Actions actions=new Actions();
		actions.avancer(tondeuse, pelouse);
		assertEquals(2,tondeuse.getAbs());
		assertEquals(2,tondeuse.getOrd());
		assertEquals('E',tondeuse.getOrientation());
	}
	@Test
	public void avancerTestSud() {
		Tondeuse tondeuse=new Tondeuse(1,2,'S');
		Pelouse pelouse=new Pelouse(4,5);
		Actions actions=new Actions();
		actions.avancer(tondeuse, pelouse);
		assertEquals(1,tondeuse.getAbs());
		assertEquals(1,tondeuse.getOrd());
		assertEquals('S',tondeuse.getOrientation());
	}
	@Test
	public void avancerTestWest() {
		Tondeuse tondeuse=new Tondeuse(1,2,'W');
		Pelouse pelouse=new Pelouse(4,5);
		Actions actions=new Actions();
		actions.avancer(tondeuse, pelouse);
		assertEquals(0,tondeuse.getAbs());
		assertEquals(2,tondeuse.getOrd());
		assertEquals('W',tondeuse.getOrientation());
	}
	@Test
	public void actionsTondeuseTest() throws Exception {
		Tondeuse tondeuse=new Tondeuse(1,2,'N');
		Pelouse pelouse=new Pelouse(6,6);
		Actions actions=new Actions();
		actions.actionsTondeuse(tondeuse, pelouse,"GAGAGAGAA");
		assertEquals(1,tondeuse.getAbs());
		assertEquals(3,tondeuse.getOrd());
		assertEquals('N',tondeuse.getOrientation());
	}
	@Test
	public void actionsTondeuseNonReconnueTest() throws Exception {
		Tondeuse tondeuse=new Tondeuse(1,2,'N');
		Pelouse pelouse=new Pelouse(6,6);
		Actions actions=new Actions();
		try {
		actions.actionsTondeuse(tondeuse, pelouse,"DGAT");
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

}
