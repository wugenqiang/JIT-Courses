package com.wgq.dao;
import java.util.List;
import com.wgq.entity.Book;
import com.wgq.entity.Page;
	
	//申明Mybatis操作的方法
	//只做数据处理
public interface BookDataBaseDao {
	
	public List<Book> queryBookListByPage(Page page);
	public int insertBook(Book book);
	public int deleteBook(Integer id);
	public int updateBook(Book book);
}

