package edu.buffalo.cse116.code.golf;

import edu.buffalo.cse116.code.Card;
import edu.buffalo.cse116.code.Deck;
import edu.buffalo.cse116.code.Tableau;

/**
 * Class represents a tableau pile in  golf,
 * with logic for pile functionality.
 * 
 * @author William F. Nicholson
 */

public class GolfTableau extends Tableau
{
	/**
	 * Create instance of tableau pile with
	 * rules for golf.
	 * @param deck
	 */
	public GolfTableau(Deck deck)
	{
		super(deck);
	}
	
	/**
	 * this method removes a card from the homecell pile only if removing card is legal, which is always false
	 */
	public Card removeCard()
	{
		this.pileSize --;
		return this.pile.pop();
	}
	
	/**
	 * this method push a card on top of the homecell pile, if adding the card is legal.
	 * 
	 * @param card
	 */
	public void addCard(Card card)
	{
		this.pile.push(card);
		this.pileSize++;
	}
	
	/**
	 * this method check if adding card into the tablaeu is legal, but it's always false.
	 * 
	 * @param card
	 */
	public boolean isAddingCardLegal(Card card)
	{
		//Adding cards to tablaeu piles in golf is always illegal.
		return false;
	}
	
	/**
	 * this method check if removing card from tableau is legal and when the pile size is equal and less it will
	 * return false
	 */
	public boolean isRemovingCardLegal()
	{
		//as long as the pile is not empty, a card may be removed from the pile.
		if(this.pile.size() <= 0)
		{
			return false;
		}
		
		return true;
	}
	
	/**
	 * setting the tableau pile size to 5
	 * @return the pile size
	 */
	@Override
	public int setPileSize() 
	{
		//Pile in golf is 5.
		return 5;
	}
}
