#include "stdio.h"
#include "math.h"
double f(double x)
{
    double sum;
    sum=x*x*x-0.2*x*x-0.2*x-1.2;
    return sum;
}
double judge(double a,double b,double c)
{
    double x;
    x=(a+b)/2;
    while(fabs(b-a)>=c)
    {
        double flag=f(x)*f(b);
        if(flag<0)
           a=x;
        else
           b=x;
        x=(a+b)/2;
    }
    return x;
}
int main()
{
    double a,b,c,x=0.0;
    printf("�������и�����a��b��Ԥ�ȸ����ľ���c��");
    scanf("%lf,%lf,%lf",&a,&b,&c);
    x=judge(a,b,c);
    printf("���㾫��Ҫ��ĸ�x=%lf",x);
    return 0;
}
