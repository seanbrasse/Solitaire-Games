package edu.buffalo.cse116.code;

import java.util.ArrayList;

public class HomecellLS extends PilesLS {

	Deck d = new Deck();
	TableauLS TLS= new TableauLS(d);

	public HomecellLS(ArrayList<Card> p1, ArrayList<Card> p2, ArrayList<Card> p3, ArrayList<Card> p4) {
		super(p1, p2, p3, p4);


		/*Each pile starts off with one card ((Diamonds, Ace), (Hearts, Ace), (Clubs, King), (Spades, King))
		 * This adds the correct initial card to each pile
		 */

		pile1.add(d.getDeck().get(13)); 
		pile2.add(d.getDeck().get(26));
		pile3.add(d.getDeck().get(12));
		pile4.add(d.getDeck().get(51));

	}
	public void setTableau(TableauLS a) {
		TLS=a;
	}
	public TableauLS getTableau() {
		return TLS;
	}

	/*Get Pile- Gets the initial card from each pile
	 */
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

	/*For initializing adding a top card
	 * Gets the top card from homecell piles 
	 * 
	 * tableauLS will call this method to get the top homecell card 
	 * to determine if adding their card is legal
	 * 
	 * Returns a card
	 */

	public Card getTC(int homecellP) {
		if(homecellP == 1) {
			return pile1.get(pile1.size()-1);
		} else if(homecellP ==2) {
			return pile2.get(pile2.size()-1);
		} else if(homecellP == 3) {
			return pile3.get(pile3.size()-1);
		} else if(homecellP == 4) {
			return pile4.get(pile4.size()-1);
		}
		return null;
	}

	/*For initializing removing a top card
	 * Gets top card from homecell pile
	 * 
	 * tableauLS will call this method and determine if the card can legally go into one of the tableau's
	 * 
	 * Returns a Card
	 */

	public Card getTCR(int homecellP) {
		if((homecellP == 1) && (pile1.size() >= 2)) {
			return pile1.get(pile1.size()-1);
		} else if((homecellP ==2) && (pile2.size() >= 2)) {
			return pile2.get(pile2.size()-1);
		} else if((homecellP == 3) && (pile3.size() >= 2)) {
			return pile3.get(pile3.size()-1);
		} else if((homecellP == 4) && (pile4.size() >= 2)) {
			return pile4.get(pile4.size()-1);
		}
		return null;
	}

	public boolean findTC() {
		//TLS.instantiatePiles();
//		System.out.println(TLS.getTableauPiles()[1].add(d.getDeck().get(7)));
		for(int i=0;i < 4; i++) {
		/*	for(int d=0;i<1;d++) {
				Card topBoi=TLS.getTableauPiles()[d].get(TLS.getTableauPiles()[d].size()-1);
				if(topBoi.equals(getTC(i))) {
					return true;
				}
			}
			*/
		//	System.out.println(TLS.getTableauPiles()[0]);
		//	System.out.println(TLS.getTableauPiles()[1]);
		//	System.out.println(TLS.getTableauPiles()[2]);
			if(TLS.getTableauPiles()[0].contains(getTC(i))) {
				return true;
			} if(TLS.getTableauPiles()[1].contains(getTC(i))){
				return true;
			} if((TLS.getTableauPiles()[2].contains(getTC(i)) )) {
				return true;
			} if(TLS.getTableauPiles()[3].contains(getTC(i))){
				return true;
			} if(TLS.getTableauPiles()[4].contains(getTC(i))){
				return true;
			} if(TLS.getTableauPiles()[5].contains(getTC(i))){
				return true;
			} if(TLS.getTableauPiles()[6].contains(getTC(i))){
				return true;
			} if(TLS.getTableauPiles()[7].contains(getTC(i))){
				return true;
			}
			
		}
		return false;
	}


	/*For removing a top card from homecell card
	 * 
	 * If findTC is true, the top card is removed from the appropriate pile
	 * Appropriate card is determined once game class is put together
	 * 
	 *  Returns nothing, Void
	 */

	public void removeTC(Card rCard) {
			if(pile1.contains(rCard)) {
				pile1.remove(pile1.size()-1);
			} if(pile2.contains(rCard)) {
				pile2.remove(pile2.size()-1);
			} if(pile3.contains(rCard)) {
				pile3.remove(pile3.size()-1);
			} if(pile4.contains(rCard)) {
				pile4.remove(pile4.size()-1);
			}
		}

/*Finds the size of  array
 * 
 */
	public int pileSize(int homecellP) {
		if(homecellP ==1) {
			return pile1.size();
		} if(homecellP ==2) {
			return pile2.size();
		}  if(homecellP ==3) {
			return pile2.size();
		}  if(homecellP ==4) {
			return pile2.size();
		}
		return 0;
	}
	
	/*
	 * Adds the top card from a homecell pile to a tableau pile
	 */
	
	

	public static void main(String[] args) {


	}

}







