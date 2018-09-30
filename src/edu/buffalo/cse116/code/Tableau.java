package edu.buffalo.cse116.code;

import java.util.Stack;

/**
 * Class represents Tableau piles, with pile size,
 * adding logic, and removing logic to be implemented
 * in extending game varients.
 * 
 * @author William F. Nicholson
 *
 */
public abstract class Tableau 
{
	/**
	 * pile is represented as an ArrayList<Card>.
	 * topCard is used to manage game logic.
	 * pileSize varies per game, used to determine draw size.
	 */
	protected Stack<Card> pile;
	protected int pileSize;
	
	/**
	 * Constructor requires setPileSize() to be defined by subclass.
	 * pile is instantiated, and cards are drawn from @param deck.
	 * Once pile is set, topCard is given the 0th index of the pile.
	 * 
	 * @param deck
	 */
	public Tableau(Deck deck)
	{
		this.pile = new Stack<Card>();
		this.pileSize = setPileSize();
		
		for(int i=0; i<deck.getDeck().size() - 1; i++)
		{
			if(pile.size() < pileSize)
			{
				pile.add(deck.getDeck().get(i));
				deck.getDeck().remove(i);
			}
			
			else
			{
				break;
			}
		}
	}
	
	public abstract Card removeCard();
	public abstract void addCard(Card card);
	public abstract boolean isAddingCardLegal(Card card);
	public abstract boolean isRemovingCardLegal();
	public abstract int setPileSize();
	
	public int getPileSize()
	{
		return this.pileSize;
	}
	
	public Stack<Card> getPile()
	{
		return this.pile;
	}
}
