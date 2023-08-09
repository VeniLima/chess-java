package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {
	
	private ChessMatch chessMatch;

	public King(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}

	@Override
	public String toString() {
		return "K";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position p = new Position(0, 0);
		p.setValues(position.getRow() - 1, position.getColumn());
		// above
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// below
		p.setValues(position.getRow() + 1, position.getColumn());
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// right
		p.setValues(position.getRow(), position.getColumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// left
		p.setValues(position.getRow(), position.getColumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// upleft
		p.setValues(position.getRow() - 1, position.getColumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// upright
		p.setValues(position.getRow() - 1, position.getColumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// downleft
		p.setValues(position.getRow() + 1, position.getColumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// downright
		p.setValues(position.getRow() + 1, position.getColumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// special move castling
		if(getMoveCount() == 0 && !chessMatch.getCheck()) {
			// castling kingside
			Position kingSideRookPosition = new Position(position.getRow(), position.getColumn() + 3);
			
			if(testRookCastling(kingSideRookPosition)) {
				Position firstPositionBetweenRook = new Position(position.getRow(), position.getColumn() + 1);
				Position secondPositionBetweenRook = new Position(position.getRow(), position.getColumn() + 2);
				
				if(getBoard().piece(firstPositionBetweenRook) == null && getBoard().piece(secondPositionBetweenRook) == null) {
					mat[position.getRow()][position.getColumn() + 2] = true;
				}
				
			}
			
			// castling queenside
			Position queenSideRookPosition = new Position(position.getRow(), position.getColumn() - 4);
			
			if(testRookCastling(queenSideRookPosition)) {
				Position firstPositionBetweenRook = new Position(position.getRow(), position.getColumn() - 1);
				Position secondPositionBetweenRook = new Position(position.getRow(), position.getColumn() - 2);
				Position thirdPositionBetweenRook = new Position(position.getRow(), position.getColumn() - 3);
				
				if(getBoard().piece(firstPositionBetweenRook) == null && getBoard().piece(secondPositionBetweenRook) == null && getBoard().piece(thirdPositionBetweenRook) == null) {
					mat[position.getRow()][position.getColumn() - 2] = true;
				}
				
			}
		}

		return mat;
	}

	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		return p == null || p.getColor() != getColor();
	}
	
	private boolean testRookCastling(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		
		return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
	}

}
