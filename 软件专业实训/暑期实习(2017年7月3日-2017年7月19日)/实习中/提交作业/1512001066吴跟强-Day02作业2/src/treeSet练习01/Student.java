package treeSetÁ·Ï°01;
import java.util.*;
public class Student implements Comparable {//Comparable½Ó¿Ú
	String name;
	int age;
	public Student(String name,int age){
		this.name=name;
		this.age=age;
	}
	public String toString(){
		return "name="+name+" : "+"age="+age;
	}
	public int compareTo(Object obj){
		Student s=(Student) obj;
		if(this.age-s.age>0)
			return 1;
		if(this.age-s.age==0)
			return this.name.compareTo(s.name);
		return -1;
	}

}
