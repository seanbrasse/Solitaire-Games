package edu.buffalo.cse116.code.golfGui;

import java.util.ArrayList;


import javax.swing.JLayeredPane;

import edu.buffalo.cse116.code.golf.GolfStock;
import edu.buffalo.cse116.code.gui.CardImage;

/**
 * Creates the 'area' of the game frame that will hold the stock of the cards, cards will be actually stackable
 * due to using the JLayeredPane where 1, 2,.. n, n+1. card at height n+1 is the top card.
 * @author andrewquinonez
 *
 */
public class GolfStockPile {

	/**
	 * A reference to the JLayeredPane class from which this object is being called. It's of type JLayeredPane instead of
	 * LSLayeredPane, so we only get the necessary methods, such as 'add' to the container, 'setLocation' of our cards, etc.
	 */
	private JLayeredPane glp;

	/**
	 * A reference to GolfStock
	 */
	private GolfStock stock;

	/**
	 * The 'x' coordinate from which we will start drawing the 'stack' of cards to represent the pile.
	 * Ex: AH will be '150, 600' Then the next card on top of it will be placed '150, 570' to leave enough room to show the card 
	 * underneath.
	 */
	private int x;

	/**
	 * The 'y' coordinate for the first card. that will be used for the initial base. Since Swing coordinate system starts 0,0 as the
	 * top left of the screen, we'll need a high value to have it on the bottom of the screen.
	 */
	private int y;

	/**
	 * The 'z' coordinate of the first card. This is going to be 0 but will be used to keep track of the height of the card.
	 * 0 means bottom and n + 1 means it's on a position on top of 'n'.
	 */
	private int z;

	/**
	 * A full list of card images so we can assign from Stack<Card> homecell to an image to display accordingly.
	 */
	private ArrayList<CardImage> cardImages;

	public GolfStockPile(JLayeredPane glp, GolfStock stock, ArrayList<CardImage> cardImages) {
		this.glp = glp;
		this.stock = stock;
		this.cardImages = cardImages;
		x=500;
		y=600; 
		drawStockPile(cardImages);
		
	}

	public void drawStockPile(ArrayList<CardImage> cardImages) {
		int tempY = y; // 97 height of the card 
		int tempZ = z;
		for(int i = 0; i < stock.size(); i++) {
			for(int j = 0; j < cardImages.size(); j++) {
				if(cardImages.get(j).equalCardValue(stock.getStockPile().get(i))) {
					//Draw with 'x' , y , z. Then increment x and y for the next one. 
					//Remember we are only displaying the cards, the game logic classes take care of deciding if it can be added
					//we just do the actual showing of it.

					//commented the line out underneath for testing, if the homecells appear then that line won't be necessary
					CardImage ci = cardImages.get(j);
					ci.setBounds(x, tempY, ci.getImageIcon().getIconWidth(), ci.getImageIcon().getIconHeight());
					ci.setLocation(x, tempY);

					//tempZ = tempZ - 2; 

					glp.add(ci, new Integer(i)); 

				}
			}			
		}



	}
}
