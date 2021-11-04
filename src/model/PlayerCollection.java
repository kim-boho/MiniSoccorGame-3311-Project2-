package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import model.players.GamePlayer;

public class PlayerCollection implements Iterable<GamePlayer>{
	
	private static ArrayList<GamePlayer> players;
	
	public PlayerCollection() {
		players = new ArrayList<GamePlayer>();
	}
	public boolean add(GamePlayer player) {
		if(player.getPlayerName().equalsIgnoreCase("Striker") 
				|| player.getPlayerName().equalsIgnoreCase("Goalkeeper")) {
			players.add(player);
			return true;
		}
		return false;
	}
	public GamePlayer get(String playerType) {
		if(playerType.equalsIgnoreCase("Striker")) {
			for(GamePlayer p:players) {
				if(p.getPlayerName().equalsIgnoreCase("Striker")) {
					return p;
				}
			}
		} else if(playerType.equalsIgnoreCase("Goalkeeper")) {
			for(GamePlayer p:players) {
				if(p.getPlayerName().equalsIgnoreCase("Goalkeeper")) {
					return p;
				}
			}
		}
		return null;
	}
	
	public void sort() {
		Collections.sort(players);
	}
	@Override
	public Iterator<GamePlayer> iterator() {
		// TODO Auto-generated method stub
		Iterator<GamePlayer> iter = new PlayerCollectionIterator<GamePlayer>(players);
		return iter;
	}
	
}
