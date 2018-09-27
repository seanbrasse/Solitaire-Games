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
	 * REMINDER: rename classes to [game name, functionality]
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
		
		for(int itterator=0; itterator<8; itterator++)
		{
			GolfTableau newTableauPile = new GolfTableau(this.gameDeck);
			this.gameTableauPiles.add(newTableauPile);
		}
		
	}
}
