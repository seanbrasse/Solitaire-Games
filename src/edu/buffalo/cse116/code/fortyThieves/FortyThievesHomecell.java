package edu.buffalo.cse116.code.fortyThieves;

import java.util.Stack;

import edu.buffalo.cse116.code.Card;
import edu.buffalo.cse116.code.Homecell;

public class FortyThievesHomecell extends Homecell {
	
	/**
	 * Constructor for the Homecell.
	 */
	public FortyThievesHomecell() {
		
	}
	

	/**
	 * Would remove a card in another solitaire game but you cannot remove cards in Forty Theives so it will return null.
	 */
	@Override
	public Card removeCard() {
		
		return null;
	}

	/**
	 * Adds a card to the homecell if it is legal.
	 */
	@Override
	public void addCard(Card card) {
		if(isAddingCardLegal(card)) {
			this.homecellPile.push(card);
		}
		
	}

	/**
	 * Checks to see if the card that wants to be added to the top of the specific homecell is legal.
	 * i.e. is the same suit and one rank above.
	 */
//	@Override
//	public boolean isAddingCardLegal(Card card) {
//		if(homecellPile.peek().isSameSuit(card)) {
//			if(homecellPile.peek().canBuildUp(card)) {
//				return true;
//			}
//		}
//		return false;
//	}
	
	@Override
	public boolean isAddingCardLegal(Card card) {
		if(homecellPile.peek().getSuit() == card.getSuit() && homecellPile.peek().getRank() - card.getRank() == -1) {
				return true;
			}
		return false;
	}

	/**
	 * Checks if a card can be removed from the homecell pile
	 */
	@Override
	public boolean isRemovingCardLegal() {
		
		//Can't remove cards from the homecell piles in FortyTheives
		return false;
	}
	
	/**
	 * Returns the stack of the homecellpile
	 */
	public Stack<Card> getHomecellPile(){
		return this.homecellPile;
	}

}
