#include "stdio.h"
#include "math.h"
double f(double x)
{
    double sum;
    sum=x*x*x-0.2*x*x-0.2*x-1.2;
    return sum;
}

int main()
{
    double x0,c,x1;
    int N=0,i=1;
    printf("������x0��N��Ԥ�ȸ����ľ���c��");
    scanf("%lf,%d,%lf",&x0,&N,&c);
    while(i<N)
    {
        x1=f(x0);
        if(fabs(x1-x0)<c)
            printf("���㾫��Ҫ��ĸ�x=%lf",x1);
        else
        {
            x0=x1;
            i=i+1;
        }
    }
    if(i==N)
        printf("n�ε����󲻷���Ҫ��");
    return 0;
}
