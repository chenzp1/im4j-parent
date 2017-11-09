package com.im4j.pojo.wx;

import java.util.List;

/**
 * Created by chenzp on 2017/11/8 0008.
 * 微信图文消息
 */
public class NewMessage extends  BaseWechatMessage{

    private  String ArticleCount;

    private List<Article> Articles;

    public String getArticleCount() {
        return ArticleCount;
    }

    public void setArticleCount(String articleCount) {
        ArticleCount = articleCount;
    }

    public List<Article> getArticles() {
        return Articles;
    }

    public void setArticles(List<Article> articles) {
        Articles = articles;
    }
}
