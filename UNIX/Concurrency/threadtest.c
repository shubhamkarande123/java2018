#include "worker.h"
#include <stdio.h>
#include <unistd.h>
#include <pthread.h>

void HandleJob(int jid)
{
	printf("Thread <%u> has accepted job %d\n", pthread_self(), jid);
	DoWork(jid);
	printf("Thread <%u> has finished job %d\n", pthread_self(), jid);
}

void* ChildStart(void* arg)
{
	HandleJob(6);	
}

int main(void)
{
	pthread_t child;

	pthread_create(&child, NULL, ChildStart, NULL);

	HandleJob(5);

	pthread_join(child, NULL);
}





