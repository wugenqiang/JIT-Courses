#include <stdio.h>
main()
{
    char x;
    printf("please input a capital letter\n");
    scanf("%c",&x);
    x=x+32;
    printf("%c",x);
}
