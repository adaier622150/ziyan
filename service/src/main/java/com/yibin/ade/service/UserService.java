package com.yibin.ade.service;


import com.yibin.ade.service.entity.param.UserPo;

/**
 * @author yibin.zou Date: 2019/3/29 Time: 上午10:39
 */
public interface UserService {

	/**
	 * 根据userCode查询用户
	 *
	 * @param userCode
	 * @return
	 */
	UserPo queryByCode(String userCode);

	/**
	 * 根据userName查询用户
	 *
	 * @param userName
	 * @return
	 */
	UserPo queryByName(String userName);

	/**
	 * 新增用户
	 *
	 * @param userPo
	 * @return
	 */
	int save(UserPo userPo);
}
