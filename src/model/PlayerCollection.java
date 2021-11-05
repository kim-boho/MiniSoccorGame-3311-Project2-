package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import model.players.GamePlayer;
/**
 * 
 * This is a class to collect GamePlayer objects that are used in application.
 *
 */
public class PlayerCollection implements Iterable<GamePlayer>{
	
	private static ArrayList<GamePlayer> players;
	
	/**
	 * Create PlayerCollection object.
	 */
	public PlayerCollection() {
		players = new ArrayList<GamePlayer>();
	}
	
	/**
	 * 
	 * @param player GamePlayer object
	 * @return true if player was added to list. Otherwise, return false.
	 */
	public boolean add(GamePlayer player) {
		if(player.getPlayerName().equalsIgnoreCase("Striker") 
				|| player.getPlayerName().equalsIgnoreCase("Goalkeeper")) {
			players.add(player);
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * @param playerType type of GamePlayer
	 * @return GamePlayer that is the same type to playerType.
	 * If there is no type such as playerType, return null.
	 */
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
	
	/**
	 * This method sorts players using GamePlayer's compareTo method.
	 */
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
