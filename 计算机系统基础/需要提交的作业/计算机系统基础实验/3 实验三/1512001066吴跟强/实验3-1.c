/*	��д�������ӷ�����
����main�����������飺
bool float1[32];
bool float2[32];
��д����
float addfloat(bool float1[],bool float2[]);
����������ӷ�������ں����ڲ�Ҫ���б���λ������λ��ͨ������λ�ж��Ƿ����롣*/
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
    for(i=1;i<=8;i++){//��float1[N]��float2[N]�Ľ���
        e1+=float1[9-i]*j;
        j*=2;
        e2+=float2[9-i]*k;
        k*=2;}
    e=e1-e2;//�Խ�
    if(e>0)//��float1[N]��Ϊ�����
    {for(i=9+e;i<N;i++)
        float2[i]=float2[i-e];
    for(i=0;i<e;i++)//����λ�洢��sheru[N]��
        sheru[i]=float2[N-e+i];
    for(i=9;i<9+e;i++)
        if(float2[0]==1)
             float2[i]=1;
        else float2[i]=0;
    }
    else//��float2[N]��Ϊ�����
    {for(i=9+e;i<N-e;i++)
        float1[i]=float1[i-e];
    for(i=0;i<e;i++)
        sheru[i]=float1[N-e+i];
    for(i=9;i<9+e;i++)
        if(float1[0]==1)
             float1[i]=1;
        else float1[i]=0;
    }
    for(i=N-1;i>=0;i--){//���������
        a[i]=float1[i]^float2[i]^b[i+1];
        b[i]=float1[i]&float2[i]|float1[i]&b[i+1]|float2[i]&b[i+1];
    }
    float result=1,f=1.0,t2=2.0;//���²��ּ������֮��ĸ��������
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
