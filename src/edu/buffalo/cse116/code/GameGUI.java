package edu.buffalo.cse116.code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 * 
 * @author 
 *
 */
public class GameGUI {
	
//	public JPanel newGamePanel() {
//		JPanel panel = new JPanel();
//		JButton newGame = new JButton("New Game");
//		
//		newGame.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent a) {
//				
//			}
//		});
//		
//		panel.add(newGame);
//		
//		return panel;
//	}
	
	/**
	 * This method adds a JPanel (panel) that contains a JButton for Little Spider and Golf. Clicking on these buttons should (eventually) implement the chosen game. 
	 * 
	 * @return panel
	 */
	public JPanel selectGamePanel() {
		JPanel panel = new JPanel();
		JButton LittleSpider = new JButton("Little Spider");
		JButton Golf = new JButton("Golf");
		
		LittleSpider.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				
			}
		});
		
		Golf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent b) {
				
			}
		});
		
		panel.add(LittleSpider);
		panel.add(Golf);
		
		return panel;
	}
	
//	public JPanel exitPanel() {
//		JPanel panel = new JPanel();
//		JButton exit = new JButton("Exit");
//		
//		exit.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent a) {
//				
//			}
//		});
//		
//		panel.add(exit);
//		
//		return panel;
//	} 
	
	
	/**
	 * This method creates a JMenuBar to the JFrame. The JMenuBar has a JMenu with 3 JMenu items (Little Spider, Golf and Exit). 
	 * The JMenuBar should be accessible in-game, unlike the selectGame JPanel.
	 * Clicking on the JMenuItems should eventually implement a new instance of the chosen game, or exit the current game (and go back to the selection panel).
	 * 
	 * @return menuBar
	 */
	public JMenuBar setGameMenu() {
		
	JMenuBar menuBar = new JMenuBar();
	JMenu newGame = new JMenu("New Game");
	JMenuItem littleSpider = new JMenuItem("Little Spider");
	JMenuItem golf = new JMenuItem("Golf");
	JMenuItem exit = new JMenuItem("Exit");
	
	littleSpider.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent a) {
			
		} 
	});
	
	golf.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent a) {
			
		}
	});
	
	exit.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent a) {
			
		}
	});
	
	newGame.add(littleSpider);
	newGame.add(golf);
	newGame.add(exit);
	menuBar.add(newGame);
	return menuBar;
	}
}
