package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

import model.players.GamePlayer;

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

}
