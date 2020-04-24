package com.wgq.dao;
import java.util.List;
import com.wgq.entity.Book;
import com.wgq.entity.Page;
	
	//����Mybatis�����ķ���
	//ֻ�����ݴ���
public interface BookDataBaseDao {
	
	public List<Book> queryBookListByPage(Page page);
	public int insertBook(Book book);
	public int deleteBook(Integer id);
	public int updateBook(Book book);
}

