package edu.buffalo.cse116.code.golfGUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import edu.buffalo.cse116.code.golf.GolfHomecell;
import edu.buffalo.cse116.code.golf.GolfTableau;
import edu.buffalo.cse116.code.gui.CardImage;

public class GolfTableauListener implements MouseListener
{
	private GolfLayeredPanel pane;
	private GolfHomecell homecellPile;
	private GolfTableau tableauPile;
	private int pileNumber;
	
	public GolfTableauListener(GolfLayeredPanel pane)
	{
		this.pane = pane;
		pileNumber = -1;
	}
	
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
