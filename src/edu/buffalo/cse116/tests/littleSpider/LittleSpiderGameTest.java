package edu.buffalo.cse116.tests.littleSpider;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.buffalo.cse116.code.littleSpider.LittleSpiderGame;

public class LittleSpiderGameTest {

	//This test fails every so often. It should not, I have done extensive testing to see what cards are being instantiated
	//and it seems like the right cards are being instantiated but one of the cards is not always being deleted
	
	@Test
	public void testDeckSize() {
		LittleSpiderGame LTG = new LittleSpiderGame();
		assertEquals(48, LTG.getCurrentDeck().getDeck().size()); 
	}

	
}
