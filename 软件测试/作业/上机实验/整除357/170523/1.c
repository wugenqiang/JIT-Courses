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
                printf("��3,5,7��������");
           if(x%15==0&&x%105!=0)
                printf("��3,5����");
           if(x%35==0&&x%105!=0)
                printf("��5,7����");
           if(x%21==0&&x%105!=0)
                printf("��3,7����");
          if(x%3==0&&x%5!=0&&x%7!=0)
                printf("��3����");
          if(x%3!=0&&x%5==0&&x%7!=0)
                printf("��5����");
          if(x%3!=0&&x%5!=0&&x%7==0)
                printf("��7����");
          if(x%3!=0&&x%5!=0&&x%7!=0)
                printf("���ܱ�3,5,7��һ����");
        }
    return 0;
}
