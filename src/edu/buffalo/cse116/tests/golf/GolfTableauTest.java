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
	 * TODO: Test cases are outdated. Seperate into two different classes seperated by package
	 * 		 and apply test cases where applicable.
	 */
	@Test
	public void testConstructor()
	{
		Deck deckForGolf = new Deck();
		GolfTableau testPileInGolfGame = new GolfTableau(deckForGolf);
		
		assertEquals(5, testPileInGolfGame.getPileSize());
	}
	
	@Test
	public void testGolfAddCardLogic()
	{
		/**
		 * One cannot add cards to piles in Golf, and as such this
		 * method when tested should always return false.
		 */
		Deck deckForGolf = new Deck();
		GolfTableau testPileInGolfGame = new GolfTableau(deckForGolf);
		
		assertFalse(testPileInGolfGame.isAddingCardLegal(null));
		assertFalse(testPileInGolfGame.isAddingCardLegal(new Card(0,0)));
	}
	
	@Test
	public void testGolfRemoveCardLogic()
	{
		/**
		 * One may remove a card in Golf from a Tableau pile if
		 * there are card to be removed. The method should return
		 * true in cases where the pile size is greater than 1, and
		 * false for all other inputs
		 */
		Deck deckForGolf = new Deck();
		GolfTableau testPileInGolfGame = new GolfTableau(deckForGolf);
		
		assertTrue(testPileInGolfGame.isRemovingCardLegal());
		testPileInGolfGame.getPile().clear();
		assertFalse(testPileInGolfGame.isRemovingCardLegal());
	}
	
	@Test
	public void testGoldRemoveCard()
	{
		/**
		 * 
		 */
		Deck deckForGolf = new Deck();
		GolfTableau testPileInGolfGame = new GolfTableau(deckForGolf);
		
		testPileInGolfGame.getPileSize();
		testPileInGolfGame.getTopCard();
		testPileInGolfGame.removeCard();
	}
}
