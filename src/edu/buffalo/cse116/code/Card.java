package edu.buffalo.cse116.code;

/**
 * This class represents a game card with the two instance variables
 * representing the card's suit and rank.
 * 
 * @author William F. Nicholson
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
	 * @return the suit of the card.
	 */
	public int getSuit()
	{
		return this.suit;
	}
	
	/**
	 * @return the rank of the card.
	 */
	public int getRank()
	{
		return this.rank;
	}
	
	/**
	 * @return whether one can build @param card
	 * homecell pile. This method DOES NOT return
	 * true if the card parameters wrap around each other.
	 */
	public boolean canBuild(Card card)
	{		
		if(Math.abs(card.rank - this.rank) == 1)
		{
			return true;
		}
		
		return false;
	}
	
	/**
	 * @return whether one can build @param card homecell
	 * pile with wrapping cards. This method DOES NOT return
	 * true if cards build in any other instance.
	 */
	public boolean canWrap(Card card)
	{
		if(this.rank == 0 || this.rank == 12)
		{
			if(this.rank == 0 && card.rank == 12)
			{
				return true;
			}
			
			if(this.rank == 12 && card.rank == 0)
			{
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * @return true if @param card can be
	 * 'built' up upon the current card,
	 * i.e. rank is one more than this card.
	 */
	public boolean canBuildUp(Card card)
	{
		if(this.suit == 1  && card.getSuit() == 1 || this.suit == 2 && card.getSuit() == 2)
		{
			if(card.getRank() - this.rank == 1) 
			{
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * @return true if @param card can be
	 * 'built' down upon the current card,
	 * i.e. rank is one less than this card.
	 */
	public boolean canBuildDown(Card card)
	{
		if(this.suit == 0  && card.getSuit() == 0 || this.suit == 3 && card.getSuit() == 3)
		{
			if(card.getRank() - this.rank == -1)
			{
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * @return true if @param card has
	 * the same suit as this card.
	 */
	public boolean isSameSuit(Card card)
	{
		if(this.suit == card.suit)
		{
			return true;
		}
		
		return false;
	}
}
