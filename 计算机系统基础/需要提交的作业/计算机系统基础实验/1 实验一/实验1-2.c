#include <stdio.h>
#include <string.h>
#include <math.h>
typedef char bool;
int intToValue(bool binary[])
{
     int i=0,result=0;
     if(strlen(binary)<=32)
    {
        if(binary[0]=='0')
            for(i;i<strlen(binary);i++)
                result+=(binary[i]-'0')*pow(2,strlen(binary)-1-i);
        else
        {
            for(i=strlen(binary)-1;i>0;i--)
            {
                result+=(binary[i]-'0'+1)%2*pow(2,strlen(binary)-1-i);
            }
            result=-(result+1);
        }
    }
    return result;
}

void main()
{
    bool binary[32];
	printf("Please input a string(only 0 or 1):\n");
    gets(binary);
	printf("此有符号数的真值为：%d\n",intToValue(binary));
}
