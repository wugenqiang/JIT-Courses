#include<stdio.h>
#define N 3
typedef struct
{
	char num[10];
	double s;
}STREC;
double fun(STREC *a,STREC *b,int *n)
{
	int i,k=0;
	double sum=0,ave=0;
	for(i=0;i<N;i++)
		sum+=a[i].s;
		ave=sum/N;
		for(i=0;i<N;i++)
			if(a[i].s<ave)
				b[k++]=a[i];
			*n=k;
	return ave;
}
main()
{
	STREC a[N],b[N];
	int i,j;
	double s;
	printf("������ÿλѧ����ѧ�� �ɼ�\n");
	for(i=0;i<N;i++)
	{
		gets(a[i].num);
		scanf("%lf",&a[i].s);
		getchar();
	}
	s=fun(a,b,&j);
	printf("\nƽ����Ϊ%lf��\n����ƽ������%d��\n",s,j);
	for(i=0;i<j;i++)
	{
		printf("�ֱ�Ϊ��%dλͬѧ\nѧ��Ϊ%s\n�ɼ�Ϊ%lf��\n",i+1,b[i].num,b[i].s);

	}
}
