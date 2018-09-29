package edu.buffalo.cse116.code.littleSpider;

import edu.buffalo.cse116.code.Card;
import edu.buffalo.cse116.code.Homecell;

public class LittleSpiderHomecell extends Homecell {
	
	/**
	 * RULES DECLARED ON WEBSITE:
	 * Once a card is removed, the card following it in
	 * the pile becomes the top card and can be removed.
	 * 
	 * LOGIC:
	 * Stacks have pop and push features,so we don't need
	 * a seperate variable to keep track of the top card.
	 */
	@Override
	public Card removeCard()
	{
		if(isRemovingCardLegal())
		{
			//POP WILL REMOVE CARD FROM PILE.
			//WE ARE RETURNING THIS.
			return this.homecellPile.pop();
		}
		
		return null;
	}

	/**
	 * 
	 */
	@Override
	public void addCard(Card card)
	{
		if(isAddingCardLegal(card))
		{
			this.homecellPile.push(card);
		}
	}

	/**
	 * 
	 */
	@Override
	public boolean isAddingCardLegal(Card card)
	{
		if(homecellPile.peek().canBuild(card) && homecellPile.peek().canWrap(card))
		{
			return true;
		}

		return false;
	}
	
	/**
	 * Only the card which is currently at the top of the homecell pile can be removed.
	 * You cannot remove the last card in the homecell pile.
	 */
	@Override
	public boolean isRemovingCardLegal()
	{
		if((this.homecellPile.size() > 1))
		{
			return true;
		}
		
		return false;
	}
}







