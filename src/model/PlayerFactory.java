package model;


import java.awt.Color;

import model.players.GamePlayer;
import model.players.Goalkeeper;
import model.players.Striker;

/*
 * This is a Factory class to create GamePlayer object.
 */

public class PlayerFactory {
	
	/**
	 * 
	 * @param playerType indicates type of player either striker or goalkeeper.
	 * @return GamePlayer object
	 */
	public GamePlayer getPlayer(String playerType) {
		if(playerType.equalsIgnoreCase("goalkeeper")) {
			return new Goalkeeper("Goalkeeper",Color.yellow);
		} else if(playerType.equalsIgnoreCase("striker")) {
			return new Striker("Striker",Color.blue);
		}
		return null;
	}
}
