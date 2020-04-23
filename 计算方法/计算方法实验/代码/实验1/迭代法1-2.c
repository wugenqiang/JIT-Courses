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
    printf("请输入x0、N及预先给定的精度c：");
    scanf("%lf,%d,%lf",&x0,&N,&c);
    while(i<N)
    {
        x1=f(x0);
        if(fabs(x1-x0)<c)
            printf("满足精度要求的根x=%lf",x1);
        else
        {
            x0=x1;
            i=i+1;
        }
    }
    if(i==N)
        printf("n次迭代后不符合要求");
    return 0;
}
