#include "worker.h"
#include <stdio.h>
#include <unistd.h>
#include <pthread.h>

long result;

pthread_mutex_t monitor = PTHREAD_MUTEX_INITIALIZER;

void HandleJob(int jid)
{
	long value;

	pthread_mutex_lock(&monitor);
	printf("Thread <%u> has accepted job %d\n", pthread_self(), jid);
	value = result;
	DoWork(jid);
	result = value + jid;
	printf("Thread <%u> has finished job %d\n", pthread_self(), jid);
	pthread_mutex_unlock(&monitor);
}

typedef struct{
	int id;
}ThreadArg;

void* ChildStart(void* arg)
{
	ThreadArg* t = arg;
	HandleJob(t->id);	
}

int main(void)
{
	pthread_t child[5];
	ThreadArg args[5];
	register int i;

	for(i = 0; i < 5; ++i)
	{
		args[i].id = i + 1;
		pthread_create(&child[i], NULL, ChildStart, &args[i]);
	}
		
	for(i = 0; i < 5; ++i)
		pthread_join(child[i], NULL);
	
	printf("Result = %ld\n", result);
}





