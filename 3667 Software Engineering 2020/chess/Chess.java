public class Chess
{
	private GamePieceFactory GPF;
	
	Chess(GamePieceFactory GPF)
	{
		this.GPF = GPF;
	}
	
	public void play()
	{
		GPF.createPiece("White","Pawn").toString();
		GPF.createPiece("Black","Pawn").toString();
		GPF.createPiece("White","King").toString();
		GPF.createPiece("Black","King").toString();
		GPF.createPiece("White","Queen").toString();
		GPF.createPiece("Black","Queen").toString();
		GPF.createPiece("White","knight").toString();
		GPF.createPiece("Black","knight").toString();
		GPF.createPiece("White","Bishop").toString();
		GPF.createPiece("Black","Bishop").toString();
		GPF.createPiece("White","Rook").toString();
		GPF.createPiece("Black","Rook").toString();


	}
}