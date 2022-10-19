#include "worker.h"
#include <stdio.h>
#include <unistd.h>

int main(int argc, char* argv[])
{
	if(argc < 2)
		return printf("USAGE: %s program-to-execute\n", argv[0]);

	printf("Welcome from process <%d/%d>\n", getpid(), getppid());

	if(execl(argv[1], NULL) == -1)
	{
		return printf("ERROR: Cannot execute %s\n", argv[1]);
	}

	wait(NULL);

	printf("Goodbye from process <%d/%d>\n", getpid(), getppid());
}

