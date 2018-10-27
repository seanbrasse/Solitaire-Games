package edu.buffalo.cse116.code.littleSpiderGui;

import java.util.ArrayList;

import javax.swing.JLayeredPane;

import edu.buffalo.cse116.code.Card;
import edu.buffalo.cse116.code.gui.CardImage;
import edu.buffalo.cse116.code.littleSpider.LittleSpiderGame;
import edu.buffalo.cse116.code.littleSpider.LittleSpiderHomecell;
import edu.buffalo.cse116.code.littleSpider.LittleSpiderTableau;

/**
 * This is going to be the actual class to pull the logic and what the GUI displays here.
 * @author Andrew Quinonez
 *
 */
public class LSLayeredPaneGame extends JLayeredPane {
	
	/**
	 * Instantiates the game logic for homecells and tableau piles for LS.
	 */
	private LittleSpiderGame lsg;
	
	/**
	 * Arraylist of the 52 card images
	 */
	private ArrayList<CardImage> cardImages;
	
	/**
	 * We'll have four homecellPiles so we need the ArrayList to hold them.
	 */
	private ArrayList<LSHomecellPile> homecellPiles;
	
	/**
	 * Here will be the LSTableauPile class once it's made. Made LShomecellPiles first b/c LS starts with creating homecell piles first.
	 */
	private ArrayList<LSTableauPile> tableauPiles;
	
	/**
	 * Reference to the class to pass everything of importantance to the Action Listener class.
	 */
	private LSActionListener lsActionListener; //There may need to be some get methods for this to work. Unless we can think of
	//another way to do it.
	
	
	/**
	 * Creates the properties we need for the LayeredPane and instantiates the game logic and then afterwords create the graphical
	 * display based on the game logic. 
	 */
	public LSLayeredPaneGame() {
		lsg = new LittleSpiderGame(); 	
		cardImages = new ArrayList<CardImage>(); //the list that will hold the 52 JLabel (Images) of our cards
		
		
		createCardImages(lsg.getCopyGameDeck());
		instantiateHomecellPiles(lsg.getHomecellPiles(), cardImages); //creates the 4 homecell piles, with their 1 initial card.
		instantiateTableauPiles(lsg.getTableauPiles(), cardImages);
//		lsActionListener = new LSActionListener(this);
		
		
		
	}
	
	/**
	 * Assign each card a picture.
	 */
	public void createCardImages(ArrayList<Card> deck) {
		
		//assign each element of the array a card image
		for(int i = 0; i < deck.size(); i++) {
			cardImages.add(new CardImage(deck.get(i), 2));
		}
	}
	
	/**
	 * Instantiate each of the 4 homecell piles 
	 * @param lsh
	 */
	public void instantiateHomecellPiles(ArrayList<LittleSpiderHomecell> lsh, ArrayList<CardImage> cardImages) {
		
		homecellPiles = new ArrayList<LSHomecellPile>();
		for(int i = 0; i < lsh.size(); i++) {
			homecellPiles.add(new LSHomecellPile(this, lsh.get(i), i, cardImages, lsg));
		}
	}
	
	public void instantiateTableauPiles(ArrayList<LittleSpiderTableau> lst, ArrayList<CardImage> cardImages) {
		tableauPiles = new ArrayList<LSTableauPile>();
		for(int i = 0; i < lst.size(); i++) {
			tableauPiles.add(new LSTableauPile(this, lst.get(i), i, cardImages ,lsg));
		}
	}
	
	
	public LittleSpiderGame getLittleSpiderGame() {
		return lsg;
	}
	
	
	
	

}
