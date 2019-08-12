package com.yibin.ade.commonn.constants;

/**
 * @author yibin.zou Date: 2019/3/29 Time: 上午10:39
 */
public interface Constants {

	int PASS_MAX_LENGTH = 128;

	int PASS_MIN_LENGTH = 10;

	int NAME_MAX_LENGTH = 16;

	int INTEGER_ONE = 1;

	int STATE_INVALID = 0;

	int STATE_VALID = 1;

	String EMPTY = "";

	String PARAM_NULL = "参数不能为空";

	String SYSTEM_ERROR = "系统错误";

	String PASSWORD_ERROR = "密码不正确";

	String USER_NOT_EXIST = "用户不存在";

	String USER_EXIST = "此用户名已存在";

	String VALIDATE_RULE_ERROR = "用户名只能由数字、英文字母（英文字母大小写不敏感）及汉字组成";

	String USERNAME_TOO_LONG = "用户名长度超出限制";

	String PASSWORD_TOO_LONG = "密码长度超出限制";

	String WEAK_PASSWORD = "密码过于简单";

	String PASSWORD_NOT_SAME = "两次密码不一致";


}
