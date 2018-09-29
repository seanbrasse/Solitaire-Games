package edu.buffalo.cse116.tests.golf;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.buffalo.cse116.code.Card;
import edu.buffalo.cse116.code.Deck;
import edu.buffalo.cse116.code.golf.GolfTableau;

/**
 * 
 * @author Willshady
 *
 */
public class GolfTableauTest 
{
	/**
	 * Tableau piles in Golf initially hold 5 cards
	 */
	@Test
	public void testConstructor()
	{
		Deck deckForGolf = new Deck();
		GolfTableau testPileInGolfGame = new GolfTableau(deckForGolf);
		
		assertEquals(5, testPileInGolfGame.getPileSize());
	}
	
	/**
	 * Golf tableau pile correctly determines if adding a specific card is legal or illegal
	 * (e.g., the method should always return false)
	 */
	@Test
	public void testGolfAddCardLogic()
	{
		Deck deckForGolf = new Deck();
		GolfTableau testPileInGolfGame = new GolfTableau(deckForGolf);
		
		assertFalse(testPileInGolfGame.isAddingCardLegal(null));
		assertFalse(testPileInGolfGame.isAddingCardLegal(new Card(0,0)));
	}
	
	/**
	 * Golf tableau pile correctly returns if removing top card is legal or illegal
	 * (e.g., if the tableau pile is NOT empty)
	 */
	@Test
	public void testGolfRemoveCardLogic()
	{
		Deck deckForGolf = new Deck();
		GolfTableau testPileInGolfGame = new GolfTableau(deckForGolf);
		
		assertTrue(testPileInGolfGame.isRemovingCardLegal());
		testPileInGolfGame.getPile().clear();
		assertFalse(testPileInGolfGame.isRemovingCardLegal());
	}
	
	/**
	 * Removing card from Golf tableau pile decreases its number of cards
	 * and results in following card being the new top card
	 */
	@Test
	public void testGolfRemoveCard()
	{
		Deck deckForGolf = new Deck();
		GolfTableau testPileInGolfGame = new GolfTableau(deckForGolf);
		
		testPileInGolfGame.getPileSize();
		testPileInGolfGame.getTopCard();
		testPileInGolfGame.removeCard();
	}
}
