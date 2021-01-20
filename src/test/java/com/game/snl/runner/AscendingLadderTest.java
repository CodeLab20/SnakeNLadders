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
import com.game.snl.model.Ladder;
import com.game.snl.model.Player;

public class AscendingLadderTest {
	
	@Test
	public void PlayerWithLadderTest() {
		
		Player player = new Player("AAA");
		int startPosition = 7;
		player.setPosition(startPosition);
		
		List<Player> players = Arrays.asList(player);
		
		GameGenerator gameGen = new GameGenerator();
		
		Map<Integer, Ladder> ladders = new HashMap<>();
		ladders.put(7, new Ladder(7, 14));
		
		Game customGame = gameGen.generateCustomGame(players, DiceTypes.DEFAULT_DICE, null, ladders);
		
		GameRunner runner = new GameRunner(customGame, players, 1);
		
		runner.handlePlayerPosition(player, 7);
		
		int newPosition = player.getPosition();
		
		Assertions.assertTrue(newPosition > startPosition, "Player has not ascended using ladder at " + startPosition + "!!");
		
	}

}
