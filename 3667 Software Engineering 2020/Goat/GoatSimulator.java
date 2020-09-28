import java.util.Observable;


public class GoatSimulator
{
	public static void main(String[] args)
	{
		
		
		Goat Billy = new Goat("Billy");
		Goat Tom = new Goat("Tom");
		Goat Sharkisha = new Goat("Sharkisha");
		
		
		
		Billy.addObserver(new ImageDisplay(Billy));
		Billy.addObserver(new PointDisplay(Billy));
		Billy.addObserver(new ColorDisplay(Billy));
		Billy.addObserver(new WinnerDisplay(Billy));
		
		Tom.addObserver(new ImageDisplay(Tom));
		Tom.addObserver(new PointDisplay(Tom));
		Tom.addObserver(new ColorDisplay(Tom));
		Tom.addObserver(new WinnerDisplay(Tom));
		
		Sharkisha.addObserver(new ImageDisplay(Sharkisha));
		Sharkisha.addObserver(new PointDisplay(Sharkisha));
		Sharkisha.addObserver(new ColorDisplay(Sharkisha));
		Sharkisha.addObserver(new WinnerDisplay(Sharkisha));
		
		
		Billy.addPoints(0);
		Tom.addPoints(200);
		Billy.addPoints(500);
		Tom.addPoints(40);
		Tom.addPoints(200);
		Tom.addPoints(400);
		Tom.addPoints(50);
		Billy.addPoints(150);
		Tom.addPoints(100);
		Sharkisha.addPoints(0);
		Billy.addPoints(300);
		Sharkisha.addPoints(1000);
	}
}