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
 * 
 */
public class GolfHomecell extends Homecell
{
	
	/**
	 * Creating a Stack to keep track of pile and
	 * prioritize access to index 0 Card and permit
	 * pop push access.
	 */
	
	//Don't think we need this because we using the homecellpile
	
	//private GolfStock stockPile;
	
	/*public GolfHomecell(GolfStock stockPile){		
		super();
		//this.stockPile = stockPile;
	}*/
	
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

	/**
	 * Check if top card of stack can build or wrap with parameter card
	 * 
	 * If homecell pile is empty, any card can be added
	 */
	
	@Override
	public boolean isAddingCardLegal(Card card) 
	{
		if(this.homecellPile.size() == 0){
			return true;
		}
		//Instead of using the firstElement(), I used the lastElement() because the top card is the last element
		else if(homecellPile.lastElement().canBuild(card) || homecellPile.lastElement().canWrap(card)){
//				homecellPile.push(card);
				return true;
			}
			
			return false;
	}

	@Override
	public boolean isRemovingCardLegal() 
	{
		//Cannot remove cards from homecell pile in golf.
		return false;
	}
	
	/**
	 * Returns the homecellpile, for testing
	 */
	public Stack<Card> getGolfHomecellPile(){
		return this.homecellPile;
	}
}