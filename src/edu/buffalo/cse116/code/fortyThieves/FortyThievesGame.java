package edu.buffalo.cse116.code.fortyThieves;

import java.util.ArrayList;
import java.util.Collections;

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
	private ArrayList<FortyThievesHomecell> gameHomecellPiles;
	
	/**
	 * An Arraylist of the tableau piles
	 */
	private ArrayList<FortyThievesTableau> gameTableauPiles;
	
	private FortyThievesStock stock;
	
	
	/**
	 * An instance of our (game) deck for this game
	 */
	private Deck deck;
	
	public FortyThievesGame() {
		deck = new Deck();
		deck.doubledDeck();
		gameHomecellPiles = new ArrayList<FortyThievesHomecell>();
		gameTableauPiles = new ArrayList<FortyThievesTableau>();
		instantiateHomecellPiles();
		instantiateTableauPiles();
		instantiateStockPile();
	}
	
	/**
	 * Each homecell needs to be initialized with 1 ace. This method will add an ace to each homecell pile.
	 */
	public void instantiateHomecellPiles() {
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
			deck.getDeck().remove(eachAce.get(i)); //remove each ace from the deck
			FortyThievesHomecell homecell = new FortyThievesHomecell(); //create a new instance of our FortyThievesHomecell class
			homecell.getHomecellPile().push(eachAce.get(i));//push a card onto the Stack of the homecell that is in each FortyThievesHomecell
			gameHomecellPiles.add(homecell); //Add the FortyThievesHomecell pile to our ArrayList of FortyThievesHomecell
			}
		}
		
	/**
	 * Instantiates each FortyThievesTableau pile (object)	
	 */
	public void instantiateTableauPiles() {
		//Starts with shuffling the remainder of the cards in the Deck object
		Collections.shuffle(deck.getDeck());
		
		//For each of the tableau piles
		for(int i = 0; i < 13; i++) {
			FortyThievesTableau tableau = new FortyThievesTableau(deck); //we create a new FortyThievesTableau object which has a Stack that holds the Card objects
			gameTableauPiles.add(tableau); //add each of those objects to our arrayList of them.
		}
		
	}
	
	/**
	 * Instantiates our Stock pile
	 */
	public void instantiateStockPile() {
		stock = new FortyThievesStock(deck);
	}
	
	
	
	/**
	 * Returns our arraylist of the FortyThievesTableau objects.
	 * @return our arraylist of the FortyThievesTableau objects.
	 */
	public ArrayList<FortyThievesTableau> getGameTableauPiles(){
		return gameTableauPiles;
	}
	
	public ArrayList<FortyThievesHomecell> getGameHomecellPiles(){
		return gameHomecellPiles;
	}
}


