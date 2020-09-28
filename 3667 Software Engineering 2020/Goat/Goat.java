import java.util.Observable;


public class Goat extends Observable
{
	private String name;
	private int score;
	
	
	public Goat(String name)
	{
		score = 0;
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public int getScore()
	{
		return score;
	}
	
	public void setScore(int score)
	{
		this.score = score;
	}
	
	public void addPoints(int points)
	{
		if (points > 0)
		{
			score += points;
			setChanged();
			notifyObservers();
		}
		
	}
	
	
}