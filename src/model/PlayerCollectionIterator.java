package model;

import java.util.ArrayList;
import java.util.Iterator;

import model.players.GamePlayer;


/**
 * 
 * This class is for generating Iterator of PlayerCollection class.
 * 
 * @param <GamePlayer>
 */
@SuppressWarnings("hiding")
public class PlayerCollectionIterator<GamePlayer> implements Iterator<GamePlayer>{
	private int head;
	private int tail;
	private ArrayList<GamePlayer> players;
	
	/**
	 * Create PlayerCollectionIterator object with input ArrayList.
	 * @param players
	 */
	public PlayerCollectionIterator(ArrayList<GamePlayer> players){
		this.players = players;
		head=0;
		tail=players.size()-1;
	}
	
	/**
	 * This method is to check whether there is more element in Iterator.
	 * @return true if there is remained element. Otherwise, return false.
	 */
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		if(head>tail) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * This is to get next element in Iterator.
	 * @return GamePlayer remained in Iterator. Otherwise, return null.
	 */
	@Override
	public GamePlayer next() {
		// TODO Auto-generated method stub
		if(hasNext()) return players.get(head++);
		else return null;
	}

}
