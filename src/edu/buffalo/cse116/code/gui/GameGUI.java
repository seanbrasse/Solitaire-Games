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

import edu.buffalo.cse116.code.golfGui.GolfLayeredPaneGame;
import edu.buffalo.cse116.code.littleSpiderGui.LSLayeredPaneGame;


/**
 * This class is the frame from where we will have at most 
 * @author 
 *
 */
public class GameGUI extends JFrame {

	/**
	 * An instance of the LS game
	 */
	private LSLayeredPaneGame ls;
	
	/**
	 * An instance of the LS game
	 */
	private GolfLayeredPaneGame g;



	/**
	 * Creates our frame for the game with the menu bar.
	 */
	public GameGUI() {

		add(menuBar(), BorderLayout.NORTH);

		//*****NOTE ******
		//The final size of the frame should be 
		setSize(1200, 800);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);	
		
		//getContentPane().setBackground(new java.awt.Color(0, 102, 0));
		
		ls = null;
		g = null;
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
				
				
				if(g != null) {
					g.removeAll();
					remove(g);
					g = null;
					//These two are necessary lines
					revalidate(); //checks if anything has changed in the 'components' (like JLayeredPane, JPanel) such as remove
					repaint(); //Similar to 'refreshing' the GUI
					
					ls = new LSLayeredPaneGame();
				} if(ls != null) {
					ls.removeAll();
					remove(ls);
					ls = new LSLayeredPaneGame();
					revalidate();
					repaint();
				} else {
					//These two are necessary lines
					revalidate(); //checks if anything has changed in the 'components' (like JLayeredPane, JPanel) such as remove
					repaint(); //Similar to 'refreshing' the GUI
					
					ls = new LSLayeredPaneGame();
					
				}
				
		
				add(ls, BorderLayout.CENTER);
				
				revalidate(); 
				repaint(); 
			} 
		});

		golf.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent a) {
				
				if(ls != null) {
					ls.removeAll();
					remove(ls);
					ls = null;
					//These two are necessary lines
					revalidate(); //checks if anything has changed in the 'components' (like JLayeredPane, JPanel) such as remove
					repaint(); //Similar to 'refreshing' the GUI
					
					g = new GolfLayeredPaneGame();
					
				} if(g != null) {
					g.removeAll();
					remove(g);
					g = new GolfLayeredPaneGame();
					revalidate();
					repaint();
				} else {
					g = new GolfLayeredPaneGame();
				}
				
				
				

				add(g, BorderLayout.CENTER);

				//remove(lslp);
				revalidate(); 
				repaint();



				//Will start Golf here **********

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
