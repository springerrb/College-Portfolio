public class Client
{
	public static void main(String[] args)
	{
		GamePieceFactory CPF = new ChessPieceFactory();
		Chess chess = new Chess(CPF);
		
		chess.play();

		GamePieceFactory CHPF = new CheckerPieceFactory();
		Checker checker  = new Checker(CHPF);

		checker.play();

		
	}
}