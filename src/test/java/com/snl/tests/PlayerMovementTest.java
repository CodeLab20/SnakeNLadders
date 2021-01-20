package com.snl.tests;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.game.snl.model.Player;
import com.game.snl.runner.GameRunner;

public class PlayerMovementTest {

	@Test
	public void PlayerTurnTest() {
		
		Player player = new Player("AAA");
		int startPosition = 15;
		player.setPosition(startPosition);
		
		List<Player> players = Arrays.asList(player);
		
		GameRunner runner = new GameRunner(players, 1);
		
		Player winner = runner.playSnakeAndLadders();
		
		int newPosition = winner.getPosition();
		
		Assertions.assertTrue(newPosition > startPosition, "Player is not moved from his initial position.");
	}
	
}
