package edu.buffalo.cse116.code.fortyThievesGUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import edu.buffalo.cse116.code.fortyThieves.FortyThievesStock;
import edu.buffalo.cse116.code.fortyThieves.FortyThievesWaste;

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
	 * 
	 * @param e
	 */
	@Override
	public void mouseClicked(MouseEvent e)
	{
		System.out.println("click registered");
		
		if(stockPile.isRemovingCardLegal())
		{
			stockPile.removeCard();
		}
		
		pane.redrawLayeredPanel();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
