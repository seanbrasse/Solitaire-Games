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

public class GolfStock 
{	
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
	
	public boolean addCard(Card card)
	{
		if(isAddCardLegal(card))
		{
			//add card to stock.
			return true;
		}
		
		return false;
	}
	
	public boolean removeTopCard(Card card)
	{
		if(isRemoveCardLegal(card))
		{
			//remove card from stock.
			return true;
		}
		
		return false;
	}
	
	public boolean isRemoveCardLegal(Card card)
	{
		//logic to remove card.
		return true;
	}
	
	public boolean isAddCardLegal(Card card)
	{
		//logic to add card.
		return true;
	}

}
