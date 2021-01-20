package com.snl.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.game.snl.model.Dice;
import com.game.snl.model.DiceFactory;
import com.game.snl.model.DiceTypes;

public class DiceTests {

	@Test
	public void rollEvenDice() {
		
		System.out.println("Testing outcome of even dice");
		
		Dice dice = DiceFactory.getDice(DiceTypes.EVEN_DICE);
		
		for(int i =0 ; i< 1000; i++) {
			final int output = dice.rollDice();
			Assertions.assertTrue(output % 2 == 0, "Even Dice is outcome is odd!!");
		}
		
		System.out.println("\n\n Dice produced even outcome for 1000 times");
	}
	
}
