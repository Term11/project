package bwf.teaching.book.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import bwf.teaching.book.dao.AdminDao;
import bwf.teaching.book.entity.Admin;

@Repository("adDao")
public class AdminDaoImpl extends BaseDao implements AdminDao {

	@Override
	public Admin getAdminByLoginId(String loginId) {	
		List<Admin> list = getCurrSession().createQuery("from Admin ad where ad.loginId = :loginId", Admin.class).setParameter("loginId", loginId).list();
		return list.isEmpty() ? null : list.get(0);
	}
	
	public void add(Admin admin) {
		getCurrSession().save(admin);
	}

}
