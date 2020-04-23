#include<stdio.h>
#include<stdlib.h>
#define list_entry(type,pos,member)  (type*)((char*)pos-(int)(&((type*)0)->member))
typedef struct node
{
	struct node *next;
}list_head;

typedef struct list
{
	list_head member;
	int m;
	double n;
}my;

list_head *insert(list_head *h,list_head *p)//头插法建立链表 
{
	if(h==NULL) return p;
	p->next=h;
	return p;

}
list_head *get_node(list_head *h,list_head **p)
{
	if(h==NULL) return NULL;
	*p=h;
	return h->next;
}

main()
{
	list_head *h=NULL,*p;
	my a,b,c,*t;
	a.m=1;a.n=1.0;a.member.next=NULL;
	b.m=2;b.n=2.0;
	c.m=3;c.n=3.0;
	h=insert(h,&a.member);
	h=insert(h,&b.member);
	h=insert(h,&c.member);//c->b->a 
	while(h)
	{
		h=get_node(h,&p);
		t=list_entry(my,p,member);
		printf("%d %lf\n",t->m,t->n);
	}
}