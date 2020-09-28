

public class StackTest
{
	public static void main(String[] args)
	{
		IntStack stack = new IntStack();
	
	stack.push(1);
	System.out.println(stack.pop());
	
	stack.push(1);
	stack.push(2);
	System.out.println(stack.pop());
	System.out.println(stack.pop());

	
	
	stack.push(1);
	stack.push(2);
	stack.push(3);
	System.out.println(stack.pop());
	System.out.println(stack.pop());
	System.out.println(stack.pop());
	
	System.out.println(stack.pop());
		
	}

}