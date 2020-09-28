public abstract class Piece
{
	public String color;
	public String type;
	
	public abstract Piece CreatePiece(String color, String type);
	
	
	public String toString()
	{
		String s = "";
		
		if(color.equals("Black")) 
		{
			s += "B";
		}
		else 
		{
			s += "W";
		}
		
		if (type.equals("Rook"))
		{
			s += "R";
		}
		else if (type.equals("Bishop"))
		{
			s += "B";
		}
		else if (type.equals("King"))
		{
			s += "K";
		}
		else if (type.equals("knight"))
		{
			s += "k";
		}			
		else if (type.equals("Queen"))
		{
			s += "Q";
		}
		else 
		{
			s += "P";
		}

		System.out.println(s);
		return s;
	}
	
}