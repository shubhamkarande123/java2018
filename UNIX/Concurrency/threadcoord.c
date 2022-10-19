#include "worker.h"
#include <stdio.h>
#include <unistd.h>
#include <pthread.h>

volatile long value;

void Produce(void)
{
	printf("Producer <%u> is ready...\n", pthread_self());
	usleep(2000000);
	value = DoWork(0);
}

void Consume(void)
{
	printf("Consumer <%u> is ready...\n", pthread_self());
	while(value == 0)
		pthread_yield();
	printf("Processed value is %ld\n", value * value);
}

void* ChildStart(void* arg)
{
	Consume();
}

int main(void)
{
	pthread_t child;

	pthread_create(&child, NULL, ChildStart, NULL);

	Produce();

	pthread_join(child, NULL);
}







