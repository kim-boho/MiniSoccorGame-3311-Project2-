package main;
import controller.GameListener;
import controller.MenubarListener;
import view.GameMenuBar;
import view.GamePanel;

import javax.swing.*;

/**
 * 
 * This class is a main class to run Soccer Game Application using main method.
 *
 */
public class MiniSoccerApp {
	
	/**
	 * Main method to run application.
	 * @param args an array of command line arguments for the application.
	 */
	public static void main(String[] args) {
		JFrame gameFrame = new JFrame("Mini Soccer");
		GamePanel gamePanel = new GamePanel();
		GameListener gameListener = new GameListener(gamePanel);
		MenubarListener menubarListener = new MenubarListener(gamePanel);
		GameMenuBar gameMenuBar = new GameMenuBar(menubarListener);
		gameFrame.add(gamePanel);
		gameFrame.addKeyListener(gameListener);
		gameFrame.setJMenuBar(gameMenuBar);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setSize(600, 600);
		gameFrame.setLocationRelativeTo(null);
		gameFrame.setResizable(false);
		gameFrame.setVisible(true);
	}
}
