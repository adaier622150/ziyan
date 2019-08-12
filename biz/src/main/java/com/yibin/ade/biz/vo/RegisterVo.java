package com.yibin.ade.biz.vo;

import java.io.Serializable;

import lombok.*;

/**
 * @author yibin.zou Date: 2019/3/29 Time: 上午10:39
 */
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RegisterVo implements Serializable {


	String userName;

	String nickName;

	String password;

	String confirmPass;

}
