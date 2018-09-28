package edu.buffalo.cse116.tests;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import edu.buffalo.cse116.code.Card;
import edu.buffalo.cse116.code.Deck;
import edu.buffalo.cse116.code.HomecellLS;
import edu.buffalo.cse116.code.TableauLS;

public class HomecellLSTest {

	//	private Card cards = new Card(0, 0);

	@Test
	//borrowed from WillShady
	public void testConstructor() { 
		Deck testDeck = new Deck();

		assertNotNull(testDeck);
		assertNotNull(testDeck.getDeck());


	}

	/*Tests if each pile has the correct initial card
	 * 
	 * Each pile starts off with one card ((Diamonds, Ace), (Hearts, Ace), (Clubs, King), (Spades, King))
	 */
	@Test
	public void p1Initial() {
		ArrayList<Card> a = new ArrayList<Card>();
		ArrayList<Card> b = new ArrayList<Card>();
		ArrayList<Card> c = new ArrayList<Card>(); 
		ArrayList<Card> d = new ArrayList<Card>();
		HomecellLS hc = new HomecellLS(a, b, c, d);
		assertEquals(0, hc.getp1().getRank());
		assertEquals(1, hc.getp1().getSuit());
	}


	@Test
	public void p2Initial() {
		ArrayList<Card> a = new ArrayList<Card>();
		ArrayList<Card> b = new ArrayList<Card>();
		ArrayList<Card> c = new ArrayList<Card>();
		ArrayList<Card> d = new ArrayList<Card>();
		HomecellLS hc = new HomecellLS(a, b, c, d);
		assertEquals(0, hc.getp2().getRank());
		assertEquals(2, hc.getp2().getSuit());
	}

	@Test 
	public void p3Initial() { 
		ArrayList<Card> a = new ArrayList<Card>();
		ArrayList<Card> b = new ArrayList<Card>();
		ArrayList<Card> c = new ArrayList<Card>();
		ArrayList<Card> d = new ArrayList<Card>();
		HomecellLS hc = new HomecellLS(a, b, c, d);
		assertEquals(12, hc.getp3().getRank());
		assertEquals(0, hc.getp3().getSuit());
	}

	@Test
	public void p4Initial() {
		ArrayList<Card> a = new ArrayList<Card>();
		ArrayList<Card> b = new ArrayList<Card>();
		ArrayList<Card> c = new ArrayList<Card>();
		ArrayList<Card> d = new ArrayList<Card>();
		HomecellLS hc = new HomecellLS(a, b, c, d);
		assertEquals(12, hc.getp4().getRank());
		assertEquals(3, hc.getp4().getSuit());
	}


	/*Tests if top card is gotten
	 * 
	 * Tests for what the top card is (if top card of a pile 
	 * has been added and is the new top card) 
	 * 
	 * Card is given to tableau to verify if a tableau card 
	 * can be added to the corresponding homecell pile
	 * 
	 */

	@Test
	public void getTC1() {
		ArrayList<Card> a = new ArrayList<Card>();
		ArrayList<Card> b = new ArrayList<Card>();
		ArrayList<Card> c = new ArrayList<Card>();
		ArrayList<Card> d = new ArrayList<Card>();
		HomecellLS hc = new HomecellLS(a, b, c, d);
		Deck deck = new Deck();
		hc.pile1.add(deck.getDeck().get(12));
		assertNotNull(hc.getTC(1));
		assertEquals(12, hc.getTC(1).getRank());
	}

	@Test
	public void getTC2() {
		ArrayList<Card> a = new ArrayList<Card>();
		ArrayList<Card> b = new ArrayList<Card>();
		ArrayList<Card> c = new ArrayList<Card>();
		ArrayList<Card> d = new ArrayList<Card>();
		HomecellLS hc = new HomecellLS(a, b, c, d);
		Deck deck = new Deck();
		hc.pile2.add(deck.getDeck().get(12));
		assertNotNull(hc.getTC(2));
		assertEquals(12, hc.getTC(2).getRank());
	}

	@Test
	public void getTC3() {
		ArrayList<Card> a = new ArrayList<Card>();
		ArrayList<Card> b = new ArrayList<Card>();
		ArrayList<Card> c = new ArrayList<Card>();
		ArrayList<Card> d = new ArrayList<Card>();
		HomecellLS hc = new HomecellLS(a, b, c, d);
		Deck deck = new Deck();
		hc.pile3.add(deck.getDeck().get(12));
		assertNotNull(hc.getTC(3));
		assertEquals(12, hc.getTC(3).getRank());
	}

	@Test
	public void getTC4() {
		ArrayList<Card> a = new ArrayList<Card>();
		ArrayList<Card> b = new ArrayList<Card>();
		ArrayList<Card> c = new ArrayList<Card>();
		ArrayList<Card> d = new ArrayList<Card>();
		HomecellLS hc = new HomecellLS(a, b, c, d);
		Deck deck = new Deck();
		hc.pile4.add(deck.getDeck().get(12));
		assertNotNull(hc.getTC(4));
		assertEquals(12, hc.getTC(4).getRank());
	}


	/*Tests if top card is being gotten
	 * 
	 * Top card is being sent back to tableaus to see if it is legal 
	 * to be put into the tableaus
	 */
	@Test
	public void getTCR1() {
		ArrayList<Card> a = new ArrayList<Card>();
		ArrayList<Card> b = new ArrayList<Card>();
		ArrayList<Card> c = new ArrayList<Card>();
		ArrayList<Card> d = new ArrayList<Card>();
		HomecellLS hc = new HomecellLS(a, b, c, d);
		Deck deck = new Deck();
		hc.pile1.add(deck.getDeck().get(12));
		//assertNotNull(hc.getTCR(1));
		assertEquals(12, hc.getTCR(1).getRank());
		assertEquals(0, hc.getTCR(1).getSuit());
	}

	@Test
	public void getTCR2() {
		ArrayList<Card> a = new ArrayList<Card>();
		ArrayList<Card> b = new ArrayList<Card>();
		ArrayList<Card> c = new ArrayList<Card>();
		ArrayList<Card> d = new ArrayList<Card>();
		HomecellLS hc = new HomecellLS(a, b, c, d);
		Deck deck = new Deck();
		hc.pile2.add(deck.getDeck().get(12));
		//assertNotNull(hc.getTCR(1));
		assertEquals(12, hc.getTCR(2).getRank());
		assertEquals(0, hc.getTCR(2).getSuit());

	}
	@Test
	public void getTCR3() {
		ArrayList<Card> a = new ArrayList<Card>();
		ArrayList<Card> b = new ArrayList<Card>();
		ArrayList<Card> c = new ArrayList<Card>();
		ArrayList<Card> d = new ArrayList<Card>();
		HomecellLS hc = new HomecellLS(a, b, c, d);
		Deck deck = new Deck();
		hc.pile3.add(deck.getDeck().get(12));
		//assertNotNull(hc.getTCR(1));
		assertEquals(12, hc.getTCR(3).getRank());
		assertEquals(0, hc.getTCR(3).getSuit());
	}
	@Test
	public void getTCR4() {
		ArrayList<Card> a = new ArrayList<Card>();
		ArrayList<Card> b = new ArrayList<Card>();
		ArrayList<Card> c = new ArrayList<Card>();
		ArrayList<Card> d = new ArrayList<Card>();
		HomecellLS hc = new HomecellLS(a, b, c, d);
		Deck deck = new Deck();
		hc.pile4.add(deck.getDeck().get(12));
		//assertNotNull(hc.getTCR(1));
		assertEquals(12, hc.getTCR(4).getRank());
		assertEquals(0, hc.getTCR(4).getSuit());
	}

	@Test
	public void removeCard() {
		Deck deck = new Deck();
		ArrayList<Card> a = new ArrayList<Card>();
		ArrayList<Card> b = new ArrayList<Card>();
		ArrayList<Card> c = new ArrayList<Card>();
		ArrayList<Card> d = new ArrayList<Card>();
		HomecellLS hc = new HomecellLS(a, b, c, d);
		TableauLS TLS = new TableauLS(deck);
		TLS.instantiatePiles();
		System.out.println(a + "initial");
		System.out.println(TLS.getTableauPiles()[1] + "Before");
		System.out.println(TLS.getTableauPiles()[1].get(0).getSuit());
		System.out.println(TLS.getTableauPiles()[1].get(0).getRank());
		a.add(deck.getDeck().get(43));
		a.add(deck.getDeck().get(2));
		a.add(deck.getDeck().get(44));
		System.out.println(a.size() + "before");
		System.out.println(a+ "before");
		TLS.addHomecellCardToPile(hc.getTC(1), 1);
		System.out.println(TLS.getTableauPiles()[1] + "After");
		System.out.println(a.size() + "after");
		System.out.println(a + "after");

		assertEquals(3, a.size());
		
		
		
	}

	/*Check findTC to see if TableauLS has a card from the homecell pile
	 */

//	@Test
//	public void foundTC() {
//		ArrayList<Card> a = new ArrayList<Card>();
//		ArrayList<Card> b = new ArrayList<Card>();
//		ArrayList<Card> c = new ArrayList<Card>();
//		ArrayList<Card> d = new ArrayList<Card>();
//		Deck deck = new Deck();
//		
//		b.add(deck.getDeck().get(1));
//		b.add(deck.getDeck().get(0));
//		b.add(deck.getDeck().get(2)); 
//		b.add(deck.getDeck().get(3));
//		
//System.out.println(b);
//		HomecellLS hc = new HomecellLS(a, b, c, d);
//		
//		TableauLS TLS = new TableauLS(deck);
//		System.out.println(b.get(3));
////		System.out.println(b.get(0));
//		//System.out.print(TLS.getTableauPiles()[2]);
//		TLS.instantiatePiles();
////		System.out.println(TLS.getTableauPiles()[2]);
////		System.out.println(TLS.getTableauPiles()[2].get(0));
//		TLS.addCardToPile(deck.getDeck().get(3), 2);;
//		hc.setTableau(TLS);
//		System.out.println(TLS.getTableauPiles()[2].get(TLS.getTableauPiles()[2].size()-1));
//		System.out.println(hc.getTableau().getTableauPiles()[2].get(TLS.getTableauPiles()[2].size()-1));
//	System.out.println(hc.findTC());
//		assertTrue(hc.findTC());
//	}
// 
	/*
	 * Checks if top card of a pile has been removed and a new top card is in place (size adjusted). (tests removeTC and getTC))
	 *  
	 */
	
//	@Test
//	public void removeChanges() {
//		ArrayList<Card> a = new ArrayList<Card>();
//		ArrayList<Card> b = new ArrayList<Card>();
//		ArrayList<Card> c = new ArrayList<Card>();
//		ArrayList<Card> d = new ArrayList<Card>();
//		HomecellLS hc = new HomecellLS(a, b, c, d);
//		Deck deck = new Deck();
//		TableauLS TLS = new TableauLS(deck);
//		b.add(deck.getDeck().get(1));
//		b.add(deck.getDeck().get(2));
//		b.add(deck.getDeck().get(3));
//		TLS.getTableauPiles()[2].add(deck.getDeck().get(1));
//		TLS.getTableauPiles()[2].add(deck.getDeck().get(2));
//		TLS.getTableauPiles()[2].add(deck.getDeck().get(3));
//		hc.removeTC(2); 
//		
//		assertEquals(2, hc.pileSize(2));
//	}

}
