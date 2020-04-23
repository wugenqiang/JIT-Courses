#include <stdio.h>
int addsub(int int1[],int int2[],int flag)
{
    int ret[5],int3[5],int4[5];
    int count=4;
    int num=0;
    int i;
    int SF=0,CF=0,OF=0;
    int c[5]={0},ZF=1;
        int result[4];
         if(flag)
            {
         for(i=0;i<4;i++)
            int2[i]=!int2[i];
            c[4]=1;
         }
         for(i=3;i>=0;i--)
            {
            result[i]=(int1[i]+int2[i]+c[i+1])%2;{

            if(result[i])
                ZF=0;
            c[i]=(int1[i]+int2[i]+c[i+1])/2;

            }
            }
        if(result[0]==2)
            result[0]=0;
        SF = result[0];
        CF = c[0]^flag;
        OF = c[0]^c[1];
        int add1=1;//作为下一个循环的全局变量
        for(i=3;i>=0;i--){
            int2[i]=int2[i]+add1;
            if(int2[i]>1)
                {
                int2[i]=0;
                add1=1;
                }
            else
                {
                add1=0;
                }
        }
        int3[0]=0;int4[0]=0;
        for(i=1;i<5;i++)
            {
            int3[i]=int1[i-1];
            int4[i]=int2[i-1];
            }
        for(i=4;i>=0;i--)
        {
            int add=0;
            add=int3[i]+int4[i]+num;//num=0
            if(add==2)
            {
                ret[count]=0;
                num=1;
            }
            if(add<2){
                ret[count]=add;
                num=0;
            }
            if(add==3){
                ret[count]=1;
                num=1;
            }
            count--;
        }

    printf("运算的结果：");
        for(i=0;i<5;i++)
            printf("%d",ret[i]);

         printf("\nZF=%d",ZF);
         printf("\nSF=%d",SF);
         printf("\nCF=%d",CF);
         printf("\nOF=%d",OF);

     return 0;
}
int main()
{
    int int1[]={1,1,0,0};
    int int2[]={0,0,1,1};//手动改变int1和int2数值，需要键盘输入再修改
    addsub(int1,int2,0);//调用函数第三个参数为表示运算法则0表示加，1表示减
    return 0;
}

