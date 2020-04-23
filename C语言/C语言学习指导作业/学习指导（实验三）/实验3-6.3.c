#include <stdio.h>
#define N 20
void fun(char *s,char t[])
{  int i,slenth,n=0;
       slenth=strlen(s);
      for(i=1;i<slenth;i+=2)
          if(s[i]%2!=0)
           t[n++]=s[i];
      t[n]='\0';
          puts(t);
}
int main()
{
    char s[N],b[N];
    printf("请输入小于20个字符的字符串:\n");
    gets(s);
    fun(s,b);
}
