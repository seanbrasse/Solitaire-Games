package edu.buffalo.cse116.code.golfGUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GolfHomecellListener implements MouseListener
{
	private GolfLayeredPanel pane;
	
	public GolfHomecellListener(GolfLayeredPanel pane)
	{
		this.pane = pane;
	}
	
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
