package edu.buffalo.cse116.code.golfGui;

import java.util.ArrayList;

import javax.swing.JLayeredPane;

import edu.buffalo.cse116.code.Card;
import edu.buffalo.cse116.code.golf.GolfGame;
import edu.buffalo.cse116.code.golf.GolfHomecell;
import edu.buffalo.cse116.code.gui.CardImage;


public class GolfLayeredPaneGame extends JLayeredPane  {
	
	/**
	 * The instance of the game to access the cards, tableau and homecell piles
	 */
	
	GolfGame game;
	
	/**
	 * A  copy of the game deck so we can use it to initially set the value of each card 
	 */
	
	ArrayList<Card> copyGameDeck;
//	ArrayList<GolfHomecell> homecells;
	
	/**
	 * Hold an image of each card
	 */
	
	ArrayList<CardImage> cardImages;
	
	/**
	 * The logic for checking on the Homecell piles
	 */
	HomecellCardPile hcPicturePile;
	
	public GolfLayeredPaneGame() {
		game = new GolfGame(); //instantiates Golf game session, cards are shuffled.
		cardImages = new ArrayList<CardImage>(); //instantiates the list
		//hcPicturePile = new HomecellCardPile(GolfHomecell c);
	}
	
	/**
	 * Creates an arraylist (cardImages) of 52 CardImage objects, i.e. the whole deck.
	 */
	
	public void assignAllCardImages() {
		for(int i = 0; i < copyGameDeck.size(); i++) {
			CardImage cardImage = new CardImage(copyGameDeck.get(i)); //assign each card an image
			cardImages.add(cardImage);
		}
		
	}
	
	/**
	 * Creates the location of where tableaus are placed
	 */
	
	public void initialTableauPlacement() {
		//card image size is 73x97
		
	}
	
	/**
	 * 
	 * @author Andrew Quinonez
	 *
	 */
	
	private class HomecellCardPile {
		//x coord
		private int x;
		//y coord
		private int y;
		//z coord
		private int z;
		
	/**
	 * A reference to the homecell to get the current cards on that homecell
	 */
		
	private GolfHomecell homecell;
	
	/**
	 * The current cards that will be viewed, will be in this list and will be updated based on the 
	 * homecell reference above.
	 */
	
	private ArrayList<CardImage> currentCards;
	
	/**
	 *Only one homecell pile
	 * No need anymore
	 */
	//private int pileNumber;
	
	public HomecellCardPile(GolfHomecell homecell) {
		this.homecell = homecell;
		setCoordsForHCPile();
	}
	
	/**
	 * Sets the coords for the one homecell pile.
	 * Edited to account for one pile
	 */
	private void setCoordsForHCPile() {
			x = 375;	
			// x is set to 375 as its the halfway point and there is only one homecell pile. 
			//The y and z value per card will change
		}
	}
	
	/**
	 * Will be called when the Y coordinate of where the card is going to be placed with respect to where 
	 * it's in the homecell pile for the logic rules of the game.
	 * @return the y coordinate value for the card image
	 */
	private int setYcardImage() {
		return 0;
	}
	
	/**
	 * Will be called when the Z coordinate of where the card is going to be placed with respect to where 
	 * it's in the homecell pile for the logic rules of the game.
	 * @return
	 */
	private int setZcardImage() {
		return 0;
	}

	
	
	
	


}



