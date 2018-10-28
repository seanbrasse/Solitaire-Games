package edu.buffalo.cse116.code.golfGUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Makes changes to model through
 * interactions with homecell piles.
 * 
 * @author William F. Nicholson
 *
 */
public class GolfHomecellListener implements MouseListener
{
	/**
	 * View the controller will manuipulate
	 */
	private GolfLayeredPanel pane;
	
	/**
	 * Allow mouse listener to get values from game.
	 * @param pane
	 */
	public GolfHomecellListener(GolfLayeredPanel pane)
	{
		this.pane = pane;
	}
	
	/**
	 * On mouse click, tell the user they can't do anything to the homecell pile.
	 */
	@Override
	public void mouseClicked(MouseEvent e)
	{
		pane.getTextField().setText("Cannot move cards from homecell pile");
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
