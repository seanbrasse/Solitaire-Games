package edu.buffalo.cse116.code.littleSpiderGui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import edu.buffalo.cse116.code.Card;
import edu.buffalo.cse116.code.gui.CardImage;
import edu.buffalo.cse116.code.littleSpider.LittleSpiderGame;
import edu.buffalo.cse116.code.littleSpider.LittleSpiderHomecell;
import edu.buffalo.cse116.code.littleSpider.LittleSpiderTableau;

public class LSMouseListener implements MouseListener{
	
	public static ArrayList<CardImage> clickedCards;
	
	public CardImage cardClicked;
	
	public CardImage targetCardClicked;
	

	
	/**
	 * This should help to get the references needed for the tableau and homecell piles.
	 */
	private LSLayeredPaneGame lslp;
	
	private LittleSpiderGame lsg; 
	
	/**
	 * Reference to this object because it has the method to draw the cards in the homecell piles
	 */
	private ArrayList<LSHomecellPile> homecellPiles;
	
	/**
	 * Reference to this object because it has the method to draw the cards in the tableau piles
	 */
	private ArrayList<LSTableauPile> tableauPiles;
	
	
	
	/**
	 * The pile number that the card is from, if it's tableau or homecell
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
	
	
	private boolean cardClicked1; //cardClicked
	private boolean cardClicked2; //targetCardClicked
	
	public LSMouseListener(LSLayeredPaneGame lslp, LittleSpiderGame lsg) {
		this.lslp = lslp;
		this.lsg = lsg;
		this.homecellPiles = lslp.getHomecellPiles(); //null points
		this.tableauPiles = lslp.getTableauPiles(); //null points
		cardPileNumber = null;
		targetCardPileNumber = null;
		
		
	}
	
	
	
	 private static final Border UNSELECTED_BORDER = BorderFactory.createEmptyBorder(0, 0, 0, 0);
	 private static final Border SELECTED_BORDER = BorderFactory.createLineBorder(Color.BLACK, 1);

    public static void select(CardImage label) {
      label.setBorder(SELECTED_BORDER);
      label.repaint();
    }

    public static void unselect(CardImage label) {
      label.setBorder(UNSELECTED_BORDER);
   
      label.repaint();
    }

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("CLICKED!!!!");
		
		
		CardImage ci = (CardImage) e.getSource();
		
		
		
		if(cardClicked == null) {
			cardClicked = ci;
			
			select(cardClicked);
			
		}  else if(cardClicked != null && cardClicked.equals(ci)) {
			unselect(cardClicked);
			cardClicked = null;
			
		}  else if(cardClicked != null && targetCardClicked == null) {
			
			targetCardClicked = ci;
			select(cardClicked);
			
			littleSpiderLogic();
			
			unselect(cardClicked);
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
			cardPileNumber = tableauPileNumber; //so we know which tableau pile the first card is in
			
			
			if(isCardInTableau(targetCardClicked.getCard())) {
				targetCardPileNumber = tableauPileNumber; //so we know in which tableau pile the target card is in
				
				
				if(cardClicked.getCard().canBuild(targetCardClicked.getCard())) {
					Card card = cardClicked.getCard();
					lsg.getTableauPiles().get(cardPileNumber).getPile().pop();
					lsg.getTableauPiles().get(targetCardPileNumber).getPile().push(card);
					for(int i = 0; i < lsg.getTableauPiles().get(targetCardPileNumber).getPile().size(); i++) {
						Card card1 = lsg.getTableauPiles().get(targetCardPileNumber).getPile().get(i);
						System.out.println("Rank and suit of card " + i + " in the pile: " + card1.getRank() + " , " + card1.getSuit());
					}
					

					
				} else if(cardClicked.getCard().canWrap(targetCardClicked.getCard())) {
					Card card = cardClicked.getCard();
					lsg.getTableauPiles().get(cardPileNumber).getPile().pop();
					lsg.getTableauPiles().get(targetCardPileNumber).getPile().push(card);
					
					//graphic change
					
					
					
				} else {
					//graphic error
				}
			} else if(isCardInHomecell(targetCardClicked.getCard())) {
				targetCardPileNumber = homecellPileNumber; //so we know which homecell pile the 2nd card is in
				
				
				
				if(cardClicked.getCard().getSuit() == targetCardClicked.getCard().getSuit()) {
					
					if(cardClicked.getCard().canBuildUp(targetCardClicked.getCard())) {
						Card card = cardClicked.getCard();
						
						
						//graphic change
						
						
						
					}else if(cardClicked.getCard().canBuildDown(targetCardClicked.getCard())) {
						Card card = cardClicked.getCard();
						lsg.getTableauPiles().get(cardPileNumber).getPile().pop();
						lsg.getHomecellPiles().get(targetCardPileNumber).getHomecellPile().push(card);
						
						//graphic change
						
						
						
					} else {
						//error
					}
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
						
						//graphic change		
						
						
					} else if(cardClicked.getCard().canWrap(targetCardClicked.getCard())) {
						Card card = cardClicked.getCard();
						lsg.getHomecellPiles().get(cardPileNumber).getHomecellPile().pop();
						lsg.getTableauPiles().get(targetCardPileNumber).getPile().push(card);
						
						//graphic change
						
						
					} else {
						//graphic error
					}
				} else if(isCardInHomecell(targetCardClicked.getCard())) {
					//Error b/c each homecell pile requires the same suit.
					
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
				System.out.println("Found card in tableau");
				return true;
			}
		}		
		System.out.println("Couldn't find card in tableau");
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
				System.out.println("Found card in homecell");
				return true;
			}
		}
		System.out.println("Coouldn't find card in homecell");
		return false;
	}
	
	
	
//	if(numHomecell == 0) {
//		x = 250;
//	} else if(numHomecell == 1) {
//		x = 450;
//	} else if(numHomecell == 2) {
//		x = 650; 
//	} else if(numHomecell == 3) {
//		x = 850;
//	} else {
	
	
	public void setLocationForAllCards() {
		
		
		ArrayList<LittleSpiderHomecell> homecellPiles = lsg.getHomecellPiles();
		ArrayList<LittleSpiderTableau> tableauPiles = lsg.getTableauPiles();
		ArrayList<CardImage> cardImages = lslp.getCardImages();
		
		
		//The x coordinate for each homecell
		int xForHomecell = 250;
		int yForHomecell = 500;
		
		//is placing homecell cards	from LS
		for(int i = 0; i < homecellPiles.size(); i++) {
			Stack<Card> homecellPile = homecellPiles.get(i).getHomecellPile();
			
			for(int j = 0; j < homecellPile.size(); j++) {
				for(int k = 0; k < lslp.getCardImages().size(); k++) {
					if(cardImages.get(k).equalCardValue(homecellPile.get(j))) {
						String cardRank = " " + lslp.getCardImages().get(k).getCard().getRank();
					
						String cardSuit = " " + lslp.getCardImages().get(k).getCard().getSuit();
						
						System.out.println("Rank and suit:" + cardRank + " , " + cardSuit);
						
						
						CardImage ci = lslp.getCardImages().get(k);
						
						ci.setBounds(xForHomecell, yForHomecell, ci.getIcon().getIconWidth(), ci.getIcon().getIconHeight());
						lslp.setLayer(ci, j);
					}
				}
				xForHomecell+=200;
			}
			
		}
		
		//x is the coordinate of the tableau pile, increments by 100 for each tableau pile so the first pile is at 100, 2nd at 200, etc...
		int xForLS = 200;
		
		//z is the coordinate of where the pile starts at (0,0 is the top left of the screen)
		int yForLS = 50;
		//changes the posistion of the tableau piles to accurately represent the game
		for(int i = 0; i < tableauPiles.size(); i++) {
			Stack<Card> tableauPile = tableauPiles.get(i).getPile();
			
			for(int j = 0; j < tableauPile.size(); j++) {
				for(int k = 0; k < lslp.getCardImages().size(); k++) {
					if(cardImages.get(k).equalCardValue(tableauPile.get(j))) {
						CardImage ci = lslp.getCardImages().get(k);
						
						ci.setBounds(xForHomecell, yForLS, ci.getIcon().getIconWidth(), ci.getIcon().getIconHeight());
						lslp.setLayer(ci, j);
						yForLS+=23;
						
					}
				}
				yForLS= 50;
				xForLS+= 100;
			}
			
			
		}
		
		
	}
	
	
	
	

	
	
	
	
	
	
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub	
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub		
	}
	
	
	

}
