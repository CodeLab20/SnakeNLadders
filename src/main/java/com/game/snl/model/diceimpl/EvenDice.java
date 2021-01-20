package com.game.snl.model.diceimpl;

import java.util.Random;

import com.game.snl.model.Dice;

/**
 * Even dice generates only even numbers i.e. 2,4,6 
 */
public class EvenDice implements Dice {

	private Random rnd = new Random();
	
	public int rollDice() {
		int num = 0;
		
		do {
			num = Math.abs(rnd.nextInt(7));
		}while(num == 0);

		/*
		 * As this is even dice, we need to increment odd number by 1
		 */
		
		return (num % 2 == 1) ? ++num : num;
	}

}
