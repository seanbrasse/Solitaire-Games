package edu.buffalo.cse116.code.fortyThievesGUI;

import java.util.ArrayList;

import javax.swing.JLayeredPane;
import javax.swing.JTextField;

import edu.buffalo.cse116.code.Card;
import edu.buffalo.cse116.code.Tableau;
import edu.buffalo.cse116.code.fortyThieves.FortyThievesGame;
import edu.buffalo.cse116.code.fortyThieves.FortyThievesHomecell;
import edu.buffalo.cse116.code.fortyThieves.FortyThievesStock;
import edu.buffalo.cse116.code.fortyThieves.FortyThievesTableau;
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
	private Tableau selectedTabelauPile;
	/**
	 * 
	 */
	private FortyThievesWaste selectedWastePile;
	/**
	 * 
	 */
	private CardImage selectedCardImage;
	
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
		int xCoordinate = 10;
		int yCoordinate = 10;
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
		int xCoordinate = 100;
		int yCoordinate = 10;
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
		ArrayList<FortyThievesTableau> listOfPiles = this.fortyThievesGame.getGameTableauPiles();
		int xPileCoordinate = 10;
		int yCardCoordinate = 200;
		
		for(int pileNumber = 0; pileNumber<listOfPiles.size(); pileNumber++)
		{
			FortyThievesTableau currentPile = listOfPiles.get(pileNumber);
			yCardCoordinate = 200;
			
			for(int cardNumber = 0; cardNumber < currentPile.getPileSize(); cardNumber++)
			{				
				currentPile.getPile();
				currentPile.getPile().get(cardNumber);
				CardImage newCardImage = new CardImage(currentPile.getPile().get(cardNumber));
				int imageWidth = newCardImage.getImageIcon().getIconWidth();
				int imageHight = newCardImage.getImageIcon().getIconHeight();
				
				newCardImage.setBounds(xPileCoordinate, yCardCoordinate, imageWidth, imageHight);
				newCardImage.setLocation(xPileCoordinate, yCardCoordinate);
				newCardImage.addMouseListener(new FortyThievesTableauListener(this));
				
				this.add(newCardImage, Integer.valueOf(cardNumber));
				/**
				 * Each card in the same pile should be slightly above the other,
				 * to create the appearance of a pile in the GUI.
				 */
				yCardCoordinate += 23;
			}
			/**
			 * At the end of each pile being drawn, the
			 * next pile should be drawn to the right of the last
			 */
			xPileCoordinate += 90;
		}
	}
	
	/**
	 * 
	 */
	public void drawHomecellPile()
	{
		ArrayList<FortyThievesHomecell> listOfPiles = this.fortyThievesGame.getGameHomecellPiles();
		int xPileCoordinate = 260;
		int yCardCoordinate = 10;
		
		for(int pileNumber = 0; pileNumber < listOfPiles.size(); pileNumber ++)
		{
			FortyThievesHomecell currentPile = listOfPiles.get(pileNumber);
			CardImage newCardImage = new CardImage(currentPile.getHomecellPile().peek());
			int imageWidth = newCardImage.getImageIcon().getIconWidth();
			int imageHight = newCardImage.getImageIcon().getIconHeight();
			
			newCardImage.setBounds(xPileCoordinate, yCardCoordinate, imageWidth, imageHight);
			newCardImage.setLocation(xPileCoordinate, yCardCoordinate);
			newCardImage.addMouseListener(new FortyThievesHomecellListener(this, currentPile));
			
			this.add(newCardImage, Integer.valueOf(1));
			xPileCoordinate += 80;
		}
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
	public void drawSelectedCard()
	{
		if(this.selectedCard != null)
		{
			CardImage newCardImage = new CardImage(this.selectedCard);
			
			int xCoordinate = 10;
			int yCoordinate = 470;
			int imageWidth = newCardImage.getImageIcon().getIconWidth();
			int imageHight = newCardImage.getImageIcon().getIconHeight();
			
			newCardImage.setBounds(xCoordinate, yCoordinate, imageWidth, imageHight);
			newCardImage.setLocation(xCoordinate, yCoordinate);
			
			if(this.selectedWastePile == null)
			{
				newCardImage.addMouseListener(new FortyThievesSelectedCardListener(this, (FortyThievesTableau)this.selectedTabelauPile));
			}
			else
			{
				newCardImage.addMouseListener(new FortyThievesSelectedCardListener(this, this.selectedWastePile));
			}
			
			this.add(newCardImage, Integer.valueOf(1));
		}
	}
	
	/**
	 * 
	 */
	public void drawLayeredPanel()
	{
		drawStockPile();
		drawSelectedCard();
		drawWastePile();
		drawHomecellPile();
		drawTextBox();
		drawTableauPiles();
	}
	
	/**
	 * 
	 */
	public void redrawLayeredPanel()
	{
		this.removeAll();
		this.revalidate();
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
	 * @return
	 */
	public CardImage getSelectedCardImage()
	{
		return this.selectedCardImage;
	}
	
	/**
	 * 
	 * @return
	 */
	public Tableau getSelectedCardStack()
	{
		return this.selectedTabelauPile;
	}
	
	/**
	 * 
	 * @param card
	 */
	public void setSelectedCard(Card card, CardImage cardImage, Tableau tableau)
	{
		this.selectedTabelauPile = tableau;
		this.selectedCardImage = cardImage;
		this.selectedCard = card;
		redrawLayeredPanel();
		
	}
	
	public void setSelectedCard(Card card, CardImage cardImage, FortyThievesWaste waste)
	{
		this.selectedWastePile = waste;
		this.selectedCard = card;
		this.selectedCardImage = cardImage;
		redrawLayeredPanel();
	}
	
	/**
	 * Returns selected card to its stack such that when the board is redrawn upon
	 * some action listener firing, it is possible to preserve board state.
	 */
	public void returnSelectedCard()
	{
		if(this.selectedCard != null)
		{
			if(this.selectedTabelauPile != null)
			{
				((FortyThievesTableau)this.selectedTabelauPile).forceAddCard(selectedCard);
			}
			
			else if (this.selectedWastePile != null)
			{
				this.selectedWastePile.getWastePile().add(selectedCard);
			}
		}
		
		this.selectedTabelauPile = null;
		this.selectedWastePile = null;
		this.selectedCardImage = null;
		this.selectedCard = null;
		
		this.redrawLayeredPanel();
	}
}
