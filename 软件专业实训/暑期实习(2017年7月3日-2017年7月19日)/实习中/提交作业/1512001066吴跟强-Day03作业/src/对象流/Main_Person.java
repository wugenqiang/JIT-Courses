package 对象流;
import java.io.*;
public class Main_Person {

	public static void main(String[] args) throws Exception {
		Person p=new Person("p1","001",20);
		System.out.println("写入文件前：");
		System.out.println("Person对象的id:"+p.getId());
		System.out.println("Person对象的name:"+p.getName());
		System.out.println("Person对象的age:"+p.getAge());
		FileOutputStream fos=new FileOutputStream("test.txt");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(p);//写入
	}
}
