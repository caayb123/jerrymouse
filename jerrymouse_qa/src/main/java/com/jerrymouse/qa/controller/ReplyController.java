package com.jerrymouse.qa.controller;

import com.jerrymouse.qa.pojo.Reply;
import com.jerrymouse.qa.service.ReplyService;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/reply")
public class ReplyController {
    @Autowired
    private ReplyService replyService;

    @PostMapping
    public Result add(Reply reply){
        replyService.add(reply);
        return Result.createBySuccessMessage("回答新增成功");
    }
    @GetMapping
    public Result findAll(){
        return Result.createBySuccess(replyService.findAll());
    }
    @GetMapping(value = "/{id}")
    public Result findById(@PathVariable(value = "id") String id){
        return Result.createBySuccess(replyService.findById(id));
    }
    @PutMapping(value = "/{id}")
    public Result update(Reply reply,@PathVariable(value = "id") String id){
        replyService.update(reply,id);
        return Result.createBySuccessMessage("回答修改成功");
    }
    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable (value = "id")String id){
        replyService.delete(id);
        return Result.createBySuccessMessage("回答删除成功");
    }
    @GetMapping(value = "/problem/{problemId}")
    public Result findByProblem(@PathVariable (value = "problemId")String problemId){
        return Result.createBySuccess(replyService.findByProblem(problemId));
    }
}
