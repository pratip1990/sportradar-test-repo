/**
 * 
 */
package com.ph.scoreboardlib.core.scoreboard;

import java.util.Comparator;
import java.util.TreeSet;

import com.ph.scoreboardlib.core.game.Game;
import com.ph.scoreboardlib.core.game.GameStatus;
import com.ph.scoreboardlib.core.game.util.GameUtil;

/**
 * @author Pratip
 * 
 */
public class Scoreboard {
	private static Scoreboard scoreboard;
	private TreeSet<Game> scores;
	
	
	private Scoreboard() {
		Comparator<Game> gameComparator = Comparator.comparing(Game::getTotalScore).thenComparing(Game::getUpdateTime)
				.reversed();
		scores = new TreeSet<>(gameComparator);
	}

	/***
	 * This a thread safe process to create a Scoreboard. Multiple thread can access
	 * the Scoreboard
	 * 
	 * @return a Singleton object of Scoreboard
	 */
	public static Scoreboard getInstance() {
		if (null == scoreboard) {
			synchronized (Scoreboard.class) {
				if (null == scoreboard) {
					scoreboard = new Scoreboard();
				}
			}
		}
		return scoreboard;
	}
	
	/**
	 * @param Game
	 * @return boolean value true for successfully updated the scoreboard
	 */
	public boolean createGame(Game game) {
		boolean updtFlg = false;
		boolean validGameFlg = GameUtil.validateGameForCreate(scores, game);
		if (validGameFlg && GameStatus.START == game.getStatus()) {
			game.setStatus(GameStatus.START);
			updtFlg = updateScoreboard(GameStatus.START, game);
			System.out.println("Game is updated with the new score");
		} else {
			System.out.println("Invalid Game Details please check");
		}
		return updtFlg;
	}

	private boolean updateScoreboard(GameStatus start, Game game) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 
	 * @return boolean value true for successfully updated the scoreboard
	 */
	public boolean updateGame(Game game) {
		return false;
	}

	/**
	 * 
	 * @return boolean value true for successfully updated the scoreboard
	 */
	public boolean finshGame(Game game) {
		return false;
	}

}
