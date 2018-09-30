package edu.buffalo.cse116.code.golf;

import java.util.ArrayList;
import java.util.Collections;

import edu.buffalo.cse116.code.Deck;

/**
 * Class representing a game instance of
 * golf.
 * 
 * @author Willshady
 *
 */
public class GolfGame 
{
	/**
	 * Each game has an instance of a Deck
	 * 			 
	 */
	private Deck gameDeck;
	private ArrayList<GolfTableau> gameTableauPiles;
	private GolfHomecell gameHomecellPile;
	private GolfStock gameStockPile;
	
	public GolfGame()
	{
		/**
		 * Create an new instance of Deck
		 * Utilizing ArrayList shuffle to randomize contents of Deck
		 * 
		 */
		this.gameDeck = new Deck();
		this.gameTableauPiles = new ArrayList<GolfTableau>();
		
		for(int itterator=0; itterator<7; itterator++)
		{
			GolfTableau newTableauPile = new GolfTableau(this.gameDeck);
			this.gameTableauPiles.add(newTableauPile);
		}
		
		this.gameStockPile = new GolfStock(this.gameDeck);
		this.gameHomecellPile = new GolfHomecell(this.gameStockPile);
	}
}
