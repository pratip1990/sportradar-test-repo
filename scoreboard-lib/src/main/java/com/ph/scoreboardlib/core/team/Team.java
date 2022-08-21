/**
 * 
 */
package com.ph.scoreboardlib.core.team;

import java.util.Objects;

/**
 * @author Pratip
 *
 */
public class Team {
	private final String name;
	private Integer score;
	public Team(String name) {
		this.name = name;
		this.score = 0;
	}
	public String getName() {
		return name;
	}
	
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return "Team [name=" + name + ", score=" + score + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Team other = (Team) obj;
		return Objects.equals(name, other.name);
	}
}
