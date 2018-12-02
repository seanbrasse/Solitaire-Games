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
