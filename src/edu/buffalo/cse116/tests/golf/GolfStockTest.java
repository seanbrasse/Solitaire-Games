package edu.buffalo.cse116.tests.golf;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.buffalo.cse116.code.Card;
import edu.buffalo.cse116.code.Deck;
import edu.buffalo.cse116.code.golf.GolfStock;

public class GolfStockTest {

	private Card card;
	private Deck deck;
	
	/*
	 * testing to see if the deck has 17 cards initially
	 */
	@Test
	public void testInitialDeckSize() {
		GolfStock deckTest = new GolfStock(deck);
		assertEquals(17, deckTest.size(), .001);
	}
	
	/*
	 * this should always return fasle
	 */
	@Test
	public void testIsAddingCardLegal() {
		GolfStock add = new GolfStock(deck);
		assertFalse(add.isAddCardLegal(card));
	}
	
	/*
	 * if not empty should check if removing card is legal
	 */
	@Test
	public void testRemoveCardIsLegal() {
		GolfStock removeTest = new GolfStock(deck);
		if(removeTest.size() > 0) {
			assertTrue(removeTest.isRemoveCardLegal(card));
		}
	}
	
	/*
	 * does the number of cards get decreased after removing a card, and does the next card become the topCard
	 */
	//not to sure how to write this one 
	
	
	
}
