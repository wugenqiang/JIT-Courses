#include <stdio.h>
#define N 20
int  fun( char  *s)
{
    int i=1,j=0;
    while(*s)
    {
	      if((i==1) && (*s!=32))
              {j++;i=0;}
	      if(*s==32)
               i=1;
	       s++;
    }
   return(j);
}
int main()
{
    char a[N];
    printf("请输入小于20个字符的小写字母字符串:\n");
    gets(a);
    fun(a);
    printf("%d",fun(a));
}
