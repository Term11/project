package bwf.teaching.book.dao;

import java.util.List;

import bwf.teaching.book.entity.Book;

public interface BookDao {

	long getTotalCount();

	List<Book> getBooks(int pageCurr, int pageSize);

	void add(Book book);

}
