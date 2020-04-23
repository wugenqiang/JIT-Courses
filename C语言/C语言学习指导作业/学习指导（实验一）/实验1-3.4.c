#include <stdio.h>
main()
{
    int x,t;
    printf("please enter a integer:\n");
    scanf("%d",&x);
    t=(x*x-x)%10;
    while(t==0)
        return(1);
    return(0);
}
