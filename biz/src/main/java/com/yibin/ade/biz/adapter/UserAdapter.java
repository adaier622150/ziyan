package com.yibin.ade.biz.adapter;

import java.util.Objects;
import java.util.UUID;

import com.yibin.ade.biz.vo.RegisterVo;
import com.yibin.ade.biz.vo.UserVo;
import com.yibin.ade.commonn.constants.Constants;
import com.yibin.ade.commonn.utils.StringUtil;
import com.yibin.ade.service.entity.param.UserPo;

/**
 * @author yibin.zou Date: 2019/3/29 Time: 上午10:39
 */
public class UserAdapter {

	public static UserPo adapt(RegisterVo registerVo, String salt) {
		if (Objects.isNull(registerVo)) {
			return null;
		}
		UserPo userPo = UserPo.builder()
				.userName(registerVo.getUserName())
				.nickName(registerVo.getNickName())
				.userCode(UUID.randomUUID().toString())
				.valid(Constants.STATE_VALID)
				.build();
		userPo.setPassword(StringUtil.encrypt(userPo.getUserCode() + registerVo.getPassword(), salt));
		return userPo;
	}

	public static UserVo adapt(UserPo po) {
		if (Objects.isNull(po)) {
			return null;
		}
		return UserVo.builder()
				.userName(po.getUserName())
				.userCode(po.getUserCode())
				.nickName(po.getNickName())
				.build();
	}

}
