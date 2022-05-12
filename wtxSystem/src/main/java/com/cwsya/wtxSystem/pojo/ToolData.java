package com.cwsya.wtxSystem.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 插件数据
 * @author cws
 */
@Component
public class ToolData {
    /**
     * 插件列表数据
     */
    private Map<String,Tool> toolList;
    private Map<String, URLClassLoader> toolsDate=new HashMap<>();
    private boolean toolLock = true;


    public Map<String, URLClassLoader> getToolsDate() {
        return toolsDate;
    }

    public void setToolsDate(Map<String, URLClassLoader> toolsDate) {
        this.toolsDate = toolsDate;
    }

    public boolean isToolLock() {
        return toolLock;
    }

    public void setToolLock(boolean toolLock) {
        this.toolLock = toolLock;
    }

    @Value("${tool.path}")
    private String path;

    public Map<String, Tool> getToolList() {
        return toolList;
    }

    public void setToolList(Map<String, Tool> toolList) {
        this.toolList = toolList;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
