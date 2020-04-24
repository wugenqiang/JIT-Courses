package homework;
import java.util.*;
public class Damo1 {

	public static void main(String[] args) throws Exception {	
		
		//1,String类操作：
		String str="暑期一开始实训的第一天作业";
		//返回指定字符在此字符串中第一次出现处的索引
        System.out.println("'一'字符第一次出现的位置是："+str.indexOf('一'));
        //返回指定字符在此字符串中最后一次出现处的索引
        System.out.println("'一'字符最后一次出现的位置是："+str.lastIndexOf('一'));
        //返回index位置上的字符
        System.out.println("字符串索引值为2的字符是："+str.charAt(2));
        //判断此字符串是否以指定的字符串结尾
        System.out.println("字符串是否 以“作业”结尾："+str.endsWith("作业"));
        //返回字符串的长度
        System.out.println("字符串的长度为："+str.length());
        //将此字符串和与指定的字符串比较
        String str2=new String("暑期一开始实训的第一天作业");
        System.out.println("str和str2比较是否相同："+str.equals(str2));
        //当且仅当字符串长度为0时,返回true
        System.out.println("字符串的长度是否为空："+str.isEmpty());
        //判断此字符串以指定的字符串开始
        System.out.println("该字符串是否以“暑期”开头："+str.startsWith("暑期"));
        //判断此字符串是否包含指定序列
        System.out.println("该字符串是否包含“第一天”"+str.contains("第一天"));
        
        //将String中的所有字符转换为小写
        String str3=new String("wETGGGH");
        System.out.println("将String中的所有字符转换为小写为："+str3.toLowerCase());
        //将String中的所有字符转换为大写
        System.out.println("将String中的所有字符转换为大写为："+str3.toUpperCase());
        //返回int参数的字符串表达方式
        System.out.println(str3.valueOf(2));
        //将字符串转换成字符数组
        System.out.println("将字符串转换成字符数组，转换后为："+str3.toCharArray());
        //返回新的字符串，通过替换
        System.out.println("将b替换T后，字符串为："+str3.replace('T','b'));
        //分割
        String str4[]={"wwwhhkhffdds","2222"};
        System.out.println(str4[0].split("hk"));
        //返回新字符串，从beginindex开始
        System.out.println(str3.substring(2));
        //返回新字符串，从beginindex开始，到endindex结束
        System.out.println(str3.substring(2,5));
        //返回新字符串，去除原字符串首尾的空格
        String str5=new String(" wETGGGH  ");
        System.out.println(str5.trim());
        
        //2,StringBuffer类
        StringBuffer a=new StringBuffer("shhisijd");
        //添加参数到StringBuffer对象中
        System.out.println(a.append('e'));
        //将字符串中的offset插入字符串
        System.out.println(a.insert(5,"ssc"));
        //移除此序列指定位置字符
        System.out.println(a.deleteCharAt(2));
        //删除指定范围内的字符或字符串
        System.out.println(a.delete(2,5));
        //替换
        System.out.println(a.replace(2,3,"thanks"));
        //修改指定位置的字符序列
        a.setCharAt(5,'e');
        System.out.println(a);
        //返回StringBuffer缓冲区中的字符串
        System.out.println(a.toString());
        //将此字符序列用其反转形式取代
        System.out.println(a.reverse());
        
        //3,System类
        long startTime=System.currentTimeMillis();//返回long类型的值，与1970年1月1日的时间差
        System.out.println(startTime);
        
        //获取当前系统属性
        Properties properties=System.getProperties();
        //获取key，返回Enumeration对象
        Enumeration propertyNames=properties.propertyNames();
        while (propertyNames.hasMoreElements()){
        	//获取系统属性的key
        	String key=(String) propertyNames.nextElement();
        	//获取value
        	String value=System.getProperty(key);
        	System.out.println(key +"-->"+value);
        }
        
        //4,Runtime类
        Runtime rt=Runtime.getRuntime();//创建实例对象，获取
        Process process=rt.exec("notepad.exe");//打开记事本
        Thread.sleep(3000);
        process.destroy();
        
        //5,Date类
        Date date1=new Date();
        Date date2=new Date(1000000000);
        System.out.println(date1);//当前的日期时间
        System.out.println(date2);//自1970年1月1日之后1000000000ms后的日期和时间
        
	}

}
