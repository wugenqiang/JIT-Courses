package ������;
import java.io.*;
public class Main_Person {

	public static void main(String[] args) throws Exception {
		Person p=new Person("p1","001",20);
		System.out.println("д���ļ�ǰ��");
		System.out.println("Person�����id:"+p.getId());
		System.out.println("Person�����name:"+p.getName());
		System.out.println("Person�����age:"+p.getAge());
		FileOutputStream fos=new FileOutputStream("test.txt");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(p);//д��
	}
}
