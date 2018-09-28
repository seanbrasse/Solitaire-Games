package edu.buffalo.cse116.code;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This class represents a deck of cards, where each
 * card in the deck is unique in its suit and rank.
 * Decks are shuffled on creation.
 * 
 * @author Willshady
 *
 */

public class Deck 
{
	
	/**
	 * Create a newly allocated deck ArrayList that will contain elements to create a standardized deck of 52 cards.
	 */
	private ArrayList<Card> deck = new ArrayList<Card>();
	
	/**
	 * Constructor will create unique Cards and add
	 * them to the ArrayList of type Card by itterating
	 * through all the suits (0 - 3), and ranks (0 - 12).
	 * 
	 * Then, shuffle deck once cards added.
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
		
		Collections.shuffle(this.deck);
	}
	
	/**
	 * Returns our deck.
	 * @return the deck we created.
	 */
	public ArrayList<Card> getDeck()
	{
		return this.deck;
	}
}