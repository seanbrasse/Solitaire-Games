package edu.buffalo.cse116.code.golfGUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import edu.buffalo.cse116.code.golf.GolfHomecell;
import edu.buffalo.cse116.code.golf.GolfStock;

/**
 * Makes changes to model through
 * interactions with stock piles.
 * 
 * @author William F. Nicholson
 *
 */
public class GolfStockListener implements MouseListener
{
	/**
	 * Game's stock pile.
	 */
	private GolfStock stockPile;
	/**
	 * Game's homecell pile.
	 */
	private GolfHomecell homecellPile;
	/**
	 * View the controller with manipulate.
	 */
	private GolfLayeredPanel pane;
	
	/**
	 * Allow mouse listener to manuipulate values.
	 * @param pane
	 */
	public GolfStockListener(GolfLayeredPanel pane)
	{
		this.pane = pane;
		stockPile = pane.getGame().getStock();
		homecellPile = pane.getGame().getGameHomecellPile();
	}
	
	/**
	 * If move is legal, change model and redraw view.
	 */
	@Override
	public void mouseClicked(MouseEvent e)
	{
		System.out.println("click registered");
		
		if(stockPile.isRemoveCardLegal())
		{
			homecellPile.addCardFromStock(stockPile.removeTopCard());
		}
		
		pane.redrawLayeredPanel();
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

}
