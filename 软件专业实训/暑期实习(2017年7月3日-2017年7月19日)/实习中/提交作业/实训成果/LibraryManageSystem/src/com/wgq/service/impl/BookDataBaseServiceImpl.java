package com.wgq.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wgq.dao.BookDataBaseDao;
import com.wgq.entity.Book;
import com.wgq.entity.Page;
import com.wgq.service.BookDataBaseService;

@Service
public class BookDataBaseServiceImpl implements BookDataBaseService {

	/**
	 * 表示Spring的自动注入
	 * 依赖注入（DI）：依赖【需要某个类对象】
	 * ,注入【Spring会自动创建并且注入到这个类对象文件中】
	 */
	@Resource
	private BookDataBaseDao dao;

	/**
	 * 请求一页数据，根据page对象里面设置的起始位置和偏移量
	 * @return 查询到的数据列表
	 */
	public List<Book> queryBookListByPage(Page page) {

		//第一次查询，只获取总条数
		Page sp=new Page();
		sp.setSearch(page.getSearch());
		List<Book> bs = dao.queryBookListByPage(sp);
		page.setCount(bs.size());
		//第二次查询，查询指定的N条
		return dao.queryBookListByPage(page);
	}

	/**
	 *添加指定ID的book
	 */
	@Override
	public int insertBook(Book book) {
		return dao.insertBook(book);
	}
		
	/**
	 * 删除指定ID的book
	 */
	@Override
	public int deleteBook(Integer id) {
		return dao.deleteBook(id);
	}
	
	/**
	 *更新指定ID的book
	 */
	@Override
	public int updateBook(Book book) {
		return dao.updateBook(book);
	}
}

