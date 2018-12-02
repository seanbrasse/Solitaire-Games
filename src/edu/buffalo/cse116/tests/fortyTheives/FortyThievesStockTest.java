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
	@Test
	public void InitialTest() {
		FortyThievesGame gg = new FortyThievesGame();
		assertEquals(57, gg.getGameStockPile().getStock().size());
	}
	
	@Test
	public void AddingCard() {
		Deck deck = new Deck();
		FortyThievesWaste wastePile = new FortyThievesWaste();
		FortyThievesStock gg = new FortyThievesStock(deck, wastePile);
		assertFalse(gg.isAddingCardLegal(new Card(0,3)));
		
	}
	
	@Test
	public void CheckRemovingCard() {
		Deck deck = new Deck();
		FortyThievesWaste wastePile = new FortyThievesWaste();
		FortyThievesStock gg = new FortyThievesStock(deck, wastePile);
		gg.getStock().push(new Card(0,1));
		gg.getStock().push(new Card(0,2));
		assertTrue(gg.isRemovingCardLegal());
		gg.removeCard();
		assertTrue(gg.isRemovingCardLegal());
		gg.removeCard();
		assertFalse(gg.isRemovingCardLegal());
	}
	
	@Test
	public void NewTopCardTest() {
		Deck deck = new Deck();
		FortyThievesWaste wastePile = new FortyThievesWaste();
		FortyThievesStock gg = new FortyThievesStock(deck, wastePile);
		FortyThievesWaste w = new FortyThievesWaste();
		gg.getStock().push(new Card(0,1));
		gg.getStock().push(new Card(0,2));
		Card card = gg.getStock().pop();
		Card card1 = gg.getStock().peek();
		assertEquals(card1, gg.getStock().peek());
		
		w.addCardFromStock(card);
		assertEquals(card, w.getWastePile().peek());
		
	}
}
