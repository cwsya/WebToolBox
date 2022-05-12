package com.cwsya.wtxSystem.pojo;

import com.cwsya.plugin.Config;
import com.cwsya.plugin.Index;

public class Tool {
    private Config config;
    private Index index;

    public Tool() {
    }

    @Override
    public String toString() {
        return "Tool{" +
                "config=" + config +
                ", index=" + index +
                '}';
    }

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    public Index getIndex() {
        return index;
    }

    public void setIndex(Index index) {
        this.index = index;
    }

    public Tool(Config config, Index index) {
        this.config = config;
        this.index = index;
    }
}
