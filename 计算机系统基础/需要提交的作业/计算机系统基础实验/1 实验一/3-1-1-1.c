
#include<iostream>
#include<cstdlib>
#include<string>
using namespace std;
char a[1000],b[1000],c[1000];
/*�߾��ȼӷ�����*/
/*a[]��������λ������*/
/*b[]������λ������*/
/*back[]������ַ�������*/
void add(char a[],char b[],char back[])
{
int i,j,k,up,x,y,z,l;
char*c;//�洢�����������
if(strlen(a)>strlen(b))//�ж�λ���ĸ�������ȡ�ϳ���λ�����Է���λҪ�ಹһλ�ͽ�����
{
l=strlen(a)+2;
}
else
{
l=strlen(b)+2;
}
c=(char *)malloc(l*sizeof(char));//��̬����char����l���ȵ��ַ���
i=strlen(a)-1;//ȡʵ�ʳ���
j=strlen(b)-1;
k=0;up=0;//k��c������±꣬up�����λ��־
while(i>=0||j>=0)
{
if(i<0)//��������λ�����ٵĻ�����0ǰ������
{
x='0';
}
else
{
x=a[i];
}
if(j<0)//������λ�����ٵĻ�����0ǰ������???
{
y='0';
}
else
{
y=b[j];
}
z=x-'0'+y-'0';//�ӷ�����
if(up)//����һ�εĽ�λ����
{
z+=1;
}
if(z>9)//��9����???
{
up=1;
z%=10;
}
else
{
up=0;
}
c[k++]=z+'0';//����c����
i--;
j--;
}
if(up)//ĩ�ν�λ���
{
c[k++]='1';
}
c[k]='\0';//������
for(k-=1,i=0;k>=0;k--)//�������򸳸�back�������
{
back[i++]=c[k];
}
back[i]='\0';
}

/************************************************************************/
/*?�������ܣ�����С�����ĸ��������޸�a��b����Ϊ������?????????????????*/
/*?���ҳ�С�����λ��,�Ƚ�С�����ĸ���,���رȽϴ�ĸ���,������Ǹ���0?*/
/************************************************************************/
int decimal(char a[],char b[])
{
int i,j,k,l1,l2;
l1=strlen(a);
l2=strlen(b);
for(i=0;i<l1;i++)
{
if(a[i]=='.')//�ҵ�С����λ�ã�Ȼ��ɾ��С����
{
for(k=i;k<l1;k++)
{
a[k]=a[k+1];
}
l1--;//���ȼ���
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
k=(l1-i)-(l2-j);//�Ƚ���������˭��С��λ����
if (i==l1&&j==l2)//��û��С����Ļ�,����0
{
return 0;
}
else if (k>=0)//����������,b[]���������벹0
{
while (k!=0)
{
b[l2++]='0';
k--;
}
return l1-i;//����a[]��С��λ��
}
else if (k<0)//��������,a[]���������벹0
{
k=k*-1;//��סkҪ��Ϊ����
while(k!=0)
{
a[l1++]='0';
k--;
}
return l2-j;
}
}


/*����������,������С�������ĺ���,����С����*/
/*����С����ĳλ0�����,Ҫȥ��,����С����󲻺��κ���,С����ҲҪȥ��*/
void result(char c[],int n)
{
int i,j,k,length;
length=strlen(c);
for(i=length;i>length-n;i--)//�������length-n��С
{
c[i]=c[i-1];
}
c[length-n]='.';//����С����
for (i=length;i>=length-n;i--)
{
if (c[i]!='0'&&i!=length-n)//������С���������ʱ��,��Ϊ0ֱ���˳�
{
break;
}
else//��0��Ϊ������,�����ض����ʱȥ��С����
{
c[i]='\0';
}
}
}

/*������ʵ��*/
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
