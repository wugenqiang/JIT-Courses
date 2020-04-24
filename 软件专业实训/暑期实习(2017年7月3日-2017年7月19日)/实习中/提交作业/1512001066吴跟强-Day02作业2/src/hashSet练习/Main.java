package hashSetÁ·Ï°;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		HashSet hs=new HashSet();
		Student stu1=new Student("1","jack");
		Student stu2=new Student("2","tom");
		Student stu3=new Student("3","rose");
		hs.add(stu1);
		hs.add(stu2);
		hs.add(stu3);
		System.out.println(hs);
	}

}
