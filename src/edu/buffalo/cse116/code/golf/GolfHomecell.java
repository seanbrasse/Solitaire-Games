package edu.buffalo.cse116.code.golf;

import java.util.Stack;

import edu.buffalo.cse116.code.Card;

/**
 * Class to represent a homecell pile in a
 * game of golf. Representing the class pile
 * as a stack of type card.
 * 
 * @author Willshady
 * 
 */
public class GolfHomecell 
{
	
	/**
	 * Creating a Stack to keep track of pile and
	 * prioritize access to index 0 Card and permit
	 * pop push access.
	 */
	private GolfStock stockPile;
	private Stack<Card> homecellPile;
	
	public GolfHomecell(GolfStock stockPile)
	{		
		this.homecellPile = new Stack<Card>();
		this.stockPile = stockPile;
	}
		
	/**
	 * Method to add a card to the homecell pile.
	 * If @return true, push to stack, else @return
	 * false.
	 * 
	 * @param card from Tableau pile
	 */
	public boolean addCard(Card card, boolean is) 
	{	
		/**
		 * An empty stock pile permits any card to be added
		 */
		if(stockPile.size() == 0)
		{
			homecellPile.push(card);
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
}
