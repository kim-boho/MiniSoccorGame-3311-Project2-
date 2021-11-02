package model;


import java.awt.Color;

import model.players.GamePlayer;
import model.players.Goalkeeper;
import model.players.Striker;

public class PlayerFactory {
	public GamePlayer getPlayer(String playerType) {
		if(playerType.equalsIgnoreCase("goalkeeper")) {
			return new Goalkeeper("Goalkeeper",Color.yellow);
		} else if(playerType.equalsIgnoreCase("striker")) {
			return new Striker("Striker",Color.blue);
		}
		return null;
	}
}
