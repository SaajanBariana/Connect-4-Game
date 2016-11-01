package ConnectFourGame;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

public class GameGUI extends JFrame {
	int size;
	int count;
	static GameGUI game;
	Observer observer;

	public GameGUI() {
		// TODO Auto-generated constructor stub
		observer = new Observer();
		showGUI();
		//size = s;
		//count = c;
		
		
	}
	
	public static GameGUI getGUI()
	{
		return game;
	}
	public void showGUI()
	{
		JFrame theFrame = new JFrame("Connect 4 Game");
		theFrame.setSize(2000, 1000);
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theFrame.setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(size + 1, size));
		GridPane g = new GridPane();
		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < 5; j++)
			{
				g.add(observer.getPieces(i, j), j, i);
			}
		}
		
		//panel.add(new Rectangle(5, 5));
		//BoardPiece b = new BoardPiece();
		
		//System.out.println(b.getColorOfCircle());	
		//b.paintComponent(Color.RED);
		//panel.add(b);
			
		
		theFrame.add(panel);
		
		
		theFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		theFrame.setVisible(true);
	}

}
