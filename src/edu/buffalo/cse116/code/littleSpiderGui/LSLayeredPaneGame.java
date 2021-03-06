package edu.buffalo.cse116.code.littleSpiderGui;

import java.util.ArrayList;

import javax.swing.JLayeredPane;
import javax.swing.JTextField;

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
	private LSMouseListener lsMouseListener;
	
	/**
	 * The JTextField that will also be our box for putting error messages.
	 */
	private JTextField errorBox;
	
	
	/**
	 * Creates the properties we need for the LayeredPane and instantiates the game logic and then afterwords create the graphical
	 * display based on the game logic. 
	 */
	public LSLayeredPaneGame() {
		
		lsg = new LittleSpiderGame(); 	
		
		lsMouseListener = new LSMouseListener(this,lsg);
		cardImages = new ArrayList<CardImage>(); //the list that will hold the 52 JLabel (Images) of our cards
		
		
		createCardImages(lsg.getCopyGameDeck());
		
		instantiateHomecellPiles(lsg.getHomecellPiles(), cardImages); //creates the 4 homecell piles, with their 1 initial card.
		instantiateTableauPiles(lsg.getTableauPiles(), cardImages);
		
		//set up error box here
		errorBox = new JTextField();
		drawErrorBox();
		
	}
	
	/**
	 * Set up and draw the error text box.
	 */
	private void drawErrorBox() {
		int xCoordinate = 800;
		int yCoordinate = 650;
		int width = 350;
		int height = 75;
		errorBox.setBounds(xCoordinate, yCoordinate, width, height);
		errorBox.setLocation(xCoordinate, yCoordinate);
		errorBox.setText("Error box.");
		this.add(errorBox);
	}
	
	/**
	 * Returns the errorBox.
	 * @return the errorBox.
	 */
	public JTextField getErrorBox() {
		return this.errorBox;
	}
		
	/**
	 * Assign each card a picture.
	 */
	public void createCardImages(ArrayList<Card> deck) {
		
		//assign each element of the array a card image
		for(int i = 0; i < deck.size(); i++) {
			CardImage cardImage = new CardImage(deck.get(i));
			cardImage.setMouseListenerForLS(lsMouseListener);
			cardImages.add(cardImage);			
		}
	}
	
	/**
	 * Instantiate each of the 4 LSHomecellPile classes
	 * @param lsh
	 */
	public void instantiateHomecellPiles(ArrayList<LittleSpiderHomecell> lsh, ArrayList<CardImage> cardImages) {
		
		homecellPiles = new ArrayList<LSHomecellPile>();
		for(int i = 0; i < lsh.size(); i++) {
			homecellPiles.add(new LSHomecellPile(this, lsh.get(i), i, cardImages, lsg));
		}
	}
	
	/**
	 * Instantiate each of the 8 LSTableauPile classes
	 * @param lst
	 * @param cardImages
	 */
	public void instantiateTableauPiles(ArrayList<LittleSpiderTableau> lst, ArrayList<CardImage> cardImages) {
		tableauPiles = new ArrayList<LSTableauPile>();
		for(int i = 0; i < lst.size(); i++) {
			tableauPiles.add(new LSTableauPile(this, lst.get(i), i, cardImages ,lsg));
		}
	}
	
	
	/**
	 * Returns the reference to the ArrayList that contains all the necessary images of our cards.
	 * @return cardImages the ArrayList of all our card images.
	 */
	public ArrayList<CardImage> getCardImages(){
		return cardImages;
	}
	
	
	

}
