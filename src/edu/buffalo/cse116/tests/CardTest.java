package edu.buffalo.cse116.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.buffalo.cse116.code.Card;

public class CardTest 
{
	@Test
	public void testCanBuild()
	{
		Card baseCard = new Card(0,1);
		Card buildCardUp = new Card(0,2);
		Card buildCardDown = new Card(0,0);
		Card buildCardUpDifferentSuit = new Card(1,2);
		Card buildCardDownDifferentSuit = new Card(2, 0);
		Card failBuilding = new Card(3,3);
		
		assertTrue(baseCard.canBuild(buildCardUp));
		assertTrue(baseCard.canBuild(buildCardDown));
		assertTrue(baseCard.canBuild(buildCardUpDifferentSuit));
		assertTrue(baseCard.canBuild(buildCardDownDifferentSuit));
		assertFalse(baseCard.canBuild(failBuilding));
	}
	
	@Test
	public void testCanWrap()
	{
		Card aceCard = new Card(0,0);
		Card kingCard = new Card(0,12);
		Card kingCardDifferentSuit = new Card(3,12);
		Card cantWrapCard = new Card(2,2);
		
		assertTrue(aceCard.canWrap(kingCard));
		assertTrue(aceCard.canWrap(kingCardDifferentSuit));
		assertTrue(kingCard.canWrap(aceCard));
		assertFalse(kingCard.canWrap(cantWrapCard));
		assertFalse(aceCard.canWrap(cantWrapCard));
	}
	
	@Test
	public void testCanBuildUp()
	{
		Card baseCard = new Card(1,0);
		Card buildUpCard = new Card(1,1);
		
		assertTrue(baseCard.canBuildUp(buildUpCard));
	}
	
	@Test
	public void testCanBuildDown()
	{
		Card baseCard = new Card(3, 12);
		Card buildDownCard = new Card(3, 11);
		
		assertTrue(baseCard.canBuildDown(buildDownCard));
	}
	
	@Test
	public void testIsSameSuit()
	{
		Card baseCard = new Card(0,0);
		Card otherCard = new Card(0,3);
		
		assertTrue(baseCard.isSameSuit(otherCard));
	}
}
