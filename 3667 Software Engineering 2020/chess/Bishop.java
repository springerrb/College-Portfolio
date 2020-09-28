public class Bishop extends Piece
{
	Bishop(String Color)
	{
		this.color = Color;
		this.type = "Bishop";
	}

	public Piece CreatePiece(String Type, String Color)
	{
		return new Bishop(Color);
	}
}