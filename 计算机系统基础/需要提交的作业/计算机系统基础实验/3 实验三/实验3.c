/*	��д�������ӷ�����
����main�����������飺
bool float1[32];
bool float2[32];
��д����
float addfloat(bool float1[],bool float2[]);
����������ӷ�������ں����ڲ�Ҫ���б���λ������λ��ͨ������λ�ж��Ƿ����롣*/
#include <stdio.h>
#include <stdbool.h>
#define N 12
void addfloat(bool float1[],bool float2[])
{
    int i,j=1,k=1,e,e1,e2;
    bool a[N],b[N+1];
    b[N]=0;
    int sheru[N];
    for(i=0;i<N;i++)
        a[i]=0;
    for(i=1;i<=8;i++){
        e1+=float1[9-i]*j;
        j*=2;
        e2+=float2[9-i]*k;
        k*=2;}
    e=e1-e2;
    if(e>0)
    for(i=9+e;i<32;i++)
        float2[i]=float2[i-e];
    for(i=0;i<e;i++)
        sheru[i]=float2[32-e+i];
    for(i=9;i<9+e;i++)
       float2[i]=0;
    for(i=N-1;i>=0;i--)
    {
        a[i]=float1[i]^float2[i]^b[i+1];
        b[i]=float1[i]&float2[i]|float1[i]&b[i+1]|float2[i]&b[i+1];
    }
        for(i=0;i<N;i++)
            printf("%2d",a[i]);
}
void main()
{
    bool float1[N];float a[N];
    bool float2[N];float b[N];
    int i;
    printf("Please input int1[32](only 0 or 1):\n");
    for(i=0;i<N;i++)
    {
        scanf("%f",&a[i]);
        float1[i]=(bool)a[i];
    }
    printf("Please input a int2[32](only 0 or 1):\n");
    for(i=0;i<N;i++)
    {
        scanf("%f",&b[i]);
        float2[i]=(bool)b[i];
    }
    addfloat(float1,float2);
}
