#include <stdio.h>
main()
{
    int n,i,t=1;
    double s=1.000000;
    printf("please enter n:\n");
    scanf("%d",&n);
    if(n>1&&n<=100)
     {
        for(i=1;i<=n;i++)
          {
            t*=i;
            s+=1.0/t;
          }
        printf("s=%lf\n",s);
     }
    else
        printf("please enter right numbers(1<n&&n<=100)\n");
}
