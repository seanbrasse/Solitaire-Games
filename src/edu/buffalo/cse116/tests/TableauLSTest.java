package edu.buffalo.cse116.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import edu.buffalo.cse116.code.Card;
import edu.buffalo.cse116.code.Deck;
import edu.buffalo.cse116.code.TableauLS;

/*
 * Suit is a number from 0 to 3, in order of: Clubs, Diamonds, Hearts, and Spades.
 * Rank is a number from 0 to 12, in order of: Ace, going 2 - 10, and proceeding Jack, Queen, King.
 */
public class TableauLSTest {
	
	Deck deck = new Deck();
	
	/**
	 * Since the homecell piles are created first in Little Spider, the deck can't contain Ace of diamonds, Ace of Hearts,
	 * King of Spades and King of Clubs.
	 * Hence the deck when TableauLS is instantiated will only contain 48 cards;
	 */
	@Before
	public void removeFourCardsForTableau() {
		Card aceDiamonds = this.deck.getDeck().get(12);
		Card aceHearts = this.deck.getDeck().get(26);
		Card kingSpades = this.deck.getDeck().get(51);
		Card kingClubs = this.deck.getDeck().get(12);
		
		this.deck.getDeck().remove(12);
		this.deck.getDeck().remove(12);
		this.deck.getDeck().remove(24);
		this.deck.getDeck().remove(48);
	}


	/**
	 * Tests to see that the number of tableau piles is 8.
	 */
	@Test
	public void testForNumberOfTableauPiles() {
		
		TableauLS tls = new TableauLS(deck);
		tls.instantiatePiles();
		
		assertEquals("There should be 8 tableau piles for Little spider.", 8, tls.getTableauPiles().length);
	}
	
	/**
	 * Tests if each Tableau pile contains only 6 cards.
	 */
	@Test
	public void testForNumberOfCardsOnPile() {
		TableauLS tls = new TableauLS(deck);
		tls.instantiatePiles();
		
		//Test for pile 1
		assertEquals("There should be 6 cards on Pile 1", 6, tls.getTableauPiles()[0].size());
		
		//Test for Pile2
		assertEquals("There should be 6 cards on Pile 2", 6, tls.getTableauPiles()[1].size());
		
		//Test for pile3
		assertEquals("There should be 6 cards on Pile 3", 6, tls.getTableauPiles()[2].size());
		
		//Test for pile4
		assertEquals("There should be 6 cards on Pile 4", 6, tls.getTableauPiles()[3].size());
		
		//Test for Pile5
		assertEquals("There should be 6 cards on Pile 1", 6, tls.getTableauPiles()[4].size());
		
		//Test for Pile6
		assertEquals("There should be 6 cards on Pile 1", 6, tls.getTableauPiles()[5].size());		
	}
	
	/**
	 * Test that every card being added to a pile is legal
	 */
	@Test
	public void testForLegalAddToTableau() {
		TableauLS tls = new TableauLS(deck);
		tls.instantiatePiles();
		
		Card currentTopcard = new Card(3, 12);
		Card newTopCard = new Card(0, 0);
		assertTrue("The top card should now be a Ace", tls.checkLegalAddToPile(currentTopcard, newTopCard));
		
		
		currentTopcard = new Card(1, 12);
		newTopCard = new Card(0, 11);
		assertTrue("The top card should now be a Queen", tls.checkLegalAddToPile(currentTopcard, newTopCard));
		
		
		currentTopcard = new Card(0,0);
		newTopCard = new Card(0, 12);
		assertTrue("The top card should now be an King", tls.checkLegalAddToPile(currentTopcard, newTopCard));
		
		
		currentTopcard = new Card(0,0);
		newTopCard = new Card(2, 1);
		assertTrue("The top card should now be an 2", tls.checkLegalAddToPile(currentTopcard, newTopCard));
		
		currentTopcard = new Card(1, 4);
		newTopCard = new Card(2,5);
		assertTrue("The top card should now be a 6", tls.checkLegalAddToPile(currentTopcard, newTopCard));
		
		
		currentTopcard = new Card(2, 6);
		newTopCard = new Card(3, 5);
		assertTrue("The top card should now be a 6", tls.checkLegalAddToPile(currentTopcard, newTopCard));
		
		currentTopcard = new Card(1, 3);
		newTopCard = new Card(2, 5);
		assertFalse("The top card will remain a 4", tls.checkLegalAddToPile(currentTopcard, newTopCard));
		
		currentTopcard = new Card(1,0);
		newTopCard = new Card(-1, -1);
		assertFalse("The top card will remain a Ace", tls.checkLegalAddToPile(currentTopcard, newTopCard));
		
	}
	
	/**
	 * Tests to see if the card is a legal remove, i.e. when its not empty
	 */
	@Test
	public void testForLegalRemoveCard() {
		
		TableauLS tls = new TableauLS(deck);
		
		ArrayList<Card> mockPile = new ArrayList<Card>();
		ArrayList<Card> mockPile2 = new ArrayList<Card>(); //Will be left empty to test with.
		mockPile.add(new Card(0,2));
		mockPile.add(new Card(0,3));
		

		tls.instantiateTestingPiles(0, mockPile, 1, mockPile2);
		
		//Will check if a card can be removed from the pile
		assertTrue("Should return true because there's at least 1 element in pile '0'.",tls.checkLegalToRemoveTopCard(0));
		
		//Will check if a card can't be removed from the pile
		assertFalse("There's nothing in  pile '1' so it should return false",tls.checkLegalToRemoveTopCard(1));
	}
	
	/**
	 * Will see if a removable card is removed from the pile.
	 */
	@Test
	public void testForRemovedCard() {
		TableauLS tls = new TableauLS(deck);
		
		ArrayList<Card> mockPile = new ArrayList<Card>();
		mockPile.add(new Card(0,0));
		ArrayList<Card> mockPile2 = new ArrayList<Card>(); //Will be left empty to test with.
		
		//Shows the initial size of the pile.
		tls.instantiateTestingPiles(0, mockPile, 1, mockPile2);
		assertEquals("The size of pile '0' should be:", 1, tls.getTableauPiles()[0].size());
		
		
		//Shows the final size of the pile after the card removal
		Card removedCard = tls.removeTopCard(0);
		assertEquals("The size of pile '0' should be:", 0, tls.getTableauPiles()[0].size());
		
		//Shows the card that was created in mockPile is the same one that was removed from the mockpile
		assertEquals("The removed card should be the same as the card in mockPile", removedCard, mockPile.get(0));
		
		//Shows that the method call on an empty arraylist for the pile ('1') will keep the size 0.
		Card removedCard2 = tls.removeTopCard(1);
		assertEquals("The size of the array should be:", 0, tls.getTableauPiles()[1].size());
		
	}

	/**
	 * Will create mock piles for testing the ability to add cards to a Tableau pile (assuming the move is legal)
	 */
	@Test
	public void testForCardIncreaseOnTableauPile() {
		TableauLS tls = new TableauLS(deck);
		//The mock cards in the pile will only contain one card each
		ArrayList<Card> mockPile = new ArrayList<Card>(); //This pile will start with a king of diamonds
		ArrayList<Card> mockPile2 = new ArrayList<Card>(); //This pile will start with an ace of spades.
		
					
		mockPile.add(deck.getDeck().get(23));//King of diamonds
	
		mockPile2.add(deck.getDeck().get(36)); // Ace of spades
	
		tls.instantiateTestingPiles(0, mockPile, 4, mockPile2);
		
		//Checking if correct index for King of Diamonds from deck
		assertEquals(new Card(1, 12).getRank(), mockPile.get(0).getRank());
		assertEquals(new Card(1, 12).getSuit(), mockPile.get(0).getSuit());
		
		//Checking if correct index for Ace of Spades from deck
		assertEquals(new Card(3, 0).getRank(), mockPile2.get(0).getRank());
		assertEquals(new Card(3, 0).getSuit(), mockPile2.get(0).getSuit());
		

		//Now we'll see if on the first mock pile, we can go full circle in adding king, ace, 2 ,3... , queen.
		for(int i = 0; i < mockPile.get(0).getRank(); i++) {
			tls.addCardToPile(new Card(2, i), 0);
			assertEquals(new Card(2, i).getRank(), tls.getTableauPiles()[0].get(tls.getTableauPiles()[0].size() - 1).getRank());
		}
		//Now check the top card outside the loop
		assertEquals(new Card(2, 11).getRank(), tls.getTableauPiles()[0].get(tls.getTableauPiles()[0].size() - 1).getRank());
		//And the length
		assertEquals(13, tls.getTableauPiles()[0].size());
		
		//Now on the 2nd mock pile we'll go in full circle from ace, king, queen... , 2.
		for(int i = 12; i > mockPile2.get(0).getRank(); i--) {
			Card localCard = new Card(0, i);
			tls.addCardToPile(localCard, 4);
			assertEquals(localCard.getRank(), tls.getTableauPiles()[4].get(tls.getTableauPiles()[4].size() - 1).getRank());
		}
		//Check top card outside of loop to be sure
		assertEquals(new Card(0, 1).getRank(), tls.getTableauPiles()[4].get(tls.getTableauPiles()[4].size() - 1).getRank());
		//Length check of pile
		assertEquals(13, tls.getTableauPiles()[4].size());
	}	
	
}
