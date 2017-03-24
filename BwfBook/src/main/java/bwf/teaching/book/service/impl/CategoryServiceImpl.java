package bwf.teaching.book.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import bwf.teaching.book.dao.CategoryDao;
import bwf.teaching.book.entity.Category;
import bwf.teaching.book.service.CategoryService;

@Service("cgService")
public class CategoryServiceImpl implements CategoryService {
	
	@Resource(name="cgDao")
	private CategoryDao categoryDao;

	@Override
	public List<Category> getAllCategories() {		
		return categoryDao.getAllCategories();
	}
	

	public CategoryDao getCategoryDao() {
		return categoryDao;
	}

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

}
