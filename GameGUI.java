import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GameGUI extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("");
		GridPane grid = new GridPane();
		Scene scene = new Scene(grid, 500, 500);

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				BoardPiece piece = new BoardPiece(i, j);
				
				Rectangle rect = piece.getRectangle();	//reference to rectangle
				GridPane.setRowIndex(rect, i);
				GridPane.setColumnIndex(rect, j);
				
				Ellipse e = piece.getEllipse();			//reference to ellipse
				GridPane.setRowIndex(e, i);
				GridPane.setColumnIndex(e, j);
				
				piece.setColor(Color.RED);
				
				grid.getChildren().add(rect);
				grid.getChildren().add(e);
			}
		}
		primaryStage.setScene(scene);
		primaryStage.show();

	}

}
