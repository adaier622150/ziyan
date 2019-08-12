package com.yibin.ade.param;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yibin.zou Date: 2019/3/29 Time: 上午10:39
 */
@Getter
@Setter
@Builder
public class UserReps implements Serializable {

	private String userName;

	private String userCode;

	private String nickName;

}
