package com.cwsya.wtxSystem.util;

import cn.hutool.core.util.StrUtil;

import java.sql.Struct;

/**
 * 请求相关接口
 * @author cws
 */
public class RequestUtil {
     public static boolean isNull(Object...o){
        for (Object o1 : o) {
            if (StrUtil.isBlankIfStr(o1)){
                return true;
            }
        }
        return false;
    }
}
