package edu.buffalo.cse116.code;

import java.util.Stack;

/**
 * This class represents an abstraction of homecell functionality.
 * Extensions of homecell will implement logic and functionality to
 * add and remove cards from the pile. 
 * 
 * @author William F. Nicholson
 */
public abstract class Homecell 
{
	/**
	 * Stack<Card> will ensure top card using pop, push, and peek methods;
	 * representing a homecell pile.
	 */
	protected Stack<Card> homecellPile;
	
	/**
	 * Constructor instantiates the stack of type card.
	 */
	public Homecell()
	{
		this.homecellPile = new Stack<Card>();
	}
	
	/**
	 * Abstract method that should remove the card
	 * from the pile upon implementation.
	 * @return the card removed from the pile.
	 */
	public abstract Card removeCard();
	
	/**
	 * Abstract method that should add the
	 * @param card to the pile upon implementation.
	 */
	public abstract void addCard(Card card);
	
	/**
	 * Abstract method that should check if the
	 * @param card can be added to the pile according
	 * to the rules of the game in question.
	 * @return if card can be added to pile
	 */
	public abstract boolean isAddingCardLegal(Card card);
	
	/**
	 * Abstract method that should check if the 
	 * @param card can be removed from the pile
	 * according to the rules of the game in question.
	 * @return if a card can be removed from the pile.
	 */
	public abstract boolean isRemovingCardLegal();
}
