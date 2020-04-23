/*	编写浮点数加法器：
设在main中有如下数组：
bool float1[32];
bool float2[32];
编写函数
float addfloat(bool float1[],bool float2[]);
输出浮点数加法结果，在函数内部要求有保护位和舍入位并通过这两位判定是否舍入。*/
#include <stdio.h>
#include <stdbool.h>
#define N 32
void addfloat(bool float1[],bool float2[])
{
    int i,j=1,k=1,e,e1,e2;
    bool a[N],b[N+1];
    b[N]=0;
    bool sheru[N];bool baohu[N];
    for(i=0;i<N;i++){
        a[i]=0;sheru[i]=0;baohu[i]=0;}
    for(i=1;i<=8;i++){//求float1[N]和float2[N]的阶码
        e1+=float1[9-i]*j;
        j*=2;
        e2+=float2[9-i]*k;
        k*=2;}
    e=e1-e2;//对阶
    if(e>0)//当float1[N]的为大阶码
    {for(i=9+e;i<N;i++)
        float2[i]=float2[i-e];
    for(i=0;i<e;i++)//舍入位存储在sheru[N]中
        sheru[i]=float2[N-e+i];
    for(i=9;i<9+e;i++)
        if(float2[0]==1)
             float2[i]=1;
        else float2[i]=0;
    }
    else//当float2[N]的为大阶码
    {for(i=9+e;i<N-e;i++)
        float1[i]=float1[i-e];
    for(i=0;i<e;i++)
        sheru[i]=float1[N-e+i];
    for(i=9;i<9+e;i++)
        if(float1[0]==1)
             float1[i]=1;
        else float1[i]=0;
    }
    for(i=N-1;i>=0;i--){//浮点数相加
        a[i]=float1[i]^float2[i]^b[i+1];
        b[i]=float1[i]&float2[i]|float1[i]&b[i+1]|float2[i]&b[i+1];
    }
    float result=1,f=1.0,t2=2.0;//以下部分计算相加之后的浮点数结果
    int e3=0,t1=1;
    for(i=1;i<9;i++){
        e3+=a[i]*t1;
        t1*=2;
    }
    e3-=127;
    if(e3>0){
        for(i=0;i<e3;i++)
            result*=2;
    }
    else if(e3<0)
          for(i=e3;i<0;i++)
             result/=2;
    for(i=9;i<32;i++){
        f+=(float)a[i]/t2;
        t2/=2;
    }
    if(a[0]==0)result*=f;
    else  result*=(-1)*f;
    printf("result=%lf\n",result);
}
void main()
{
    bool float1[N];float a[N];
    bool float2[N];float b[N];
    int i;
    printf("Please input int1[32](only 0 or 1):\n");
    for(i=0;i<N;i++){
        scanf("%f",&a[i]);
        float1[i]=(bool)a[i];}
    printf("Please input a int2[32](only 0 or 1):\n");
    for(i=0;i<N;i++){
        scanf("%f",&b[i]);
        float2[i]=(bool)b[i];}
    addfloat(float1,float2);
}
