#include <stdio.h>
#include <string.h>
#include <unistd.h>

extern int ProcessBuffer(char[], int);

int main(void)
{
	char text[80];

	printf("Text to process: ");
	scanf("%79[^\n]s", text);	

	ProcessBuffer(text, strlen(text));

	printf("Processed text is %s\n", text);
}

