package edu.buffalo.cse116.tests.fortyTheives;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import edu.buffalo.cse116.code.Card;
import edu.buffalo.cse116.code.Deck;
import edu.buffalo.cse116.code.fortyThieves.FortyThievesGame;
import edu.buffalo.cse116.code.fortyThieves.FortyThievesStock;
import edu.buffalo.cse116.code.fortyThieves.FortyThievesWaste;

public class FortyThievesStockTest {
	
	/**
	 * Testing initial size of the stock pile
	 */
	@Test
	public void initialStockSizeTest() {
		FortyThievesGame gg = new FortyThievesGame();
		assertEquals(57, gg.getGameStockPile().getStock().size());
	}
	
	/**
	 * Tests if adding a card is legal (Always illegal)
	 */
	@Test
	public void addCardTest() {
		Deck deck = new Deck();
		FortyThievesWaste wastePile = new FortyThievesWaste();
		FortyThievesStock gg = new FortyThievesStock(deck, wastePile);
		assertFalse(gg.isAddingCardLegal(new Card(0,3)));
		
	}
	
	/**
	 * Tests if removing from stock pile is legal, when stock pile is empty it's illegal
	 */
	@Test
	public void isRemoveCardLegalTest() {
		Deck deck = new Deck();
		FortyThievesWaste wastePile = new FortyThievesWaste();
		FortyThievesStock gg = new FortyThievesStock(deck, wastePile);
		
		assertEquals(0,gg.getStock().size());
		assertFalse(gg.isRemovingCardLegal()); //Tests if removing a card is legal when stock is empty
		
		gg.getStock().push(new Card(0,1));
		gg.getStock().push(new Card(0,2));
		assertTrue(gg.isRemovingCardLegal()); //Tests if removing a card is legal
		gg.removeCard();
		assertTrue(gg.isRemovingCardLegal());  //Tests if removing a card is legal
		
		gg.removeCard();
		assertFalse(gg.isRemovingCardLegal()); //Tests if removing a card is legal when stock is empty
	}
	
	/**
	 * Tests if removing from stock decreases size, updates top card.
	 * Also checks if removing from stock adds to the waste pile and updates waste size and top card 
	 */
	@Test
	public void removeTest() {
		Deck deck = new Deck();
		FortyThievesWaste w = new FortyThievesWaste();
		FortyThievesStock gg = new FortyThievesStock(deck, w);

		
		assertEquals(0, gg.getStock().size());
		assertEquals(0, w.getWastePile().size());
		
		gg.getStock().push(new Card(2,1));
		gg.getStock().push(new Card(3,2));
		gg.getStock().push(new Card(0,3));
		gg.getStock().push(new Card(1,4));
		assertEquals(4, gg.getStock().size());

		
		gg.removeCard();
		assertEquals(3, gg.getStock().size()); //Checks updated stock size
		assertEquals(0, gg.getStock().peek().getSuit()); //Checks updated stock top card
		assertEquals(3, gg.getStock().peek().getRank()); //Checks updated stock top card
		
		assertEquals(1, w.getWastePile().size()); //Checks that removing from stock updates (adds) to waste pile size
		assertEquals(1, w.getWastePile().peek().getSuit()); //Checks updated waste pile top card
		assertEquals(4, w.getWastePile().peek().getRank()); //Checks updated waste pile top card
		
		gg.removeCard();
		assertEquals(2, gg.getStock().size()); //Checks updated stock size
		assertEquals(3, gg.getStock().peek().getSuit()); //Checks updated stock top card
		assertEquals(2, gg.getStock().peek().getRank()); //Checks updated stock top card
		
		assertEquals(2, w.getWastePile().size()); //Checks that removing from stock updates (adds) to waste pile size
		assertEquals(0, w.getWastePile().peek().getSuit()); //Checks updated waste pile top card
		assertEquals(3, w.getWastePile().peek().getRank()); //Checks updated waste pile top card
		
	}
}
