/*
 * This class maintains a set of ints. 
 */
public class IntSet {
	private Node node;       
    private Node head;       
	
	public IntSet() {
		
		head = new Node();
		
		
		
	}
	
	public boolean find(int key) {

		node = head;
		while (node != null) {
			if (node.data() == key)
				return true;
			node = node.next();
		}
		return false;
	}
	
	/* Insert a key into the set. */
	public void insert(int key) {
		// Make sure that the key is not present.
		assert (!find(key));
		
		
		// Perform insert.
		node = head;
		while (node != null)
		{
			if (node.data() == -1)
			{
				System.out.println("node has data");
				node.data(key);
			}
			
			if (node.next() == null)
			{
				System.out.println("next node created");
				node.link(new Node());
				return;
			}
			node = node.next();
			
		}

	}
	
	/* Remove a key from the set. */
	public void remove(int key) {
		// Make sure that the key is present.
		assert (find(key));
		
		if (head.data() == key)
		{
			System.out.println("updated head");
			
			head = head.next();
			return;
		}
		
		node = head;;
		// Find the position of the key. // Perform remove.
		while (node != null)
		{
			//System.out.println("top of remove loop");
			
			if (node.next() == null)
			{
				System.out.println("I am the tail");
				if (node.data() == key)
				{
					node.data(-1);
				}
			}
			//if(node.next().next() == null)
			//{
				//if (node.next().data() == key)
				//{
				//	node.link(new Node());
				//}
			//}
			
			else if (node.next().data() == key)
			{
				System.out.println("node updated");
				node.link(node.next().next());
			}
			
			node = node.next();
		}
		
		
	}
	
	public int max()
	{
		node = head;
		int currMax = -1;
		while (node != null)
		{
			if (node.data() > currMax)
				currMax = node.data();
			
			node = node.next();
		}
		
		return currMax;
	}
	
	
	public void sort()
	{
		
		IntSet i = new IntSet();
		int max = -1;
		
		while (node != null)
		{
			max = this.max();
			i.insert(max);
			this.remove(max);
			i.Aprint();
			this.Aprint();
		}
		
		this.head = i.head;
		
	}
	/* Print the contents of the set in sorted order. */
	public void print() 
	{
		this.sort();
		node = head;
		while (node != null)
		{
			System.out.println(node.data());
			node = node.next();
		}
		System.out.println("---------------------------");
		
		
	}
	
	public void Aprint()
	{
		node = head;
		while (node != null)
		{
			System.out.println(node.data());
			node = node.next();
		}
		System.out.println("---------------------------");
	}
}
