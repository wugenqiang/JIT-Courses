#include <stdio.h>
int fun(int n)
{
    int i,m;
    if(n<=0)
        return (1);
    if(n>0)
        for(m=n+1;;m++)
       {
          for(i=2;i<m;i++)
          {
              if(m%i==0)
                break;
          }
              if(i==m)
                return (m);
       }
}
int main()
{
    int x;
    printf("please enter an integer:\n");
    scanf("%d",&x);
    fun(x);
    printf("%d\n",fun(x));
}
