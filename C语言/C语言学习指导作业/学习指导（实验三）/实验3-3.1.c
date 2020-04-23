#include <stdio.h>
#define N 10
int fun(int *s, int t, int *k)
{  int max_integer=0;
	int i;
	max_integer = s[0];
	for(i=0; i<t;i++)
        {
		   if(max_integer<s[i])
		   {
		      max_integer=s[i];
		      *k=i;
		   }
		}
	return *k;}
int main()
{
    int a[N],*s,i,b[N];
    s=a;
    printf("please enter an array having ten integers:\n");
    for(i=0;i<N;i++)
        scanf("%d",s++);
    fun(a,N,b);
    printf("%d",fun(a,N,b));
}
