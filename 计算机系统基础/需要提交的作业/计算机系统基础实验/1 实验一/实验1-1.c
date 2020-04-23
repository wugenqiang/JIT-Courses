#include <stdio.h>
#include <string.h>
#include <math.h>
typedef char bool;
unsigned int unsignedToValue(bool binary[])
{
    int i=0,result=0;
    for(i;i<strlen(binary);i++)
    {
        result+=(binary[i]-'0')*pow(2,strlen(binary)-1-i);
    }
    return result;
}

void main()
{
	bool binary[32];
	printf("Please input a string(only 0 or 1):\n");
    gets(binary);
	printf("此无符号数的真值为：%u\n",unsignedToValue(binary));
}
