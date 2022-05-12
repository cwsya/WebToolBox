package com.cwsya.wtxSystem.service.impl;

import cn.hutool.core.io.FileUtil;
import com.cwsya.Config;
import com.cwsya.plugin.Index;
import com.cwsya.wtxSystem.pojo.Tool;
import com.cwsya.wtxSystem.pojo.ToolData;
import com.cwsya.wtxSystem.service.ToolService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cws
 */
@Service
public class ToolServiceImpl implements ToolService {

    private final ToolData toolData;
    @Value("${tool.updateFrequency}")
    private Integer updateFrequency;
    private static Integer frequency=0;

    public ToolServiceImpl(ToolData toolData) {
        this.toolData = toolData;
    }

    /**
     * 更新插件列表
     */
    @Override
    public void upDate() {
        if (toolData.isToolLock()&&++frequency>=updateFrequency){
            frequency=0;
            HashMap<String, Tool> hashMap = new HashMap<>();
            for (String s : getToolsList(toolData.getPath())) {
                Tool tool = loadTool(s);
                hashMap.put(tool.getConfig().getName(),tool);
            }
            toolData.setToolList(hashMap);
        }
    }

    /**
     * 获取插件集合
     *
     * @return 插件集合
     */
    @Override
    public Map<String, Tool> getTools() {
        return toolData.getToolList();
    }

    /**
     * 解析单个插件
     *
     * @param jarPath jar包路径
     * @return 单个插件
     */
    @Override
    public Tool loadTool(String jarPath) {
        URLClassLoader urlClassLoader1=null;
        try {
            urlClassLoader1 = toolData.getToolsDate().get(jarPath);
        }catch (Exception e){

        }
        if (urlClassLoader1!=null){
            Class<?> classStudentServiceImpl;
            try {
                classStudentServiceImpl = urlClassLoader1.loadClass("Config");
                Config o = (Config)classStudentServiceImpl.newInstance();
                Index index = o.getIndex();
                com.cwsya.plugin.Config config = index.getConfig();
                return new Tool(config, index);
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }

        }else {
            File file = new File(jarPath);
            URLClassLoader urlClassLoader;
            try {
                urlClassLoader = new URLClassLoader(new URL[]{file.toURI().toURL()});
                Class<?> classStudentServiceImpl = urlClassLoader.loadClass("Config");
                Config o = (Config)classStudentServiceImpl.newInstance();
                Index index = o.getIndex();
                com.cwsya.plugin.Config config = index.getConfig();
                toolData.getToolsDate().put(jarPath,urlClassLoader);
                return new Tool(config, index);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    /**
     * 获取目录中的插件列表
     *
     * @param toolsPath 插件路径
     * @return 路径中插件列表
     */
    @Override
    public List<String> getToolsList(String toolsPath) {
        ArrayList<String> list = new ArrayList<>();
        File[] ls = FileUtil.ls(toolsPath);
        for (File l : ls) {
            if (l.getName().endsWith(".jar")){
                list.add(l.getPath());
            }
        }
        return list;
    }
}
