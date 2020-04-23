#include <stdio.h>
#define N 10
int fun(int lim,int aa[])
{
    int i,j,t=1;
    if(lim<=1)
    {
        aa[0]=0;
       return 0;
    }
    if(lim==2)
    {
        aa[1]=1;
       return 1;
    }
    if(lim==3)
    {
        aa[2]=2;
       return 2;
    }
    if(lim>3)
        for (i=1;i<=lim-1;i++)
       {
            for(j=2;j<i;j++)
              {
               if(i%j==0)break;}
            if(i==j)
             aa[t++]=i;
       }
       return (t);
}
int main()
{
    int x,a[N];
    printf("please enter an integer:\n");
    scanf("%d",&x);
    fun(x,a);
    printf("%d\n",fun(x,a));
}
