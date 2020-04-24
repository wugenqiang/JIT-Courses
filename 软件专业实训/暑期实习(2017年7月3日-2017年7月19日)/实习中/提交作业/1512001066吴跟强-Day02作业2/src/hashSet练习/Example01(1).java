package hashSet练习;
import java.util.*;
public class Example01 {
	public static void main(String[] args) {
		HashSet set=new HashSet();
		set.add("001");//向set中添加字符串
		set.add("002");
		set.add("003");
		set.add("003");//添加重复元素，验证是否读取
		//获取Iterator对象
		Iterator it=set.iterator();
		while(it.hasNext()){//判断it中是否有元素
			//通过迭代器的next()方法获取元素
			Object obj=it.next();
			System.out.println(obj);//打印
		}

	}

}
