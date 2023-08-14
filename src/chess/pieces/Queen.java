package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Queen extends ChessPiece{

	public Queen(Board board, Color color) {
		super(board, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] possibleMovesMatrix = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position p = new Position(0, 0);

		// above
		p.setValues(position.getRow() - 1, position.getColumn());
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			possibleMovesMatrix[p.getRow()][p.getColumn()] = true;

			p.setRow(p.getRow() - 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			possibleMovesMatrix[p.getRow()][p.getColumn()] = true;
		}
		
		// up left
		p.setValues(position.getRow() - 1, position.getColumn() - 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			possibleMovesMatrix[p.getRow()][p.getColumn()] = true;

			p.setRow(p.getRow() - 1);
			p.setColumn(p.getColumn() - 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			possibleMovesMatrix[p.getRow()][p.getColumn()] = true;
		}
		
		// up right
		p.setValues(position.getRow() - 1, position.getColumn() + 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			possibleMovesMatrix[p.getRow()][p.getColumn()] = true;

			p.setRow(p.getRow() - 1);
			p.setColumn(p.getColumn() + 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			possibleMovesMatrix[p.getRow()][p.getColumn()] = true;
		}
		
		// up left
		p.setValues(position.getRow() - 1, position.getColumn() - 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			possibleMovesMatrix[p.getRow()][p.getColumn()] = true;

			p.setRow(p.getRow() - 1);
			p.setColumn(p.getColumn() - 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			possibleMovesMatrix[p.getRow()][p.getColumn()] = true;
		}
		
		// down right
		p.setValues(position.getRow() + 1, position.getColumn() + 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			possibleMovesMatrix[p.getRow()][p.getColumn()] = true;

			p.setRow(p.getRow() + 1);
			p.setColumn(p.getColumn() + 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			possibleMovesMatrix[p.getRow()][p.getColumn()] = true;
		}
		
		// left right
		p.setValues(position.getRow() + 1, position.getColumn() - 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			possibleMovesMatrix[p.getRow()][p.getColumn()] = true;

			p.setRow(p.getRow() + 1);
			p.setColumn(p.getColumn() - 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			possibleMovesMatrix[p.getRow()][p.getColumn()] = true;
		}
		
		// left
		p.setValues(position.getRow(), position.getColumn() - 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			possibleMovesMatrix[p.getRow()][p.getColumn()] = true;

			p.setColumn(p.getColumn() - 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			possibleMovesMatrix[p.getRow()][p.getColumn()] = true;
		}

		// right
		p.setValues(position.getRow(), position.getColumn() + 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			possibleMovesMatrix[p.getRow()][p.getColumn()] = true;

			p.setColumn(p.getColumn() + 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			possibleMovesMatrix[p.getRow()][p.getColumn()] = true;
		}

		// down
		p.setValues(position.getRow() + 1, position.getColumn());
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			possibleMovesMatrix[p.getRow()][p.getColumn()] = true;

			p.setRow(p.getRow() + 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			possibleMovesMatrix[p.getRow()][p.getColumn()] = true;
		}
		
		
		
		return possibleMovesMatrix;
	}
	
	@Override
	public String toString() {
		if(this.getColor() == Color.BLACK) {
			return "♛";
		}else {
			return "♕";
		}
	}

}
