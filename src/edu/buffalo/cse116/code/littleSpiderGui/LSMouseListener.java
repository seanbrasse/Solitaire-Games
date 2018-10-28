package edu.buffalo.cse116.code.littleSpiderGui;

import java.awt.Color;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

import edu.buffalo.cse116.code.Card;
import edu.buffalo.cse116.code.gui.CardImage;
import edu.buffalo.cse116.code.littleSpider.LittleSpiderGame;
import edu.buffalo.cse116.code.littleSpider.LittleSpiderHomecell;
import edu.buffalo.cse116.code.littleSpider.LittleSpiderTableau;

public class LSMouseListener implements MouseListener{
	
	/**
	 * The first card that is clicked.
	 */
	public CardImage cardClicked;
	
	/**
	 * The second card that is clicked.
	 */
	public CardImage targetCardClicked;
	
	/**
	 * This should help to get the references needed for the tableau and homecell piles.
	 */
	private LSLayeredPaneGame lslp;
	
	/**
	 * Reference to the game logic we'll need for the action listeners.
	 */
	private LittleSpiderGame lsg; 
	
	/**
	 * The pile number that the card is from, if it's tableau or homecell.
	 */
	private Integer cardPileNumber; //0 - 3 is for homecell, 0 - 7 is for tableau
	
	/**
	 * The pile number for the targeted card that is clicked (2nd card that is clicked)
	 * if it's from homecell or tableau
	 */
	private Integer targetCardPileNumber; 
	
	/**
	 * To know which tableau pile the card was found in
	 */
	private Integer tableauPileNumber;
	
	/**
	 * To know which homecell pile the card was found in
	 */
	private Integer homecellPileNumber;
	
	
	/**
	 * Passes in a reference to the LSLayeredPaneGame and the logic for the game.
	 * @param lslp
	 * @param lsg
	 */
	public LSMouseListener(LSLayeredPaneGame lslp, LittleSpiderGame lsg) {
		this.lslp = lslp;
		this.lsg = lsg;
		cardPileNumber = null;
		targetCardPileNumber = null;
		
		
	}
	
	/**
	 * Creates the border for cards that are unselected, i.e. no border.
	 */
	private static final Border UNSELECTED_BORDER = BorderFactory.createEmptyBorder(0, 0, 0, 0);
	
	/**
	 * Adds a black line around the selected card.
	 */
	private static final Border SELECTED_BORDER = BorderFactory.createLineBorder(Color.BLACK, 1);

	/**
	 * Puts the border around a card.
	 * @param cardImage that will have a border put on.
	 */
    public static void select(CardImage cardImage) {
      cardImage.setBorder(SELECTED_BORDER);
      cardImage.repaint();
    }

    
    /**
     * Takes a card and puts the "unselect" border on a cardImage
     * @param cardImage the card we will "unselect".
     */
    public static void unselect(CardImage cardImage) {
      cardImage.setBorder(UNSELECTED_BORDER);
      cardImage.repaint();
    }

    /**
     * Takes the clicked cards and checks if the action that can be done on them is valid.
     */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
			
		CardImage ci = (CardImage) e.getSource();
		
		
		if(cardClicked == null) {
			cardClicked = ci;
			
			select(cardClicked);
			lslp.getErrorBox().setText("Error box.");
			
		}  else if(cardClicked != null && cardClicked.equals(ci)) {
			unselect(cardClicked);
			cardClicked = null;
			
		}  else if(cardClicked != null && targetCardClicked == null) {
			
			targetCardClicked = ci;
			select(targetCardClicked);
			
			littleSpiderLogic();
			setLocationForAllCards();
			
			unselect(cardClicked);
			unselect(targetCardClicked);
			
			cardClicked = null;
			targetCardClicked = null;
			
		} else {
			cardClicked = null;
			targetCardClicked = null;
		}
		
		
		
	}
	
	/**
	 * Little spider logic
	 */
		public void littleSpiderLogic() {
		
		if(isCardInTableau(cardClicked.getCard())) {
			cardPileNumber = tableauPileNumber; //so we know which tableau pile the first clicked card is in (0-7)
			
			
			if(isCardInTableau(targetCardClicked.getCard())) {
				targetCardPileNumber = tableauPileNumber; //so we know in which tableau pile the target card is in
				
				
				if(cardClicked.getCard().canBuild(targetCardClicked.getCard())) {
					Card card = cardClicked.getCard();
					lsg.getTableauPiles().get(cardPileNumber).getPile().pop(); //'pop' the first clicked card off it's tableau pile
					lsg.getTableauPiles().get(targetCardPileNumber).getPile().push(card); //and 'push' it onto this pile
					
					//Now print each card that is in the new pile
					
					

					
				} else if(cardClicked.getCard().canWrap(targetCardClicked.getCard())) {
					Card card = cardClicked.getCard();
					lsg.getTableauPiles().get(cardPileNumber).getPile().pop();
					lsg.getTableauPiles().get(targetCardPileNumber).getPile().push(card);
					
					
					
					
					
				} else {
					lslp.getErrorBox().setText("Illegal move: tableau to tableau.");
				}
			} else if(isCardInHomecell(targetCardClicked.getCard())) {
				targetCardPileNumber = homecellPileNumber; //so we know which homecell pile the 2nd card is in
				System.out.println("The second card is in homecell");
				
				
				if(cardClicked.getCard().getSuit() == targetCardClicked.getCard().getSuit()) {
					
					
					if(cardClicked.getCard().canBuildUp(targetCardClicked.getCard())) {
						Card card = cardClicked.getCard();
						lsg.getTableauPiles().get(cardPileNumber).getPile().pop();
						lsg.getHomecellPiles().get(targetCardPileNumber).getHomecellPile().push(card);
	
					}else if(cardClicked.getCard().canBuildDown(targetCardClicked.getCard())) {
						System.out.println("Trying to build down clubs and spades");
						Card card = cardClicked.getCard();
						lsg.getTableauPiles().get(cardPileNumber).getPile().pop();
						lsg.getHomecellPiles().get(targetCardPileNumber).getHomecellPile().push(card);
			
					} else {
						lslp.getErrorBox().setText("Illegal move: tableau to homecell");
					}
				} else {
					lslp.getErrorBox().setText("Illegal move: tableau to homecell");
				}
			}
		} else if(isCardInHomecell(cardClicked.getCard())) {
			cardPileNumber = homecellPileNumber; //to know which homecell pile the first card is in
			
			
			if(lsg.getHomecellPiles().get(cardPileNumber).isRemovingCardLegal()) {
				
				if(isCardInTableau(targetCardClicked.getCard())) {
					targetCardPileNumber = tableauPileNumber;
					
					
					if(cardClicked.getCard().canBuild(targetCardClicked.getCard())) {
						Card card = cardClicked.getCard();
						lsg.getHomecellPiles().get(cardPileNumber).getHomecellPile().pop();
						lsg.getTableauPiles().get(targetCardPileNumber).getPile().push(card);
						
						
						
						
					} else if(cardClicked.getCard().canWrap(targetCardClicked.getCard())) {
						Card card = cardClicked.getCard();
						lsg.getHomecellPiles().get(cardPileNumber).getHomecellPile().pop();
						lsg.getTableauPiles().get(targetCardPileNumber).getPile().push(card);
						
						
					} else {
						lslp.getErrorBox().setText("Illegal move: can't");
					}
				} else if(isCardInHomecell(targetCardClicked.getCard())) {
					lslp.getErrorBox().setText("Illegal move: homecell to homecell");
					
				}
			}
				
		}
		
		
		
		
		
	}

	
	/**
	 * Checks if the card that you clicked is the top of the tableau pile.
	 * @param card
	 * @return
	 */
	private boolean isCardInTableau(Card card) {
		
		ArrayList<LittleSpiderTableau> tableauLogicPiles = lsg.getTableauPiles();
		for(int i = 0; i < tableauLogicPiles.size(); i++) {
			Stack<Card> tableauPile = tableauLogicPiles.get(i).getPile();
			
			if(card == tableauPile.peek()) {
				tableauPileNumber = new Integer(i);
				System.out.println("Found card in tableau: " + card.getRank() + " , " + card.getSuit());
				return true;
			}
		}		
		System.out.println("Couldn't find card in tableau: " + card.getRank() + " , " + card.getSuit());
		return false;
	}
	
	/**
	 * Checks if the card you clicked is the top card of the homecell.
	 * @param card
	 * @return
	 */
	private boolean isCardInHomecell(Card card) {
		ArrayList<LittleSpiderHomecell> homecellLogicPiles = lsg.getHomecellPiles();
		
		for(int i = 0; i < homecellLogicPiles.size(); i++) {
			Stack<Card> homecellPile = homecellLogicPiles.get(i).getHomecellPile();
			
			if(card == homecellPile.peek()) {
				homecellPileNumber = new Integer(i);
				System.out.println("Found card in homecell: " + card.getRank() + " , " + card.getSuit());
				return true;
			}
		}
		System.out.println("Coouldn't find card in homecell:" + card.getRank() + " , " + card.getSuit());
		return false;
	}
	
	

	/**
	 * Calls the two methods that repositions all the cards
	 */
	public void setLocationForAllCards() {
		reLocateHomecellPiles();
		reLocateTableauPiles();
		
	}
	
	/**
	 * Reposisitions all the cards that should be on a homecell.
	 */
	public void reLocateHomecellPiles() {
		ArrayList<LittleSpiderHomecell> homecellPiles = lsg.getHomecellPiles();
		
		int xSpacing = 250;
		int zSpacing = 0;
		
		//gets each homecell pile (4)
		for(int i = 0; i < homecellPiles.size(); i++) {
			Stack<Card> homecell = homecellPiles.get(i).getHomecellPile();
			
			//gets the amount of elements in the specific pile, 'i'
			for(int j = 0; j < homecell.size(); j++) {
				
				//looks through each card image to find one that matches that corresponding card
				for(int k = 0; k < lslp.getCardImages().size(); k++) {
					Card card = homecell.get(j);
					
					//The image card we are checking for a match:
					CardImage cardImage = lslp.getCardImages().get(k);
					
					if(cardImage.getCard() == card) {
						cardImage.setBounds(xSpacing, 500, cardImage.getIcon().getIconWidth(), cardImage.getIcon().getIconHeight());
						lslp.setLayer(cardImage, zSpacing);
					}
				}
				zSpacing++;			
			}
			xSpacing+= 200;
			zSpacing = 0;
		}	
	}
	
	
	/**
	 * Repositions cards that are in the tableau to reflect the current game logic
	 */
	public void reLocateTableauPiles() {
		ArrayList<LittleSpiderTableau> tableauPiles = lsg.getTableauPiles();
		
		
		int xSpacing = 200;
		int ySpacing = 50;
		int zSpacing = 0;
		
		//go through each of the tableau piles
		for(int i = 0; i < tableauPiles.size(); i++) {
			Stack<Card> tableauPile = tableauPiles.get(i).getPile();
			
			//Go through a single tableau pile
			for(int j = 0; j < tableauPile.size(); j++) {
				
				//Go through each CardImage
				for(int k = 0; k < lslp.getCardImages().size(); k++) {
					
					//the current card in this tableau pile
					Card card = tableauPile.get(j);
					
					//the current CardImage in this tableau pile
					CardImage cardImage = lslp.getCardImages().get(k);
					
					if(cardImage.getCard() == card) {
						cardImage.setBounds(xSpacing, ySpacing, cardImage.getIcon().getIconWidth(), cardImage.getIcon().getIconHeight());
						lslp.setLayer(cardImage, zSpacing);
						System.out.println(zSpacing);
						zSpacing++;
						System.out.println(zSpacing);
					}				
				}				
				ySpacing+= 23;				
			}
			zSpacing = 0;
			ySpacing = 50;
			xSpacing += 100;
		}
	}

	/**
	 * Not used.
	 * @param e
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub	
	}
	
	/**
	 * Not used.
	 * @param e
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	/**
	 * Not used.
	 * @param e
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub		
	}
	/**
	 * Not used.
	 * @param e
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub		
	}
}
