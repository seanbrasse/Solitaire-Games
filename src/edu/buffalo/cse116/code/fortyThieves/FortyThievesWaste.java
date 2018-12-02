package edu.buffalo.cse116.code.fortyThieves;

import java.util.Stack;

import edu.buffalo.cse116.code.Card;

/**
 * Creates our Waste pile and has the rules to check if adding or removing from the Waste pile is legal or not.
 * @author Andrew Quinonez
 *
 */
public class FortyThievesWaste {

	/**
	 * A stack that contains the Card objects removed from the Stock pile.
	 */
	private Stack<Card> wastePile;
	
	/**
	 * Instantiates the Waste pile.
	 */
	public FortyThievesWaste() {
		wastePile = new Stack<Card>(); //initially empty.
	}
	
	/**
	 * Returns the card removed from waste if the move is legal
	 * @return Card that is top of Waste pile.
	 */
	public Card removedCard() {
		if(isRemoveLegal()) {
			return wastePile.pop();
		}
		return null;
	}
	
	/*
	 *Returns if removing from the waste pile is legal (Always unless pile is empty) 
	 */
	
	public boolean isRemoveLegal() {
		if(!wastePile.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	/*
	 *Returns a waste pile 
	 */
	
	public Stack<Card> getWastePile(){
		return wastePile;
	}
	
/*
 * 	Might not need this method because Stock's remove method handles adding to the waste pile 
 * (See project test requirements)
 */
	
//	public void addCardFromStock(Card card)
//	{
//		wastePile.push(card);
//	}
	
	/*
	 *Returns if adding from a pile other than the stock pile is legal (illegal) 
	 */
	
	public boolean isAddingFromNotStockLegal(){
		return false;
	}
	
}
