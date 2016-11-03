addNeighbors(board);
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