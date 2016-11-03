package ConnectFourGame;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class GameGUI extends Application
{	
	 public static void main(String[] args) {
	        Application.launch(args);
	    }
	 public GameGUI()
	 {
		 
	 }
	 private Parent createContent()
	 {
		 int size = 6;
		 Pane root = new GridPane();						//Refers to the scene which uses grid
		 Shape gridShape = makeGrid(size);
		 root.getChildren().add(gridShape);					//Draws the board
		 BoardPiece[][] board = setUpPieces(size);
		 for (int i= 0; i < board.length; i++)
		 {
			 VBox v = new VBox(5);
			 v.setPadding(new Insets(20, 10, 10, 20 + (i*85)));
			 for (int j = 0; j < board[i].length; j++)
			 {
				 v.getChildren().add(board[i][j].getEllipse());
			 }
			 root.getChildren().add(v);
		 }
		 TextField text = new TextField();
		 text.setText("Welcome to Connect 4! Click on any column to begin!");
		 text.setFont(Font.font ("Verdana", 18));
		 text.setStyle("-fx-text-inner-color: blue");
		 root.getChildren().addAll(makeColumns(size, board, text));			//Draws the data in the columns
		 text.setEditable(false);
		 text.setTranslateY(260);
		 //System.out.println(text.getAlignment());
		 text.setAlignment(Pos.CENTER);
		 root.getChildren().add(text);
		 return root;
	 }
	 
	 private Shape makeGrid(int size){
		 // makes the grid
			 Shape shape = new Rectangle((6+1)*80,(6+1)*80);	//Creates the screen of the game
			 
			 for(int i = 0; i< size; i++)							//For each row
			 {
				 for(int j = 0; j<size;j++)						//For each column
				 {
					 //Creates the circle
					 Circle circle = new Circle(80/2, 80/2, 80/2);
					 circle.setTranslateX(j*(80+5)+80/4);
					 circle.setTranslateY(i*(80+5)+80/4);
					 
					 //Cuts out a circle from the present shape
					 shape = shape.subtract(shape, circle);
					 
				 }
			 }
			 
			 shape.setFill(Color.BLUE);							//Changes color of shape 
			 return shape;
		 
	 }
	 
	 public BoardPiece[][] setUpPieces(int size)
	 {
		 Observer o = Observer.getObserver();
		 BoardPiece[][] board = new BoardPiece[size][size];
		 for (int i = 0; i < size; i++)
		 {
			 for(int j = 0; j < size; j++)
			 {
				 BoardPiece p = o.getPieces( 25 + (j* 45), 25 + (i*45));
				 //System.out.println(p.getX() + " " + p.getY());
				 board[i][j] = p;
			 }
		 }
		 return board;
	 }
	 // makes the columns
	 private List<Rectangle> makeColumns(int size, BoardPiece[][] board, TextField text)
	 {
		 List<Rectangle> list = new ArrayList<>();
		 for(int i=0; i<size;i++)
		 {
			 RectangleSubclass rect = new RectangleSubclass(80,560, i);
			 rect.setTranslateX(i*(80+5)+ 80/4);
			 rect.setFill(Color.TRANSPARENT);
			 rect.setOnMouseEntered(e -> rect.setFill(Color.rgb(200, 200, 50,0.3)));
			 rect.setOnMouseExited(e -> rect.setFill(Color.TRANSPARENT));
			 rect.setOnMouseClicked(e -> playPiece(rect, board, text));
			 list.add(rect);
		 }
		 return list;
	 }
	 
	 private void playPiece(RectangleSubclass rect, BoardPiece[][] board, TextField text)
	 {
		 int col = rect.getColumn();
		 int i = 0;
		 boolean go = false;
		 BoardPiece previous = board[col][i];
		 if(previous.getColor().equals(Color.WHITE))
		 {
			 go = true;
		 }
		if (go)
		{
			 Observer o = Observer.getObserver();
			 String[] playerinfo = o.sendPlayerInfo();
			 Color c;
			 String message = playerinfo[0];
			 if (playerinfo[1].equals("red"))
			 {
				 c = Color.RED;
				 text.setStyle("-fx-text-inner-color: blue");
			 }
			 else
			 {
				 c = Color.LIGHTBLUE;
				 text.setStyle("-fx-text-inner-color: red");
			 }
			 text.setText(message + ", it is your turn to play your piece");
			 previous.setColor(c);
			 while (i < board.length-1)
			 {
				 BoardPiece current = board[col][i+1];
				 if(current.getColor().equals(Color.WHITE))
				 {
					 current.setColor(c); 
				 }
				 else
				 {
					 break;
				 }
				 previous.setColor(Color.WHITE);
				 previous = current;
				 i++;
			 }
		}
		
	 }
	
	public void displayWinner()
	{
		
	}
	//@Override
	 public void start(Stage stage) throws Exception  
	 {
		stage.setScene(new Scene(createContent()));
		stage.show();
	 }
}







