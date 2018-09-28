package edu.buffalo.cse116.code.littleSpider;

import edu.buffalo.cse116.code.Card;
import edu.buffalo.cse116.code.Homecell;

public class LittleSpiderHomecell extends Homecell {

	Card c = new Card(0, 0);
	
	/*
	 * Should be void?
	 * 
	 * (non-Javadoc)
	 * @see edu.buffalo.cse116.code.Homecell#removeCard()
	 */
	
	@Override
	public Card removeCard() {
		if(isRemovingCardLegal(c)) {
			this.homecellPile.pop();
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCard(Card card) {
		if(isAddingCardLegal(c)) {
			this.homecellPile.push(card);
		}
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isAddingCardLegal(Card card) {
		if((c.canBuild(card)) && (c.canWrap(card))){
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * Checks if it is legal to remove a card from the homecell pile
	 * 
	 * Should have param of type card?
	 * Need a card to compare to the cards represented in the build and wrap methods
	 * 
	 * (non-Javadoc)
	 * @see edu.buffalo.cse116.code.Homecell#isRemovingCardLegal(edu.buffalo.cse116.code.Card)
	 */
	
	@Override
	public boolean isRemovingCardLegal(){
		if((c.canBuild()) && (c.canWrap(card)) && (this.homecellPile.size() > 1)){
			return true;
		}
		return false;
	}


}







