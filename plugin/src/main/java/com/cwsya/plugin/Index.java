package com.cwsya.plugin;

import cn.hutool.json.JSONObject;

import java.util.Map;

/**
 * 插件模板
 * @author cws
 */
public interface Index {
    /**
     * 获取插件配置
     * @return 插件配置
     */
    Config getConfig();

    /**
     * 处理前端的数据
     * @param path 前端请求的路径
     * @param parameter 前端请求的参数
     * @return 返回数据
     */
    Result<?> service(JSONObject parameter);

    /**
     * 获取插件页面
     * @return 页面
     */
    String getIndex();

}
