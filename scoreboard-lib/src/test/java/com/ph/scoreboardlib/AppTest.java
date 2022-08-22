package com.ph.scoreboardlib;

import org.junit.jupiter.api.Test;

import com.ph.scoreboardlib.core.game.Game;
import com.ph.scoreboardlib.core.game.GameStatus;
import com.ph.scoreboardlib.core.game.builder.GameBuilder;
import com.ph.scoreboardlib.core.game.exception.GameCreatationException;
import com.ph.scoreboardlib.core.scoreboard.Scoreboard;

/**
 * Unit test for simple App.
 */
public class AppTest {
	/**
	 * Rigorous Test :-)
	 * 
	 * @throws GameCreatationException
	 * @throws InterruptedException 
	 */
	@Test
	public void shouldAnswerWithTrue() throws GameCreatationException, InterruptedException {
		Scoreboard scoreboard = Scoreboard.getInstance();

		Game game1 = new GameBuilder("Mexico", "Canada").build();
		scoreboard.createGame(game1);

		Game game2 = new GameBuilder("Spain", "Brazil").build();
		scoreboard.createGame(game2);

		Game game3 = new GameBuilder("Germany", "France").build();
		scoreboard.createGame(game3);

		Game game4 = new GameBuilder("Uruguay", "Italy").build();
		scoreboard.createGame(game4);

		Game game5 = new GameBuilder("Argentina", "Australia").build();
		scoreboard.createGame(game5);

		System.out.println("=========Creation Summary Scoreboard=================");
		scoreboard.summary();

		System.out.println("=========Game Update=================");

		game1 = new GameBuilder("Mexico", "Canada").homeScore(0).awayScore(5).status(GameStatus.IN_PROGRESS).build();
		scoreboard.updateGame(game1);
		Thread.sleep(1000);

		game2 = new GameBuilder("Spain", "Brazil").homeScore(10).awayScore(2).status(GameStatus.IN_PROGRESS).build();
		scoreboard.updateGame(game2);
		Thread.sleep(1000);

		game3 = new GameBuilder("Germany", "France").homeScore(2).awayScore(2).status(GameStatus.IN_PROGRESS).build();
		scoreboard.updateGame(game3);
		Thread.sleep(1000);

		game4 = new GameBuilder("Uruguay", "Italy").homeScore(6).awayScore(6).status(GameStatus.IN_PROGRESS).build();
		scoreboard.updateGame(game4);
		Thread.sleep(1000);

		game5 = new GameBuilder("Argentina", "Australia").homeScore(3).awayScore(1).status(GameStatus.IN_PROGRESS)
				.build();
		scoreboard.updateGame(game5);

		Thread.sleep(1000);

		System.out.println("==========Update Summary Scoreboard================");
		scoreboard.summary();
		
		System.out.println("==========Game Finished ================");
		game3 = new GameBuilder("Germany", "France").status(GameStatus.FINISH).build();
		scoreboard.finshGame(game3);
		
		System.out.println("==========Finish Summary Scoreboard================");
		scoreboard.summary();
	}
}
