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
    printf("�����볤��С��20���ַ�����\n");
    gets(s);
    char c;
    printf("ɾ���ַ�:\n");
    c=getchar();
    fun(s,c);
    puts(s);
}
