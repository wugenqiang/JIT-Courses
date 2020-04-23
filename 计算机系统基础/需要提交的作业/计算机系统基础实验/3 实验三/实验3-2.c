/*3.	编写无符号整数乘法运算器：
bool int1[4];
bool int2[4];
编写函数
int mul(int int1[],int int2[]);
在运算结束后，将高4位保存在int1中，低4位保存在int2中，返回是否溢出。*/
#include <stdio.h>
#include <stdbool.h>
#define N 8
int mul(int int1[],int int2[])
{
    int i,j,count=0;
    int m[4][4];
    bool a[N],b[N],c[N],d[N];
    bool a1[N],a2[N],a3[N];
    bool b1[N+1],b2[N+1],b3[N+1];
    b1[N]=0;b2[N]=0;b3[N]=0;
    for(i=0;i<N;i++)//初始化数组为0
    {
        a[i]=0;c[i]=0;
        b[i]=0;d[i]=0;
    }
    for(i=0;i<4;i++)//用二维数组4*4存储数据
        for(j=0;j<4;j++)
           m[i][j]=int1[j]*int2[3-i];
    for(i=3;i>=0;i--){//取出
         a[i+4]=m[0][i];
         b[i+3]=m[1][i];
         c[i+2]=m[2][i];
         d[i+1]=m[3][i];}
    for(i=N-1;i>=0;i--){//二进制相加
        a1[i]=a[i]^b[i]^b1[i+1];
        b1[i]=a[i]&b[i]|a[i]&b1[i+1]|b[i]&b1[i+1];
        a2[i]=c[i]^d[i]^b2[i+1];
        b2[i]=c[i]&d[i]|c[i]&b2[i+1]|d[i]&b2[i+1];
        a3[i]=a1[i]^a2[i]^b3[i+1];
        b3[i]=a1[i]&a2[i]|a1[i]&b3[i+1]|a2[i]&b3[i+1];}
    for(i=0;i<4;i++){//高4位保存在int1[4]中，低4位保存在int2[4]中
        int1[i]=a3[i];
        int2[i]=a3[i+4];}
    for(i=0;i<4;i++)//判断是否溢出的方法
       if(int1[i]==0) count++;
    if(count!=4)//判断是否溢出的条件
        printf("发生溢出！");
    else
        printf("未发生溢出！");
    return 0;
}
void main()
{
    bool int1[4];int a[4];
    bool int2[4];int b[4];
    int i;
    printf("Please input int1[4](only 0 or 1):\n");
    for(i=0;i<4;i++){
        scanf("%d",&a[i]);
        int1[i]=(bool)a[i];}
    printf("Please input a int2[4](only 0 or 1):\n");
    for(i=0;i<4;i++){
        scanf("%d",&b[i]);
        int2[i]=(bool)b[i];}
    mul(a,b);
}
