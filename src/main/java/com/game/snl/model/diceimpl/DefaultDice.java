package com.game.snl.model.diceimpl;

import java.util.Random;

import com.game.snl.model.Dice;

/**
 * Default dice generates all numbers from 1 to 6 
 *
 */
public class DefaultDice implements Dice {

	private Random rnd = new Random();
	
	public int rollDice() {
		int num = -1;
		
		do {
			num = Math.abs(rnd.nextInt(7)) ;
		}while(num == 0);
		
		return num;
	}

}
