int ProcessBuffer(char buffer[], int n)
{
		register int i, j;

		for(i = 0, j = n - 1; i < j; ++i, --j)
		{
			char ib = buffer[i];
			char jb = buffer[j];

			buffer[i] = jb;
			buffer[j] = ib;
		}

		return i;
}

