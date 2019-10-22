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
    @PostMapping
    public Result add(Problem problem){
         problemService.add(problem);
          return Result.createBySuccessMessage("问题新增成功");
    }
    @GetMapping
    public Result findAll(){
        return Result.createBySuccess(problemService.findAll());
    }
    @GetMapping(value = "/{id}")
    public Result findById(@PathVariable(value = "id") String id){
        return Result.createBySuccess(problemService.findById(id));
    }
    @PutMapping(value = "/{id}")
    public Result update(Problem problem,@PathVariable(value = "id") String id){
        problemService.update(problem,id);
        return Result.createBySuccessMessage("修改问题信息成功");
    }
    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable (value = "id")String id){
        problemService.delete(id);
        return Result.createBySuccessMessage("问题删除成功");
    }
    @GetMapping(value = "/search/{page}/{size}")
    public Result search(Problem problem,@PathVariable(value = "page")Integer page,@PathVariable (value = "size")Integer size){
        return problemService.search(problem,page,size);
    }


}
