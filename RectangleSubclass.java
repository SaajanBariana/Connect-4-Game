
import javafx.scene.shape.Rectangle;

public class RectangleSubclass extends Rectangle{
	public int column;
	public RectangleSubclass(int width, int height, int column) {
		super(width, height);
		this.column = column;
	}
	
	public int getColumn()
	{
		return column;
	}

}
