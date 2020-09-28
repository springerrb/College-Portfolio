#include<stdio.h>

void printRectangleWhile(int Coln, int Rown)
{
	if(!(Rown == 1||Coln == 1))
	{
		int i = 0;
		int j = 0;
		while (i < Rown)
		{
			j = 0;
			while (j < Coln)
			{

				if(i == 0 || i == (Rown - 1)|| j == 0 || j == (Coln - 1))
				{
					printf("+");
				}
				else
				{
					printf("-");
				}
				if(j == (Coln - 1))
				{
					printf("\n");
				}
			j++;}
		i++;}
	}
	else
	{return;}
}


void printTriangleFor(int n)
{
	if(n > 0)
	{
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				if (i == (n-1))
				{printf("+");}
				else if (i != (n-1) && ((j == (n - 1) || j == n - i - 1)))
				{
					printf("+");
				}
				else if (j > n - i)
				{
					printf("-");
				}
				else if (j < n - i) 
				{
					printf(" ");
				}
				else
				{
					printf("-");
				}

				if (j == (n-1))
				{
					printf("\n");
				}
			}
		}
	}
	else
	{
		return ;
	}
}

