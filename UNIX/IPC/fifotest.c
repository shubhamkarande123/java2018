#include <stdio.h>
#include <string.h>
#include <unistd.h>
#include <fcntl.h>
#include <sys/mman.h>

#define FIFONAME "/tmp/testfifo"
#define BUFSZ 80

int RunWriter(const char* text)
{
	int fd;
	char* buffer;

	fd = open(FIFONAME, O_WRONLY, 0664);
	if(fd == -1)
		return puts("ERROR: Cannot create write to FIFO.");

	write(fd, text, BUFSZ);
	
	close(fd);
}

int RunReader()
{
	int fd;
	char buffer[BUFSZ];

	fd = open(FIFONAME, O_RDONLY, 0);
	if(fd == -1)
		return puts("ERROR: Cannot read from FIFO.");
	
	read(fd, buffer, BUFSZ);
	printf("Text = %s\n", buffer);
	
	close(fd);
}

int main(int argc, char* argv[])
{
	mkfifo(FIFONAME, 0644);

	if(argc > 1)
		RunWriter(argv[1]);
	else
		RunReader();
}


