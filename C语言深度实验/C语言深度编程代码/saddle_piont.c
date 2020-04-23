#include <stdio.h>
#define M 4
#define N 4
void saddle_point(int a[M][N])
{
	int i,j,i0,j0,k=1,find=0;
   for(i=0;i<M;i++)        //穷举所有的行
   {
     j0=0;
     for(j=1;j<N;j++)
     if(a[i][j]>a[i][j0])j0=j;    //找到第i行上最大的数a[i][j0]
     for(i0=0;i0<M;i0++)    //对找到的该数穷举所有行
     if(a[i0][j0]<a[i][j0])k=0;    //如它不是本列上最小的数就“否决掉”
     if(k)    //若确认是，就输出，表明已找到
	 {
         printf("鞍点是：a[%d][%d]=%d\n",i,j0,a[i][j0]);
         find=1;
	 }
   }
     if(!find)
     printf("此数组无鞍点！\n");
}
void main()
{
	int i,j;
	int a[M][N];
	printf("please input a arrray(4*4):\n");
	for(i=0;i<M;i++)
		for(j=0;j<N;j++)
       scanf("%d",&a[i][j]);
	saddle_point(a);
}