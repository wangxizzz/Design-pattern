package com.code.refactoring.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.google.common.base.Splitter;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.util.List;
import java.util.Map;

/**
 * @Author wangxi
 * @Time 2019/10/20 13:42
 * Json相关操作
 */
public class JsonUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtil.class);

    private static final ObjectMapper DEFAULT_MAPPER = new ObjectMapper();


    public static String toJson(Object o) {
        return toJson(DEFAULT_MAPPER, o);
    }

    public static String toJson(ObjectMapper mapper, Object o) {
        if (o == null) {
            return null;
        }
        try {
            return mapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            LOGGER.error(e.getMessage(), e);
            return null;
        }
    }

    public static String toJson(Object o, String... excludes) {
        return toJson(DEFAULT_MAPPER, o, excludes);
    }

    private static void removeNode(ObjectNode objectNode, String exclude) {
        List<String> nodeNames = Splitter.on('.').omitEmptyStrings().splitToList(exclude);
        ObjectNode parentNode = objectNode;
        if (CollectionUtils.isNotEmpty(nodeNames)) {
            for (int i = 0; i < nodeNames.size() - 1; i++) {
                JsonNode jsonNode = parentNode.get(nodeNames.get(i));
                if (jsonNode != null && jsonNode instanceof ObjectNode) {
                    parentNode = (ObjectNode) jsonNode;
                } else {
                    parentNode = null;
                    break;
                }
            }
            if (parentNode != null) {
                parentNode.remove(nodeNames.get(nodeNames.size() - 1));
            }
        }
    }

    /**
     * 支持序列化Json的时删除不必要的字段，其中通过.定义层级
     *
     * @param mapper
     * @param o
     * @param excludes
     * @return
     */
    public static String toJson(ObjectMapper mapper, Object o, String... excludes) {
        final ObjectNode jsonNode = mapper.valueToTree(o);
        for (String exclude : excludes) {
            if (StringUtils.isNotBlank(exclude)) {
                removeNode(jsonNode, exclude);
            }
        }
        return jsonNode.toString();
    }

    public static void writeJsonToOutputStream(Object o, OutputStream os) throws IOException {
        writeJsonToOutputStream(DEFAULT_MAPPER, o, os);
    }

    public static void writeJsonToOutputStream(ObjectMapper mapper, Object o, OutputStream os) throws IOException {
        mapper.writeValue(os, o);
    }

    /**
     * 将对象直接转为Tree model对象
     *
     * @param o
     * @return
     */
    public static JsonNode toNode(Object o) {
        return toNode(DEFAULT_MAPPER, o);
    }

    public static JsonNode toNode(ObjectMapper mapper, Object o) {
        return mapper.valueToTree(o);
    }

    public static <T> T fromNode(JsonNode node, Class<T> clazz) {
        return fromNode(DEFAULT_MAPPER, node, clazz);
    }

    public static <T> T fromNode(ObjectMapper mapper, JsonNode node, Class<T> clazz) {
        try {
            return mapper.treeToValue(node, clazz);
        } catch (Exception e) {
            LOGGER.error("fromNode error! node:{}, clazz:{}", node, clazz, e);
            return null;
        }
    }

    /**
     * 不转为POJO对象，转为Tree model对象
     *
     * @param jsonString
     * @return
     */
    public static JsonNode toNode(String jsonString) {
        return fromJson(jsonString, JsonNode.class);
    }

    public static JsonNode toNode(ObjectMapper mapper, String jsonString) {
        return fromJson(mapper, jsonString, JsonNode.class);
    }

    /**
     * 不转为POJO对象，转为Map对象
     *
     * @param jsonString
     * @return
     */
    public static Map<String, Object> toMap(String jsonString) {
        return fromJson(jsonString, Map.class);
    }

    public static Map<String, Object> toMap(ObjectMapper mapper, String jsonString) {
        return fromJson(mapper, jsonString, Map.class);
    }

    /**
     * 不转为POJO对象，转为List对象
     *
     * @param jsonString
     * @return
     */
    public static List<Object> toList(String jsonString) {
        return fromJson(jsonString, List.class);
    }

    public static List<Object> toList(ObjectMapper mapper, String jsonString) {
        return fromJson(mapper, jsonString, List.class);
    }

    /**
     * 如果JSON字符串为Null或"null"字符串, 返回Null. 如果JSON字符串为"[]", 返回空集合.
     *
     * 如需读取集合如List/Map, 且不是List<String>这种简单类型时使用如下语句,使用後面的函數.
     */
    public static <T> T fromJson(String jsonString, Class<T> clazz) {
        return fromJson(DEFAULT_MAPPER, jsonString, clazz);
    }

    public static <T> T fromJson(ObjectMapper mapper, String jsonString, Class<T> clazz) {
        if (StringUtils.isEmpty(jsonString)) {
            return null;
        }

        try {
            return mapper.readValue(jsonString, clazz);
        } catch (Exception e) {
            LOGGER.error("parse json error! json:{}, clazz:{}", jsonString, clazz, e);
            return null;
        }
    }

    public static <T> T fromJson(Reader reader, Class<T> clazz) {
        return fromJson(DEFAULT_MAPPER, reader, clazz);
    }

    public static <T> T fromJson(ObjectMapper mapper, Reader reader, Class<T> clazz) {
        if (null == reader) {
            return null;
        }

        try {
            return mapper.readValue(reader, clazz);
        } catch (Exception e) {
            LOGGER.error("parse json error! reader:{}, clazz:{}", reader, clazz, e);
            return null;
        }
    }

    /**
     * 如果JSON字符串为Null或"null"字符串, 返回Null. 如果JSON字符串为"[]", 返回空集合.
     *
     * 如需读取集合如List/Map, 且不是List<String>時, 先用constructParametricType(List.class,MyBean.class)構造出JavaTeype,再調用本函數.
     */
    public static <T> T fromJson(String jsonString, JavaType javaType) {
        return fromJson(DEFAULT_MAPPER, jsonString, javaType);
    }

    public static <T> T fromJson(ObjectMapper mapper, String jsonString, JavaType javaType) {
        if (StringUtils.isEmpty(jsonString)) {
            return null;
        }

        try {
            return (T) mapper.readValue(jsonString, javaType);
        } catch (IOException e) {
            LOGGER.error("parse json error! json:{}, javaType:{}", jsonString, javaType, e);
            return null;
        }
    }

    /**
     *
     * @param reader
     * @param javaType
     * @param <T>
     * @return
     */
    public static <T> T fromJson(Reader reader, JavaType javaType) {
        return fromJson(DEFAULT_MAPPER, reader, javaType);
    }

    public static <T> T fromJson(ObjectMapper mapper, Reader reader, JavaType javaType) {
        if (null == reader) {
            return null;
        }
        try {
            return (T) mapper.readValue(reader, javaType);
        } catch (IOException e) {
            LOGGER.error("parse json error! reader:{}, javaType:{}", reader, javaType, e);
            return null;
        }
    }

    /**
     * 構造泛型的Type如List<MyBean>, Map<String,MyBean>
     */
    public static JavaType constructParametricType(Class<?> parametrized, Class<?>... parameterClasses) {
        return TypeFactory.defaultInstance().constructParametricType(parametrized, parameterClasses);
    }

    /**
     * 構造泛型的Type如Mybean<List<OtherBean>>
     */
    public static JavaType constructParametricType(Class<?> parametrized, JavaType... parameterTypes) {
        return TypeFactory.defaultInstance().constructParametricType(parametrized, parameterTypes);
    }

    public static JavaType getJavaType(Class<?> clazz) {
        return TypeFactory.defaultInstance().constructType(clazz);
    }

}
