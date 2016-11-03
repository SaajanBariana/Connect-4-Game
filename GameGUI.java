package ConnectFourGame;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;


public class GameGUI extends Application
{	
	 public static void main(String[] args) {
		 int size = Integer.parseInt(args[0]);
		 int numberOfPieces = Integer.parseInt(args[1]);
		 
		 Observer.o.setSize(size);
		 Observer.o.setPiecesNumber(numberOfPieces);
	        Application.launch(args);
	    }

	 
	 private Parent createContent()
	 {
		 Pane root = new GridPane();						//Refers to the scene which uses grid
		 Shape gridShape = makeGrid(Observer.o.getSize());
		 root.getChildren().add(gridShape);					//Draws the board
		 BoardPiece[][] board = setUpPieces(Observer.o.getSize());
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
		 root.getChildren().addAll(makeColumns(Observer.o.getSize(), board));			//Draws the data in the columns
		 return root;
	 }
	 
	 
	 private Shape makeGrid(int size){
		 // makes the grid
			 Shape shape = new Rectangle((size+1)*80,(size+1)*80);	//Creates the screen of the game
			 
			 for(int i = 0; i< size; i++)							//For each row
			 {
				 for(int j = 0; j<size;j++)						//For each column
				 {
					 //Creates the circle
					 Circle circle = new Circle(Observer.o.getPieceSize()/2, Observer.o.getPieceSize()/2, Observer.o.getPieceSize()/2);
					 circle.setTranslateX(j*(Observer.o.getPieceSize()+5)+Observer.o.getPieceSize()/4);
					 circle.setTranslateY(i*(Observer.o.getPieceSize()+5)+Observer.o.getPieceSize()/4);
					 
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
	 private List<Rectangle> makeColumns(int size, BoardPiece[][] board)
	 {
		 List<Rectangle> list = new ArrayList<>();
		 for(int i=0; i<size;i++)
		 {
			 RectangleSubclass rect = new RectangleSubclass(Observer.o.getPieceSize(),7*Observer.o.getPieceSize(), i);
			 rect.setTranslateX(i*(Observer.o.getPieceSize()+5)+ Observer.o.getPieceSize()/4);
			 rect.setFill(Color.TRANSPARENT);
			 rect.setOnMouseEntered(e -> rect.setFill(Color.rgb(200, 200, 50,0.3)));
			 rect.setOnMouseExited(e -> rect.setFill(Color.TRANSPARENT));
			 rect.setOnMouseClicked(e -> playPiece(rect, board));
			 list.add(rect);
		 }
		 return list;
	 }
	 
	 private void playPiece(RectangleSubclass rect, BoardPiece[][] board)
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
			
			 if (playerinfo[1].equals("red"))
			 {
				 c = Color.RED;
			 }
			 else
			 {
				 c = Color.LIGHTBLUE;
			 }
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

	 //@Override
	 public void start(Stage stage) throws Exception  
	 {
		stage.setScene(new Scene(createContent()));
		stage.setTitle("Connect4");
		stage.show();
	 }
}