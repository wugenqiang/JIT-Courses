#include <stdio.h>
main()
{
    int x,m,a,b,c;
    printf("请输入一个3位数：\n");
    scanf("%d",&x);
    a=x%10;
    b=x/100;
    c=x%100/10;
    m=a*a*a+b*b*b+c*c*c;
    if(m==x)
        printf("%d为水仙花数",x);
    else if(m!=x)
        printf("%d不是水仙花数",x);
}
