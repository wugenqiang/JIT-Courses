package treeSet��ϰ02;
import java.util.*;
public class MyComparator implements Comparator{//Comparator�ӿ�
	public int compare(Object obj1,Object obj2){//ʵ�ֱȽϷ���
		String s1=(String)obj1;
		String s2=(String)obj2;
		int temp=s1.length()-s2.length();
		return temp;//����ֵ��1��-1,0
	}
}
