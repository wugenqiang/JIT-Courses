#include "stdio.h"
#define N 5//xi�ĸ���
double Lagrange(double x[],double y[],double xx,int n)
//xx:x���xֵ��n����ʾn���������ղ�ֵ
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
    double xx,yy;//xx:x���xֵ,yy:x���yֵ
    int i,n;
    printf("�����뺯������xi��ֵ��");
    for(i=0;i<N;i++)
        scanf("%lf",&x[i]);
    printf("\n�����뺯������yi��ֵ��");
    for(i=0;i<N;i++)
        scanf("%lf",&y[i]);
    while(1)
    {
        printf("\n���������ʽ��Ҫ��������ֵ�ĵ�x��ֵ:xx=");
        scanf("%lf",&xx);
        printf("\n��������Ҫ�����������ղ�ֵ�Ĵ���n��");
        scanf("%d",&n);
        if(n>=N||n<=0)
            return 1;
        yy=Lagrange(x,y,xx,n);
        printf("\n����%d���������ղ�ֵ��x=%lf���ĺ�������ֵΪy=%lf\n",n,xx,yy);
    }

    return 0;
}
