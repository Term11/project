package bwf.teaching.book.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import bwf.teaching.book.dao.BookDao;
import bwf.teaching.book.entity.Book;
import bwf.teaching.book.service.BookService;

@Service("bkService")
public class BookServiceImpl implements BookService {
	
	@Resource(name="bkDao")
	private BookDao bookDao;

	@Override
	public long getTotalCount() {		
		return bookDao.getTotalCount();
	}

	@Override
	public List<Book> getBooks(int pageCurr, int pageSize) {		
		return bookDao.getBooks(pageCurr, pageSize);
	}
	
	

	public BookDao getBookDao() {
		return bookDao;
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public boolean checkTitle(String title) {		
		return false;
	}

	@Override
	public void save(Book book) {		
		bookDao.add(book);
	}

}
