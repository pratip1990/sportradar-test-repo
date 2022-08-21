/**
 * 
 */
package com.ph.scoreboardlib.core.scoreboard;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.ph.scoreboardlib.core.game.Game;
import com.ph.scoreboardlib.core.game.GameStatus;
import com.ph.scoreboardlib.core.game.builder.GameBuilder;
import com.ph.scoreboardlib.core.game.exception.GameCreatationException;

/**
 * @author Pratip
 *
 */
@TestMethodOrder(OrderAnnotation.class)
class ScoreboardTest {

	@Test
	@Order(1)
	void testGetInstance() {
		Scoreboard scoreboard = Scoreboard.getInstance();
		assertNotEquals(scoreboard, null);
	}
	
	
	/**
	 * Test method for {@link com.ph.scoreboardlib.core.scoreboard.Scoreboard#createGame(com.ph.scoreboardlib.core.game.Game)}.
	 * @throws GameCreatationException 
	 */
	@Test
	@Order(2)
	void testCreateGame() throws GameCreatationException {
		Game game = new GameBuilder("Germany", "France").status(GameStatus.START).build();
		Scoreboard scoreboard = Scoreboard.getInstance();
		boolean actual = scoreboard.createGame(game);
		assertEquals(true, actual);
	}

	/**
	 * Test method for {@link com.ph.scoreboardlib.core.scoreboard.Scoreboard#updateGame(com.ph.scoreboardlib.core.game.Game)}.
	 * @throws GameCreatationException 
	 */
	@Test
	@Order(3)
	void testUpdateGame() throws GameCreatationException {
		Game game = new GameBuilder("Germany", "France").status(GameStatus.IN_PROGRESS).homeScore(0).awayScore(1).build();
		Scoreboard scoreboard = Scoreboard.getInstance();
		boolean actual = scoreboard.updateGame(game);
		assertEquals(true, actual);
	}

	/**
	 * Test method for {@link com.ph.scoreboardlib.core.scoreboard.Scoreboard#finshGame(com.ph.scoreboardlib.core.game.Game)}.
	 */
	@Test
	@Order(4)
	void testFinshGame() {
		fail("Not yet implemented");
	}

}
