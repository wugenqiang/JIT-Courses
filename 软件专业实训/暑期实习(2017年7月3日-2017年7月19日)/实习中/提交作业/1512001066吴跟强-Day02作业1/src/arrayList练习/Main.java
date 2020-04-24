package arrayList¡∑œ∞;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Student> list=new ArrayList<Student>();
		for(int i=0;i<50;i++){
			list.add(new Student("001"+i,"–°"+i));
		}
		for(Student s:list){
			System.out.println(s.toString());
		}

	}

}
