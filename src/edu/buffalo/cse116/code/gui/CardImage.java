package edu.buffalo.cse116.code.gui;

import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import edu.buffalo.cse116.code.Card;

/**
 * Assigns a Card to it's according image and any extra information that may be needed.
 * The picture is held in a JLabel so for easier implementation this class is a child of JLabel.
 * @author Andrew Quinonez
 *
 */
public class CardImage extends JLabel{
	
	/**
	 * Where we'll store our card.
	 */
	private Card card;
	
	/**
	 * Where we'll hold our corresponding card image
	 */
	private ImageIcon cardImage;
	
	
	
	/**
	 * Takes a Card and finds the corresponding image of the card and stores that information in this (JLabel child) class.
	 * @param card
	 */
	public CardImage(Card card) {	
		this.card = card;
		cardImage = setCardImage(); 	
		setIcon(cardImage);
	}
	

	/**
	 * Find the corresponding card to each Card object
	 * @return image icon for the card
	 */
	private ImageIcon setCardImage () {
		ImageIcon retVal;
		String imgLoc = "resources/Cards/"; //String imageLocation
		
			if(card.getRank() > 0 && card.getRank() < 10) {
				int rank = card.getRank();
				imgLoc = imgLoc + (rank + 1);
				
				//Checks for the suit
				if(card.getSuit() == 0) {
					imgLoc = imgLoc + "c.gif";
				} else if(card.getSuit() == 1) {
					imgLoc = imgLoc + "d.gif";
				} else if(card.getSuit() == 2) {
					imgLoc = imgLoc + "h.gif";
				} else if(card.getSuit() == 3) {
					imgLoc = imgLoc + "s.gif";
				} else {
					
				}
				
			} else if( card.getRank() == 0) { //Checks if the card is an Ace
				imgLoc = imgLoc + "a" ;
				int suit = card.getSuit();
				
				if(suit == 0) {
					imgLoc = imgLoc + "c.gif";
				} else if(suit == 1) {
					imgLoc = imgLoc + "d.gif";
				} else if(suit == 2) {
					imgLoc = imgLoc + "h.gif";
				} else if(suit == 3) {
					imgLoc = imgLoc + "s.gif";
				} else {
					
				}
			} else if(card.getRank() == 10) { //Checks if the card is a Jack
				imgLoc = imgLoc + "j";
				
				if(card.getSuit() == 0) {
					imgLoc = imgLoc + "c.gif";
				} else if(card.getSuit() == 1) {
					imgLoc = imgLoc + "d.gif";
				} else if(card.getSuit() == 2) {
					imgLoc = imgLoc + "h.gif";
				} else if(card.getSuit() == 3) {
					imgLoc = imgLoc + "s.gif";
				} else {
					
				}
				
			} else if(card.getRank() == 11) { //Checks if the card is a Queen
				imgLoc = imgLoc + "q";
				
				if(card.getSuit() == 0) {
					imgLoc = imgLoc + "c.gif";
				} else if(card.getSuit() == 1) {
					imgLoc = imgLoc + "d.gif";
				} else if(card.getSuit() == 2) {
					imgLoc = imgLoc + "h.gif";
				} else if(card.getSuit() == 3) {
					imgLoc = imgLoc + "s.gif";
				} else {
					
				}
				
			} else if(card.getRank() == 12) { //Checks if the card is a King
				imgLoc = imgLoc + "k";
				
				if(card.getSuit() == 0) {
					imgLoc = imgLoc + "c.gif";
				} else if(card.getSuit() == 1) {
					imgLoc = imgLoc + "d.gif";
				} else if(card.getSuit() == 2) {
					imgLoc = imgLoc + "h.gif";
				} else if(card.getSuit() == 3) {
					imgLoc = imgLoc + "s.gif";
				} else {
					
				}
			} else {
				// Would/Could throw an exception b/c this card's rank is 'invalid' for standard game of cards
			}
		retVal = new ImageIcon(imgLoc);
		
		return retVal;
	}
	
	/**
	 * Sets the blank green card for Golf's initial blank Tableau
	 * @return Image icon for the card
	 */
	private ImageIcon setGreenCardImage() {
		ImageIcon retVal;
		String imgLoc = "resources/Cards/"; 
		imgLoc = imgLoc + "green.gif";
		retVal = new ImageIcon(imgLoc);
		return retVal;
	}
	
	/**
	 * Returns the Card of this object to check rank and suit of the card in the ActionListener.
	 * @return card.
	 */
	public Card getCard() {
		return card;
	}
	
	public ImageIcon getImageIcon() {
		return cardImage;
	}
	
	/**
	 * Returns the Golf initial Green Homecell card
	 */
	public ImageIcon getGreenImageIcon() {
		return setGreenCardImage();
	}
	
	/**
	 * When placing cards, we need to make sure the correct card is being assigned. Such as the initial 4 cards in the
	 * homecell for LS. This will take a card and see if the card is the same, if not, then returns false
	 * @param card
	 * @return true if the card is the correct card on the 'card' image.
	 */
	public boolean equalCardValue(Card card) {
		if(this.card.getRank() == card.getRank() && this.card.getSuit() == card.getSuit()) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Pass the mouse listener for the corresponding game
	 * @param ml
	 */
	public void setMouseListenerForLS(MouseListener ml) {
		addMouseListener(ml);
	}
	
	

}
