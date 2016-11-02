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
	 
	 private Parent createContent()
	 {
		 Pane root = new Pane();
		 
		 Shape  gridShape = makeGrid();
		 root.getChildren().add(gridShape);
		 return root;
	 }
	 
	 private Shape makeGrid(){
		 Shape shape = new Rectangle((6+1)*80,(6+1)*80);
		 
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











/*
//Creating the JFrame
JFrame GameWindow = new JFrame("Connect4");
GameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
GameWindow.setLayout(new BorderLayout());

//For the part of the GUI where I can add a new piece
JPanel DropWindow = new JPanel();
DropWindow.setLayout(new GridLayout(1,GridSize));

DropWindow.setLayout(new GridLayout(1, GridSize));

for(int i = 0;i<GridSize;i++)
{
JButton addButton = new JButton();
DropWindow.add(addButton);
}

//For the part of the GUI where I can draw the board
JPanel BoardWindow = new JPanel();
BoardWindow.setLayout(new GridLayout(GridSize, GridSize, 5, 5));
BoardWindow.setBackground(Color.orange);

for(int i = 0;i<GridSize;i++)
{
for(int j = 0;j<GridSize;j++)
{
	JButton gridPoint = new JButton();
	gridPoint.setEnabled(false);
	BoardWindow.add(gridPoint);
}
}

//Adding everything into the JFrame and playing the JFrame
GameWindow.add(DropWindow,BorderLayout.SOUTH);
GameWindow.add(BoardWindow,BorderLayout.CENTER);
GameWindow.setExtendedState(JFrame.MAXIMIZED_BOTH); 
GameWindow.setVisible(true);
*/
