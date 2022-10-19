#include "worker.h"
#include <stdio.h>
#include <unistd.h>

long value;

int pfd[2];

void Produce(void)
{
	printf("Producer <%d/%d> is ready...\n", getpid(), getppid());
	value = DoWork(0);
	write(pfd[1], &value, sizeof(value));
}

void Consume(void)
{
	printf("Consumer <%d/%d> is ready...\n", getpid(), getppid());
	read(pfd[0], &value, sizeof(value));
	printf("Processed value is %ld\n", value * value);
}

int main(void)
{
	pid_t child;

	pipe(pfd);

	child = fork();

	if(child == 0)
		Consume();
	else
	{
		Produce();
		waitpid(child, NULL, 0);
	}

	close(pfd[1]);
	close(pfd[0]);
}

