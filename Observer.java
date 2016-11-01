package ConnectFourGame;

import java.awt.Color;

import javafx.scene.shape.Rectangle;

/**
 * used to connect the classes together.
 * @author Saajan Bariana
 *
 */
public class Observer {
	GameGUI game = GameGUI.getGUI();
	Player player1;
	Player player2;
	/**
	 * initializes the Observer class to set up two players and their colors. 
	 */
	public Observer() 
	{
		
		player1 = new Player("Player 1", Color.RED, true);
		player2 = new Player("Player 2", Color.BLUE, false);
	}
	
	/**
	 * used to send information about the current player to the GUI to choose the correct color and name
	 * @return returns an array. Index 0 is the player's name. Index 1 is the player's color
	 */
	public String[] sendPlayerInfo()
	{
		String[] info = new String[2];
		Player currentPlayer;
		if (player1.getTurn())
		{
			info[0] = player1.getName();
			info[1] = player1.getColor();
			player1.setTurn(false);
		}
		else
		{
			info[0] = player2.getName();
			info[1] = player2.getColor();
			player1.setTurn(true);
		}
		return info;
	}
	/**
	 * used the get the board pieces and will send them to the GUI to create the game board
	 * @return
	 */
	public Rectangle getPieces(int x, int y)
	{
		return new Rectangle(x, y, 100, 100);
		//currently a shell method
	}

}
