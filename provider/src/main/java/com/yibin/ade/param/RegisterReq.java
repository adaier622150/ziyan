package com.yibin.ade.param;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author yibin.zou Date: 2019/3/29 Time: 上午10:39
 */
@Getter
@Setter
public class RegisterReq implements Serializable {


	String userName;

	String nickName;

	String password;

	String confirmPass;

}
