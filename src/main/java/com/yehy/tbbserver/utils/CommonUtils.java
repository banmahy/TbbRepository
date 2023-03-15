package com.yehy.tbbserver.utils;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;

/**
 * @ClassName CommonUtils
 * @Author yehy
 * @Date 2022/9/12 16:21
 **/
public class CommonUtils {

    public static String convert2Str(Object str) {
        if (str == null){
            return "";
        }
        return String.valueOf(str);
    }

}
