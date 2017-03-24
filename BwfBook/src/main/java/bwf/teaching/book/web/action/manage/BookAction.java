package bwf.teaching.book.web.action.manage;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import bwf.teaching.book.entity.Book;
import bwf.teaching.book.service.BookService;
import bwf.teaching.book.web.tool.Paging;
import bwf.teaching.book.web.tool.Tool;

@SuppressWarnings("serial")
@Controller("bookAction")
@Scope("prototype")
public class BookAction extends ActionSupport {
	
	private String pageNO; // list请求提交的获取第几页图书信息的代表第几页的参数	
	private int pageSize = 5; // 每页显示多少条图书信息，默认值为5
	private Map<String, Object> listResult; //list请求后，返回给前端的json结果
	
	private String title;
	private boolean exists;
	
	private Book book; // save请求的时候，用来封装提交的图书信息的参数
	private File bphoto; //使用和表单中文件域name属性相同的File类型的字段名，就能接受到上传的文件；如果没有上传文件，则该字段为null
	private String bphotoFileName;
	private String bphotoContentType;
	
	
	@Resource(name="bkService")
	private BookService bookService;
	
	
	public String mgr() throws Exception {
		return SUCCESS;
	}
	
	
	/* 处理一次获取分页图书信息列表的ajax请求的方法 */
	public String list() throws Exception {		
		Paging paging = new Paging(pageNO, pageSize, bookService.getTotalCount());		
		List<Book> books = bookService.getBooks(paging.getCurr(), paging.getSize());
		listResult = new HashMap<String, Object>();
		listResult.put("books", books);
		listResult.put("paging", paging);
		return SUCCESS;
	}

	/* 处理一次验证图书名是否已经存在的方法 */
	public String checkTitle() throws Exception {	
		System.out.println("title: " + title);
		this.exists = bookService.checkTitle(title);
		return SUCCESS;
	}
	
	/* 处理录入信息图书信息请求的方法 */
	public String save() throws Exception {
		
		if(bphoto != null) {
			String randomFileName = Tool.getRandFileName(bphotoFileName.substring(bphotoFileName.lastIndexOf(".")));			
			String path = ServletActionContext.getServletContext().getRealPath("/photo/" + randomFileName);
			FileUtils.copyFile(bphoto, new File(path));
			book.setPhoto(randomFileName);
		} else {
			book.setPhoto("default_photo.png");
		}
		
		bookService.save(book);
		ActionContext.getContext().put("saveTip", "图书信息录入成功");
		return INPUT;
	}


	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public boolean isExists() {
		return exists;
	}



	public void setExists(boolean exists) {
		this.exists = exists;
	}



	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public String getPageNO() {
		return pageNO;
	}

	public void setPageNO(String pageNO) {
		this.pageNO = pageNO;
	}


	public Map<String, Object> getListResult() {
		return listResult;
	}
	public void setListResult(Map<String, Object> listResult) {
		this.listResult = listResult;
	}



	public Book getBook() {
		return book;
	}


	public void setBook(Book book) {
		this.book = book;
	}


	public BookService getBookService() {
		return bookService;
	}
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}


	public File getBphoto() {
		return bphoto;
	}


	public void setBphoto(File bphoto) {
		this.bphoto = bphoto;
	}


	public String getBphotoFileName() {
		return bphotoFileName;
	}


	public void setBphotoFileName(String bphotoFileName) {
		this.bphotoFileName = bphotoFileName;
	}


	public String getBphotoContentType() {
		return bphotoContentType;
	}


	public void setBphotoContentType(String bphotoContentType) {
		this.bphotoContentType = bphotoContentType;
	}
	
	
	
	
}
