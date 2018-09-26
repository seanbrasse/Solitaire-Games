package edu.buffalo.cse116.code;

import java.util.ArrayList;

public abstract class PilesLS {

	public ArrayList<Card> pile1;
	public ArrayList<Card> pile2;
	public ArrayList<Card> pile3;
	public ArrayList<Card> pile4;
	
	public PilesLS(ArrayList<Card> p1, ArrayList<Card> p2, ArrayList<Card> p3, ArrayList<Card> p4) {
		this.pile1 = p1;
		this.pile2 = p2;
		this.pile3 = p3;
		this.pile4 = p4; 
	}
	
	public ArrayList<Card> getPile1(){
		return this.pile1;
	}
	
	public ArrayList<Card> getPile2(){
		return this.pile2;
	}
	
	public ArrayList<Card> getPile3(){
		return this.pile3;
	}
	
	public ArrayList<Card> getPile4(){
		return this.pile4;
	}
	
}

	/*Checks if any tableau's has one of the top cards from the HomecellLS piles
	 * Returns a boolean
	 */
	

