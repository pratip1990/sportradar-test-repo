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

}
