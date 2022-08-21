/**
 * 
 */
package com.ph.scoreboardlib.core.game.builder;

import java.time.LocalDateTime;
import java.util.Set;

import com.ph.scoreboardlib.core.game.Game;
import com.ph.scoreboardlib.core.game.GameStatus;
import com.ph.scoreboardlib.core.game.exception.GameCreatationException;
import com.ph.scoreboardlib.core.scoreboard.Scoreboard;
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

	public Game build() throws GameCreatationException {
		Game game = null;
		if (null != this.homeTeam && null != this.awayTeam) {
			game = new Game(this.homeTeam, this.awayTeam);
			if (GameStatus.START == this.status) {
				startGame(game);
			} else if (GameStatus.IN_PROGRESS == this.status) {
				game = inProgressGame(game);
			} else if (GameStatus.FINISH == this.status) {
				game = finishGame(game);
			} else {
				throw new GameCreatationException("GameCreatationException : invalid Game Status");
			}
		} else {
			throw new GameCreatationException("GameCreatationException : homeTeam or away team is null");
		}
		
		return game;
	}

	private Game finishGame(Game game) {
		// TODO Auto-generated method stub
		return null;
	}

	private Game inProgressGame(Game game) {
		// TODO Auto-generated method stub
		return null;
	}

	private void startGame(Game game) throws GameCreatationException {
		Set<Game> scores = Scoreboard.getInstance().get();
		if (!scores.contains(game)) {
			game.setStartTime(LocalDateTime.now());
			game.setUpdateTime(game.getUpdateTime());
			game.setStatus(GameStatus.START);
			game.setTotalScore(game.getHome().getScore() + game.getAway().getScore());
		} else {
			throw new GameCreatationException("GameCreatationException : this game is not yet started");
		}
		
	}
}
