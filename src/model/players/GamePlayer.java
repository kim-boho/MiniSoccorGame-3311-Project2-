package model.players;

import model.PlayerStatistics;
import model.SoccerBall;

import java.awt.*;

/**
 * 
 * This is abstract class to define game player.
 *
 */
public abstract class GamePlayer implements Comparable<GamePlayer> {

	protected final String playerName;

	protected final Color playerColor;

	protected Point playerPosition;

	protected final PlayerStatistics playerStatistics;
	
	/**
	 * Create game player object.
	 * @param name player's name
	 * @param color player's color
	 */
	public GamePlayer(String name, Color color) {
		playerName = name;
		playerColor = color;
		playerStatistics = new PlayerStatistics();
		setInitialPosition();
	}
	
	/**
	 * To check whether player has a ball.
	 * @return true if player is close to ball and can have it. Otherwise, return false.
	 */
	public boolean isPlayerHasBall() {
		Point playerPositionCenter = new Point(getPlayerPosition().x + 15, getPlayerPosition().y + 30);
		return playerPositionCenter.distance(SoccerBall.getSoccerBall().getPosition()) < 55;
	}
	
	/**
	 * To grab a boll by player.
	 */
	public void grabsBall() {
		SoccerBall ball = SoccerBall.getSoccerBall();
		if (getPlayerPosition().x + 15 > ball.getPosition().x) {
			ball.setPosition(new Point(getPlayerPosition().x - 10, getPlayerPosition().y + 55));
		} else {
			ball.setPosition(new Point(getPlayerPosition().x + 20, getPlayerPosition().y + 55));
		}
	}
	
	/**
	 * To move player to the left
	 */
	public abstract void moveLeft();
	
	/**
	 * To move player to the right
	 */
	public abstract void moveRight();
	
	/**
	 * To move player to up
	 */
	public abstract void moveUp();
	
	/**
	 * To move player to down
	 */
	public abstract void moveDown();
	
	/**
	 * To let player shoot the ball
	 */
	public abstract void shootBall();
	
	/**
	 * To get player's name
	 * @return String player's name
	 */
	public String getPlayerName() {
		return playerName;
	}
	
	/**
	 * To get player's color
	 * @return Color player's color
	 */
	public Color getPlayerColor() {
		return playerColor;
	}
	
	/**
	 * To get player's position
	 * @return Point coordinates of x and y of player
	 */
	public Point getPlayerPosition() {
		return playerPosition;
	}
	
	/**
	 * To set initial position of player
	 */
	public abstract void setInitialPosition();
	
	/**
	 * To set position of player
	 * @param newPosition for new position
	 */
	public void setPlayerPosition(Point newPosition) {
		playerPosition = newPosition;
		if (isPlayerHasBall()) {
			grabsBall();
		}
	}
	
	/**
	 * To get player's score
	 * @return Integer player's score
	 */
	public Integer getPlayerStatistics() {
		return playerStatistics.getStatistics();
	}
	
	/**
	 * To set player's score
	 * @param newStatistics for new score of player
	 */
	public void setPlayerStatistics(Integer newStatistics) {
		playerStatistics.setStatistics(newStatistics);
	}
	
	/**
	 * {@inheritDoc}
	 **/
	@Override
	public int compareTo(GamePlayer otherPlayer) {
		return otherPlayer.getPlayerStatistics().compareTo(this.getPlayerStatistics());
	}
	
	/**
	 * {@inheritDoc}
	 **/
	@Override
	public abstract String toString();
}
