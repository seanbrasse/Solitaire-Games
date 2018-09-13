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
	 * suit is a number from 0 to 3, in order of: Clubs, Diamonds, Hearts, and Spades.
	 * rank is a number from 0 to 12, in order of: Ace, going 2 - 10, and proceeding Jack, Queen, King.
	 */
	private int suit;
	private int rank;
	
	public Card(int suit, int rank)
	{
		this.suit = suit;
		this.rank = rank;
	}
	
	public int getSuit()
	{
		return this.suit;
	}
	
	public int getRank()
	{
		return this.rank;
	}
}
