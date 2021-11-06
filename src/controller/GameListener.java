package controller;

import model.SoccerGame;
import view.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * 
 * This is a controller class to control keyboard input from user.
 *
 */
public class GameListener implements KeyListener {

	private final GamePanel gamePanel;
	
	/**
	 * Create class object with the current panel.
	 * @param panel is a GamePanel that user is running.
	 */
	public GameListener(GamePanel panel) {
		gamePanel = panel;
	}
	
	/**
	 * {@inheritDoc}
	 **/
	@Override
	public void keyTyped(KeyEvent e) {

	}
	
	/**
	 * {@inheritDoc}
	 **/
	@Override
	public void keyPressed(KeyEvent e) {
		SoccerGame soccerGame = gamePanel.getGame();
		if (!soccerGame.isPaused() && !soccerGame.isOver()) {
			switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					soccerGame.getActivePlayer().moveLeft();
					break;
				case KeyEvent.VK_RIGHT:
					soccerGame.getActivePlayer().moveRight();
					break;
				case KeyEvent.VK_UP:
					soccerGame.getActivePlayer().moveUp();
					break;
				case KeyEvent.VK_DOWN:
					soccerGame.getActivePlayer().moveDown();
					break;
				case KeyEvent.VK_SPACE:
					if (soccerGame.getActivePlayer().isPlayerHasBall()) {
						soccerGame.getActivePlayer().shootBall();
					}
					break;
			}
		}
	}
	
	/**
	 * {@inheritDoc}
	 **/
	@Override
	public void keyReleased(KeyEvent e) {

	}
}
