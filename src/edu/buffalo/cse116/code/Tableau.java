package edu.buffalo.cse116.code;

import java.util.ArrayList;

/**
 * This class represents a tableau pile in either
 * solitare game of golf or little spider, with logic
 * for pile functionality.
 * 
 * @author Willshady
 *
 */

public class Tableau 
{
	ArrayList<Card> pile;
	Card topCard;
	boolean isGolfFlag;
	boolean isLittleSpiderFlag;
	int pileSize;
	
	/**
	 * Constructor will check for game type, ask for a
	 * pre-built deck of cards. The constructor will
	 * draw from the deck of cards to form its pile
	 * and apply the grounds for logic.
	 *  
	 * @param Golf
	 * @param LittleSpider
	 */
	public Tableau(boolean isTheGameGolf, Deck deck)
	{
		this.pile = new ArrayList<Card>();
		this.topCard = null;
		
		if(isTheGameGolf == true)
		{
			pileSize = 5;
			this.isGolfFlag = true;
			this.isLittleSpiderFlag = false;
		}
		else
		{
			pileSize = 6;
			this.isLittleSpiderFlag = true;
			this.isGolfFlag = false;
		}
		
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
	
	public void removeCard()
	{
		if(this.isAddingCardLegal())
		{
			if(this.isGolfFlag)
			{
				this.pile.remove(0);
				this.topCard = this.pile.get(0);
			}
			
			if(this.isLittleSpiderFlag)
			{
				/**
				 * Andrew, your logic goes here!
				 */
			}
		}
	}
	
	public void addCard()
	{
		
	}
	
	public boolean isAddingCardLegal()
	{
		if(this.isGolfFlag)
		{
			return false;
		}
		
		if(this.isLittleSpiderFlag)
		{
			/**
			 * Andrew, your logic goes here!
			 */
		}
		
		return false;
	}
	
	public boolean isRemovingCardLegal()
	{
		if(this.pile.size() <= 0)
		{
			return false;
		}
		
		if(this.isGolfFlag)
		{
			return true;
		}
		
		if(this.isLittleSpiderFlag)
		{
			/**
			 * Andrew, your logic goes here!
			 */
		}
		
		return false;
	}
	
	public int getPileSize()
	{
		return this.pileSize;
	}
}
