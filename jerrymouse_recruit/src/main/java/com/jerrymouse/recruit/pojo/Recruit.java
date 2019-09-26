package com.jerrymouse.recruit.pojo;

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
@Table(name = "tb_recruit")
public class Recruit {
    @Id
    private String id;
     @Column(name = "jobname")
    private String jobName;

    private String salary;

    private String condition;

    private String education;

    private String type;

    private String address;

    private String eid;
    @Column(name = "createtime")
    private Date createTime;

    private String state;

    private String url;

    private String label;

    private String content1;

    private String content2;
}