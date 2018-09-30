package edu.buffalo.cse116.tests.golf;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import edu.buffalo.cse116.code.Card;
import edu.buffalo.cse116.code.Deck;
import edu.buffalo.cse116.code.golf.GolfStock;
import edu.buffalo.cse116.code.golf.GolfTableau;

public class GolfStockTest 
{
	/*
	 * testing to see if the deck has 17 cards initially
	 */
	@Test
	public void testInitialDeckSize() 
	{
		Deck testDeck = new Deck();
		ArrayList<GolfTableau> testTableauPiles = new ArrayList<GolfTableau>();
		
		for(int itterator=0; itterator<7; itterator++)
		{
			GolfTableau newTableauPile = new GolfTableau(testDeck);
			testTableauPiles.add(newTableauPile);
		}
		
		GolfStock deckTest = new GolfStock(testDeck);
		assertEquals(17, deckTest.size(), .001);
	}
	
	/*
	 * this should always return fasle
	 */
	@Test
	public void testIsAddingCardLegal() 
	{
		Deck testDeck = new Deck();
		Card testCard = new Card(0,0);
		ArrayList<GolfTableau> testTableauPiles = new ArrayList<GolfTableau>();
		
		for(int itterator=0; itterator<7; itterator++)
		{
			GolfTableau newTableauPile = new GolfTableau(testDeck);
			testTableauPiles.add(newTableauPile);
		}
		
		GolfStock testStock = new GolfStock(testDeck);
		
		assertFalse(testStock.isAddCardLegal(testCard));
	}
	
	/*
	 * if not empty should check if removing card is legal
	 */
	@Test
	public void testRemoveCardIsLegal() 
	{
		Deck testDeck = new Deck();
		GolfStock removeTest = new GolfStock(testDeck);
		if(removeTest.size() > 0) 
		{
			assertTrue(removeTest.isRemoveCardLegal());
		}
	}
	
	/*
	 * does the number of cards get decreased after removing a card, and does the next card become the topCard
	 */
	@Test
	public void testRemoveCard()
	{
		Deck testDeck = new Deck();
		ArrayList<GolfTableau> testTableauPiles = new ArrayList<GolfTableau>();
		
		for(int itterator=0; itterator<7; itterator++)
		{
			GolfTableau newTableauPile = new GolfTableau(testDeck);
			testTableauPiles.add(newTableauPile);
		}
		
		GolfStock deckTest = new GolfStock(testDeck);
		deckTest.removeTopCard(); 
		
		assertEquals(16, deckTest.size());
	}
}
