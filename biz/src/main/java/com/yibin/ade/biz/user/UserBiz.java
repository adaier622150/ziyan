package com.yibin.ade.biz.user;

import java.util.Objects;

import javax.annotation.Resource;

import com.google.common.base.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.yibin.ade.biz.adapter.UserAdapter;
import com.yibin.ade.biz.vo.LoginVo;
import com.yibin.ade.biz.vo.RegisterVo;
import com.yibin.ade.biz.vo.UserVo;
import com.yibin.ade.commonn.constants.Constants;
import com.yibin.ade.commonn.utils.StringUtil;
import com.yibin.ade.service.UserService;
import com.yibin.ade.service.entity.param.UserPo;

/**
 * @author yibin.zou Date: 2019/3/29 Time: 上午10:39
 */
@Component
public class UserBiz {

    private static Logger LOGGER = LoggerFactory.getLogger(UserBiz.class);

    @Resource
    private UserService userService;

    @Value("${security.salt}")
    private String salt;

    public UserVo register(RegisterVo registerVo) {
        Preconditions.checkArgument(Objects.nonNull(registerVo), Constants.PARAM_NULL);
        Preconditions.checkArgument(Objects.equals(registerVo.getPassword(), registerVo.getConfirmPass()), Constants.PASSWORD_NOT_SAME);
        Preconditions.checkArgument(StringUtil.getStrLength(registerVo.getUserName()) <= Constants.NAME_MAX_LENGTH, Constants.USERNAME_TOO_LONG);
        Preconditions.checkArgument(StringUtil.validateStrRule(registerVo.getUserName()), Constants.VALIDATE_RULE_ERROR);
        Preconditions.checkArgument(StringUtil.getStrLength(registerVo.getPassword()) <= Constants.PASS_MAX_LENGTH, Constants.PASSWORD_TOO_LONG);
        Preconditions.checkArgument(StringUtil.checkPwd(registerVo.getPassword()), Constants.WEAK_PASSWORD);
        UserPo userPo = userService.queryByName(registerVo.getUserName());
        Preconditions.checkArgument(Objects.isNull(userPo), Constants.USER_EXIST);
        userPo = UserAdapter.adapt(registerVo, salt);
        Preconditions.checkArgument(Objects.equals(userService.save(userPo), Constants.INTEGER_ONE), Constants.SYSTEM_ERROR);
        return UserAdapter.adapt(userPo);
    }

    public UserVo login(LoginVo loginVo) {
        Preconditions.checkArgument(Objects.nonNull(loginVo), Constants.PARAM_NULL);
        Preconditions.checkArgument(!StringUtils.isEmpty(loginVo.getUserName()), Constants.PARAM_NULL);
        Preconditions.checkArgument(!StringUtils.isEmpty(loginVo.getPassword()), Constants.PARAM_NULL);
        UserPo userPo = userService.queryByName(loginVo.getUserName());
        Preconditions.checkArgument(Objects.nonNull(userPo), Constants.USER_NOT_EXIST);
        Preconditions.checkArgument(Objects.equals(
                StringUtil.encrypt(userPo.getUserCode() + loginVo.getPassword(), salt), userPo.getPassword()), Constants.PASSWORD_ERROR);
        return UserAdapter.adapt(userPo);
    }

    public UserVo detail(String userName) {
        Preconditions.checkArgument(!StringUtils.isEmpty(userName), Constants.PARAM_NULL);
        UserPo userPo = userService.queryByName(userName);
        Preconditions.checkArgument(Objects.nonNull(userPo), Constants.USER_NOT_EXIST);
        return UserAdapter.adapt(userPo);
    }


}
