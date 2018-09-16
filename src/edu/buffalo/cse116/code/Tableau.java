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
	int deckSize;
	
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
		
	}
}
