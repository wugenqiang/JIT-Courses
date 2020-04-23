#include <stdio.h>
#define N 20
int fun(char *ptr)
{
    int i,j=0;
    for(i=0;*(ptr+i)!='\0';i++)
    if(*(ptr+i)<='z'&& *(ptr+i)>='a'||*(ptr+i)<='Z' && *(ptr+i)>='A')
    {
        *(ptr+j)=*(ptr+i);
         j++;
    }
      *(ptr+j)='\0';
       return(j);
}
int main()
{
    char a[N];
    printf("请输入不大于20个字符:\n");
    gets(a);
    fun(a);
    printf("%d",fun(a));
}
