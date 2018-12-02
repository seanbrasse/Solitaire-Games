package edu.buffalo.cse116.code.fortyThievesGUI;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

import edu.buffalo.cse116.code.fortyThieves.FortyThievesTableau;
import edu.buffalo.cse116.code.gui.CardImage;

/**
 * Makes changes to model through
 * interactions with tableau piles.
 * 
 * @author William F. Nicholson
 *
 */
public class FortyThievesTableauListener implements MouseListener
{
	/**
	 * Parent pile the source card belongs to.
	 */
	private FortyThievesTableau tableauPile;
	/**
	 * View for controller to manipulate.
	 */
	private FortyThievesLayeredPanel pane;
	/**
	 * Prior solution for card selection involved boarder coloring. Legacy code...
	 */
	private static final Border SELECTED_BORDER = BorderFactory.createLineBorder(Color.BLACK, 1);
	/**
	 * Prior solution for card selection involved boarder coloring. Legacy code...
	 */
	private static final Border UNSELECTED_BORDER = BorderFactory.createEmptyBorder(0, 0, 0, 0);
	/**
	 * Important field for allowing for proper tableau pile to be assigned to source card.
	 */
	private int pileNumber;
	
	/**
	 * Construct new listener and pass view to controller.
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
						pane.repaint();
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
		}
		
		else
		{
			pane.getTextField().setText("Can only select top card");
			return;
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
	
	/**
	 * Helper method to prevent cards in tableau pile
	 * from being selected when not applicable.
	 * 
	 * @param cardImage
	 * @return whether card in question is top of stack.
	 */
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
	
	/**
	 * While utilized, no effects of this code is utilized anyone. Legacy code?...
	 * 
	 * @param label
	 */
	public static void select(CardImage label)
	{
		label.setBorder(SELECTED_BORDER);
		label.repaint();
	}
	
	/**
	 * While utilized, no effects of this code is utilized anyone. Legacy code?...
	 * 
	 * @param label
	 */
	public static void unselect(CardImage label)
	{
		label.setBorder(UNSELECTED_BORDER);
		label.repaint();
	}
}
