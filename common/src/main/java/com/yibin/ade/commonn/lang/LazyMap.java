package com.yibin.ade.commonn.lang;

import java.util.concurrent.ConcurrentMap;

import com.google.common.collect.Maps;

/**
 * lazyMap
 *
 * @author wenwu.cao
 * @since 08 二月 2018
 */
public abstract class LazyMap<K, V> {

	private ConcurrentMap<K, V> map = Maps.newConcurrentMap();

	public V get(K key) {
		V value = map.get(key);
		if (value != null) {
			return value;
		}

		value = load(key);
		V existsValue = (value == null ? null : map.putIfAbsent(key, value));
		return existsValue == null ? value : existsValue;
	}

	protected abstract V load(K key);

}
