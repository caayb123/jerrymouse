package com.jerrymouse.recruit.service;

import com.jerrymouse.recruit.pojo.Enterprise;
import entity.Result;


import java.util.List;


public interface EnterpriseService {
     /**
          * @Description: 热门企业查询
          * @Author: cyb
          */
    Result<List<Enterprise>> findByIsHot(String isHot);


}
