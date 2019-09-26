package com.jerrymouse.recruit.service.impl;

import com.jerrymouse.recruit.dao.EnterpriseDao;
import com.jerrymouse.recruit.pojo.Enterprise;
import com.jerrymouse.recruit.service.EnterpriseService;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterpriseImpl implements EnterpriseService {

    @Autowired
    private EnterpriseDao enterpriseDao;

    @Override
    public Result<List<Enterprise>> findByIsHot(String isHot) {
        return Result.createBySuccess(enterpriseDao.findByIsHot(isHot));
    }
}
