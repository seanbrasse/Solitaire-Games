package edu.buffalo.cse116.code.golf;

import java.util.ArrayList;

import edu.buffalo.cse116.code.Card;
import edu.buffalo.cse116.code.Deck;

/**
 * Class represents a stock pile, the pile of remaining
 * cards from the deck, setup once the tableau
 * piles have been drawn.
 * 
 * @author Willshady
 *
 */

public class GolfStock {
	
	ArrayList<Card> stockPile;
	
	/**
	 * Draw remaining cards from deck, add them to
	 * the stock pile.
	 */
	public GolfStock(Deck gameDeck)
	{
		this.stockPile = new ArrayList<Card>();
		
		for(Card card: gameDeck.getDeck())
		{
			this.stockPile.add(card);
		}
	}
	
	public int size()
	{
		/**
		 * Return size of stock pile, the size of the
		 * ArrayList in which it resides.
		 */
		return this.stockPile.size();
	}

}
