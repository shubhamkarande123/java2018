#include <stdio.h>
#include <unistd.h>
#include <signal.h>
#include <stdlib.h>

void End(void)
{
	puts("Goodbye.");
}

void MainHandler(int signo)
{
	switch(signo)
	{
	case SIGFPE:
		puts("ERROR: Division by zero.");
		break;		

	case SIGSEGV:
		puts("ERROR: Illegal memory operation.");
		break;

	case SIGINT:
		puts("ERROR: Program interrupted.");
		break;
	}

	exit(signo);
}

void RunHandler(int signo)
{
	switch(signo)
	{
	case SIGUSR1:
		puts("WARNING: Negatives not allowed!");
		break;
	}
}

void Run()
{
	long list[] = {111, 222, 333, 444, 555, 666, 777, 888};
	long value;
	register int i;

	struct sigaction act = {RunHandler};
	struct sigaction oact;

	sigaction(SIGUSR1, &act, &oact);

	for(i = 0; i < 3; ++i)
	{
		printf("Enter value: ");
		scanf("%ld", &value);

		if(value < 0)
		{
			raise(SIGUSR1);
			continue;
		}

		printf("Result = %ld\n", 2520 / value);
		printf("Entry = %ld\n", list[value]);
	}

	sigaction(SIGUSR1, &oact, NULL);
}

int main(void)
{
	struct sigaction act = {MainHandler};

	sigaction(SIGFPE, &act, NULL);
	sigaction(SIGSEGV, &act, NULL);
	sigaction(SIGINT, &act, NULL);

	puts("Welcome User.");
	atexit(End);

	Run();
}


