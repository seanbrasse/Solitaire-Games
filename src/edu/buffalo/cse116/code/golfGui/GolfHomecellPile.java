package edu.buffalo.cse116.code.golfGui;

import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JLayeredPane;

import edu.buffalo.cse116.code.Card;
import edu.buffalo.cse116.code.golf.GolfHomecell;
import edu.buffalo.cse116.code.gui.CardImage;

public class GolfHomecellPile {

	/**
	 * A reference to the JLayeredPane class from which this object is being called. It's of type JLayeredPane instead of
	 * LSLayeredPane, so we only get the necessary methods, such as 'add' to the container, 'setLocation' of our cards, etc.
	 */
	private JLayeredPane lslp;
	
	/**
	 * Creates the reference to the class, LittleSpiderHomecell
	 */
	private GolfHomecell gHomecell;
	
	/**
	 * Creates the reference to the Stack<Card> from 'gHomecell' so that we can see what cards are there.
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
	 * The initialization will pass through the GolfLayeredPaneGame (subclass of JLayeredPane) so we can just add to the pane 
	 * from which this class is being called and do the adding to that container, here.
	 * @param lslp the reference to LSLayeredPaneGame so that we can make changes from here.
	 * @param lsHomecell
	 * @param numHomecell is the number that this homecell is from 0 - 3 (4 total). Ex: the first one will be A of H for numHomecell = 0
	 */
	public GolfHomecellPile(JLayeredPane lslp, GolfHomecell gHomecell, ArrayList<CardImage> cardImages) {
		this.lslp = lslp;
		this.gHomecell = gHomecell;
		y = 600;
		homecell = gHomecell.getGolfHomecellPile();
		this.cardImages = cardImages;
		setXcoord();
		drawHomecellPile(cardImages);
		
	}
	
	/**
	 * Creates the x coordinate that will be constant for the homecell pile, with only the y and z value changing per card stacked on top.
	 * Note that there is only one GolfHomecellPile. The homecell is not placed at the center x coordinate however as it is accompanied by 
	 * the stock pile.
	 * 
	 */
	public void setXcoord() {
		//NOTE: this numbers isn't final.
		x = 600;
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
