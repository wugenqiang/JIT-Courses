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
	        	   System.out.println("��3,5,7��������");
	           if(x%15==0&&x%105!=0)
	        	   System.out.println("��3,5����");
	           if(x%35==0&&x%105!=0)
	        	   System.out.println("��5,7����");
	           if(x%21==0&&x%105!=0)
	        	   System.out.println("��3,7����");
	          if(x%3==0&&x%5!=0&&x%7!=0)
	        	  System.out.println("��3����");
	          if(x%3!=0&&x%5==0&&x%7!=0)
	        	  System.out.println("��5����");
	          if(x%3!=0&&x%5!=0&&x%7==0)
	        	  System.out.println("��7����");
	          if(x%3!=0&&x%5!=0&&x%7!=0)
	        	  System.out.println("���ܱ�3,5,7��һ����");
	        }
		return 0;
	}
	public static void main(String[] args)
	{
		function abc=new function();
        abc.get(6);
	}
}
