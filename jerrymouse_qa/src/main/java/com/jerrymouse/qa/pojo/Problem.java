package com.jerrymouse.qa.pojo;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* Created by Mybatis Generator on 2019/09/26
*/
@Getter
@Setter
@Entity
@Table(name = "tb_problem")
public class Problem {
    @Id
    private String id;

    private String title;
    @Column(name = "createtime")
    private Date createTime;
    @Column(name = "updatetime")
    private Date updateTime;

    private String userId;

    private String nickname;

    private Long visits;
    @Column(name = "thumbup")
    private Long thumbUp;

    private Long reply;

    private String solve;
    @Column(name = "replyname")
    private String replyName;
    @Column(name = "replytime")
    private Date replyTime;

    private String content;
}