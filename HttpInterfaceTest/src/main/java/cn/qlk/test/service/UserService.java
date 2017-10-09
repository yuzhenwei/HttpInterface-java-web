package cn.qlk.test.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.qlk.test.bean.User;
import cn.qlk.test.dao.UserMapper;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	private final static Logger  logger = LoggerFactory.getLogger(CaseMangerService.class);
	/**
	 * 根据用户名查询用户
	 * @param userName
	 * @return
	 */
	public User getUser(String userName){
		User user=null;
		try {
			user = userMapper.getUser(userName);
			logger.debug("查询到用户的数据的信息"+userName);
				
		} catch (Exception e) {
			logger.debug("查询到用户时系统错误"+e);
			e.printStackTrace();
			return user;
		}
		
		return user;
	}
}
