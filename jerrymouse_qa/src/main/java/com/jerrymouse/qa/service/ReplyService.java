package com.jerrymouse.qa.service;

import com.jerrymouse.qa.pojo.Reply;
import entity.PageResult;
import entity.Result;

import java.util.List;

public interface ReplyService {
    void add(Reply reply);
    List<Reply> findAll();
    Reply findById(String id);
    void update(Reply reply,String id);
    void delete(String id);
    List<Reply> findByProblem(String problemId);
}
