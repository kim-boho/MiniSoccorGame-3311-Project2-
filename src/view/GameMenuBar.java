package view;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
/**
 * 
 * This is a class to form graphic for interface of menu bar.
 *
 */
@SuppressWarnings("serial")
public class GameMenuBar extends JMenuBar {
	
	/**
	 * Create menu bar on interface and let listener be able to control it by user.
	 * @param menubarListener that obtains input of user.
	 */
	public GameMenuBar(ActionListener menubarListener) {
		super();
		JMenu gameMenu = new JMenu("Game");
		gameMenu.add(createMenuItem("New game", "NEW", KeyEvent.VK_N, menubarListener));
		gameMenu.addSeparator();
		gameMenu.add(createMenuItem("Exit", "EXIT", KeyEvent.VK_Q, menubarListener));
		super.add(gameMenu);
		JMenu controlMenu = new JMenu("Control");
		controlMenu.add(createMenuItem("Pause", "PAUSE", KeyEvent.VK_P, menubarListener));
		controlMenu.add(createMenuItem("Resume", "RESUME", KeyEvent.VK_R, menubarListener));
		super.add(controlMenu);
	}
	
	/**
	 * To create menu bar element with proper function.
	 * @param text name of the item
	 * @param actionCommand that is menu bar input
	 * @param accelerator that is keyboard input
	 * @param listener that interacts with this interface
	 * @return JMenuItem menu bar item
	 */
	private JMenuItem createMenuItem(String text, String actionCommand, int accelerator, ActionListener listener) {
		JMenuItem menuItem = new JMenuItem(text);
		menuItem.setActionCommand(actionCommand);
		menuItem.addActionListener(listener);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(accelerator, 0));
		return menuItem;
	}

}
