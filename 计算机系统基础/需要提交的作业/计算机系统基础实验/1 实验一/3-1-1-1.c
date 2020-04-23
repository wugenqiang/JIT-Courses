
#include<iostream>
#include<cstdlib>
#include<string>
using namespace std;
char a[1000],b[1000],c[1000];
/*高精度加法运算*/
/*a[]被加数，位数不限*/
/*b[]加数，位数不限*/
/*back[]结果，字符串保存*/
void add(char a[],char b[],char back[])
{
int i,j,k,up,x,y,z,l;
char*c;//存储结果的逆数组
if(strlen(a)>strlen(b))//判断位数哪个更大吗，取较长的位数，以防进位要多补一位和结束符
{
l=strlen(a)+2;
}
else
{
l=strlen(b)+2;
}
c=(char *)malloc(l*sizeof(char));//动态开辟char类型l长度的字符串
i=strlen(a)-1;//取实际长度
j=strlen(b)-1;
k=0;up=0;//k是c数组的下标，up代表进位标志
while(i>=0||j>=0)
{
if(i<0)//当被加数位数过少的话，用0前补不足
{
x='0';
}
else
{
x=a[i];
}
if(j<0)//当加数位数过少的话，用0前补不足???
{
y='0';
}
else
{
y=b[j];
}
z=x-'0'+y-'0';//加法运算
if(up)//对上一次的进位处理
{
z+=1;
}
if(z>9)//超9处理???
{
up=1;
z%=10;
}
else
{
up=0;
}
c[k++]=z+'0';//存入c数组
i--;
j--;
}
if(up)//末次进位情况
{
c[k++]='1';
}
c[k]='\0';//结束符
for(k-=1,i=0;k>=0;k--)//数组逆序赋给back结果数组
{
back[i++]=c[k];
}
back[i]='\0';
}

/************************************************************************/
/*?函数功能：返回小数点后的个数，并修改a，b数组为正整型?????????????????*/
/*?先找出小数点的位置,比较小数点后的个数,返回比较大的个数,不足的那个补0?*/
/************************************************************************/
int decimal(char a[],char b[])
{
int i,j,k,l1,l2;
l1=strlen(a);
l2=strlen(b);
for(i=0;i<l1;i++)
{
if(a[i]=='.')//找到小数点位置，然后删除小数点
{
for(k=i;k<l1;k++)
{
a[k]=a[k+1];
}
l1--;//长度减少
break;
}
}
for(j=0;j<l2;j++)
{
if(b[j]=='.')
{
for(k=j;k<l2;k++)
{
b[k]=b[k+1];
}
l2--;
break;
}
}
k=(l1-i)-(l2-j);//比较两个数组谁的小数位更多
if (i==l1&&j==l2)//都没有小数点的话,返回0
{
return 0;
}
else if (k>=0)//被加数更多,b[]数组后面对齐补0
{
while (k!=0)
{
b[l2++]='0';
k--;
}
return l1-i;//返回a[]的小数位数
}
else if (k<0)//加数更多,a[]数组后面对齐补0
{
k=k*-1;//记住k要变为正的
while(k!=0)
{
a[l1++]='0';
k--;
}
return l2-j;
}
}


/*处理结果数组,将数组小数点后面的后移,插入小数点*/
/*处理小数点某位0的情况,要去掉,若是小数点后不含任何数,小数点也要去掉*/
void result(char c[],int n)
{
int i,j,k,length;
length=strlen(c);
for(i=length;i>length-n;i--)//数组后移length-n大小
{
c[i]=c[i-1];
}
c[length-n]='.';//插入小数点
for (i=length;i>=length-n;i--)
{
if (c[i]!='0'&&i!=length-n)//当不在小数点上面的时候,不为0直接退出
{
break;
}
else//将0置为结束符,包括特定情况时去掉小数点
{
c[i]='\0';
}
}
}

/*主函数实现*/
int main(void)
{
int n,k;
scanf("%d",&n);
while(n--)
{
memset(a,'\0',sizeof(a));
memset(b,'\0',sizeof(b));
memset(c,'\0',sizeof(c));
cin>>a>>b;
k=decimal(a,b);
add(a,b,c);
if(k!=0)
{
result(c,k);
}
cout<<c<<endl;
}
return 0;
}
