import java.util.Arrays;
import java.util.List;

import com.game.snl.model.Player;
import com.game.snl.runner.GameRunner;

public class App {

	public static void main(String[] args) {
		
		System.out.println("Starting Snake And Ladders Game..");
		
		List<Player> players = Arrays.asList(new Player("AAA"), new Player("BBB")); 
		
		GameRunner runner = new GameRunner(players, 5);
		Player winner = runner.playSnakeAndLadders();
		
		System.out.printf("Player : %s is winner!!!\n", winner.getName());
		
		System.out.println("Snake And Ladders Game Ended!!!");
	}
}
