#include <stdio.h>
#include <math.h>
#define Max_N 10    /*最大维数*/
/*直接三角分解法函数*/
float *DirectLU(float a[Max_N][Max_N],float b[],int n)
{int i,j,k;
  float y[Max_N],L[Max_N][Max_N],U[Max_N][Max_N],x[Max_N];
 /*U矩阵对角元素赋值为1*/
  for(i=0;i<n;i++)   U[i][i]=1;
  for(k=0;k<n;k++)
  { for(i=k;i<n;i++)   /*计算L矩阵的第k列元素*/
    { L[i][k]=a[i][k];
      for(j=0;j<=k-1;j++)
       L[i][k]-=(L[i][j]*U[j][k]);
     }
    for(j=k+1;j<n;j++) /*计算U矩阵的第k行元素*/
    { U[k][j]=a[k][j];
      for(i=0;i<=k-1;i++)
       U[k][j]-=(L[k][i]*U[i][j]);
      U[k][j]/=L[k][k];
     }
   }
  for(i=0;i<n;i++)       /*计算Ly=b中的y*/
  {y[i]=b[i];
   for(j=0;j<=i-1;j++)
    y[i]-=(L[i][j]*y[j]);
   y[i]/=L[i][i];
   }
  for(i=n-1;i>=0;i--)    /*计算Ux=y中的x*/
  {x[i]=y[i];
   for(j=i+1;j<n;j++)
    x[i]-=(U[i][j]*x[j]);
   }
 return(x);
}
main()   /*主函数*/
{ int i,j,k,n;
  float temp;
  float a[Max_N][Max_N],b[Max_N],*x;
  printf("\nPlease input n value(dim of Ax=b):"); /*输入矩阵维数*/
  do
  { scanf("%d",&n);
    if(n>Max_N)
    printf("\nplease re-input n value:");
   }
  while(n>Max_N||n<=0);
  /*输入Ax=b的A矩阵*/
  printf("Input the A(i,j):\n");
  for(i=0;i<n;i++)
    for(j=0;j<n;j++)
     scanf("%f",&a[i][j]);
  /*输入b矩阵*/
  printf("Input b(i):\n");
  for(i=0;i<n;i++)  scanf("%f",&b[i]);
   x=DirectLU(a,b,n);  /*调用直接三角分解法函数*/
  printf("Solve is :");  /*输出方程组的解*/
   for(i=0;i<n;i++)
    {printf("x[%d]=%f",i,x[i]);
     if(i%2==0)
      printf("\n");
     }
}
