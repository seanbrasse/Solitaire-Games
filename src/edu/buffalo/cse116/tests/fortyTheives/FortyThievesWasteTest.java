package edu.buffalo.cse116.tests.fortyTheives;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import edu.buffalo.cse116.code.Card;
import edu.buffalo.cse116.code.fortyThieves.FortyThievesWaste;

public class FortyThievesWasteTest {

	/*
	 * Tests initial size of the waste pile
	 */
	
	@Test
	public void initialSizeTest() {
		FortyThievesWaste w = new FortyThievesWaste();
		assertEquals(0,  w.getWastePile().size(), 0); //Checks that initial size is 0
	}
	
	/*
	 * Tests if adding a card works (Always legal when adding from the stock.) 
	 */
	@Test
	public void AddTest() {
			FortyThievesWaste w = new FortyThievesWaste();
			assertEquals(0, w.getWastePile().size());
			w.addCardFromStock(new Card(0,3));
			assertEquals(1, w.getWastePile().size()); //Checks if size increases
			assertEquals(0, w.getWastePile().peek().getSuit()); //Checks if top card is updated
			assertEquals(3, w.getWastePile().peek().getRank()); //Checks if top card is updated
			
			w.addCardFromStock(new Card(3,5));
			assertEquals(2, w.getWastePile().size()); //Checks if size increases
			assertEquals(3, w.getWastePile().peek().getSuit()); //Checks if top card is updated
			assertEquals(5, w.getWastePile().peek().getRank()); //Checks if top card is updated
	}
	
	/*
	 * Tests if removing a card is legal
	 */
	
	@Test
	public void isRemoveCardLegalTest() {
		FortyThievesWaste w = new FortyThievesWaste();
		
		assertEquals(0,w.getWastePile().size(), 0);
		assertFalse(w.isRemoveLegal()); //remove not legal if waste pile is empty
		
		
		w.getWastePile().push(new Card(0,3));
		w.getWastePile().push(new Card(1,6));
		w.getWastePile().push(new Card(3,2));
		w.getWastePile().push(new Card(1,8));
		w.getWastePile().push(new Card(4,6));
		
		assertEquals(5,w.getWastePile().size(), 0);
		assertTrue(w.isRemoveLegal()); //legal if waste pile is not empty
	}
	
	/*
	 * Tests if size decreases when top card is being removed. Also tests for updated top card
	 */
	@Test
	public void removeTest() {
		FortyThievesWaste w = new FortyThievesWaste();
		
		assertEquals(0, w.getWastePile().size(), 0);
		w.getWastePile().push(new Card(0,3));
		w.getWastePile().push(new Card(1,6));
		w.getWastePile().push(new Card(3,2));
		w.getWastePile().push(new Card(1,8));
		w.getWastePile().push(new Card(4,6));
		assertEquals(5, w.getWastePile().size(), 0);

		
		w.removedCard();
		assertEquals(4, w.getWastePile().size(), 0); // Checks for updated size
		assertEquals(1, w.getWastePile().peek().getSuit()); //Checks if top card is updated
		assertEquals(8, w.getWastePile().peek().getRank()); //Checks if top card is updated
		
		w.removedCard();
		assertEquals(3, w.getWastePile().size(), 0); // Checks for updated size
		assertEquals(3, w.getWastePile().peek().getSuit()); //Checks if top card is updated
		assertEquals(2, w.getWastePile().peek().getRank()); //Checks if top card is updated

	}
	
}
  