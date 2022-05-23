import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * This is the Game Window Class.  It is a JFrame.
 * @author robert.lancaster
 *
 */
public class GameWindow extends JFrame {
	
	private static final long serialVersionUID = 1L; 	// I added this to make it shut up about the warning this wasn't there.  It isn't important
	public GamePanel game; 								// This is the GamePanel that will appear in the middle of the screen.
	
	/**
	 * This is a constructor for the Game Window.
	 */
public GameWindow(){
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// Makes the program close when you close this window.
	this.setSize(700,700);									// Sets the size of the Window.
	this.setLayout(new BorderLayout());						// Sets the layout of the Window.  BorderLayouts are nice.
	this.setTitle("Tower");				// This sets the Title of the Window.  Fun!
	
	JMenuBar bar = new JMenuBar();			// This makes the menu bar where the menu will be
	JMenu menu = new JMenu("Menu");			// I made a menu, I called it File, so original!
	bar.add(menu);							// This adds the File menu to the menu bar
	this.add(bar, BorderLayout.NORTH);		// This puts the MenuBar at the top of the Window in the top of the Layout
	
	JMenuItem newGame = new JMenuItem("New Game");		// This menu item will start the game.
	newGame.addActionListener(new ActionListener(){		// Adds an action listener for the game
		public void actionPerformed(ActionEvent e){		// This is a simple way to add this method without needing it put it all at the bottom.
			game.newGame();								// Here is how it starts the game.
		}
	});
	menu.add(newGame);
	
	JMenuItem quit = new JMenuItem("Quit");			// This is the Quit menu item, it will quit the game.
	quit.addActionListener(new ActionListener(){	// Adds an action listener for the game
		public void actionPerformed(ActionEvent e){ // This is a simple way to add this method without needing it put it all at the bottom.
			System.exit(0);							// Here is how it exits the game.
		}
	});
	menu.add(quit);
	
	
	game = new GamePanel();					// This creates the GamePanel where the game will run.
	this.add(game,BorderLayout.CENTER);		// This adds the GamePanel to this Window in the center of the Layout
	this.setVisible(true);					// This makes the Window Visible
	
}

}
