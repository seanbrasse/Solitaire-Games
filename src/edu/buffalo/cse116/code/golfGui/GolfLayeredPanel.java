package edu.buffalo.cse116.code.golfGUI;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;

import edu.buffalo.cse116.code.golf.GolfGame;
import edu.buffalo.cse116.code.golf.GolfHomecell;
import edu.buffalo.cse116.code.golf.GolfStock;
import edu.buffalo.cse116.code.golf.GolfTableau;
import edu.buffalo.cse116.code.gui.CardImage;

@SuppressWarnings("serial")
public class GolfLayeredPanel extends JLayeredPane
{
	private GolfGame golfGame;
	private JTextField errorBox;
	
	public GolfLayeredPanel()
	{
		golfGame = new GolfGame();
		errorBox = new JTextField();
		drawLayeredPanel();
	}
	
	public void drawTableauPiles()
	{
		ArrayList<GolfTableau> listOfPiles = this.golfGame.getGameTableauPiles();
		int xPileCoordinate = 100;
		int yCardCoordinate = 75;
		
		for(int pileNumber = 0; pileNumber<listOfPiles.size(); pileNumber++)
		{
			GolfTableau currentPile = listOfPiles.get(pileNumber);
			yCardCoordinate = 75;
			
			for(int cardNumber = 0; cardNumber < currentPile.getPileSize(); cardNumber++)
			{
				CardImage newCardImage = new CardImage(currentPile.getPile().get(cardNumber));
				int imageWidth = newCardImage.getImageIcon().getIconWidth();
				int imageHight = newCardImage.getImageIcon().getIconHeight();
				
				//Only can select card if it is top of the pile
				if(currentPile.getPile().get(cardNumber) == currentPile.getPile().peek())
				{
					newCardImage.setEnabled(true);
				}
				
				else
				{
					newCardImage.setEnabled(false);
				}
				
				newCardImage.setBounds(xPileCoordinate, yCardCoordinate, imageWidth, imageHight);
				newCardImage.setLocation(xPileCoordinate, yCardCoordinate);
				newCardImage.addMouseListener(new GolfTableauListener(this));
				
				this.add(newCardImage, Integer.valueOf(cardNumber));
				yCardCoordinate += 23;
			}
			
			xPileCoordinate += 150;
		}
	}
	
	public void drawHomecellPile()
	{
		GolfHomecell pile = this.golfGame.getGameHomecellPile();
		int xCoordinate = 600;
		int yCoordinate = 500;
		
		if(pile.getGolfHomecellPile().empty())
		{
			JLabel greenCard = new JLabel();
			ImageIcon imageIcon = new ImageIcon("resources/Cards/green.gif");
			greenCard.setIcon(imageIcon);
			greenCard.setBounds(xCoordinate, yCoordinate, imageIcon.getIconWidth(), imageIcon.getIconHeight());
			greenCard.setLocation(xCoordinate, yCoordinate);
			this.add(greenCard, Integer.valueOf(0));
		}
		
		else
		{
			CardImage newCardImage = new CardImage(pile.getGolfHomecellPile().peek());
			int imageWidth = newCardImage.getImageIcon().getIconWidth();
			int imageHight = newCardImage.getImageIcon().getIconHeight();
			
			newCardImage.setBounds(xCoordinate, yCoordinate, imageWidth, imageHight);
			newCardImage.setLocation(xCoordinate, yCoordinate);
			newCardImage.addMouseListener(new GolfHomecellListener(this));
			this.add(newCardImage, Integer.valueOf(1));
		}
	}
	
	public void drawStockPile()
	{
		//Because the stock pile is an ArrayList and not a Stack, we assume top card is at index 0.
		GolfStock pile = this.golfGame.getStock();
		CardImage newCardImage = null;
		int xCoordinate = 450;
		int yCoordinate = 500;
		int imageWidth = 0;
		int imageHight = 0;
		
		if(!pile.getStockPile().isEmpty())
		{
			newCardImage = new CardImage(pile.getStockPile().get(0));
			imageWidth = newCardImage.getImageIcon().getIconWidth();
			imageHight = newCardImage.getImageIcon().getIconHeight();
			
			newCardImage.setBounds(xCoordinate, yCoordinate, imageWidth, imageHight);
			newCardImage.setLocation(xCoordinate, yCoordinate);
			newCardImage.addMouseListener(new GolfStockListener(this));
			this.add(newCardImage, Integer.valueOf(1));
		}
	}
	
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
	
	public void drawLayeredPanel()
	{
		drawTableauPiles();
		drawHomecellPile();
		drawTextBox();
		drawStockPile();
	}
	
	public void redrawLayeredPanel()
	{
		this.removeAll();
		this.drawLayeredPanel();
	}
	
	public JTextField getTextField()
	{
		return errorBox;
	}
	
	public GolfGame getGame()
	{
		return this.golfGame;
	}
}
