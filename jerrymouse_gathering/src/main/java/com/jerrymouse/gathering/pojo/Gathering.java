package com.jerrymouse.gathering.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* Created by Mybatis Generator on 2019/10/21
*/
@Getter
@Setter
@Entity
@Table(name = "tb_gathering")
public class Gathering implements Serializable {
    @Id
    private String id;

    private String name;

    private String sponsor;

    private String image;
    @Column(name = "starttime")
    private Date startTime;
    @Column(name = "endtime")
    private Date endTime;

    private String address;
    @Column(name = "enrolltime")
    private Date enrollTime;

    private String state;

    private String city;

    private String summary;

    private String detail;
}