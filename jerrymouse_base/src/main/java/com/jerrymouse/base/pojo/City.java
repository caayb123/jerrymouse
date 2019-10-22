package com.jerrymouse.base.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
* Created by Mybatis Generator on 2019/10/21
*/
@Getter
@Setter
@Entity
@Table(name = "tb_city")
public class City implements Serializable {
    @Id
    private String id;

    private String name;
    @Column(name = "ishot")
    private String isHot;

    private Long count;

    private Long fans;
    @Column(name = "labelname")
    private String labelName;

    private String recommend;

    private String state;
}