package com.game.snl.runner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.game.snl.generators.GameGenerator;
import com.game.snl.model.DiceTypes;
import com.game.snl.model.Game;
import com.game.snl.model.Player;
import com.game.snl.model.Snake;

public class DescendingSnakeTests {
	
	@Test
	public void PlayerWithSnakeTest() {
		
		Player player = new Player("AAA");
		int startPosition = 14;
		player.setPosition(startPosition);
		
		List<Player> players = Arrays.asList(player);
		
		GameGenerator gameGen = new GameGenerator();
		
		Map<Integer, Snake> snakes = new HashMap<>();
		snakes.put(14, new Snake(14, 7));
		
		Game customGame = gameGen.generateCustomGame(players, DiceTypes.DEFAULT_DICE, snakes, null);
		
		GameRunner runner = new GameRunner(customGame, players, 1);
		
		runner.handlePlayerPosition(player, 14);
		
		int newPosition = player.getPosition();
		
		Assertions.assertTrue(newPosition < startPosition, "Player has not descended from snake at " + startPosition + "!!");
		
	}

}
