#include <stdio.h>
int addsub(int int1[],int int2[],int flag){
    int ret[5],int3[5],int4[5];
    int count=4;
    int num=0;
    int i,j,k;
    int ZF=1,SF=0,CF=0,OF=0;
    if(flag==0){
        int3[0]=0;int4[0]=0;
        for(i=1;i<5;i++){
            int3[i]=int1[i-1];
            int4[i]=int2[i-1];
        }
        for(i=4;i>=0;i--){
            int add=0;
            add=int3[i]+int4[i]+num;
            if(add>1)
            {
                ret[count]=0;
                num=1;
                CF=1;
            }
            else{
                ret[count]=add;
                num=0;
            }
            count--;
        }
     }else{
        for(i=0;i<4;i++){
            if(int2[i]==1){
                int2[i]=0;
            }else{
                int2[i]=1;
            }
        }
        int add1=1;//作为下一个循环的全局变量
        for(i=3;i>=0;i--){
            int2[i]=int2[i]+add1;
            if(int2[i]>1){
                int2[i]=0;
            }else{
                add1=0;
            }
        }
        int3[0]=0;int4[0]=0;
        for(i=1;i<5;i++){
            int3[i]=int1[i-1];
            int4[i]=int2[i-1];
        }
        for(i=4;i>=0;i--){
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
     }
    printf("运算的四位结果：");
    for(k=1;k<5;k++){               //将k改为0可以输出五位结果，溢出时正确结果为五位
        if(ret[0]!=0||ret[k]!=0){
            ZF=0;
        }
        if(ret[0]!=0){
            OF=1;
            SF=1;
            CF=1;
        }
        printf("%d",ret[k]);
 }
         printf("\nZF=%d",ZF);
         printf("\nSF=%d",SF);
         printf("\nCF=%d",CF);
         printf("\nOF=%d",OF);

     return 0;
}
int main(){
    int int1[]={1,1,0,0},int2[]={0,0,1,1};//手动改变int1和int2数值，需要键盘输入再修改
    addsub(int1,int2,0);//调用函数第三个参数为表示运算法则0表示加，1表示减
    return 0;
}

