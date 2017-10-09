package cn.qlk.test.dao;


import cn.qlk.test.bean.User;

public interface UserMapper {

	/**
	 * 查询用户，并得到用户信息
	 * @param userName
	 * @return
	 * @throws Exception
	 */
	public User getUser(String userName) throws Exception;
	
 }
