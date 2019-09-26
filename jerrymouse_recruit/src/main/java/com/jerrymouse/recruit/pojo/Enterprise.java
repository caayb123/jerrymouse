package com.jerrymouse.recruit.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* Created by Mybatis Generator on 2019/09/25
*/
@Getter
@Setter
@Entity
@Table(name = "tb_enterprise")
public class Enterprise {
    @Id
    private String id;

    private String name;

    private String summary;

    private String address;

    private String labels;

    private String coordinate;
    @Column(name = "ishot")
    private String isHot;

    private String logo;
    @Column(name = "jobcount")
    private Integer jobCount;

    private String url;
}