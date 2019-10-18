package com.jerrymouse.qa.controller;

import com.jerrymouse.qa.pojo.Problem;
import com.jerrymouse.qa.service.ProblemService;
import entity.PageResult;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/problem")
public class ProblemController {

    @Autowired
    private ProblemService problemService;

    @GetMapping(value = "/newlist/{label}/{page}/{size}")
    public Result<PageResult<Problem>> newList(@PathVariable(value = "label") String label, @PathVariable(value = "page")Integer page, @PathVariable(value = "size")Integer size){
        return problemService.findNewList(label, page, size);
    }
    @GetMapping(value = "/hotlist/{label}/{page}/{size}")
    public Result<PageResult<Problem>> hotList(@PathVariable(value = "label") String label,@PathVariable(value = "page")Integer page,@PathVariable(value = "size")Integer size){
        return problemService.findHotList(label, page, size);
    }
    @GetMapping(value = "/waitlist/{label}/{page}/{size}")
    public Result<PageResult<Problem>> waitList(@PathVariable(value = "label") String label,@PathVariable(value = "page")Integer page,@PathVariable(value = "size")Integer size){
        return problemService.findWaitList(label, page, size);
    }


}
