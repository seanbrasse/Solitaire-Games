package edu.buffalo.cse116.code;

/**
 * This class represents a game card with the two instance variables
 * representing the card's respective suit and rank.
 * 
 * @author Willshady
 *
 */

public class Card 
{
	/**
	 * Suit is a number from 0 to 3, in order of: Clubs, Diamonds, Hearts, and Spades.
	 */
	private int suit;
	
	/**
	 * Rank is a number from 0 to 12, in order of: Ace, going 2 - 10, and proceeding Jack, Queen, King.
	 */
	private int rank;
	
	/**
	 * Constructs a newly allocated Card, of suit and rank based on the parameters.
	 * @param suit of the card.
	 * @param rank of the card.
	 */
	public Card(int suit, int rank)
	{
		this.suit = suit;
		this.rank = rank;
	}
	
	/**
	 * Returns the suit of the card.
	 * @return the suit of the card.
	 */
	public int getSuit()
	{
		return this.suit;
	}
	
	/**
	 * Returns the rank of the card.
	 * @return the rank of the card.
	 */
	public int getRank()
	{
		return this.rank;
	}
}
