package edu.buffalo.cse116.code.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import edu.buffalo.cse116.code.littleSpider.LittleSpiderGUI;

/**
 * 
 * @author 
 *
 */
public class GameGUI extends JFrame {
	

	
	
	
	
	
	public GameGUI() {
		add(menuBar(), BorderLayout.NORTH);	
		pack();
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}


	/**
	 * This method creates a JMenuBar to the JFrame. The JMenuBar has a JMenu with 3 JMenu items (Little Spider, Golf and Exit). 
	 * The JMenuBar should be accessible in-game, unlike the selectGame JPanel.
	 * Clicking on the JMenuItems should eventually implement a new instance of the chosen game, or exit the current game (and go back to the selection panel).
	 * 
	 * @return menuBar
	 */
	public JMenuBar menuBar() {
		
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
			System.exit(0);
		}
	});
	
	newGame.add(littleSpider);
	newGame.add(golf);
	newGame.add(exit);
	menuBar.add(newGame);
	return menuBar;
	}
}
