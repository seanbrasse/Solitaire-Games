package edu.buffalo.cse116.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;


/**
 * This class creates a Tableau for the Little Spider solitaire game that instantiates 8 piles with 6 cards each.
 * From those 8 piles, you can check the card on top, and if removing/adding a card to the tableau pile is a legal move.
 * As well as methods that will remove the card if it's a legal and add the card if it's to be a legal move.
 * @author AndrewQuinonez
 *
 */
public class TableauLS {
	
	/**
	 * Will be an alias for the deck object being used between Tableau and Homecell for Little Spider. The deck
	 * will only contain 48 cards upon instantiation of the class due to game rules.
	 * 
	 * 
	 */
	private Deck deck;
	
	/**
	 * Instantiate an ArrayList of Card type
	 */
	private ArrayList<Card>[] tableauPiles;
	
	
	
	@SuppressWarnings("unchecked")
	public TableauLS(Deck deck) {
		this.deck = deck;		
		tableauPiles = new ArrayList[8];
	}
	
	/**
	 * Instantiates the tableauPiles by creating 8 piles with 6 cards on each pile.
	 */
	public void instantiatePiles() {
		Collections.shuffle(this.deck.getDeck());
		int minIndex = 0;
		int maxIndex = 6;
		
		ArrayList<Card> pile;
		for(int i =0; i < tableauPiles.length; i++) {
			pile = new ArrayList<Card>();
			for(int j = minIndex; j< maxIndex; j++) {
				pile.add(deck.getDeck().get(minIndex));
			}
			tableauPiles[i] = pile;
		}	
	}
	
	/**
	 * Instantiates a tableauPile where you can manipulate the piles for testing purposes.
	 */
	public void instantiateTestingPiles(int testingPileNumber, ArrayList<Card> testingPile, int testingPileNumber2, ArrayList<Card> testingPile2) {
		
		tableauPiles[testingPileNumber] = new ArrayList<Card>();
		tableauPiles[testingPileNumber2] = new ArrayList<Card>();
	
		for(int i = 0; i < testingPile.size(); i++) {
			
			tableauPiles[testingPileNumber].add(testingPile.get(i));
		}
		
		for(int i = 0; i < testingPile2.size(); i++) {
			tableauPiles[testingPileNumber2].add(testingPile2.get(i));
		}
	
	}
	
	/**
	 * Takes the top card and the new (potential) top card and checks if it's a legal move to add to the pile.
	 * @param currentTopCard is the card on top of the current pile at that moment.
	 * @param newTopcard is the new (potential top) card we want to check against the current one.
	 * @return
	 */
	public boolean checkLegalAddToPile(Card currentTopCard , Card newTopcard) {
		
		if(newTopcard.getRank() >= 1 && newTopcard.getRank() <= 11) {
			
			if((newTopcard.getRank() == currentTopCard.getRank() + 1) || (newTopcard.getRank() == currentTopCard.getRank() - 1)) {
				return true;
			} 
		} else if(newTopcard.getRank() == 0 && (currentTopCard.getRank() == 12 ||  currentTopCard.getRank() == 1)) {
			return true;
		} else if(newTopcard.getRank() == 12 && (currentTopCard.getRank() == 0 || currentTopCard.getRank() == 11)) {
			return true;
		} 
		return false;		
	}
	
	
	/**
	 * Removes the top card of a pile and returns it.
	 * @param pileNumber is the pile from which the top card will be removed.
	 * @return
	 */
	public Card removeTopCard(int pileNumber) {
		Card removedCard = null;
		if(checkLegalToRemoveTopCard(pileNumber)) {
			removedCard = tableauPiles[pileNumber].get(tableauPiles[pileNumber].size() - 1);
			tableauPiles[pileNumber].remove(tableauPiles[pileNumber].size() - 1);
			return removedCard;
		} else {
			return removedCard; //Otherwise no card is removed and returns a null card.
		}
	}
	
	
	/**
	 * Will check the pile to see if the top card can be removed.
	 * @param pileNumber is the number for the pile we are going to check (0-7 because there's 8 piles).
	 * @return
	 */
	public boolean checkLegalToRemoveTopCard(int pileNumber) {
		if(tableauPiles[pileNumber].size() > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	
	
	/**
	 * Will add a card to a pile if it can be proven to be a legal move.
	 * @param the card you want to add to the top of a pile.
	 * @param the pile number you're looking for to put the card on top.
	 */
	public void addCardToPile(Card newPotentialTopcard, int pileNumber) {
		Card topPileCard = new Card( -1 , -1);
		
		if(tableauPiles[pileNumber].size() != 0) {
			topPileCard = tableauPiles[pileNumber].get(tableauPiles[pileNumber].size() - 1);	
		} 
		
		if(checkLegalAddToPile(topPileCard, newPotentialTopcard)) {
			
			tableauPiles[pileNumber].add(newPotentialTopcard);
		} 
			//If it doesn't pass the check then this method won't do anything.	
	}
	
	
	
	/**
	 * Gets a top card from the given pile
	 * @param pileNumber is the pile which to get the top card from.
	 * @return 
	 */
	public Card getTopCard(int pileNumber) {
		Card topCard = null;
		if(tableauPiles[pileNumber].size() - 1 >= 0) {
			topCard = tableauPiles[pileNumber].get(tableauPiles[pileNumber].size() - 1);
		}
		
		return topCard;
	}
	
	/**
	 * Returns the tableau piles.
	 * @return
	 */
	public ArrayList<Card>[] getTableauPiles(){
		return tableauPiles;
	}
}
