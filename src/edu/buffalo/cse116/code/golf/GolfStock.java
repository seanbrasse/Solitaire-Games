package edu.buffalo.cse116.code.golf;

import java.util.ArrayList;

import edu.buffalo.cse116.code.Card;
import edu.buffalo.cse116.code.Deck;

/**
 * Class represents a stock pile, the pile of remaining
 * cards from the deck, setup once the tableau
 * piles have been drawn.
 * 
 * @author William F. Nicholson
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
		
		int size = gameDeck.getDeck().size();
		for(int i = 0; i < size; i++){
			this.stockPile.add(gameDeck.getDeck().get(0));
			gameDeck.getDeck().remove(0);
		}
		
			
		
	}
	
	/**
	 * Return size of stock pile, the size of the
	 * ArrayList in which it resides.
	 */
	public int size()
	{
		return this.stockPile.size();
	}
	
	/**
	 * Removes the top card and returns it. Otherwise returns null.
	 * @return the card that was removed from the top.
	 */
	public Card removeTopCard()
	{
		if(isRemoveCardLegal())
		{
			//remove card from stock.
			return this.stockPile.remove(0);
		}
		
		return null;
	}
	
	/**
	 * Checks if you can remove a card from the Stock pile, if there's at least one card on the Stock pile.
	 * @return true if you can legally remove a card from the Stock.
	 */
	public boolean isRemoveCardLegal()
	{
		//logic to remove card.
		if(this.stockPile.size() > 0)
		{
			return true;
		}
		
		return false;
	}
	
	/**
	 * Checks to see if the card can be added to the Stock, it won't be able to.
	 * @param card we want to add to the Stock
	 * @return false because no cards can be added to the Stock.
	 */
	public boolean isAddCardLegal(Card card)
	{
		//Cards cannot be added to stock pile in golf.
		return false;
	}
	
	/**
	 * Returns the stockpile
	 */
	
	public ArrayList<Card> getStockPile(){
		return this.stockPile;
	}

}
