#include <stdio.h>
#define M 5
int fun(int a[M][M])
{
    int sum=0,i,j;
    for(i=0;i<M;i++)
    for(j=0;j<M;j++)
    {
        if(i==j||i==M-1-j)
        sum+=a[i][j];
    }
      return (sum);
}
int main()
{
    int a[M][M],i,j;
    printf("please enter 5*5 array:\n");
    for(i=0;i<M;i++)
    {for(j=0;j<M;j++)
         scanf("%d",&a[i][j]);}
    fun(a);
    printf("%d\n",fun(a));
}
