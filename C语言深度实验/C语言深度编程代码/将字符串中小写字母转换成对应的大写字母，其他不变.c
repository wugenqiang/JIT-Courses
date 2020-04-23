#include <stdio.h>
#include <string.h>
char *fun(char tt[])
{
	int i;
	for(i=0;tt[i]!='\0';i++)
		if((tt[i]>='a')&&(tt[i]<='z'))
			tt[i]-=32;
	return (tt);
}
main()
{
	char tt[81];
	printf("\nPlease enter astring:");
	gets(tt);
	printf("\nThe result string is:\n%s",fun(tt));
}