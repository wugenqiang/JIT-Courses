#include <stdio.h>
#define M 4
#define N 4
void saddle_point(int a[M][N])
{
	int i,j,i0,j0,k=1,find=0;
   for(i=0;i<M;i++)        //������е���
   {
     j0=0;
     for(j=1;j<N;j++)
     if(a[i][j]>a[i][j0])j0=j;    //�ҵ���i����������a[i][j0]
     for(i0=0;i0<M;i0++)    //���ҵ��ĸ������������
     if(a[i0][j0]<a[i][j0])k=0;    //�������Ǳ�������С�����͡��������
     if(k)    //��ȷ���ǣ���������������ҵ�
	 {
         printf("�����ǣ�a[%d][%d]=%d\n",i,j0,a[i][j0]);
         find=1;
	 }
   }
     if(!find)
     printf("�������ް��㣡\n");
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