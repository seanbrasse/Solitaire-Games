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
		this.pile = new Stack<Card>();
		this.topCard = null;
		
		for(int i=0; i<deck.getDeck().size(); i++)
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
		
		this.topCard = pile.get(0);
	}

	@Override
	public Card removeCard() 
	{
		if(isRemovingCardLegal(getTopCard()))
		{
			return this.pile.pop();
		}
		
		return null;
	}

	@Override
	public void addCard(Card card) 
	{
		if(isAddingCardLegal(card)) {
			this.pile.push(card);
		}
	}

	@Override
	public boolean isAddingCardLegal(Card card) 
	{
		if(this.pile.firstElement().canWrap(card)) {
			this.pile.push(card);
			return true;
		}
		return false;
	}

	@Override
	public boolean isRemovingCardLegal(Card card) 
	{
		
		return false;
	}

	@Override
	public int setPileSize() {
		//Pile size in little spider is 8.
		return 8;
	}
}
