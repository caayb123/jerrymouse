package com.jerrymouse.base.dao;

import com.jerrymouse.base.pojo.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface LabelDao extends JpaRepository<Label, String>, JpaSpecificationExecutor<Label> {
       List<Label> findByRecommend(String recommend);
}
