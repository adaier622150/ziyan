package com.yibin.ade.commonn.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapType;
import com.google.common.base.Strings;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yibin.zou Date: 2019/8/12 Time: 8:43 PM
 */
public class JsonUtil {

    public static ObjectMapper jsonMapper = new ObjectMapper();

    private JsonUtil() {
    }

    public static ObjectMapper instance() {
        return jsonMapper;
    }

    public static String of(Object o) throws JsonProcessingException {
        return jsonMapper.writeValueAsString(o);
    }

    @SuppressWarnings("unchecked")
    public static <T> T of(String json, Class<T> tClass) throws IOException {
        if (Strings.isNullOrEmpty(json)) {
            return null;
        }
        return jsonMapper.readValue(json, tClass);
    }

    public static <T> T of(String json, TypeReference<T> reference) throws IOException {
        if (Strings.isNullOrEmpty(json)) {
            return null;
        }
        return jsonMapper.readerFor(reference).readValue(json);
    }

    public static <T> T of(String json, Class<T> clazz, Module module) throws IOException {
        if (Strings.isNullOrEmpty(json)) {
            return null;
        }
        jsonMapper.registerModule(module);
        return jsonMapper.readerFor(clazz).readValue(json);
    }

    public static <T> List<T> ofList(String json, Class<T> tClass) throws IOException {
        if (Strings.isNullOrEmpty(json)) {
            return null;
        }
        JavaType javaType = jsonMapper.getTypeFactory().constructParametrizedType(ArrayList.class, ArrayList.class,
                tClass);
        return jsonMapper.readValue(json, javaType);
    }

    public static <K, V> Map<K, V> ofMap(String json, Class<K> keyClass, Class<V> valueClass) throws IOException {
        if (Strings.isNullOrEmpty(json)) {
            return null;
        }
        MapType mapType = jsonMapper.getTypeFactory().constructMapType(HashMap.class, keyClass, valueClass);
        return jsonMapper.readValue(json, mapType);
    }

    public static String toJson(Object obj) throws JsonProcessingException {
        if (null == obj) {
            return null;
        }
        return jsonMapper.writeValueAsString(obj);
    }
}
