package bwf.teaching.book.dao;

import java.util.List;

import bwf.teaching.book.entity.User;

public interface UserDao {
	
	/**
	 * 插入一条用户信息
	 * @param user
	 */
	void add(User user);
	
	/**
	 * 分页查询用户信息
	 * @param pageCurr 第几页
	 * @param pageSize 每页几条
	 * @return
	 */
	List<User> getUsers(int pageCurr, int pageSize);

}
