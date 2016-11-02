package ConnectFourGame;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

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
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theFrame.setLayout(new BorderLayout());
		
		
		theFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		theFrame.setVisible(true);
	}
	public void start(Stage primaryStage) throws Exception 
	{
		/*primaryStage.setTitle("");
		GridPane grid = new GridPane();
		Scene scene = new Scene(grid, 500, 500);

		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 3; j++) {
				//BoardPiece piece = new BoardPiece(i, j);
				
				//Rectangle rect = piece.getRectangle();	//reference to rectangle
				//GridPane.setRowIndex(rect, i);
				//GridPane.setColumnIndex(rect, j);
				
				//Ellipse e = piece.getEllipse();			//reference to ellipse
				//GridPane.setRowIndex(e, i);
				//GridPane.setColumnIndex(e, j);
				
				
				//grid.getChildren().add(rect);
				//grid.getChildren().add(e);
			}
		}
		primaryStage.setScene(scene);
		primaryStage.show();*/

	}

}
