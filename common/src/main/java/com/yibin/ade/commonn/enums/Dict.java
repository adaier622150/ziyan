package com.yibin.ade.commonn.enums;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Objects;

import com.yibin.ade.commonn.lang.LazyMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.util.Pair;

/**
 * 数据字典接口
 *
 * @author yibin.zou Date: 2019/8/12 Time: 7:17 PM
 */
public interface Dict<T> extends Serializable {

	Logger logger = LoggerFactory.getLogger(Dict.class);

	/**
	 * 返回字段type 相当于key
	 * @return key
	 */
	T getType();

	/**
	 * @return type desc
	 */
	String getDesc();


	/**
	 * 通过type拿到Dict实例
	 * @param type type
	 * @param dict dict class对象
	 * @return dict 实例
	 */
	static Dict codeOf(Integer type, Class<? extends Dict> dict) {
		if (type == null) {
			return null;
		}
		return lazyMap.get(new Pair<>(type + "", dict));
	}

	/**
	 * 通过type拿到Dict实例
	 * @param type type
	 * @param dict dict class对象
	 * @return dict 实例
	 */
	static Dict codeOf(String type, Class<? extends Dict> dict) {
		if (type == null) {
			return null;
		}
		return lazyMap.get(new Pair<>(type, dict));
	}

	LazyMap<Pair<String, Class<? extends Dict>>, Dict> lazyMap = new LazyMap<Pair<String, Class<? extends Dict>>, Dict>() {
		@Override
		protected Dict load(Pair<String, Class<? extends Dict>> key) {
			String type = key.getKey();
			Class dict = key.getValue();
			if (dict == null || !dict.isInterface()) {
				throw new RuntimeException("dict code of fail");
			}
			if (!Dict.class.isAssignableFrom(dict)) {
				logger.warn("not from dict, type :{} ,class:{} ", type, dict);
				throw new RuntimeException(String.format("dict find fail,dict is not extend dict, type :%s ,class:%s ", type, dict));
			}
			Field[] fields = dict.getFields();
			if (fields == null || fields.length == 0) {
				throw new RuntimeException(String.format("dict find fail,fields is empty, type :%s ,class:%s ", type, dict));
			}
			try {
				for (Field field : fields) {
					if (Dict.class.isAssignableFrom(field.getType())) {
						Dict dictTemp = (Dict) field.get(dict);
						if (Objects.equals(String.valueOf(dictTemp.getType()), type)) {
							logger.info("find dict,type:{},temp:{} ", type, dictTemp);
							return dictTemp;
						}
					}
				}
			}
			catch (IllegalAccessException e) {
				throw new RuntimeException(String.format("dict find fail, type :%s ,class:%s ", type, dict));
			}
			return null;
		}
	};
}
