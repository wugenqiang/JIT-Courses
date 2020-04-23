#include <stdio.h>
#define M 2
#define N 2
void fun(int tt[M][N],int pp[N])
{
    int i,j;
    for(j=0;j<N;j++)
    {
        pp[j]=tt[0][j];
        for (i=0;i<M;i++)
     {
        if(tt[i][j]<pp[j])
        pp[j]=tt[i][j];
     }
    }
}
int main()
{
    int a[M][N],b[N];
    int i,j,t;
    printf("请输入二维数组M*N：\n");
    for (i=0;i<M;i++)
    for (j=0;j<N;j++)
        {scanf("%d",&a[i][j]);}
    fun(a,b);
    for(j=0;j<N;j++)
         printf("%2d",b[j]);
}
