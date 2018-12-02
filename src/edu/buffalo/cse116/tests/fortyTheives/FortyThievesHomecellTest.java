package edu.buffalo.cse116.tests.fortyTheives;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.buffalo.cse116.code.fortyThieves.FortyThievesGame;
import edu.buffalo.cse116.code.fortyThieves.FortyThievesHomecell;

public class FortyThievesHomecellTest {
	@Test
	public void InitialHomecellPiles(){
		FortyThievesGame InitialPileSize = new FortyThievesGame();
		assertEquals(1, InitialPileSize.getGameHomecellPiles().size());
		
		FortyThievesHomecell homecell = InitialPileSize.getGameHomecellPiles().get(0);
		
		assertEquals(1, homecell.getHomecellPile().size());
	}
	
	@Test
	public void IsAddingLegal() {
		FortyThievesHomecell gg = new FortyThievesHomecell();
		
	}
}
