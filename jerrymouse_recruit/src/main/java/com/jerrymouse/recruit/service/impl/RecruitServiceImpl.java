package com.jerrymouse.recruit.service.impl;

import com.jerrymouse.recruit.dao.RecruitDao;
import com.jerrymouse.recruit.pojo.Recruit;
import com.jerrymouse.recruit.service.RecruitService;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecruitServiceImpl implements RecruitService {
    @Autowired
    private RecruitDao recruitDao;

    @Override
    public Result<List<Recruit>> findByState(String state) {
        return Result.createBySuccess(recruitDao.findTop4ByStateOrderByCreateTimeDesc(state));
    }

    @Override
    public Result<List<Recruit>> findByNew(String state) {
        return Result.createBySuccess(recruitDao.findTop12ByStateNotOrderByCreateTimeDesc(state));
    }
}
