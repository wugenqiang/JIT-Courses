package hashSet��ϰ;
import java.util.*;
public class Example01 {
	public static void main(String[] args) {
		HashSet set=new HashSet();
		set.add("001");//��set������ַ���
		set.add("002");
		set.add("003");
		set.add("003");//����ظ�Ԫ�أ���֤�Ƿ��ȡ
		//��ȡIterator����
		Iterator it=set.iterator();
		while(it.hasNext()){//�ж�it���Ƿ���Ԫ��
			//ͨ����������next()������ȡԪ��
			Object obj=it.next();
			System.out.println(obj);//��ӡ
		}

	}

}
