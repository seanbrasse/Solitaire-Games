package edu.buffalo.cse116.tests.littleSpider;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.buffalo.cse116.code.Card;
import edu.buffalo.cse116.code.Deck;
import edu.buffalo.cse116.code.littleSpider.LittleSpiderTableau;

/**
 * 
 * @author William
 * @author Andrew
 *
 */
public class LittleSpiderTableauTest 
{
	/**
	 * After setting up the homecell piles, each tableau piles should be dealt 6 cards.
	 */
	@Test
	public void testConstructor()
	{
		Deck deck = new Deck();
		LittleSpiderTableau test = new LittleSpiderTableau(deck);
		
		assertEquals(6, test.getPileSize());
	}
	
	/**
	 * A card can be added to a tableau pile when its rank is either one below or one above
	 * the tableau's top card. The cards' suits do not matter. When adding a card to a tableau pile,
	 * ranks can "wrap around".
	 */
	@Test
	public void testLittleSpiderAddCardLogic()
	{
		//Create a deck and use it to populate a tableau pile.
		Deck deckForLittleSpider = new Deck();
		LittleSpiderTableau testPile = new LittleSpiderTableau(deckForLittleSpider);
		
		//With the card at the top of the pile, create instances where rank
		//is above and bellow by varying degrees, and such that the rank differs.
		Card topCard = testPile.getPile().peek();
		
		for(int rank=0; rank<13; rank++)
		{
			for(int suit=0; suit<4; suit++)
			{
				Card testCard = new Card(suit, rank);
				
				//Can't have the cards building or wrapping, we need this to fail!
				if(topCard.canBuild(testCard) || topCard.canWrap(testCard))
				{
					break;
				}
				
				assertFalse(testPile.isAddingCardLegal(new Card(suit, rank)));
			}
			
		}
	}
	
	/**
	 * Only the card which is currently at the top of the tableau pile can be removed.
	 */
	@Test
	public void testLittleSpiderRemoveCardLogic()
	{
		Deck deckForLittleSpider = new Deck();
		LittleSpiderTableau testPileInLittleSpider = new LittleSpiderTableau(deckForLittleSpider);
		
		assertTrue(testPileInLittleSpider.isRemovingCardLegal());
		testPileInLittleSpider.getPile().clear();
		assertFalse(testPileInLittleSpider.isRemovingCardLegal());
	}
	
	/**
	 * Adding card to Little Spider's tableau pile increases its number of cards and results in that card being the tableau pile's new top card
	 */
	@Test
	public void testLittleSpiderAddCard()
	{
		Deck deckForLittleSpider = new Deck();
		LittleSpiderTableau testPileInLittleSpider = new LittleSpiderTableau(deckForLittleSpider);		
		//On pile creation, pile size should be of 6 elements
		assertEquals(6, testPileInLittleSpider.getPileSize());
		//Adding a new card (which here could be illegal), will increase the size by one.
		testPileInLittleSpider.addCard(new Card(0,0));		
		assertEquals(7, testPileInLittleSpider.getPileSize());
	}
	
	/**
	 * Once a card is removed, the card following it in the pile becomes the top card and can be removed.
	 */
	@Test
	public void testLittleSpiderRemoveCard()
	{
		Deck deckForLittleSpider = new Deck();
		LittleSpiderTableau testPileInLittleSpider = new LittleSpiderTableau(deckForLittleSpider);
		
		//On pile creation, pile size should be of 6 elements
		assertEquals(6, testPileInLittleSpider.getPileSize());
		//Adding a new card (which here could be illegal), will increase the size by one.
		testPileInLittleSpider.removeCard();
		assertEquals(5, testPileInLittleSpider.getPileSize());
	}
}
