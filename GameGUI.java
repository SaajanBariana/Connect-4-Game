package ConnectFourGame;

import javafx.application.Application;

import javafx.scene.Parent;
import javafx.scene.Scene;
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
		 Pane root = new Pane();
		 
		 Shape gridShape = makeGrid();
		 root.getChildren().add(gridShape);
		 return root;
	 }
	 
	 private Shape makeGrid(){
		 Shape shape = new Rectangle((6+1)*80,(6+1)*80);
		 Observer o = Observer.getObserver();
		 for(int i = 0; i< 6; i++)
		 {
			 for(int j = 0; j<6;j++)
			 {
				 Circle circle = new Circle(80/2, 80/2, 80/2);
				 circle.setTranslateX(j*(80+5)+80/4);
				 circle.setTranslateY(i*(80+5)+80/4);
				 
				 shape = shape.subtract(shape, circle);
				 
			 }
		 }
		 shape.setFill(Color.BLUE);
		 return shape;
	 }

	//@Override
	 public void start(Stage stage) throws Exception  
	 {
		stage.setScene(new Scene(createContent()));
		stage.show();
	 }
}







