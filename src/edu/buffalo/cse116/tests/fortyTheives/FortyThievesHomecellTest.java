package edu.buffalo.cse116.tests.fortyTheives;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import edu.buffalo.cse116.code.Card;
import edu.buffalo.cse116.code.fortyThieves.FortyThievesGame;
import edu.buffalo.cse116.code.fortyThieves.FortyThievesHomecell;

public class FortyThievesHomecellTest {
	@Test
	public void InitialHomecellPiles(){
		FortyThievesGame InitialPileSize = new FortyThievesGame();
		assertEquals(1, InitialPileSize.getGameHomecellPiles().get(0).getHomecellPile().size());
		assertEquals(1, InitialPileSize.getGameHomecellPiles().get(1).getHomecellPile().size());
		assertEquals(1, InitialPileSize.getGameHomecellPiles().get(2).getHomecellPile().size());
		assertEquals(1, InitialPileSize.getGameHomecellPiles().get(3).getHomecellPile().size());
		assertEquals(1, InitialPileSize.getGameHomecellPiles().get(4).getHomecellPile().size());
		assertEquals(1, InitialPileSize.getGameHomecellPiles().get(5).getHomecellPile().size());
		assertEquals(1, InitialPileSize.getGameHomecellPiles().get(6).getHomecellPile().size());
		assertEquals(1, InitialPileSize.getGameHomecellPiles().get(7).getHomecellPile().size());
	}
	
	@Test
	public void IsAddingLegal() {
		FortyThievesHomecell gg = new FortyThievesHomecell();
		gg.getHomecellPile().push(new Card(0,3));
		gg.getHomecellPile().push(new Card(1,6));
		gg.getHomecellPile().push(new Card(2,2));
		gg.getHomecellPile().push(new Card(3,8));
		assertEquals(4, gg.getHomecellPile().size());
	}
	
	@Test
	public void RemovingTopCard() {
		FortyThievesHomecell gg = new FortyThievesHomecell();
		assertFalse(gg.isRemovingCardLegal());
	}
	
	@Test
	public void NewTopCardTest() {
		FortyThievesHomecell gg = new FortyThievesHomecell();
		gg.getHomecellPile().push(new Card(0,3));
		Card card = gg.getHomecellPile().peek();
		assertEquals(1, gg.getHomecellPile().size());
		assertEquals(card, gg.getHomecellPile().peek());
	}
}