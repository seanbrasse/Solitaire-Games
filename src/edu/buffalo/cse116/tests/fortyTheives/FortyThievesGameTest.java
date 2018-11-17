package edu.buffalo.cse116.tests.fortyTheives;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.buffalo.cse116.code.Deck;
import edu.buffalo.cse116.code.fortyThieves.FortyThievesGame;

public class FortyThievesGameTest {

	@Test
	public void test() {
		Deck deck = new Deck();
		
		deck.doubledDeck();
		
		assertEquals(104, deck.getDeck().size());
		
		assertEquals(0, deck.getDeck().get(0).getSuit()); //clubs aces are index 0,1
		assertEquals(0, deck.getDeck().get(1).getSuit());
		
		assertEquals(0, deck.getDeck().get(0).getRank());
		assertEquals(0, deck.getDeck().get(1).getRank());
		
		assertEquals(1, deck.getDeck().get(26).getSuit()); //diamond aces are indexes 26, 27
		assertEquals(1, deck.getDeck().get(27).getSuit());
		
		assertEquals(0, deck.getDeck().get(26).getRank());
		assertEquals(0, deck.getDeck().get(27).getRank());
		assertEquals(1, deck.getDeck().get(28).getRank()); //this one is a test that rank is moving up
		
		
		assertEquals(2, deck.getDeck().get(52).getSuit()); //hearts of aces are indexes 52, 53
		assertEquals(2, deck.getDeck().get(53).getSuit());
		
		assertEquals(0, deck.getDeck().get(52).getRank());
		assertEquals(0, deck.getDeck().get(53).getRank());
		
		
		assertEquals(3, deck.getDeck().get(78).getSuit()); //spades of aces are indexes 78,79
		assertEquals(3, deck.getDeck().get(79).getSuit());
		
		assertEquals(0, deck.getDeck().get(78).getRank());
		assertEquals(0, deck.getDeck().get(79).getRank());
		
		assertEquals(12, deck.getDeck().get(103).getRank());
	}
	
	/**
	 * Checks that the initial size of each tableau is 3.
	 */
	@Test
	public void testInitialTableauPileSize() {
		
	}
	
	
	@Test
	public void testdeck() {
		FortyThievesGame x = new FortyThievesGame();

		for(int i = 0; i < 8; i++) {
			assertEquals(1, x.getGameHomecellPiles().get(i).getHomecellPile().size());
		}
		
		for(int i = 0; i < 13; i++) {
			assertEquals(3, x.getGameTableauPiles().get(i).getPile().size());
		}
	}

}
