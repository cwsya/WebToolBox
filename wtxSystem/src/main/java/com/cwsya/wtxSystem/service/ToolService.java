package com.cwsya.wtxSystem.service;

import com.cwsya.plugin.Index;
import com.cwsya.wtxSystem.pojo.Tool;

import java.util.List;
import java.util.Map;

/**
 * 工具类
 */
public interface ToolService {
    /**
     * 更新插件列表
     */
    void upDate();

    /**
     * 获取插件集合
     * @return 插件集合
     */
    Map<String, Tool> getTools();

    /**
     * 解析单个插件
     * @param jarPath jar包路径
     * @return 单个插件
     */
    Tool loadTool(String jarPath);

    /**
     * 获取目录中的插件列表
     * @param toolsPath 插件路径
     * @return 路径中插件列表
     */
    List<String> getToolsList(String toolsPath);
}
