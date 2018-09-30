package edu.buffalo.cse116.code.littleSpider;

import java.util.ArrayList;

import edu.buffalo.cse116.code.Card;
import edu.buffalo.cse116.code.Deck;

/**
 * Class representing a game instance of 
 * little spider.
 * 
 * @author Willshady
 *
 */
public class LittleSpiderGame 
{
	/**
	 * 
	 */
	private Deck gameDeck;
	private ArrayList<LittleSpiderTableau> gameTableauPiles;
	private ArrayList<LittleSpiderHomecell> gameHomecellPiles;
	
	public LittleSpiderGame()
	{
		/**
		 * Create homecell piles, add one specific card to each pile.
		 * Then, create tableau piles with remaining cards from deck.
		 */
		this.gameDeck = new Deck();
		this.gameTableauPiles = new ArrayList<LittleSpiderTableau>();
		this.gameHomecellPiles = new ArrayList<LittleSpiderHomecell>();
		
		for(int i=0; i<this.gameDeck.getDeck().size(); i++)
		{
			Card currentCard = this.gameDeck.getDeck().get(i);
			
			if(currentCard.getRank() == 0)
			{
				if(currentCard.getSuit() == 1 || currentCard.getSuit() == 2)
				{
					LittleSpiderHomecell newHomecellPile = new LittleSpiderHomecell();
					newHomecellPile.getHomecellPile().add(currentCard);
					this.gameHomecellPiles.add(newHomecellPile);
					this.gameDeck.getDeck().remove(i);
				}
			}
			
			if(currentCard.getRank() == 12)
			{
				if(currentCard.getSuit() == 0 || currentCard.getSuit() == 3)
				{
					LittleSpiderHomecell newHomecellPile = new LittleSpiderHomecell();
					newHomecellPile.getHomecellPile().add(currentCard);
					this.gameHomecellPiles.add(newHomecellPile);
					this.gameDeck.getDeck().remove(i);
				}
			}
		}
	}
	
	/*
	 * Returns the current deck
	 * Used for testing
	 */
	public Deck getCurrentDeck() {
		return this.gameDeck;
	}
	
	/*
	 * Returns the ArrayList of LittleSpiderHomecell
	 * Used for testing
	 */

	public ArrayList<LittleSpiderHomecell> getHomecellPiles(){
		return this.gameHomecellPiles;
	}

	
}
