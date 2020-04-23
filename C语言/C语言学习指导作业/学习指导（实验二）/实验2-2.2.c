#include <stdio.h>
#define N 11
main()
{   int i,number,a[N]={1,2,4,6,8,9,12,15,149,156};
    printf("please enter an integer to insert in the array:\n");
    scanf("%d",&number);
    printf("The original array:\n");
    for(i=0;i<N-1;i++)
      printf("%5d",a[i]);
      printf("\n");
    for(i=N-1;i>0;i--)
      if(number<=a[i])
             a[i+1]=a[i];
    else
    {
      a[i+1]=number;
      continue;
    }
    if(number<a[0]) a[0]=number;
      printf("The result array:\n");
    for(i=0;i<N;i++)
       printf("%5d",a[i]);
  printf("\n");
}
