package homework;
import java.util.*;
public class Damo1 {

	public static void main(String[] args) throws Exception {	
		
		//1,String�������
		String str="����һ��ʼʵѵ�ĵ�һ����ҵ";
		//����ָ���ַ��ڴ��ַ����е�һ�γ��ִ�������
        System.out.println("'һ'�ַ���һ�γ��ֵ�λ���ǣ�"+str.indexOf('һ'));
        //����ָ���ַ��ڴ��ַ��������һ�γ��ִ�������
        System.out.println("'һ'�ַ����һ�γ��ֵ�λ���ǣ�"+str.lastIndexOf('һ'));
        //����indexλ���ϵ��ַ�
        System.out.println("�ַ�������ֵΪ2���ַ��ǣ�"+str.charAt(2));
        //�жϴ��ַ����Ƿ���ָ�����ַ�����β
        System.out.println("�ַ����Ƿ� �ԡ���ҵ����β��"+str.endsWith("��ҵ"));
        //�����ַ����ĳ���
        System.out.println("�ַ����ĳ���Ϊ��"+str.length());
        //�����ַ�������ָ�����ַ����Ƚ�
        String str2=new String("����һ��ʼʵѵ�ĵ�һ����ҵ");
        System.out.println("str��str2�Ƚ��Ƿ���ͬ��"+str.equals(str2));
        //���ҽ����ַ�������Ϊ0ʱ,����true
        System.out.println("�ַ����ĳ����Ƿ�Ϊ�գ�"+str.isEmpty());
        //�жϴ��ַ�����ָ�����ַ�����ʼ
        System.out.println("���ַ����Ƿ��ԡ����ڡ���ͷ��"+str.startsWith("����"));
        //�жϴ��ַ����Ƿ����ָ������
        System.out.println("���ַ����Ƿ��������һ�족"+str.contains("��һ��"));
        
        //��String�е������ַ�ת��ΪСд
        String str3=new String("wETGGGH");
        System.out.println("��String�е������ַ�ת��ΪСдΪ��"+str3.toLowerCase());
        //��String�е������ַ�ת��Ϊ��д
        System.out.println("��String�е������ַ�ת��Ϊ��дΪ��"+str3.toUpperCase());
        //����int�������ַ�����﷽ʽ
        System.out.println(str3.valueOf(2));
        //���ַ���ת�����ַ�����
        System.out.println("���ַ���ת�����ַ����飬ת����Ϊ��"+str3.toCharArray());
        //�����µ��ַ�����ͨ���滻
        System.out.println("��b�滻T���ַ���Ϊ��"+str3.replace('T','b'));
        //�ָ�
        String str4[]={"wwwhhkhffdds","2222"};
        System.out.println(str4[0].split("hk"));
        //�������ַ�������beginindex��ʼ
        System.out.println(str3.substring(2));
        //�������ַ�������beginindex��ʼ����endindex����
        System.out.println(str3.substring(2,5));
        //�������ַ�����ȥ��ԭ�ַ�����β�Ŀո�
        String str5=new String(" wETGGGH  ");
        System.out.println(str5.trim());
        
        //2,StringBuffer��
        StringBuffer a=new StringBuffer("shhisijd");
        //��Ӳ�����StringBuffer������
        System.out.println(a.append('e'));
        //���ַ����е�offset�����ַ���
        System.out.println(a.insert(5,"ssc"));
        //�Ƴ�������ָ��λ���ַ�
        System.out.println(a.deleteCharAt(2));
        //ɾ��ָ����Χ�ڵ��ַ����ַ���
        System.out.println(a.delete(2,5));
        //�滻
        System.out.println(a.replace(2,3,"thanks"));
        //�޸�ָ��λ�õ��ַ�����
        a.setCharAt(5,'e');
        System.out.println(a);
        //����StringBuffer�������е��ַ���
        System.out.println(a.toString());
        //�����ַ��������䷴ת��ʽȡ��
        System.out.println(a.reverse());
        
        //3,System��
        long startTime=System.currentTimeMillis();//����long���͵�ֵ����1970��1��1�յ�ʱ���
        System.out.println(startTime);
        
        //��ȡ��ǰϵͳ����
        Properties properties=System.getProperties();
        //��ȡkey������Enumeration����
        Enumeration propertyNames=properties.propertyNames();
        while (propertyNames.hasMoreElements()){
        	//��ȡϵͳ���Ե�key
        	String key=(String) propertyNames.nextElement();
        	//��ȡvalue
        	String value=System.getProperty(key);
        	System.out.println(key +"-->"+value);
        }
        
        //4,Runtime��
        Runtime rt=Runtime.getRuntime();//����ʵ�����󣬻�ȡ
        Process process=rt.exec("notepad.exe");//�򿪼��±�
        Thread.sleep(3000);
        process.destroy();
        
        //5,Date��
        Date date1=new Date();
        Date date2=new Date(1000000000);
        System.out.println(date1);//��ǰ������ʱ��
        System.out.println(date2);//��1970��1��1��֮��1000000000ms������ں�ʱ��
        
	}

}
