#include <stdio.h>
main()
{
    int x,m,a,b,c;
    printf("������һ��3λ����\n");
    scanf("%d",&x);
    a=x%10;
    b=x/100;
    c=x%100/10;
    m=a*a*a+b*b*b+c*c*c;
    if(m==x)
        printf("%dΪˮ�ɻ���",x);
    else if(m!=x)
        printf("%d����ˮ�ɻ���",x);
}
