#include<stdio.h> 
#include<stdlib.h> 

char* month_str[]={"January","February","March","April","May","June","July","August","September","October","November","December"}; 
char* week[]={"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"}; 

int IsLeapYear(int year) /*find out the year is leap year or not*/ 
{ 
    if((year%4==0&&year%100!=0)||(year%400==0)) 
       return 1;   
    else 
       return 0; 

} 
int month_day(int year,int month) 
{ 
    int mon_day[]={31,28,31,30,31,30,31,31,30,31,30,31}; 
    if(IsLeapYear(year)&&month==2) 
       return 29; 
    else 
       return(mon_day[month-1]); 
} 
int DaySearch(int year,int month,int day) /*search what day this day is*/ 
{ 
    int c=0; 
    float s; 
    int m; 
    for(m=1;m<month;m++) 
       c=c+month_day(year,m); 
    c=c+day; 
    s=year-1+(float)(year-1)/4+(float)(year-1)/100+(float)(year-1)/400-40+c; 
    return ((int)s%7); 
} 

int PrintAllYear(int year)/*print the all year*/ 
{ 
    int temp; 
    int i,j; 
    printf("\n\n%d Calander\n",year); 
    for(i=1;i<=12;i++) 
	{ 
       printf("\n\n%s(%d)\n",month_str[i-1],i); 
       printf("0 1 2 3 4 5 6 \n"); 
       printf("S M T W T F S \n\n"); 
       temp=DaySearch(year,i,1); 
       for(j=1;j<=month_day(year,i)+temp;j++) 
	   { 
          if(j-temp<=0) 
             printf(" "); 
          else if(j-temp<10) 
                  printf("%d ",j-temp); 
               else 
                   printf("%d ",j-temp); 

          if(j%7==0) 
             printf("\n"); 
	   } 
	} 
     return 0; 
} 

int main() 
{ 
    int option,da; 
    char ch; 
    int year,month,day; 
    while(1) 
	{ 
        printf("\nPlease select the service you need:\n"); 
        printf("\n1 Search what day the day is"); 
        printf("\n2 Search whether the year is leap year or not"); 
        printf("\n3 Print the calander of the whole year"); 
        printf("\n4 Exit\n"); 
        scanf("%d",&option); 

        switch(option) 
		{ 
           case 1: 
                  while(1) 
				  { 
                      printf("\nPlease input the year,month and day(XXXX,XX,XX):"); 
                      scanf("%d,%d,%d,%c",&year,&month,&day); 
                      da=DaySearch(year,month,day); 
                      printf("\n%d-%d-%d is %s,do you want to continue?(Y/N)",year,month,day,week[da]); 
                      fflush(stdin); 
                      scanf("%c",&ch); 
                      if(ch=='N'||ch=='n') 
                      break; 
				  } 
                break; 
          case 2: 
                 while(1) 
				 { 
                     printf("\nPlease input the year which needs searched?(XXXX)"); 
                     scanf("%d",&year); 
                     if(IsLeapYear(year)) 
                        printf("\n%d is Leap year,do you want to continue?(Y/N)",year); 
                     else 
                        printf("\n%d is not Leap year,do you want to continue(Y/N)?",year); 
                     fflush(stdin); 
                     scanf("%c",&ch); 
                     if(ch=='N'||ch=='n') 
                        break; 
				 } 
                break; 
           case 3: 
             while(1) 
			 { 
                   printf("\nPlease input the year which needs printed(XXXX)"); 
                   scanf("%d",&year); 
                   PrintAllYear(year); 
                   printf("\nDo you want to continue to print(Y/N)?"); 
                   fflush(stdin); 
                   scanf("%c",&ch); 
                   if(ch=='N'||ch=='n') 
                      break; 
			 } 
               break; 
           case 4: 
           fflush(stdin); 
           printf("Are you sure?(Y/N)"); 
           scanf("%c",&ch); 
           if(ch=='Y'||ch=='y') 
             exit(0); 
             break; 
           default: 
             printf("\nError:Sorry,there is no this service now!\n"); 
             break; 
		} 

	} 

   return 0; 
}