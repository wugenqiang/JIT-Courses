#include <stdio.h>
#include <string.h>
#include <math.h>
typedef char bool;
float floatToValue(bool binary[])
{
     float result=1.0;
     float j=0.5;
     int i;
     int e=0;//阶码
     float t=1.0;
     if(strlen(binary)<=32)
    {
        for(i=8;i>0;i--)
            e+=(binary[i]-'0')*pow(2,strlen(binary)-1-i);
        e-=127;
        if(e>=0)
        {
            for(i=0;i<e;i++)
                t*=2;
        }
        else
        {
            for(i=e;i<0;i++)
                t/=2;
        }

        for(i=9;i<32;i++)
            {
                result=result+(binary[i]-'0')*j;
                j=j/2;
            }

            result=result*t;
    }

    if(binary[0]=='0')
        return result;
    else
        return -result;
}

void main()
{
    bool binary[32];
	printf("Please input a string(only 0 or 1):\n");
    gets(binary);
	printf("此单精度浮点数的真值为：%lf\n",floatToValue(binary));

}
