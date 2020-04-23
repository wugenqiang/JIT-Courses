#include <stdio.h>
main()
{
    int n,i,sum=0,t;
    printf("please enter a positive integer:\n");
    scanf("%d",&n);
    for(i=2;i<n;i++)
       {
            t=n%i;
        if(t==0)
            sum+=i;
       }
    printf("sum=%d",sum);
}
