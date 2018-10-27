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
	
	private Card card;
	
	/**
	 * This should help to get the references needed for the tableau and homecell piles.
	 */
	private LSLayeredPaneGame lslp;
	
	private LittleSpiderGame lsg; 
	
	private LSHomecellPile homecellPile;
	
	private LSTableauPile tableauPile;
	
	private boolean clicked;
	private String mouse;
	
	
	private boolean cardClicked1; //cardClicked
	private boolean cardClicked2; //targetCardClicked
	
	public LSMouseListener(LSLayeredPaneGame lslp, LittleSpiderGame lsg, LSHomecellPile homecellPile, LSTableauPile tableauPile) {
		this.lslp = lslp;
		this.lsg = lsg;
		this.homecellPile = homecellPile;
		this.tableauPile = tableauPile;
	
		clicked = false;
		
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
		}
		
		
		
	}
	
	/**
	 * Little spider logic -- mother fucker!@!@!
	 */
		public void littleSpiderLogic() {
		
		if(isCardInTableau(cardClicked.getCard())) {
			if(isCardInTableau(targetCardClicked.getCard())) {
				if(cardClicked.getCard().canBuild(targetCardClicked.getCard())) {
					
				} else if(cardClicked.getCard().canWrap(targetCardClicked.getCard())) {
					
				} else {
					//error
				}
			} else if(isCardInHomecell(targetCardClicked.getCard())) {
				if(cardClicked.getCard().getSuit() == targetCardClicked.getCard().getSuit()) {
					if(cardClicked.getCard().canBuildUp(targetCardClicked.getCard())) {
						
					}else if(cardClicked.getCard().canBuildDown(targetCardClicked.getCard())) {
						
					} else {
						//error
					}
				}
			}
		} else if(isCardInHomecell(cardClicked.getCard())) {
			if(isCardInTableau(targetCardClicked.getCard())) {
				
			} else if(isCardInHomecell(targetCardClicked.getCard())) {
				
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
				return true;
			}
		}		
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
				return true;
			}
		}
		
		return false;
	}
	
	
	
	

	
	
	
	
	
	
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		this.mouse = "Mouse pressed at : " + e.getX() + ", " + e.getY();
		saySomething("Mouse pressed; # of clicks: "
                + e.getClickCount(), e);
		
	}

	private void saySomething(String string, MouseEvent e) {
		JTextArea textArea = new JTextArea();
		String eventDescription = string;
		String newline = "\n";
		// TODO Auto-generated method stub
		 textArea.append(eventDescription + " detected on "
                + e.getComponent().getClass().getName()
                + "." + newline);
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		saySomething("Mouse released; # of clicks: "
                + e.getClickCount(), e);
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		saySomething("Mouse entered", e);
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		saySomething("Mouse exited", e);
		
	}
	
	
	

}
