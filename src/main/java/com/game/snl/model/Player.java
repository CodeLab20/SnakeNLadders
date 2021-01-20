package com.game.snl.model;

public class Player {
	private String name;
	private int position = 0;
	
	public int getPosition() {
		return position;
	}
	
	public void setPosition(int position) {
		this.position = position;
	}
	
	public String getName() {
		return name;
	}

	public Player(String name) {
		this.name = name;
	}

	public int throwDice(Dice dice) {
		return dice.rollDice();
	}
	
	
}
