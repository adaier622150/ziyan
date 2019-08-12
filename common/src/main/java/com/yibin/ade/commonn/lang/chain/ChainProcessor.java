package com.yibin.ade.commonn.lang.chain;

/**
 * 链链处理器
 *
 * @author yibin.zou Date: 2019/8/12 Time: 7:17 PM
 */
public interface ChainProcessor<P, T> {

	void process(ChainContext<P, T> context);

}
