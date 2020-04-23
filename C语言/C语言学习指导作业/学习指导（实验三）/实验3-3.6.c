#include <stdio.h>
#define N 20
void fun(char s[],char c)
{
    int i;
    for(i=0;s[i]!='\0';i++)
        if(s[i]==c)
         s[i]=s[i+1];
}
int main()
{
    char s[N];
    printf("请输入长度小于20的字符串：\n");
    gets(s);
    char c;
    printf("删除字符:\n");
    c=getchar();
    fun(s,c);
    puts(s);
}
