package treeSetÁ·Ï°02;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		TreeSet ts=new TreeSet(new MyComparator());
		ts.add("jack");
		ts.add("love");
		ts.add("rose");
		Iterator it=ts.iterator();//µü´úÆ÷
		while(it.hasNext()){
			System.out.println(it.next());
		}

	}

}
