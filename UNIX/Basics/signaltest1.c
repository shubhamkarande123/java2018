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

void Run()
{
	long list[] = {111, 222, 333, 444, 555, 666, 777, 888};
	long value;
	register int i;

	for(i = 0; i < 3; ++i)
	{
		printf("Enter value: ");
		scanf("%ld", &value);

		printf("Result = %ld\n", 2520 / value);
		printf("Entry = %ld\n", list[value]);
	}

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


