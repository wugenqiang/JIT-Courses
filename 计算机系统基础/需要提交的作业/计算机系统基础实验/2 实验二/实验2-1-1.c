#include <stdio.h>
#include <stdbool.h>
#define N 4
void addsub(bool int1[],bool int2[],bool flag)
{
    int i;
    bool a[N],b[N+1];
    bool OF,SF,CF,ZF=1;
    b[N]=flag;
    if(flag==1)
        for(i=0;i<N;i++)
            int2[i]=!int2[i];
        for(i=N-1;i>=0;i--)
        {
            a[i]=int1[i]^int2[i]^b[i+1];
            b[i]=int1[i]&int2[i]|int1[i]&b[i+1]|int2[i]&b[i+1];
        }
        OF=b[0]^b[1];
        CF=b[0]^flag;
        SF=a[0];
        for(i=0;i<N;i++)
            if(a[i]==1){ZF=0;break;}
        for(i=0;i<N;i++)
            printf("%d\t",a[i]);
        printf("\n");
        printf("OF=%d,CF=%d,SF=%d,ZF=%d\n",OF,CF,SF,ZF);
}
void main()
{
    bool int1[N];
    int a[N];
    bool int2[N];
    int b[N];
    bool flag;
    int i;
    printf("Please input int1[4](only 0 or 1):\n");
    for(i=0;i<N;i++)
    {
        scanf("%d",&a[i]);
        int1[i]=(bool)a[i];
    }
    printf("Please input a int2[4](only 0 or 1):\n");
    for(i=0;i<N;i++)
    {
        scanf("%d",&b[i]);
        int2[i]=(bool)b[i];
    }
    printf("Please enter flag(0 or 1) to choose '+' or '-':\n");
    scanf("%d",&flag);
    addsub(int1,int2,flag);
}
