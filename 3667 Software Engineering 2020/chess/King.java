public class King extends Piece
{
	King(String Color)
	{
		this.color = Color;
		this.type = "King";
	}

	public Piece CreatePiece(String Type, String Color)
	{
		return new King(Color);
	}
}