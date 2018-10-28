package edu.buffalo.cse116.tests.golf;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import edu.buffalo.cse116.code.Card;
import edu.buffalo.cse116.code.golf.GolfGame;
//import edu.buffalo.cse116.code.Deck;
import edu.buffalo.cse116.code.golf.GolfHomecell;

public class GolfGameTest {
	
	
	
	@Test
	public void testForCorrectNumberTableauPiles() {
		GolfGame gg = new GolfGame();
		assertEquals(7, gg.getGameTableauPiles().size());
		
	}

}
