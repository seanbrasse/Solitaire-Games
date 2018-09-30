package edu.buffalo.cse116.code.golf;

import java.util.ArrayList;
import java.util.Collections;

import edu.buffalo.cse116.code.Deck;

/**
 * Class representing a game instance of
 * golf.
 * 
 * @author William F. Nicholson
 *
 */
public class GolfGame 
{
	/**
	 * Each game has an instance of a Deck			 
	 */
	private Deck gameDeck;
	
	/**
	 * Will hold each tableau pile that will be used for Golf game
	 */
	private ArrayList<GolfTableau> gameTableauPiles;
	
	/**
	 * Our Homecell pile, we only need one for Golf.
	 */
	private GolfHomecell gameHomecellPile;
	
	/**
	 * Our Stock pile, will hold the remaining cards
	 */
	private GolfStock gameStockPile;
	
	/**
	 * Create an new instance of Deck and randomized it. Then creates our Tableau piles, as well as our Stock and
	 * Homecell pile.
	 */
	public GolfGame()
	{
		
		this.gameDeck = new Deck();
		Collections.shuffle(this.gameDeck.getDeck());
		
		this.gameTableauPiles = new ArrayList<GolfTableau>();
		
		for(int itterator=0; itterator<7; itterator++)
		{
			GolfTableau newTableauPile = new GolfTableau(this.gameDeck);
			this.gameTableauPiles.add(newTableauPile);
		}
		
		this.gameStockPile = new GolfStock(this.gameDeck);
		this.gameHomecellPile = new GolfHomecell();
	}
	
	/**
	 * Returns gameTableauPiles.
	 * @return gameTableauPiles
	 */
	public ArrayList<GolfTableau> getGameTableauPiles(){
		return gameTableauPiles;
	}
}
