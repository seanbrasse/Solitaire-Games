package edu.buffalo.cse116.code.fortyThievesGUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import edu.buffalo.cse116.code.fortyThieves.FortyThievesStock;

/**
 * 
 * @author william
 *
 */
public class FortyThievesStockListener implements MouseListener
{
	/**
	 * 
	 */
	private FortyThievesStock stockPile;
	/**
	 * 
	 */
	private FortyThievesLayeredPanel pane;	
	/**
	 * 
	 * @param pane
	 */
	public FortyThievesStockListener(FortyThievesLayeredPanel pane)
	{
		this.pane = pane;
		this.stockPile = pane.getGame().getGameStockPile();
	}

	/**
	 * If one can remove a card from the stock pile, check if there is a
	 * selected card, if so, return the selected card and redraw, else,
	 * pop off stock pile which adds to waste.
	 * 
	 * @param e
	 */
	@Override
	public void mouseClicked(MouseEvent e)
	{
		System.out.println("click registered");
		
		if(pane.getSelectedCard() != null)
		{
			//cannot add to stock, return selected card.
			pane.returnSelectedCard();
		}
		
		else
		{
			if(stockPile.isRemovingCardLegal())
			{
				stockPile.removeCard();
			}
		}
		
		pane.redrawLayeredPanel();
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		
	}
}
