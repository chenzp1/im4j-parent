package com.im4j.pojo;

/**
 * Created by chenzp on 2017/11/8 0008.
 */
public class TextMessage extends BaseWechatMessage {
    /**
     * 文本消息内容
     */
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
