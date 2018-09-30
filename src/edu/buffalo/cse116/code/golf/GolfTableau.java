package edu.buffalo.cse116.code.golf;

import edu.buffalo.cse116.code.Card;
import edu.buffalo.cse116.code.Deck;
import edu.buffalo.cse116.code.Tableau;

/**
 * Class represents a tableau pile in  golf,
 * with logic for pile functionality.
 * 
 * @author William F. Nicholson
 *
 */

public class GolfTableau extends Tableau
{
	/**
	 * 
	 * @param deck
	 */
	public GolfTableau(Deck deck)
	{
		super(deck);
	}
	
	public Card removeCard()
	{
		this.pileSize --;
		return this.pile.pop();
	}
	
	public void addCard(Card card)
	{
		this.pile.push(card);
		this.pileSize++;
	}
	
	public boolean isAddingCardLegal(Card card)
	{
		//Adding cards to tablaeu piles in golf is always illegal.
		return false;
	}
	
	public boolean isRemovingCardLegal()
	{
		//as long as the pile is not empty, a card may be removed from the pile.
		if(this.pile.size() <= 0)
		{
			return false;
		}
		
		return true;
	}

	@Override
	public int setPileSize() 
	{
		//Pile in golf is 5.
		return 5;
	}
}
