package edu.buffalo.cse116.code.littleSpiderGui;

import java.util.ArrayList;


import javax.swing.JLayeredPane;

import edu.buffalo.cse116.code.Card;
import edu.buffalo.cse116.code.gui.CardImage;
import edu.buffalo.cse116.code.littleSpider.LittleSpiderGame;
import edu.buffalo.cse116.code.littleSpider.LittleSpiderHomecell;

/**
 * Will instantiate the placement of cards, the card logic from phase 1 will be instantiated (and 
 * listeners placed here?) 
 * 
 * I have some experimential private classes at the bottom, leaning towards it being in the final build, just
 * needs to be improved upon.
 * 
 * @author Andrew Quinonez
 *
 */
public class LSLPgame extends JLayeredPane {
	
	/**
	 * The instance of the game to access the cards, tableau and homecell piles
	 */
	LittleSpiderGame game;
	
	/**
	 * A  copy of the game deck so we can use it to initially set the value of each card 
	 */
	ArrayList<Card> copyGameDeck;
	ArrayList<LittleSpiderHomecell> homecells;
	
	/**
	 * Hold an image of each card
	 */
	ArrayList<CardImage> cardImages;
	
	/**
	 * The logic for checking on the Homecell piles
	 */
	ArrayList<HomecellCardPile> hcPicturePiles;
	
	
	
	
	public LSLPgame() {
		game = new LittleSpiderGame(); //instantiate game session, cards get randomized
		cardImages = new ArrayList<CardImage>(); //the list is instantiated
		
		homecells = game.getHomecellPiles(); //the four homecells are in this pile 
		hcPicturePiles = new ArrayList<HomecellCardPile>();
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
	 * Creates the space for the first 4 homecell cards
	 */
	public void initialHomecellPlacement() {
		//The starting position on the screen is 0,0 which is the top left of the screen
		//the initial placements of each homecell pile will start at (150, 800), (300, 800), (450, 800), (600, 800)
		
		for(int i = 0; i < homecells.size(); i++) {
			for (int j = 0; j < cardImages.size(); i++) {
				
				if(cardImages.get(j).equalCardValue(homecells.get(i).getHomecellPile().peek())) {
					hcPicturePiles.add(new HomecellCardPile(homecells.get(i), i));
				}
			}
		}		
	}
	
	/**
	 * Creates the location of wher
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
		//x coord, depending on which pile it is
		private int x;
		//y coord
		private int y;
		//z coord
		private int z;
		
		
		/**
		 * A reference to the homecell to get the current cards on that homecell
		 */
		private LittleSpiderHomecell homecell;
		
		/**
		 * The current cards that will be viewed, will be in this list and will be updated based on the 
		 * homecell reference above.
		 */
		private ArrayList<CardImage> currentCards;
		
		/**
		 * Since there's 4 piles, we need to know which pile is being used so we know which coords will be used
		 * from 0 - 3 to keep consistent with index values.
		 */
		private int pileNumber;
		
		public HomecellCardPile(LittleSpiderHomecell homecell, int pileNumber) {
			this.homecell = homecell;
			setCoordsForPileNumber(pileNumber);
		}
		
		/**
		 * Sets the coords that will be used depending which number homecell pile this is.
		 */
		private void setCoordsForPileNumber(int pileNumber) {
			if(pileNumber == 0) {
				x = 150;	// So for example: if its 0, then the cards for the first pile will only
				//be placed in this x coordinate spot, but the y and z value per card will change
			} else if(pileNumber == 1) {
				x = 300;
			} else if(pileNumber == 2) {
				x = 450;
			} else if(pileNumber == 3) {
				x = 600;
			} else {
				//something is wrong otherwise since there should only be 4  piles.
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

}
