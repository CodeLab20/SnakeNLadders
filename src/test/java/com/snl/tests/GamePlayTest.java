package com.snl.tests;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.game.snl.model.Player;
import com.game.snl.runner.GameRunner;

public class GamePlayTest {

	@Test
	public void multiplayerGamePlayTest() {
		
		Player p1 = new Player("AAA");
		Player p2 = new Player("BBB");
		Player p3 = new Player("CCC");
		Player p4 = new Player("DDD");
		
		
		List<Player> players = Arrays.asList(p1, p2, p3, p4);
		
		GameRunner runner = new GameRunner(players, -1);
		
		Player winner = runner.playSnakeAndLadders();
		
		int newPosition = winner.getPosition();
		
		System.out.println("Winner is:" + winner.getName());
		
		Assertions.assertTrue(newPosition == 100, winner.getName() + " is not winner.");
	}
	
	
	@Test
	public void noPlayerGamePlayTest() {
		
		List<Player> players = Collections.EMPTY_LIST;
		
		Assertions.assertThrows(IllegalArgumentException.class, ()-> new GameRunner(players, -1), "IllegalArgumentException is not thrown.");
	}
	
	@Test
	public void nullPlayerGamePlayTest() {
		
		List<Player> players = null;
		
		Assertions.assertThrows(NullPointerException.class, ()-> new GameRunner(players, -1), "NullPointerException is not thrown.");
	}
}
