package com.cwsya.wtxSystem.service.impl;

import cn.hutool.core.io.FileUtil;
import com.cwsya.wtxSystem.pojo.Tool;
import com.cwsya.wtxSystem.pojo.ToolData;
import com.cwsya.wtxSystem.service.ToolService;
import com.cwsya.wtxSystem.service.ToolsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * @author cws
 */
@Service
public class ToolsServiceImpl implements ToolsService {

    @Autowired
    private ToolService toolService;
    @Autowired
    private ToolData toolData;

    /**
     * 获取所有插件
     *
     * @return 所有插件集合
     */
    @Override
    public Map<String, Tool> getTools() {
        toolService.upDate();
        return toolService.getTools();
    }

    /**
     * 获取插件数据
     *
     * @param name 插件名称
     * @return 插件数据
     */
    @Override
    public Tool getTool(String name) {
        return toolService.getTools().get(name);
    }

    /**
     * 卸载插件
     *
     * @param name    插件路径
     * @param path
     * @return 是否成功
     */
    @Override
    public boolean delTool(String name, String path) {
        toolData.setToolLock(false);
        try {
            toolData.getToolList().remove(name);
            toolData.getToolsDate().get(path).close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        toolData.getToolsDate().remove(path);
        File file = new File(path);
        FileUtil.rename(file,file.getName()+".bak",true);
        toolData.setToolLock(true);
        return true;
    }

}
