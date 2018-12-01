package edu.buffalo.cse116.code.fortyThievesGUI;

import javax.swing.JLayeredPane;
import javax.swing.JTextField;

import edu.buffalo.cse116.code.fortyThieves.FortyThievesGame;
import edu.buffalo.cse116.code.fortyThieves.FortyThievesStock;
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
	public FortyThievesLayeredPanel()
	{
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
}
