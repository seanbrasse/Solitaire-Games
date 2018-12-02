package edu.buffalo.cse116.code.fortyThievesGUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import edu.buffalo.cse116.code.fortyThieves.FortyThievesTableau;
import edu.buffalo.cse116.code.fortyThieves.FortyThievesWaste;

/**
 * Special listener for selected card to hack
 * functionality into this god damned project.
 * 
 * @author William F. Nicholson
 *
 */
public class FortyThievesSelectedCardListener implements MouseListener
{
	/**
	 * View to allow us to manipulate stuff.
	 */
	private FortyThievesLayeredPanel pane;
	
	/**
	 * Constructor for when selecting from waste pile
	 * 
	 * @param pane
	 */
	public FortyThievesSelectedCardListener(FortyThievesLayeredPanel pane, FortyThievesWaste wastePile)
	{
		this.pane = pane;
	}
	
	/**
	 * Constructor for when selecting from tableau pile
	 * 
	 * @param pane
	 * @param tableauPile
	 */
	public FortyThievesSelectedCardListener(FortyThievesLayeredPanel pane, FortyThievesTableau tableauPile)
	{
		this.pane = pane;
	}
	
	@Override
	public void mouseClicked(MouseEvent e)
	{
		this.pane.returnSelectedCard();
		this.pane.redrawLayeredPanel();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	
}
