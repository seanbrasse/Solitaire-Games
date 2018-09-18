package edu.buffalo.cse116.code;

import java.util.ArrayList;

public class LittleSpiderHomecell
{
	private ArrayList<Card> pile1, pile2, pile3, pile4;
	private Deck d = new Deck();


	public LittleSpiderHomecell(ArrayList<Card> p1, ArrayList<Card> p2, ArrayList<Card> p3, ArrayList<Card> p4) {
		this.pile1 = p1;
		this.pile2 = p2;
		this.pile3 = p3;
		this.pile4 = p4; 
 
		//These piles start off with one of their corresponding cards ((Diamonds, Ace), (Hearts, Ace), (Clubs, King), (Spades, King))

		pile1.add(d.getDeck().get(13)); 
		pile2.add(d.getDeck().get(26));
		pile3.add(d.getDeck().get(12));
		pile4.add(d.getDeck().get(51));
 
	}

	//Get Pile

	public Card getp1() {
		return pile1.get(0);
	}

	public Card getp2() {
		return pile2.get(0);
	}

	public Card getp3() {
		return pile3.get(0);
	}

	public Card getp4() {
		return pile4.get(0);
	}

	public void addCard() {
		
	}
	
	public void removeCard() {
		
	}

}





