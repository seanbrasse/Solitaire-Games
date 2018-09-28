package edu.buffalo.cse116.code.golf;

import java.util.ArrayList;

import edu.buffalo.cse116.code.Card;
import edu.buffalo.cse116.code.Deck;

/**
 * Class represents a tableau pile in  golf,
 * with logic for pile functionality.
 * 
 * @author Willshady
 *
 */

public class GolfTableau 
{
	/**
	 * 
	 */
	ArrayList<Card> pile;
	Card topCard;
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
	public GolfTableau(Deck deck)
	{
		this.pile = new ArrayList<Card>();
		this.topCard = null;
		this.pileSize = 5;
		
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
	
	public void removeCard()
	{
		if(this.isAddingCardLegal())
		{
			this.pile.remove(0);
			this.topCard = this.pile.get(0);
		}
	}
	
	public void addCard()
	{
		
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
