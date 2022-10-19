#include "worker.h"
#include <stdio.h>
#include <unistd.h>
#include <pthread.h>

/*
char* text;

void WriteMessage(char* msg)
{
	text = msg;
}

char* ReadMessage(void)
{
	return text;
}
*/

pthread_key_t key;

void WriteMessage(char* msg)
{
	pthread_setspecific(key, msg);
}

char* ReadMessage(void)
{
	return pthread_getspecific(key);
}

void PrintMessage(int copies)
{
	register int i;

	for(i = 0; i < copies; ++i)
	{
		printf("Thread <%u> printed message %s\n", pthread_self(), ReadMessage());
		DoWork(i);
	}
}

void* ChildStart(void* arg)
{
	WriteMessage("Hello");
	PrintMessage(5);
}


int main(void)
{
	pthread_t child;

	pthread_key_create(&key, NULL);

	pthread_create(&child, NULL, ChildStart, NULL);

	WriteMessage("Welcome");
	PrintMessage(7);
}




