#include <stdio.h>
void input(int *arr,int n)
{
    int *p,i;
  p=arr;
    printf("please enter 10 integers:\n");
    for(i=0;i<n;i++)
    scanf("%d",arr++);
}
void max_min(int *arr,int n)
{
    int *min,*max,*p,t;
    min=max=arr;
    for(p=arr+1;p<arr+n;p++)
      if(*p>*max)
         max=p;
      else if(*p<*min) min=p;
        t=*arr;*arr=*min;*min=t;
    if(*max==*arr) max=min;
  t=*(arr+n-1);
    *(arr+n-1)=*max;
    *max=t;
}
void output(int *arr,int n)
{
    int *p,i;
    p=arr;
    printf("The changed array is:\n");
    for(i=0;i<n;i++)
      printf("%3d",*p++);
    printf("\n");
}
main()
{
    int a[10];
    input(a,10);
  max_min(a,10);
    output(a,10);
}
