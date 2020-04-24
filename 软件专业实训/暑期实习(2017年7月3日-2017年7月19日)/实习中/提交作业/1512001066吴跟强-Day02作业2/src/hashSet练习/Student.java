package hashSet��ϰ;
import java.util.*;
public class Student {
	private String id;
	private String name;
	public Student(String id,String name){
		this.id=id;
		this.name=name;
	}
	public String toString(){
		return "id="+id+":"+"name="+name;
	}
	public int hashCode(){
		return id.hashCode();//����id���ԵĹ�ϣֵ
	}
	public boolean equals(Object obj){
		if(this==obj)
			return true;
		if(!(obj instanceof Student))
			return false;
		Student stu=(Student)obj;
		boolean b=this.id.equals(stu.id);
		return b;
	}
}
