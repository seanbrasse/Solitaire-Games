package edu.buffalo.cse116.tests.littleSpider;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import edu.buffalo.cse116.code.Card;
import edu.buffalo.cse116.code.Deck;
import edu.buffalo.cse116.code.littleSpider.LittleSpiderHomecell;
import edu.buffalo.cse116.code.littleSpider.LittleSpiderTableau;

public class LittleSpiderHomecellTest {

	/*
	 *  Tests if heart and diamond cards are being correctly added to the homecell piles. Also tests isAddingCardIsLegal for heart and diamond cards
	 *  
	 *  Heart and diamond cards can only be added to their corresponding homecell piles if their suit is the same and they build UP
	 */

	@Test
	public void canAddHeartsAndDiamonds() {
		LittleSpiderHomecell LSHHearts = new LittleSpiderHomecell();
		LittleSpiderHomecell LSHDiamonds = new LittleSpiderHomecell();
		LSHHearts.getHomecellPile().push(new Card(2, 2));
		LSHHearts.getHomecellPile().push(new Card(2, 5));
		LSHHearts.getHomecellPile().push(new Card(2, 7));
		LSHHearts.getHomecellPile().push(new Card(2, 9));
		System.out.println(LSHHearts.getHomecellPile().size() + " is the size of pile1 initially");
		LSHHearts.addCard(new Card(2,10));
		System.out.println(LSHHearts.getHomecellPile().size() + " is the size of pile1 after attempt 1");
		assertEquals(5, LSHHearts.getHomecellPile().size());
		LSHHearts.addCard(new Card(2,11));
		System.out.println(LSHHearts.getHomecellPile().size() + " is the size of pile1 after attempt 2");
		assertEquals(6, LSHHearts.getHomecellPile().size());
		LSHHearts.addCard(new Card(3,12));
		LSHHearts.addCard(new Card(2,12));
		LSHHearts.addCard(new Card(3,11));
		LSHHearts.addCard(new Card(0,11));
		System.out.println(LSHHearts.getHomecellPile().size() + " is the size of pile1 after attempt 3 \n");
		assertEquals(7, LSHHearts.getHomecellPile().size());

		LSHDiamonds.getHomecellPile().push(new Card(1, 2));
		LSHDiamonds.getHomecellPile().push(new Card(1, 5));
		LSHDiamonds.getHomecellPile().push(new Card(1, 7));
		LSHDiamonds.getHomecellPile().push(new Card(1, 9));
		System.out.println(LSHDiamonds.getHomecellPile().size() + " is the size of pile2 initially");
		LSHDiamonds.addCard(new Card(1,10));
		System.out.println(LSHDiamonds.getHomecellPile().size() + " is the size of pile2 after attempt 1");
		assertEquals(5, LSHDiamonds.getHomecellPile().size());
		LSHDiamonds.addCard(new Card(1,11));
		System.out.println(LSHDiamonds.getHomecellPile().size() + " is the size of pile2 after attempt 2");
		assertEquals(6, LSHDiamonds.getHomecellPile().size());
		LSHDiamonds.addCard(new Card(2,12));
		LSHDiamonds.addCard(new Card(1,12));
		LSHDiamonds.addCard(new Card(3,11));
		LSHDiamonds.addCard(new Card(0,11));
		System.out.println(LSHDiamonds.getHomecellPile().size() + " is the size of pile2 after attempt 3 \n");
		assertEquals(7, LSHDiamonds.getHomecellPile().size());
	}

	/*
	 *  Tests if clubs and spades cards are being correctly added to the homecell piles. Also tests isAddingCardIsLegal for clubs and spade cards
	 *   
	 *  Club and spade cards can only be added to their corresponding homecell piles if their suit is the same and they build DOWN
	 */

	@Test
	public void canAddClubsAndSpades() {
		LittleSpiderHomecell LSHClubs = new LittleSpiderHomecell();
		LittleSpiderHomecell LSHSpades = new LittleSpiderHomecell();
		LSHClubs.getHomecellPile().push(new Card(0, 2));
		LSHClubs.getHomecellPile().push(new Card(3, 11));
		LSHClubs.getHomecellPile().push(new Card(0, 1));
		LSHClubs.getHomecellPile().push(new Card(0, 6));
		System.out.println(LSHClubs.getHomecellPile().lastElement().getRank() + " -this is the last element's rank");
		System.out.println(LSHClubs.getHomecellPile().size() + " is the size of pile1 initially");
		LSHClubs.addCard(new Card(0,5));
		System.out.println(LSHClubs.getHomecellPile().size() + " is the size of pile1 after attempt 1");
		assertEquals(5, LSHClubs.getHomecellPile().size());
		LSHClubs.addCard(new Card(0,4));
		System.out.println(LSHClubs.getHomecellPile().size() + " is the size of pile1 after attempt 2");
		assertEquals(6, LSHClubs.getHomecellPile().size());
		LSHClubs.addCard(new Card(3,3));
		LSHClubs.addCard(new Card(0,3));
		LSHClubs.addCard(new Card(0,8));
		LSHClubs.addCard(new Card(0,11));
		System.out.println(LSHClubs.getHomecellPile().size() + " is the size of pile1 after attempt 3 \n");
		assertEquals(7, LSHClubs.getHomecellPile().size());

		LSHSpades.getHomecellPile().push(new Card(3, 2));
		LSHSpades.getHomecellPile().push(new Card(3, 5));
		LSHSpades.getHomecellPile().push(new Card(3, 7));
		LSHSpades.getHomecellPile().push(new Card(3, 9));
		System.out.println(LSHSpades.getHomecellPile().size() + " is the size of pile1 initially");
		LSHSpades.addCard(new Card(3,8));
		System.out.println(LSHSpades.getHomecellPile().size() + " is the size of pile1 after attempt 1");
		assertEquals(5, LSHSpades.getHomecellPile().size());
		LSHSpades.addCard(new Card(3,7));
		System.out.println(LSHSpades.getHomecellPile().size() + " is the size of pile1 after attempt 2");
		assertEquals(6, LSHSpades.getHomecellPile().size());
		LSHSpades.addCard(new Card(1,12));
		LSHSpades.addCard(new Card(3,6));
		LSHSpades.addCard(new Card(3,11));
		LSHSpades.addCard(new Card(0,11));
		System.out.println(LSHSpades.getHomecellPile().size() + " is the size of pile1 after attempt 3 \n");
		assertEquals(7, LSHSpades.getHomecellPile().size());

	}

	/*
	 * Tests if cards can be added to an empty "tableau" pile (They CANNOT)
	 */

	@Test
	public void cantAddToEmptyStack() {
		LittleSpiderHomecell LHS = new LittleSpiderHomecell();
		System.out.println(LHS.getHomecellPile().size() + " is the size before");
		LHS.addCard(new Card(2, 1));
		System.out.println(LHS.getHomecellPile().size() + " is the size after");
		assertEquals(0, LHS.getHomecellPile().size()); 
	}

	/*
	 * Tests if removing cards from the homecell piles is legal. 
	 * 
	 * Also tests if ifRemovingCardIsLegal works.
	 * Makes sure a the next card in the stack becomes the top card
	 * 
	 * Removing is only legal if there is MORE than 1 card in the homecell pile
	 */

	@Test
	public void canRemoveCard() {
		Deck deck = new Deck();
		LittleSpiderHomecell LSH = new LittleSpiderHomecell();
		LittleSpiderTableau LST = new LittleSpiderTableau(deck);
		LST.getPile().push(new Card (2,10));
		LSH.getHomecellPile().push(new Card(2, 3));
		LSH.getHomecellPile().push(new Card(2, 5));
		LSH.getHomecellPile().push(new Card(3, 12));
		LSH.getHomecellPile().push(new Card(1, 8));
		LSH.getHomecellPile().push(new Card(2, 8));
		System.out.println(LSH.getHomecellPile().size() + " size before");
		System.out.println(LSH.getHomecellPile().lastElement().getSuit() + " " + LSH.getHomecellPile().lastElement().getRank());
		LSH.removeCard();
		assertEquals(4, LSH.getHomecellPile().size());
		assertEquals(1, LSH.getHomecellPile().lastElement().getSuit());		
		assertEquals(8, LSH.getHomecellPile().lastElement().getRank());
		LSH.removeCard();
		assertEquals(3, LSH.getHomecellPile().size());
		assertEquals(3, LSH.getHomecellPile().lastElement().getSuit());
		assertEquals(12, LSH.getHomecellPile().lastElement().getRank());
		LSH.removeCard();
		assertEquals(2, LSH.getHomecellPile().size());
		assertEquals(2, LSH.getHomecellPile().lastElement().getSuit());
		assertEquals(5, LSH.getHomecellPile().lastElement().getRank());
		LSH.removeCard();
		assertEquals(1, LSH.getHomecellPile().size());
		assertEquals(2, LSH.getHomecellPile().lastElement().getSuit());
		assertEquals(3, LSH.getHomecellPile().lastElement().getRank());
		LSH.removeCard();
		assertEquals(1, LSH.getHomecellPile().size());
		assertEquals(2, LSH.getHomecellPile().lastElement().getSuit());
		assertEquals(3, LSH.getHomecellPile().lastElement().getRank());
		System.out.println(LSH.getHomecellPile().lastElement().getSuit() + " " + LSH.getHomecellPile().lastElement().getRank());
		System.out.println(LSH.getHomecellPile().size() + " size after");
	}

}
