package com.game.snl.runner;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.game.snl.generators.GameGenerator;
import com.game.snl.model.DiceTypes;
import com.game.snl.model.Game;
import com.game.snl.model.Ladder;
import com.game.snl.model.Player;
import com.game.snl.model.Snake;

public class GameRunner {
	
	private List<Player> players = new ArrayList<>();
	private Game game = null;
	private int turns = -1;
	
	public Player playSnakeAndLadders() {
		return this.playSnakeAndLadders(DiceTypes.DEFAULT_DICE);
	}
	
	public Player playSnakeAndLadders(DiceTypes type) {
		this.initializeGame(type);
		this.play();
		return this.getWinner();
	}
	
	public Player playCustomSnakeAndLadders() {
		this.play();
		return this.getWinner();
	}
	
	public GameRunner(List<Player> players, int turns) {
		Objects.requireNonNull(players, "Players can not be null!!");
		
		this.players.addAll(players);
		this.turns = turns <= 0 ? -1 : turns;
	}
	
	public GameRunner(Game game, List<Player> players, int turns) {
		Objects.requireNonNull(players, "Players can not be null!!");
		
		this.game = game;
		this.players.addAll(players);
		this.turns = turns <= 0 ? -1 : turns;
	}
	
	
	private void initializeGame(DiceTypes type) {
		GameGenerator gen = new GameGenerator();
		game = gen.generateDefaultGame(players, type);
	}
	
	private void play() {
		
		while(! isGameCompleted() ) {
			for(Player p : players) {
				System.out.printf("Player: %s is playing. Current cell is: %d \n",
									p.getName(), p.getPosition());
				int diceOp = p.throwDice(game.getDice());
				
				System.out.printf("Player: %s thrown dice and got output: %d \n", p.getName(), diceOp);
				
				int pos = diceOp + p.getPosition();
				
				if(pos > 100) {
					System.out.printf("Play next turn till you get %d as Dice output \n", (100 - p.getPosition()));
					continue;
				}
			
				handlePlayerPosition(p, pos);
			}
			this.turns--;
		}
	}

	void handlePlayerPosition(Player p, int pos) {
		
		final Map<Integer, Ladder> ladders = game.getGameBoard().getLadders();
		final Map<Integer, Snake> snakes = game.getGameBoard().getSnakes();
		
		System.out.printf("Player: %s moved to %d.\n", p.getName(), pos);
		
		// Handling snake and ladder in a cell
		if(ladders.containsKey(pos)) {
			Ladder ladr =  ladders.get(pos);
			pos = ladr.getEnd();
			System.out.printf("Player: %s climbed ladder from position %d to %d.\n", 
						p.getName(), ladr.getStart(), ladr.getEnd());
		}else if(snakes.containsKey(pos)) {
			Snake snke = snakes.get(pos);
			pos = snke.getEnd();
			System.out.printf("Player: %s descended snake from position %d to %d.\n", 
					p.getName(), snke.getStart(), snke.getEnd());
		}
		
		p.setPosition(pos);
	}
	
	private boolean isGameCompleted() {
		// if number of turns are positive and if turns == 0 
		if(this.turns != -1 && turns == 0){
			System.out.println("All turns are completed. Player with max position is the winner.");
			return true;
		}
		
		// if any player has reached max position
		return players.stream().anyMatch(p -> p.getPosition() == game.getGameBoard().getSize());
	}

	private Player getWinner(){
		return players.stream().max(Comparator.comparingInt(Player::getPosition)).get();
	}
}
