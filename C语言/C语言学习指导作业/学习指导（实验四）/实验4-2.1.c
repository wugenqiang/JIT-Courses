#include <stdio.h>
#define N 3
 typedef struct
    {
        char num[10];
        double s;
    }STREC;
int fun(STREC *a,STREC *b)
{  int i,j=0,max,k,f=0;
      max=(*a).s;
      for (i=1;i<N;i++)
         if  (a[i].s>max) max=a[i].s;  /*�����е�ѧ���������ҳ���ߵķ�ֵ*/
      for (i=0;i<N;i++)
         if (a[i].s==max)
	     {  f++;                        /*ͳ�Ʒ�����ߵ�ѧ������*/
            for (k=0;k<10;k++)
            b[j].num[k]=a[i].num[k];  /*������ѧ������������߷�ֵ��ȵ�ѧ�����ݷŵ���һ����b��*/
            b[j].s=a[i].s;
            j++;
	     }
return(f);                      /*���ط�����ߵ�ѧ������*/
}
    int main()
{
    int i;
    STREC a[N],b[N];
    printf("please enter num��s\n");
    for(i=0;i<N;i++)
        {gets(a[i].num);
        scanf("%lf",&a[i].s);
        getchar();}
        printf("���������Ϊ%d\n",fun(a,b));
}
