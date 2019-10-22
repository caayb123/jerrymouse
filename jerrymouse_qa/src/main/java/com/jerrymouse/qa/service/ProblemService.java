package com.jerrymouse.qa.service;


import com.jerrymouse.qa.pojo.Problem;
import entity.PageResult;
import entity.Result;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProblemService {

    Result<PageResult<Problem>> findNewList(String labelId, Integer page, Integer size);
    Result<PageResult<Problem>> findHotList(String labelId, Integer page, Integer size);
    Result<PageResult<Problem>> findWaitList(String labelId, Integer page, Integer size);
    void add(Problem problem);
    List<Problem> findAll();
    Problem findById(String id);
    void update(Problem problem,String id);
    void delete(String id);
    Result<PageResult<Problem>> search(Problem problem,Integer page,Integer size);

}
