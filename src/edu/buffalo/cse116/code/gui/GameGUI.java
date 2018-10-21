package edu.buffalo.cse116.code.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import com.buffalo.cse116.code.littleSpiderGui.LSTableauLayeredPane;
import com.buffalo.cse116.code.littleSpiderGui.LittleSpiderGUI;

/**
 * 
 * @author 
 *
 */
public class GameGUI extends JFrame {
	
private LSTableauLayeredPane lslp;

	

	/**
	 * Creates our frame for the game with the menu bar.
	 */
	public GameGUI() {
	
		add(menuBar(), BorderLayout.NORTH);
		
		//pack(); //Packs our components nicely
		setSize(1000, 700);//Size of our frame, Not final
		
	
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
	private JMenuBar menuBar() {
		
	JMenuBar menuBar = new JMenuBar();
	JMenu newGame = new JMenu("New Game");
	JMenuItem littleSpider = new JMenuItem("Little Spider");
	JMenuItem golf = new JMenuItem("Golf");
	JMenuItem exit = new JMenuItem("Exit");
	
	
	littleSpider.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent a) {
			
			//These 4 lines are just for testing purposes, can be removed whenever, won't be in the final submition
			lslp = new LSTableauLayeredPane(); //Will start Little Spider
			LSTableauLayeredPane test = new LSTableauLayeredPane();
			add(lslp, BorderLayout.NORTH); //Sets
			add(test, BorderLayout.SOUTH);
			
			//These two are necessary lines
			revalidate(); //checks if anything has changed in the 'components' (like JLayeredPane, JPanel) such as remove
			repaint(); //Similar to 'refreshing' the GUI
			
		} 
	});
	
	golf.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent a) {
			//Will start Golf
			remove(lslp);
			revalidate(); 
			repaint();
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
