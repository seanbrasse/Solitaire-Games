package edu.buffalo.cse116.code;

import java.util.Stack;

/**
 * Class represents abstraction of tableau piles,
 * with pile size, adding logic, and removing logic
 * to be implemented in extending game variants.
 * 
 * @author William F. Nicholson
 */
public abstract class Tableau 
{
	/**
	 * pile is represented as an Stack<Card>; Stack ensures
	 * that top card is preserved upon data manipulation.
	 * pileSize varies per game, used to determine draw size.
	 */
	protected Stack<Card> pile;
	protected int pileSize;
	
	/**
	 * Constructor requires setPileSize() to be defined by subclass.
	 * Pile is instantiated, and cards are drawn from @param deck.
	 */
	public Tableau(Deck deck)
	{
		this.pile = new Stack<Card>();
		this.pileSize = setPileSize();
		
		for(int i=0; i<deck.getDeck().size() - 1; i++)
		{
			if(pile.size() < pileSize)
			{
				pile.push(deck.getDeck().get(i));
				deck.getDeck().remove(i);
			}
			
			else
			{
				break;
			}
		}
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
	
	/**
	 * Method required to be implemented in order for
	 * constructor to compile. @return the desired size
	 * of the pile which will be instantiated in the
	 * Constructor.
	 */
	public abstract int setPileSize();
	
	/**
	 * @return size of the pile.
	 */
	public int getPileSize()
	{
		return this.pileSize;
	}
	
	/**
	 * @return pile represented as Stack<Card>.
	 */
	public Stack<Card> getPile()
	{
		return this.pile;
	}
}
