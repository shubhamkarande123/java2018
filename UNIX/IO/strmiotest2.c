#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <sys/stat.h>

extern int ProcessBuffer(char[], int);

int main(int argc, char* argv[])
{
	int fd;
	int n;
	char* buffer;
	struct stat fs;

	if(argc < 2)
		return printf("USAGE: %s file-to-encrypt\n", argv[0]);

	fd = open(argv[1], O_RDWR, 0);

	if(fd == -1)
		return printf("ERROR: Cannot open %s\n", argv[1]);

	fstat(fd, &fs);
	n = fs.st_size;

	buffer = malloc(n);

	read(fd, buffer, n);
	ProcessBuffer(buffer, n);
	pwrite(fd, buffer, n, 0);

	free(buffer);
	close(fd);
}



