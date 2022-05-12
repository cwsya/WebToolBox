package com.cwsya.wtxSystem.pojo.VO;

import com.cwsya.plugin.Config;

/**
 * @author cws
 */
public class Tool {
    private Config config;

    @Override
    public String toString() {
        return "Tool{" +
                "config=" + config +
                '}';
    }

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    public Tool(Config config) {
        this.config = config;
    }
}
