package edu.buffalo.cse116.code.fortyThievesGUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

import edu.buffalo.cse116.code.fortyThieves.FortyThievesHomecell;
import edu.buffalo.cse116.code.fortyThieves.FortyThievesTableau;
import edu.buffalo.cse116.code.gui.CardImage;

/**
 * Makes changes to model through
 * interactions with homecell piles.
 * 
 * @author William F. Nicholson
 *
 */
public class FortyThievesHomecellListener implements MouseListener
{
	/**
	 * Homecell pile respective cards belong to.
	 */
	private FortyThievesHomecell homecellPile;
	/**
	 * View the controller will manuipulate
	 */
	private FortyThievesLayeredPanel pane;
	/**
	 * Before having a seperate selected card area, boarders were used to highlight cards.
	 */
	private static final Border UNSELECTED_BORDER = BorderFactory.createEmptyBorder(0, 0, 0, 0);
	
	/**
	 * Constructor assigning model and parent homecell pile.
	 */
	public FortyThievesHomecellListener(FortyThievesLayeredPanel pane, FortyThievesHomecell homecellPile)
	{
		this.pane = pane;
		this.homecellPile = homecellPile;
	}
	
	@Override
	public void mouseClicked(MouseEvent e)
	{
		/**
		 * Cannot remove cards from homecell pile.
		 */
		if(pane.getSelectedCard() == null)
		{
			
		}
		
		else
		{
			/**
			 * When card can be added to homecell pile,
			 * ensure selected card holds null values before redraw.
			 */
			if(homecellPile.isAddingCardLegal(pane.getSelectedCard()))
			{
				homecellPile.addCard(pane.getSelectedCard());
				pane.setSelectedCard(null, null, (FortyThievesTableau)null);
			}
			
			else
			{
				/**
				 * When illegal moves are made, make sure the user knows...
				 */
				
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
	
	/**
	 * Code which, while utilized, was apart of a legacy solution
	 * and who's impact is never seen in the view. 
	 * 
	 * @param label
	 */
	public static void unselect(CardImage label)
	{
		label.setBorder(UNSELECTED_BORDER);
		label.repaint();
	}
}
