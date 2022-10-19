int ProcessBuffer(char buffer[], int n)
{
		register int i;

		for(i = 0; i < n; ++i)
		{
			if(buffer[i] != ' ')
				buffer[i] ^= '#';
		}

		return i;
}

