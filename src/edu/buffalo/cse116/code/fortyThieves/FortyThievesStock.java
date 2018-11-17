package edu.buffalo.cse116.code.fortyThieves;

import java.util.ArrayList;
import java.util.Stack;

import edu.buffalo.cse116.code.Card;
import edu.buffalo.cse116.code.Deck;

public class FortyThievesStock {
	
	/**
	 * Creates the ArrayList of Card that will contain the remaining Card objects from the deck. 
	 * i.e. 57.
	 */
	private Stack<Card> stockPile;
	
	/**
	 * Takes the remaining card Deck and places it into the Stock pile.
	 * @param deck
	 */
	public FortyThievesStock(Deck deck) {
		this.stockPile = new Stack<Card>();
		
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
}
