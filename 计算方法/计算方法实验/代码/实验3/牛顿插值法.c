#include "stdio.h"
#define N 5//xi�ĸ���
void Difference(double x[],double y[],int n)
//xx:x���xֵ��n����ʾn��ţ�ٲ�ֵ
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
    double xx,yy;//xx:x���xֵ,yy:x���yֵ
    int i,n;
    printf("�����뺯������xi��ֵ��");
    for(i=0;i<N;i++)
        scanf("%lf",&x[i]);
    printf("\n�����뺯������yi��ֵ��");
    for(i=0;i<N;i++)
        scanf("%lf",&y[i]);
    printf("\n���������ʽ��Ҫ��������ֵ�ĵ�x��ֵ:xx=");
    scanf("%lf",&xx);
    printf("\n��������Ҫ����ţ�ٲ�ֵ�Ĵ���n��");
    scanf("%d",&n);
    if(n>=N||n<=0)
        return 1;
    Difference(x,y,n);
    for(i=n-1;i>=0;i--)
        yy=yy*(xx-x[i])+y[i];
    printf("\n����%d��ţ�ٲ�ֵ��x=%lf���ĺ�������ֵΪy=%lf\n",n,xx,yy);
    return 0;
}
