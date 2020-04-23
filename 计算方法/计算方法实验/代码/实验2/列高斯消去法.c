#include <stdio.h>
#include <math.h>
#define Max 10
void ColPivot(float a[Max][Max],float b[],int n)//列主元高斯
{
    int i,j,k,m_i;
    float m_x,temp;
    for(i=0;i<n-1;i++)
    {
       j=i+1; m_i=i; m_x=fabs(a[i][i]);
       for(;j<n;j++)
          if(fabs(a[j][i]>m_x))  /*找主元素*/
          {
              m_i=j;
              m_x=fabs(a[j][i]);
          }
       if(i<m_i)             /*交换两行*/
       {
           temp=b[i];
           b[i]=b[m_i];
           b[m_i]=temp;
           for(j=i;j<n;j++)
           {
               temp=a[i][j];
               a[i][j]=a[m_i][j];
               a[m_i][j]=temp;
            }
     }
      /*消元*/
     for(j=i+1;j<n;j++)
     {
          temp=-a[j][i]/a[i][i];
          b[j]+=b[i]*temp;
          for(k=i;k<n;k++)
             a[j][k]+=a[i][k]*temp;
     }
   }
}
int main()
{
    int i,j,k,n;
    float a[Max][Max],b[Max],x[Max];
    printf("请输入矩阵维数n：");
    scanf("%d",&n);
    if(n>Max||n<=0)
      return 1;
    printf("Input the A(i,j):\n");
    for(i=0;i<n;i++)
      for(j=0;j<n;j++)
        scanf("%f",&a[i][j]);
    printf("Input b(i):\n");
    for(i=0;i<n;i++)
       scanf("%f",&b[i]);
    ColPivot(a,b,n);
    x[n-1]=b[n-1]/a[n-1][n-1];   /*解方程*/
    for(i=n-2;i>=0;i--)
    {
        x[i]=b[i];
        for(j=i+1;j<n;j++)
        x[i]-=a[i][j]*x[j];
        x[i]/=a[i][i];
    }
    printf("方程组的解:\n");
    for(i=0;i<n;i++)
        printf("x[%d]=%f\n",i,x[i]);
    return 0;
}
