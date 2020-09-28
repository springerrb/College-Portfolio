#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdarg.h>
#include <time.h>
#include <fcntl.h>
#include <unistd.h>
#include <regex.h>

#define FILENAME "disassembler.cc"
#define FILESIZE 16384
#define TEXTSIZE 1024
#define STDOUT_FILENO 1
#define TRUE 1
#define FALSE 0
#define NUM_MATCH 20
#pragma GCC diagnostic ignored "-Wwrite-strings"

regex_t regex;

regmatch_t matches[NUM_MATCH];
int reti;

int testNoMain();
int testPrintAssembly();
int testPrintAdd();
int testPrintAnd();
int testPrintBr();
int testPrintJmpRet();
int testPrintJsrJsrr();
int testPrintLd();
int testPrintLdi();
int testPrintLdr();
int testPrintLea();
int testPrintNot();
int testPrintRti();
int testPrintSt();
int testPrintSti();
int testPrintStr();
int testPrintTrap();

int getMain(char *method);
int getMethod(char **sig, int num, char *method);
int readStudentCFile(char *filename);
int loopExists();
int getStudentFile();
void capture();
void uncapture();

char input[TEXTSIZE];
char msg[TEXTSIZE];
char studentFile[FILESIZE];
char method[FILESIZE];
int stdout_save;

int main() {
	int e = 0;
	
	if (readStudentCFile(FILENAME))
	{
		printf("Cannot open file %s.\n", FILENAME);
		exit(1);
	}
	
	if (testNoMain()) {
		printf("ERROR: File %s has a main method.  \n", FILENAME);
		e++;
	}
	if (testPrintAssembly()) {
		if (e == 1) printf("In %s:\n", FILENAME);
		printf("ERROR: Return type or parameter wrong in printAssembly.\n");
		e++;
	}
	if (testPrintAdd()) {
		if (e == 1) printf("In %s:\n", FILENAME);
		printf("ERROR: Return type or parameter wrong in printAdd.\n");
		e++;
	}
	if (testPrintAnd()) {
		if (e == 1) printf("In %s:\n", FILENAME);
		printf("ERROR: Return type or parameter wrong in printAnd.\n");
		e++;
	}
	if (testPrintBr()) {
		if (e == 1) printf("In %s:\n", FILENAME);
		printf("ERROR: Return type or parameter wrong in printBr.\n");
		e++;
	}
	if (testPrintJmpRet()) {
		if (e == 1) printf("In %s:\n", FILENAME);
		printf("ERROR: Return type or parameter wrong in printJmpRet.\n");
		e++;
	}
	if (testPrintJsrJsrr()) {
		if (e == 1) printf("In %s:\n", FILENAME);
		printf("ERROR: Return type or parameter wrong in printJsrJsrr.\n");
		e++;
	}
	if (testPrintLd()) {
		if (e == 1) printf("In %s:\n", FILENAME);
		printf("ERROR: Return type or parameter wrong in printLd.\n");
		e++;
	}
	if (testPrintLdi()) {
		if (e == 1) printf("In %s:\n", FILENAME);
		printf("ERROR: Return type or parameter wrong in printLdi.\n");
		e++;
	}
	if (testPrintLdr()) {
		if (e == 1) printf("In %s:\n", FILENAME);
		printf("ERROR: Return type or parameter wrong in printLdr.\n");
		e++;
	}
	if (testPrintLea()) {
		if (e == 1) printf("In %s:\n", FILENAME);
		printf("ERROR: Return type or parameter wrong in printLea.\n");	
		e++;
	}
	if (testPrintNot()) {
		if (e == 1) printf("In %s:\n", FILENAME);
		printf("ERROR: Return type or parameter wrong in printNot.\n");	
		e++;
	}
	if (testPrintRti()) {
		if (e == 1) printf("In %s:\n", FILENAME);
		printf("ERROR: Return type or parameter wrong in printRti.\n");	
		e++;
	}
	if (testPrintSt()) {
		if (e == 1) printf("In %s:\n", FILENAME);
		printf("ERROR: Return type or parameter wrong in printSt.\n");
		e++;
	}
	if (testPrintSti()) {
		if (e == 1) printf("In %s:\n", FILENAME);
		printf("ERROR: Return type or parameter wrong in printSti.\n");
		e++;
	}
	if (testPrintStr()) {
		if (e == 1) printf("In %s:\n", FILENAME);
		printf("ERROR: Return type or parameter wrong in printStr.\n");
		e++;
	}
	if (testPrintTrap()) {
		if (e == 1) printf("In %s:\n", FILENAME);
		printf("ERROR: Return type or parameter wrong in printTrap.\n");
		e++;
	}
	if (!e)
	{
		printf("No errors found in %s.\n", FILENAME);
	}	
	return 0;
}

int testNoMain()
{
	return !getMain(method);
}

int testPrintAssembly()
{
	char *signature[3];
	signature[0] = "void";
	signature[1] = "printAssembly";
	signature[2] = "*char";
	return getMethod(signature, 3, method);	
}

int testPrintAdd()
{
	char *signature[3];
	signature[0] = "void";
	signature[1] = "printAdd";
	signature[2] = "int";
	return getMethod(signature, 3, method);	
}

int testPrintAnd()
{
	char *signature[3];
	signature[0] = "void";
	signature[1] = "printAnd";
	signature[2] = "int";
	return getMethod(signature, 3, method);	

}

int testPrintBr()
{
	char *signature[4];
	signature[0] = "void";
	signature[1] = "printBr";
	signature[2] = "int";
	signature[3] = "int";
	return getMethod(signature, 4, method);	
}

int testPrintJmpRet()
{
	char *signature[3];
	signature[0] = "void";
	signature[1] = "printJmpRet";
	signature[2] = "int";
	return getMethod(signature, 3, method);	
}

int testPrintJsrJsrr()
{
	char *signature[4];
	signature[0] = "void";
	signature[1] = "printJsrJsrr";
	signature[2] = "int";
	signature[3] = "int";
	return getMethod(signature, 4, method);	
}

int testPrintLd()
{
	char *signature[4];
	signature[0] = "void";
	signature[1] = "printLd";
	signature[2] = "int";
	signature[3] = "int";
	return getMethod(signature, 4, method);	
}

int testPrintLdi()
{
	char *signature[4];
	signature[0] = "void";
	signature[1] = "printLdi";
	signature[2] = "int";
	signature[3] = "int";
	return getMethod(signature, 4, method);	
}

int testPrintLdr()
{
	char *signature[3];
	signature[0] = "void";
	signature[1] = "printLdr";
	signature[2] = "int";
	return getMethod(signature, 3, method);	

}

int testPrintLea()
{
	char *signature[4];
	signature[0] = "void";
	signature[1] = "printLea";
	signature[2] = "int";
	signature[3] = "int";
	return getMethod(signature, 4, method);
}

int testPrintNot()
{
	char *signature[3];
	signature[0] = "void";
	signature[1] = "printNot";
	signature[2] = "int";
	return getMethod(signature, 3, method);	
}

int testPrintRti()
{
	char *signature[3];
	signature[0] = "void";
	signature[1] = "printRti";
	signature[2] = "int";
	return getMethod(signature, 3, method);	
}

int testPrintSt()
{
	char *signature[4];
	signature[0] = "void";
	signature[1] = "printSt";
	signature[2] = "int";
	signature[3] = "int";
	return getMethod(signature, 4, method);
}

int testPrintSti()
{
	char *signature[4];
	signature[0] = "void";
	signature[1] = "printSti";
	signature[2] = "int";
	signature[3] = "int";
	return getMethod(signature, 4, method);
}

int testPrintStr()
{
	char *signature[3];
	signature[0] = "void";
	signature[1] = "printStr";
	signature[2] = "int";
	return getMethod(signature, 3, method);	
}

int testPrintTrap()
{
	char *signature[3];
	signature[0] = "void";
	signature[1] = "printTrap";
	signature[2] = "int";
	return getMethod(signature, 3, method);	
}

void getParamRE(char *regexp, char *param)
{

	if (param[0] == '*')
	{
		strcat(regexp, "\\s*");
		strcat(regexp, "\\(\\(");
		strcat(regexp, &param[1]);
		strcat(regexp, "\\s\\+\\*\\w\\+");
		strcat(regexp, "\\)\\|\\(");
		strcat(regexp, &param[1]);
		strcat(regexp, "\\s\\+\\w\\+\\s*\\[\\s*\\]");
		strcat(regexp, "\\)\\)");

	}
	else
	{
		strcat(regexp, "\\s*");
		strcat(regexp, param);
		strcat(regexp, "\\s\\+\\w\\+");
	}
}

/**
 * Find a method given the method header.  The method will be stored
 * in the globa char array method as a string.
 * @param sig Signature string array with return type, method name
 * and parameter types, in that order.
 * @param num The total number of strings in sig.
 * @param method The char array to copy this method into if it is found. 
 */
int getMethod(char **sig, int num, char *method)
{
	if (strlen(studentFile) == 0) return 1;
 	

	char regexp[TEXTSIZE];
	regexp[0] = 0;
	//printf(":%s\n", sig[0]);
	//printf(":%s\n", sig[1]);
	//printf(":%s\n", sig[2]);
	strcat(regexp, sig[0]);
	strcat(regexp, "\\s\\+");	
	strcat(regexp, sig[1]);
	strcat(regexp, "\\s*(");
	if (num > 2)
	{
		getParamRE(regexp, sig[2]);
		for (int i = 3; i < num; i++)
		{
			strcat(regexp,"\\s*,\\s*");
			getParamRE(regexp, sig[i]);
		}
	}
	else
	{
		strcat(regexp, "\\s*\\(void\\)?");
	}

	//strcat(regexp, "\\s*)[^{;]*{");
	strcat(regexp, "\\s*)\\s*{");

	//printf("RE: %s\n", regexp);	
	reti = regcomp(&regex, regexp, 0);
	if (reti) {
		//fprintf(stderr, "Could not compile regex\n");
		return 3;
	}

	/* Execute regular expression */
	reti = regexec(&regex, studentFile, NUM_MATCH, matches, 0);
	if (!reti) {

		int start = (int)matches[0].rm_so;
		int end = (int)matches[0].rm_eo;		
		studentFile[start] = 'X';
		studentFile[end] = 'E';
		int openCount = 1;
		//printf("%s\n", studentFile);
		//printf("RegExp: %s\n", regexp);
		//printf("Start:%d\tStop:%d\n", start, end);

		while (openCount > 0 && end < FILESIZE)
		{
			if (studentFile[end] == '{')
				openCount++;
			else if (studentFile[end] == '}')
				openCount--;
			end++;
		}

		strncpy(method, &studentFile[start], end - start);
		method[end - start] = '\0'; 
		//printf("METHOD: %s\n", method);
		return 0;

	}
	else
	{
		//printf("No match\n");
		//printf("RE: %s\n", regexp);	
		//printf("%s\n", studentFile);
		return 2;
	}	
}

/**
 * Find a main method.  Function main has several different signature
 * possibilities which makes it a bit different from a normal function.
 * @param method The char array to copy main into if it is found. 
 */
int getMain(char *method)
{
	if (strlen(studentFile) == 0) return 1;
 	
	char *regexp = "\\(\\(int\\)\\|\\(void\\)\\)\\s*main\\s*([^)]*)\\s*{";

	//printf("RE: %s\n", regexp);	
	reti = regcomp(&regex, regexp, 0);
	if (reti) {
		//fprintf(stderr, "Could not compile regex\n");
		return 3;
	}

	/* Execute regular expression */
	reti = regexec(&regex, studentFile, NUM_MATCH, matches, 0);
	if (!reti) {

		int start = (int)matches[0].rm_so;
		int end = (int)matches[0].rm_eo;		
		int openCount = 1;
		//printf("%s\n", studentFile);
		//printf("Start:%d\tStop:%d\n", start, end);

		while (openCount > 0 && end < FILESIZE)
		{
			if (studentFile[end] == '{')
				openCount++;
			else if (studentFile[end] == '}')
				openCount--;
			end++;
		}

		strncpy(method, &studentFile[start], end - start);
		method[end - start] = '\0'; 
		//printf("%s\n", method);
		return 0;

	}
	else
	{
		//printf("No match\n");
		//printf("RE: %s\n", regexp);	
		//printf("Student File\n%s\n", studentFile);
		return 2;
	}	
}

/*
 *	Reads a file into the studentFile char array.  
 * 	This file is assumed to be a C program and will
 * 	have all comments removed.
 *	@param *filename The name of the student file to open.
 *	@return Returns true if the file was opened and read properly.
 */
int readStudentCFile(char *filename)
{
	FILE *file;
	char c = ' ';
	char lc = ' ';
	int charCount = 0;
	int inSingle = 0;
	int inMulti = 0;
	
	file = fopen(filename, "r");

	if (file == NULL) return 1;
	
	
	c = fgetc(file);
	lc = c;
	
	studentFile[charCount++] = c;
	
	c = fgetc(file);
	
	
	while (charCount < FILESIZE && c != EOF) {
		if (inMulti) {
			if (c == '\n') {
				studentFile[charCount++] = '\n';
			}else if(lc == '*' && c == '/') {
				inMulti = FALSE;
				lc = ' ';
				c = ' ';
				studentFile[charCount-1] = ' ';
				studentFile[charCount++] = ' ';
			}
			else
			{
				studentFile[charCount++] = ' ';
				lc = c;
			}
		} else if (inSingle) {
			if (c == '\n') {
				inSingle = FALSE;
				lc = ' ';
				studentFile[charCount++] = '\n';
			} else {
				studentFile[charCount++] = ' ';
				lc = c;
			}			
		} else { 
			if (lc == '/') { 
				if (c == '/') {
					inSingle = TRUE;
					lc = ' ';
					c = ' ';
					studentFile[charCount-1] = ' ';
					studentFile[charCount++] = ' ';
				}
				else if (c == '*')
				{
					inMulti = TRUE;
					lc = ' ';
					c = ' ';
					studentFile[charCount-1] = ' ';
					studentFile[charCount++] = ' ';
				}
				else
				{
					studentFile[charCount++] = c;
					lc = c;
				}
				
			} else {
				studentFile[charCount++] = c;
				lc = c;
			}
		}
		
		c = fgetc(file);
	}
	
	//Make it a proper string
	studentFile[charCount] = '\0';	

	//Returns false if EOF was not reached which 
	//means we ran out of room in the array.	
	if (c == EOF) 
	{
		//printf("EOF Reached.\n");
		return 0;
	}
	else 
	{
		printf("ERROR: EOF Not Reached.  Entire file not read.\n");
		return 1;
	}	
}	
	 


//Return 1 if loop found.  Return 0 if no loop found.
int loopExists()
{
	if (!readStudentCFile(FILENAME)) 
	{
		printf("Can't read student file: %s.  Failing test.", FILENAME);
		return TRUE;
	}
	
	return FALSE;
}
	
void capture()
{    
      fflush(stdout); //clean everything first
      stdout_save = dup(STDOUT_FILENO); //save the stdout state
      freopen("NUL", "a", stdout); //redirect stdout to null pointer
      setvbuf(stdout, input, _IOFBF, 1024); //set buffer to stdout
}

void uncapture()
{
      freopen("NUL", "a", stdout); //redirect stdout to null again
      dup2(stdout_save, STDOUT_FILENO); //restore the previous state of stdout
      setvbuf(stdout, NULL, _IONBF, 0); //disable buffer to print to screen instantly
}


