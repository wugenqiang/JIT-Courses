#include<stdio.h>
#define N 3
typedef struct
{
	char num[10];
	double s;
}STREC;
int fun(STREC *a,STREC *b)
{
	int i,k=0;
	double m;
	m=(*a).s;
	for(i=1;i<N;i++)
		if(a[i].s>m)
		m=a[i].s;
		for(i=0;i<N;i++)
			if(a[i].s==m)
				b[k++]=a[i];
			return k;
}
main()
{
	STREC m[N],n[N];
	int i,s;
	double k;
	printf("����������ѧ��ѧ�� �ɼ�\n");
	for(i=0;i<N;i++)
	{
		gets(m[i].num);
		scanf("%lf",&m[i].s);
		getchar();
	}
	s=fun(m,n);
	k=n[0].s;
	printf("\n����%dλ��߷�����\n��߷�Ϊ%lf��\n",s,k);
	for(i=0;i<s;i++)
	{
		printf("���Ƿֱ�Ϊ��%dλѧ��\nѧ��Ϊ%s\n",i+1,n[i].num);

	}
}
