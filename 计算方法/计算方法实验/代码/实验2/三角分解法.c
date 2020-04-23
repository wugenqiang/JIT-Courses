#include <stdio.h>
#include <math.h>
#define Max 10

void *LU(float a[Max][Max],int n,float b[])//进行LU分解
{
   int i,j,k;
   float y[Max],L[Max][Max],U[Max][Max],x[Max];
   for(i=0;i<n;i++)
     U[i][i]=1;/*U矩阵对角元素赋值为1*/
   for(k=0;k<n;k++)
  {
      for(i=k;i<n;i++)   /*计算L矩阵的第k列元素*/
     {
         L[i][k]=a[i][k];
         for(j=0;j<k;j++)
           L[i][k]-=(L[i][j]*U[j][k]);
    }
     for(j=k;j<n;j++) /*计算U矩阵的第k行元素*/
     {
         U[k][j]=a[k][j];
         for(i=0;i<k;i++)
           U[k][j]-=(L[k][i]*U[i][j]);
         U[k][j]/=L[k][k];
     }
   }

    for(i=0;i<n;i++)       /*计算Ly=b中的y*/
    {
        y[i]=b[i];
        for(j=0;j<i;j++)
           y[i]-=(L[i][j]*y[j]);
        y[i]/=L[i][i];
    }
    for(i=n-1;i>=0;i--)    /*计算Ux=y中的x*/
   {
       x[i]=y[i];
       for(j=n-1;j>=i+1;j--)
          x[i]-=(U[i][j]*x[j]);
       x[i]/=U[i][i];
   }
    printf("方程组的解:\n");
    for(k=0;k<n;k++)
        printf("x[%d]=%f\n",k,x[k]);
}
int main()
{
    int n;
    int i,j,k;
    float a[Max][Max],b[Max],*x;
    printf("输入线性方程组的维数:");
    scanf("%d",&n);
    if(n>Max||n<=0)
        return 1;//错误处理，维度n要小于Max
   printf("Input the A(i,j):\n");
   for(i=0;i<n;i++)
     for(j=0;j<n;j++)
       scanf("%f",&a[i][j]);
    printf("Input b(i):\n");
    for(i=0;i<n;i++)
        scanf("%f",&b[i]);
    LU(a,n,b);

    return 0;
}
