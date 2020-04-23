#include "stdio.h"
int main()
{
    int x;
    printf("please enter a number(0~500)\n");
    scanf("%d",&x);
    if(x<0||x>500)
        printf("ERROR,x<0 or x>500");
    else
        {
           if(x%3==0&&x%5==0&&x%7==0)
                printf("被3,5,7三者整除");
           if(x%15==0&&x%105!=0)
                printf("被3,5整除");
           if(x%35==0&&x%105!=0)
                printf("被5,7整除");
           if(x%21==0&&x%105!=0)
                printf("被3,7整除");
          if(x%3==0&&x%5!=0&&x%7!=0)
                printf("被3整除");
          if(x%3!=0&&x%5==0&&x%7!=0)
                printf("被5整除");
          if(x%3!=0&&x%5!=0&&x%7==0)
                printf("被7整除");
          if(x%3!=0&&x%5!=0&&x%7!=0)
                printf("不能被3,5,7任一整除");
        }
    return 0;
}
