public class HashTable 
{
	private Node[] table;
	private int size;
	private HashFunctions hash;
	private int length;
	
	
	
	public HashTable(int s)
	{
		size = s;
		table = new Node[size];
		//for (int i = 0; i < size; i++)
		//{
			//table[i] = new Node(); // populate the empty table with null nodes (tails)
		//}
		
		length = 0; // our new list has length 0
		
		hash = new HashFunctions(size); // needs a preset list of hash functions
	}
	
	public void insert(int k, int p)
	{
		int i = 0;
		switch(p) {	//use the appropriate hash function to hash k into i
			case 1: i = hash.hash1(k);
							break;
			case 2: i = hash.hash2(k);
							break;
			case 3: i = hash.hash3(k);
							break;
			case 4: i = hash.hash4(k);
							break;
			default: System.out.println("Invalid program number. Only 1-4.");
		}
		
		//the ith list head is updated with k linked to prev. head
		table[i] = new Node(k, table[i]);
	}
	
	public void remove(int k, int p)
	{
		Node n = this.find(k, p);
		n = n.next();
	}
	
	public Node find(int k, int p)
	{
		int i = 0;
		switch(p) {	//use the appropriate hash function to hash k into i
			case 1: i = hash.hash1(k);
							break;
			case 2: i = hash.hash2(k);
							break;
			case 3: i = hash.hash3(k);
							break;
			case 4: i = hash.hash4(k);
							break;
			default: System.out.println("Invalid program number. Only 1-4.");
		}
		
		for (Node n = table[i]; n != null; n = n.next())
		{
			if (n.data() == k)
				return n;
		}
		
		System.out.println("key not found");
		return null;
	}
	
	public void print()
	{
		
		for (int i = 0; i < size; i++)
		{
			for (Node n = table[i]; n != null; n = n.next())
			{
				System.out.println(n.data());
			}
		}		
	}
	
	public void print(Node N)
	{
		if (length <= size)
		{
			for (Node n = N; n != null; n = n.next()) // for all 
				System.out.println(n.data());	// print
				
			System.out.println(length); // also prints the length of the list
		}
		else
		{
			for (int i = 0; i < length - size; i++) // for as many times as the list is too large
			{
				N = N.link(); // remove the head of the list
				length += -1;   //decrement length
			}			
				
			print(N);
		}
		
	}
	
	public Node longest()
	{
		int max = 0;
		int index = 0;
		int count = 0;
		
		for (int i = 0; i < size; i++)
		{
			count = 0;
			
			for (Node n = table[i]; n != null; n = n.next())
			{
				count++;
			}
			
			if (count > max)
			{
				max = count;
				index = i;
			}
		}
		
		//for (int i = 0; i < size; i++)
		//{
		//	table[i] = table[index];
		//}
		
		length = max;
		return table[index];
	}
	
	public int getLength()
	{
		return this.length;
	}
	
	public Node expand(int n, int p)
	{
		while (length < size) //while we don't have enough keys
		{
			for (Node i = this.longest(); i != null; i = i.next()) //for the longest node list in the table
			{
				//for each node add 
				//another key where key = key * p 
				//using hashFunction p 
				
				if ((i.data() + n) < (size * size)) // if n + p < c 
				this.insert(i.data() + n, p);       // insert 
			}
		}
		
		return this.longest(); // returns only the node that heads the longest list
		
	}
	
	
}