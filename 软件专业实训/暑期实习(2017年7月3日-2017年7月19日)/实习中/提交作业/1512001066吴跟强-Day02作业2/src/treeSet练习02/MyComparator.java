package treeSet练习02;
import java.util.*;
public class MyComparator implements Comparator{//Comparator接口
	public int compare(Object obj1,Object obj2){//实现比较方法
		String s1=(String)obj1;
		String s2=(String)obj2;
		int temp=s1.length()-s2.length();
		return temp;//返回值：1，-1,0
	}
}
