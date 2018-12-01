package edu.buffalo.cse116.code.fortyThievesGUI;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

import edu.buffalo.cse116.code.fortyThieves.FortyThievesWaste;
import edu.buffalo.cse116.code.gui.CardImage;

/**
 * 
 * @author william
 *
 */
public class FortyThievesWasteListener implements MouseListener
{
	/**
	 * 
	 */
	private FortyThievesWaste wastePile;
	/**
	 * 
	 */
	private FortyThievesLayeredPanel pane;
	/**
	 * 
	 */
	private static final Border SELECTED_BORDER = BorderFactory.createLineBorder(Color.BLACK, 1);
	
	/**
	 * 
	 * @param pane
	 */
	public FortyThievesWasteListener(FortyThievesLayeredPanel pane)
	{
		this.pane = pane;
		this.wastePile = pane.getGame().getGameWastePile();
	}
	
	/**
	 * 
	 */
	@Override
	public void mouseClicked(MouseEvent e)
	{
		System.out.println("click registered");
		
		if(pane.getSelectedCard() != null)
		{
			//cannot add selected card to waste, return selected card.
			pane.returnSelectedCard();
		}
		
		else
		{
			if(wastePile.isRemoveLegal())
			{
				pane.setSelectedCard(wastePile.getWastePile().pop(), wastePile.getWastePile());
				select((CardImage)e.getComponent());
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
	
	public static void select(CardImage label)
	{
		label.setBorder(SELECTED_BORDER);
		label.repaint();
	}
}
