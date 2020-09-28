public class CheckerPiece extends Piece
{
	CheckerPiece(String Color)
	{
		this.color = Color;
		this.type = "CheckerPiece";
	}

	public Piece CreatePiece(String Type, String Color)
	{
		return new CheckerPiece(Color);
	}
	
	public String toString()
	{
		String s = "";

		if (this.color.equals("Red"))
		s += "R";

		if (this.color.equals("Black"))
		s += "B";

		System.out.println(s);
		return s;

	}

}