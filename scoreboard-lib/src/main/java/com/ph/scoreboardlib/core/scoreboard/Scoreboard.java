/**
 * 
 */
package com.ph.scoreboardlib.core.scoreboard;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.locks.ReentrantReadWriteLock;

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
	private ReentrantReadWriteLock lock;
	
	private Scoreboard() {
		Comparator<Game> gameComparator = Comparator.comparing(Game::getTotalScore).thenComparing(Game::getUpdateTime)
				.reversed();
		scores = new TreeSet<>(gameComparator);
		lock = new ReentrantReadWriteLock();
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
	 * @param Game New created Game
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

	/**
	 * 
	 * @return boolean value true for successfully updated the scoreboard
	 */
	public boolean updateGame(Game game) {
		boolean updtFlg = false;
		boolean validGameFlg = GameUtil.validateGameForUpdate(scores, game);
		if (validGameFlg && GameStatus.FINISH != game.getStatus()) {
			game.setStatus(GameStatus.IN_PROGRESS);
			updtFlg = updateScoreboard(GameStatus.IN_PROGRESS, game);
			System.out.println("Game is updated with the new score");
		} else {
			System.out.println("Can not update the START Game Status");
		}
		return updtFlg;
	}

	/**
	 * 
	 * @return boolean value true for successfully updated the scoreboard
	 */
	public boolean finshGame(Game game) {
		return false;
	}
	
	private boolean updateScoreboard(GameStatus gameStatus, Game game) {
		lock.writeLock().lock();
		boolean updtFlg = false;
		if (GameStatus.FINISH == gameStatus) {
			scores.remove(game);
			System.out.println("Game Removed");
			updtFlg = true;
		} else if (GameStatus.FINISH != gameStatus) {
			scores.add(game);
			System.out.println("Game Add or Updated in Scoreboard");
			updtFlg = true;
		}
		lock.writeLock().unlock();
		return updtFlg;
	}

	public Set<Game> get() {
		Set<Game> temp = new LinkedHashSet<>();
		scores.forEach(a -> {
			temp.add(a);
		});
		System.out.println(temp);
		return temp;
	}

}
