package com.game.snl.model;

import java.util.Map;

public class GameBoard {
	
	private int size;
	
	private Map<Integer, Snake> snakes;
	
	private Map<Integer, Ladder> ladders;

	public GameBoard(int size, Map<Integer, Snake> snakes, Map<Integer, Ladder> ladders) {
		this.size = size;
		this.snakes = snakes;
		this.ladders = ladders;
	}

	public int getSize() {
		return size;
	}

	public Map<Integer, Snake> getSnakes() {
		return snakes;
	}

	public Map<Integer, Ladder> getLadders() {
		return ladders;
	}

	
}
