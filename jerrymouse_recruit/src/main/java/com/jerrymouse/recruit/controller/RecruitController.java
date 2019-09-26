package com.jerrymouse.recruit.controller;

import com.jerrymouse.recruit.pojo.Recruit;
import com.jerrymouse.recruit.service.RecruitService;
import entity.RecruitConst;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/recruit")
@CrossOrigin
public class RecruitController {

    @Autowired
    private RecruitService recruitService;

    @GetMapping(value = "/search/recommend")
    public Result recommend(){
        return recruitService.findByState(RecruitConst.REMEDY);
    }
    @GetMapping(value = "/search/newlist")
    public Result newList(){
        return recruitService.findByNew(RecruitConst.DOWN);
    }

}
