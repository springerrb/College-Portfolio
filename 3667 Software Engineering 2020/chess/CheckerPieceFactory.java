public class CheckerPieceFactory extends GamePieceFactory
{

	public Piece createPiece(String color, String type)
	{
		
		Piece p;

		p = new CheckerPiece(color);
						
		return p;
	}


}