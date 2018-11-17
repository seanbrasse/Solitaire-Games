package edu.buffalo.cse116.code.fortyThieves;

import edu.buffalo.cse116.code.Card;
import edu.buffalo.cse116.code.Deck;
import edu.buffalo.cse116.code.Tableau;

public class FortyThievesTableau extends Tableau {

	public FortyThievesTableau(Deck deck) {
		super(deck);
		
	}

	/**
	 * If removing a card is legal, then the card will be removed.
	 */
	@Override
	public Card removeCard() {
		if(isRemovingCardLegal()) {
			pileSize--;
			return pile.pop();
		}
		return null;
	}

	/**
	 * If the card is legal to add to the tableau pile, then the method will 'push' it on top
	 */
	@Override
	public void addCard(Card card) {
		if(isAddingCardLegal(card)) {
			pile.push(card);
			pileSize++;
		}
	}

	/**
	 * Checks if the card passing through can be used to build up.
	 */
	@Override
	public boolean isAddingCardLegal(Card card) {
		if(!this.pile.isEmpty() && this.pile.peek().getSuit() == card.getSuit() && this.pile.peek().canBuild(card)) {
			return true;
		} else if(this.pile.isEmpty()) {
			pile.push(card);
		}
		return false;
	}

	/**
	 * Returns true or false if it's legal or not legal to remove a card
	 */
	@Override
	public boolean isRemovingCardLegal() {
		if(!pile.isEmpty()) {
			return true;
		}
		return false;
	}

	/**
	 * Sets the initial pile size of the tableau
	 */
	@Override
	public int setPileSize() {
		// TODO Auto-generated method stub
		return 3;
	}

}
