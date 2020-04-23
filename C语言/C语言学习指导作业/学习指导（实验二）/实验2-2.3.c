#include "stdio.h"
#include "conio.h"
main()
{
  int i,j,max,s,t;
 int a[2][3]={{1,34,23},{56,345,7}};
    max=0;
    t=0;
    s=0;
    for(i=0;i<2;i++)
    for(j=0;j<3;j++)
       if(a[i][j]>max)
        {
            max=a[i][j];
            s=i;
            t=j;
        }
    printf("%d,%d,max=%d\n",s,t,max);
}
