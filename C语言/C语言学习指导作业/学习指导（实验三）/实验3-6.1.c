#include <stdio.h>
#define M 3
#define N 4
void  fun(char  (*s)[N], char *b)
{
    int i,j;
	for(j=0;j<N;j++)
		{for(i=0;i<M;i++)
			b[j*M+i]=*(s[i]+j);}
			b[M*N]='\0';
 puts(b);
}

int main()
{
    char a[M][N],b[N];
    printf("请输入M行N列的二维数组：\n");
    int i,j;
    for(i=0;i<M;i++)
    for(j=0;j<N;j++)
   scanf("%c",&a[i][j]);
    fun(a,b);
}
