package edu.buffalo.cse116.code.littleSpider;

import java.util.ArrayList;
import java.util.Collections;

import edu.buffalo.cse116.code.Card;
import edu.buffalo.cse116.code.Deck;

/**
 * Class representing a game instance of 
 * little spider.
 * 
 * @author William F. Nicholson
 * @author Sean Brasse
 * @author Andrew Quinoez 
 *
 */
public class LittleSpiderGame 
{
	/**
	 * Instantiates the deck
	 * Instantiates an ArrayList of LittleSpiderTableau
	 * Instantiates an ArrayList of LittleSpiderHomecell
	 * 
	 */
	private Deck gameDeck;
	private ArrayList<LittleSpiderTableau> gameTableauPiles;
	private ArrayList<LittleSpiderHomecell> gameHomecellPiles;
	
	/**
	 * This will be used to reference each card to an image.
	 */
	private ArrayList<Card> copyGameDeck; 
	
	
	
	public LittleSpiderGame()
	{
		/**
		 * Create homecell piles, add one specific card to each pile.
		 * Then, create tableau piles with remaining cards from deck.
		 */
		this.gameDeck = new Deck();
		this.gameTableauPiles = new ArrayList<LittleSpiderTableau>();
		this.gameHomecellPiles = new ArrayList<LittleSpiderHomecell>();
		
		copyGameDeck = new ArrayList<Card>();
		copyGameDeck.addAll(gameDeck.getDeck());
			
		/**
		 * Holds the four cards we'll need for the homecell piles
		 */
		Card aDiamonds = gameDeck.getDeck().get(13);
		Card aHearts = gameDeck.getDeck().get(26);
		Card kClubs = gameDeck.getDeck().get(12);
		Card kSpades = gameDeck.getDeck().get(51);
				
		/**
		 * Once we have references to the cards we need, from the deck class we'll remove these cards
		 */
		gameDeck.getDeck().remove(51);
		gameDeck.getDeck().remove(26);
		gameDeck.getDeck().remove(13);
		gameDeck.getDeck().remove(12);
				
		/**
		 * Makes 4 instances of LittleSpiderHomecell
		 */
		LittleSpiderHomecell hcp1 = new LittleSpiderHomecell();		
		LittleSpiderHomecell hcp2 = new LittleSpiderHomecell();		
		LittleSpiderHomecell hcp3 = new LittleSpiderHomecell();		
		LittleSpiderHomecell hcp4 = new LittleSpiderHomecell();		
		
		/**
		 * Now take the references for the cards and add it to the homecell piles
		 */
		hcp1.getHomecellPile().add(aDiamonds);
		hcp2.getHomecellPile().add(aHearts);
		hcp3.getHomecellPile().add(kClubs);
		hcp4.getHomecellPile().add(kSpades);
		
		/**
		 * Now we add our homecell piles to the list of homecell piles
		 */
		gameHomecellPiles.add(hcp1);
		gameHomecellPiles.add(hcp2);
		gameHomecellPiles.add(hcp3);
		gameHomecellPiles.add(hcp4);
		
		
		
		/**
		 * Now with the remaining 48 cards, we'll shuffle
		 */
		Collections.shuffle(gameDeck.getDeck());
		
		
		/**
		 * Now take these 48 cards and create 8 tableau piles where each pile will get 6 cards
		 */
		for(int i = 0; i < 8; i++) {	
			LittleSpiderTableau lst = new LittleSpiderTableau(gameDeck);
			gameTableauPiles.add(lst);
			
		}
		
		
	}
	
	/**
	 * Returns the current deck
	 * Used for testing
	 */
	public Deck getCurrentDeck() {
		return this.gameDeck;
	}
	
	/**
	 * Returns the ArrayList of LittleSpiderHomecell
	 * Used for testing
	 */

	public ArrayList<LittleSpiderHomecell> getHomecellPiles(){
		return this.gameHomecellPiles;
	}
	
	/**
	 * Returns a copy of the deck that has all the 52 elements (cards) so pictures can be assigned to them.
	 * @return
	 */
	public ArrayList<Card> getCopyGameDeck(){
		return copyGameDeck;
	}
	

	/**
	 * Returns the ArrayList of LittleSpiderTableau
	 * Used for testing
	 */
	
	public ArrayList<LittleSpiderTableau> getTableauPiles(){
		return this.gameTableauPiles;
	}

	
}
