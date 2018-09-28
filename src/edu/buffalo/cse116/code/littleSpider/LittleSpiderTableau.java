package edu.buffalo.cse116.code.littleSpider;

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
 *
 */
public class LittleSpiderTableau extends Tableau 
{

	public LittleSpiderTableau(Deck deck) 
	{
		super(deck);
	}

	@Override
	public Card removeCard() 
	{
		return null;
	}

	@Override
	public void addCard(Card card) 
	{
		
	}

	@Override
	public boolean isAddingCardLegal() 
	{
		return false;
	}

	@Override
	public boolean isRemovingCardLegal() 
	{
		return false;
	}

	@Override
	public int setPileSize() {
		//Pile size in little spider is 6.
		return 6;
	}
}
