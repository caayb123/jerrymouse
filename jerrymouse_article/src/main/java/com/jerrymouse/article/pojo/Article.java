package com.jerrymouse.article.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* Created by Mybatis Generator on 2019/10/18
*/
@Getter
@Setter
@Entity
@Table(name = "tb_article")
public class Article implements Serializable {
    @Id
    private String id;
    @Column(name = "columnid")
    private String columnId;
    @Column(name = "userid")
    private String userId;

    private String title;

    private String image;
    @Column(name = "createtime")
    private Date createTime;
    @Column(name = "updatetime")
    private Date updateTime;
    @Column(name = "ispublic")
    private String isPublic;
    @Column(name = "istop")
    private String isTop;

    private Integer visits;

    private Integer thumbup;

    private Integer comment;

    private String state;
    @Column(name = "channelid")
    private String channelId;

    private String url;

    private String type;

    private String content;
}