package edu.buffalo.cse116.code.fortyThieves;

import java.util.ArrayList;

import edu.buffalo.cse116.code.Card;
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
		gameHomecellPiles = new ArrayList<FortyTheivesHomecell>();
		gameTableauPiles = new ArrayList<FortyTheivesTableau>();
		
	}
	
	/**
	 * Each homecell needs to be initialized with 1 ace. This method will add an ace to each homecell pile.
	 */
	public void findAllAcesIndex() {
		ArrayList<Card> eachAce = new ArrayList<Card>();
		eachAce.add(deck.getDeck().get(0));
		eachAce.add(deck.getDeck().get(1));
		eachAce.add(deck.getDeck().get(26));
		eachAce.add(deck.getDeck().get(27));
		eachAce.add(deck.getDeck().get(52));
		eachAce.add(deck.getDeck().get(53));
		eachAce.add(deck.getDeck().get(78));
		eachAce.add(deck.getDeck().get(79));
		
		
		for(int i = 0; i < 8; i++) {
			deck.getDeck().remove(eachAce.get(i));
		}
		System.out.println("Deck size: " + deck.getDeck().size());
	}	
}


