package edu.buffalo.cse116.code.littleSpiderGui;

import java.util.ArrayList;


import javax.swing.JFrame;

import edu.buffalo.cse116.code.Card;
import edu.buffalo.cse116.code.gui.CardImage;
import edu.buffalo.cse116.code.littleSpider.LittleSpiderGame;

/**
 * Instantiates the necessary classes to run Little Spider.
 * @author Andrew Quinonez
 *
 */
public class LittleSpiderGUI{
	JFrame frame;
	
	//just a normal copy of the cards
	ArrayList<Card> copyGameDeck;
	//the cards with their corresponding images
	ArrayList<CardImage> imgCardDeck;
	
	//creating the 8 tableau sections on the frame, unless we know another way to do this, we can do that
	LSTableauLayeredPane lst1;
	LSTableauLayeredPane lst2;
	LSTableauLayeredPane lst3;
	LSTableauLayeredPane lst4;
	LSTableauLayeredPane lst5;
	LSTableauLayeredPane lst6;
	LSTableauLayeredPane lst7;
	LSTableauLayeredPane lst8;
	

	public LittleSpiderGUI(JFrame frame) {
		this.frame = frame; //Pass the frame to this class so we can assign the components of the GUI.
		
		LittleSpiderGame lsg = new LittleSpiderGame();//
		
		//Create the image to accompany the corresponding card
		imgCardDeck = new ArrayList<CardImage>();
		copyGameDeck = lsg.getCopyGameDeck();
		assignAllCardImages();
		createHomecellPiles();
		
	}
	
	/**
	 * Will assign each card a picture
	 */
	public void assignAllCardImages() {
		
		
		for(int i = 0; i < copyGameDeck.size(); i++) {
			CardImage cardImage = new CardImage(copyGameDeck.get(i)); //assign each card an image
			imgCardDeck.add(cardImage);
		}
		
	}
	
	/**
	 * Will create the Homecell piles and will be ran first since Homecell is instantiated with 4 cards
	 */
	public void createHomecellPiles() {
		
	}
	
	/**
	 * Will create the 8 necessary Tableau piles with their 6 cards 
	 */
	public void createTableauPiles() {
		
	}
	
	
	
	
}