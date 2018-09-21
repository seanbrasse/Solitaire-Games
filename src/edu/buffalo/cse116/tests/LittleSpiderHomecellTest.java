package edu.buffalo.cse116.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;

import edu.buffalo.cse116.code.Card;
import edu.buffalo.cse116.code.Deck;
import edu.buffalo.cse116.code.LittleSpiderHomecell;

public class LittleSpiderHomecellTest {

	private Card cards = new Card(0, 0);
	
	@Test
	//borrowed from WillShady
	public void testConstructor() { 
		Deck testDeck = new Deck();
		
		assertNotNull(testDeck);
		assertNotNull(testDeck.getDeck());
		
	}
	
	@Test
	public void p1Initial() {
		ArrayList<Card> a = new ArrayList<Card>();
		ArrayList<Card> b = new ArrayList<Card>();
		ArrayList<Card> c = new ArrayList<Card>(); 
		ArrayList<Card> d = new ArrayList<Card>();
		LittleSpiderHomecell hc = new LittleSpiderHomecell(a, b, c, d);
		assertEquals(13, hc.getp1());
	}
	
	@Test
	public void p2Initial() {
		ArrayList<Card> a = new ArrayList<Card>();
		ArrayList<Card> b = new ArrayList<Card>();
		ArrayList<Card> c = new ArrayList<Card>();
		ArrayList<Card> d = new ArrayList<Card>();
		LittleSpiderHomecell hc = new LittleSpiderHomecell(a, b, c, d);
		assertEquals(26, hc.getp2());
	}
	
	@Test 
	public void p3Initial() { 
		ArrayList<Card> a = new ArrayList<Card>();
		ArrayList<Card> b = new ArrayList<Card>();
		ArrayList<Card> c = new ArrayList<Card>();
		ArrayList<Card> d = new ArrayList<Card>();
		LittleSpiderHomecell hc = new LittleSpiderHomecell(a, b, c, d);
		assertEquals(12, hc.getp3());
	}
	
	@Test
	public void p4Initial() {
		ArrayList<Card> a = new ArrayList<Card>();
		ArrayList<Card> b = new ArrayList<Card>();
		ArrayList<Card> c = new ArrayList<Card>();
		ArrayList<Card> d = new ArrayList<Card>();
		LittleSpiderHomecell hc = new LittleSpiderHomecell(a, b, c, d);
		assertEquals(51, hc.getp4());
	}

}
