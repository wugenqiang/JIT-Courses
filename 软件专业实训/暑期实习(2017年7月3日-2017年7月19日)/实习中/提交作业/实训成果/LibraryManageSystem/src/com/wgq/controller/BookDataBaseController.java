package com.wgq.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wgq.entity.Book;
import com.wgq.entity.Page;
import com.wgq.service.BookDataBaseService;

/**
 * spring mvc处理方法支持的返回方式：ModelAndView, Model, ModelMap, Map,View, String, void
 * 	ModelAndView构造方法可以指定返回的页面名称，也可以通过setViewName()方法跳转到指定的页面 ,
 * 	使用addObject()设置需要返回的值，addObject()有几个不同参数的方法，可以默认和指定返回对象的名字。
 * 	调用addObject()方法将值设置到一个名为ModelMap的类属性，ModelMap是LinkedHashMap的子类
 * @author STAR
 *
 */
@ResponseBody
@Controller
@Scope("prototype")
public class BookDataBaseController {
	
	@Resource
	private BookDataBaseService service;

	/**
	 * 获取一页数据
	 * @param session
	 * @param offset 起始页
	 * @param limit 请求条数
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/booksPage.do")
	public Map<String,Object> toBookListPage(HttpSession session, Page page, ModelMap map) {
		List<Book> list = null;
		System.err.println("Limit:"+page.getLimit()+":"+"Offset:"+page.getOffset());
		Map<String,Object> result = new HashMap<String,Object>();
		list = service.queryBookListByPage(page);
		result.put("total",page.getCount());
        result.put("rows",list);
        System.out.println("总共"+list.size()+"条数据");
		return result;
	}
	
	/**
	 * 添加一条数据
	 * @param session
	 * @param book
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/bookInsert.do",produces="text/html;charset=UTF-8")
	public String bookInsert(HttpSession session, Book book, ModelMap map) {
		if (service.insertBook(book) == 1) {
			System.out.println("数据添加成功:"+book.toString());
			return "<h2>数据添加成功</h2>";
			}
		return "{\"status\":\"success\",\"data\":\"\"}";
	}
	
	/**
	 * 删除数据
	 * @param session
	 * @param book
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/bookDelete.do")
	public String delete(HttpSession session, HttpServletRequest resq, ModelMap map) {
		String[] ids = resq.getParameterValues("id");
		for (String id : ids) {
			if (service.deleteBook(new Integer(id)) == 1) {
				System.out.println("数据删除成功：ID="+id);
			}else{
				return "{\"status\":\"error\",\"data\":\"数据删除失败\"}";
			}
		}
		return "{\"status\":\"success\",\"data\":\"数据删除成功\"}";
	}
	
	/**
	 * 更新数据
	 * @param session
	 * @param book
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/bookUpdate.do",produces="text/html;charset=UTF-8")
	public String bookUpdate(HttpSession session, Book book, ModelMap map) {
		if (service.updateBook(book) == 1) {
			System.out.println("数据更新成功:"+book.toString());
			return "<h2>数据更新成功</h2>";
			}
		return "{\"status\":\"success\",\"data\":\"\"}";
	}
}
