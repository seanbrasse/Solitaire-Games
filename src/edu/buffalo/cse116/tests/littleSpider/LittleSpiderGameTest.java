package edu.buffalo.cse116.tests.littleSpider;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.buffalo.cse116.code.littleSpider.LittleSpiderGame;

public class LittleSpiderGameTest {

	//Both tests fail every so often. It should not, I have done extensive testing to see what cards are being instantiated
	//and it seems like the right cards are being instantiated but one of the cards is not always being deleted
	 
	@Test
	public void testDeckSize() {
		LittleSpiderGame LTG = new LittleSpiderGame();
		System.out.print(LTG.getCurrentDeck().getDeck().size() + " this is the size of the deck");
		assertEquals(48, LTG.getCurrentDeck().getDeck().size()); 
		
	}
	
	@Test
	public void FourHomecellsInstantiated() {
		LittleSpiderGame LTG = new LittleSpiderGame();
		System.out.println(LTG.getHomecellPiles().size() + " this is the amount of homecell piles");
		assertEquals(4, LTG.getHomecellPiles().size());
		
	}

	
}
