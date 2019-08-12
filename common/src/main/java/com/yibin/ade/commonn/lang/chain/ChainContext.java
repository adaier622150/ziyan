package com.yibin.ade.commonn.lang.chain;

import java.util.LinkedList;
import java.util.Map;

import org.springframework.util.CollectionUtils;

import com.google.common.collect.Maps;

/**
 * 处理器上下文内容
 *
 * @author yibin.zou Date: 2019/8/12 Time: 7:17 PM
 */
public class ChainContext<P, T> {

	/**
	 * 上下文窗口数据
	 */
	private ContextContainer contextContainer;

	/**
	 * 返回数据值
	 */
	private T resultData;

	/**
	 * 链式参数
	 */
	private P param;

	/**
	 * 链式Processor
	 */
	private LinkedList<ChainProcessor<P, T>> processor;

	private ChainContext(Builder<P, T> builder) {
		param = builder.param;
		processor = builder.processor;
		this.contextContainer = new ContextContainer() {

			Map<String, Object> container = Maps.newHashMap();

			@Override
			public <D> void addContextData(String key, D data) {
				container.put(key, data);
			}

			@Override
			public <D> D getContextData(String key, Class<D> dClass) {
				return dClass.cast(container.get(key));
			}
		};
	}

	public P getParam() {
		return param;
	}

	public LinkedList<ChainProcessor<P, T>> getProcessor() {
		return processor;
	}

	public T process() {
		if (CollectionUtils.isEmpty(this.getProcessor())) {
			return null;
		}
		ChainProcessor<P, T> next = this.getProcessor().poll();
		while (next != null) {
			next.process(this);
			next = this.getProcessor().poll();
		}

		return this.resultData;
	}


	public <D> void addContextData(String key, D data) {
		this.contextContainer.addContextData(key, data);
	}

	public <D> D getContextData(String key, Class<D> dClass) {
		return this.contextContainer.getContextData(key, dClass);
	}

	public T getResultData() {
		return resultData;
	}

	public void setResultData(T resultData) {
		this.resultData = resultData;
	}


	public static final class Builder<P, T> {
		private P param;

		private LinkedList<ChainProcessor<P, T>> processor;

		public Builder<P, T> param(P param) {
			this.param = param;
			return this;
		}

		public Builder<P, T> addNextProcessor(ChainProcessor<P, T> processor) {
			if (this.processor == null) {
				this.processor = new LinkedList<>();
			}
			this.processor.offer(processor);
			return this;
		}

		public ChainContext<P, T> build() {
			return new ChainContext<>(this);
		}
	}
}
