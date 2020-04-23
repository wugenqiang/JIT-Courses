#include <stdio.h>
#include <math.h>
#define Max_N 10    /*���ά��*/
/*ֱ�����Ƿֽⷨ����*/
float *DirectLU(float a[Max_N][Max_N],float b[],int n)
{int i,j,k;
  float y[Max_N],L[Max_N][Max_N],U[Max_N][Max_N],x[Max_N];
 /*U����Խ�Ԫ�ظ�ֵΪ1*/
  for(i=0;i<n;i++)   U[i][i]=1;
  for(k=0;k<n;k++)
  { for(i=k;i<n;i++)   /*����L����ĵ�k��Ԫ��*/
    { L[i][k]=a[i][k];
      for(j=0;j<=k-1;j++)
       L[i][k]-=(L[i][j]*U[j][k]);
     }
    for(j=k+1;j<n;j++) /*����U����ĵ�k��Ԫ��*/
    { U[k][j]=a[k][j];
      for(i=0;i<=k-1;i++)
       U[k][j]-=(L[k][i]*U[i][j]);
      U[k][j]/=L[k][k];
     }
   }
  for(i=0;i<n;i++)       /*����Ly=b�е�y*/
  {y[i]=b[i];
   for(j=0;j<=i-1;j++)
    y[i]-=(L[i][j]*y[j]);
   y[i]/=L[i][i];
   }
  for(i=n-1;i>=0;i--)    /*����Ux=y�е�x*/
  {x[i]=y[i];
   for(j=i+1;j<n;j++)
    x[i]-=(U[i][j]*x[j]);
   }
 return(x);
}
main()   /*������*/
{ int i,j,k,n;
  float temp;
  float a[Max_N][Max_N],b[Max_N],*x;
  printf("\nPlease input n value(dim of Ax=b):"); /*�������ά��*/
  do
  { scanf("%d",&n);
    if(n>Max_N)
    printf("\nplease re-input n value:");
   }
  while(n>Max_N||n<=0);
  /*����Ax=b��A����*/
  printf("Input the A(i,j):\n");
  for(i=0;i<n;i++)
    for(j=0;j<n;j++)
     scanf("%f",&a[i][j]);
  /*����b����*/
  printf("Input b(i):\n");
  for(i=0;i<n;i++)  scanf("%f",&b[i]);
   x=DirectLU(a,b,n);  /*����ֱ�����Ƿֽⷨ����*/
  printf("Solve is :");  /*���������Ľ�*/
   for(i=0;i<n;i++)
    {printf("x[%d]=%f",i,x[i]);
     if(i%2==0)
      printf("\n");
     }
}
