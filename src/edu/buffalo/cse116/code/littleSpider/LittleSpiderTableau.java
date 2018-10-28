package edu.buffalo.cse116.code.littleSpider;

import java.util.Stack;

import edu.buffalo.cse116.code.Card;
import edu.buffalo.cse116.code.Deck;
import edu.buffalo.cse116.code.Tableau;


/**
 * This class creates a Tableau for the Little Spider solitaire game that instantiates 8 piles with 6 cards each.
 * From those 8 piles, you can check the card on top, and if removing/adding a card to the tableau pile is a legal move.
 * As well as methods that will remove the card if it's a legal and add the card if it's to be a legal move.
 * 
 * @author AndrewQuinonez
 * @author William F. Nicholson
 * @author Anthony Latoni
 *
 */
public class LittleSpiderTableau extends Tableau 
{

	public LittleSpiderTableau(Deck deck) 
	{
		super(deck);
	}

	/**
	 * Removes a card from the tableau
	 */
	@Override
	public Card removeCard()
	{
		this.pileSize--;
		return this.pile.pop();
	}
	/**
	 * Adds a card to the tableau
	 * @param the card we want to add
	 */
	@Override
	public void addCard(Card card) 
	{
		this.pile.push(card);
		this.pileSize = this.pileSize + 1;
	}

	/**
	 * Checks if it is legal to add a card. A card can be added if it builds in either direction or can wrap
	 * @param the card we want to add
	 */
	@Override
	public boolean isAddingCardLegal(Card card) 
	{
		if(this.pile.peek().canWrap(card) || this.pile.peek().canBuild(card))
		{
			return true;
		}
		
		return false;
	}
	
	/**
	 * Checks if it is legal to remove a card. Cards can always be removed from a tableau as long as its not empty.
	 */
	@Override
	public boolean isRemovingCardLegal() 
	{
		if(this.pile.size() <= 0)
		{
			return false;
		}

		return true;
	}
	
	/**
	 * Initializes a pile size of 6.
	 * @return the pile size
	 */
	@Override
	public int setPileSize()
	{
		//Pile size in little spider is 6.
		return 6;
	}


}
