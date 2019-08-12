package com.yibin.ade.commonn.lang.chain;

/**
 * 上下文容器
 *
 * @author yibin.zou Date: 2019/8/12 Time: 7:17 PM
 */
public interface ContextContainer {

	/**
	 * 增加上下数据
	 * @param key
	 * @param data
	 * @param <D>
	 */
	<D> void addContextData(String key, D data);

	/**
	 * 获取上下文数据
	 * @param key
	 * @param <D>
	 * @return
	 */
	<D> D getContextData(String key, Class<D> dClass);
}
