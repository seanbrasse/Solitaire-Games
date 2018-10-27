package edu.buffalo.cse116.code.golfGui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

import edu.buffalo.cse116.code.Card;
import edu.buffalo.cse116.code.golf.GolfGame;
import edu.buffalo.cse116.code.gui.CardImage;


public class GolfActionListener implements ActionListener, MouseListener{
	
	public static ArrayList<CardImage> clickedCards;
	
	private Card card;
	
	/**
	 * This should help to get the references needed for the tableau and homecell piles.
	 */
	private GolfLayeredPaneGame glp;//most likely delete
	
	private GolfGame gG; //somewhat  likely to delete
	
	private boolean clicked;
	
	public GolfActionListener() {
		clicked = false;
		
	}
	
	
//	 private static final Border UNSELECTED_BORDER = BorderFactory.createEmptyBorder(0, 0, 0, 0);
//	 private static final Border SELECTED_BORDER = BorderFactory.createLineBorder(Color.BLACK, 1);
	 private static final Border UNSELECTED_BORDER = BorderFactory.createEmptyBorder(1, 1, 1, 1);
	 private static final Border SELECTED_BORDER = BorderFactory.createMatteBorder(5/2,5/2,5/2,5/2, Color.BLACK);

	    public static void select(CardImage label) {
	      label.setBorder(SELECTED_BORDER);
	      label.repaint();
	    }

	    public static void unselect(CardImage label) {
	      label.setBorder(UNSELECTED_BORDER);
	   
	      label.repaint();
	    }
	    
//	    public void borderGreen(CardImage label) {
//		      label.setBorder(SELECTED_BORDER);
//		      label.repaint();
//		    }

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(clicked == false) {
			clicked = true;
			CardImage ci = (CardImage) e.getSource();
			select(ci);
		} else {
			clicked = false;
			CardImage ci = (CardImage) e.getSource();
			unselect(ci);
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
