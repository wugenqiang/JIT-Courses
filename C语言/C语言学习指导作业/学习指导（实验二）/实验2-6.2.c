#include <stdio.h>
#define N 10
float fun(float array[],int n)
{
    int i,max=0,j=0;
    float t[n],sum=0,aver;
    for(i=0;i<n;i++)
    {
        if(max<array[i])
        max=array[i];
    }
    printf("max=%d\n",max);
    for(i=0;i<n;i++)
    {
        if(max==array[i])
            t[j++]=array[i];
    }
    printf("最高分的人数=%d\n",j);
    for(i=0;i<n;i++)
    {
        sum+=array[i];
    }aver=sum/n;
    return(aver);
}
int main()
{
    int i;
    float a[N];
    printf("请输入N个学生的成绩：\n");
    for(i=0;i<N;i++)
    {
        scanf("%f",&a[i]);
    }
    fun(a,N);
    printf("平均成绩=%.1f\n",fun(a,N));
}
