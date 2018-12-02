package edu.buffalo.cse116.tests.fortyTheives;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

import edu.buffalo.cse116.code.Card;
import edu.buffalo.cse116.code.Deck;
import edu.buffalo.cse116.code.fortyThieves.FortyThievesGame;
import edu.buffalo.cse116.code.fortyThieves.FortyThievesTableau;

public class FortyThievesTableauTest {

	/**
	 * Checks that the initial size of each tableau is 3.
	 */
	@Test
	public void testInitialTableauPileSize() {
			Deck d = new Deck();
			FortyThievesTableau t = new FortyThievesTableau(d);
			FortyThievesGame tG = new FortyThievesGame();
			tG.getGameTableauPiles().get(0).getPileSize();
			assertEquals(3, tG.getGameTableauPiles().get(0).getPileSize(), 0);
	}
	
	/*
	 * Tests if adding to the tableau piles is legal.
	 */
	@Test
	public void isAddLegalTest() {
		FortyThievesGame tG = new FortyThievesGame();
		
	//Is adding legal when the tableau is empty?
		FortyThievesTableau testTableau= tG.getGameTableauPiles().get(0);
		assertEquals(3, testTableau.getPileSize());
		testTableau.getPile().pop();
		testTableau.getPile().pop();
		testTableau.getPile().pop();
		assertEquals(0,testTableau.getPile().size(),0);//Checks that the Tableau pile is empty
		assertTrue(testTableau.isAddingCardLegal(new Card(4,3)));
		
	//Is adding cards legal?
		assertTrue(testTableau.isAddingCardLegal(new Card(4,2)));
		testTableau.getPile().push(new Card(4,2));
		assertTrue(testTableau.isAddingCardLegal(new Card(4,1)));
		testTableau.getPile().push(new Card(4,5));
		assertTrue(testTableau.isAddingCardLegal(new Card(4,4)));
		assertFalse(testTableau.isAddingCardLegal(new Card(4,6)));
	}
		
		/*
		 * Tests if adding new cards increase size and change the top card to the newly added card's value?
		 */
	@Test	
	public void addTest() {
		FortyThievesGame tG = new FortyThievesGame();
			FortyThievesTableau testTableau= tG.getGameTableauPiles().get(0);
			assertEquals(3, testTableau.getPileSize());
			testTableau.getPile().pop();
			testTableau.getPile().pop();
			testTableau.getPile().pop();
			assertEquals(0, testTableau.getPile().size(),0);
			
			testTableau.getPile().push(new Card(2,10)); //first card in
			testTableau.addCard(new Card(2,9)); //second card in
			assertEquals(2, testTableau.getPile().size(),0); //Checks that add increases Tableau size
			
			assertEquals(2,testTableau.getPile().peek().getSuit(),0); //Checks that Top card's suit is correct
			assertEquals(9,testTableau.getPile().peek().getRank(),0); //Checks that Top card's rank is correct
	} 
	
	/*
	 * Tests if cards can be removed
	 */
	
	@Test
	public void isRemoveLegalTest() {
		FortyThievesGame tG = new FortyThievesGame();
		FortyThievesTableau testTableau= tG.getGameTableauPiles().get(0);
		
		assertEquals(3, testTableau.getPile().size(),0);
		testTableau.getPile().pop();
		testTableau.getPile().pop();
		testTableau.getPile().pop();
		assertEquals(0, testTableau.getPile().size(),0);
		assertFalse(testTableau.isRemovingCardLegal()); //Checks if removing is legal when Tableau is empty
		
		testTableau.getPile().push(new Card(1,10));
		testTableau.getPile().push(new Card(1,9));
		testTableau.getPile().push(new Card(1,8));
		testTableau.getPile().push(new Card(1,7));
		testTableau.getPile().push(new Card(1,6));
		assertEquals(5,testTableau.getPile().size(),0);
		assertTrue(testTableau.isRemovingCardLegal()); //Checks if removing card is legal
	}
	
	/*
	 * Tests if removing a card decreases tableau size and changes topcard
	 */
	
	@Test
	public void removeTest() {
		FortyThievesGame tG = new FortyThievesGame();
		FortyThievesTableau testTableau= tG.getGameTableauPiles().get(0);
		
		assertEquals(3, testTableau.getPile().size(),0);
		testTableau.getPile().push(new Card(1,10));
		testTableau.getPile().push(new Card(1,9));
		testTableau.getPile().push(new Card(4,8));
		testTableau.getPile().push(new Card(2,7));
		testTableau.getPile().push(new Card(3,6));
		assertEquals(8, testTableau.getPile().size(),0);

		testTableau.removeCard();
		assertEquals(7, testTableau.getPile().size(),0);
		
		assertEquals(2,testTableau.getPile().peek().getSuit(), 0); //Checks suit to see if it is Top Card
		assertEquals(7,testTableau.getPile().peek().getRank(), 0); //Checks rank to see if it is Top Card
		
		testTableau.removeCard();
		assertEquals(6, testTableau.getPile().size(),0);
		
		assertEquals(4,testTableau.getPile().peek().getSuit(), 0); //Checks suit to see if it is Top Card
		assertEquals(8,testTableau.getPile().peek().getRank(), 0); //Checks rank to see if it is Top Card

		
	}
	
}
