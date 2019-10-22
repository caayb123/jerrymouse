package com.jerrymouse.qa.pojo;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* Created by Mybatis Generator on 2019/10/22
*/
@Getter
@Setter
@Entity
@Table(name = "tb_reply")
public class Reply {
    @Id
    private String id;
    @Column(name = "problemid")
    private String problemId;
    @Column(name = "createtime")
    private Date createTime;
    @Column(name = "updatetime")
    private Date updateTime;
    @Column(name = "userid")
    private String userId;

    private String nickname;

    private String content;
}