package zhengchu357;

public class function
{
	public int get(int x)
	{
		if(x<0||x>500)
	       System.out.println("ERROR,x<0 or x>500");
	    else
	        {
	           if(x%3==0&&x%5==0&&x%7==0)
	        	   System.out.println("被3,5,7三者整除");
	           if(x%15==0&&x%105!=0)
	        	   System.out.println("被3,5整除");
	           if(x%35==0&&x%105!=0)
	        	   System.out.println("被5,7整除");
	           if(x%21==0&&x%105!=0)
	        	   System.out.println("被3,7整除");
	          if(x%3==0&&x%5!=0&&x%7!=0)
	        	  System.out.println("被3整除");
	          if(x%3!=0&&x%5==0&&x%7!=0)
	        	  System.out.println("被5整除");
	          if(x%3!=0&&x%5!=0&&x%7==0)
	        	  System.out.println("被7整除");
	          if(x%3!=0&&x%5!=0&&x%7!=0)
	        	  System.out.println("不能被3,5,7任一整除");
	        }
		return 0;
	}
	public static void main(String[] args)
	{
		function abc=new function();
        abc.get(6);
	}
}
