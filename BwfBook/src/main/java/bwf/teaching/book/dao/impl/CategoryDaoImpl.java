package bwf.teaching.book.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import bwf.teaching.book.dao.CategoryDao;
import bwf.teaching.book.entity.Category;

@Repository("cgDao")
public class CategoryDaoImpl extends BaseDao implements CategoryDao {

	@Override
	public List<Category> getAllCategories() {		
		return getCurrSession().createQuery("from Category", Category.class).list();
	}

}
