package com.yibin.ade.param;

import lombok.*;

import java.io.Serializable;

/**
 * @author yibin.zou Date: 2019/3/29 Time: 上午10:39
 */
@Getter
@Setter
public class LoginReq implements Serializable {


	String userName;


	String password;

}
