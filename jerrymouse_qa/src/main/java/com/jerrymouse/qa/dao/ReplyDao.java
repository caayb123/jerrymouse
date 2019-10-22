package com.jerrymouse.qa.dao;

import com.jerrymouse.qa.pojo.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ReplyDao extends JpaRepository<Reply,String>, JpaSpecificationExecutor<Reply> {
      List<Reply> findByProblemId(String problemId);
}
