/**
 * 
 */
package com.ph.scoreboardlib.core.scoreboard;

import java.util.TreeSet;

import com.ph.scoreboardlib.core.game.Game;

/**
 * @author Pratip
 * 
 */
public class Scoreboard {
	private static Scoreboard scoreboard;
	private TreeSet<Game> scores;
	
	/**
	 * @param Game
	 * @return boolean value true for successfully updated the scoreboard
	 */
	public boolean createGame(Game game) {
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
