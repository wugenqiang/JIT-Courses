#include <stdio.h>
#include <stdlib.h>
#include <string.h>
struct stud_node
{
	int num;
	char name[3];
	int score;
	struct stud_node *next;
};
struct stud_node *input(struct stud_node *p2);
struct stud_node *deletelist(struct stud_node *head,int min_score);
int main()
{
	int min_score;
	struct stud_node *head;
	struct stud_node *p;
	head=NULL;
	head=input(head);
	scanf("%d",&min_score);
	head=deletelist(head,min_score);
	for(p=head->next;p!=NULL;p=p->next)
		printf("%d%s%d",p->num,p->name,p->score);
	return 0;
}
struct stud_node *input(struct stud_node *head)
{
	struct stud_node *p1,*node;
	int i,grade;
	char str[3];
	head=(struct stud_node *)malloc(sizeof(struct stud_node));
	if(head==NULL)
		return head;
	p1=head;
	node=head;
	head->next=NULL;
	do
	{
		scanf("%d",&i);
		if(i!=0)
		{
	    	scanf("%s%d",str,&grade);
		    p1=(struct stud_node*)malloc(sizeof(struct stud_node));
		    p1->num=i;
		    strcpy(p1->name,str);
	    	p1->score=grade;
	    	p1->next=NULL;
		    head->next=p1;
		    head=p1;
		}
	}while(i!=0);
	return node;
}
struct stud_node *deletelist(struct stud_node *cur,int min_score)
{
	struct stud_node *curnode,*nextnode;
	curnode=cur;
	nextnode=curnode->next;
	while(curnode->next!=NULL)
	{
		if(nextnode->score<min_score)
			curnode->next=nextnode->next;
		free(nextnode);
		curnode=curnode->next;
		nextnode=curnode->next;
	}
	return cur;
}
