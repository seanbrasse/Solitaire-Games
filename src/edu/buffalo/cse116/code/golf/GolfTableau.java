package edu.buffalo.cse116.code.golf;

import java.util.ArrayList;

import edu.buffalo.cse116.code.Card;
import edu.buffalo.cse116.code.Deck;

/**
 * This class represents a tableau pile in either
 * solitare game of golf or little spider, with logic
 * for pile functionality.
 * 
 * @author Willshady
 *
 */

/*
 * NOTE for team: This Tableau class should be for Golf and I'll create a Tableau class for little spider. - Andrew.
 */

public class GolfTableau 
{
	/**
	 * An Arraylist for a tableau pile.
	 */
	ArrayList<Card> pile;
	
	/**
	 * The topcard on the pile.
	 */
	Card topCard;
	
	//Since there'll be a Tableau class for LS and Golf, guess we won't need the flags - Andrew.
	/**
	 * Flag to inform the class if the game is a golf
	 */
	boolean isGolfFlag;
	boolean isLittleSpiderFlag;
	
	
	
	/**
	 * The number of cards on each Tableau pile, 5 for Golf solitaire and 6 for Little Spider solitaire.
	 */
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
	public GolfTableau(boolean isTheGameGolf, Deck deck)
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
		} //Checks out for both so far (CFB) - Andrew
		
		//We get our deck of 52 cards with 'deck.getDeck(), returns ArrayList<Card>deck. - Andrew
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
	
	public ArrayList<Card> getPile()
	{
		return this.pile;
	}
	
	public Card getTopCard()
	{
		return this.topCard;
	}
}
