package edu.buffalo.cse116.code.golfGui;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import edu.buffalo.cse116.code.Card;
import edu.buffalo.cse116.code.golf.GolfGame;
import edu.buffalo.cse116.code.golf.GolfHomecell;
import edu.buffalo.cse116.code.golf.GolfTableau;
import edu.buffalo.cse116.code.gui.CardImage;

//import edu.buffalo.cse116.code.littleSpiderGui.LSLPgame.HomecellCardPile;


public class GolfLayeredPaneGame extends JLayeredPane  {
	
	/**
	 * Instantiates the game logic for homecells and tableau piles for LS.
	 */
	private GolfGame golfG;
	
	/**
	 * Arraylist of the 52 card images
	 */
	private ArrayList<CardImage> cardImages;
	
	/**
	 * Here will be the GolfTableauPile class once it's made. Made GolfTableauPiles first b/c Golf starts with creating Tableau piles first.
	 */
	private ArrayList<GolfTableauPile> tableauPiles;
	
	private GolfHomecell ghc;
	
	/**
	 * We have one homecellPile.
	 */
	private GolfHomecellPile homecellPile;
	//private ArrayList<LSHomecellPile> homecellPiles;
	
	
	
	/**
	 * Creates the properties we need for the LayeredPane and instantiates the game logic and then afterwords create the graphical
	 * display based on the game logic. 
	 */
	public GolfLayeredPaneGame() {
		golfG = new GolfGame(); 	
		ghc=new GolfHomecell();
		cardImages = new ArrayList<CardImage>(); //the list that will hold the 52 JLabel (Images) of our cards
		CardImage green=new CardImage(new Card(0,0));
		green.setIcon(green.getGreenImageIcon());
		homecellPile = new GolfHomecellPile(this, ghc, cardImages, green);
		
		createCardImages(golfG.getCopyGameDeck());
		//instantiateHomecellPiles(lsg.getHomecellPiles(), cardImages); //creates the 4 homecell piles, with their 1 initial card.
		instantiateTableauPiles(golfG.getGameTableauPiles(), cardImages);
		
	} 
	
	/**
	 * Assign each card a picture.
	 */
	public void createCardImages(ArrayList<Card> deck) {
		//assign each element of the array a card image
		for(int i = 0; i < deck.size(); i++) {
			cardImages.add(new CardImage(deck.get(i)));
		}
		setCardImage();
		}
	
	//Instantiates homecell pile with empty green slot
	private ImageIcon setCardImage() {
		ImageIcon retVal;
		String imgLoc = "resources/Cards/"; 
		imgLoc = imgLoc + "green.gif";
		retVal = new ImageIcon(imgLoc);
		return retVal;
	}
//	/**
//	 * Instantiate each of the 4 homecell piles 
//	 * @param lsh
//	 */
//	public void instantiateHomecellPiles(ArrayList<LittleSpiderHomecell> lsh, ArrayList<CardImage> cardImages) {
//		
//		homecellPiles = new ArrayList<LSHomecellPile>();
//		for(int i = 0; i < lsh.size(); i++) {
//			homecellPiles.add(new LSHomecellPile(this, lsh.get(i), i, cardImages));
//		}
//	}
	
	public void instantiateTableauPiles(ArrayList<GolfTableau> gt, ArrayList<CardImage> cardImages) {
		tableauPiles = new ArrayList<GolfTableauPile>();
		for(int i = 0; i < gt.size(); i++) {
			tableauPiles.add(new GolfTableauPile(this, gt.get(i), i, cardImages));
		}
	}
	
	
	
	
	
	
	

	
}



