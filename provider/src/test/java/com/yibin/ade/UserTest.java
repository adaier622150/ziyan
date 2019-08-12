package com.yibin.ade;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.yibin.ade.biz.user.UserBiz;
import com.yibin.ade.biz.vo.LoginVo;
import com.yibin.ade.biz.vo.RegisterVo;


public class UserTest extends BaseTest {

    @Resource
    private UserBiz userBiz;

    @Test
    public void register() {
        RegisterVo register = RegisterVo.builder()
                .userName("yibinzou")
                .nickName("邹益斌")
                .password("123qwe!@#")
                .confirmPass("123qwe!@#")
                .build();
        Assert.assertNotNull(userBiz.register(register));
    }

    @Test
    public void login() {
        LoginVo loginVo = new LoginVo();
        loginVo.setUserName("admin");
        loginVo.setPassword("kiWpEHQaRb9HfBN9YWMA");
        Assert.assertNotNull(userBiz.login(loginVo));
    }

    @Test
    public void detail() {
        String userName = "admin";
        Assert.assertNotNull(userBiz.detail(userName));
    }
}
