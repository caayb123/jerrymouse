package com.jerrymouse.recruit.service;

import com.jerrymouse.recruit.pojo.Recruit;
import entity.Result;

import java.util.List;

public interface RecruitService {
     /**
          * @Description:推荐职位查询
          * @Author: cyb
          */
     Result<List<Recruit>> findByState(String state);

     Result<List<Recruit>> findByNew(String state);

}
