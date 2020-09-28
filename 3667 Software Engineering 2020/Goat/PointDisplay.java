import java.util.Observable;
import java.util.Observer;

public class PointDisplay implements Observer
{
	private String name;
	private int score;
	private Observable o;

	public PointDisplay(Observable o)
	{
		this.o = o;
		o.addObserver(this);
		this.name = ((Goat)o).getName();
		this.score = ((Goat)o).getScore();
	}
		
	public void update(Observable goat, Object o)
	{
		System.out.printf("%s ate something and now has %d points.\n", name, ((Goat)goat).getScore());
	}
}