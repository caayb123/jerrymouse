package com.jerrymouse.article.service.impl;

import com.jerrymouse.article.dao.ArticleDao;
import com.jerrymouse.article.pojo.Article;
import com.jerrymouse.article.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service(value = "articleService")
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    @Transactional
    public int check(String id) {
        redisTemplate.delete("article_"+id);   //删除缓存
      return articleDao.updateState(id);
    }

    @Override
    @Transactional
    public int thumbup(String id) {
        redisTemplate.delete("article_"+id);   //删除缓存
        return articleDao.updateThumbup(id);
    }

    @Override
    public Article findArticleById(String id) {
        Article article = (Article)redisTemplate.opsForValue().get("article_" + id);
        if (article==null){  //判断redis缓存
          article=articleDao.findById(id).get();
            redisTemplate.opsForValue().set("article_"+id,article,1, TimeUnit.DAYS);  //设置缓存过期时间
        }
        return article;
    }

    @Override
    @Transactional
    public void delete(String id) {
        redisTemplate.delete("article_"+id);   //删除缓存
        articleDao.deleteById(id);
    }
}
