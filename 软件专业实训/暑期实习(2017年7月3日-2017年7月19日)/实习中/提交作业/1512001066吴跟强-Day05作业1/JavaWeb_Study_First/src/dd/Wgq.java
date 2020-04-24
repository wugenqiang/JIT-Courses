package dd;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Wgq extends HttpServlet {

	//private static final long serialVersionUID = -8497133460832056245L;
    /**
     * HttpServletRequest:��װ���û���������Ϣ��ȫ��Http��ͷ����
     * HttpServletResponse����װ�˲���Request����Ϣ�����з���������Ĺ��ܣ��������ݡ��ض��򡢵�ת�ȵȣ�
     * req��resp��tomcat����Tomcat��������
     */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//�涨���ص����ݸ�ʽ��html���ı����ݣ�ʹ�õı�����UTF-8��
		resp.setContentType("text/html;charset=UTF-8");
		//ͨ��HttpServletRequest��������ȡ�û�������Ϣ
		String name = req.getParameter("name");
		//��ȡ����������ڷ������ݸ��ͻ���
		PrintWriter out = resp.getWriter();
		if (name == null) {
			//�����ݷ��ͳ�ȥ
			out.write("����������");
		}else {
			out.write(name);
		}
	}
}
