public class knight extends Piece
{
	knight(String Color)
	{
		this.color = Color;
		this.type = "knight";
	}

	public Piece CreatePiece(String Type, String Color)
	{
		return new knight(Color);
	}
}