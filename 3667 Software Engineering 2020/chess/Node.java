

public class Node
{
	private int data;
	private Node link;
	
	public Node()
	{
		this.link = null;
		this.data = -1;
	}
	
	public Node(int x)
	{
		this.link = null;
		this.data = x;
	}
	
	public Node(int x, Node n)
	{
		this.link = n;
		this.data = x;
	}
	
	public Node(Node n)
	{
		this.link = n;
		this.data = -1;
	}
	
	public Node next()
	{
		return (this.link);
	}
	
	public int data()
	{
		return this.data;
	}
	
	public void data(int x)
	{
		this.data = x;
	}
	
	public Node link()
	{
		return this.link;
	}
	
	public void link(Node n)
	{
		this.link = n;
	}
}