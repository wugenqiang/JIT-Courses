#include <stdio.h>
#define N 3
void fun(int a[][N],int n)
{
    int i,j;
    for (i=0;i<N;i++)
    for(j=0;j<N;j++)
        if(i>=j)
           a[i][j]=n*a[i][j];
}
int main()
{
    int a[N][N],i,j;
    printf("please enter an array(N*N):\n");
    for(i=0;i<N;i++)
    for(j=0;j<N;j++)
           scanf("%d",&a[i][j]);
    int n;
    printf("please enter n:\n");
    scanf("%d",&n);
    fun(a,n);
    for(i=0;i<N;i++)
      {
          for(j=0;j<N;j++)
          {
              printf("%4d",a[i][j]);
          }
           printf("\n");
      }
}
