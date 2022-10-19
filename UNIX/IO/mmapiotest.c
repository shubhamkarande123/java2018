#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <sys/stat.h>
#include <sys/mman.h>

extern void ProcessBuffer(char[], int);

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

	buffer = mmap(NULL, n, PROT_READ | PROT_WRITE, MAP_SHARED, fd, 0);

	ProcessBuffer(buffer, n);

	munmap(buffer, n);
	close(fd);
}



