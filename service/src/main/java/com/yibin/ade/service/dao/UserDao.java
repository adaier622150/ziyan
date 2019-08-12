package com.yibin.ade.service.dao;

import com.yibin.ade.service.entity.param.UserPo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


/**
 * @author yibin.zou Date: 2019/3/29 Time: 上午10:39
 */
@Repository
public interface UserDao {

	/**
	 * 根据userCode查询用户
	 *
	 * @param userCode
	 * @return
	 */
	@Select("SELECT id as id ,user_name as userName, user_code as userCode, nick_name as nickName, password as password, " +
			" valid as valid, create_time as createTime, update_time as updateTime FROM user WHERE user_code = #{userCode}")
	UserPo queryByCode(@Param("userCode") String userCode);

	/**
	 * 根据userName查询用户
	 *
	 * @param userName
	 * @return
	 */
	@Select("SELECT id as id , user_name as userName, user_code as userCode, nick_name as nickName, password as password, " +
			" valid as valid, create_time as createTime, update_time as updateTime FROM user WHERE user_name = #{userName}")
	UserPo queryByName(@Param("userName") String userName);

	/**
	 * 新增用户信息
	 *
	 * @param user
	 * @return
	 */
	@Insert("INSERT INTO user(user_name, password, user_code, nick_name, valid) VALUES(#{user.userName}, #{user.password}, " +
			"#{user.userCode}, #{user.nickName}, #{user.valid})")
	int save(@Param("user") UserPo user);

}
