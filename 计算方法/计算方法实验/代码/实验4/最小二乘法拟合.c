#include <stdio.h>
#include <math.h>
#define Max 25  /*最大数据点的个数*/
#define M 3  /*正规方程组的阶数*/
/*列主元高斯消去法求解线性方程组*/
void ColPivot(double A[M][M],double B[],int n)
{
    int i,j,k,m_i;
    float m_x,temp;
    for(i=0;i<n-1;i++)
    { /*列主元*/
        j=i+1; m_i=i; m_x=fabs(A[i][i]);
        for(;j<n;j++)
          if(fabs(A[j][i]>m_x))  /*找主元素*/
          {
              m_i=j;
              m_x=fabs(A[j][i]);
          }
          if(i<m_i)             /*交换两行*/
          {
              temp=B[i]; B[i]=B[m_i]; B[m_i]=temp;
              for(j=i;j<n;j++)
              {
                  temp=A[i][j];
                  A[i][j]=A[m_i][j];
                  A[m_i][j]=temp;
              }
          }
         /*消元*/
         for(j=i+1;j<M;j++)
        {
            temp=-A[j][i]/A[i][i];
            B[j]+=B[i]*temp;
           for(k=i;k<M;k++)
           A[j][k]+=A[i][k]*temp;
        }
    }
}

int main()
{
    int i,j,k,n;
    double x[Max],y[Max],b[M],a[M][M],c[M];
    printf("\nPlease input n value:"); /*输入点数n*/
    do
    {
        scanf("%d",&n);
        if(n>Max)
            printf("\nplease re-input n value:");
    }while(n>Max||n<=0);
    printf("Input x[i],i=0,...%d:\n",n-1);
    for(i=0;i<n;i++)
        scanf("%lf",&x[i]);
    printf("Input y[i],i=0,...%d:\n",n-1);
    for(i=0;i<n;i++)
        scanf("%lf",&y[i]);
    for(i=0;i<M;i++) /*构造正规方程组*/
    {
        for(j=0;j<M;j++)
        {
            a[i][j]=0;
            b[i]=0;
            for(k=0;k<n;k++)
           {
               a[i][j]=a[i][j]+pow(x[k],i+j);
               b[i]=b[i]+pow(x[k],i)*y[k];
           }
        }
    }
    ColPivot(a,b,M);  /*调用列主元消去法函数计算方程组的解*/
    c[M-1]=b[M-1]/a[M-1][M-1];   /*解方程*/
    for(i=M-2;i>=0;i--)
     {
         c[i]=b[i];
         for(j=i+1;j<M;j++)
            c[i]-=a[i][j]*c[j];
         c[i]/=a[i][i];
     }
    printf("Solve is :\n");  /*输出方程组的解*/
    for(i=0;i<M;i++)
        printf("c[%d]=%lf\n",i,c[i]);
    printf("Result：y=%lf+%lfx+%lfx2",c[0],c[1],c[2]);
    getch();
    return 0;
 }
