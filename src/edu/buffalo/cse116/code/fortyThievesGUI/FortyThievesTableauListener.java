package edu.buffalo.cse116.code.fortyThievesGUI;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

import edu.buffalo.cse116.code.fortyThieves.FortyThievesTableau;
import edu.buffalo.cse116.code.gui.CardImage;

public class FortyThievesTableauListener implements MouseListener
{
	/**
	 * 
	 */
	private FortyThievesTableau tableauPile;
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
	 */
	private static final Border UNSELECTED_BORDER = BorderFactory.createEmptyBorder(0, 0, 0, 0);
	/**
	 * 
	 */
	private int pileNumber;
	
	/**
	 * 
	 * @param pane
	 */
	public FortyThievesTableauListener(FortyThievesLayeredPanel pane)
	{
		this.pane = pane;
		this.pileNumber = -1;
		this.tableauPile = null;
	}
	
	@Override
	public void mouseClicked(MouseEvent e)
	{
		CardImage cardImage = (CardImage)e.getSource();
		
		if(isCardTopOfPile(cardImage))
		{
			tableauPile = pane.getGame().getGameTableauPiles().get(pileNumber);
			
			if(pane.getSelectedCard() == null)
			{
				if(tableauPile.isRemovingCardLegal())
				{
					pane.setSelectedCard(tableauPile.removeCard(), cardImage, tableauPile);
					select(cardImage);
					return;
				}
				
				else
				{
					return;
				}
			}
			
			else
			{
				if(pane.getSelectedCardImage().equalCardValue(((CardImage)e.getSource()).getCard()))
				{
					pane.returnSelectedCard();
					pane.redrawLayeredPanel();
				}
				
				else if(tableauPile.isAddingCardLegal(pane.getSelectedCard()))
				{
					tableauPile.addCard(pane.getSelectedCard());
					pane.setSelectedCard(null, null, (FortyThievesTableau)null);
				}
				
				else
				{
					pane.returnSelectedCard();
					pane.redrawLayeredPanel();
				}
			}
		}
		
		pane.redrawLayeredPanel();
//		CardImage cardImage = (CardImage)e.getSource();
//
//		if(isCardTopOfPile(cardImage))
//		{
//			tableauPile = pane.getGame().getGameTableauPiles().get(pileNumber);
//			
//			if(pane.getSelectedCard() != null)
//			{
//				if(tableauPile.isAddingCardLegal(pane.getSelectedCard()))
//				{
//					tableauPile.addCard(pane.getSelectedCard());
//					pane.setSelectedCard(null, null, (FortyThievesTableau)null);
//				}
//				
//				else
//				{
//					pane.returnSelectedCard();
//				}
//			}
//			
//			else
//			{
//				if(e.getSource() != pane.getSelectedCardImage() && tableauPile.isRemovingCardLegal())
//				{
//					pane.setSelectedCard(tableauPile.removeCard(), (CardImage)e.getComponent(), tableauPile);
//					select((CardImage)e.getComponent());
//					return;
//				}
//				
//				else
//				{
//					
//				}
//			}
//		}
//		
//		pane.redrawLayeredPanel();
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
	
	public boolean isCardTopOfPile(CardImage cardImage)
	{
		for(int piles=0; piles<pane.getGame().getGameTableauPiles().size(); piles++)
		{
			FortyThievesTableau currentPile = pane.getGame().getGameTableauPiles().get(piles);
			
			if(!currentPile.getPile().isEmpty())
			{
				if(cardImage.getCard() == currentPile.getPile().peek())
				{
					pileNumber = piles;
					return true;
				}
			}
		}
		
		return false;
	}
	
	public static void select(CardImage label)
	{
		label.setBorder(SELECTED_BORDER);
		label.repaint();
	}
	
	public static void unselect(CardImage label)
	{
		label.setBorder(UNSELECTED_BORDER);
		label.repaint();
	}
}
