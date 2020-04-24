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
     * HttpServletRequest:封装了用户的请求信息（全部Http的头部）
     * HttpServletResponse：封装了部分Request的信息，带有服务器特殊的功能（返回数据、重定向、调转等等）
     * req和resp给tomcat，有Tomcat来负责处理
     */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//规定返回的数据格式（html的文本内容，使用的编码是UTF-8）
		resp.setContentType("text/html;charset=UTF-8");
		//通过HttpServletRequest对象来获取用户请求信息
		String name = req.getParameter("name");
		//获取输出流，用于返回数据给客户端
		PrintWriter out = resp.getWriter();
		if (name == null) {
			//把数据发送出去
			out.write("参数不存在");
		}else {
			out.write(name);
		}
	}
}
