package com.yibin.ade.commonn.enums;

/**
 *
 * @author yibin.zou Date: 2019/8/12 Time: 7:17 PM
 */
public class DictImpl<T> implements Dict<T> {

	private static final long serialVersionUID = -2595348814148479535L;

	private T type;

	private String desc;

	private DictImpl(T type, String desc) {
		this.type = type;
		this.desc = desc;
	}

	public static DictImpl<Integer> of(int type, String desc) {
		return new DictImpl<>(type, desc);
	}

	public static DictImpl<String> of(String type, String desc) {
		return new DictImpl<>(type, desc);
	}

	@Override
	public T getType() {
		return type;
	}

	public void setType(T type) {
		this.type = type;
	}

	@Override
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
