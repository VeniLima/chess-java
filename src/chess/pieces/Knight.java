package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Knight extends ChessPiece {

	public Knight(Board board, Color color) {
		super(board, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] possibleMovesMatrix = new boolean[getBoard().getRows()][getBoard().getColumns()];
		Position p = new Position(0, 0);

		// upleft
		p.setValues(position.getRow() - 2, position.getColumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			possibleMovesMatrix[p.getRow()][p.getColumn()] = true;
		}

		// upright
		p.setValues(position.getRow() - 2, position.getColumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			possibleMovesMatrix[p.getRow()][p.getColumn()] = true;
		}

		// downright
		p.setValues(position.getRow() + 2, position.getColumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			possibleMovesMatrix[p.getRow()][p.getColumn()] = true;
		}

		// downleft
		p.setValues(position.getRow() + 2, position.getColumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			possibleMovesMatrix[p.getRow()][p.getColumn()] = true;
		}

		// left up
		p.setValues(position.getRow() - 1, position.getColumn() - 2);
		if (getBoard().positionExists(p) && canMove(p)) {
			possibleMovesMatrix[p.getRow()][p.getColumn()] = true;
		}

		// left down
		p.setValues(position.getRow() + 1, position.getColumn() - 2);
		if (getBoard().positionExists(p) && canMove(p)) {
			possibleMovesMatrix[p.getRow()][p.getColumn()] = true;
		}
		
		// right up
		p.setValues(position.getRow() + 1, position.getColumn() + 2);
		if (getBoard().positionExists(p) && canMove(p)) {
			possibleMovesMatrix[p.getRow()][p.getColumn()] = true;
		}
		
		// right down
		p.setValues(position.getRow() - 1, position.getColumn() + 2);
		if (getBoard().positionExists(p) && canMove(p)) {
			possibleMovesMatrix[p.getRow()][p.getColumn()] = true;
		}

		return possibleMovesMatrix;
	}

	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		return p == null || p.getColor() != getColor();
	}

	@Override
	public String toString() {
		if(this.getColor() == Color.BLACK) {
			return "♞";
		}else {
			return "♘";
		}
	}

}
