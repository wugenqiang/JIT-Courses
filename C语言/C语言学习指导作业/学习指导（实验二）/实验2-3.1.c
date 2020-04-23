#include <stdio.h>
float fun(int n)
{
    int i;
    float sum=0,m=1.0;
    for(i=1;i<=n;i++)
        {
            m=1.0/m+1;
            sum+=m;
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
