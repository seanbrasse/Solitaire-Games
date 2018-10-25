package edu.buffalo.cse116.code.littleSpiderGui;

import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JLayeredPane;

import edu.buffalo.cse116.code.Card;
import edu.buffalo.cse116.code.gui.CardImage;
import edu.buffalo.cse116.code.littleSpider.LittleSpiderHomecell;


/**
 * Will take in a homecell and then create the graphical display based on the reference to LittleSpiderHomecell we have here.
 * @author Andrew Quinonez.
 *
 */
public class LSHomecellPile {
	
	/**
	 * A reference to the JLayeredPane class from which this object is being called. It's of type JLayeredPane instead of
	 * LSLayeredPane, so we only get the necessary methods, such as 'add' to the container, 'setLocation' of our cards, etc.
	 */
	private JLayeredPane lslp;
	
	/**
	 * Creates the reference to the class, LittleSpiderHomecell
	 */
	private LittleSpiderHomecell lsHomecell;
	
	/**
	 * Creates the reference to the Stack<Card> from 'lsHomecell' so that we can see what cards are there.
	 */
	private Stack<Card> homecell;
	
	/**
	 * Creates the copy of the 'homecell' Stack from above but with CardImage(s) (JLabel subclass) so we already know the order to display.
	 */
	private ArrayList<CardImage> homecellCardImages; //This field may get removed (10/25)
	
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
	 * The initialization will pass through the LSLayeredPane (subclass of JLayeredPane) so we can just add to the pane 
	 * from which this class is being called and do the adding to that container, here.
	 * Assign a reference to the one of the four Homecell piles here.
	 * @param lslp the reference to LSLayeredPaneGame so that we can make changes from here.
	 * @param lsHomecell
	 * @param numHomecell is the number that this homecell is from 0 - 3 (4 total). Ex: the first one will be A of H for numHomecell = 0
	 */
	public LSHomecellPile(JLayeredPane lslp, LittleSpiderHomecell lsHomecell, int numHomecell, ArrayList<CardImage> cardImages) {
		this.lslp = lslp;
		this.lsHomecell = lsHomecell;
		homecell = lsHomecell.getHomecellPile();
		this.cardImages = cardImages;
		setXcoord(numHomecell);
		drawHomecellPile(cardImages);
	}
	
	/**
	 * Creates the x coordinate that will be constant for the homecell pile, with only the y and z value changing per card stacked on top.
	 * @param numHomecell
	 */
	public void setXcoord(int numHomecell) {
		//NOTE: these numbers aren't final.
		if(numHomecell == 0) {
			x = 150;
		} else if(numHomecell == 1) {
			x = 300;
		} else if(numHomecell == 2) {
			x = 450;
		} else if(numHomecell == 3) {
			x = 600;
		} else {
			//Should not be any other, this will be very bad otherwise cuz we'll have a random pile floating in space.
		}
	}
	
	/**
	 * Updates the CardImages to any changes made to 'homecell' from the game logic class.
	 */
	//NOTE: this may not be needed, along with homecellCardImages. b/c we can just scan through a full deck of images
	public void updateHomecellCardImages() {
		
	}
	
	
	/**
	 * Whenever a card gets removed, added to the Stack, the reference will change accordingly. Assuming no threading issues occur, we 
	 * will have the reference Stack<Card> 'homecell' with either a card more, or a card less. Then we'll update the drawing of the
	 * CardImage (JLabel) done here.
	 */
	public void drawHomecellPile(ArrayList<CardImage> cardImages) {
		int tempY = y; // 97 height of the card 
		int tempZ = z;
		for(int i = 0; i < homecell.size(); i++) {
			for(int j = 0; j < cardImages.size(); j++) {
				if(cardImages.get(j).equalCardValue(homecell.get(i))) {
					//Draw with 'x' , y , z. Then increment x and y for the next one. 
					//Remember we are only displaying the cards, the game logic classes take care of deciding if it can be added
					//we just do the actual showing of it.
					
					//commented the line out underneath for testing, if the homecells appear then that line won't be necessary
					CardImage ci = cardImages.get(j);
					ci.setBounds(x, tempY, ci.getImageIcon().getIconWidth(), ci.getImageIcon().getIconHeight());
					ci.setLocation(x, tempY);
					
					tempY = tempY - 23;
					
					lslp.add(ci, new Integer(i));
					
				}
			}
			
		}
	}
	
	
	
	
	

}
