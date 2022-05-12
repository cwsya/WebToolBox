package org.cwsya.demo;

public class Config implements com.cwsya.plugin.Config {
    /**
     * 获取插件名称
     *
     * @return 插件名称
     */
    @Override
    public String getName() {
        return "Name";
    }

    /**
     * 获取插件介绍
     *
     * @return 插件简介
     */
    @Override
    public String getIntroduction() {
        return "Introduction";
    }

    /**
     * 获取插件图标
     *
     * @return 插件图标
     */
    @Override
    public String getIcon() {
        return "Icon";
    }

    /**
     * 获取插件作者
     *
     * @return 插件作者
     */
    @Override
    public String getAuthor() {
        return "Author";
    }

    /**
     * 获取作者地址
     *
     * @return 作者地址
     */
    @Override
    public String getAuthorUrl() {
        return "AuthorUrl";
    }

    /**
     * 获取项目地址
     *
     * @return 项目地址
     */
    @Override
    public String getUrl() {
        return "Url";
    }
}
