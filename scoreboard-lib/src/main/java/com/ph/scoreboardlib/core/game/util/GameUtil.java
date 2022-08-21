/**
 * 
 */
package com.ph.scoreboardlib.core.game.util;

import java.util.TreeSet;

import com.ph.scoreboardlib.core.game.Game;
import com.ph.scoreboardlib.core.game.GameStatus;

/**
 * @author Pratip
 *
 */
public class GameUtil {

	/**
	 * validate a game to start a new game
	 * @param scores
	 * @param game
	 * @return boolean
	 */
	public static boolean validateGameForCreate(TreeSet<Game> scores, Game game) {
		if(null == game) {
			System.out.println("Invalid Game: Game is not instantiated");
			return false;
		} else if (scores.contains(game)) {
			System.out.println("Invalid Game: Game is already started");
			return false;
		}
		return true;
	}

	/**
	 * validate a game to update a in progress game
	 * @param scores
	 * @param game
	 * @return boolean
	 */
	public static boolean validateGameForUpdate(TreeSet<Game> scores, Game game) {
		if(null == game) {
			System.out.println("Invalid Game: Game is not instantiated");
			return false;
		} else if (!scores.contains(game)) {
			System.out.println("Invalid Game: Game is not started yet");
			return false;
		} else if (GameStatus.FINISH == game.getStatus()){
			System.out.println("Invalid Game: FINISHED Game can not be updated");
			return false;
		}
		return true;
	}

	/**
	 * validate a game to remove a in progress game
	 * @param scores
	 * @param game
	 * @return boolean
	 */
	public static boolean validateGameForFinish(TreeSet<Game> scores, Game game) {
		if(null == game) {
			System.out.println("Invalid Game: Game is not instantiated");
			return false;
		} else if (!scores.contains(game)) {
			System.out.println("Invalid Game: no Game found to finish");
			return false;
		}
		return true;
	}

}
