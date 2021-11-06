package model;

import java.util.Timer;
import java.util.TimerTask;

import model.players.*;

/**
 * 
 * This class is to create and control a game.
 *
 */
public class SoccerGame {

	private Integer timeRemaining;

	private Integer goal;

	private Boolean isPaused;

	private Boolean isOver;

	private final PlayerCollection gamePlayers;
	
	/**
	 * Create soccer game object.
	 */
	public SoccerGame() {
		timeRemaining = 60;
		goal = 0;
		isPaused = true;
		isOver = false;
		SoccerBall.getSoccerBall().resetSoccerBall();
		PlayerFactory playerFactory = new PlayerFactory();
		gamePlayers = new PlayerCollection();
		gamePlayers.add(playerFactory.getPlayer("Striker"));
		gamePlayers.add(playerFactory.getPlayer("Goalkeeper"));
		startGame();
	}
	
	/**
	 * To start a game
	 */
	private void startGame() {
		Timer timer = new Timer();
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				if (!isPaused()) {
					if (getTimeRemaining() <= 0) {
						setOver(true);
						timer.cancel();
					} else {
						setTimeRemaining(getTimeRemaining() - 1);
					}
					if (isScored()) {
						setPaused(true);
						setGoal(getGoal() + 1);
						getActivePlayer().setPlayerStatistics(getActivePlayer().getPlayerStatistics() + 1);
						getGamePlayers().get("Striker").setInitialPosition();
						SoccerBall.getSoccerBall().resetSoccerBall();
					} else {
						automateGoalkeeper();
					}
				}
			}
		};
		timer.schedule(timerTask, 1000, 1000);
	}
	
	/**
	 * To get remaining time
	 * @return Integer that is the remaining time.
	 */
	public Integer getTimeRemaining() {
		return timeRemaining;
	}
	
	/**
	 * To set remaining time
	 * @param timeRemaining to set
	 */
	public void setTimeRemaining(Integer timeRemaining) {
		this.timeRemaining = timeRemaining;
	}
	
	/**
	 * To get goal score
	 * @return Integer goal score
	 */
	public Integer getGoal() {
		return goal;
	}
	
	
	/*
	 * To set goal score
	 * @param newGoal that is new score to set
	 */
	public void setGoal(Integer newGoal) {
		goal = newGoal;
	}
	
	/*
	 * Check if the game is paused
	 * @return true if the game is paused. Otherwise, return false.
	 */
	public Boolean isPaused() {
		return isPaused;
	}
	
	/*
	 * To set whether the game is paused
	 * @param paused that is true if the game is paused. Otherwise, it's false.
	 */
	public void setPaused(Boolean paused) {
		isPaused = paused;
	}
	
	/*
	 * Check if the game is over
	 * @return true if the game is over. Otherwise, return false.
	 */
	public Boolean isOver() {
		return isOver;
	}
	
	/*
	 * To set whether the game is over
	 * @param over that is true if the game is over. Otherwise, it's false.
	 */
	public void setOver(Boolean over) {
		isOver = over;
	}
	
	/*
	 * To get game players
	 * @return PlayerCollection that includes all players for the game.
	 */
	public PlayerCollection getGamePlayers() {
		return gamePlayers;
	}
	
	/*
	 * Move goalkeeper based on position of the ball.
	 * If the ball is on side of goalkeeper, goalkeeper grabs and shoots it.
	 * Otherwise, goalkeeper moves randomly.
	 */
	public void automateGoalkeeper() {
		SoccerBall soccerBall = SoccerBall.getSoccerBall();
		Goalkeeper goalkeeper = (Goalkeeper) gamePlayers.get("Goalkeeper");
		if (soccerBall.onGoalkeeperSide()) {
			goalkeeper.grabsBall();
			goalkeeper.shootBall();
			goalkeeper.setPlayerStatistics(goalkeeper.getPlayerStatistics() + 1);
		} else {
			goalkeeper.moveRandomly();
		}
	}
	
	/*
	 * Check if the goal was scored
	 * @return true if the goal was scored. Otherwise, return false.
	 */
	public boolean isScored() {
		return SoccerBall.getSoccerBall().inGate();
	}
	
	/*
	 * To get active player(striker).
	 * @return GamePlayer who is active player.
	 */
	public GamePlayer getActivePlayer() {
		return gamePlayers.get("Striker");
	}
}
