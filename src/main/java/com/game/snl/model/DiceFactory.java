package com.game.snl.model;

import com.game.snl.model.diceimpl.DefaultDice;
import com.game.snl.model.diceimpl.EvenDice;

public class DiceFactory {

	public static Dice getDice(DiceTypes type) {
		switch(type) {
		
		case EVEN_DICE:return new EvenDice();
		
		default:
			return new DefaultDice();
		}
	}
}
