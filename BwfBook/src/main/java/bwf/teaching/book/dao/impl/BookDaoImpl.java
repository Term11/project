package bwf.teaching.book.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import bwf.teaching.book.dao.BookDao;
import bwf.teaching.book.entity.Book;

@Repository("bkDao")
public class BookDaoImpl extends BaseDao implements BookDao {

	@Override
	public long getTotalCount() {	
		return (long)getCurrSession().createQuery("select count(b) from Book b").uniqueResult();
	}

	@Override
	public List<Book> getBooks(int pageCurr, int pageSize) {		
		return getCurrSession().createQuery("from Book b left join fetch b.category", Book.class)
				.setFirstResult((pageCurr - 1) * pageSize)
				.setMaxResults(pageSize)
				.list();
	}

	@Override
	public void add(Book book) {
		getCurrSession().save(book);
		
	}

}
