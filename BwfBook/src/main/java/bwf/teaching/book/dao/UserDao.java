package bwf.teaching.book.dao;

import bwf.teaching.book.entity.User;

public interface UserDao {
	
	/**
	 * 插入一条用户信息
	 * @param user
	 */
	void add(User user);
	
	User getUserByLoginId(String loginId);

}
