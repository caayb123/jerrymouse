package com.jerrymouse.qa.service;


import com.jerrymouse.qa.pojo.Problem;
import entity.Result;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProblemService {

    Result<Page<Problem>> findNewList(String labelId, Integer page, Integer size);
    Result<Page<Problem>> findHotList(String labelId, Integer page, Integer size);
    Result<Page<Problem>> findWaitList(String labelId, Integer page, Integer size);

}
