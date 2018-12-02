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
			pane.returnSelectedCard();
			pane.redrawLayeredPanel();
			
			if(pane.getTextField().getText().equals("Illegal Move"))
			{
				pane.getTextField().setText("Dude, the move's illegal...");
			}
			
			else if(pane.getTextField().getText().equals("Dude, the move's illegal..."))
			{
				pane.getTextField().setText("...Can you cut it out? I'm tired of your stupidity");
			}
			
			else if(pane.getTextField().getText().equals("...Can you cut it out? I'm tired of your stupidity"))
			{
				pane.removeAll();
				pane.drawTextBox();
				pane.getTextField().setText("Happy asshole? All you had to do was fucking make a valid move, but now you lost. GAME OVER");
			}
			
			else
			{
				pane.getTextField().setText("Illegal Move");
			}
			
			return;
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
