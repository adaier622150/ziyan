package com.yibin.ade.provider;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.*;

import com.yibin.ade.adapter.UserAdapter;
import com.yibin.ade.biz.user.UserBiz;
import com.yibin.ade.param.LoginReq;
import com.yibin.ade.param.RegisterReq;
import com.yibin.ade.param.UserReps;

/**
 * @author yibin.zou Date: 2019/3/29 Time: 上午10:39
 */
@RestController
@RequestMapping("/course/user/")
public class UserController {

    @Resource
    private UserBiz userBiz;


    @PostMapping("register/v1")
    public UserReps register(@RequestBody RegisterReq registerReq) {
        return UserAdapter.adapt(userBiz.register(UserAdapter.adapt(registerReq)));
    }

    @PostMapping("login/v1")
    public UserReps login(@RequestBody LoginReq loginReq) {
        return UserAdapter.adapt(userBiz.login(UserAdapter.adapt(loginReq)));
    }

    @GetMapping("detail/v1")
    public UserReps detail(@RequestParam("userName") String userName) {
        return UserAdapter.adapt(userBiz.detail(userName));
    }


    @GetMapping("test/v1")
    public String test() {
        System.out.println("============ 来了老弟 ===========");
        return new String("来了老弟");
    }

}
