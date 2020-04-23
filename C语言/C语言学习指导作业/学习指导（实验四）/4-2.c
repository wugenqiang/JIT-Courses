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
	printf("请输入每位学生的学号 成绩\n");
	for(i=0;i<N;i++)
	{
		gets(a[i].num);
		scanf("%lf",&a[i].s);
		getchar();
	}
	s=fun(a,b,&j);
	printf("\n平均分为%lf分\n低于平均分有%d人\n",s,j);
	for(i=0;i<j;i++)
	{
		printf("分别为第%d位同学\n学号为%s\n成绩为%lf分\n",i+1,b[i].num,b[i].s);

	}
}
