public class IntStack {
	// May create private data here.
	int[] stack;


	public IntStack() 
	{
		stack = new int[100];
	}

	public void push(int x) 
	{
		// TODO: Code to push an item x onto the stack. The stack wlil never contain more than 100 elements.
		for (int i = 0; i < 100; i++)
		{
			if (stack[i] == 0)
			{
				stack[i] = x;
				return;
			}
		}
	}

	public int pop() 
	{
		// TODO: Code to pop and retrun an item from the top of the stack. If the stack is empty, return -1.
		int pop = 0;
		if (stack[0] == 0)
			return -1;
		
		for (int i = 0; i < 100; i++)
		{
			if (stack[i] == 0)
			{
				pop = stack[i-1];
				stack[i-1] = 0;
				
				return pop;
			}
		}
		return 999;
	}
}
