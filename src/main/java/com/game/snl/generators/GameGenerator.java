package com.game.snl.generators;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.game.snl.model.Dice;
import com.game.snl.model.DiceFactory;
import com.game.snl.model.DiceTypes;
import com.game.snl.model.Game;
import com.game.snl.model.GameBoard;
import com.game.snl.model.Ladder;
import com.game.snl.model.Player;
import com.game.snl.model.Snake;

public class GameGenerator {
	
	public static final int boardSize = 100;
	
	public Game generateDefaultGame(List<Player> players, DiceTypes type) {
		Map<Integer, Snake> snakes = generateSnakes();
		Map<Integer, Ladder> ladders = generateLadders();
		
		GameBoard board = new GameBoard(boardSize, snakes, ladders);
		
		final Dice dice = DiceFactory.getDice(type);
		
		return new Game(board, players, dice);
	}
	
	private Map<Integer, Snake> generateSnakes(){
		
		Map<Integer, Snake> snakes = new HashMap<>();
		
		snakes.put(98, new Snake(98, 13));
		snakes.put(93, new Snake(93, 37));
		snakes.put(83, new Snake(83, 22));
		snakes.put(89, new Snake(89, 51));
		snakes.put(69, new Snake(69, 33));
		snakes.put(68, new Snake(68, 2));
		snakes.put(64, new Snake(64, 24));
		snakes.put(59, new Snake(59, 18));
		
		return snakes;
	}
	
	private Map<Integer, Ladder> generateLadders(){
		Map<Integer, Ladder> ladders = new HashMap<>();

		ladders.put(8, new Ladder(8, 26));
		ladders.put(19, new Ladder(19, 38));
		ladders.put(21, new Ladder(21, 82));
		ladders.put(28, new Ladder(28, 53));
		ladders.put(36, new Ladder(36, 57));
		ladders.put(43, new Ladder(43, 77));
		ladders.put(50, new Ladder(50, 91));
		ladders.put(54, new Ladder(54, 88));
		ladders.put(61, new Ladder(61, 99));
		ladders.put(62, new Ladder(62, 96));
		ladders.put(66, new Ladder(66, 87));

		return ladders;
	}
}
