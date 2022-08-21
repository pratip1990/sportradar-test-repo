/**
 * 
 */
package com.ph.scoreboardlib.core.game.builder;

import com.ph.scoreboardlib.core.game.Game;
import com.ph.scoreboardlib.core.game.GameStatus;
import com.ph.scoreboardlib.core.team.Team;

/**
 * @author Pratip
 *
 */
public class GameBuilder {
	private Team homeTeam;
	private int homeScore;
	private Team awayTeam;
	private int awayScore;
	private GameStatus status;

	public GameBuilder(String homeTeam, String awayTeam){
		this.homeTeam = new Team(homeTeam);
		this.awayTeam = new Team(awayTeam);
		this.status = GameStatus.START;
	}
	
	public GameBuilder status(GameStatus status) {
		this.status = status;
		return this;
	}

	public Game build() {
		// TODO Auto-generated method stub
		return null;
	}
}
