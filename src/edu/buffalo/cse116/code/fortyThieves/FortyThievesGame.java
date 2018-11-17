package edu.buffalo.cse116.code.fortyThieves;

import java.util.ArrayList;

import edu.buffalo.cse116.code.Deck;

/**
 * Class representing a game instance of Forty Theives.
 * @author andrewquinonez
 *
 */
public class FortyThievesGame {
	
	/**
	 * An Arraylist of the homecell piles
	 */
	private ArrayList<FortyTheivesHomecell> gameHomecellPiles;
	
	/**
	 * An Arraylist of the tableau piles
	 */
	private ArrayList<FortyTheivesTableau> gameTableauPiles;
	
	
	/**
	 * An instance of our (game) deck for this game
	 */
	private Deck deck;
	
	public FortyThievesGame() {
		deck = new Deck();
		deck.doubledDeck();
	}
	

}
