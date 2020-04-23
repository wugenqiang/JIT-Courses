#include <stdio.h>
#include <malloc.h>
struct link
{
	int data;
	struct link *next;
};
struct link *delete_1()
{
	int m,n;
	struct link *h,*p;
	h=(struct link *)malloc(sizeof(struct link));
	h->next=NULL;
	printf("please enter m:\n");
	scanf("%d",&m);
	printf("what you need to delete:\n");
	scanf("%d",&n);
	while(m!=-1||h!=NULL)
	{
		p=(struct link *)malloc(sizeof(struct link));
		p->data=n;
		h=h->next;
		if(h->next->data==n)
		{	
			p=h->next;
            h=h->next;
			free(p);
		} 
		
		return h;
	}
     if(m==-1||h==NULL) return 0;   
}
int main()
{
	struct link *head;
	head=delete_1();
	while(head!=NULL)
	{
		printf("%4d\n",head->data);
		head=head->next;
	}
	printf("\n");
}