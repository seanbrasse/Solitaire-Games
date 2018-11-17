package edu.buffalo.cse116.tests.fortyTheives;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.buffalo.cse116.code.Deck;

public class FortyTheivesGameTest {

	@Test
	public void test() {
		Deck deck = new Deck();
		
		deck.doubledDeck();
		
		assertEquals(104, deck.getDeck().size());
	}
	
	/**
	 * Checks that the initial size of each tableau is 3.
	 */
	@Test
	public void testInitialTableauPileSize() {
		
	}

}
