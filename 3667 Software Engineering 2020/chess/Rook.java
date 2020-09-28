public class Rook extends Piece
{
	Rook(String Color)
	{
		this.color = Color;
		this.type = "Rook";
	}

	public Piece CreatePiece(String Type, String Color)
	{
		return new Rook(Color);
	}
}