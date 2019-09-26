package com.jerrymouse.recruit.controller;

import com.jerrymouse.recruit.service.EnterpriseService;
import entity.RecruitConst;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/enterprise")
public class EnterpriseController {

    @Autowired
    private EnterpriseService enterpriseService;

    @GetMapping(value = "/search/hotlist")
    public Result hotList(){
        return enterpriseService.findByIsHot(RecruitConst.IS_HOT);
    }


}
