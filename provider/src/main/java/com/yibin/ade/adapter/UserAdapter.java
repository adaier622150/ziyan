package com.yibin.ade.adapter;

import java.util.Objects;

import com.yibin.ade.biz.vo.LoginVo;
import com.yibin.ade.biz.vo.RegisterVo;
import com.yibin.ade.biz.vo.UserVo;
import com.yibin.ade.param.LoginReq;
import com.yibin.ade.param.RegisterReq;
import com.yibin.ade.param.UserReps;

/**
 * @author yibin.zou Date: 2019/3/29 Time: 上午10:39
 */
public class UserAdapter {

	public static RegisterVo adapt(RegisterReq registerReq) {
		if (Objects.isNull(registerReq)) {
			return null;
		}
		return RegisterVo.builder()
				.userName(registerReq.getUserName())
				.nickName(registerReq.getNickName())
				.confirmPass(registerReq.getConfirmPass())
				.password(registerReq.getPassword())
				.build();
	}

	public static LoginVo adapt(LoginReq loginReq) {
		if (Objects.isNull(loginReq)) {
			return null;
		}
		return LoginVo.builder()
				.password(loginReq.getPassword())
				.userName(loginReq.getUserName())
				.build();
	}

	public static UserReps adapt(UserVo vo) {
		if (Objects.isNull(vo)) {
			return null;
		}
		return UserReps.builder()
				.userName(vo.getUserName())
				.userCode(vo.getUserCode())
				.nickName(vo.getNickName())
				.build();
	}

}
