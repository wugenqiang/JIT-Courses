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
        time_print();   //输出当前年月日
        printf("please input (阿拉伯数字小写金额): ￥");
        scanf("%s",c);
        p=c;
        len=strlen(p);
        /*求出整数部分的长度*/
        for(i=0;i<=len-1 && *(p+i)<='9' && *(p+i)>='0';i++);
        if(*(p+i)=='.' || *(p+i)=='/0')   //*(p+i)=='/0'没小数点的情况
            len_integer=i;
        else
            {
               printf("Error: 请注意输入格式(XXX.XX)");
               
               exit(EXIT_FAILURE);
            }
        printf("￥%s 的中文大写金额如下所示:",c);
        /*转换整数部分*/
        for(i=0;i<len_integer;i++)
            {
                a=*(p+i)-'0';
                if(a==0)
                    {
                        if(i==0)
                            {
                                if(*(p+1)!='.' && *(p+1)!='/0' && *(p+1)!='0')
                                    {
                                       printf("/n输入有错误！第一位为而后整数部分有非字符，请检查/n");
                                       system("pause");
                                       printf("/n程序继续执行,注意：整数部分的剩下部分将被忽略/n");
                                    }
                                printf("零圆");
                                break;   //若第一个是则忽略其他整数部分
                            }
                        else if(*(p+i+1)!='0' && i!=len_integer-5 && i!=len_integer-1 && i!=len_integer-9)   //圆、万、亿位为时选择不加零                           {
                            {
                                 printf("零");
                                 continue;                           
                            }
                       
                        else if(i==len_integer-1 || i==len_integer-5 || i==len_integer-9)   //圆万亿单位不能掉
                            {
                                 rmb_units(len_integer+1-i);
                                 continue;
                            }
                        else
                                 continue;
                     }
               big_write_num(a);              //阿拉伯数字中文大写输出
                rmb_units(len_integer+1-i);   //人民币货币单位中文大写输出
           }
        /*求出小数部分的长度*/
        len_decimal=len-len_integer-1;
        if(len_decimal<0)
            {
                len_decimal=0;
                printf("整");   //或正
            }
        if(len_decimal>2)      //只取两位小数
                len_decimal=2;
        //printf("%d----%d-----%d/n",len,len_integer,len_decimal);
        p=c;
        /*转换小数部分*/
        for(j=0;j<len_decimal;j++)    
            {
                a=*(p+len_integer+1+j)-'0';    //定位到小数部分，等价于a=*(p+len-len_decimal+j)-'0';
                if(a<0 || a>9)
                    {
                        printf("/nError: 输入有错误，小数部分含有错误的字符/n");
                        exit(EXIT_FAILURE);
                    }
                if(a==0)
                    {
                        if(j+1<len_decimal)
                         {
                             if(*(p+len_integer+j+2)!='0')      
                                printf("零");
                             else
                                {
                                 printf("整");
                                 break;
                                 }
                         }
                          continue;
                     }
                big_write_num(a);
                rmb_units(1-j);
            }
    }
    /*人民币货币单位中文大写输出*/
    void rmb_units(int k)
      {
         //相当于const char rmb_units[]="fjysbqwsbqisbqw";
         //"分角圆拾佰仟万拾佰仟亿拾佰仟万";
          switch(k)
              {
                   case 3:case 7:case 11: printf("拾");break;
                   case 4:case 8:case 12: printf("佰");break;
                   case 5:case 9:case 13: printf("仟");break;
                   case 6: case 14:       printf("万");break;
                   case 10:               printf("亿");break;
                   case 2:                printf("圆");break;
                   case 1:                printf("角");break;
                   case 0:                printf("分");break;
                   default:               break;
              }
      }
    /*阿拉伯数字中文大写输出*/
    void big_write_num(int l)
      {
        //相当于const char big_write_num[]="0123456789";
        //"零壹贰叁肆伍陆柒捌玖"
        switch(l)
             {
                  case 0:printf("零");break;
                  case 1:printf("壹");break;
                  case 2:printf("贰");break;
                  case 3:printf("叁");break;
                  case 4:printf("肆");break;
                  case 5:printf("伍");break;
                  case 6:printf("陆");break;
                  case 7:printf("柒");break;
                  case 8:printf("捌");break;
                  case 9:printf("玖");break;
                  default:break;
             }
      }
    /*输出当前年月日，相关类型和函数声明参见<time.h>*/
    void time_print(void)
      {
         time_t rawtime;   
         struct tm * timeinfo;
         time ( &rawtime );    //获取时间
         //printf("%d",rawtime);
         timeinfo = localtime ( &rawtime );//转换为当地时间tm结构
         //直接打印tm结构的元素，tm_year从1900年计算，所以要加1900,月tm_mon，从0计算，所以要加1
         printf ( "%d年%02d月%02d日",1900+timeinfo->tm_year, 1+timeinfo->tm_mon,timeinfo->tm_mday);
      }