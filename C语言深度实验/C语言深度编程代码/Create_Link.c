#include <stdio.h>
#include <malloc.h>
struct link
{
	int date;
	struct link *next;
};
struct link *create_link()
{
	int a;
	struct link *h,*new;
	h=(struct link *)malloc(sizeof(struct link));
	h->next=NULL;
	scanf("%d",&a);
	while(a!=-1)
	{
    	new=(struct link *)malloc(sizeof(struct link));
    	new->date=a;
		new->next=h->next;
		h->next=new;
		scanf("%d",&a);
	}
	return h;
}
main()
{
	struct link *head;
	head=create_link();
	while(head!=NULL)
	{
		head=head->next;
	    printf("%4d",head->date);
	}
	printf("\n");
}