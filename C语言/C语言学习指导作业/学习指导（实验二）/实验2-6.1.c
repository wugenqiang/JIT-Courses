#include <stdio.h>
#include <math.h>
    float fun()
{
   float x1=0.0,x0;
   do
     {
      x0=x1;
      x1=cos(x0);
     }
   while(fabs(x0-x1)>=1e-6);
     return (x1);
}

int main()
{
    float x1;
    fun(x1);
    printf("Root=%f",fun(x1));
}
