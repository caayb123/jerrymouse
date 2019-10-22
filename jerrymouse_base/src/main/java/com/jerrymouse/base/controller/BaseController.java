package com.jerrymouse.base.controller;

import com.jerrymouse.base.pojo.Label;
import com.jerrymouse.base.service.LabelService;
import entity.BaseConst;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/label")
public class BaseController {

    @Autowired
    private LabelService labelService;

    @GetMapping
    public Result findAll(){
        return labelService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Result findById(@PathVariable(value = "id") String id){
        return labelService.findById(id);
    }
    @PutMapping(value = "/{id}")
    public Result update(@PathVariable(value = "id") String id, Label label){
        return labelService.update(id, label);
    }
    @PostMapping
    public Result add(Label label){
        return labelService.add(label);
    }
    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable(value = "id") String id){
        return labelService.deleteById(id);
    }

    @PostMapping(value = "/search/{page}/{size}")
    public Result findSearch(Label label,@PathVariable(value = "page") Integer page,@PathVariable(value = "size") Integer size){
         return labelService.findSearch(label,page,size);
    }
    @GetMapping(value = "/toplist")
    public Result topList(){
       return Result.createBySuccess(labelService.topList(BaseConst.IS_RECOMMEND));

    }




}
