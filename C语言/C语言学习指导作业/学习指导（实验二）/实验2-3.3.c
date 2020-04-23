#include <stdio.h>
#define N 4
void fun(int n,int a[])
{
    int i;
    for (i=N-1;i>=0;i--)
        {
            a[i]=n%10;
            n=n/10;
        }
}
void main()
{
    int x,i,a[N];
    printf("please enter an integer having four numbers:\n");
    scanf("%d",&x);
    fun(x,a);
    for(i=0;i<N;i++)
      printf("%2d",a[i]);
}
