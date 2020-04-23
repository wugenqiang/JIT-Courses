#include <stdio.h>
#define N 10
void fun(char s[])
{int i,len;
    len=strlen(s);
    for(i=len-1;i>0;i--)
     {  s[2*i]=s[i];
        s[2*i-1]=' ';
     }
    len=strlen(s);
    s[len]='\0';
}
int main()
{
    char a[N];
    printf("请输入由四个数字组成的字符串：\n");
    gets(a);
    fun(a);
    puts(a);
}
