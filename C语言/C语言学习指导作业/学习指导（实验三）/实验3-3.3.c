#include <stdio.h>
#define N 10
long  fun ( char *p)
{    int n=0,m=0;
    while(*p!='\0')
        {
         if(*p=='-')
             m=1;
         else if (*p=='+')
             m=0;
        else
          n=n*10+(*p-'0');
          p++;
        }
       if (m==1) n=-n;
      return n;

}
int main()
{
    char a[N];
    gets(a);
    fun(a);
    printf("%ld",fun(a));
}
