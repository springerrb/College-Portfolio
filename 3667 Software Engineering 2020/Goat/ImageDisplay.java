import java.util.Observable;
import java.util.Observer;

public class ImageDisplay implements Observer
{
	private String name;
	private Observable o;

	public ImageDisplay(Observable o)
	{
		this.o = o;
		o.addObserver(this);
		this.name = ((Goat)o).getName();
	}
		
	public void update(Observable goat, Object o)
	{
		System.out.println(name + " is made bigger.");
	}
}