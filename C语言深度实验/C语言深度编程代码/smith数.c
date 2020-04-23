#include <stdio.h>
void main() 
	{
		int s,i;
		printf("please enter a integer(s>2):\n");
		scanf("%d",&s);
        for(i=2;i<s;i++)
        {
        	if(sum(i)==prime_sum(i))
        		printf("%2d ",i);
        }printf("\n");
	}
	int prime(int n)
    {
		int i;
    	if(n<2)return 0;
    	for(i=2;i<=n/2;i++)
    		   if(n%i==0)return 0;
    		   return 1;	
    }
   int prime_sum(int n)
    {
    	int t=0,m=0,j,loc=0;
    	for(j=2;j<n;j++)
    	{
    		while(n%j==0&&prime(j)==1)
    		    {
				    loc=1;
					n=n/j;
    		    	m=j;
    				while(m!=0)
    			    {
    				   t+=m%10;
    				   m/=10;
    			    }
    		    }
    	}
		if(loc==1&&prime(n)==1)
		{
			while(n)
			{
			   t+=n%10;
		       n/=10;
			}
		}
		return t;
    }
   int sum(int n)
    {
	     int sum=0;
	     while(n!=0)
	     {
		    sum+=n%10;
		    n/=10;
	     }
	     return sum;
	}
