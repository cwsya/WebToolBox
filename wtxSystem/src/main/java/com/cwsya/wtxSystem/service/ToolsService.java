package com.cwsya.wtxSystem.service;

import com.cwsya.wtxSystem.pojo.Tool;

import java.util.Map;

/**
 * @author cws
 */
public interface ToolsService {
    /**
     * 获取所有插件
     * @return 所有插件集合
     */
    Map<String, Tool> getTools();

    /**
     * 获取插件数据
     * @param name 插件名称
     * @return 插件数据
     */
    Tool getTool(String name);

    /**
     * 卸载插件
     *
     * @param path    插件路径
     * @param replace
     * @return 是否成功
     */
    boolean delTool(String name, String path);
}
