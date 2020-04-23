#include <stdio.h>
float fun(int n)
{
    int i;
    float sum=0,a=2.0,b=1.0;
    for(i=1;i<=n;i++)
        {
            sum+=a/b;
            a=a+b;
            b=a-b;
        }
    return (sum);
}
int main()
{
    float sum;
    int n;
    printf("please enter an integer:\n");
    scanf("%d",&n);
    sum=fun(n);
    printf("%f\n",sum);
}
