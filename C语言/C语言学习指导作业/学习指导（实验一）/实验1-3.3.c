#include <stdio.h>
main()
{
    double x,y;
    printf("please enter x:\n");
    scanf("%lf",&x);
    if(x<0&&x!=-3)
            y=x*x+x+6;
    else if(x>=0&&x<10&&x!=2&&x!=3)
            y=x*x-5*x+6;
        else
            y=x*x-x-1;
    printf("%lf",y);
}
