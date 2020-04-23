#include <stdio.h>
#include <stdlib.h>
typedef struct node
{
 int data;
 struct node *next;
}linklist;

linklist *CREATLINKLISTR()
{int a;
 linklist *head,*s,*r;
 head=NULL;
 r=NULL;
 printf("请按递增顺序输入单链表的数据元素：\n");
 scanf("%d",&a);
 while(a!=-1)
 {
  s=(linklist*)malloc(sizeof(linklist));
  s->data=a;
  if(head==NULL)
    head=s;
  else
    r->next=s;
  r=s;
  scanf("%d",&a);
 }
 if(r!=NULL)  r->next=NULL;
 return head;
}

void *PRINTLINKLIST(linklist *q)
{
  while(q)
  {
    printf("%d ",q->data);
    q=q->next;
  }
}
 

linklist  *Insert(linklist *head,int x)
{linklist  *s,*q;
 s=(linklist*)malloc(sizeof(linklist));
 s->data=x;
 q=head;
 if(q->data>x)
 {
  s->next=q;
  head=s;
 }
 else
 while(q!=NULL)
 {
   if(q->next->data>x)
   {
    s->next=q->next;
    q->next=s;
    break;                
   }      
   q=q->next;
 }
 q=head;

 PRINTLINKLIST(q);  
}

main()
{linklist *p;
  int x;
   p=CREATLINKLISTR();
   printf("你所建立的单链表为：\n");
   PRINTLINKLIST(p);
   printf("\n");
   printf("请输入在建立的单链表中插入数据x：\n");
   scanf("%d",&x);
   Insert(p,x);
   getchar();
   getchar();
}