import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class BoardPiece {

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