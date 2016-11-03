package ConnectFourGame;

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
	Ellipse ellipse;

	public BoardPiece(int row, int column) {
		this.row = row;
		this.column = column;

		ellipse = new Ellipse(row, column, 40, 40);
		//ellipse.setCenterX(row);
		//ellipse.setCenterY(column);
		ellipse.setRadiusX(40);
		ellipse.setRadiusY(40);
		ellipse.setFill(Color.WHITE);

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
	public int getX()
	{
		return row;
	}
	public int getY()
	{
		return column;
	}
}