package com.cwsya.plugin;

/**
 * 插件配置信息
 * @author cws
 */
public interface Config {
    /**
     * 获取插件名称
     * @return 插件名称
     */
    String getName();

    /**
     * 获取插件介绍
     * @return 插件简介
     */
    String getIntroduction();

    /**
     * 获取插件图标
     * @return 插件图标
     */
    String getIcon();

    /**
     * 获取插件作者
     * @return 插件作者
     */
    String getAuthor();

    /**
     * 获取作者地址
     * @return 作者地址
     */
    String getAuthorUrl();

    /**
     * 获取项目地址
     * @return 项目地址
     */
    String getUrl();
}
