#include "stdio.h"
#define N 5//xi的个数
void Difference(double x[],double y[],int n)
//xx:x点的x值，n：表示n次牛顿插值
{
    int i,j;
    double f[N];
    for(i=1;i<=n;i++)
    {
        f[0]=y[i];
        for(j=0;j<i;j++)
            if(j!=i)
                f[j+1]=(f[j]-y[j])/(x[i]-x[j]);
        y[i]=f[i];
    }
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
    printf("\n请输入多项式中要求函数近似值的点x的值:xx=");
    scanf("%lf",&xx);
    printf("\n请输入需要进行牛顿插值的次数n：");
    scanf("%d",&n);
    if(n>=N||n<=0)
        return 1;
    Difference(x,y,n);
    for(i=n-1;i>=0;i--)
        yy=yy*(xx-x[i])+y[i];
    printf("\n经过%d次牛顿插值后x=%lf处的函数近似值为y=%lf\n",n,xx,yy);
    return 0;
}
