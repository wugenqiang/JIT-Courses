#include<stdio.h>
#include<malloc.h>
#define NULL 0
#define LEN sizeof(DAT)
typedef struct student
{
  long num;
  float score;
  struct student *next;
}DAT;
int n=0;
DAT *creat(void)
{
	DAT *head=NULL;
	DAT *p1,*p2;
	p1=p2=(DAT *)malloc(LEN);
	if(NULL!=p1)
	{
		scanf("%ld,%f",&p1->num,&p1->score);
		while(0!=p1->num)
		{   n++;
			if(1==n) head=p1;
			else p2->next=p1;
			p2=p1;
			p1=(DAT *)malloc(LEN);
			if(NULL!=p1) scanf("%ld,%f",&p1->num,&p1->score);
			else printf("is NULL\n");
		}
		p2->next=NULL;
	}
     return(head);
}
void pri(DAT *head)
{
	if(NULL!=head)
	do
	{
		printf("%ld\t%5.2f\n",head->num,head->score);
		head=head->next;
	}while(NULL!=head);

}
DAT *del(DAT *head,long num)
{
	DAT *p1,*p2;
	if(NULL==head) {printf("is NULL\n");goto end;}
	p1=head;
	while(num!=p1->num&&NULL!=p1->next)
	{
		p2=p1;
		p1=p1->next;
	}
	if(num==p1->num)
	{
		if(head==p1) head=p1->next;
		else p2->next=p1->next;
		printf("已删除:%ld\n",num);
		n--;
	}
	else printf("找不到该节点\n");
    end:
	return(head);
}
DAT *insert(DAT *head,DAT *stud)
{
	DAT *p0,*p1,*p2;
	p1=head;
	p0=stud;
	if(NULL==head) {head=p0;p0->next=NULL;}
	else
	{
		while((p0->num>p1->num)&&(NULL!=p1->next))
		{
			p2=p1;
			p1=p1->next;
		}
		if(p0->num<=p1->num)
		{
			if(p1==head) head=p0;
			else p2->next=p0;
			p0->next=p1;
		}
		else {p1->next=p0;p0->next=NULL;}

	}
	n++;
	return(head);
}
void main(void)
{
	DAT *head,*stud;
	long num;
	head=creat();
	pri(head);
	printf("请输入要删除的num:\n");
	scanf("%ld",&num);
	while(0!=num)
	{
		head=del(head,num);
		pri(head);
		printf("请输入要删除的num:\n");
	    scanf("%ld",&num);

	}
	printf("请输入要插入的num:\n");
	stud=(DAT *)malloc(LEN);
	scanf("%ld,%f",&stud->num,&stud->score);
	if(NULL!=stud)
		while(0!=stud->num)
	{
       head=insert(head,stud);
	   pri(head);
	   printf("请输入要插入的num:\n");
	   stud=(DAT *)malloc(LEN);
	   scanf("%ld,%f",&stud->num,&stud->score);

	}
}