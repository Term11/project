package bwf.teaching.book.service;

import java.util.List;

import bwf.teaching.book.entity.Book;

public interface BookService {

	/**
	 * 获取图书信息的总数量
	 * 
	 * @return 总数量
	 */
	long getTotalCount();

	/**
	 * 分页获取图书信息列表
	 * @param pageCurr 当前页数
	 * @param pageSize 每页显示条数
	 * @return 当前页数的图书信息列表
	 */
	List<Book> getBooks(int pageCurr, int pageSize);

	boolean checkTitle(String title);

	void save(Book book);

}
