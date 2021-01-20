package com.game.snl.model;

import java.util.List;

public class Game {
	private GameBoard gameBoard;
	private List<Player> players;
	private Dice dice;
	
	public Game(GameBoard gameBoard, List<Player> players, Dice dice) {
		super();
		this.gameBoard = gameBoard;
		this.players = players;
		this.dice = dice;
	}

	public GameBoard getGameBoard() {
		return gameBoard;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public Dice getDice() {
		return dice;
	}
	
}
