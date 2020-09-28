public class ChessPieceFactory extends GamePieceFactory
{
	public Piece createPiece(String color, String type)
	{
		
		Piece p;

		if (type.equals("Rook"))
		{
			p = new Rook(color);
		}
		else if (type.equals("Bishop"))
		{
			p = new Bishop(color);
		}
		else if (type.equals("King"))
		{
			p = new King(color);
		}
		else if (type.equals("knight"))
		{
			p = new knight(color);
		}			
		else if (type.equals("Queen"))
		{
			p = new Queen(color);
		}
		else 
		{
			p = new Pawn(color);
		}
		
		return p;
	}


}