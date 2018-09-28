package edu.buffalo.cse116.code;

import java.util.Stack;

/**
 * 
 * @author Willshady
 *
 */
public abstract class Homecell 
{
	protected Stack<Card> homecellPile;
	
	public Homecell()
	{
		this.homecellPile = new Stack<Card>();
	}
	
	public abstract Card removeCard();
	public abstract void addCard(Card card);
	public abstract boolean isAddingCardLegal(Card card);
	public abstract boolean isRemovingCardLegal(Card card);
	
	/*
	 * Do we need a getTopcard method to make our parameters?
	 */
}
