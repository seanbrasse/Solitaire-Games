package edu.buffalo.cse116.code.gui;

import java.awt.Dimension;
import java.io.File;
import java.net.URL;

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
	 * Takes a card and finds the image of the card and stores that information in this JLabel child class.
	 * @param card
	 */
	public CardImage(Card card) {	
		this.card = card;
		
		cardImage = setCardImage(); 	
		setIcon(cardImage);
		

        //setBounds(layoutWidth/ 2, layoutHeight/2, cardImage.getIconWidth(), cardImage.getIconHeight());
        //this.setBounds(500, 0, cardImage.getIconWidth(), cardImage.getIconHeight()); //coords: (0,0) is the top left corner
        
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
					/*Add if time allows/or required for phase 2, a way to throw an exception if a card of a suit is there
					when it shouldn't be. */
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
					//Read above comment.
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
					//Read above comment about this space.
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
					//Read above comment about this space.
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
					//Read above comment about this space.
				}
			} else {
				// Would/Could throw an exception b/c this card's rank is 'invalid' for standard game of cards
			}
			System.out.println(imgLoc);
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
	
	public ImageIcon getCardImage() {
		return cardImage;
	}

}
