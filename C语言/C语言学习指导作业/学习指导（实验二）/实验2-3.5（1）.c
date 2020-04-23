#include <stdio.h>
#define N 3
int fun(int a[][N],int n)
{
    int i,j;
    for(i=0;i<N;i++)
    {
        for(j=0;j<N;j++)
        {
            if(i>=j)
            a[i][j]=n*a[i][j];
        }

    }
    return a[i][j];

}
int main()
{
    int n=3,i,j,a[N][N];
    for(i=0;i<N;i++)
    for(j=0;j<N;j++)
    scanf("%d",&a[i][j]);
    fun(a,n);

    for(i=0;i<N;i++)
    {for(j=0;j<N;j++)

    printf("%4d",a[i][j]);


    printf("\n");
    }
}
