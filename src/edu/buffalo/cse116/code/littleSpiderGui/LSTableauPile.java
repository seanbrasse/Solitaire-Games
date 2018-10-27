package edu.buffalo.cse116.code.littleSpiderGui;

import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JLayeredPane;

import edu.buffalo.cse116.code.Card;
import edu.buffalo.cse116.code.gui.CardImage;
import edu.buffalo.cse116.code.littleSpider.LittleSpiderGame;
import edu.buffalo.cse116.code.littleSpider.LittleSpiderHomecell;
import edu.buffalo.cse116.code.littleSpider.LittleSpiderTableau;

public class LSTableauPile {
	/**
	 * A reference to the JLayeredPane class from which this object is being called. It's of type JLayeredPane instead of
	 * LSLayeredPane, so we only get the necessary methods, such as 'add' to the container, 'setLocation' of our cards, etc.
	 */
	private JLayeredPane lslp;
	
	/**
	 * Creates the reference to the class, LittleSpiderHomecell
	 */
	private LittleSpiderTableau lsTableau;
	
	/**
	 * Creates the reference to the Stack<Card> from 'lsHomecell' so that we can see what cards are there.
	 */
	private Stack<Card> tableau;
	
	/**
	 * Creates the copy of the 'homecell' Stack from above but with CardImage(s) (JLabel subclass) so we already know the order to display.
	 */
	private ArrayList<CardImage> tableauCardImages; //This field may get removed (10/25)
	
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
	
	
	/**
	 * Insantiates the tableau piles
	 */
	public LSTableauPile(JLayeredPane lslp, LittleSpiderTableau lsTableau, int numTableau, ArrayList<CardImage> cardImages, LittleSpiderGame lsg) {
		this.lslp = lslp;
		this.lsTableau = lsTableau;
		y = 50;
		tableau = lsTableau.getPile();
		this.cardImages = cardImages;
		setXcoord(numTableau);
		drawTableauPile(cardImages);
		
	}
	
	/**
	 * Creates the x coordinate that will be constant for the homecell pile, with only the y and z value changing per card stacked on top.
	 * @param numTableau
	 */
	public void setXcoord(int numTableau) {
		//NOTE: these numbers aren't final. 73 x 97 card w,h
//		if(numTableau == 0) {
//			x = 100;
//		} else if(numTableau == 1) {
//			x = 175;
//		} else if(numTableau == 2) {
//			x = 225;
//		} else if(numTableau == 3) {
//			x = 300;
//		} else if(numTableau == 4) {
//			x = 450;
//		} else if(numTableau == 5) {
//			x = 525;
//		} else if(numTableau == 6) {
//			x = 675;
//		} else if(numTableau == 7) {
//			x = 750;
//		} else {
//			//Should not be any other, this will be very bad otherwise cuz we'll have a random pile floating in space.
//		}
		
		if(numTableau == 0) {
			x = 200;
		} else if(numTableau == 1) {
			x = 300;
		} else if(numTableau == 2) {
			x = 400;
		} else if(numTableau == 3) {
			x = 500;
		} else if(numTableau == 4) {
			x = 600;
		} else if(numTableau == 5) {
			x = 700;
		} else if(numTableau == 6) {
			x = 800;
		} else if(numTableau == 7) {
			x = 900;
		} else {
			//Should not be any other, this will be very bad otherwise cuz we'll have a random pile floating in space.
		}
	}

	
	/**
	 * Draws the cards corresponding to what the game logic's tableau pile has in it's array of Cards. 
	 * @param cardImages is the array of the images for each card.
	 */
	public void drawTableauPile(ArrayList<CardImage> cardImages) {
		int tempY = y; // 97 height of the card 
		int tempZ = z;
		int topCardValue = tableau.size() - 1;
		for(int i = 0; i < tableau.size(); i++) {
			for(int j = 0; j < cardImages.size(); j++) {
				if(cardImages.get(j).equalCardValue(tableau.get(i))) {
					//Draw with 'x' , y , z. Then increment x and y for the next one. 
					//Remember we are only displaying the cards, the game logic classes take care of deciding if it can be added
					//we just do the actual showing of it.
					
					//commented the line out underneath for testing, if the homecells appear then that line won't be necessary
					CardImage ci = cardImages.get(j);
					
					//This 'if' statement checks if on the nth loop, if the card getting drawn on the frame is a top card for that 
					//tableau pile.
					if(topCardValue == i) {
						ci.setEnabled(true);
					} else {
						ci.setEnabled(false);
					}
					
					
					ci.setBounds(x, tempY, ci.getImageIcon().getIconWidth() + 2, ci.getImageIcon().getIconHeight() + 2);
					ci.setLocation(x, tempY);
					
					tempY = tempY + 23;
					
					lslp.add(ci, new Integer(i)); 
					
				}
			}			
		}
	}
	
	

}
