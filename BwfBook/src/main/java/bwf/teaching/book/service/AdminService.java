package bwf.teaching.book.service;

import bwf.teaching.book.entity.Admin;

public interface AdminService {

	/**
	 * 管理员登录验证的方法
	 * @param loginId 要验证的账号
	 * @param loginPsw 要验证的密码
	 * @return 验证后的管理员详细信息，封装到Admin对象中，如果验证失败，则返回null。
	 */
	Admin loginCheck(String loginId, String loginPsw);

}
