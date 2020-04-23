#include <stdio.h>
#include <math.h>
#define Max 10

void *LU(float a[Max][Max],int n,float b[])//����LU�ֽ�
{
   int i,j,k;
   float y[Max],L[Max][Max],U[Max][Max],x[Max];
   for(i=0;i<n;i++)
     U[i][i]=1;/*U����Խ�Ԫ�ظ�ֵΪ1*/
   for(k=0;k<n;k++)
  {
      for(i=k;i<n;i++)   /*����L����ĵ�k��Ԫ��*/
     {
         L[i][k]=a[i][k];
         for(j=0;j<k;j++)
           L[i][k]-=(L[i][j]*U[j][k]);
    }
     for(j=k;j<n;j++) /*����U����ĵ�k��Ԫ��*/
     {
         U[k][j]=a[k][j];
         for(i=0;i<k;i++)
           U[k][j]-=(L[k][i]*U[i][j]);
         U[k][j]/=L[k][k];
     }
   }

    for(i=0;i<n;i++)       /*����Ly=b�е�y*/
    {
        y[i]=b[i];
        for(j=0;j<i;j++)
           y[i]-=(L[i][j]*y[j]);
        y[i]/=L[i][i];
    }
    for(i=n-1;i>=0;i--)    /*����Ux=y�е�x*/
   {
       x[i]=y[i];
       for(j=n-1;j>=i+1;j--)
          x[i]-=(U[i][j]*x[j]);
       x[i]/=U[i][i];
   }
    printf("������Ľ�:\n");
    for(k=0;k<n;k++)
        printf("x[%d]=%f\n",k,x[k]);
}
int main()
{
    int n;
    int i,j,k;
    float a[Max][Max],b[Max],*x;
    printf("�������Է������ά��:");
    scanf("%d",&n);
    if(n>Max||n<=0)
        return 1;//������ά��nҪС��Max
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
