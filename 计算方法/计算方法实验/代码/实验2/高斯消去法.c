#include<stdio.h>
#include<math.h>
void main()
{
    int a[3][3]={{2,1,1},{1,3,2},{1,2,2}};
    int b[3]={4,6,5};
    int n=3;
    int i,j,k;
    float t,x[5];
    for(i=0;i<n;i++)//求第一列乘数
    {
        a[i][0]=a[i][0]/a[0][0];
    }
    for(k=0;k<=n-2;k++)
    {
        for(i=k+1;i<=n-1;i++)//按列求第k+1次消元矩阵
        {
            for(j=k+1;j<=n-1;j++)
            a[i][j]=a[i][j]-a[i][k]*a[k][j];
        }
        printf("输出第%d次消元矩阵A%d=\n",k+1,k+1);
        for(i=0;i<n;i++) //输出第k+1次消元矩阵
        {
            for(j=0;j<n;j++)
            printf("%3d ",a[i][j]);
            printf("\n");
        }
        printf("\n");
        for(i=k+1;i<=n-1;i++)//计算和输出第k+1次b的值
        b[i]=b[i]-a[i][k]*b[k];
        printf("输出第%d次矩阵b=\n",k+1);
        for(i=0;i<n;i++)
        printf("%3d ",b[i]);
        printf("\n");
        printf("\n");
        i=k+2;
        while(i<n)//计算下一列乘数
        {
            a[i][k+1]=a[i][k+1]/a[k+1][k+1];
            i++;
        }
    }
    for(i=n-1;i>=0;i--)
    {
        t=0;
        for(j=i+1;j<=n-1;j++)
        t=t+a[i][j]*x[j];
        x[i]=(b[i]-t)/a[i][i];
    }
    printf("高斯消去法得到x的值为：\n");
    for(i=0;i<=n-1;i++)
    printf("x[%d]=%f\n",i,x[i]);
}
