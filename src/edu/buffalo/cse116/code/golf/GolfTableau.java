package edu.buffalo.cse116.code.golf;

import java.util.Stack;

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
		this.pile = new Stack<Card>();
		this.topCard = null;
		
		for(int i=0; i<deck.getDeck().size(); i++)
		{
			if(pile.size() < pileSize)
			{
				pile.push(deck.getDeck().get(i));
				deck.getDeck().remove(i);
			}
			else
			{
				break;
			}
		}
		
		this.topCard = pile.peek();
	}
	
	public Card removeCard()
	{
		Card removedCard = this.pile.remove(0);
		this.topCard = this.pile.get(0);
		this.pileSize --;
		
		return removedCard;
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
