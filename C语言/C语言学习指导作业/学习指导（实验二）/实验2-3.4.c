#include <stdio.h>
#define N 5
void fun(int arr[],int n)
{
    int i,t;
    for(i=0;i<N/2;i++)
    {
        t=arr[N-1-i];
        arr[N-1-i]=arr[i];
        arr[i]=t;
    }
}
int main()
{
    int a[N],i;
    printf("please enter an array:\n");
    for(i=0;i<N;i++)
        {
            scanf("%d,",&a[i]);
        }
    fun(a,N);
    for(i=0;i<N;i++)
        {
            printf("%d,",a[i]);
        }
}
