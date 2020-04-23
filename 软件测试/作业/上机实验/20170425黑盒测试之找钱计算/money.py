#program:money.py
def main():
    p=eval(input("请输入商品价格："))
    m=eval(input("请输入顾客付款："))
    mp=m-p
    if mp<0:
       print ('顾客付款不足:',mp)
    elif mp==0:
       print("不用找钱")
    else:
        a=mp/50
         b=mp%50
        c=b/10
        d=b%10
        e=d/5
        f=d%5
        print ("程序执行结果是：\n")
        print ('There are %d张50元,%d张10元,%d张5元 and %d张1元'%(a,c,e,f))
if __name__ == "__main__":
    main()
  
