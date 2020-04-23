#include<stdio.h>
#include<stdlib.h>
typedef struct slist
{
	double s;
	struct slist *next ;
}STREC;

double fun(STREC *h)
{	double m;
	struct slist *p;
	p=h->next;
	m=p->s;
	for(;p->next!='\0';)
	{	if(m<p->next->s)
	m=p->next->s;
	 p=p->next;
	}
	return m;
}

main()
{
	double  a;
	struct slist *h,*new,*rear;
	h=(STREC *)malloc(sizeof(STREC));
	rear=h;
	scanf("%lf",&a);
	while (a!=-1)
	{
		new=(STREC *)malloc(sizeof(STREC));
		new->s=a;
		rear->next=new;
		rear=new ;
		scanf("%lf",&a);

	}
	rear->next='\0';
   printf("%lf\n",fun(h));
}
