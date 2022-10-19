#include <stdio.h>
#include <string.h>
#include <unistd.h>
#include <dlfcn.h>

extern int ProcessBuffer(char[], int);

int main(int argc, char* argv[])
{
	char text[80];
	void* lib;
	int (*pbfunc)(char[],int);

	if(argc < 2)
		return printf("USAGE: %s library-name\n", argv[0]);

	lib = dlopen(argv[1], RTLD_NOW);

	if(lib == NULL)
		return printf("ERROR: Cannot open %s\n", argv[1]);

	pbfunc = dlsym(lib, "ProcessBuffer");

	if(pbfunc)
	{	
		printf("Text to process: ");
		scanf("%79[^\n]s", text);	

		pbfunc(text, strlen(text));

		printf("Processed text is %s\n", text);
	}
	else
		return printf("ERROR: Bad library\n");
	
	dlclose(lib);
}

