#include <stdio.h>
#define N 8
main()
{
	int a[N];
	int i,j;
	for(i=0;i<N;i++)
	{	
		for(j=i;j>=0;j--)
			if(i==j||j==0)a[j]=1;
			else
		    a[j]=a[j]+a[j-1];
		for(j=0;j<=i;j++)
	        printf("%4d",a[j]);
		printf("\n");
	}
}