package com.yibin.ade.service.impl;

import javax.annotation.Resource;

import com.yibin.ade.service.dao.UserDao;
import com.yibin.ade.service.entity.param.UserPo;
import org.springframework.stereotype.Service;

import com.yibin.ade.service.UserService;

/**
 * @author yibin.zou Date: 2019/3/29 Time: 上午10:39
 */
@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;


	@Override
	public UserPo queryByCode(String userCode) {
		return userDao.queryByCode(userCode);
	}

	@Override
	public UserPo queryByName(String userName) {
		return userDao.queryByName(userName);
	}

	@Override
	public int save(UserPo user) {
		return userDao.save(user);
	}

}
