package edu.buffalo.cse116.code.golf;

import edu.buffalo.cse116.code.Card;
import edu.buffalo.cse116.code.Homecell;

/**
 * Class to represent a homecell pile in a
 * game of golf. Representing the class pile
 * as a stack of type card.
 * 
 * @author William F. Nicholson
 * 
 */
public class GolfHomecell extends Homecell
{
	
	/**
	 * Creating a Stack to keep track of pile and
	 * prioritize access to index 0 Card and permit
	 * pop push access.
	 */
	private GolfStock stockPile;
	
	public GolfHomecell(GolfStock stockPile)
	{		
		super();
		this.stockPile = stockPile;
	}
	
	@Override
	public void addCard(Card card) 
	{	
		if(isAddingCardLegal(card))
		{
			homecellPile.push(card);
		}
	}

	@Override
	public Card removeCard() 
	{
		if(isRemovingCardLegal())
		{
			return homecellPile.pop();
		}
		
		return null;
	}

	@Override
	public boolean isAddingCardLegal(Card card) 
	{
		if(stockPile.size() == 0)
		{
			return true;
		}
		
		/**
		 * Check if top card of stack can build or wrap with parameter card
		 */
		else
		{
			if(homecellPile.firstElement().canBuild(card) || homecellPile.firstElement().canWrap(card))
			{
				homecellPile.push(card);
				return true;
			}
			
			return false;
		}
	}

	@Override
	public boolean isRemovingCardLegal() 
	{
		//Cannot remove cards from homecell pile in golf.
		return false;
	}
}
