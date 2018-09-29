package edu.buffalo.cse116.tests.littleSpider;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

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
	 * Tableau piles in Little Spider initially hold 6 cards
	 */
	@Test
	public void testConstructor()
	{
		Deck deck = new Deck();
		LittleSpiderTableau test = new LittleSpiderTableau(deck);
		
		assertEquals(6, test.getPileSize());
	}
	
	/**
	 * Little Spider tableau pile correctly determines if adding a
	 * specific card is legal or illegal [4 points]
	 */
	@Test
	public void testLittleSpiderAddCardLogic()
	{
		
	}
	
	/**
	 * Little Spider tableau pile correctly returns if removing top card is legal or illegal
	 * (e.g., if the tableau pile is NOT empty)
	 */
	@Test
	public void testLittleSpiderRemoveCardLogic()
	{
		
	}
	
	/**
	 * Adding card to Little Spider's tableau pile increases its number of cards
	 * and results in that card being the tableau pile's new top card
	 */
	@Test
	public void testLittleSpiderAddCard()
	{
		
	}
	
	/**
	 * Removing card from Little Spider's tableau pile decreases its number of cards
	 * and results in following card being the new top card
	 */
	@Test
	public void testLittleSpiderRemoveCard()
	{
		
	}
}
