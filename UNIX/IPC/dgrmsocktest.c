#include <stdio.h>
#include <string.h>
#include <unistd.h>
#include <sys/socket.h>
#include <sys/un.h>

#define SOCKPATH "/tmp/testdgrmsock"
#define BUFSZ 80

int RunServer(void)
{
	int server = socket(AF_UNIX, SOCK_DGRAM, 0);
	struct sockaddr_un local = {AF_UNIX, SOCKPATH};
	int status = bind(server, (struct sockaddr*) &local, sizeof(local));

	if(status == -1)
		return puts("ERROR: Bind failure");

	for(;;)
	{
		struct sockaddr_un remote = {AF_UNIX};

		char buffer[BUFSZ];
		int m = sizeof(remote);

		int n = recvfrom(server, buffer, BUFSZ, 0, (struct sockaddr*) &remote, &m);
		ProcessBuffer(buffer, n);
		sendto(server, buffer, n, 0, (struct sockaddr*) &remote, m);

	}
}

int RunClient(const char* text)
{
	struct sockaddr_un remote = {AF_UNIX, SOCKPATH};
	int n = strlen(text);

	int client = socket(AF_UNIX, SOCK_DGRAM, 0);
	struct sockaddr_un local = {AF_UNIX};
	bind(client, (struct sockaddr*) &local, sizeof(local));

	n = sendto(client, text, n, 0, (struct sockaddr*) &remote, sizeof(remote));
	if(n > 0)
	{
		char buffer[BUFSZ] = "";
		n = recv(client, buffer, BUFSZ - 1, 0);
		if(n > 0)
			printf("Response : %s\n", buffer);
		else
			puts("ERROR: Communication failure");			
	}
	else
		puts("ERROR: Communication failure");

	close(client);

}

int main(int argc, char* argv[])
{
	if(argc == 1)
	{
		unlink(SOCKPATH);
		RunServer();
	}
	else
		RunClient(argv[1]);
}

