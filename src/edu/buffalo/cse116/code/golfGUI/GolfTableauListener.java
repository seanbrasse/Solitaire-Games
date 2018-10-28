package edu.buffalo.cse116.code.golfGUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import edu.buffalo.cse116.code.golf.GolfHomecell;
import edu.buffalo.cse116.code.golf.GolfTableau;
import edu.buffalo.cse116.code.gui.CardImage;

/**
 * Makes changes to model through
 * interactions with tableau piles.
 * 
 * @author William F. Nicholson
 *
 */
public class GolfTableauListener implements MouseListener
{
	/**
	 * View which we'll use to call redraw and get stuff from it.
	 */
	private GolfLayeredPanel pane;
	/**
	 * Homecell pile we can use to help determine logic
	 */
	private GolfHomecell homecellPile;
	/**
	 * Tableau piles we'll be checking for legal moves.
	 */
	private GolfTableau tableauPile;
	/**
	 * keep track of which tableau pile in question
	 * the selected card belongs to.
	 */
	private int pileNumber;
	
	/**
	 * Construct a new mouse listener
	 * 
	 * @param pane
	 */
	public GolfTableauListener(GolfLayeredPanel pane)
	{
		this.pane = pane;
		pileNumber = -1;
	}
	
	/**
	 * Check if card can be acted upon,
	 * is if adding card to homecell is legal,
	 * make model change and redraw if applicable.
	 */
	@Override
	public void mouseClicked(MouseEvent e)
	{
		CardImage cardImage = (CardImage)e.getSource();
		
		if(isCardTopOfPile(cardImage))
		{
			tableauPile = pane.getGame().getGameTableauPiles().get(pileNumber);
			homecellPile = pane.getGame().getGameHomecellPile();
			
			if(homecellPile.isAddingCardLegal(cardImage.getCard()))
			{
				homecellPile.addCard(tableauPile.removeCard());
				pane.redrawLayeredPanel();
			}
			else
			{
				pane.getTextField().setText("Illegal move.");
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) 
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}
	
	/**
	 * Helper method to prevent cards in tableau pile
	 * from being selected when not applicable.
	 * 
	 * @param cardImage
	 * @return whether card in question is top of stack.
	 */
	public boolean isCardTopOfPile(CardImage cardImage)
	{
		for(int piles=0; piles<pane.getGame().getGameTableauPiles().size(); piles++)
		{
			GolfTableau currentPile = pane.getGame().getGameTableauPiles().get(piles);
			
			if(!currentPile.getPile().isEmpty())
			{
				if(cardImage.getCard() == currentPile.getPile().peek())
				{
					pileNumber = piles;
					return true;
				}
			}
		}
		
		return false;
	}

}
