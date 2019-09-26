package com.jerrymouse.recruit.dao;

import com.jerrymouse.recruit.pojo.Recruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface RecruitDao extends JpaRepository<Recruit,String>, JpaSpecificationExecutor<Recruit> {
    List<Recruit> findTop4ByStateOrderByCreateTimeDesc(String state);  //为2推荐
    List<Recruit> findTop12ByStateNotOrderByCreateTimeDesc(String state); //不为0关闭
}
