package com.im4j.pojo.wx;

/**
 * Created by chenzp on 2017/11/8 0008.
 */
public class Article {

    /**
     * 图片标题
     */
    private String Title;

    /**
     * 图片描述
     */
    private String Description;

    /**
     * 图片地址
     */
    private String PicUrl;

    /**
     * 点击图片跳转
     */
    private String Url;


    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }
}
