package edu.buffalo.cse116;

import java.awt.BorderLayout; 

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import edu.buffalo.cse116.code.gui.GameGUI;

/**
 * 
 * @author william
 *
 */
public class Main 
{
	/**
	 * Creates our frame and start the game.
	 */
	public static void runGUI()
	{
			GameGUI game = new GameGUI();
		
	}
	
	public static void main(String [] args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				runGUI();
			}
		});
	}
}