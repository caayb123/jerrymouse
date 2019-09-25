package com.jerrymouse.base.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* Created by Mybatis Generator on 2019/09/24
*/
@Getter
@Setter
@Entity
@Table(name = "tb_label")
public class Label {
    @Id
    private String id;
    @Column(name = "labelname")
    private String labelName;  //标签名

    private String state; //状态

    private Long count; //使用数量

    private String recommend; //是否推荐

    private Long fans; //关注数
}