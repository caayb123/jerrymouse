package com.jerrymouse.article.dao;

import com.jerrymouse.article.pojo.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArticleDao extends JpaRepository<Article,String>, JpaSpecificationExecutor<Article> {

    @Query(value = "update tb_article set state = '1' where id =?1",nativeQuery = true)
    @Modifying
    int updateState(String id);
    @Query(value = "update tb_article set thumbup=thumbup+1 where id=?1",nativeQuery = true)
    @Modifying
    int updateThumbup(String id);


}
