package edu.buffalo.cse116.code.fortyThieves;


import java.util.Stack;

import edu.buffalo.cse116.code.Card;
import edu.buffalo.cse116.code.Deck;

/**
 * Creates the Stock pile in the form of a Stack of Card objects. We also have the rules here to check if cards can be added or removed from the stock.
 * @author Andrew Quinonez
 *
 */
public class FortyThievesStock {
	
	/**
	 * Creates the ArrayList of Card that will contain the remaining Card objects from the deck. 
	 * i.e. 57.
	 */
	private Stack<Card> stockPile;
	
	/**
	 * Holds a reference to our current Waste pile in the game
	 */
	private FortyThievesWaste wastePile;
	
	/**
	 * Takes the remaining card Deck and places it into the Stock pile.
	 * @param deck
	 */
	public FortyThievesStock(Deck deck, FortyThievesWaste wastePile) { 
		this.stockPile = new Stack<Card>();
		this.wastePile = wastePile;
		
		int size = deck.getDeck().size();
		for(int i = 0; i < size; i++){
			this.stockPile.add(deck.getDeck().get(0));
			deck.getDeck().remove(0);
		}
	}
	
	/**
	 * Returns the stock pile of our remaining Cards
	 * @return the stock pile of our remaining Cards
	 */
	public Stack<Card> getStock(){
		return stockPile;
	}
	
	/**
	 * Will add a card to Stock if it's legal, it isn't so it won't add anything
	 * @param card
	 */
	public void addCardToStock(Card card) {
		if(isAddingCardLegal(card)) {
			//If only you could add to the Stock in Forty Thieves...
			stockPile.push(card);
		}
	}
	
	/**
	 * Will take the removed card if its legal (when its not empty) and places it in the Waste pile
	 */
	public void removeCard() {
		if(isRemovingCardLegal()) {
			this.wastePile.getWastePile().push(stockPile.pop()); 
		}		
	}
	
	/**
	 * Checks if a card can be added to the stock pile. You can't in Forty Thieves so it will return false;
	 * @param card
	 * @return
	 */
	public boolean isAddingCardLegal(Card card) {
		return false;
	}
	
	/**
	 * Will check if you can remove a card from Stock.
	 * @return
	 */
	public boolean isRemovingCardLegal() {
		if(!stockPile.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
}
