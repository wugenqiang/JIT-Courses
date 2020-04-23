#include <stdio.h>
main()
{
    int a=0,b=1,c,s,i;
    printf("请输入一个整数：\n");
    scanf("%d",&s);
    for(i=0;;i++)
    {
        c=a+b;
        a=b+c;
        b=a+c;
        if(c>s)
            {
               printf("%d\n",c);break;
            }
        if(a>s)
            {
                printf("%d\n",a);break;
            }
        if(b>s)
            {
                printf("%d\n",b);
            }
    }
}
