package edu.buffalo.cse116.tests.littleSpider;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.buffalo.cse116.code.Card;
import edu.buffalo.cse116.code.littleSpider.LittleSpiderGame;

public class LittleSpiderGameTest {

	
	
	
	
	@Test
	public void testForCorrectHomecell() {
		LittleSpiderGame lsg = new LittleSpiderGame();
		assertEquals(4, lsg.getHomecellPiles().size());
		
		//Ace of diamonds
		Card aDiamonds = new Card(1, 0);
		//Ace of Hearts
		Card aHearts = new Card(2, 0);
		//King of Clubs
		Card kClubs = new Card(0, 12);
		//King of Spades
		Card kSpades = new Card(3, 12);
		
		
		//Check if the first homecell pile only contains ace of diamonds
		assertEquals(aDiamonds.getSuit(), lsg.getHomecellPiles().get(0).getHomecellPile().get(0).getSuit());
		assertEquals(aDiamonds.getRank(), lsg.getHomecellPiles().get(0).getHomecellPile().get(0).getRank());
		//Check if the 2nd homecell pile only contains ace of hearts
		assertEquals(aHearts.getSuit(), lsg.getHomecellPiles().get(1).getHomecellPile().get(0).getSuit());
		assertEquals(aHearts.getRank(), lsg.getHomecellPiles().get(1).getHomecellPile().get(0).getRank());
		//Check if the 3rd homecell pile only contains king of clubs
		assertEquals(kClubs.getSuit(), lsg.getHomecellPiles().get(2).getHomecellPile().get(0).getSuit());
		assertEquals(kClubs.getRank(), lsg.getHomecellPiles().get(2).getHomecellPile().get(0).getRank());
		//Check if the 4th homecell pile only contains king of spades
		assertEquals(kSpades.getSuit(), lsg.getHomecellPiles().get(3).getHomecellPile().get(0).getSuit());
		assertEquals(kSpades.getRank(), lsg.getHomecellPiles().get(3).getHomecellPile().get(0).getRank());
	}
	
	@Test
	public void testForEightTableauPiles() {
		LittleSpiderGame lts = new LittleSpiderGame();
		assertEquals(8, lts.getTableauPiles().size());
		
		for(int i = 0; i < lts.getTableauPiles().size();i++) {
			assertEquals(6, lts.getTableauPiles().get(i).getPileSize());
		}
	}
	
	
	
}
