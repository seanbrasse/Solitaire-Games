package edu.buffalo.cse116;

import java.awt.BorderLayout; 

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import edu.buffalo.cse116.code.GameGUI;

/**
 * 
 * @author william
 *
 */
public class Main 
{
	public static void runGUI()
	{
		JFrame frame = new JFrame("Solataire Games");
			
		GameGUI gui = new GameGUI();							
		
		frame.getContentPane().add(gui.setGameMenu(), BorderLayout.NORTH);
		frame.getContentPane().add(gui.selectGamePanel(), BorderLayout.CENTER);
		
		frame.pack();
		frame.setSize(600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
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