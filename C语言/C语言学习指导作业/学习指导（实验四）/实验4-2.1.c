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
         if  (a[i].s>max) max=a[i].s;  /*从所有的学生数据中找出最高的分值*/
      for (i=0;i<N;i++)
         if (a[i].s==max)
	     {  f++;                        /*统计分数最高的学生人数*/
            for (k=0;k<10;k++)
            b[j].num[k]=a[i].num[k];  /*将所有学生分数中与最高分值相等的学生数据放到另一数组b中*/
            b[j].s=a[i].s;
            j++;
	     }
return(f);                      /*返回分数最高的学生人数*/
}
    int main()
{
    int i;
    STREC a[N],b[N];
    printf("please enter num、s\n");
    for(i=0;i<N;i++)
        {gets(a[i].num);
        scanf("%lf",&a[i].s);
        getchar();}
        printf("最高数人数为%d\n",fun(a,b));
}
