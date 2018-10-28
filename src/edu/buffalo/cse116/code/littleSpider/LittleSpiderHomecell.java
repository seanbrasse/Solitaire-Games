package edu.buffalo.cse116.code.littleSpider;

import java.util.Stack;

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
	 * 
	 * @author Sean Brasse
	 * @author William F. Nicholson 
	 * 
	 * 
	 */
	
	/**
	 * This method removes a card from the homecell pile
	 * @return the removed card
	 */
	@Override
	public Card removeCard()
	{
		if(isRemovingCardLegal())
		{
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
	 * the top card AND a rank one ABOVE the homecell pile's top card. Clubs or Spades can 
	 * be added to a homecell pile if it has the identical suit as the top card AND a rank 
	 * one BELOW the homecell pile's top card. Cards CANNOT wrap when adding to a homecell pile.
	 * @return true if the card can be legally added
	 */

	@Override
	public boolean isAddingCardLegal(Card card) {
		if(this.homecellPile.size() > 0) {
			if(this.homecellPile.lastElement().canBuildUp(card)) {
				return true;
			} else if(this.homecellPile.lastElement().canBuildDown(card)) {
				return true;
			}
		} 
		return false;

	}

	/**
	 * Only the card which is currently at the top of the homecell pile can be removed.
	 * You cannot remove the last card in the homecell pile.
	 * @return true if a card can be legally removed
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

	/**
	 * Gets the homecellPile, allows for testing
	 * 
	 * @return a homecellPile
	 */
	public Stack<Card> getHomecellPile(){
		return this.homecellPile;
	}

} 
 
 





