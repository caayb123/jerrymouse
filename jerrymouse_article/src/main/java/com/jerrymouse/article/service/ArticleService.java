package com.jerrymouse.article.service;

import com.jerrymouse.article.pojo.Article;

import java.util.List;

public interface ArticleService {
    int check(String id);
    int thumbup(String id);
    Article findArticleById(String id);
    void delete(String id);
}
