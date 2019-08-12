package com.yibin.ade.service.entity.param;

import java.io.Serializable;
import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author yibin.zou Date: 2019/3/29 Time: 上午10:39
 */
@Getter
@Setter
@Builder
public class UserPo implements Serializable {


	private Integer id;


	private String userName;

	private String userCode;

	private String nickName;

	private String password;

	private int valid;

	private Date createTime;

	private Date updateTime;
}
