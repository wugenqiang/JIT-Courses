#include <stdio.h>
#define N 20
void fun(char str[],int i,int n)
{
    int j,m=0;
    for(j=0;j<N;j++)
    {if(j<=i)
    str[m++]=str[j];
        if(j>=(i+n+1))
    str[m++]=str[j];}
    str[m++]='\0';

}
int main()
{
    char str[N];
    printf("������С��20���ַ����ַ�����\n");
    gets(str);
    int i,n;
    printf("�������i���ַ���i�������n���ַ���Ҫɾ��\n");
    scanf("%d%d",&i,&n);
    fun(str,i,n);
    puts(str);
}
