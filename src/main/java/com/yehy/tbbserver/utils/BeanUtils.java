package com.yehy.tbbserver.utils;

import com.alibaba.fastjson.JSON;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName BeanUtils
 * @Author yehy
 * @Date 2022/5/21 10:06
 **/
public class BeanUtils {
    public static <T, S> T copy(S sourceObj, Class<T> targetClass) {
        if (sourceObj == null) {
            return null;
        }

        return JSON.parseObject(JSON.toJSONString(sourceObj), targetClass);
    }

    public static <T> List<T> copyList(List<? extends Object> sourceList, Class<T> targetClass) {
        if (CollectionUtils.isEmpty(sourceList)) {
            return new ArrayList();
        }
        return JSON.parseArray(JSON.toJSONString(sourceList), targetClass);
    }
}
