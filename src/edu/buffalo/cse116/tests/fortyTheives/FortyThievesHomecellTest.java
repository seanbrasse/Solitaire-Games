package edu.buffalo.cse116.tests.fortyTheives;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import edu.buffalo.cse116.code.Card;
import edu.buffalo.cse116.code.fortyThieves.FortyThievesGame;
import edu.buffalo.cse116.code.fortyThieves.FortyThievesHomecell;

public class FortyThievesHomecellTest {

	/*
	 *Tests that each homecell pile contains 1 card initially 
	 */

	@Test
	public void InitialHomecellPiles(){
		FortyThievesGame ftg = new FortyThievesGame();
		assertEquals(1, ftg.getGameHomecellPiles().get(0).getHomecellPile().size());
		assertEquals(1, ftg.getGameHomecellPiles().get(1).getHomecellPile().size());
		assertEquals(1, ftg.getGameHomecellPiles().get(2).getHomecellPile().size());
		assertEquals(1, ftg.getGameHomecellPiles().get(3).getHomecellPile().size());
		assertEquals(1, ftg.getGameHomecellPiles().get(4).getHomecellPile().size());
		assertEquals(1, ftg.getGameHomecellPiles().get(5).getHomecellPile().size());
		assertEquals(1, ftg.getGameHomecellPiles().get(6).getHomecellPile().size());
		assertEquals(1, ftg.getGameHomecellPiles().get(7).getHomecellPile().size());
	}

	/*
	 * Tests if adding a card to the homecell is legal
	 */

	@Test
	public void IsAddingLegal() {
		FortyThievesHomecell gg = new FortyThievesHomecell();		
		gg.getHomecellPile().push(new Card(3,8));
		assertEquals(1, gg.getHomecellPile().size());

		assertTrue(gg.isAddingCardLegal(new Card(3,9)));

		gg.getHomecellPile().push(new Card(2,3));
		assertTrue(gg.isAddingCardLegal(new Card(2,4)));
		assertFalse(gg.isAddingCardLegal(new Card(2,2)));
	}

	/*
	 * Tests if adding to the homecell increases size and updates topcard
	 */

	@Test
	public void addTest() {
		FortyThievesHomecell gg = new FortyThievesHomecell();		
		gg.getHomecellPile().push(new Card(3,8));
		assertEquals(1, gg.getHomecellPile().size());

		gg.addCard(new Card(3,9));
		assertEquals(2, gg.getHomecellPile().size()); //Checks for updated pile size
		assertEquals(3, gg.getHomecellPile().peek().getSuit()); //Checks for updated topcard
		assertEquals(9, gg.getHomecellPile().peek().getRank()); //Checks for updated topcard

		gg.addCard(new Card(3,10));
		assertEquals(3, gg.getHomecellPile().size()); //Checks for updated pile size
		assertEquals(3, gg.getHomecellPile().peek().getSuit()); //Checks for updated topcard
		assertEquals(10, gg.getHomecellPile().peek().getRank()); //Checks for updated topcard


	}

	/*
	 * Tests if removing top card is legal (Removing is illegal)
	 */

	@Test
	public void RemovingTopCard() {
		FortyThievesHomecell gg = new FortyThievesHomecell();
		assertFalse(gg.isRemovingCardLegal());
	}

}