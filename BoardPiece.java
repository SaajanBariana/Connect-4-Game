package ConnectFourGame;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.ColorModel;

public class BoardPiece extends JPanel {
	// hello
	public Graphics g;
	public Color c;
	
	
	public BoardPiece() {
		// TODO Auto-generated constructor stub
		
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		g.drawRect(10, 10, 100, 100);
		g.drawOval(10, 10, 100, 100);
	}
	public void paintComponent(Color c)
	{
		super.paintComponent(g);
		g.drawRect(10, 10, 100, 100);
		g.setColor(c);
		g.fillOval(10, 10, 100, 100);
	}
	public ColorModel getColorOfCircle()
	{
		return super.getColorModel();
		//return g.getColor();
	}
	
	
	
	

}
