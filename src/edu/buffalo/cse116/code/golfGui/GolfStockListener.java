package edu.buffalo.cse116.code.golfGUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import edu.buffalo.cse116.code.golf.GolfHomecell;
import edu.buffalo.cse116.code.golf.GolfStock;

public class GolfStockListener implements MouseListener
{
	private GolfStock stockPile;
	private GolfHomecell homecellPile;
	private GolfLayeredPanel pane;
	
	public GolfStockListener(GolfLayeredPanel pane)
	{
		this.pane = pane;
		stockPile = pane.getGame().getStock();
		homecellPile = pane.getGame().getGameHomecellPile();
	}

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
