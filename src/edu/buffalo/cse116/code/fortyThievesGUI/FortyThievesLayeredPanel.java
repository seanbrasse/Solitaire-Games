package edu.buffalo.cse116.code.fortyThievesGUI;

import java.util.Stack;

import javax.swing.JLayeredPane;
import javax.swing.JTextField;

import edu.buffalo.cse116.code.Card;
import edu.buffalo.cse116.code.fortyThieves.FortyThievesGame;
import edu.buffalo.cse116.code.fortyThieves.FortyThievesStock;
import edu.buffalo.cse116.code.fortyThieves.FortyThievesWaste;
import edu.buffalo.cse116.code.gui.CardImage;
/**
 * 
 * @author william
 *
 */
@SuppressWarnings("serial")
public class FortyThievesLayeredPanel extends JLayeredPane
{
	/**
	 * 
	 */
	private FortyThievesGame fortyThievesGame;
	/**
	 * 
	 */
	private JTextField errorBox;
	/**
	 * 
	 */
	private Card selectedCard;
	/**
	 * 
	 */
	private Stack<Card> selectedCardPile;
	
	/**
	 * 
	 */
	public FortyThievesLayeredPanel()
	{
		selectedCard = null;
		fortyThievesGame = new FortyThievesGame();
		errorBox = new JTextField();
		drawLayeredPanel();
	}
	
	/**
	 * 
	 */
	public void drawStockPile()
	{
		FortyThievesStock pile = fortyThievesGame.getGameStockPile();
		CardImage newCardImage = null;
		int xCoordinate = 450;
		int yCoordinate = 500;
		int imageWidth = 0;
		int imageHight = 0;
		
		if(!pile.getStock().isEmpty())
		{
			newCardImage = new CardImage(pile.getStock().peek());
			imageWidth = newCardImage.getImageIcon().getIconWidth();
			imageHight = newCardImage.getImageIcon().getIconHeight();
			
			newCardImage.setBounds(xCoordinate, yCoordinate, imageWidth, imageHight);
			newCardImage.setLocation(xCoordinate, yCoordinate);
			newCardImage.addMouseListener(new FortyThievesStockListener(this));
			this.add(newCardImage, Integer.valueOf(1));
		}
	}
	
	/**
	 * 
	 */
	public void drawWastePile()
	{
		FortyThievesWaste pile = fortyThievesGame.getGameWastePile();
		CardImage newCardImage = null;
		int xCoordinate = 450;
		int yCoordinate = 500;
		int imageWidth = 0;
		int imageHight = 0;
		
		if(!pile.getWastePile().isEmpty())
		{
			newCardImage = new CardImage(pile.getWastePile().peek());
			imageWidth = newCardImage.getImageIcon().getIconWidth();
			imageHight = newCardImage.getImageIcon().getIconHeight();
			
			newCardImage.setBounds(xCoordinate, yCoordinate, imageWidth, imageHight);
			newCardImage.setLocation(xCoordinate, yCoordinate);
			newCardImage.addMouseListener(new FortyThievesWasteListener(this));
			this.add(newCardImage, Integer.valueOf(1));
		}
	}
	
	/**
	 * 
	 */
	public void drawTableauPiles()
	{
		
	}
	
	/**
	 * 
	 */
	public void drawHomecellPile()
	{
		
	}
	
	/**
	 * 
	 */
	public void drawTextBox()
	{
		int xCoordinate = 800;
		int yCoordinate = 500;
		int width = 350;
		int height = 75;
		errorBox.setBounds(xCoordinate, yCoordinate, width, height);
		errorBox.setLocation(xCoordinate, yCoordinate);
		errorBox.setText("Error box.");
		this.add(errorBox);
	}
	
	/**
	 * 
	 */
	public void drawLayeredPanel()
	{
		drawStockPile();
		drawWastePile();
		drawTableauPiles();
		drawHomecellPile();
		drawTextBox();
	}
	
	/**
	 * 
	 */
	public void redrawLayeredPanel()
	{
		this.removeAll();
		this.drawLayeredPanel();
	}
	
	/**
	 * 
	 * @return
	 */
	public JTextField getTextField()
	{
		return errorBox;
	}
	
	/**
	 * 
	 * @return
	 */
	public FortyThievesGame getGame()
	{
		return this.fortyThievesGame;
	}
	
	/**
	 * 
	 * @return
	 */
	public Card getSelectedCard()
	{
		return this.selectedCard;
	}
	
	/**
	 * 
	 * @param card
	 */
	public void setSelectedCard(Card card, Stack<Card> stack)
	{
		this.selectedCardPile = stack;
		this.selectedCard = card;
	}
	
	/**
	 * Returns selected card to its stack such that when the board is redrawn upon
	 * some action listener firing, it is possible to preserve board state.
	 */
	public void returnSelectedCard()
	{
		if(this.selectedCard != null)
		{
			this.selectedCardPile.push(selectedCard);
		}
		
		this.selectedCardPile = null;
		this.selectedCard = null;
	}
}
