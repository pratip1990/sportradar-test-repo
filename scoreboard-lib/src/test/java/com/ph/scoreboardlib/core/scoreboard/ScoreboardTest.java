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
	 */
	@Test
	@Order(2)
	void testCreateGame() {
		Game game = new GameBuilder("Germany", "France").status(GameStatus.START).build();
		Scoreboard scoreboard = Scoreboard.getInstance();
		boolean actual = scoreboard.createGame(game);
		assertEquals(true, actual);
	}

	/**
	 * Test method for {@link com.ph.scoreboardlib.core.scoreboard.Scoreboard#updateGame(com.ph.scoreboardlib.core.game.Game)}.
	 */
	@Test
	void testUpdateGame() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.ph.scoreboardlib.core.scoreboard.Scoreboard#finshGame(com.ph.scoreboardlib.core.game.Game)}.
	 */
	@Test
	void testFinshGame() {
		fail("Not yet implemented");
	}

}
