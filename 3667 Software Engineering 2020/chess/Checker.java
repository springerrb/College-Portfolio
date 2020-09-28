public class Checker
{
	private GamePieceFactory GPF;
	
	Checker(GamePieceFactory GPF)
	{
		this.GPF = GPF;
	}
	
	public void play()
	{
		GPF.createPiece("Red","CheckerPiece").toString();
		GPF.createPiece("Black","CheckerPiece").toString();

	}
}