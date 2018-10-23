package edu.buffalo.cse116.code.littleSpiderGui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLayeredPane;

import edu.buffalo.cse116.code.Card;
import edu.buffalo.cse116.code.gui.CardImage;

/**
 * Hold the connection between each part of the project potentially.
 * @author andrewquinonez
 *
 */
public class LSTableauLayeredPane extends JLayeredPane {
	
	//Use a list to hold the selected card, if the card is already contained in the list, then it's unselected
	ArrayList<Card> heldCards = new ArrayList<Card>();
	
	/*
	 * ****************************************NOTE ****************************************
	 * This class ended up being for testing purposes, can be deleted, just a place holder for putting things on the GUI
	 * for understanding.
	 */
	
	private int paneWidth;
	private int paneHeight;
	
	private int paneX;
	private int paneY;
	
	public LSTableauLayeredPane() {
		paneWidth = 600; //not final
		paneHeight = 500; //not final
			
		//The commented out code was used for testing purposes and are just for reference, can be deleted if you want.
		CardImage ci = new CardImage(new Card(2, 12));
		
		CardImage ci2 = new CardImage(new Card(0,0));
		
		
		ci.setBounds(300,300, ci.getCardImage().getIconWidth(), ci.getCardImage().getIconHeight());
		ci.setLocation(300, 300);
		ci2.setBounds(500,150, ci.getCardImage().getIconWidth(), ci.getCardImage().getIconHeight());
		
		add(ci, 0);
		add(ci2, 1);

		//addLayeredPane(); //testing
		
		
		this.setBorder(BorderFactory.createTitledBorder("helloooo"));
		this.setPreferredSize(new Dimension(paneWidth/2, paneHeight));
		
		
		//this.setBounds(500,350, 300, 200);
		
		//setBackground(Color.cyan);
		//setOpaque(true);
		//setBoundes()
	}

	public void addLayeredPane() {
		JLayeredPane jlp = new JLayeredPane();
		
	
		//jlp.setBackground(Color.cyan);
		//jlp.setOpaque(true);
		jlp.setBounds(700, 500, 100, 100);
		jlp.setBorder(BorderFactory.createTitledBorder("diiimelo"));
		
		//CardImage ci3 = new CardImage(new Card(3,5), paneWidth, paneHeight);
		//ci3.setBounds(75,75, ci3.getCardImage().getIconWidth(), ci3.getCardImage().getIconHeight());
		//jlp.add(ci3, 0);
		
		add(jlp, 0);
		
		new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		};
		
	}
	

}
