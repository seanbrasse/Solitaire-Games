package edu.buffalo.cse116.tests.fortyTheives;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.buffalo.cse116.code.fortyThieves.FortyThievesGame;

public class FortyThievesHomecellTest {
	@Test
	public void InitialHomecellPiles(){
		FortyThievesGame InitialPileSize = new FortyThievesGame();
		assertEquals(1, InitialPileSize.getGameHomecellPiles().size());
	}
}
