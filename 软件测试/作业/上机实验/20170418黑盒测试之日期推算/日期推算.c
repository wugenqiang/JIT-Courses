#include "stdio.h"
#include "stdlib.h"
int main()
{
    freopen("in.txt","r",stdin);
    freopen("out.txt","w",stdout);
    int y=0,m=0,d=0;
    int year,month,day;
    //printf("Please enter a date:(exc:year年month月day日)\n");
    while(scanf("%d年%d月%d日",&year,&month,&day)!=EOF)
    {
        if((year<1000||year>9999)||(month<1||month>12)||(day<1||day>31))
             printf("Error");
        else
        {
            y=isLeap(year);
            m=Month(month);
            d=Day(day);
            print(y,m,d,year,month,day);
        }
    }
    return 0;
}
int isLeap(int year)
{
    if((year%4==0&&year/100!=0)||(year%400==0))
        return 1;
    return 0;
}
int Month(int month)
{
    int m;
    switch(month)
    {
        case 1:case 3:case 5:case 7:case 8:case 10:m=1;break;
        case 2:m=2;break;
        case 4:case 6:case 9:case 11:m=3;break;
        case 12:m=4;
    }
    return m;
}
int Day(int day)
{
    int d;
    if(day>=1&&day<=26)
        d=1;
    else
    {
        switch(day)
        {
            case 27:d=2;break;
            case 28:d=3;break;
            case 29:d=4;break;
            case 30:d=5;break;
            case 31:d=6;
        }
    }
    return d;
}
int print(int y,int m,int d,int year,int month,int day)
{
    int flag=0;
    if(d==1)
        day+=2;
    if((m==1||m==3||m==4)&&(d==2||d==3))
        day+=2;
    if((m==1||m==3)&&(d==4))
        day+=2;
    if(m==1&&d==5)
    {
        day=1;month+=1;
    }
    if(m==1&&d==6)
    {
        day=2;month+=1;
    }
    if(m==3&&d==4)
    {
        day=1;month+=1;
    }
     if(m==3&&d==5)
    {
        day=2;month+=1;
    }
    if(m==3&&d==6)
    {
        printf("Error\n");flag=1;
    }
    if(m==4&&d==5)
    {
        day=1;month=1;year+=1;
    }
    if(m==4&&d==6)
    {
        day=2;month=1;year+=1;
    }
    if(y==0&&m==2&&d==2)
    {
        day=1;month+=1;
    }
    if(y==0&&m==2&&d==3)
    {
        day=2;month+=1;
    }
    if(y==0&&m==2&&d==4)
    {
        printf("Error\n");flag=1;
    }
    if(y==1&&m==2&&d==2)
        day+=2;
    if(y==1&&m==2&&d==3)
    {
        day=1;month+=1;
    }
    if(y==1&&m==2&&d==4)
    {
        day=2;month+=1;
    }
    if(m==2&&(d==5||d==6))
    {
        printf("Error\n");flag=1;
    }
    if(!flag)
    printf("%2d年%d月%d日\n",year,month,day);
}
