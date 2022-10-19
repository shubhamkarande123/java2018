#include <time.h>

int DoWork(int count)
{
	clock_t t = clock() + count * CLOCKS_PER_SEC;

	if(count <= 0)
		count = time(NULL) % 10 + 1;

	while(clock() < t);

	return count;
}
