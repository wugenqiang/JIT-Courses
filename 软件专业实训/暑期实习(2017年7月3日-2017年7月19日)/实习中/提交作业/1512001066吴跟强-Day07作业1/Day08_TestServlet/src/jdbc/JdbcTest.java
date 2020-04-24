package jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@SuppressWarnings("serial")
public class JdbcTest extends HttpServlet {
	
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3307/bookdb?useUnicode=true&characterEncoding=UTF-8";
	private String sql = "select * from user";
    
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection con=null;
		ResultSet result=null;
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out=resp.getWriter();
		try{
			//注册
			Class.forName(driver);
			//获取连接
			con=DriverManager.getConnection(url,"root","154326");
			//获取Startment
			Statement state=con.createStatement();
			//执行
			result=state.executeQuery(sql);
			//JSON数据格式
			//JSON里面对象（键值对）、数组（单个的数据）
			String json="";
			List<User> list = new ArrayList<User>();
			Gson gson=new Gson();
			while(result.next()){//显示结果集的内容
				User user = new User();
				user.setId(result.getInt("id"));
				user.setName(result.getString("name"));
				user.setNickname(result.getString("nickname"));
				user.setPassword(result.getString("password"));
				user.setSex(result.getInt("sex"));
				user.setAge(result.getInt("age"));
				user.setUsertype(result.getInt("usertype"));
				list.add(user);
			}
			
			json=gson.toJson(list);
			out.println(json);
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
