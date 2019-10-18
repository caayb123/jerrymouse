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

}
