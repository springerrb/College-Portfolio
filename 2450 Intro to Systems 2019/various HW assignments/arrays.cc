#include <stdio.h>

double findCloseToZero(double myArray[], int numItems)
{
	double abs = 0;
	double x = myArray[0];
	double absx = 0;
	for (int i = 1; i < numItems; i++)
	{
		absx = x;
		if (absx < 0)
			absx = absx * -1;

		abs = myArray[i];
		if (abs < 0)
			abs = abs * -1;

		if (abs < absx)
			x = myArray[i];
	}
	return x;
}

double findFarFromZero(double myArray[], int numItems)
{
	double x = myArray[0];
	double abs = 0;
	double absx = 0;
	for (int i = 1; i < numItems; i++)
	{
		absx = x;
		if (absx < 0)
			absx = absx * -1;

		abs = myArray[i];
		if (abs < 0)
			abs = abs * -1;

		if (abs > absx)
			x = myArray[i];
	}
	return x;
}

int countDivisible(int myArray[], int numItems, int divisor)
{
	int count = 0;
	int x = 0;
	for (int i = 0; i < numItems; i++)
	{
		x = myArray[i] / divisor;
		if (x * divisor == myArray[i])
			count++;
	}
	return count;
}


int countWholeNumbers(double myArray[], int numItems)
{
	double x = 0;
	int count = 0;
	for (int i = 0; i < numItems; i++)
	{
		x = int(myArray[i] / 1);
		if (x == myArray[i])
			count++;
	}
	return count;
}


double sumFractions(double myArray[], int numItems)
{
	double sum = 0;
	double x = 0;
	for (int i = 0; i < numItems; i++)
	{
		sum += myArray[i];
		x = int(myArray[i] / 1);
		sum -= x;
	}
	printf("%f", sum);
	return sum;
}


int countAbsoluteRangeValues(double myArray[], int numItems, double param)
{
	double abs = 0;
	double afterParam = 0;
	if (param < 0)
	{
		param = param * -1;
	}

	int count = 0;
	for (int i = 0; i < numItems; i++)
	{
		abs = myArray[i];
		
		printf("%f abs", abs);

		if (abs < 0)
			abs = abs * -1;
		printf("%f abs", abs);
		printf("%f param", param);
		afterParam = abs - param;
		printf("%f afterParam", afterParam);
		if (afterParam < 0)
			afterParam = afterParam * -1;
		printf("%f afterparam", afterParam);
		if (afterParam < .5)
		count++;

		printf("%d count", count);
	}
		
	return count;
}

double abs(double num)
{
	double x = num;
	if (x < 0)
		x = x * -1;
	return x;
}

