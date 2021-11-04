package model;

import java.util.ArrayList;
import java.util.Iterator;

import model.players.GamePlayer;

@SuppressWarnings("hiding")
public class PlayerCollectionIterator<GamePlayer> implements Iterator<GamePlayer>{
	private int head;
	private int tail;
	private ArrayList<GamePlayer> players;
	public PlayerCollectionIterator(ArrayList<GamePlayer> players){
		this.players = players;
		head=0;
		tail=players.size()-1;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		if(head>tail) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public GamePlayer next() {
		// TODO Auto-generated method stub
		return players.get(head++);
	}

}
