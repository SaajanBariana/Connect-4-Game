import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

//  w  w  w  .  j a  v  a2s . c  o m
public class BoardPiece {
	/*
	 * public static void main(String[] args) { Application.launch(args); }
	 */
	/*
	 * @Override public void start(Stage primaryStage) {
	 * primaryStage.setTitle(""); Group root = new Group(); Scene scene = new
	 * Scene(root, 300, 250, Color.WHITE);
	 * 
	 * 
	 * Rectangle r = new Rectangle(); r.setWidth(100); r.setHeight(100);
	 * r.setFill(Color.BLUE);
	 * 
	 * Ellipse e = new Ellipse(); e.setCenterX(50); e.setCenterY(50);
	 * e.setRadiusX(40); e.setRadiusY(40); e.setFill(Color.WHITE);
	 * 
	 * root.getChildren().add(r); root.getChildren().add(e);
	 * primaryStage.setScene(scene); primaryStage.show(); }
	 */

	int row;
	int column;
	Rectangle rect;
	Ellipse ellipse;

	public BoardPiece(int row, int column) {
		this.row = row;
		this.column = column;
		rect = new Rectangle();
		rect.setHeight(40);
		rect.setWidth(40);
		rect.setFill(Color.BLUE);

		ellipse = new Ellipse();
		ellipse.setCenterX(30);
		ellipse.setCenterY(30);
		ellipse.setRadiusX(15);
		ellipse.setRadiusY(15);
		ellipse.setFill(Color.WHITE);

	}

	public Rectangle getRectangle() {
		return rect;
	}

	public Ellipse getEllipse() {
		return ellipse;
	}
	
	public Paint getColor(){
		return ellipse.getFill();
	}
	
	public void setColor(Paint color){
		ellipse.setFill(color);
	}
}