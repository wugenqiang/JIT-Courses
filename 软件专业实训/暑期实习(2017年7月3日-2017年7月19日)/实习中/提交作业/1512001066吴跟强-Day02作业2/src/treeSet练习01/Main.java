package treeSetÁ·Ï°01;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		TreeSet ts=new TreeSet();
		ts.add(new Student("jack",18));
		ts.add(new Student("rose",16));
		Iterator it=ts.iterator();//µü´úÆ÷
		while(it.hasNext()){
			System.out.println(it.next());
		}

	}

}
