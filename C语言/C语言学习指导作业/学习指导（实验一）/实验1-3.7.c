#include <stdio.h>
main()
{
    long int s,f=0,n,i,t=0;
    printf("please enter some numbers:\n");
    scanf("%ld",&s);
    printf("所给数的位数n:\n");
    scanf("%ld",&n);
    for(i=1;i<=n;i++,i++)
        {
            f=10*f+s%10;
            s=s/100;
        }
    for(i=1;i<=(n+1)/2;i++)
    {
        t=10*t+f%10;
        f=f/10;
    }

    printf("t=%ld",t);
}
