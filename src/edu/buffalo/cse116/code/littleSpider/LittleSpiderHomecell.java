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
			//WE ARE RETURNING THIS IF LEGAL.
			return this.homecellPile.pop();
		}
		
		return null;
	}

	/**
	 * A card whose suit is Hearts or Diamonds can be added to a homecell pile if
	 * it has the identical suit as the top card AND a rank one ABOVE the homecell 
	 * pile's top card. For example, the Queen of Diamonds can only be added to a 
	 * homecell pile whose current top card is the Jack of Diamonds.A card whose suit
	 * is Clubs or Spades can be added to a homecell pile if it has the identical suit
	 * as the top card AND a rank one BELOW the homecell pile's top card. For example,
	 * the Queen of Spades can only be added to a homecell pile whose current top card 
	 * is the King of Spades. No matter its suit, the added card becomes the homecell's
	 * new top card.
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
	 * Hearts or Diamonds can be added to a homecell pile if it has the identical suit as
	 * the top card AND a rank one ABOVE the homecell pile's top card.
	 */
	@Override
	public boolean isAddingCardLegal(Card card)
	{
		//WE ARE CHECKING TOP CARD AND COMPARING IT TO @PARAM CARD TO SEE IF IT WRAPS.
		if(homecellPile.peek().canBuild(card) || homecellPile.peek().canWrap(card))
		{
			//WE ARE CHECKING TOP CARD AND COMPARING IT TO @PARAM CARD TO SEE IF ITS SAME SUIT.
			if(homecellPile.peek().isSameSuit(card))
			{
				return true;
			}
		}
		//IF THE CARDS DO NOT WRAP OR ARE NOT THE SAME SUIT, CAN'T ADD THE CARD.
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







