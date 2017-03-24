package bwf.teaching.book.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import bwf.teaching.book.dao.AdminDao;
import bwf.teaching.book.entity.Admin;
import bwf.teaching.book.service.AdminService;

@Service("adService")
public class AdminServiceImpl implements AdminService {
	
	@Resource(name="adDao")
	private AdminDao adminDao;

	@Override
	public Admin loginCheck(String loginId, String loginPsw) {
		Admin admin = adminDao.getAdminByLoginId(loginId);
		if(admin != null && admin.getLoginPsw().equals(loginPsw)) {
			return admin;
		}		
		return null;
	}

}
