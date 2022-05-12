package com.cwsya.wtxSystem.controller;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.cwsya.wtxSystem.exception.ParameterException;
import com.cwsya.wtxSystem.exception.ToolException;
import com.cwsya.wtxSystem.pojo.Result;
import com.cwsya.wtxSystem.pojo.ResultCodeEnum;
import com.cwsya.wtxSystem.pojo.Tool;
import com.cwsya.wtxSystem.service.ToolsService;
import com.cwsya.wtxSystem.util.BeanCopyUtils;
import com.cwsya.wtxSystem.util.RequestUtil;
import jdk.nashorn.internal.runtime.ParserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * @author cws
 *
 */
@RestController
public class ToolsController {

    @Autowired
    private ToolsService toolsService;

    @PostMapping("/getTools")
    public Result<?> getTools(){
        Map<String, Tool> tools = toolsService.getTools();
        Map<String, Object> map=null;
        if (ObjectUtil.isNotNull(tools)){
            map = new HashMap<>(tools.size());
            for (Map.Entry<String, Tool> stringToolEntry : tools.entrySet()) {
                map.put(stringToolEntry.getKey(),stringToolEntry.getValue().getConfig());
            }
        }
        return new Result<>(ResultCodeEnum.SUCCESS, map);
    }
    @PostMapping("/getToolIndex")
    public Result<?> getToolIndex(@RequestBody JSONObject jsonObject) throws ParameterException, ToolException {
        String name = jsonObject.getStr("name");
        if (RequestUtil.isNull(name)){
            throw new ParameterException();
        }
        Tool tool;
        try {
            tool = toolsService.getTool(name);
        }catch (NullPointerException nullPointerException){
            throw new ToolException();
        }
        return new Result<>(ResultCodeEnum.SUCCESS,tool.getIndex().getIndex());
    }
    @PostMapping("/tool/{name}/service")
    public Result<?> getToolIndex(@PathVariable("name") String name, @RequestBody JSONObject jsonObject, HttpServletRequest request) throws ParameterException, ToolException {
        com.cwsya.plugin.Result<?> service = toolsService.getTool(name).getIndex().service(jsonObject);
        return BeanCopyUtils.copyBean(service, Result.class);
    }

    @PostMapping("/delTool")
    public Result<?> delTool(@RequestBody JSONObject jsonObject) throws ParameterException, ToolException {
        String name = jsonObject.getStr("name");
        if (RequestUtil.isNull(name)){
            throw new ParameterException();
        }
        String s;
        try {
            s = StrUtil.subBetween(toolsService.getTool(name).getConfig().getClass().getResource("").getPath(), "file:/", ".jar!/") + ".jar";
        }catch (NullPointerException nullPointerException){
            throw new ToolException();
        }
        toolsService.delTool(name,s.replace("/","\\"));
        return new Result<>(ResultCodeEnum.SUCCESS,"1");
    }




}
