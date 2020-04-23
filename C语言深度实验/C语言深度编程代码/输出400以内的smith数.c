#include <stdio.h>
int main()
{
	int n,m;
	printf("please output smith(<=400):\n");
	for(n=2;n<=400;n++)
	{
		int k=2,sum_1=0,sum_2=0,i,t;
		int loc=0;
		t=n;
		m=n;
		 while(k <t) 
	        {
	          if( t % k == 0) 
	            { 
				    loc=1;
					i=k;
				    t = t / k;
                    while(i!=0)
					{
						sum_1+=i%10;
						i/=10;
					}
	            } 
	          else    k++;
	        }
		 while(loc==1&&t!=0)
		 {
		    sum_1+=t%10;
			t/=10;
		 }
		 while(m!=0)
		 {
			 sum_2+=m%10;
			 m/=10;
		 }
		 if(sum_1==sum_2)
			 printf("%4d",n);

	}printf("\n");
}
