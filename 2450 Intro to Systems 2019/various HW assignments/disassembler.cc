#include <stdio.h>
#include <string.h>

#define LIMIT 40

void printAssembly(char filename[]);


//**************************************************
//Make sure to comment main out before submitting
//**************************************************

//int main()
//{
	//char filename[] = "test1.hex";
	//printf("is main even working?\n");
	//printAssembly(filename);
//}

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

void printAdd(int hex)
{
	int DR = 0;
	int SR1 = 0;
	int IMM = 0;
	int imm5 = getSubInt(0, 4, hex);
	int x = getMask(4, 31, 1);
	if (imm5 > 15)
	{
		imm5 = imm5 | x;
	}
	int SR2 = 0;
	
	printf("ADD\t");
	
	DR = getSubInt(9, 11, hex);
	printf("R%d, ", DR);
	
	SR1 = getSubInt(6, 8, hex);
	printf("R%d, ", SR1);
	
	IMM = getSubInt(5, 5, hex);
	if (IMM == 1)
	{
		printf("#%d", imm5);
	}
	else 
	{
		SR2 = getSubInt(0, 2, hex);
		printf("R%d", SR2);
	}

	printf("\n");
}

void printAnd(int hex)
{
	int DR = 0;
	int SR1 = 0;
	int IMM = 0;
	int imm5 = getSubInt(0, 4, hex);
	int x = getMask(4, 31, 1);
	if (imm5 > 15)
	{
		imm5 = imm5 | x;  //sets all bits above len to one
		//imm5 = imm5 & x;
		//imm5 = imm5 + 1;
		//imm5 = imm5 - 32;
				//printf("%d should be 31\n", imm5);

	}
	int SR2 = 0;
	
	printf("AND\t");
	
	DR = getSubInt(9, 11, hex);
	printf("R%d, ", DR);
	
	SR1 = getSubInt(6, 8, hex);
	printf("R%d, ", SR1);
	
	IMM = getSubInt(5, 5, hex);
	if (IMM == 1)
	{
		printf("#%d", imm5);
	}
	else 
	{
		SR2 = getSubInt(0, 2, hex);
		printf("R%d", SR2);
	}

	printf("\n");
}

void printBr(int hex, int pc)
{
	int n = 1;
	int z = 1;
	int p = 1;
	int offset = 0;
	
	printf("BR");
	
	if (getSubInt(11, 11, hex) == n)
		printf("N");
	if (getSubInt(10, 10, hex) == z)
		printf("Z");
	if (getSubInt(9, 9, hex) == p)
		printf("P");
	
	printf("\t");
	
	offset = getSubInt(0, 8, hex);
	int x = getMask(8, 31, 1);
	if (offset > 255)
	{
		offset = offset | x;
	}
	offset = offset + pc + 1;
	printf("x%X\n", offset);
}

void printJmpRet(int hex)
{
	int base = getSubInt(6, 8, hex);
	
	if (getSubInt(6, 8, hex) == 7)
		printf("RET\n");
	
	else	
	{
		printf("JMP\t");
		printf("R%d\n", base);
	}
}

void printJsrJsrr(int hex, int pc)
{
	int offset = 0;
	offset = getSubInt(0, 10, hex);
	int x = getMask(10, 31, 1);
	if (offset > 1024)
	{
		offset = offset | x;
	}
	offset = offset + pc + 1;
	
	int base = getSubInt(6, 8, hex);
	
	if (getSubInt(11, 11, hex) == 1)
		printf("JSR\tx%X\n", offset);
	else 
		printf("JSRR\tR%d\n", base);
	
}

void printLd(int hex, int pc)
{
	int DR = 0;
	DR = getSubInt(9, 11, hex);
	int offset = 0;
	offset = getSubInt(0, 8, hex);
	int x = getMask(8, 31, 1);
	if (offset > 256)
	{
		offset = offset | x;
	}
	offset = pc + offset + 1;
	
	printf("LD\tR%d, x%X\n", DR, offset);
}

void printLdi(int hex, int pc)
{
	int DR = 0;
	DR = getSubInt(9, 11, hex);
	int offset = 0;
	offset = getSubInt(0, 8, hex);
	int x = getMask(8, 31, 1);
	if (offset > 256)
	{
		offset = offset | x;
	}
	offset = pc + offset + 1;
	
	printf("LDI\tR%d, x%X\n", DR, offset);
}

void printLdr(int hex)
{
	int DR = 0;
	DR = getSubInt(9, 11, hex);
	int base = 0;
	base = getSubInt(6, 8, hex);
	
	int offset = getSubInt(0, 5, hex);
	int x = getMask(5, 31, 1);

	if (offset > 31)
	{
		offset = offset | x;
	}
	
	printf("LDR\tR%d, R%d, #%d\n", DR, base, offset);
}

void printLea(int hex, int pc)
{
	int DR = 0;
	DR = getSubInt(9, 11, hex);
	int offset = getSubInt(0, 10, hex);
	offset = getSubInt(0, 8, hex);
	int x = getMask(8, 31, 1);
	if (offset > 255)
	{
		offset = offset | x;
	}
	offset = offset + pc + 1;
	//printf("#%X\n", offset);
	
	
	printf("LEA\tR%d, x%X\n", DR, offset);
}

void printNot(int hex)
{
	int DR = 0;
	DR = getSubInt(9, 11, hex);
	int SR = 0;
	SR = getSubInt(6,8, hex);
	
	
	
	printf("NOT\tR%d, R%d\n", DR, SR);
}

void printRti(int hex)
{
	printf("RTI\n");
}

void printSt(int hex, int pc)
{
	int SR = 0;
	SR = getSubInt(9, 11, hex);
	int offset = 0;
	offset = getSubInt(0, 8, hex);
	int x = getMask(8, 31, 1);
	if (offset > 256)
	{
		offset = offset | x;
	}
	offset = pc + offset + 1;
	
	printf("ST\tR%d, x%X\n", SR, offset);
}

void printSti(int hex, int pc)
{
	int SR = 0;
	SR = getSubInt(9, 11, hex);
	int offset = 0;
	offset = getSubInt(0, 8, hex);
	int x = getMask(8, 31, 1);
	if (offset > 256)
	{
		offset = offset | x;
	}
	offset = pc + offset + 1;
	
	printf("STI\tR%d, x%X\n", SR, offset);	
}

void printStr(int hex)
{
	int SR = 0;
	SR = getSubInt(9, 11, hex);
	int base = 0;
	base = getSubInt(6, 8, hex);
	
	int offset = getSubInt(0, 5, hex);
	int x = getMask(5, 31, 1);

	if (offset > 31)
	{
		offset = offset | x;
	}
	
	printf("STR\tR%d, R%d, #%d\n", SR, base, offset);
}

void printTrap(int hex)
{
	char trap[10] = "";
	
	if (hex == 61477)
		strcpy(trap, "HALT");
	else if (hex == 61476)
		strcpy(trap, "PUTSP");
	else if (hex == 61475)
		strcpy(trap, "IN");
	else if (hex == 61474)
		strcpy(trap, "PUTS");
	else if (hex == 61473)
		strcpy(trap, "OUT");
	else if (hex == 61472)
		strcpy(trap, "GETC");
	
	
	printf("%s\n", trap);
}

void printAssembly(char filename[])
{
	//printf("printAssembly does indeed start\n");
	FILE *infile;	
	infile = fopen(filename, "r");
	//printf("check if file is NULL \n");
	if (infile == NULL)	{
		printf("File %s is null.\n", filename);			
	} else {
    int count = 0;
    int instruction = 0;
	int pc = 0;
	int x = 0;
    //printf("variables have been initialized\n");
    //Read the initial PC as an integer and save
	fscanf(infile, "%X", &instruction);
    pc = instruction;
	//printf("pc should be set to line #1 and is %X\n", pc);
    //While not at end of file and not over the limit
	//printf("entering the loop\n");
    while (fscanf(infile, "%X", &instruction) != EOF && count < LIMIT) 
	{
      count++;  //Count number of lines for limit
      
	  //printf("at the top of the loop count is %X\n", count);
      //Remove the print and put your code here
      //printf("at the top of the loop instruction is %X\n", instruction);
	  x = getSubInt(12, 15, instruction);
	//printf("x is %X \n", x);  
	  if (x == 1)
		printAdd(instruction);
	else if (x == 5)
		printAnd(instruction);
	else if (x == 0)
		printBr(instruction, pc);
	else if (x == 12)
		printJmpRet(instruction);
	else if (x == 4)
		printJsrJsrr(instruction, pc);
	else if (x == 2)
		printLd(instruction, pc);
	else if (x == 10)
		printLdi(instruction, pc);
	else if (x == 6)
		printLdr(instruction);
	else if (x == 14)
		printLea(instruction, pc);
	else if (x == 9)
		printNot(instruction);
	else if (x == 8)
		printRti(instruction);
	else if (x == 3)
		printSt(instruction, pc);
	else if (x == 11)
		printSti(instruction, pc);
	else if (x == 7)
		printStr(instruction);
	else if (x == 15)
		printTrap(instruction);
	
		  
	  
		  
      //Increment the PC
	  pc++;
      //Figure out the oppcode from the high order 4 bits of the instruction
      //Use a big if or switch to call the appropriate print function.
      //Pass the function the full instruction and the PC, but only if necessary.
      
    }
	//printf("am I skiping the loop?");
  }
}

