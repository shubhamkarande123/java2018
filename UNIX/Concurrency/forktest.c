#include "worker.h"
#include <stdio.h>
#include <unistd.h>

void HandleJob(int jid)
{
	printf("Process <%d/%d> accepted job with id %d\n", getpid(), getppid(), jid);
	DoWork(jid);
	printf("Process <%d/%d> finished job with id %d\n", getpid(), getppid(), jid);
}


int main(void)
{
	pid_t child;

	child = fork();

	if(child == 0)
	{
		HandleJob(6);
	}
	else
	{
		HandleJob(5);
		waitpid(child, NULL, 0);
	}
}

