package edu.buffalo.cse116.code.fortyThievesGUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

import edu.buffalo.cse116.code.fortyThieves.FortyThievesHomecell;
import edu.buffalo.cse116.code.fortyThieves.FortyThievesTableau;
import edu.buffalo.cse116.code.gui.CardImage;

public class FortyThievesHomecellListener implements MouseListener
{
	/**
	 * 
	 */
	private FortyThievesHomecell homecellPile;
	/**
	 * 
	 */
	private FortyThievesLayeredPanel pane;
	/**
	 * 
	 */
	private static final Border UNSELECTED_BORDER = BorderFactory.createEmptyBorder(0, 0, 0, 0);
	
	/**
	 * 
	 */
	public FortyThievesHomecellListener(FortyThievesLayeredPanel pane, FortyThievesHomecell homecellPile)
	{
		this.pane = pane;
		this.homecellPile = homecellPile;
	}
	
	@Override
	public void mouseClicked(MouseEvent e)
	{
		if(pane.getSelectedCard() == null)
		{
			
		}
		
		else
		{
			if(homecellPile.isAddingCardLegal(pane.getSelectedCard()))
			{
				homecellPile.addCard(pane.getSelectedCard());
				pane.setSelectedCard(null, null, (FortyThievesTableau)null);
			}
			
			else
			{
				
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
	
	public static void unselect(CardImage label)
	{
		label.setBorder(UNSELECTED_BORDER);
		label.repaint();
	}
}
