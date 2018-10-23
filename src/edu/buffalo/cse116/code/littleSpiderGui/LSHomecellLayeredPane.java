package edu.buffalo.cse116.code.littleSpiderGui;

import java.util.ArrayList;
import java.util.Stack;
import javax.swing.JLayeredPane;
import edu.buffalo.cse116.code.Card;
import edu.buffalo.cse116.code.gui.CardImage;

/**
 * Create a homecell pile for our card. 
 * @author andrewquinonez
 *
 */
public class LSHomecellLayeredPane extends JLayeredPane{
	
	private CardImage bottomCard;
	private ArrayList<CardImage> card;
	
	/**
	 * Will take our pile and then create container for the cards that are returned.
	 * @param pile
	 */
	public LSHomecellLayeredPane(CardImage bottomCard) {
		//assign the properties, size, colors, action listener.
		

		
		this.bottomCard = bottomCard;
	}
	
	/**
	 * Assign the placement of the cards
	 */

}
