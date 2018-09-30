package edu.buffalo.cse116.tests.golf;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import edu.buffalo.cse116.code.Card;
//import edu.buffalo.cse116.code.Deck;
import edu.buffalo.cse116.code.golf.GolfHomecell;


public class GolfHomecellTest {
	
	/**
	 * This is testing the initial deck size if it starts with 0 card
	 */
	@Test
	public void TestInitialPileSize() {
		
		GolfHomecell testForGolf = new GolfHomecell();
		
		assertEquals(0, testForGolf.getGolfHomecellPile().size());
	}
	
	/**
	 * Testing if adding cards is legal, if the rank of the card is one greater or less then it is legal
	 */
	@Test
	public void TestAddingCardLegal() {

		GolfHomecell testForGolf = new GolfHomecell();
	
		//System.out.println(testForGolf.getGolfHomecellPile().size() + " initial size");
		
		assertTrue("This works", testForGolf.isAddingCardLegal(new Card( 3,6)));
		
		testForGolf.getGolfHomecellPile().push(new Card(0,3));
		testForGolf.getGolfHomecellPile().push(new Card(0,4));
		testForGolf.getGolfHomecellPile().push(new Card(0,7));
		
		//System.out.println(testForGolf.getGolfHomecellPile().firstElement().getRank());
		//System.out.println(testForGolf.getGolfHomecellPile().lastElement().getRank());
		//System.out.println(testForGolf.getGolfHomecellPile().size() + " 2nd size");
		
		testForGolf.addCard(new Card(0,8));
		assertEquals(4, testForGolf.getGolfHomecellPile().size());
		
		testForGolf.addCard(new Card(2,7));
		assertEquals(5, testForGolf.getGolfHomecellPile().size());
		
		testForGolf.addCard(new Card(3,7));
		assertEquals(5, testForGolf.getGolfHomecellPile().size());
		
		testForGolf.addCard(new Card(0,8));
		assertEquals(6, testForGolf.getGolfHomecellPile().size());
		
		testForGolf.addCard(new Card(3,9));
		assertEquals(7, testForGolf.getGolfHomecellPile().size());
		
		testForGolf.addCard(new Card(1,10));
		assertEquals(8, testForGolf.getGolfHomecellPile().size());
		
		testForGolf.addCard(new Card(1,11));
		assertEquals(9, testForGolf.getGolfHomecellPile().size());
		
		testForGolf.addCard(new Card(2,12));
		assertEquals(10, testForGolf.getGolfHomecellPile().size());
	}
	
	/**
	 * Testing if removing card from the homecell pile is legal, but this will always be FALSE.
	 */
	@Test
	public void testRemoveCardIsLegal(){
		
		GolfHomecell testForGolf = new GolfHomecell();
		
		assertFalse(testForGolf.isRemovingCardLegal());
	}
	
	/**
	 * This is testing if once a card is being added to the homecell pile, it checks if the top card is being
	 * replace by the new card
	 */
	@Test
	public void TestNewTopCard() {
		GolfHomecell testForGolf = new GolfHomecell();
		testForGolf.getGolfHomecellPile().push(new Card(3, 6));
		assertEquals(3, testForGolf.getGolfHomecellPile().lastElement().getSuit());
		assertEquals(6, testForGolf.getGolfHomecellPile().lastElement().getRank());
		
		testForGolf.getGolfHomecellPile().push(new Card(2, 8));
		assertEquals(2, testForGolf.getGolfHomecellPile().lastElement().getSuit());
		assertEquals(8, testForGolf.getGolfHomecellPile().lastElement().getRank());
		
		testForGolf.getGolfHomecellPile().push(new Card(3, 9));
		assertEquals(3, testForGolf.getGolfHomecellPile().lastElement().getSuit());
		assertEquals(9, testForGolf.getGolfHomecellPile().lastElement().getRank());
	}
}
