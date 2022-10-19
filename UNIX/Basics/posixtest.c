#include <stdio.h>
#include <unistd.h>

void End(void)
{
	puts("Goodbye User");
}

int main(int argc, char* argv[])
{
	register int i;

	puts("Welcome User.");
	atexit(End);

	for(i = 1; i < argc; ++i)
	{
		long t[] = {5, 0};

		usleep(5000000);

		puts(argv[i]);
	}
}

