#include <stdio.h>


int getMask(int start, int end, int mask)
{
	int x = 1;
	if ((mask != 0 && mask != 1) || ( start < 0 || end > 31) || (start > end))
		return 0;
	int y = end - start + 1;

	//printf("%X \n", x);
	x = x << y;
	//printf("%X \n", x);
	x = x - 1;
	//printf("%X \n", x);
	x = x << start;
	//printf("%X \n", x);
	//printf("if mask were 1 then x would be %X", x);	
	
	if (y > 31)
	x = 0xFFFFFFFF;
	if (mask == 0)
	x = ~x;
	
	
	return x;
}


int getSubInt(int start, int end, int bits)
{
	if (( start < 0 || end > 31) || (start > end))
		return 0;
	int x = bits >> start;
	int y = getMask(0, end - start, 1);
	x = x & y;
	
	return x;
}



void printDashHex(int hex)
{
	int one = getSubInt(0, 3, hex);
	//printf("one is %X \n", one);
	int two = getSubInt(4, 7, hex);
	//printf("two is %X \n", two);
	int three = getSubInt(8, 11, hex);
	//printf("three is %X \n", three);
	int four = getSubInt(12, 15, hex);
	//printf("four is %X \n", four);
	int five = getSubInt(16, 19, hex);
	//printf("five is %X \n", five);
	int six = getSubInt(20, 23, hex);
	//printf("six is %X \n", six);
	int seven = getSubInt(24, 27, hex);
	//printf("seven is %X \n", seven);
	int eight = getSubInt(28, 31, hex);
	//printf("eight is %X \n", eight);
	
	printf("%X-%X-%X-%X-%X-%X-%X-%X\n", eight, seven, six, five, four, three, two, one);
}
