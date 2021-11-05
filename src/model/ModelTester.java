package model;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.awt.Point;
import java.util.Iterator;

import org.junit.jupiter.api.Test;

import model.players.GamePlayer;
import model.players.Goalkeeper;
import model.players.Striker;

class ModelTester {

	@Test
	void playertest() {
		PlayerCollection gamePlayers=new PlayerCollection();;
		PlayerFactory playerFactory = new PlayerFactory();
		/*
		 * test for playercollection.add
		 */
		assertTrue(gamePlayers.add(playerFactory.getPlayer("Striker")));
		assertTrue(gamePlayers.add(playerFactory.getPlayer("Goalkeeper")));
		
		
		GamePlayer Goalkeeper = gamePlayers.get("Goalkeeper");
		GamePlayer Striker = gamePlayers.get("Striker");
		
	
		/*
		 * test for playercollection.get
		 */		
		assertEquals("class model.players.Striker",gamePlayers.get("Striker").getClass().toString());
		assertEquals("class model.players.Goalkeeper",gamePlayers.get("Goalkeeper").getClass().toString());
		assertEquals(null,gamePlayers.get("abc"));
		/*
		 * test for playFactory
		 */
		assertEquals("class model.players.Striker",playerFactory.getPlayer("Striker").getClass().toString());
		assertEquals("class model.players.Goalkeeper",playerFactory.getPlayer("Goalkeeper").getClass().toString());
		assertEquals(null, playerFactory.getPlayer("abc"));
		
		Goalkeeper.setPlayerStatistics(4);
		Striker.setPlayerStatistics(2);
		/*
		 * test for getPlayerStatistics
		 */		
		assertEquals(4,Goalkeeper.getPlayerStatistics());
		assertEquals(2,Striker.getPlayerStatistics());
		
		/*
		 * test for PlayerCollectionIterator and PlayerCollection.sort
		 */		
		gamePlayers.sort();
		Iterator<GamePlayer> ip = (PlayerCollectionIterator<GamePlayer>) gamePlayers.iterator();
		assertTrue(ip.hasNext());
		
		assertEquals(4,ip.next().getPlayerStatistics());
		assertEquals(2,ip.next().getPlayerStatistics());
		assertFalse(ip.hasNext());
		/*
		 * test for toString
		 */
		assertEquals("Goalkeeper caught 4 balls",Goalkeeper.toString());
		assertEquals("Striker scored 2 goals",Striker.toString());
	}
	
	@Test
	public void moveTest() {
		Striker striker = new Striker("Striker", Color.red);
		striker.setInitialPosition();;
		//initial position 500,450
		//usual movement = 5
		
		striker.moveLeft();// should be 500-5,450 = 495, 450
		assertEquals(495,striker.getPlayerPosition().getX());
		assertEquals(450,striker.getPlayerPosition().getY());
		
		striker.moveRight();// should be the initial position
		assertEquals(500,striker.getPlayerPosition().getX());
		assertEquals(450,striker.getPlayerPosition().getY());
		
		striker.moveUp();// should be 500, 450-5 = 500, 445
		assertEquals(500,striker.getPlayerPosition().getX());
		assertEquals(445,striker.getPlayerPosition().getY());
		
		striker.moveDown();// should be the initial position
		assertEquals(500,striker.getPlayerPosition().getX());
		assertEquals(450,striker.getPlayerPosition().getY());
		
		
		Goalkeeper goalkeeper = new Goalkeeper("Goalkeeper", Color.red);
		goalkeeper.setInitialPosition();//initial position 280, 70
		// default movement step for goal keeper = 10; (for left and right)
		
		goalkeeper.moveLeft();// should be 280-movement step, 70 = 270, 70
		assertEquals(270,goalkeeper.getPlayerPosition().getX());
		assertEquals(70,goalkeeper.getPlayerPosition().getY());
		
		goalkeeper.moveRight();// should be the initial position
		assertEquals(280,goalkeeper.getPlayerPosition().getX());
		assertEquals(70,goalkeeper.getPlayerPosition().getY());
		
		goalkeeper.moveDown();// should be 280, 70+5 = 280, 80
		assertEquals(280,goalkeeper.getPlayerPosition().getX());
		assertEquals(75,goalkeeper.getPlayerPosition().getY());
		
		goalkeeper.moveUp();// should be the initial position
		assertEquals(280,goalkeeper.getPlayerPosition().getX());
		assertEquals(70,goalkeeper.getPlayerPosition().getY());
		
		int x=goalkeeper.getPlayerPosition().x;
		goalkeeper.moveRandomly();
		//it moves randomly to left or right
		//So, check whether the x position was changed
		assertTrue(goalkeeper.getPlayerPosition().getX()!=x);
	}
	
	@Test
	public void soccerTest(){
		SoccerGame game = new SoccerGame();
		assertNotNull(game);
		// check whether the SoccerGame object was created
		
		// check setter and getter of remaining time
		game.setTimeRemaining(50);
		assertTrue(game.getTimeRemaining()==50);
		
		// check setter and getter of score
		game.setGoal(2);
		assertTrue(game.getGoal()==2);
		
		// check setter and getter of pause
		game.setPaused(false);
		assertTrue(game.isPaused()==false);
		game.setPaused(true);
		assertTrue(game.isPaused()==true);
		
		// check setter and getter of game over
		game.setOver(true);
		assertTrue(game.isOver()==true);
		game.setOver(false);
		assertTrue(game.isOver()==false);
		
		
		PlayerCollection players = game.getGamePlayers();
		assertEquals("Striker", players.get("Striker").getPlayerName());
		assertEquals("Goalkeeper",players.get("Goalkeeper").getPlayerName());
		// check whether players in SoccerGame were created
		
		assertEquals("Striker",game.getActivePlayer().getPlayerName());
		// check whether active player is striker
		
		SoccerBall ball = SoccerBall.getSoccerBall();
		ball.setPosition(game.getGamePlayers().get("Goalkeeper").getPlayerPosition());
		assertTrue(ball.getPosition().x==280);
		assertTrue(ball.getPosition().y==70);
		// Set the ball goalkeeper's initial position(280,70) and move goal keeper.
		// and check it.
		
		
		game.automateGoalkeeper();
		// Then, goal keeper should block the ball and get one score.
		assertEquals(1,game.getGamePlayers().get("Goalkeeper").getPlayerStatistics());
		
		
		// In the above test, goal was kicked out.
		// So check that the ball is not in gate.
		assertFalse(ball.inGate());
		
		// Set the ball in the gate range(180<x<400,10<y<60) and check it.
		ball.setPosition(new Point(200,40));
		assertTrue(ball.inGate());
		
		// Also check whether it is scored when the ball is in gate.
		assertTrue(game.isScored());
	}
}
