package model;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 
 * This class is to manage ball object.(static)
 *
 */
public class SoccerBall {
	
	private static final SoccerBall soccerBall = new SoccerBall();

	private Point position;

	private double velocity;

	private final Color color;
	
	/**
	 * Set ball with initial properties.
	 */
	private SoccerBall() {
		color = Color.white;
		resetSoccerBall();
	}
	
	/**
	 * Getter for SoccerBall.
	 * @return SoccerBall object.
	 */
	public static SoccerBall getSoccerBall() {
		return soccerBall;
	}
	
	/**
	 * To move the ball
	 * @param initialDistance to move in y coordinate
	 * @param initialVelocity of the ball
	 * @param acceleration of the ball
	 */
	public void moveBall(int initialDistance, double initialVelocity, double acceleration) {
		moveBallY(initialDistance);
		setVelocity(initialVelocity);
		Timer timer = new Timer();
		TimerTask repaintTask = new TimerTask() {
			@Override
			public void run() {
				if (Math.abs(velocity) < 2) {
					velocity = 0.0;
					timer.cancel();
				} else {
					velocity = velocity - acceleration;
				}
				moveBallY((int) velocity);
			}
		};
		timer.schedule(repaintTask, 0, 10);
	}
	
	/**
	 * To move the ball in y coordinate
	 * @param distance of y coordinate to move
	 */
	public void moveBallY(int distance) {
		if (getPosition().y + distance < 510 && getPosition().y - distance > 20) {
			setPosition(new Point(getPosition().x, getPosition().y - distance));
		} else {
			setVelocity(0.0);
		}
	}
	
	/**
	 * To set the ball to initial position
	 */
	public void resetSoccerBall() {
		setVelocity(0.0);
		setPosition(new Point(480, 500));
	}
	
	/**
	 * To check whether the ball is on goalkeeper's side
	 * @return true if the ball is on goalkeeper's side. Otherwise, return false.
	 */
	public boolean onGoalkeeperSide() {
		return getPosition().y < 200;
	}
	
	/**
	 * To check whether the ball is in gate
	 * @return True if the ball is in gate. Otherwise, return false.
	 */
	public boolean inGate() {
		return getPosition().x > 180 && getPosition().x < 400 && getPosition().y > 10 && getPosition().y < 60;
	}
	
	/**
	 * To set velocity of ball
	 * @param velocity of ball
	 */
	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}
	
	/**
	 * To get position of ball
	 * @return Point coordinates of x and y of ball
	 */
	public Point getPosition() {
		return position;
	}
	
	/**
	 * To set position of ball
	 * @param position of ball
	 */
	public void setPosition(Point position) {
		this.position = position;
	}
	
	/**
	 * To get color of ball
	 * @return Color of ball
	 */
	public Color getColor() {
		return color;
	}
}
