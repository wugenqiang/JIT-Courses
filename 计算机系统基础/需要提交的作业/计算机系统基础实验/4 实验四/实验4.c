#include <stdio.h>
#define N 10
struct
{
    int s[N];
    char m;
}t;
void main()
{
    int n,i,j=0;
    printf("Please enter n:\n");
    for(i=0;i<N;i++)
    {
        scanf("%d",&n);
        if(n<10&&n>5)
            t.s[j++]=n;
    }
    for(i=0;i<j;i++)
        printf("t.s[%d]=%2d ",i,t.s[i]);
}
