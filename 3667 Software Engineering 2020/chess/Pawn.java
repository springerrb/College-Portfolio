public class Pawn extends Piece
{
	Pawn(String Color)
	{
		this.color = Color;
		this.type = "Pawn";
	}

	public Piece CreatePiece(String Type, String Color)
	{
		return new Pawn(Color);
	}
}