package org.cwsya.demo;

import cn.hutool.json.JSONObject;
import com.cwsya.plugin.Config;
import com.cwsya.plugin.Result;

/**
 * @author cws
 */
public class Index implements com.cwsya.plugin.Index {
    /**
     * 获取插件配置
     *
     * @return 插件配置
     */
    @Override
    public Config getConfig() {
        return new org.cwsya.demo.Config();
    }

    /**
     * 处理前端的数据
     *
     * @param parameter 前端请求的参数
     * @return 返回数据
     */
    @Override
    public Result<?> service(JSONObject parameter) {

        return new Result<>(1,"123",new service().test());
    }

    /**
     * 获取插件页面
     *
     * @return 页面
     */
    @Override
    public String getIndex() {
        return "Index";
    }
}
