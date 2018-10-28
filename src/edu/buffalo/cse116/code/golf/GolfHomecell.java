package edu.buffalo.cse116.code.golf;

import java.util.Stack;

import edu.buffalo.cse116.code.Card;
import edu.buffalo.cse116.code.Homecell;

/**
 * Class to represent a homecell pile in a
 * game of golf. Representing the class pile
 * as a stack of type card.
 * 
 * @author William F. Nicholson
 * @author Wilmer Liang Feng
 */

public class GolfHomecell extends Homecell
{	
	/**
	 * this method push a card on top of the homecell pile, if adding the card is legal.
	 * 
	 * @param card
	 */
	@Override
	public void addCard(Card card) 
	{	
		if(isAddingCardLegal(card))
		{
			homecellPile.push(card);
		}
	}

	public void addCardFromStock(Card card)
	{
		homecellPile.push(card);
	}
	
	/**
	 * this method removes a card from the homecell pile only if removing card is legal, which is always false
	 */
	@Override
	public Card removeCard() 
	{
		if(isRemovingCardLegal())
		{
			return homecellPile.pop();
		}
		
		return null;
	}

	/**
	 * Check if top card of stack can build or wrap with parameter card
	 * 
	 * If homecell pile is empty, any card can be added
	 * @return true if the card can be legally added
	 * 
	 */
	
	@Override
	public boolean isAddingCardLegal(Card card) 
	{
		if(this.homecellPile.size() == 0){
			return true;
		}
		else if(homecellPile.lastElement().canBuild(card) || homecellPile.lastElement().canWrap(card)){
				return true;
			}
			
			return false;
	}

	/**
	 * Checks if it is legal to remove a card from the homecell, it should always be false
	 * @return false when it tries to remove cards from homecell pile in golf, use for testing
	 */
	@Override
	public boolean isRemovingCardLegal() 
	{
		//Cannot remove cards from homecell pile in golf.
		return false;
	}
	
	/**
	 * Returns the homecell pile, for testing
	 * @return a homecell pile
	 */
	public Stack<Card> getGolfHomecellPile(){
		return this.homecellPile;
	}
}