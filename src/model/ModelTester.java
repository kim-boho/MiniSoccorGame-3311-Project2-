package model;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
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
		GamePlayer striker = new Striker("Striker", Color.red);
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
		
		
		GamePlayer goalkeeper = new Goalkeeper("Goalkeeper", Color.red);
		goalkeeper.setInitialPosition();//initial position 280, 70
		// movementstep for goalkeeper = 10;
		
		goalkeeper.moveLeft();// should be 280-movementstep, 70 = 270, 70
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
		
	}

}
