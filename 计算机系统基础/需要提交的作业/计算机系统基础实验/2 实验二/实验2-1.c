#include <stdio.h>
#include <stdbool.h>

int addsub(bool int1[],bool int2[],bool flag)
{
    int i,j=0,m=1,n=1;
    int a1=0,b2=0,s=0;
    int sum[32];
    int OF=0,CF=0,SF=0,ZF=1;
    printf("int1[4]=");
    for(i=0;i<4;i++)
        printf("%d",int1[i]);
    for(i=0;i<4;i++)
    {
        a1+=int1[3-i]*m;
        m*=2;
    }
    printf("\nint2[4]=");
    for(i=0;i<4;i++)
        printf("%d",int2[i]);
    for(i=0;i<4;i++)
    {
        b2+=int2[3-i]*n;
        n*=2;
    }
    printf("\n");

    if(flag==0)//进行加法运算
    {
       s=a1+b2;
       while(s>0)
       {
           sum[j]=s%2;
           s/=2;
           j++;
       }
       if(j==3)
        sum[3]=0;
       for(i=0;i<4;i++)
         printf("%d",sum[3-i]);
       if(sum[j]==1)
          OF=1;
       for(i=0;i<4;i++)
       {
           if(int1[i]==int2[i]&&int1[i]==1)
             CF=OF^1;
           else
            CF=OF^0;
       }
        if(sum[j-1]==1)
            SF=1;
        while(i>=0)
        {
            if(sum[i++]!=0)
                {
                    ZF=0;
                    break;
                }
        }
        printf("\nOF=%d CF=%d SF=%d ZF=%d",OF,CF,SF,ZF);
    }

    if(flag==1)//进行减法运算
    {
        s=a1-b2;
        if(s==0)
        {
             for(i=0;i<4;i++)
            sum[i]=0;
             for(i=0;i<4;i++)
         printf("%d",sum[3-i]);
        }

        if(s>0)
        {
            j=0;
            while(s>0)
           {
              sum[j]=s%2;
              s/=2;
              j++;
           }
           if(j==3||j==2)
             sum[j]=0;
           for(i=0;i<4;i++)
             printf("%d",sum[3-i]);
        }
        if(s<0)
        {
            SF=1;
            s=-s;
            j=0;
            while(s>0)
           {
              sum[j]=s%2;
              s/=2;
              j++;
           }
           if(j==3||j==2)
             sum[j]=0;
            for(i=0;i<4;i++)
                ~(sum[i]);
            for(i=3;i>1;i--)
                sum[i]=sum[i-1];
            sum[0]=1;
            for(i=0;i<4;i++)
              printf("%d",sum[i]);
        }
        for(i=0;i<4;i++)
          if(sum[i]==1)
              OF=1;
            while(i>=0)
        {
            if(sum[i++]!=0)
                {
                    ZF=0;
                    break;
                }
        }
      printf("\nOF=%d CF=%d SF=%d ZF=%d",OF,CF,SF,ZF);
    }

    return 0;
}

void main()
{
    bool int1[4];
    int a[4];
    bool int2[4];
    int b[4];
    bool flag;
    int i;
    printf("Please input int1[4](only 0 or 1):\n");
    for(i=0;i<4;i++)
    {
        scanf("%d",&a[i]);
        int1[i]=(bool)a[i];
    }
    printf("Please input a int2[4](only 0 or 1):\n");
    for(i=0;i<4;i++)
    {
        scanf("%d",&b[i]);
        int2[i]=(bool)b[i];
    }
    printf("Please enter flag(0 or 1) to choose '+' or '-':\n");
    scanf("%d",&flag);
    addsub(int1,int2,flag);
}
