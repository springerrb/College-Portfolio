public class Queen extends Piece
{
	Queen(String Color)
	{
		this.color = Color;
		this.type = "Queen";
	}

	public Piece CreatePiece(String Type, String Color)
	{
		return new Queen(Color);
	}
}