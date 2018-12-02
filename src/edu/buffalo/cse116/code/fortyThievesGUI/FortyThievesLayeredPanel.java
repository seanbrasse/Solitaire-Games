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
 * Layered pane which draws and redraws
 * each of forty thieves's piles. Also instantiates
 * new game of forty thieves and wires control listeners.
 * 
 * @author William F. Nicholson
 */
@SuppressWarnings("serial")
public class FortyThievesLayeredPanel extends JLayeredPane
{
	/**
	 * Model the controller will manuipulate.
	 */
	private FortyThievesGame fortyThievesGame;
	/**
	 * Error messages will be displayed here.
	 */
	private JTextField errorBox;
	/**
	 * A hack solution to selecting cards, cards that can be selected
	 * as per model logic will be assigned here to be drawn on the bottom
	 * left corner of the container.
	 */
	private Card selectedCard;
	/**
	 * Accompanying the selected card, a reference to its pile is made,
	 * such that should the card need to be returned to its pile, doing so
	 * would not require searching through the entirety of the model.
	 */
	private Tableau selectedTabelauPile;
	/**
	 * Because multiple piles may be selected, there are two seperate
	 * pile types that need to be checked for, and can be assigned via.
	 * method overloading. Must check which pile is null or assigned.
	 */
	private FortyThievesWaste selectedWastePile;
	/**
	 * Accompanying the selected card, a reference to its card image is
	 * made, such that all card components are present for any possible
	 * opporation needed to be executed.
	 */
	private CardImage selectedCardImage;
	
	/**
	 * Constructs a new layered pane.
	 * Instantiates fields with new values.
	 */
	public FortyThievesLayeredPanel()
	{
		selectedCard = null;
		fortyThievesGame = new FortyThievesGame();
		errorBox = new JTextField();
		drawLayeredPanel();
	}
	
	/**
	 * Display top card of stock pile,
	 * add drawn object to layered pane.
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
	 * Display top card of waste pile,
	 * add drawn object to layered pane.
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
	 * Iterate through each tableau pile, draw
	 * each card onto the layered panel.
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
	 * Iterate through each homecell pile, draw
	 * each top card onto the layered panel.
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
	 * Draw the textbox, add it to the
	 * layered pane.
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
	 * Drawing selected card onto
	 * the layered pane, should there be one.
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
	 * draws all piles, the textbox, and the selected card,
	 * should it exist.
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
	 * redraws all piles, the textbox, and the selected card,
	 * should it exist.
	 */
	public void redrawLayeredPanel()
	{
		this.removeAll();
		this.revalidate();
		this.drawLayeredPanel();
	}
	
	/**
	 * Returns the textbox such that controllers
	 * can update the text inside it.
	 * 
	 * @return View's JTextField
	 */
	public JTextField getTextField()
	{
		return errorBox;
	}
	
	/**
	 * Returns the model such that controllers
	 * can make logic checks and update the model
	 * as needed.
	 * 
	 * @return Model created in the LayeredPane view.
	 */
	public FortyThievesGame getGame()
	{
		return this.fortyThievesGame;
	}
	
	/**
	 * Return the selected card for controller checks.
	 * 
	 * @return View's selected card.
	 */
	public Card getSelectedCard()
	{
		return this.selectedCard;
	}
	
	/**
	 * Return the selected card image for drawing or checks
	 * 
	 * @return View's selected card image.
	 */
	public CardImage getSelectedCardImage()
	{
		return this.selectedCardImage;
	}
	
	/**
	 * Return the selected card stack for controller checks
	 * and returning the selected card to its original stack.
	 * 
	 * @return View's selected card stack.
	 */
	public Tableau getSelectedCardStack()
	{
		return this.selectedTabelauPile;
	}
	
	/**
	 * Ensure that when selecting a card, access to piles and image are passed
	 * 
	 * @param card
	 * @param cardImage
	 * @param tableau
	 */
	public void setSelectedCard(Card card, CardImage cardImage, Tableau tableau)
	{
		this.selectedTabelauPile = tableau;
		this.selectedCardImage = cardImage;
		this.selectedCard = card;
		redrawLayeredPanel();
		
	}
	
	/**
	 * We can select cards from tableau or waste pile, so let us overload the method accordingly.
	 * 
	 * @param card
	 * @param cardImage
	 * @param waste
	 */
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
