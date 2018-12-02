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
		if(pane.getSelectedCard() != null)
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
		
		else
		{
			if(wastePile.isRemoveLegal())
			{
				pane.setSelectedCard(wastePile.getWastePile().pop(), (CardImage)e.getComponent(), wastePile);
				pane.redrawLayeredPanel();
			}
			
			else
			{
				pane.returnSelectedCard();
				pane.redrawLayeredPanel();
				pane.getTextField().setText("Illegal Move");
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
	
	public static void select(CardImage label)
	{
		label.setBorder(SELECTED_BORDER);
		label.repaint();
	}
}
