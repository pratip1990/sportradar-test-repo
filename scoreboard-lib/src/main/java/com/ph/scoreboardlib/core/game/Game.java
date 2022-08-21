package com.ph.scoreboardlib.core.game;

import java.time.LocalDateTime;
import java.util.Objects;

import com.ph.scoreboardlib.core.team.Team;

public class Game {
	private Team home;
	private Team away;
	private GameStatus status;
	private int totalScore;
	private LocalDateTime startTime;
	private LocalDateTime updateTime;
	
	public Game(Team home, Team away) {
		super();
		this.home = home;
		this.away = away;
		this.status = GameStatus.START;
		this.totalScore = home.getScore() + away.getScore();
		this.startTime = LocalDateTime.now();
		this.updateTime = this.startTime;
	}
	
	public Team getHome() {
		return home;
	}
	public void setHome(Team home) {
		this.home = home;
	}
	public Team getAway() {
		return away;
	}
	public void setAway(Team away) {
		this.away = away;
	}
	public GameStatus getStatus() {
		return status;
	}
	public void setStatus(GameStatus status) {
		this.status = status;
	}
	public int getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	public LocalDateTime getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}
	
	@Override
	public String toString() {
		return "Game [home=" + home + ", away=" + away + ", status=" + status + ", totalScore=" + totalScore
				+ ", startTime=" + startTime + ", updateTime=" + updateTime + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(away, home);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		return Objects.equals(away, other.away) || Objects.equals(home, other.home);
	}
}
