#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<time.h>
#define N 30
void rmb_units(int k);
void big_write_num(int l);
void time_print(void);
int main()
    {
        char c[N],*p;
        int a,i,j,len,len_integer=0,len_decimal=0;
        time_print();   //�����ǰ������
        printf("please input (����������Сд���): ��");
        scanf("%s",c);
        p=c;
        len=strlen(p);
        /*����������ֵĳ���*/
        for(i=0;i<=len-1 && *(p+i)<='9' && *(p+i)>='0';i++);
        if(*(p+i)=='.' || *(p+i)=='/0')   //*(p+i)=='/0'ûС��������
            len_integer=i;
        else
            {
               printf("Error: ��ע�������ʽ(XXX.XX)");
               
               exit(EXIT_FAILURE);
            }
        printf("��%s �����Ĵ�д���������ʾ:",c);
        /*ת����������*/
        for(i=0;i<len_integer;i++)
            {
                a=*(p+i)-'0';
                if(a==0)
                    {
                        if(i==0)
                            {
                                if(*(p+1)!='.' && *(p+1)!='/0' && *(p+1)!='0')
                                    {
                                       printf("/n�����д��󣡵�һλΪ�������������з��ַ�������/n");
                                       system("pause");
                                       printf("/n�������ִ��,ע�⣺�������ֵ�ʣ�²��ֽ�������/n");
                                    }
                                printf("��Բ");
                                break;   //����һ���������������������
                            }
                        else if(*(p+i+1)!='0' && i!=len_integer-5 && i!=len_integer-1 && i!=len_integer-9)   //Բ������λΪʱѡ�񲻼���                           {
                            {
                                 printf("��");
                                 continue;                           
                            }
                       
                        else if(i==len_integer-1 || i==len_integer-5 || i==len_integer-9)   //Բ���ڵ�λ���ܵ�
                            {
                                 rmb_units(len_integer+1-i);
                                 continue;
                            }
                        else
                                 continue;
                     }
               big_write_num(a);              //�������������Ĵ�д���
                rmb_units(len_integer+1-i);   //����һ��ҵ�λ���Ĵ�д���
           }
        /*���С�����ֵĳ���*/
        len_decimal=len-len_integer-1;
        if(len_decimal<0)
            {
                len_decimal=0;
                printf("��");   //����
            }
        if(len_decimal>2)      //ֻȡ��λС��
                len_decimal=2;
        //printf("%d----%d-----%d/n",len,len_integer,len_decimal);
        p=c;
        /*ת��С������*/
        for(j=0;j<len_decimal;j++)    
            {
                a=*(p+len_integer+1+j)-'0';    //��λ��С�����֣��ȼ���a=*(p+len-len_decimal+j)-'0';
                if(a<0 || a>9)
                    {
                        printf("/nError: �����д���С�����ֺ��д�����ַ�/n");
                        exit(EXIT_FAILURE);
                    }
                if(a==0)
                    {
                        if(j+1<len_decimal)
                         {
                             if(*(p+len_integer+j+2)!='0')      
                                printf("��");
                             else
                                {
                                 printf("��");
                                 break;
                                 }
                         }
                          continue;
                     }
                big_write_num(a);
                rmb_units(1-j);
            }
    }
    /*����һ��ҵ�λ���Ĵ�д���*/
    void rmb_units(int k)
      {
         //�൱��const char rmb_units[]="fjysbqwsbqisbqw";
         //"�ֽ�Բʰ��Ǫ��ʰ��Ǫ��ʰ��Ǫ��";
          switch(k)
              {
                   case 3:case 7:case 11: printf("ʰ");break;
                   case 4:case 8:case 12: printf("��");break;
                   case 5:case 9:case 13: printf("Ǫ");break;
                   case 6: case 14:       printf("��");break;
                   case 10:               printf("��");break;
                   case 2:                printf("Բ");break;
                   case 1:                printf("��");break;
                   case 0:                printf("��");break;
                   default:               break;
              }
      }
    /*�������������Ĵ�д���*/
    void big_write_num(int l)
      {
        //�൱��const char big_write_num[]="0123456789";
        //"��Ҽ��������½��ƾ�"
        switch(l)
             {
                  case 0:printf("��");break;
                  case 1:printf("Ҽ");break;
                  case 2:printf("��");break;
                  case 3:printf("��");break;
                  case 4:printf("��");break;
                  case 5:printf("��");break;
                  case 6:printf("½");break;
                  case 7:printf("��");break;
                  case 8:printf("��");break;
                  case 9:printf("��");break;
                  default:break;
             }
      }
    /*�����ǰ�����գ�������ͺͺ��������μ�<time.h>*/
    void time_print(void)
      {
         time_t rawtime;   
         struct tm * timeinfo;
         time ( &rawtime );    //��ȡʱ��
         //printf("%d",rawtime);
         timeinfo = localtime ( &rawtime );//ת��Ϊ����ʱ��tm�ṹ
         //ֱ�Ӵ�ӡtm�ṹ��Ԫ�أ�tm_year��1900����㣬����Ҫ��1900,��tm_mon����0���㣬����Ҫ��1
         printf ( "%d��%02d��%02d��",1900+timeinfo->tm_year, 1+timeinfo->tm_mon,timeinfo->tm_mday);
      }