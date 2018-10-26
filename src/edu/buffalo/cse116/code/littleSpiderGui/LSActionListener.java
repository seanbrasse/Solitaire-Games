package edu.buffalo.cse116.code.littleSpiderGui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLayeredPane;

import edu.buffalo.cse116.code.Card;

public class LSActionListener implements ActionListener{
	
	private Card card;
	
	/**
	 * This should help to get the references needed for the tableau and homecell piles.
	 */
	private JLayeredPane lslp;
	
	public LSActionListener(JLayeredPane lslp) {
		this.lslp = lslp;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	
	
	

}
