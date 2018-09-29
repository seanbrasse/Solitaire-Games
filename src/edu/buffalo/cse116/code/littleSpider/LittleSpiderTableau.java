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
			this.pileSize--;
			return this.pile.pop();
	}

	@Override
	public void addCard(Card card) 
	{
		this.pile.push(card);
		this.pileSize = this.pileSize + 1;
	}

	@Override
	public boolean isAddingCardLegal(Card card) 
	{
		if(this.pile.peek().canWrap(card) || this.pile.peek().canBuild(card))
		{
			return true;
		}
		
		return false;
	}

	@Override
	public boolean isRemovingCardLegal() 
	{
		if(this.pile.size() <= 0)
		{
			return false;
		}

		return true;
	}

	@Override
	public int setPileSize()
	{
		//Pile size in little spider is 6.
		return 6;
	}


}
