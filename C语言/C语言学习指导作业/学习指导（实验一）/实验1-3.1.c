#include <stdio.h>
main()
{
    double x;
    scanf("%lf",&x);
    printf("please enter x(x>0)\n");
    x=x*100+0.5;
    x=(int)x/100.0;
    printf("%lf\n",x);
}
