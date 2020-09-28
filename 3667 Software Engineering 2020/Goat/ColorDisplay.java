import java.util.Observable;
import java.util.Observer;


public class ColorDisplay implements Observer
{
	private String name;
	private int score;
	private Observable o;
	private String color;

	public ColorDisplay(Goat o)
	{
		this.o = o;
		o.addObserver(this);
		
		this.name = o.getName();
		this.score = o.getScore();
		color = "Green";
		
		
	}
		
	public void update(Observable goat, Object args)
	{
		String currColor = this.color;
		
		if (((Goat)goat).getScore() >= 500)
		{
			color = "Yellow";
		}
		
		if (((Goat)goat).getScore() >= 900)
		{
			color = "Red";
		}
		
		if (currColor != this.color)
		System.out.printf("The new color scheme is %s\n", color);
	}
}