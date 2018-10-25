package edu.buffalo.cse116.code.littleSpiderGui;

import java.util.ArrayList;

import javax.swing.JLayeredPane;

import edu.buffalo.cse116.code.littleSpider.LittleSpiderGame;

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
	 * We'll have four homecellPiles so we need the ArrayList to hold them.
	 */
	private ArrayList<LSHomecellPile> homecellPiles;
	
	/**
	 * Here will be the LSTableauPile class ocne it's made. Made LShomecellPiles first b/c LS starts with creating homecell piles first.
	 */
	
	/**
	 * Creates the properties we need for the LayeredPane and instantiates the game logic and then afterwords create the graphical
	 * display based on the game logic. 
	 */
	public LSLayeredPaneGame() {
		lsg = new LittleSpiderGame(); 
		//Next instantiate the graphical display of the homecell hehe.
	}
	
	
	

}
