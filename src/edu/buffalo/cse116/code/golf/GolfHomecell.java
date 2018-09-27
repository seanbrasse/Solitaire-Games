package edu.buffalo.cse116.code.golf;

import java.util.ArrayList;

import edu.buffalo.cse116.code.Card;

public class GolfHomecell {
	
	// an ArrayList to keep track of the pile
	private GolfTableau top;
	private ArrayList<Card> cardPile;
	
	public GolfHomecell(GolfTableau tableau, ArrayList<Card> array) {
		
		this.top = tableau;
		this.cardPile = array;
		
	}
	
	public void addingCards() {
		
		// Adding cards into the Home cell pile when it's legal
		for(int i = 0; i < cardPile.size(); i++) {
			
			if(cardPile.size() == 0) {
				
				// the Home cell pile start out empty, so any card is legal
				cardPile.add(top.topCard);
				
				// checking if the card is legal
			} else if(top.topCard.getRank() >= 1 && top.topCard.getRank() <= 11) {
				
				if(cardPile.get(i).getRank() == top.topCard.getRank() + 1 || cardPile.get(i).getRank() == top.topCard.getRank() - 1) {
					cardPile.add(top.topCard);
				}
				
			} else if(top.topCard.getRank() == 0) {

				if(cardPile.get(i).getRank() == 12 || cardPile.get(i).getRank() == 1){
					cardPile.add(top.topCard);
				}
				
			} else if(top.topCard.getRank() == 12) {
				
				if(cardPile.get(i).getRank() == 0 || cardPile.get(i).getRank() == 11) {
					cardPile.add(top.topCard);
				}
				
			} else {
				break;
			}
		}
	}
	
}
