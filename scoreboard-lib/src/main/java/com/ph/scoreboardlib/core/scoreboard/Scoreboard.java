/**
 * 
 */
package com.ph.scoreboardlib.core.scoreboard;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.Collectors;

import com.ph.scoreboardlib.core.game.Game;
import com.ph.scoreboardlib.core.game.GameStatus;
import com.ph.scoreboardlib.core.game.util.GameUtil;

/**
 * @author Pratip
 * 
 */
public class Scoreboard {
	private static Scoreboard scoreboard;
	private Set<Game> scores;
	private ReentrantReadWriteLock lock;
	Comparator<Game> gameComparator;

	private Scoreboard() {
		gameComparator = Comparator.comparing(Game::getTotalScore).reversed();
		scores = new HashSet<>();
		lock = new ReentrantReadWriteLock();
	}

	/**
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
	 * Use to create new Game (Start a new game)
	 * 
	 * @param Game
	 * @return boolean value true for successfully updated the scoreboard
	 */
	public boolean createGame(Game game) {
		boolean updtFlg = false;
		boolean validGameFlg = GameUtil.validateGameForCreate(scores, game);
		if (validGameFlg && GameStatus.START == game.getStatus()) {
			game.setStatus(GameStatus.START);
			updtFlg = updateScoreboard(GameStatus.START, game);
			System.out.println("A new Game is created : " + game);
		} else {
			System.out.println("Invalid Game Details please check");
		}
		return updtFlg;
	}

	/**
	 * Use to update the scores of existing game
	 * 
	 * @param Game
	 * @return boolean value true for successfully updated the scoreboard
	 */
	public boolean updateGame(Game game) {
		boolean updtFlg = false;
		boolean validGameFlg = GameUtil.validateGameForUpdate(scores, game);
		if (validGameFlg && GameStatus.FINISH != game.getStatus()) {
			game.setStatus(GameStatus.IN_PROGRESS);
			updtFlg = updateScoreboard(GameStatus.IN_PROGRESS, game);
			System.out.println("Game is updated with the new score : "+ game);
		} else {
			System.out.println("Invalid Game Details please check");
		}
		return updtFlg;
	}

	/**
	 * Use to remove the finished game
	 * 
	 * @param Game
	 * @return boolean value true for successfully updated the scoreboard
	 */
	public boolean finshGame(Game game) {
		boolean updtFlg = false;
		boolean validGameFlg = GameUtil.validateGameForFinish(scores, game);
		if (validGameFlg) {
			game.setStatus(GameStatus.FINISH);
			updtFlg = updateScoreboard(GameStatus.FINISH, game);
			System.out.println("Game is finished");
		} else {
			System.out.println("Invalid Game Details please check");
		}
		return updtFlg;
	}

	private boolean updateScoreboard(GameStatus gameStatus, Game game) {
		lock.writeLock().lock();
		boolean updtFlg = false;
		if (GameStatus.FINISH == gameStatus) {
			scores.remove(game);
			//System.out.println("Game Removed");
			updtFlg = true;
		} else if (GameStatus.FINISH != gameStatus) {
			scores.add(game);
			//System.out.println("Game Add or Updated in Scoreboard");
			updtFlg = true;
		}
		lock.writeLock().unlock();
		return updtFlg;
	}

	/**
	 * Use to get the current state of scoreboard
	 * 
	 * @return Set<Game>
	 */
	public Set<Game> get() {
		lock.readLock().lock();
		Set<Game> temp = new LinkedHashSet<>();
		scores.forEach(a -> {
			temp.add(a);
		});
		lock.readLock().unlock();
		return temp;
	}
	
	public void summary() {
		List<Game> temp = scores.stream().sorted(gameComparator).collect(Collectors.toList());
		temp.forEach(a -> System.out.println(a));
	}

}
