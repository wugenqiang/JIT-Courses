#include <stdio.h>
#define N  20
#include <string.h>
void len_cat(char c1[],char c2[])
{
   int i,j;
   for(i=0;c1[i]!='\0';i++)
   for(j=0;c2[j]!='\0';j++)
     c1[i+j]=c2[j];
   c1[i+j]='\0';
}
int main()
{
    char c1[N],c2[N],c3[N];
    printf("please enter two strings:\n");
    gets(c1);
    gets(c2);
    len_cat(c1,c2);
    printf("%s",c1);
}
