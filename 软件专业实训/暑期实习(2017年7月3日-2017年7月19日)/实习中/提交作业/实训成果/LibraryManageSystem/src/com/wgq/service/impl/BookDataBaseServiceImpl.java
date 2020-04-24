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
	 * ��ʾSpring���Զ�ע��
	 * ����ע�루DI������������Ҫĳ�������
	 * ,ע�롾Spring���Զ���������ע�뵽���������ļ��С�
	 */
	@Resource
	private BookDataBaseDao dao;

	/**
	 * ����һҳ���ݣ�����page�����������õ���ʼλ�ú�ƫ����
	 * @return ��ѯ���������б�
	 */
	public List<Book> queryBookListByPage(Page page) {

		//��һ�β�ѯ��ֻ��ȡ������
		Page sp=new Page();
		sp.setSearch(page.getSearch());
		List<Book> bs = dao.queryBookListByPage(sp);
		page.setCount(bs.size());
		//�ڶ��β�ѯ����ѯָ����N��
		return dao.queryBookListByPage(page);
	}

	/**
	 *���ָ��ID��book
	 */
	@Override
	public int insertBook(Book book) {
		return dao.insertBook(book);
	}
		
	/**
	 * ɾ��ָ��ID��book
	 */
	@Override
	public int deleteBook(Integer id) {
		return dao.deleteBook(id);
	}
	
	/**
	 *����ָ��ID��book
	 */
	@Override
	public int updateBook(Book book) {
		return dao.updateBook(book);
	}
}

