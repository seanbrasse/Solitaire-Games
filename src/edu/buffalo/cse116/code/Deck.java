package edu.buffalo.cse116.code;

import java.util.ArrayList;

/**
 * This class represents a deck of cards, where each
 * card in the deck is unique in its suit and rank.
 * 
 * @author Willshady
 *
 */

public class Deck 
{
	private ArrayList<Card> deck = new ArrayList<Card>();
	
	/**
	 * Constructor will create unique Cards and add
	 * them to the ArrayList of type Card by itterating
	 * through all the suits (0 - 3), and ranks (0 - 12).
	 */
	public Deck()
	{
		for(int cardSuit = 0; cardSuit< 4; ++cardSuit)
		{
			for(int cardRank = 0; cardRank < 13; ++cardRank)
			{
				deck.add(new Card(cardSuit, cardRank));
			}
		}
	}
	
	public ArrayList<Card> getDeck()
	{
		return this.deck;
	}
}
