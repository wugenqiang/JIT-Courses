#include <stdio.h>
#include <math.h>
main()
{
    int n,i,j;
    double s=0;
    printf("���������2��һ��������\n");
    scanf("%d",&n);
    for(j=3;j<=n;j++)
       {
           for(i=2;i<j;i++)
       {
           if(j%i==0)
            break;
       }
            if(j==i)
            s+=sqrt(j);
       }
        printf("s=%lf",s);
}






