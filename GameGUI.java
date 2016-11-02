package ConnectFourGame;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
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
		 Pane root = new GridPane();						//Refers to the scene which uses grid
		 Shape gridShape = makeGrid();
		 root.getChildren().add(gridShape);					//Draws the board
		 root.getChildren().addAll(makeColumns());			//Draws the data in the columns
		 return root;
	 }
	 
	 private Shape makeGrid(){
		 Observer o = Observer.getObserver();
		 // makes the grid
			 Shape shape = new Rectangle((6+1)*80,(6+1)*80);	//Creates the screen of the game
			 
			 for(int i = 0; i< 6; i++)							//For each row
			 {
				 for(int j = 0; j<6;j++)						//For each column
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
	 
	 // makes the columns
	 private List<Rectangle> makeColumns()
	 {
		 List<Rectangle> list = new ArrayList<>();
		 for(int i=0; i<6;i++)
		 {
			 Rectangle rect = new Rectangle(80,(6+1)*80);
			 rect.setTranslateX(i*(80+5)+ 80/4);
			 rect.setFill(Color.TRANSPARENT);
			 rect.setOnMouseEntered(e -> rect.setFill(Color.rgb(200, 200, 50,0.3)));
			 rect.setOnMouseExited(e -> rect.setFill(Color.TRANSPARENT));
			 rect.setOnMouseClicked(e -> playPiece());
			 list.add(rect);
		 }
		 return list;
	 }
	 
	 private void playPiece()
	 {
		 
	 }
	//@Override
	 public void start(Stage stage) throws Exception  
	 {
		stage.setScene(new Scene(createContent()));
		stage.show();
	 }
}







