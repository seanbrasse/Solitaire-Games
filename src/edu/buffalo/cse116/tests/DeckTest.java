package edu.buffalo.cse116.tests;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

import edu.buffalo.cse116.code.Card;
import edu.buffalo.cse116.code.Deck;

/**
 * This tester class will ensure there
 * are 52 unique cards in a deck 
 * 
 * @author Willshady
 *
 */
public class DeckTest 
{
	/**
	 * Method will test if the Deck class
	 * constructor creates an ArrayList
	 */
	@Test
	public void testDeckConstructor()
	{
		Deck testDeck = new Deck();
		
		assertNotNull(testDeck);
		assertNotNull(testDeck.getDeck());
	}
	
	/**
	 * 
	 */
	@Test
	public void testDeckHasUniqueCards()
	{
		Deck testDeck = new Deck();
		HashSet<String> uniqueCardValues = new HashSet<String>();
		
		for(Card card : testDeck.getDeck())
		{
			int suit = card.getSuit();
			int rank = card.getRank();
			
			String cardValues = suit + ":" + rank;
			
			uniqueCardValues.add(cardValues);
		}
		
		if(uniqueCardValues.size() != 52)
		{
			fail();
		}
		
	}
}
