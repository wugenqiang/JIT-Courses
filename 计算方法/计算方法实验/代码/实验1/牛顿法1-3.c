#include "stdio.h"
#include "math.h"
double f(double x)
{
    double sum;
    sum=x*x*x-0.2*x*x-0.2*x-1.2;
    return sum;
}
double f1(double x)
{
    double sum1;
    sum1=3*x*x-0.4*x-0.2;
    return sum1;
}

int main()
{
    double x0,c,x1;
    int N=0,i=1;
    printf("������x0��N��Ԥ�ȸ����ľ���c��");
    scanf("%lf,%d,%lf",&x0,&N,&c);
    while(f1(x0)!=0&&fabs(x1-x0)>c&&i<N)
    {
        x0=x1;
        x1=x0-f(x0)/f1(x0);
        i++;
    }
    if(fabs(x1-x0)<=c)
        printf("���㾫��Ҫ��ĸ�x=%lf",x1);
    if(i==N)
        printf("������Ҫ��");
    if(f1(x0)==0)
        printf("x=%lf",x0);
    return 0;
}
