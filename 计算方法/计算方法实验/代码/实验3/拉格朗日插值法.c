#include "stdio.h"
#define N 5//xi的个数
double Lagrange(double x[],double y[],double xx,int n)
//xx:x点的x值，n：表示n次拉格朗日插值
{
    int i,j;
    double f[N],yy=0;
    for(i=0;i<n;i++)
    {
        f[i]=y[i];
        for(j=0;j<n;j++)
            if(j!=i)
                f[i]*=(xx-x[j])/(x[i]-x[j]);
        yy+=f[i];
    }
    return yy;
}
int main()
{
    double x[N],y[N];
    double xx,yy;//xx:x点的x值,yy:x点的y值
    int i,n;
    printf("请输入函数表中xi的值：");
    for(i=0;i<N;i++)
        scanf("%lf",&x[i]);
    printf("\n请输入函数表中yi的值：");
    for(i=0;i<N;i++)
        scanf("%lf",&y[i]);
    while(1)
    {
        printf("\n请输入多项式中要求函数近似值的点x的值:xx=");
        scanf("%lf",&xx);
        printf("\n请输入需要进行拉格朗日插值的次数n：");
        scanf("%d",&n);
        if(n>=N||n<=0)
            return 1;
        yy=Lagrange(x,y,xx,n);
        printf("\n经过%d次拉格朗日插值后x=%lf处的函数近似值为y=%lf\n",n,xx,yy);
    }

    return 0;
}
