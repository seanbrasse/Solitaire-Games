package edu.buffalo.cse116.code.golf;

import java.util.ArrayList;

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
	 */
	ArrayList<Card> pile;
	Card topCard;
	int pileSize;
	
	/**
	 * 
	 * @param deck
	 */
	public GolfTableau(Deck deck)
	{
		super(deck);
		this.pile = new ArrayList<Card>();
		this.topCard = null;
		
		/*********************************************
		 * code applicable for little spider tableau pile
		{
			pileSize = 6;
			this.isLittleSpiderFlag = true;
			this.isGolfFlag = false;
		} //Checks out for both so far (CFB) - Andrew
		**********************************************/
		for(int i=0; i<deck.getDeck().size(); i++)
		{
			if(pile.size() < pileSize)
			{
				pile.add(deck.getDeck().get(i));
				deck.getDeck().remove(i);
			}
			else
			{
				break;
			}
		}
		
		this.topCard = pile.get(0);
	}
	
	public Card removeCard()
	{
		if(this.isAddingCardLegal())
		{
			Card removedCard = this.pile.remove(0);
			this.topCard = this.pile.get(0);
			
			return removedCard;
		}
		
		return null;
	}
	
	public void addCard(Card card)
	{
		if(isRemovingCardLegal())
		{
			this.pile.add(card);
		}
	}
	
	public boolean isAddingCardLegal()
	{
		return false;
	}
	
	public boolean isRemovingCardLegal()
	{
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
