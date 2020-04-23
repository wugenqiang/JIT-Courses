#include <stdio.h>
#define N 10
void fun(char s[])
{
    char b[N];
    int i,j=0;
    for(i=0;s[i]!='\0';i++)
       {
           b[j]=s[i];
           printf("%c",b[j]);
           j++;b[j]=' ';
           printf("%c",b[j]);
           j++;
       }
}
int main()
{
    char a[N];
    printf("请输入由四个数字组成的字符串：\n");
    gets(a);
    fun(a);
}
