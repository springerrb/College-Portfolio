import java.util.Observable;
import java.util.Observer;

public class WinnerDisplay implements Observer
{
	private String name;
	private int score;
	private Observable o;

	public WinnerDisplay(Observable o)
	{
		this.o = o;
		o.addObserver(this);
		this.name = ((Goat)o).getName();
		this.score = ((Goat)o).getScore();
	}
		
	public void update(Observable goat, Object o)
	{
		if (((Goat)goat).getScore() >= 1000)
		System.out.printf("%s wins.\n", name);
	}
}