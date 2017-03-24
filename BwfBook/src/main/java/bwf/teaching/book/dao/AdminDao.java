package bwf.teaching.book.dao;

import bwf.teaching.book.entity.Admin;

public interface AdminDao {

	/**
	 * 根据管理员登录账号，查询管理员详细信息
	 * @param loginId 指定的账号
	 * @return 封装了管理员详细信息的Admin对象，如果没有查询到，则返回null
	 */
	Admin getAdminByLoginId(String loginId);

}
