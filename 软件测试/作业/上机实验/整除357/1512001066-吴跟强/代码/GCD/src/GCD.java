
public class GCD {
	public int getGCD(int x,int y){
		if(x<1||x>100){
			System.out.println("参数不正确");
			return -1;
		}
		if(y<1||y>100){
			System.out.println("参数不正确");
			return -1;
		}
		int max,min,result=1;
		if(x>=y){
			max=x;
			min=y;
		}
		else{
			max=y;
			min=x;
		}
		for(int n=1;n<=min;n++){
			if(min%n==0&&max%n==0){
				if(n>result)
					result=n;
			}
		}
		System.out.println("最大公约数为："+result);
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         GCD gcd=new GCD();
         gcd.getGCD(6, 12);
	}

}
