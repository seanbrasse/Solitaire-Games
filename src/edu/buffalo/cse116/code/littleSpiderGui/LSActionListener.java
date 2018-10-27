package edu.buffalo.cse116.code.littleSpiderGui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;


import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import edu.buffalo.cse116.code.Card;
import edu.buffalo.cse116.code.gui.CardImage;
import edu.buffalo.cse116.code.littleSpider.LittleSpiderGame;

public class LSActionListener implements ActionListener, MouseListener{
	
	public static ArrayList<CardImage> clickedCards;
	
	private Card card;
	
	/**
	 * This should help to get the references needed for the tableau and homecell piles.
	 */
	private LSLayeredPaneGame lslp;//most likely delete
	
	private LittleSpiderGame lsg; //somewhat  likely to delete
	
	private boolean clicked;
	private String mouse;
	
	public LSActionListener() {
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
