
import java.awt.Color;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 * used to connect the classes together.
 * @author Saajan Bariana
 *
 */
public class Observer {
	GameGUI game = new GameGUI();
	Player player1;
	Player player2;
	static Observer o = new Observer();
	private int size;
	private int numberOfPieces;
	private int boardPieceSize = 80;
	/**
	 * initializes the Observer class to set up two players and their colors. 
	 */
	private Observer() 
	{
		
		player1 = new Player("Player 1", Color.RED, true);
		player2 = new Player("Player 2", Color.BLUE, false);
	}
	
	public void setSize(int size)
	{
		this.size = size;
	}
	
	public void setPiecesNumber(int pieces)
	{
		numberOfPieces = pieces;
	}
	
	public int getSize()
	{
		return size;
	}
	
	public int getPieceCount()
	{
		return numberOfPieces;
	}
	
	public int getPieceSize()
	{
		return boardPieceSize;
	}
	/**
	 * used to send information about the current player to the GUI to choose the correct color and name
	 * @return returns an array. Index 0 is the player's name. Index 1 is the player's color
	 */
	public String[] sendPlayerInfo()
	{
		String[] info = new String[2];
		if (player1.getTurn())
		{
			info[0] = player1.getName();
			info[1] = player1.getColor();
			player1.setTurn(false);
		}
		else
		{
			info[0] = player2.getName();
			info[1] = player2.getColor();
			player1.setTurn(true);
		}
		return info;
	}
	
	public static Observer getObserver()
	{
		return o;
	}
	/**
	 * used the get the board pieces and will send them to the GUI to create the game board
	 * @return
	 */
	public BoardPiece getPieces(int x, int y)
	{
		return new BoardPiece(x, y);
		//currently a shell method
	}
	/*
	 * addNeighbors(board);
		return board;
	}

	private void addNeighbors(BoardPiece[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				BoardPiece p = board[i][j];
				if (j - 1 >= 0)
					p.N = board[i][j - 1];
				if (j - 1 >= 0 && i + 1 < board.length)
					p.NE = board[i + 1][j - 1];
				if (i + 1 < board.length)
					p.E = board[i + 1][j];
				if (j + 1 < board.length && i + 1 < board.length)
					p.SE = board[i + 1][j + 1];
				if (j + 1 < board.length)
					p.S = board[i][j + 1];
				if (j + 1 < board.length && i - 1 >= 0)
					p.SW = board[i - 1][j + 1];
				if (i - 1 >= 0)
					p.W = board[i - 1][j];
				if (j - 1 >= 0 && i - 1 >= 0)
					p.NW = board[i - 1][j - 1];
			}
		}
	}
	 * 
	 * 
	 * 
	 * 
	 * 
	 * private boolean checkWinner(RectangleSubclass rect, BoardPiece[][] board, int row, String[] playerInfo) {
		boolean foundWinner = false;
		Observer o = Observer.getObserver();
		BoardPiece p = board[rect.getColumn()][row];
		Color c;
		BoardPiece savePiece;

		if (playerInfo[0] != null && playerInfo[1] != null) {
			if (playerInfo[1].equals("red")) {
				c = Color.RED;
			} else {
				c = Color.LIGHTBLUE;
			}

			if (!foundWinner && p.N != null && p.N.getColor().equals(c)) {
				savePiece = theEndPiece(p, 1, c);
				foundWinner = findLengthOfPieces(savePiece, 1, c);
				
			}
			if (!foundWinner && p.NE != null && p.NE.getColor().equals(c)) {
				savePiece = theEndPiece(p, 2, c);
				foundWinner = findLengthOfPieces(savePiece, 2, c);
			}
			if (!foundWinner && p.E != null && p.E.getColor().equals(c)) {
				savePiece = theEndPiece(p, 3, c);
				foundWinner = findLengthOfPieces(savePiece, 3, c);
			}
			if (!foundWinner && p.SE != null && p.SE.getColor().equals(c)) {
				savePiece = theEndPiece(p, 4, c);
				foundWinner = findLengthOfPieces(savePiece, 4, c);
			}
			if (!foundWinner && p.S != null && p.S.getColor().equals(c)) {
				savePiece = theEndPiece(p, 5, c);
				foundWinner = findLengthOfPieces(savePiece, 5, c);
			}
			if (!foundWinner && p.SW != null && p.SW.getColor().equals(c)) {
				savePiece = theEndPiece(p, 6, c);
				foundWinner = findLengthOfPieces(savePiece, 6, c);
			}
			if (!foundWinner && p.W != null && p.W.getColor().equals(c)) {
				savePiece = theEndPiece(p, 7, c);
				foundWinner = findLengthOfPieces(savePiece, 7, c);
			}
			if (!foundWinner && p.NW != null && p.NW.getColor().equals(c)) {
				savePiece = theEndPiece(p, 8, c);
				foundWinner = findLengthOfPieces(savePiece, 8, c);
			}
		}

		return foundWinner;
	}

	private BoardPiece theEndPiece(BoardPiece piece, int direction, Color c) {
		BoardPiece p = piece;
		Boolean foundEndPiece = true;
		while (foundEndPiece) {
			foundEndPiece = false;
			if (direction == 1 && p.N != null && p.N.getColor().equals(c)) { // N
				foundEndPiece = true;
				p = p.N;
			}
			if (direction == 2 && p.NE != null && p.NE.getColor().equals(c)) { // NE
				foundEndPiece = true;
				p = p.NE;
			}
			if (direction == 3 && p.E != null && p.E.getColor().equals(c)) { // E
				foundEndPiece = true;
				p = p.E;
			}
			if (direction == 4 && p.SE != null && p.SE.getColor().equals(c)) { // SE
				foundEndPiece = true;
				p = p.SE;
			}
			if (direction == 5 && p.S != null && p.S.getColor().equals(c)) { // S
				foundEndPiece = true;
				p = p.S;
			}
			if (direction == 6 && p.SW != null && p.SW.getColor().equals(c)) { // SW
				foundEndPiece = true;
				p = p.SW;
			}
			if (direction == 7 && p.W != null && p.W.getColor().equals(c)) { // W
				foundEndPiece = true;
				p = p.W;
			}
			if (direction == 8 && p.NW != null && p.NW.getColor().equals(c)) { // NW
				foundEndPiece = true;
				p = p.NW;
			}
		}
		return p;
	}

	private boolean findLengthOfPieces(BoardPiece piece, int direction, Color c) {
		BoardPiece p = piece;
		Boolean isWinner = false;
		Boolean nextPiece = true;
		int counter = 1;
		while (nextPiece) {
			nextPiece = false;
			if (direction == 1 && p.S != null && p.S.getColor().equals(c)) { // S
				p = p.S;
				counter++;
				nextPiece = true;
			}
			if (direction == 2 && p.SW != null && p.SW.getColor().equals(c)) { // SW
				p = p.SW;
				counter++;
				nextPiece = true;
			}
			if (direction == 3 && p.W != null && p.W.getColor().equals(c)) { // W
				p = p.W;
				counter++;
				nextPiece = true;
			}
			if (direction == 4 && p.NW != null && p.NW.getColor().equals(c)) { // NW
				p = p.NW;
				counter++;
				nextPiece = true;
			}
			if (direction == 5 && p.N != null && p.N.getColor().equals(c)) { // N
				p = p.N;
				counter++;
				nextPiece = true;
			}
			if (direction == 6 && p.NE != null && p.NE.getColor().equals(c)) { // NE
				p = p.NE;
				counter++;
				nextPiece = true;
			}
			if (direction == 7 && p.E != null && p.E.getColor().equals(c)) { // E
				p = p.E;
				counter++;
				nextPiece = true;
			}
			if (direction == 8 && p.SE != null && p.SE.getColor().equals(c)) { // SE
				p = p.SE;
				counter++;
				nextPiece = true;
			}
		}

		if (counter >= Observer.getObserver().getPieceCount())
			isWinner = true;
		return isWinner;

	}
	 */

}
