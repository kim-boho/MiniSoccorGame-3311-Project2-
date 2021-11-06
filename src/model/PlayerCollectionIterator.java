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
	 * {@inheritDoc}
	 **/
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
	 * {@inheritDoc}
	 **/
	@Override
	public GamePlayer next() {
		// TODO Auto-generated method stub
		if(hasNext()) return players.get(head++);
		else return null;
	}

}
